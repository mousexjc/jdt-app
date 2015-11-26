package cn.chinajdt.bussiness.sys.dao;

import cn.chinajdt.bussiness.sys.model.Sysrole;

import java.util.List;
import java.util.Map;

public interface SysroleMapper {
    int deleteByPrimaryKey(String sysroleid);

    int insert(Sysrole record);

    int insertSelective(Sysrole record);

    Sysrole selectByPrimaryKey(String sysroleid);

    int updateByPrimaryKeySelective(Sysrole record);

    int updateByPrimaryKey(Sysrole record);

    List<Sysrole> list( Map<String,Object> conditions ) ;
}