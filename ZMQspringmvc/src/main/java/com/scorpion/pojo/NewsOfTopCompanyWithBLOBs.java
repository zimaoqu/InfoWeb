package com.scorpion.pojo;

public class NewsOfTopCompanyWithBLOBs extends NewsOfTopCompany {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column topcompany.name
     *
     * @mbggenerated
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column topcompany.title
     *
     * @mbggenerated
     */
    private String title;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column topcompany.url
     *
     * @mbggenerated
     */
    private String url;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column topcompany.description
     *
     * @mbggenerated
     */
    private String description;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column topcompany.html
     *
     * @mbggenerated
     */
    private String html;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column topcompany.keywords
     *
     * @mbggenerated
     */
    private String keywords;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column topcompany.Relcompany
     *
     * @mbggenerated
     */
    private String relcompany;
    private String date;

    private String industry;

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column topcompany.name
     *
     * @return the value of topcompany.name
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column topcompany.name
     *
     * @param name the value for topcompany.name
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column topcompany.title
     *
     * @return the value of topcompany.title
     *
     * @mbggenerated
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column topcompany.title
     *
     * @param title the value for topcompany.title
     *
     * @mbggenerated
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column topcompany.url
     *
     * @return the value of topcompany.url
     *
     * @mbggenerated
     */
    public String getUrl() {
        return url;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column topcompany.url
     *
     * @param url the value for topcompany.url
     *
     * @mbggenerated
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column topcompany.description
     *
     * @return the value of topcompany.description
     *
     * @mbggenerated
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column topcompany.description
     *
     * @param description the value for topcompany.description
     *
     * @mbggenerated
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column topcompany.html
     *
     * @return the value of topcompany.html
     *
     * @mbggenerated
     */
    public String getHtml() {
        return html;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column topcompany.html
     *
     * @param html the value for topcompany.html
     *
     * @mbggenerated
     */
    public void setHtml(String html) {
        this.html = html == null ? null : html.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column topcompany.keywords
     *
     * @return the value of topcompany.keywords
     *
     * @mbggenerated
     */
    public String getKeywords() {
        return keywords;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column topcompany.keywords
     *
     * @param keywords the value for topcompany.keywords
     *
     * @mbggenerated
     */
    public void setKeywords(String keywords) {
        this.keywords = keywords == null ? null : keywords.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column topcompany.Relcompany
     *
     * @return the value of topcompany.Relcompany
     *
     * @mbggenerated
     */
    public String getRelcompany() {
        return relcompany;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column topcompany.Relcompany
     *
     * @param relcompany the value for topcompany.Relcompany
     *
     * @mbggenerated
     */
    public void setRelcompany(String relcompany) {
        this.relcompany = relcompany == null ? null : relcompany.trim();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}