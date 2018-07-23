package com.example.tuosha.service;

import com.example.tuosha.model.KouziBean;
import com.example.tuosha.dao.KouziDao;

import java.util.ArrayList;

public class KouziImpl {

    public static ArrayList<KouziBean> getKouziList() throws Exception {
        KouziDao basicDao = new KouziDao();
        ArrayList<KouziBean> KouziBeans = basicDao.SelectKz();
        return KouziBeans;
    }

    public static ArrayList<KouziBean> getKouziListByType(int type) throws Exception {
        KouziDao basicDao = new KouziDao();
        ArrayList<KouziBean> KouziBeans = basicDao.SelectKzByType(type);
        return KouziBeans;
    }
}
