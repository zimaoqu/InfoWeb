package com.scorpion.pojo;

public class negativenewsWithBLOBs extends negativenews {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column negativenews.title
     *
     * @mbggenerated
     */
    private String title;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column negativenews.url
     *
     * @mbggenerated
     */
    private String url;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column negativenews.keywords
     *
     * @mbggenerated
     */
    private String keywords;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column negativenews.html
     *
     * @mbggenerated
     */
    private String html;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column negativenews.relcompany
     *
     * @mbggenerated
     */
    private String relcompany;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column negativenews.title
     *
     * @return the value of negativenews.title
     *
     * @mbggenerated
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column negativenews.title
     *
     * @param title the value for negativenews.title
     *
     * @mbggenerated
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column negativenews.url
     *
     * @return the value of negativenews.url
     *
     * @mbggenerated
     */
    public String getUrl() {
        return url;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column negativenews.url
     *
     * @param url the value for negativenews.url
     *
     * @mbggenerated
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column negativenews.keywords
     *
     * @return the value of negativenews.keywords
     *
     * @mbggenerated
     */
    public String getKeywords() {
        return keywords;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column negativenews.keywords
     *
     * @param keywords the value for negativenews.keywords
     *
     * @mbggenerated
     */
    public void setKeywords(String keywords) {
        this.keywords = keywords == null ? null : keywords.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column negativenews.html
     *
     * @return the value of negativenews.html
     *
     * @mbggenerated
     */
    public String getHtml() {
        return html;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column negativenews.html
     *
     * @param html the value for negativenews.html
     *
     * @mbggenerated
     */
    public void setHtml(String html) {
        this.html = html == null ? null : html.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column negativenews.relcompany
     *
     * @return the value of negativenews.relcompany
     *
     * @mbggenerated
     */
    public String getRelcompany() {
        return relcompany;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column negativenews.relcompany
     *
     * @param relcompany the value for negativenews.relcompany
     *
     * @mbggenerated
     */
    public void setRelcompany(String relcompany) {
        this.relcompany = relcompany == null ? null : relcompany.trim();
    }
}