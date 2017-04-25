package com.scorpion.dao;

import com.scorpion.pojo.negativenews;
import com.scorpion.pojo.negativenewsExample;
import com.scorpion.pojo.negativenewsWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface negativenewsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table negativenews
     *
     * @mbggenerated
     */
    int countByExample(negativenewsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table negativenews
     *
     * @mbggenerated
     */
    int deleteByExample(negativenewsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table negativenews
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table negativenews
     *
     * @mbggenerated
     */
    int insert(negativenewsWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table negativenews
     *
     * @mbggenerated
     */
    int insertSelective(negativenewsWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table negativenews
     *
     * @mbggenerated
     */
    List<negativenewsWithBLOBs> selectByExampleWithBLOBs(negativenewsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table negativenews
     *
     * @mbggenerated
     */
    List<negativenews> selectByExample(negativenewsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table negativenews
     *
     * @mbggenerated
     */
    negativenewsWithBLOBs selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table negativenews
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") negativenewsWithBLOBs record, @Param("example") negativenewsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table negativenews
     *
     * @mbggenerated
     */
    int updateByExampleWithBLOBs(@Param("record") negativenewsWithBLOBs record, @Param("example") negativenewsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table negativenews
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") negativenews record, @Param("example") negativenewsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table negativenews
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(negativenewsWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table negativenews
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(negativenewsWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table negativenews
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(negativenews record);

    /**
     * query Negativenews
     * @return
     */
    List<negativenewsWithBLOBs> queryNegativenews();
}