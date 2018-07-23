package com.example.tuosha.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.tuosha.Util.ConnectionUtil;
import com.example.tuosha.model.ImsXuanMixloanBankEntity;
import com.example.tuosha.service.ImsXuanMixloanProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.tuosha.dao.ImsXuanMixloanProductDao;
import com.example.tuosha.model.ImsXuanMixloanProductEntity;


@Service("imsXuanMixloanProductServiceImpl")
public class ImsXuanMixloanProductServiceImpl implements ImsXuanMixloanProductService {
    @Autowired
    private ImsXuanMixloanProductDao imsXuanMixloanProductDao;

    @Override
    public ImsXuanMixloanProductEntity queryObject(Integer id) {
        return imsXuanMixloanProductDao.queryObject(id);
    }

    @Override
    public List<ImsXuanMixloanProductEntity> queryList(Map<String, Object> map) {
        return imsXuanMixloanProductDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return imsXuanMixloanProductDao.queryTotal(map);
    }

    @Override
    public void save(ImsXuanMixloanProductEntity imsXuanMixloanProduct) {
        imsXuanMixloanProductDao.save(imsXuanMixloanProduct);
    }

    @Override
    public int update(ImsXuanMixloanProductEntity imsXuanMixloanProduct) {
        return imsXuanMixloanProductDao.update(imsXuanMixloanProduct);
    }

    @Override
    public int delete(Integer id) {
        return imsXuanMixloanProductDao.delete(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return imsXuanMixloanProductDao.deleteBatch(ids);
    }


    //@Override
    public ArrayList<ImsXuanMixloanProductEntity> getproductArrayList() {
        return imsXuanMixloanProductDao.getproductArrayList();
    }

    @Override
    public ArrayList<ImsXuanMixloanProductEntity> queryProductDebitAll() {
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<ImsXuanMixloanProductEntity> result = new ArrayList<ImsXuanMixloanProductEntity>();
        Connection conn = null;
        try {
            conn = ConnectionUtil.getmysqlConnection();
            String selectSql = "select a.name,b.ext_info" +
                    " from Ims_Xuan_Mixloan_product a " +
                    " left join ims_xuan_mixloan_loan b on b.id = a.relate_id" +
                    " where a.type=2";
            pst = conn.prepareStatement(selectSql);
            rs = pst.executeQuery();
            while (rs.next()) {
                ImsXuanMixloanProductEntity icf = new ImsXuanMixloanProductEntity();
                icf.setName(rs.getString("name"));
                //icf.setId(rs.getInt("id"));
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

        //return imsXuanMixloanProductDao.queryList(map);
    }

    @Override
    public ArrayList<ImsXuanMixloanProductEntity> queryProductBankAll() {
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<ImsXuanMixloanProductEntity> result = new ArrayList<ImsXuanMixloanProductEntity>();
        Connection conn = null;
        try {
            conn = ConnectionUtil.getmysqlConnection();
            String selectSql = "select a.name,b.apply_nums,b.ext_info" +
                    " from Ims_Xuan_Mixloan_product a " +
                    " left join ims_xuan_mixloan_loan b on b.id = a.relate_id" +
                    " where a.type=1";
            pst = conn.prepareStatement(selectSql);
            rs = pst.executeQuery();
            while (rs.next()) {
                ImsXuanMixloanProductEntity icf = new ImsXuanMixloanProductEntity();
                icf.setName(rs.getString("name"));
                //icf.setId(rs.getInt("id"));
                String str = rs.getString("ext_info");
                JSONObject jobject = JSON.parseObject(str);
                jobject.put("apply_num", rs.getInt("apply_nums"));
                String einfo = jobject.toString();
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

        //return imsXuanMixloanProductDao.queryList(map);
    }
}
