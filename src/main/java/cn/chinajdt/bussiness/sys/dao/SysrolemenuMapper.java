package cn.chinajdt.bussiness.sys.dao;

import cn.chinajdt.bussiness.sys.model.Sysrolemenu;

public interface SysrolemenuMapper {
    int deleteByPrimaryKey(String sysrolemenuid);

    int insert(Sysrolemenu record);

    int insertSelective(Sysrolemenu record);

    Sysrolemenu selectByPrimaryKey(String sysrolemenuid);

    int updateByPrimaryKeySelective(Sysrolemenu record);

    int updateByPrimaryKey(Sysrolemenu record);
}