package cn.chinajdt.bussiness.demo.service;

import cn.chinajdt.bussiness.demo.model.Demo;
import cn.chinajdt.sys.exception.BsnException;

import java.util.List;

/**
 * Created by Jacky on 15/11/7.
 */
public interface SysUserService {

    int deleteByPrimaryKey(String id) throws BsnException ;

    int insert(Demo record) throws BsnException ;

    int insertSelective(Demo record) throws BsnException ;

    Demo selectByPrimaryKey(String id) throws BsnException ;

    int updateByPrimaryKeySelective(Demo record) throws BsnException ;

    int updateByPrimaryKey(Demo record) throws BsnException ;

    List<Demo> all() ;

    List<Demo> queryPage( int pageNo,int pageSize ) ;
}
