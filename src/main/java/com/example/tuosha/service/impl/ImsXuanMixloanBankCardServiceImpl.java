package com.example.tuosha.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.tuosha.Util.ConnectionUtil;
import com.example.tuosha.model.ImsXuanMixloanBankEntity;
import com.example.tuosha.service.ImsXuanMixloanBankCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.tuosha.dao.ImsXuanMixloanBankCardDao;
import com.example.tuosha.model.ImsXuanMixloanBankCardEntity;


@Service("imsXuanMixloanBankCardServiceImpl")
public class ImsXuanMixloanBankCardServiceImpl implements ImsXuanMixloanBankCardService {
    @Autowired
    private ImsXuanMixloanBankCardDao imsXuanMixloanBankCardDao;

    @Override
    public ImsXuanMixloanBankCardEntity queryObject(Integer id) {
        return imsXuanMixloanBankCardDao.queryObject(id);
    }

    @Override
    public List<ImsXuanMixloanBankCardEntity> queryList(Map<String, Object> map) {
        return imsXuanMixloanBankCardDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return imsXuanMixloanBankCardDao.queryTotal(map);
    }

    @Override
    public void save(ImsXuanMixloanBankCardEntity imsXuanMixloanBankCard) {
        imsXuanMixloanBankCardDao.save(imsXuanMixloanBankCard);
    }

    @Override
    public int update(ImsXuanMixloanBankCardEntity imsXuanMixloanBankCard) {
        return imsXuanMixloanBankCardDao.update(imsXuanMixloanBankCard);
    }

    @Override
    public int delete(Integer id) {
        return imsXuanMixloanBankCardDao.delete(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return imsXuanMixloanBankCardDao.deleteBatch(ids);
    }


    public ArrayList<ImsXuanMixloanBankCardEntity> queryListAll() {
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<ImsXuanMixloanBankCardEntity> result = new ArrayList<ImsXuanMixloanBankCardEntity>();
        Connection conn = null;
        try {
            conn = ConnectionUtil.getmysqlConnection();
            String selectSql = "select a.name,a.ext_info, " +
                    "b.id,b.name as cardname,b.apply_nums,b.ext_info as ext_info2 " +
                    "from Ims_Xuan_Mixloan_Bank a " +
                    "left join Ims_Xuan_Mixloan_Bank_Card b on a.id = b.bank_id " +
                    "where b.id>0";
            pst = conn.prepareStatement(selectSql);
            rs = pst.executeQuery();
            while (rs.next()) {
                ImsXuanMixloanBankCardEntity icf = new ImsXuanMixloanBankCardEntity();
                icf.setName(rs.getString("name"));//请求的银行名称
                icf.setId(rs.getInt("id"));
                icf.setApplyNums(rs.getInt("apply_nums"));

                //把银行的说明串，加入到银行卡的说明串
                String str1 = rs.getString("ext_info");
                JSONObject jobject = JSON.parseObject(str1);
                String subscribe_tips = jobject.getString("subscribe_tips");
                String str2 = rs.getString("ext_info2");
                JSONObject jobject2 = JSON.parseObject(str2);
                jobject2.put("subscribe_tips", subscribe_tips);
                String einfo = jobject2.toString();
                icf.setExtInfo(einfo);
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

    public ArrayList<ImsXuanMixloanBankCardEntity> queryDebitAll() {
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<ImsXuanMixloanBankCardEntity> result = new ArrayList<ImsXuanMixloanBankCardEntity>();
        Connection conn = null;
        try {
            conn = ConnectionUtil.getmysqlConnection();
            String selectSql = "select * " +
                    "from Ims_Xuan_Mixloan_Bank_Card ";
            pst = conn.prepareStatement(selectSql);
            rs = pst.executeQuery();
            while (rs.next()) {
                ImsXuanMixloanBankCardEntity icf = new ImsXuanMixloanBankCardEntity();
                icf.setName(rs.getString("name"));//请求的银行名称
                icf.setId(rs.getInt("id"));
                icf.setApplyNums(rs.getInt("apply_nums"));

                //把银行的说明串，加入到银行卡的说明串
                String str1 = rs.getString("ext_info");
                JSONObject jobject = JSON.parseObject(str1);
                String subscribe_tips = jobject.getString("subscribe_tips");
                String str2 = rs.getString("ext_info2");
                JSONObject jobject2 = JSON.parseObject(str2);
                jobject2.put("subscribe_tips", subscribe_tips);
                String einfo = jobject2.toString();
                icf.setExtInfo(einfo);
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
}
