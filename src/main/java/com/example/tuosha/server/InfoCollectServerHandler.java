package com.example.tuosha.server;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.exceptions.ClientException;
import com.example.tuosha.Util.NetWorkImpl;
import com.example.tuosha.Util.Protocols;
import com.example.tuosha.model.*;
import com.example.tuosha.service.impl.*;

import com.example.tuosha.service.ContentImpl;
import com.example.tuosha.service.KouziImpl;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import org.hibernate.mapping.Array;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import static com.example.tuosha.Util.SmsUtil.sendMessage;


/**
 * Created by kasim on 15-2-9.
 */
public class InfoCollectServerHandler extends ChannelDuplexHandler {
    private final String SERVER_NET_ERROR = "本机连接到服务器的网络传输发生错误:";
    private final String SERVER_STOPPED = "服务已停止";
    private final String HANDLER_CHANNELACTIVE = "服务处理器channelActive被调用";
    private final String HANDLER_CHANNELINACTIVE = "服务处理器channelInactive被调用";
    private final String HANDLER_CHANNELREAD = "服务处理器channelRead被调用";
    private final String HANDLER_CHANNELREAD_ERROR = "服务处理器channelRead发生错误";
    private final String HANDLER_EXCEPTION_CAUGHT = "服务处理器exceptionCaught被调用";

    public SWImpl swImpl = new SWImpl();
    //public ReportDao reportDao = new ReportDao();
    //public ReportImpl report = new ReportImpl();
    //public LDImpl ld = new LDImpl();
    // public InfoImpl info = new InfoImpl();
    //public HashMap<String, ArrayList<ActionBean>> hashMapAction = new HashMap<String, ArrayList<ActionBean>>();

   //ic ImsXuanMixloanBankCardServiceImpl bankCardServiceImpl = new ImsXuanMixloanBankCardServiceImpl();
  //  public ImsXuanMixloanChannelServiceImpl channelServiceImpl = new ImsXuanMixloanChannelServiceImpl();
    public ImsXuanMixloanChannelSubjectServiceImpl channelSubjectServiceImpl = new ImsXuanMixloanChannelSubjectServiceImpl();
    public ImsXuanMixloanCreditcardServiceImpl CreditcardServiceImpl = new ImsXuanMixloanCreditcardServiceImpl();
    public ImsXuanMixloanHelpServiceImpl helpServiceImpl = new ImsXuanMixloanHelpServiceImpl();
    public ImsXuanMixloanInviterServiceImpl inviterServiceImpl = new ImsXuanMixloanInviterServiceImpl();
    public ImsXuanMixloanLoanServiceImpl loanServiceImpl = new ImsXuanMixloanLoanServiceImpl();
    public ImsXuanMixloanMemberServiceImpl memberServiceImpl = new ImsXuanMixloanMemberServiceImpl();
    public ImsXuanMixloanPaymentServiceImpl paymentServiceImpl = new ImsXuanMixloanPaymentServiceImpl();
    public ImsXuanMixloanPosterServiceImpl posterServiceImpl = new ImsXuanMixloanPosterServiceImpl();
    public ImsXuanMixloanProductApplyServiceImpl productApplyServiceImpl = new ImsXuanMixloanProductApplyServiceImpl();
    public ImsXuanMixloanProductServiceImpl productServiceImpl = new ImsXuanMixloanProductServiceImpl();
    public TbUsersServiceImpl tbUsersServiceImpl = new TbUsersServiceImpl();

