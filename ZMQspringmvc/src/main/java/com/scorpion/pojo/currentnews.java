package com.scorpion.pojo;

import java.util.Date;

public class currentnews {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column currentnews.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column currentnews.source
     *
     * @mbggenerated
     */
    private String source;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column currentnews.date
     *
     * @mbggenerated
     */
    private String date;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column currentnews.oreitationvalue
     *
     * @mbggenerated
     */
    private Float oreitationvalue;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column currentnews.ispush
     *
     * @mbggenerated
     */
    private Integer ispush;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column currentnews.isread
     *
     * @mbggenerated
     */
    private Integer isread;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column currentnews.id
     *
     * @return the value of currentnews.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column currentnews.id
     *
     * @param id the value for currentnews.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column currentnews.source
     *
     * @return the value of currentnews.source
     *
     * @mbggenerated
     */
    public String getSource() {
        return source;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column currentnews.source
     *
     * @param source the value for currentnews.source
     *
     * @mbggenerated
     */
    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column currentnews.date
     *
     * @return the value of currentnews.date
     *
     * @mbggenerated
     */
    public String getDate() {
        return date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column currentnews.date
     *
     * @param date the value for currentnews.date
     *
     * @mbggenerated
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column currentnews.oreitationvalue
     *
     * @return the value of currentnews.oreitationvalue
     *
     * @mbggenerated
     */
    public Float getOreitationvalue() {
        return oreitationvalue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column currentnews.oreitationvalue
     *
     * @param oreitationvalue the value for currentnews.oreitationvalue
     *
     * @mbggenerated
     */
    public void setOreitationvalue(Float oreitationvalue) {
        this.oreitationvalue = oreitationvalue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column currentnews.ispush
     *
     * @return the value of currentnews.ispush
     *
     * @mbggenerated
     */
    public Integer getIspush() {
        return ispush;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column currentnews.ispush
     *
     * @param ispush the value for currentnews.ispush
     *
     * @mbggenerated
     */
    public void setIspush(Integer ispush) {
        this.ispush = ispush;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column currentnews.isread
     *
     * @return the value of currentnews.isread
     *
     * @mbggenerated
     */
    public Integer getIsread() {
        return isread;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column currentnews.isread
     *
     * @param isread the value for currentnews.isread
     *
     * @mbggenerated
     */
    public void setIsread(Integer isread) {
        this.isread = isread;
    }
}