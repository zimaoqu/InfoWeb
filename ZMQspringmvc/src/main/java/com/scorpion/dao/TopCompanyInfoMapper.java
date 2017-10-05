package com.scorpion.dao;

import com.scorpion.pojo.TopCompanyInfo;
import com.scorpion.pojo.TopCompanyInfoExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TopCompanyInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table top_info
     *
     * @mbggenerated
     */
    int countByExample(TopCompanyInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table top_info
     *
     * @mbggenerated
     */
    int deleteByExample(TopCompanyInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table top_info
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table top_info
     *
     * @mbggenerated
     */
    int insert(TopCompanyInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table top_info
     *
     * @mbggenerated
     */
    int insertSelective(TopCompanyInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table top_info
     *
     * @mbggenerated
     */
    List<TopCompanyInfo> selectByExample(TopCompanyInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table top_info
     *
     * @mbggenerated
     */
    TopCompanyInfo selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table top_info
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") TopCompanyInfo record, @Param("example") TopCompanyInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table top_info
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") TopCompanyInfo record, @Param("example") TopCompanyInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table top_info
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(TopCompanyInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table top_info
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(TopCompanyInfo record);

    List<String> getIndustryList();

    List<String> getComOfIndustry(Map map);
}