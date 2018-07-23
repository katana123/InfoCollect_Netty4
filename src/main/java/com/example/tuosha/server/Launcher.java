package com.example.tuosha.server;

/**
 * Created by kasim on 15-2-11.
 */
public class Launcher {
    public static void main(String[] args) throws Exception {
        System.out.println("准备开始启动服务器");
        final InfoCollectServer server = new InfoCollectServer();
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                try {
                    server.dispose();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        server.bind();
    }
}
