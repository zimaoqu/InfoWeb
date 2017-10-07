package com.scorpion.dao;

import com.scorpion.pojo.copper;
import com.scorpion.pojo.copperExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface copperMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table copper
     *
     * @mbggenerated
     */
    int countByExample(copperExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table copper
     *
     * @mbggenerated
     */
    int deleteByExample(copperExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table copper
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table copper
     *
     * @mbggenerated
     */
    int insert(copper record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table copper
     *
     * @mbggenerated
     */
    int insertSelective(copper record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table copper
     *
     * @mbggenerated
     */
    List<copper> selectByExample(copperExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table copper
     *
     * @mbggenerated
     */
    copper selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table copper
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") copper record, @Param("example") copperExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table copper
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") copper record, @Param("example") copperExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table copper
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(copper record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table copper
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(copper record);

    /**
     * 获取国际copper的数据
     * @return
     */
    List<copper> selectAllCopper();
}