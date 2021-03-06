package com.scorpion.pojo;

public class NewsOfIndustry extends NewsOfIndustryKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column industry_news.category
     *
     * @mbggenerated
     */

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column industry_news.source
     *
     * @mbggenerated
     */
    private String source;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column industry_news.count
     *
     * @mbggenerated
     */
    private Integer count;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column industry_news.category
     *
     * @return the value of industry_news.category
     *
     * @mbggenerated
     */


    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column industry_news.source
     *
     * @return the value of industry_news.source
     *
     * @mbggenerated
     */
    public String getSource() {
        return source;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column industry_news.source
     *
     * @param source the value for industry_news.source
     *
     * @mbggenerated
     */
    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column industry_news.count
     *
     * @return the value of industry_news.count
     *
     * @mbggenerated
     */
    public Integer getCount() {
        return count;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column industry_news.count
     *
     * @param count the value for industry_news.count
     *
     * @mbggenerated
     */
    public void setCount(Integer count) {
        this.count = count;
    }
}