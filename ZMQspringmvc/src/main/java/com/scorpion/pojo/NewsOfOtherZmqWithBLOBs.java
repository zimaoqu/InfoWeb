package com.scorpion.pojo;

public class NewsOfOtherZmqWithBLOBs extends NewsOfOtherZmq {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zimaoqunews.name
     *
     * @mbggenerated
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zimaoqunews.title
     *
     * @mbggenerated
     */
    private String title;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zimaoqunews.date
     *
     * @mbggenerated
     */
    private String date;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zimaoqunews.description
     *
     * @mbggenerated
     */
    private String description;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zimaoqunews.keywords
     *
     * @mbggenerated
     */
    private String keywords;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zimaoqunews.Relcompany
     *
     * @mbggenerated
     */
    private String relcompany;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zimaoqunews.html
     *
     * @mbggenerated
     */
    private String html;

    private String url;

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zimaoqunews.name
     *
     * @return the value of zimaoqunews.name
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zimaoqunews.name
     *
     * @param name the value for zimaoqunews.name
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zimaoqunews.title
     *
     * @return the value of zimaoqunews.title
     *
     * @mbggenerated
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zimaoqunews.title
     *
     * @param title the value for zimaoqunews.title
     *
     * @mbggenerated
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zimaoqunews.date
     *
     * @return the value of zimaoqunews.date
     *
     * @mbggenerated
     */
    public String getDate() {
        return date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zimaoqunews.date
     *
     * @param date the value for zimaoqunews.date
     *
     * @mbggenerated
     */
    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zimaoqunews.description
     *
     * @return the value of zimaoqunews.description
     *
     * @mbggenerated
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zimaoqunews.description
     *
     * @param description the value for zimaoqunews.description
     *
     * @mbggenerated
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zimaoqunews.keywords
     *
     * @return the value of zimaoqunews.keywords
     *
     * @mbggenerated
     */
    public String getKeywords() {
        return keywords;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zimaoqunews.keywords
     *
     * @param keywords the value for zimaoqunews.keywords
     *
     * @mbggenerated
     */
    public void setKeywords(String keywords) {
        this.keywords = keywords == null ? null : keywords.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zimaoqunews.Relcompany
     *
     * @return the value of zimaoqunews.Relcompany
     *
     * @mbggenerated
     */
    public String getRelcompany() {
        return relcompany;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zimaoqunews.Relcompany
     *
     * @param relcompany the value for zimaoqunews.Relcompany
     *
     * @mbggenerated
     */
    public void setRelcompany(String relcompany) {
        this.relcompany = relcompany == null ? null : relcompany.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zimaoqunews.html
     *
     * @return the value of zimaoqunews.html
     *
     * @mbggenerated
     */
    public String getHtml() {
        return html;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zimaoqunews.html
     *
     * @param html the value for zimaoqunews.html
     *
     * @mbggenerated
     */
    public void setHtml(String html) {
        this.html = html == null ? null : html.trim();
    }
}