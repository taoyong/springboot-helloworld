package com.keeper.springBootHelloWorld.dao.mapper;

import com.keeper.springBootHelloWorld.dao.entity.UserInfo;
import com.keeper.springBootHelloWorld.dao.entity.UserInfoCriteria;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;


public interface UserInfoMapper {
    @SelectProvider(type=UserInfoSqlProvider.class, method="countByExample")
    long countByExample(UserInfoCriteria example);

    @DeleteProvider(type=UserInfoSqlProvider.class, method="deleteByExample")
    int deleteByExample(UserInfoCriteria example);

    @Delete({
        "delete from user",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into user (id, userName, ",
        "userAge, userSex)",
        "values (#{id,jdbcType=BIGINT}, #{userName,jdbcType=VARCHAR}, ",
        "#{userAge,jdbcType=TINYINT}, #{userSex,jdbcType=VARCHAR})"
    })
    int insert(UserInfo record);

    @InsertProvider(type=UserInfoSqlProvider.class, method="insertSelective")
    int insertSelective(UserInfo record);

    @SelectProvider(type=UserInfoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="userName", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="userAge", property="userAge", jdbcType=JdbcType.TINYINT),
        @Result(column="userSex", property="userSex", jdbcType=JdbcType.VARCHAR)
    })
    List<UserInfo> selectByExampleWithRowbounds(UserInfoCriteria example, RowBounds rowBounds);

    @SelectProvider(type=UserInfoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="userName", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="userAge", property="userAge", jdbcType=JdbcType.TINYINT),
        @Result(column="userSex", property="userSex", jdbcType=JdbcType.VARCHAR)
    })
    List<UserInfo> selectByExample(UserInfoCriteria example);

    @Select({
        "select",
        "id, userName, userAge, userSex",
        "from user",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="userName", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="userAge", property="userAge", jdbcType=JdbcType.TINYINT),
        @Result(column="userSex", property="userSex", jdbcType=JdbcType.VARCHAR)
    })
    UserInfo selectByPrimaryKey(Long id);

    @UpdateProvider(type=UserInfoSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") UserInfo record, @Param("example") UserInfoCriteria example);

    @UpdateProvider(type=UserInfoSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") UserInfo record, @Param("example") UserInfoCriteria example);

    @UpdateProvider(type=UserInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UserInfo record);

    @Update({
        "update user",
        "set userName = #{userName,jdbcType=VARCHAR},",
          "userAge = #{userAge,jdbcType=TINYINT},",
          "userSex = #{userSex,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(UserInfo record);
}