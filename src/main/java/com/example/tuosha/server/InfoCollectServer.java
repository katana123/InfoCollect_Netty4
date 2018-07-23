package com.example.tuosha.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;


/**
 * Created by kasim on 15-2-9.
 */
public class InfoCollectServer implements ChannelFutureListener {
    //    private static final int PORT = 9988;
    private static final int PORT = 9200;
    private final String DECODER = "decoder";
    private final String ENCODER = "encoder";
    private final String SERVERHANDLER = "serverHandler";
    private final String IDLESTATEHANDLER = "idleStateHandler";

    private ChannelFutureListener listener;
    private EventLoopGroup bossGroup = new NioEventLoopGroup();
    private EventLoopGroup workerGroup = new NioEventLoopGroup();
    private ServerBootstrap serverBootstrap;

    public InfoCollectServer() throws Exception {
        serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(bossGroup, workerGroup);
        serverBootstrap.channel(NioServerSocketChannel.class); // 指定 channel 类型为 tcp 协议 nio server socket channel
        serverBootstrap.option(ChannelOption.SO_REUSEADDR, true);
        serverBootstrap.childOption(ChannelOption.SO_KEEPALIVE, true);
        serverBootstrap.childOption(ChannelOption.TCP_NODELAY, true);
        serverBootstrap.childOption(ChannelOption.SO_RCVBUF, Integer.MAX_VALUE);
        serverBootstrap.childOption(ChannelOption.SO_SNDBUF, Integer.MAX_VALUE);
        serverBootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
                ch.pipeline().addLast(DECODER, new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, 4, 0, 4));
                ch.pipeline().addLast(ENCODER, new LengthFieldPrepender(4));
                ch.pipeline().addLast(IDLESTATEHANDLER, new IdleStateHandler(30, 0, 0, TimeUnit.SECONDS));
                ch.pipeline().addLast(SERVERHANDLER, new InfoCollectServerHandler());
            }
        });
    }

    public void bind() throws Exception {
        listener = this;
        ChannelFuture channelFuture = serverBootstrap.bind(PORT).syncUninterruptibly();
        channelFuture.addListener(new ChannelFutureListener() {

            @Override
            public void operationComplete(ChannelFuture future) throws Exception {
                // TODO Auto-generated method stub
                listener.operationComplete(future);
            }
        });
        channelFuture.channel().closeFuture().syncUninterruptibly();
    }

    public void dispose() throws Exception {
        workerGroup.shutdownGracefully();
        bossGroup.shutdownGracefully();
    }

    @Override
    public void operationComplete(ChannelFuture future) throws Exception {
        // TODO Auto-generated method stub
        if (future.isSuccess()) {
            System.out.println("启动服务器成功！");
        } else {
            System.err.println("启动失败！");
        }
    }
}
