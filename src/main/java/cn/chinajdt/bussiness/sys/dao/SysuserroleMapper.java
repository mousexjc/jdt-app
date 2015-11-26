package cn.chinajdt.bussiness.sys.dao;

import cn.chinajdt.bussiness.sys.model.Sysuserrole;

import java.util.List;
import java.util.Map;

public interface SysuserroleMapper {
    int deleteByPrimaryKey(String sysuserroleid);

    int insert(Sysuserrole record);

    int insertSelective(Sysuserrole record);

    Sysuserrole selectByPrimaryKey(String sysuserroleid);

    int updateByPrimaryKeySelective(Sysuserrole record);

    int updateByPrimaryKey(Sysuserrole record);

    void deleteByUserid ( String sysuserid ) ;

    void deleteByRoleid ( String sysroleid ) ;

    List<Sysuserrole> list( Map<String,Object> conditions ) ;
}