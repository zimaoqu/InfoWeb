package com.scorpion.pojo;

public class NewsOfOtherZmqKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zimaoqunews.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zimaoqunews.url
     *
     * @mbggenerated
     */
    private String url;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zimaoqunews.id
     *
     * @return the value of zimaoqunews.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zimaoqunews.id
     *
     * @param id the value for zimaoqunews.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zimaoqunews.url
     *
     * @return the value of zimaoqunews.url
     *
     * @mbggenerated
     */
    public String getUrl() {
        return url;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zimaoqunews.url
     *
     * @param url the value for zimaoqunews.url
     *
     * @mbggenerated
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }
}