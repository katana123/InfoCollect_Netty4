package com.example.tuosha.service.impl;

import com.example.tuosha.Util.ConnectionUtil;
import com.example.tuosha.service.ImsXuanMixloanBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.tuosha.dao.ImsXuanMixloanBankDao;
import com.example.tuosha.model.ImsXuanMixloanBankEntity;


@Service("imsXuanMixloanBankServiceImpl")
public class ImsXuanMixloanBankServiceImpl implements ImsXuanMixloanBankService {
    @Autowired
    private ImsXuanMixloanBankDao imsXuanMixloanBankDao;

    @Override
    public ImsXuanMixloanBankEntity queryObject(Integer id) {
        return imsXuanMixloanBankDao.queryObject(id);
    }

    @Override
    public List<ImsXuanMixloanBankEntity> queryList(Map<String, Object> map) {
        return imsXuanMixloanBankDao.queryList(map);
    }

    public ArrayList<ImsXuanMixloanBankEntity> queryListAll() {
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<ImsXuanMixloanBankEntity> result = new ArrayList<ImsXuanMixloanBankEntity>();
        Connection conn = null;
        try {
            conn = ConnectionUtil.getmysqlConnection();
            String selectSql = "select * from Ims_Xuan_Mixloan_Bank ";
            pst = conn.prepareStatement(selectSql);
            rs = pst.executeQuery();
            while (rs.next()) {
                ImsXuanMixloanBankEntity icf = new ImsXuanMixloanBankEntity();
                icf.setName(rs.getString("name"));
                icf.setId(rs.getInt("id"));
                icf.setExtInfo(rs.getString("ext_info"));

                result.add(icf);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            ConnectionUtil.close(rs, pst, conn);
        }
        return result;
        //return imsXuanMixloanBankDao.queryListAll();
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return imsXuanMixloanBankDao.queryTotal(map);
    }

    @Override
    public void save(ImsXuanMixloanBankEntity imsXuanMixloanBank) {
        imsXuanMixloanBankDao.save(imsXuanMixloanBank);
    }

    @Override
    public int update(ImsXuanMixloanBankEntity imsXuanMixloanBank) {
        return imsXuanMixloanBankDao.update(imsXuanMixloanBank);
    }

    @Override
    public int delete(Integer id) {
        return imsXuanMixloanBankDao.delete(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return imsXuanMixloanBankDao.deleteBatch(ids);
    }

}
