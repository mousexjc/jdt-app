package cn.chinajdt.bussiness.sys.dao;

import cn.chinajdt.bussiness.sys.model.Sysuserrole;
import org.apache.ibatis.annotations.Param;

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

    void insertBatch ( List<Sysuserrole> list ) ;

    void deleteByUseridAndRoleid( @Param("userid")String userid , @Param("roleid")String roleid );

    List<Sysuserrole> all( @Param("sysuserid")String sysuserid , @Param("sysroleid") String sysroleid ) ;
}