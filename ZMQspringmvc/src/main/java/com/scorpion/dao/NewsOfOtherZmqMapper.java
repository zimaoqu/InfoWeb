package com.scorpion.dao;

import com.scorpion.pojo.NewsOfOtherZmq;
import com.scorpion.pojo.NewsOfOtherZmqExample;
import com.scorpion.pojo.NewsOfOtherZmqKey;
import com.scorpion.pojo.NewsOfOtherZmqWithBLOBs;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface NewsOfOtherZmqMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zimaoqunews
     *
     * @mbggenerated
     */
    int countByExample(NewsOfOtherZmqExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zimaoqunews
     *
     * @mbggenerated
     */
    int deleteByExample(NewsOfOtherZmqExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zimaoqunews
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(NewsOfOtherZmqKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zimaoqunews
     *
     * @mbggenerated
     */
    int insert(NewsOfOtherZmqWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zimaoqunews
     *
     * @mbggenerated
     */
    int insertSelective(NewsOfOtherZmqWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zimaoqunews
     *
     * @mbggenerated
     */
    List<NewsOfOtherZmqWithBLOBs> selectByExampleWithBLOBs(NewsOfOtherZmqExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zimaoqunews
     *
     * @mbggenerated
     */
    List<NewsOfOtherZmq> selectByExample(NewsOfOtherZmqExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zimaoqunews
     *
     * @mbggenerated
     */
    NewsOfOtherZmqWithBLOBs selectByPrimaryKey(NewsOfOtherZmqKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zimaoqunews
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") NewsOfOtherZmqWithBLOBs record, @Param("example") NewsOfOtherZmqExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zimaoqunews
     *
     * @mbggenerated
     */
    int updateByExampleWithBLOBs(@Param("record") NewsOfOtherZmqWithBLOBs record, @Param("example") NewsOfOtherZmqExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zimaoqunews
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") NewsOfOtherZmq record, @Param("example") NewsOfOtherZmqExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zimaoqunews
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(NewsOfOtherZmqWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zimaoqunews
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(NewsOfOtherZmqWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zimaoqunews
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(NewsOfOtherZmq record);
    /**
     * 获取其他自贸区所有新闻的条数
     */
    int countAllOtherZmqNews();

    /**
     * 获取其他自贸区新闻
     * @param map
     * @return
     */
    List<NewsOfOtherZmqWithBLOBs> selectAllOtherZmqNews(Map map);
    /**
     * 获取匹配结果的公司的新闻
     * @return
     */
    List<NewsOfOtherZmqWithBLOBs> selectMatchOtherZmqNews(Map map);
    /**
     * 获取匹配新闻的条数
     */
    int countMatchOtherZmqNews(Map map);
}