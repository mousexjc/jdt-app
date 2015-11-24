package cn.chinajdt.bussiness.sys.service;

import cn.chinajdt.bussiness.sys.model.Sysuser;
import cn.chinajdt.sys.exception.BsnException;

public interface SysuserService {
    int deleteByPrimaryKey(Long sysuserid)throws BsnException;

    int insert(Sysuser record)throws BsnException;

    int insertSelective(Sysuser record)throws BsnException;

    Sysuser selectByPrimaryKey(Long sysuserid)throws BsnException;

    int updateByPrimaryKeySelective(Sysuser record)throws BsnException;

    int updateByPrimaryKey(Sysuser record)throws BsnException;
}