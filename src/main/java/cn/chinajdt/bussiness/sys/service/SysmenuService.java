package cn.chinajdt.bussiness.sys.service;

import cn.chinajdt.bussiness.sys.model.Sysmenu;
import cn.chinajdt.sys.exception.BsnException;

import java.util.List;

public interface SysmenuService {

    int deleteByPrimaryKey(String sysmenuid)throws BsnException;

    int insert(Sysmenu record)throws BsnException;

    int insertSelective(Sysmenu record)throws BsnException;

    Sysmenu selectByPrimaryKey(String sysmenuid)throws BsnException;

    int updateByPrimaryKeySelective(Sysmenu record)throws BsnException;

    int updateByPrimaryKey(Sysmenu record)throws BsnException;

    List<Sysmenu> list( int pageno , int pagesize )throws BsnException ;
}