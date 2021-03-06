package com.scorpion.dao;

import com.scorpion.pojo.NewsOfSHZmq;
import com.scorpion.pojo.NewsOfSHZmqExample;
import com.scorpion.pojo.NewsOfSHZmqKey;
import com.scorpion.pojo.NewsOfSHZmqWithBLOBs;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface NewsOfSHZmqMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shanghainews
     *
     * @mbggenerated
     */
    int countByExample(NewsOfSHZmqExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shanghainews
     *
     * @mbggenerated
     */
    int deleteByExample(NewsOfSHZmqExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shanghainews
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(NewsOfSHZmqKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shanghainews
     *
     * @mbggenerated
     */
    int insert(NewsOfSHZmqWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shanghainews
     *
     * @mbggenerated
     */
    int insertSelective(NewsOfSHZmqWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shanghainews
     *
     * @mbggenerated
     */
    List<NewsOfSHZmqWithBLOBs> selectByExampleWithBLOBs(NewsOfSHZmqExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shanghainews
     *
     * @mbggenerated
     */
    List<NewsOfSHZmq> selectByExample(NewsOfSHZmqExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shanghainews
     *
     * @mbggenerated
     */
    NewsOfSHZmqWithBLOBs selectByPrimaryKey(NewsOfSHZmqKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shanghainews
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") NewsOfSHZmqWithBLOBs record, @Param("example") NewsOfSHZmqExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shanghainews
     *
     * @mbggenerated
     */
    int updateByExampleWithBLOBs(@Param("record") NewsOfSHZmqWithBLOBs record, @Param("example") NewsOfSHZmqExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shanghainews
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") NewsOfSHZmq record, @Param("example") NewsOfSHZmqExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shanghainews
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(NewsOfSHZmqWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shanghainews
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(NewsOfSHZmqWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shanghainews
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(NewsOfSHZmq record);
    /**
     * 获取上海自贸区新闻的数量
     * @return
     */
    int countAllSHZmqNews();

    /**
     * 获取所有上海自贸区新闻
     * @param map
     * @return
     */
    List<NewsOfSHZmqWithBLOBs> selectAllSHZmqNews(Map<String,Integer> map);
    /**
     * 获取匹配结果的公司的新闻
     * @return
     */
    List<NewsOfSHZmqWithBLOBs> selectMatchSHZmqNews(Map map);
    /**
     * 获取匹配新闻的条数
     */
    int countMatchSHZmqNews(Map map);
}