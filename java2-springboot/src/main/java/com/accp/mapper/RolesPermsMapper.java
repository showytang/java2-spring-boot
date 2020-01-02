package com.accp.mapper;

import com.accp.domain.RolesPerms;
import com.accp.domain.RolesPermsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RolesPermsMapper {
    int countByExample(RolesPermsExample example);

    int deleteByExample(RolesPermsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RolesPerms record);

    int insertSelective(RolesPerms record);

    List<RolesPerms> selectByExample(RolesPermsExample example);

    RolesPerms selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RolesPerms record, @Param("example") RolesPermsExample example);

    int updateByExample(@Param("record") RolesPerms record, @Param("example") RolesPermsExample example);

    int updateByPrimaryKeySelective(RolesPerms record);

    int updateByPrimaryKey(RolesPerms record);
}