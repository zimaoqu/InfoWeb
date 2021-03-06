package com.scorpion.pojo;

import java.util.Date;

public class NewsOfCompanyWithBLOBs extends NewsOfCompany {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_content.name
     *
     * @mbggenerated
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_content.title
     *
     * @mbggenerated
     */
    private String title;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_content.url
     *
     * @mbggenerated
     */
    private String url;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_content.description
     *
     * @mbggenerated
     */
    private String description;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_content.html
     *
     * @mbggenerated
     */
    private String html;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_content.keywords
     *
     * @mbggenerated
     */
    private String keywords;
    private String date;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_content.Relcompany
     *
     * @mbggenerated
     */
    private String relcompany;


    public String getDate() {
        return date;
    }


    public void setDate(String date) {
        this.date = date;
    }



    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_content.name
     *
     * @return the value of tb_content.name
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_content.name
     *
     * @param name the value for tb_content.name
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_content.title
     *
     * @return the value of tb_content.title
     *
     * @mbggenerated
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_content.title
     *
     * @param title the value for tb_content.title
     *
     * @mbggenerated
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_content.url
     *
     * @return the value of tb_content.url
     *
     * @mbggenerated
     */
    public String getUrl() {
        return url;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_content.url
     *
     * @param url the value for tb_content.url
     *
     * @mbggenerated
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_content.description
     *
     * @return the value of tb_content.description
     *
     * @mbggenerated
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_content.description
     *
     * @param description the value for tb_content.description
     *
     * @mbggenerated
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_content.html
     *
     * @return the value of tb_content.html
     *
     * @mbggenerated
     */
    public String getHtml() {
        return html;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_content.html
     *
     * @param html the value for tb_content.html
     *
     * @mbggenerated
     */
    public void setHtml(String html) {
        this.html = html == null ? null : html.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_content.keywords
     *
     * @return the value of tb_content.keywords
     *
     * @mbggenerated
     */
    public String getKeywords() {
        return keywords;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_content.keywords
     *
     * @param keywords the value for tb_content.keywords
     *
     * @mbggenerated
     */
    public void setKeywords(String keywords) {
        this.keywords = keywords == null ? null : keywords.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_content.Relcompany
     *
     * @return the value of tb_content.Relcompany
     *
     * @mbggenerated
     */
    public String getRelcompany() {
        return relcompany;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_content.Relcompany
     *
     * @param relcompany the value for tb_content.Relcompany
     *
     * @mbggenerated
     */
    public void setRelcompany(String relcompany) {
        this.relcompany = relcompany == null ? null : relcompany.trim();
    }
}