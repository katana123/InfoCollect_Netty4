package com.example.tuosha.Util;

/**
 * Created by kasim on 15-2-10.
 */
public class Protocols {

    public static final String TCP_SERVER_ADDRESS = "192.168.100.105";
    //    public static final String TCP_SERVER_ADDRESS = "10.9.7.74";
    public static final int TCP_SERVER_PORT = 9200;

    public static final int NET_TCP_BUFFER = 64 * 1024 * 1024; // 64MB
    public static final int IMCG_HEARTBEAT_READ_PERIOD_SECONDS = 15;
    public static final int IMCG_HEARTBEAT_WRITE_PERIOD_SECONDS = 16;

    //与服务器通信的协议
    public static final byte DEFAULT = 0x00;
    //心跳
    public static final byte HEART_BEAT = 0x01;
    //用户的访问权限,有可以访问,无法访问需要注册,已注册等待授权三种
    public static final byte PERMISSION = 0x02; //返回协议值:0表示用户未注册,1表示用户已注册但未授权,2表示用户可以登录
    public static final byte BANK = 0x3f; //银行列表
    //登陆协议,登陆成功和登录失败
    public static final byte LOGIN = 0x03; // 返回协议值:0代表登录用户名不存在,1代表登陆成功,2代表登录密码错误,3代表用户信息与绑定设备不匹配
    public static final byte KOUZILIST = 0x04; //返回口子集合的口子列表
    public static final byte REGISTER = 0x06;
    public static final byte CHECK_USRNAME = 0x07;
    public static final byte BANKLIST = 0x05; //银行列表PRODUCT
    public static final byte PRODUCTLIST = 0x08;
    public static final byte BANKCARDLIST = 0x09; //银行列表
    public static final byte PROGRESSLIST = 0x0A;
    public static final byte DAIKUANLIST = 0x0B;
    public static final byte BANKDEBITLIST = 0x10;
    public static final byte PRODUCTEBITLIST = 0x11;
    public static final byte CHECKNAME = 0x12;
    public static final byte WELCOME = 0x13;
    public static final byte KOUZISECONDLIST = 0x14; //返回口子集合的二级页面的口子列表
    public static final byte CONTENTLIST = 0x15; //返回技术主页的新闻列表
    public static final byte CONTENTLISTBYID = 0x16; //返回技术主页的二级新闻列表
    public static final byte SENDVEVIFYCODE = 0x17; //发送短信验证码
}
