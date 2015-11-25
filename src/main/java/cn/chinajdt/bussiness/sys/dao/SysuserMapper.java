package cn.chinajdt.bussiness.sys.dao;

import cn.chinajdt.bussiness.sys.model.Sysuser;

import java.util.List;
import java.util.Map;

public interface SysuserMapper {
    int deleteByPrimaryKey(String sysuserid);

    int insert(Sysuser record);

    int insertSelective(Sysuser record);

    Sysuser selectByPrimaryKey(String sysuserid);

    int updateByPrimaryKeySelective(Sysuser record);

    int updateByPrimaryKey(Sysuser record);

    List<Sysuser> list ( Map<String,Object> conditions ) ;
}