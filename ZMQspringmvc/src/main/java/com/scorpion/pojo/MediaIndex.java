package com.scorpion.pojo;

import java.util.Date;

public class MediaIndex {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mediaindex.keyword
     *
     * @mbggenerated
     */
    private String keyword;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mediaindex.time
     *
     * @mbggenerated
     */
    private Date time;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mediaindex.indexNum
     *
     * @mbggenerated
     */
    private Integer indexnum;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mediaindex.keyword
     *
     * @return the value of mediaindex.keyword
     *
     * @mbggenerated
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mediaindex.keyword
     *
     * @param keyword the value for mediaindex.keyword
     *
     * @mbggenerated
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mediaindex.time
     *
     * @return the value of mediaindex.time
     *
     * @mbggenerated
     */
    public Date getTime() {
        return time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mediaindex.time
     *
     * @param time the value for mediaindex.time
     *
     * @mbggenerated
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mediaindex.indexNum
     *
     * @return the value of mediaindex.indexNum
     *
     * @mbggenerated
     */
    public Integer getIndexnum() {
        return indexnum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mediaindex.indexNum
     *
     * @param indexnum the value for mediaindex.indexNum
     *
     * @mbggenerated
     */
    public void setIndexnum(Integer indexnum) {
        this.indexnum = indexnum;
    }
}