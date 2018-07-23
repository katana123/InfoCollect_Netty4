package com.example.tuosha.service;

import com.example.tuosha.model.ContentBean;
import com.example.tuosha.dao.ContentDao;

import java.util.ArrayList;

public class ContentImpl {

    public static ArrayList<ContentBean> getContentList() {
        ContentDao contentDao = new ContentDao();
        ArrayList<ContentBean> contentBeans = contentDao.SelectContents();
        return contentBeans;
    }

    public static ArrayList<ContentBean> getContentListByType(int type) throws Exception {
        ContentDao basicDao = new ContentDao();
        ArrayList<ContentBean> contentBeans = basicDao.SelectContentsByType(type);
        return contentBeans;
    }
}
