package com.scorpion.pojo;

public class crude_btl extends crude_btlKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column crude_btl.name
     *
     * @mbggenerated
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column crude_btl.price
     *
     * @mbggenerated
     */
    private String price;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column crude_btl.ups_and_downs
     *
     * @mbggenerated
     */
    private String upsAndDowns;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column crude_btl.ups_and_downs_l
     *
     * @mbggenerated
     */
    private String upsAndDownsL;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crude_btl.name
     *
     * @return the value of crude_btl.name
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crude_btl.name
     *
     * @param name the value for crude_btl.name
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crude_btl.price
     *
     * @return the value of crude_btl.price
     *
     * @mbggenerated
     */
    public String getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crude_btl.price
     *
     * @param price the value for crude_btl.price
     *
     * @mbggenerated
     */
    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crude_btl.ups_and_downs
     *
     * @return the value of crude_btl.ups_and_downs
     *
     * @mbggenerated
     */
    public String getUpsAndDowns() {
        return upsAndDowns;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crude_btl.ups_and_downs
     *
     * @param upsAndDowns the value for crude_btl.ups_and_downs
     *
     * @mbggenerated
     */
    public void setUpsAndDowns(String upsAndDowns) {
        this.upsAndDowns = upsAndDowns == null ? null : upsAndDowns.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crude_btl.ups_and_downs_l
     *
     * @return the value of crude_btl.ups_and_downs_l
     *
     * @mbggenerated
     */
    public String getUpsAndDownsL() {
        return upsAndDownsL;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crude_btl.ups_and_downs_l
     *
     * @param upsAndDownsL the value for crude_btl.ups_and_downs_l
     *
     * @mbggenerated
     */
    public void setUpsAndDownsL(String upsAndDownsL) {
        this.upsAndDownsL = upsAndDownsL == null ? null : upsAndDownsL.trim();
    }
}