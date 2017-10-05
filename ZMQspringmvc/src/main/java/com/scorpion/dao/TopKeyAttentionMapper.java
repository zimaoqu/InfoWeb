package com.scorpion.dao;

import com.scorpion.pojo.TopKeyAttention;
import com.scorpion.pojo.TopKeyAttentionExample;
import com.scorpion.pojo.TopKeyAttentionWithBLOBs;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TopKeyAttentionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table toptest
     *
     * @mbggenerated
     */
    int countByExample(TopKeyAttentionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table toptest
     *
     * @mbggenerated
     */
    int deleteByExample(TopKeyAttentionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table toptest
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer flag);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table toptest
     *
     * @mbggenerated
     */
    int insert(TopKeyAttentionWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table toptest
     *
     * @mbggenerated
     */
    int insertSelective(TopKeyAttentionWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table toptest
     *
     * @mbggenerated
     */
    List<TopKeyAttentionWithBLOBs> selectByExampleWithBLOBs(TopKeyAttentionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table toptest
     *
     * @mbggenerated
     */
    List<TopKeyAttention> selectByExample(TopKeyAttentionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table toptest
     *
     * @mbggenerated
     */
    TopKeyAttentionWithBLOBs selectByPrimaryKey(Integer flag);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table toptest
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") TopKeyAttentionWithBLOBs record, @Param("example") TopKeyAttentionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table toptest
     *
     * @mbggenerated
     */
    int updateByExampleWithBLOBs(@Param("record") TopKeyAttentionWithBLOBs record, @Param("example") TopKeyAttentionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table toptest
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") TopKeyAttention record, @Param("example") TopKeyAttentionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table toptest
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(TopKeyAttentionWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table toptest
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(TopKeyAttentionWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table toptest
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(TopKeyAttention record);


    /**
     * 获取 根据关键词匹配的新闻（垄断、合并） 企业预警页面
     * @param map
     * @return
     */
    List<TopKeyAttentionWithBLOBs> queryNewsOfAttKey(Map map);
}