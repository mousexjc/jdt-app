package cn.chinajdt.bussiness.sys.service;

import cn.chinajdt.bussiness.sys.model.Sysuser;
import cn.chinajdt.sys.exception.BsnException;

import java.util.List;
import java.util.Map;

public interface SysuserService {
    int deleteByPrimaryKey(String sysuserid)throws BsnException;

    int insert(Sysuser record)throws BsnException;

    int insertSelective(Sysuser record)throws BsnException;

    Sysuser selectByPrimaryKey(String sysuserid);

    int updateByPrimaryKeySelective(Sysuser record)throws BsnException;

    int updateByPrimaryKey(Sysuser record)throws BsnException;

    List<Sysuser> list( Map<String,Object> conditions , int pageno , int pagesize ) ;

}