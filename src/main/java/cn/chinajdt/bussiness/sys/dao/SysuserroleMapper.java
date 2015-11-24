package cn.chinajdt.bussiness.sys.dao;

import cn.chinajdt.bussiness.sys.model.Sysuserrole;

public interface SysuserroleMapper {
    int deleteByPrimaryKey(String sysuserroleid);

    int insert(Sysuserrole record);

    int insertSelective(Sysuserrole record);

    Sysuserrole selectByPrimaryKey(String sysuserroleid);

    int updateByPrimaryKeySelective(Sysuserrole record);

    int updateByPrimaryKey(Sysuserrole record);
}