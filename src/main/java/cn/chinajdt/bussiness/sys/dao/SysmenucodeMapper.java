package cn.chinajdt.bussiness.sys.dao;

import cn.chinajdt.bussiness.sys.model.Sysmenucode;

public interface SysmenucodeMapper {
    int deleteByPrimaryKey(String sysmenucodeid);

    int insert(Sysmenucode record);

    int insertSelective(Sysmenucode record);

    Sysmenucode selectByPrimaryKey(String sysmenucodeid);

    int updateByPrimaryKeySelective(Sysmenucode record);

    int updateByPrimaryKey(Sysmenucode record);
}