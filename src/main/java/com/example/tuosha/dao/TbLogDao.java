package com.example.tuosha.dao;

import com.example.tuosha.model.TbLogEntity;
import com.example.tuosha.model.TbLogExample;
import com.example.tuosha.base.dao.BaseDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author qiqiim
 * @email 1044053532@qq.com
 * @date 2018-07-10 12:09:31
 */
public interface TbLogDao extends BaseDao<TbLogEntity> {
    int countByExample(TbLogExample example);

    int deleteByExample(TbLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbLogEntity record);

    int insertSelective(TbLogEntity record);

    List<TbLogEntity> selectByExample(TbLogExample example);

    TbLogEntity selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbLogEntity record, @Param("example") TbLogExample example);

    int updateByExample(@Param("record") TbLogEntity record, @Param("example") TbLogExample example);

    int updateByPrimaryKeySelective(TbLogEntity record);

    int updateByPrimaryKey(TbLogEntity record);

}
