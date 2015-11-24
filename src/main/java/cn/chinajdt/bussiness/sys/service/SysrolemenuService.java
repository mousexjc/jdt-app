package cn.chinajdt.bussiness.sys.service;

import cn.chinajdt.bussiness.sys.model.Sysrolemenu;
import cn.chinajdt.sys.exception.BsnException;

public interface SysrolemenuService {
    int deleteByPrimaryKey(String sysrolemenuid) throws BsnException;

    int insert(Sysrolemenu record) throws BsnException;

    int insertSelective(Sysrolemenu record) throws BsnException;

    Sysrolemenu selectByPrimaryKey(String sysrolemenuid) throws BsnException;

    int updateByPrimaryKeySelective(Sysrolemenu record) throws BsnException;

    int updateByPrimaryKey(Sysrolemenu record) throws BsnException;
}