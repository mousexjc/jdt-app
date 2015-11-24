package cn.chinajdt.bussiness.sys.service;

import cn.chinajdt.bussiness.sys.model.Sysuserrole;
import cn.chinajdt.sys.exception.BsnException;

public interface SysuserroleService {

    int deleteByPrimaryKey(String sysuserroleid) throws BsnException;

    int insert(Sysuserrole record) throws BsnException;

    int insertSelective(Sysuserrole record) throws BsnException;

    Sysuserrole selectByPrimaryKey(String sysuserroleid) throws BsnException;

    int updateByPrimaryKeySelective(Sysuserrole record) throws BsnException;

    int updateByPrimaryKey(Sysuserrole record) throws BsnException;
}