    public AlipayServiceImpl alipayServiceImpl = new AlipayServiceImpl();
    public BankCardsServiceImpl bankCardsServiceImpl = new BankCardsServiceImpl();
    public CategoriesServiceImpl categoriesServiceImpl = new CategoriesServiceImpl();
    public DaikuansServiceImpl daikuansServiceImpl = new DaikuansServiceImpl();
    public EDusServiceImpl eDusServiceImpl = new EDusServiceImpl();
    public HkjBannersServiceImpl hkjBannersServiceImpl = new HkjBannersServiceImpl();
    public HkjsServiceImpl hkjsServiceImpl= new HkjsServiceImpl();
    public JieQianBannersServiceImpl jieQianBannersServiceImpl= new JieQianBannersServiceImpl();
    public JieQianJqCatServiceImpl jieQianJqCatServiceImpl= new JieQianJqCatServiceImpl();
    public JieQiansServiceImpl jieQiansServiceImpl= new JieQiansServiceImpl();
    public JqCatsServiceImpl jqCatsServiceImpl= new JqCatsServiceImpl();
    public MigrationsServiceImpl migrationsServiceImpl = new MigrationsServiceImpl();
    public MobileversionServiceImpl mobileversionServiceImpl = new MobileversionServiceImpl();
    public MoneyRecordsServiceImpl moneyRecordsServiceImpl = new MoneyRecordsServiceImpl();
    public NoticesServiceImpl noticesServiceImpl = new NoticesServiceImpl();
    public OrdersServiceImpl ordersServiceImpl = new OrdersServiceImpl();
    public PasswordResetsServiceImpl passwordResetsServiceImpl = new PasswordResetsServiceImpl();
    public PostsServiceImpl postsServiceImpl = new PostsServiceImpl();
    public ProcessesServiceImpl processesServiceImpl = new ProcessesServiceImpl();
    public ProductsServiceImpl productsServicesImpl = new ProductsServiceImpl();
    public SettingsServiceImpl settingsServiceImpl= new SettingsServiceImpl();
    public TiEsServiceImpl tiEsServiceImpl = new TiEsServiceImpl();
    public ToolsServiceImpl toolsServiceImpl= new ToolsServiceImpl();
    public UsersServiceImpl usersServiceImpl= new UsersServiceImpl();
    public XinYongKasServiceImpl xinYongKasServiceImpl= new XinYongKasServiceImpl();
    public XykBannersServiceImpl xykBannersServiceImpl= new XykBannersServiceImpl();

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(HANDLER_CHANNELACTIVE);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        String clientIPAddress = ((InetSocketAddress) ctx.channel().remoteAddress()).getAddress().getHostAddress();
        System.out.println(HANDLER_CHANNELINACTIVE + ":" + clientIPAddress);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        //System.out.println("channelRead");
        try {
            // 改写成bean
            int infocolLength = byteBuf.readInt();
            byte[] infocolBytes = new byte[infocolLength];
            byteBuf.readBytes(infocolBytes);

            SWbean swbean = (SWbean) NetWorkImpl.getObj(infocolBytes);

            if (swbean.getCommand() == Protocols.HEART_BEAT) {

            } else {

            }
            SWbean resposeSwbean = new SWbean();
            int netCommand = swbean.getCommand();

            System.out.println("command:" + netCommand);
            switch (netCommand) {
                /************************ 用户权限判断 ***********************/
                case Protocols.WELCOME:               //返回副协议: 0为未注册 1为已注册 2
                    if (true) {
                        UsersEntity systemUser = swbean.getUsersEntity();

                        String nickname = systemUser.getNickname();
                        String password = systemUser.getPassword();
                        String mobile = systemUser.getMobile();
                        UsersEntity rebackUser = usersServiceImpl.queryuser(mobile, password);

                        if (rebackUser.getStatus() != null) {
                            resposeSwbean.setUsersEntity(rebackUser);
                            int result = rebackUser.getMember();
                            System.out.println("Status:" + result);
                            System.out.println("0:未激活，1，正常，2，禁用,3没有");
                            resposeSwbean.setResult(result);
                        } else {
                            resposeSwbean.setResult(3);
                        }
                        resposeSwbean.setRecommand(Protocols.WELCOME);
                        resposeSwbean.setCommand(Protocols.WELCOME);
                    }
                    break;

                /************************ 用户权限判断 ***********************/

                /************************ 客户端心跳保持 ***********************/
                case Protocols.HEART_BEAT:
                    resposeSwbean.setRecommand(Protocols.HEART_BEAT);
                    break;

                /*bank*/
                //银行提额通道
                case Protocols.BANKLIST:
                    if (true) {

                        resposeSwbean.setTiEsEntities(tiEsServiceImpl.queryListAll());
                        System.out.println("command:" + tiEsServiceImpl.queryListAll());
                        resposeSwbean.setCommand(Protocols.BANKLIST);
                        resposeSwbean.setRecommand(Protocols.BANKLIST);
                    }
                    break;
                /*bank*/
                //银行信用卡
                case Protocols.BANKCARDLIST:
                    if (true) {

                        resposeSwbean.setXinYongKasEntities(xinYongKasServiceImpl.queryListAll());
                        System.out.println("command:" + xinYongKasServiceImpl.queryListAll());
                        resposeSwbean.setCommand(Protocols.BANKCARDLIST);
                        resposeSwbean.setRecommand(Protocols.BANKCARDLIST);
                    }
                    break;
                //银行借贷通道
                case Protocols.DAIKUANLIST:
                    if (true) {

                        resposeSwbean.setDaikuansEntities(daikuansServiceImpl.queryListAll());
                        System.out.println("command:" + daikuansServiceImpl.queryListAll());
                        resposeSwbean.setCommand(Protocols.DAIKUANLIST);
                        resposeSwbean.setRecommand(Protocols.DAIKUANLIST);
                    }
                    break;
                //银行贷款查询进度
                case Protocols.PROGRESSLIST:
                    if (true) {

                        resposeSwbean.setProcessesEntities(processesServiceImpl.queryListAll());
                        System.out.println("command:" + processesServiceImpl.queryListAll());
                        resposeSwbean.setCommand(Protocols.PROGRESSLIST);
                        resposeSwbean.setRecommand(Protocols.PROGRESSLIST);
                    }
                    break;
                /************************ 客户端登陆 ***********************/
                case Protocols.LOGIN:
                    if (true) {
                        UsersEntity systemUser = swbean.getUsersEntity();
                        //String nickname =  systemUser.getNickname();
                        String mobile =  systemUser.getMobile();

                        String password =  systemUser.getPassword();

                        UsersEntity rebackUser =usersServiceImpl.queryuser(mobile,password);
                        System.out.println("sql执行完成"+rebackUser);
                        if (rebackUser.getStatus()!=null) {
                            System.out.println("sql执行完成2"+rebackUser);
                            resposeSwbean.setUsersEntity(rebackUser);
                            int result = rebackUser.getMember();
                            resposeSwbean.setUsersEntity(rebackUser);

                            System.out.println("Status:" + result);
                            System.out.println("0:未激活，1，正常，2，禁用");
                            resposeSwbean.setResult(result);
                            System.out.println("客户端登陆结果为：" + result);
                        }else{
                            resposeSwbean.setResult(3);
                        }
                        resposeSwbean.setCommand(Protocols.LOGIN);
                        resposeSwbean.setRecommand(Protocols.LOGIN);
                    }
                    break;
                /************************ 客户端注册新用户 ***********************/
                case Protocols.REGISTER:
                    if (true) {
                        UsersEntity systemUser = swbean.getUsersEntity(); //need system user bean
                        int result = usersServiceImpl.insertuser(systemUser);
                        System.out.println("客户端注册新用户结果为：" + result);
                        System.out.println("1表示插入成功，2表示插入失败");
                        resposeSwbean.setResult(result);
                        resposeSwbean.setUsersEntity(systemUser);
                        resposeSwbean.setCommand(Protocols.REGISTER);
                        resposeSwbean.setRecommand(Protocols.REGISTER);
                    }
                    break;
                /************************ 客户端判断用户名是否可用 ***********************/
                case Protocols.CHECKNAME:
                    if (true) {
                        UsersEntity mUser = swbean.getUsersEntity(); //need system user bean

                        UsersEntity rebackUser = usersServiceImpl.queryname(mUser.getNickname());

                        if (rebackUser.getNickname() != null) {

                            System.out.println("客户端判断用户名是否可用结果为：" + 2);
                            System.out.println("（1表示可用，2表示不可用）");
                            resposeSwbean.setResult(2);
                        } else {
                            resposeSwbean.setResult(1);
                        }
                        resposeSwbean.setRecommand(Protocols.CHECKNAME);
                        resposeSwbean.setCommand(Protocols.CHECKNAME);
                    }
                    break;



                case Protocols.KOUZILIST:
                    if (true) {
                        ArrayList<JieQiansEntity> jieQiansEntities = JieQiansServiceImpl.getJieQianList();
                        resposeSwbean.setJieQiansEntities(jieQiansEntities);
                        resposeSwbean.setCommand(Protocols.KOUZILIST);
                        resposeSwbean.setRecommand(Protocols.KOUZILIST);
                    }
                    break;
                case Protocols.KOUZISECONDLIST:
                    if (true) {
                        int KouziType = swbean.getKouziType();
                        ArrayList<JieQiansEntity> jieQiansEntities = JieQiansServiceImpl.getJieQianListByType(KouziType);
                        resposeSwbean.setJieQiansEntities(jieQiansEntities);
                        resposeSwbean.setCommand(Protocols.KOUZISECONDLIST);
                        resposeSwbean.setRecommand(Protocols.KOUZISECONDLIST);
                    }
                    break;
                case Protocols.CONTENTLIST:
                    if (true) {
                        System.out.println(22222);
                        ArrayList<PostsEntity> postsEntities = PostsServiceImpl.getPostsList();
                        resposeSwbean.setPostsEntities(postsEntities);
                        resposeSwbean.setCommand(Protocols.CONTENTLIST);
                        resposeSwbean.setRecommand(Protocols.CONTENTLIST);
                    }
                    break;
                case Protocols.CONTENTLISTBYID:

                    int JisuId = swbean.getJisuType();
                    System.out.println(JisuId);
                    ArrayList<PostsEntity> postsEntities = PostsServiceImpl.getPostsListByType(JisuId);
                    resposeSwbean.setPostsEntities(postsEntities);
                    resposeSwbean.setCommand(Protocols.CONTENTLISTBYID);
                    resposeSwbean.setRecommand(Protocols.CONTENTLISTBYID);
                    break;
                case Protocols.SENDVEVIFYCODE:
                    System.out.println("短信发送接口！");
                    Random random = new Random();
                    String phone = swbean.getPhone();
                    String result = "";
                    for (int i = 0; i < 6; i++) {
                        result += random.nextInt(10);
                    }
//                    try {
//                        sendMessage(phone, result);
//                    } catch (ClientException e) {
//                        e.printStackTrace();
//                    } catch (InterruptedException e) {
//                    }
                    System.out.println(result);
                    resposeSwbean.setPhone(phone);
                    resposeSwbean.setVcode(result);
                    resposeSwbean.setCommand(Protocols.SENDVEVIFYCODE);
                    resposeSwbean.setRecommand(Protocols.SENDVEVIFYCODE);
                    break;


            }
            byte[] resbytes = new NetWorkImpl().getByteData(resposeSwbean);
            ByteBuf byteBuf1 = ctx.alloc().buffer(4 + resbytes.length);
            byteBuf1.writeInt(resbytes.length);
            byteBuf1.writeBytes(resbytes);
            ctx.writeAndFlush(byteBuf1);
        } catch (Exception e) {
            System.out.println(HANDLER_CHANNELREAD_ERROR + e);
            throw e;
        } finally {
            if (byteBuf != null) byteBuf.release();
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.err.println(HANDLER_EXCEPTION_CAUGHT + ":" + cause.getLocalizedMessage());
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent idleStateEvent = (IdleStateEvent) evt;
            if (idleStateEvent.state() == IdleState.READER_IDLE) {
                System.out.println("userEventTriggered: heartbeat timeout, client removed," + ctx.channel());
                ctx.close();
            }
        }
    }
}
