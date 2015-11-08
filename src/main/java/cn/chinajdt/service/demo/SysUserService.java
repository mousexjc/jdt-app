package cn.chinajdt.service.demo;

import cn.chinajdt.model.demo.SysUser;
import cn.chinajdt.sys.exception.BsnException;

/**
 * Created by Jacky on 15/11/7.
 */
public interface SysUserService {

    int deleteByPrimaryKey(String id) throws BsnException ;

    int insert(SysUser record) throws BsnException ;

    int insertSelective(SysUser record) throws BsnException ;

    SysUser selectByPrimaryKey(String id) throws BsnException ;

    int updateByPrimaryKeySelective(SysUser record) throws BsnException ;

    int updateByPrimaryKey(SysUser record) throws BsnException ;
}
