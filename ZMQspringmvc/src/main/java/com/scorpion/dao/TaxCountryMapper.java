package com.scorpion.dao;

import com.scorpion.pojo.TaxCountry;
import com.scorpion.pojo.TaxCountryExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TaxCountryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tax_country
     *
     * @mbggenerated
     */
    int countByExample(TaxCountryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tax_country
     *
     * @mbggenerated
     */
    int deleteByExample(TaxCountryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tax_country
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tax_country
     *
     * @mbggenerated
     */
    int insert(TaxCountry record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tax_country
     *
     * @mbggenerated
     */
    int insertSelective(TaxCountry record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tax_country
     *
     * @mbggenerated
     */
    List<TaxCountry> selectByExample(TaxCountryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tax_country
     *
     * @mbggenerated
     */
    TaxCountry selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tax_country
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") TaxCountry record, @Param("example") TaxCountryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tax_country
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") TaxCountry record, @Param("example") TaxCountryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tax_country
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(TaxCountry record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tax_country
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(TaxCountry record);
    /**
     * 获取全国TaxCountry的数据
     * @return
     */
    List<TaxCountry> selectAllTaxCountry();
}