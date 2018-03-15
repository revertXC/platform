package com.deer.shiro.mapper.shiro;


import com.deer.common.annotation.MybatisDao;
import com.deer.shiro.model.Operation;

@MybatisDao
public interface OperationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Operation record);

    int insertSelective(Operation record);

    Operation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Operation record);

    int updateByPrimaryKey(Operation record);
}