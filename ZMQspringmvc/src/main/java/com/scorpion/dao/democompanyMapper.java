package com.scorpion.dao;

import com.scorpion.pojo.democompany;
import com.scorpion.pojo.democompanyExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface democompanyMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table democompany
     *
     * @mbggenerated
     */
    int countByExample(democompanyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table democompany
     *
     * @mbggenerated
     */
    int deleteByExample(democompanyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table democompany
     *
     * @mbggenerated
     */
    int insert(democompany record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table democompany
     *
     * @mbggenerated
     */
    int insertSelective(democompany record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table democompany
     *
     * @mbggenerated
     */
    List<democompany> selectByExample(democompanyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table democompany
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") democompany record, @Param("example") democompanyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table democompany
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") democompany record, @Param("example") democompanyExample example);

    /**
     * 根据companyname来获取curreputation
     * @param map
     * @return
     */
    double getCurreputation(Map map);

    List<String> getComList();
}