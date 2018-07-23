package com.example.tuosha.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

/**
 * Created by kasim on 15-2-10.
 */
public class PropertiesHelper {

    private Properties properties;
    private FileInputStream fileInputStream;
    private FileOutputStream fileOutputStream;
    private String propertiesFile;

    /**
     * Creates a new instance of PropertiesHelper
     */
    public PropertiesHelper(String propertiesFile) throws Exception {
        properties = null;
        fileInputStream = null;
        fileOutputStream = null;
        this.propertiesFile = propertiesFile;
        File file = new File(propertiesFile);
//        if (!file.exists()) {
////            throw new Exception(".config file not exists!");
//            CreateFileUtil.createFile(propertiesFile);
//        }

        fileInputStream = new FileInputStream(this.propertiesFile);
        properties = new Properties();
        properties.load(fileInputStream);
        fileInputStream.close();
        fileInputStream = null;
    }

    public String getValue(String key, String defaultValue) throws Exception {
        // 这里要特别注意，因为 properties 总是默认采用 ISO-8859-1 编码读取配置文件，所以必须进行转码
        // 否则配置文件中含有中文就必然会乱码
        if (defaultValue != null) {
            return new String(properties.getProperty(key, defaultValue).getBytes("ISO-8859-1"), System.getProperty("file.encoding"));
        } else {
            return new String(properties.getProperty(key, "unknown").getBytes("ISO-8859-1"), System.getProperty("file.encoding"));
        }
    }

    // 直接返回字符串键值对类型哈希表
    public HashMap<String, String> getHashMap() {
        if (properties == null) {
            return null;
        }

        /*
         * 因为 properties 实现了 Map<Object, Object> 接口，本可以直接
         * return new HashMap<Object, Object>(properties); 这种方式的
         * HashMap 构造函数可以接受 Map。但是因为要返回的是字符串键值对
         * 类型哈希表，所以还是进行了遍历（字符串键值对类型转换），遍历采
         * 用 entrySet 方式，一次性转换，速度最快！比 keySet 要强太多了！
         */

        HashMap<String, String> hashMap = new HashMap<String, String>();

        Iterator<Map.Entry<Object, Object>> iterator = properties.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Object, Object> entry = iterator.next();
            hashMap.put(entry.getKey().toString(), entry.getValue().toString());
        }

        return hashMap;
    }

    public void setValue(String key, String newValue) throws Exception {
        if (newValue != null) {
            System.out.println("setValue");
            properties.setProperty(key, newValue);
        } else {
            properties.setProperty(key, "unknown");
        }
    }

    public void update() throws Exception {
        fileOutputStream = new FileOutputStream(propertiesFile);
        properties.store(fileOutputStream, "modified by the program");
        fileOutputStream.close();
    }

    public void write(String propertiesFile, String key, String Value) {
        properties = null;
        fileInputStream = null;
        fileOutputStream = null;
        this.propertiesFile = propertiesFile;
        File file = new File(propertiesFile);
        properties = new Properties();
        try {
            if (!file.exists()) {
                throw new Exception(".config file not exists!");
            }
            FileOutputStream fos = new FileOutputStream(file, false);
            // 要添加的内容
            properties.setProperty(key, Value);
            properties.store(fos, null);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}

