package com.scorpion.pojo;

public class currentnewsWithBLOBs extends currentnews {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column currentnews.title
     *
     * @mbggenerated
     */
    private String title;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column currentnews.url
     *
     * @mbggenerated
     */
    private String url;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column currentnews.keywords
     *
     * @mbggenerated
     */
    private String keywords;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column currentnews.html
     *
     * @mbggenerated
     */
    private String html;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column currentnews.relcompany
     *
     * @mbggenerated
     */
    private String relcompany;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column currentnews.title
     *
     * @return the value of currentnews.title
     *
     * @mbggenerated
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column currentnews.title
     *
     * @param title the value for currentnews.title
     *
     * @mbggenerated
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column currentnews.url
     *
     * @return the value of currentnews.url
     *
     * @mbggenerated
     */
    public String getUrl() {
        return url;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column currentnews.url
     *
     * @param url the value for currentnews.url
     *
     * @mbggenerated
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column currentnews.keywords
     *
     * @return the value of currentnews.keywords
     *
     * @mbggenerated
     */
    public String getKeywords() {
        return keywords;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column currentnews.keywords
     *
     * @param keywords the value for currentnews.keywords
     *
     * @mbggenerated
     */
    public void setKeywords(String keywords) {
        this.keywords = keywords == null ? null : keywords.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column currentnews.html
     *
     * @return the value of currentnews.html
     *
     * @mbggenerated
     */
    public String getHtml() {
        return html;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column currentnews.html
     *
     * @param html the value for currentnews.html
     *
     * @mbggenerated
     */
    public void setHtml(String html) {
        this.html = html == null ? null : html.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column currentnews.relcompany
     *
     * @return the value of currentnews.relcompany
     *
     * @mbggenerated
     */
    public String getRelcompany() {
        return relcompany;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column currentnews.relcompany
     *
     * @param relcompany the value for currentnews.relcompany
     *
     * @mbggenerated
     */
    public void setRelcompany(String relcompany) {
        this.relcompany = relcompany == null ? null : relcompany.trim();
    }
}