package cn.chinajdt.bussiness.sys.service;

import cn.chinajdt.bussiness.sys.model.Sysrole;
import cn.chinajdt.sys.exception.BsnException;

import java.util.List;
import java.util.Map;

public interface SysroleService {
    int deleteByPrimaryKey(String sysroleid) throws BsnException;

    int insert(Sysrole record) throws BsnException;

    int insertSelective(Sysrole record) throws BsnException;

    Sysrole selectByPrimaryKey(String sysroleid) throws BsnException;

    int updateByPrimaryKeySelective(Sysrole record) throws BsnException;

    int updateByPrimaryKey(Sysrole record) throws BsnException;

    List<Sysrole> list( Map<String,Object> conditions , int pageno , int pagesize ) ;

    void authority( String[] useridArr , String[] roleidArr ) throws BsnException ;

    void unauthority( String userid , String roleid ) throws BsnException ;

}