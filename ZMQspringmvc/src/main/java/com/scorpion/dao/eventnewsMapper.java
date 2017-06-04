package com.scorpion.dao;

import com.scorpion.pojo.eventnews;
import com.scorpion.pojo.eventnewsExample;
import com.scorpion.pojo.eventnewsWithBLOBs;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface eventnewsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_event
     *
     * @mbggenerated
     */
    int countByExample(eventnewsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_event
     *
     * @mbggenerated
     */
    int deleteByExample(eventnewsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_event
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_event
     *
     * @mbggenerated
     */
    int insert(eventnewsWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_event
     *
     * @mbggenerated
     */
    int insertSelective(eventnewsWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_event
     *
     * @mbggenerated
     */
    List<eventnewsWithBLOBs> selectByExampleWithBLOBs(eventnewsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_event
     *
     * @mbggenerated
     */
    List<eventnews> selectByExample(eventnewsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_event
     *
     * @mbggenerated
     */
    eventnewsWithBLOBs selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_event
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") eventnewsWithBLOBs record, @Param("example") eventnewsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_event
     *
     * @mbggenerated
     */
    int updateByExampleWithBLOBs(@Param("record") eventnewsWithBLOBs record, @Param("example") eventnewsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_event
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") eventnews record, @Param("example") eventnewsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_event
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(eventnewsWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_event
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(eventnewsWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_event
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(eventnews record);

    List<eventnewsWithBLOBs> getEventNews(Map map);
}