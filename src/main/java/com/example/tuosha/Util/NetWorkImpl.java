package com.example.tuosha.Util;

import java.io.*;

/**
 * Created by kasim on 15-2-10.
 */
public class NetWorkImpl {
    public static byte[] getByteData(Object o) throws Exception {
        if (o == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(o);
        byte[] ndata = byteArrayOutputStream.toByteArray();
        objectOutputStream.close();
        return ndata;
    }

    public static Object getObj(byte[] data) {
        if (data == null) {
            return null;
        }

        Object object = null;
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new ByteArrayInputStream(data));
            object = objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return object;
    }
}
