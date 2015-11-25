package cn.chinajdt.bussiness.sys.service;

import cn.chinajdt.bussiness.sys.model.Sysmenu;
import cn.chinajdt.sys.exception.BsnException;

import java.util.List;
import java.util.Map;

public interface SysmenuService {

    int deleteByPrimaryKey(String sysmenuid)throws BsnException;

    int insert(Sysmenu record)throws BsnException;

    int insertSelective(Sysmenu record)throws BsnException;

    Sysmenu selectByPrimaryKey(String sysmenuid);

    int updateByPrimaryKeySelective(Sysmenu record)throws BsnException;

    int updateByPrimaryKey(Sysmenu record)throws BsnException;

    List<Sysmenu> list( Map<String,Object> conditions , int pageno , int pagesize ) ;

    void deleteMenus(String[] idArr )throws BsnException ;
}