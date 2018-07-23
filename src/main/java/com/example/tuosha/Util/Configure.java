package com.example.tuosha.Util;

/**
 * Created by dongdaqing on 15-3-4.
 * 本类用于存放不同模块的不同ITEM TYPE,配合协议头使用,单独使用没有意义
 * 本类还存放各个协议的返回值,表明其意义
 */
public class Configure {
    /***************************内网报表模块 始**********************/
    public static final byte REPORT_DAILYPRODUCTION = 0x01; //生产日报
    public static final byte REPORT_PRODUCTPROGRESS = 0x02; //生产进度
    public static final byte REPORT_PRODUCTEXPRESS = 0x03;//成品速报
    public static final byte REPORT_IRONPARAMETER = 0x04; //炼铁关键参数
    public static final byte REPORT_HOTCHARGING = 0x05; //热装情况统计表
    public static final byte REPORT_THREESTORAGE = 0x06;//三库库存
    public static final byte REPORT_STORAGESEND = 0x07; //库存及外发
    public static final byte REPORT_IMPORTANTSORT = 0x08;//客户端获取重点品种日报
    public static final byte REPORT_CONTRACTEXCU = 0x09;//合同执行报表
    public static final byte REPORT_DAILYRESOUCE = 0x0a;//客户端获取原燃料日报
    public static final byte REPORT_DAILYENERGY = 0x0b; //能源日报
    public static final byte REPORT_DAILYQUALITY = 0x0c;//质量动态日报

    public static final byte REPORT_DAILYIRON = 0x31;//铁前信息
    public static final byte REPORT_DAILYLGYCC = 0x32;//炼钢和一次材信息
    public static final byte REPORT_DAILYECC = 0x33;//二次材生产信息


    /***************************内网报表模块 终**********************/

    /***************************权限获取 始**********************/
    public static final byte CAN_LOGIN = 0x01; //客户端可以登录
    public static final byte REGISTERED = 0x02; //客户端已经注册,但是还没有授权
    public static final byte NEED_REGISTER = 0x03; //客户端没有注册,需要注册
    /***************************权限获取 终**********************/

    /***************************登陆 始**********************/
    public static final byte LOGIN_USERNAME_NOT_EXISTS = 0x01; //用户名不存在
    public static final byte LOGIN_WRONG_PASSWORD = 0x02; //密码错误
    public static final byte LOGIN_WRONG_IMEI = 0x03; //输入的账号密码于绑定的IMEI不匹配
    public static final byte LOGIN_SUCCESS = 0x04; //登陆成功
    /***************************登陆 终**********************/

    /***************************注册 始**********************/
    public static final byte REGISTER_USERNAME_VALIED = 0x01; //用户名可用
    public static final byte REGISTER_USERNAME_INVAILED = 0x02; //用户名不可用
    public static final byte REGISTER_SUCCESS = 0x03; //注册成功
    public static final byte REGISTER_FAILED = 0x04; //注册失败
    /***************************注册 终**********************/

    /***************************行业动态信息 始**********************/
    public static final byte CHANG_CAI = 0x01; //长材
    public static final byte BAN_CAI = 0x02; //板材
    public static final byte DU_XIN_CAI_TU_BAN = 0x03; //镀锌彩涂板
    public static final byte YOU_TE_GANG = 0x04; //优特钢
    public static final byte BU_XIU_GANG = 0x05; //不锈钢
    public static final byte GANG_TIE_YUAN_LIAO = 0x06; //钢铁原料
    public static final byte JING_KOU_TIE_KUANG_SHI = 0x07; //进口铁矿石
    public static final byte TIE_HE_JIN_XIAN_HUO = 0x08; //铁合金现货
    public static final byte GANG_CAI_JI_ZHUN = 0x09; //钢材基准
    public static final byte GANG_TIE_YUAN_LIAO_JI_ZHUN = 0x0a; //钢铁原料基准
    public static final byte TIE_KUANG_SHI = 0x0b; //铁矿石
    public static final byte GANG_PI = 0x0c; //钢坯
    public static final byte MEI_TAN_JI_ZHUN = 0x0d; //煤炭基准
    public static final byte YOU_SE_JIN_SHU = 0x0e; //有色金属
    public static final byte TIE_HE_JIN = 0x0f; //铁合金
    public static final byte FEI_GANG = 0x10; //废钢
    public static final byte PU_SHI_TIE_KUANG_SHI = 0x11; //普氏62%铁矿石
    /***************************行业动态信息 终**********************/

    /***************************行业动态信息图表模块 始**********************/
    public static final byte CVAS_PICTURE = 0x01; //不分日周报的图形数据
    public static final byte CVAS_PICTURE_DAILY = 0x02; //日报图形数据
    public static final byte CVAS_PICTURE_WEEKLY = 0x03; //周报图形数据
    /***************************行业动态信息图表模块 终**********************/

    /***************************云文件模块 始**********************/
    public static final byte CLOUF_FILE_ROOT = 0x01;//获取云文件更目录所有文件和文件夹
    public static final byte CLOUF_FILE_CHILD = 0x02;//获取所点击文件夹的所有内容(文件夹和文件)
    public static final byte CLOUF_FILE_PARENT = 0x03;//获取当前目录的上级目录
    public static final byte CLOUF_FILE_REFERSH = 0x04;//刷新本级目录
    /***************************云文件模块 终**********************/

    /***************************外网商情 始**********************/
    //钢铁模块图表数据
    public static final byte BUSINESS_INTEL_CHART_GANG_CAI_ZHONG_HE = 0x01; //钢铁综合
    public static final byte BUSINESS_INTEL_CHART_CHANG_CAI = 0x02; //长材
    public static final byte BUSINESS_INTEL_CHART_BAN_CAI = 0x03; //板材

    //八个品种模块图表数据
    public static final byte BUSINESS_INTEL_CHART_GAO_XIAN = 0x01; //高线
    public static final byte BUSINESS_INTEL_CHART_LUO_WEN_GANG = 0x02; //螺纹钢
    public static final byte BUSINESS_INTEL_CHART_JIAO_GANG = 0x03; //角钢
    public static final byte BUSINESS_INTEL_CHART_ZHONG_HOU_BAN = 0x04; //中厚板
    public static final byte BUSINESS_INTEL_CHART_RE_ZHA_JUAN_BAN = 0x05; //热轧卷板
    public static final byte BUSINESS_INTEL_CHART_LENG_ZHA_BO_BAN = 0x06; //冷轧薄板
    public static final byte BUSINESS_INTEL_CHART_DU_XIN_BAN = 0x07; //镀锌板
    public static final byte BUSINESS_INTEL_CHART_WU_FENG_GUAN = 0x08; //无缝管
    /***************************外网商情 终**********************/

    /***************************签批模块操作数 始**********************/
    public static final byte DOCUMENT_SIGNATURE_REQUEST_SIGN_IMAGE = 0x01;
    public static final byte DOCUMENT_SIGNATURE_SEND_SIGN_IMAGE = 0x02;
    /***************************签批模块操作数 终**********************/

    /***************************公文发送结果 始**********************/
    public static final byte SEND_DOCUMENT_SUCCEED = 0x01;
    public static final byte SEND_DOCUMENT_FAILED = 0x02;
    /***************************公文发送结果 终**********************/

    /***************************公文区分 始**********************/
    public static final int GW_ZZB = 1; //制造部公文
    public static final int GW_LD = 2; //公司领导公文
    public static final int GW_MS = 3; //秘书公文
    /***************************公文区分 终**********************/
}
