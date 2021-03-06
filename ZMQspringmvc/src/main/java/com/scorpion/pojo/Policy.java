package com.scorpion.pojo;

import java.util.Date;

public class Policy {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column policy.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column policy.url
     *
     * @mbggenerated
     */
    private String url;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column policy.date
     *
     * @mbggenerated
     */
    private String date;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column policy.title
     *
     * @mbggenerated
     */
    private String title;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column policy.category
     *
     * @mbggenerated
     */
    private String category;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column policy.category_en
     *
     * @mbggenerated
     */
    private String categoryEn;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column policy.id
     *
     * @return the value of policy.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column policy.id
     *
     * @param id the value for policy.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column policy.url
     *
     * @return the value of policy.url
     *
     * @mbggenerated
     */
    public String getUrl() {
        return url;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column policy.url
     *
     * @param url the value for policy.url
     *
     * @mbggenerated
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column policy.date
     *
     * @return the value of policy.date
     *
     * @mbggenerated
     */
    public String getDate() {
        return date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column policy.date
     *
     * @param date the value for policy.date
     *
     * @mbggenerated
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column policy.title
     *
     * @return the value of policy.title
     *
     * @mbggenerated
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column policy.title
     *
     * @param title the value for policy.title
     *
     * @mbggenerated
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column policy.category
     *
     * @return the value of policy.category
     *
     * @mbggenerated
     */
    public String getCategory() {
        return category;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column policy.category
     *
     * @param category the value for policy.category
     *
     * @mbggenerated
     */
    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column policy.category_en
     *
     * @return the value of policy.category_en
     *
     * @mbggenerated
     */
    public String getCategoryEn() {
        return categoryEn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column policy.category_en
     *
     * @param categoryEn the value for policy.category_en
     *
     * @mbggenerated
     */
    public void setCategoryEn(String categoryEn) {
        this.categoryEn = categoryEn == null ? null : categoryEn.trim();
    }
}