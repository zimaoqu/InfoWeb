package com.scorpion.pojo;

/**
 * Created by xiang on 2017/7/12.
 */
public class PredictedandRealistic {
    private String name;
    private String predicted;
    private String realistic;
    private String bignewsid;
    private String similarcount;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPredicted() {
        return predicted;
    }

    public String getBignewsid() {
        return bignewsid;
    }

    public void setBignewsid(String bignewsid) {
        this.bignewsid = bignewsid;
    }

    public String getSimilarcount() {
        return similarcount;
    }

    public void setSimilarcount(String similarcount) {
        this.similarcount = similarcount;
    }

    public void setPredicted(String predicted) {
        this.predicted = predicted;
    }

    public String getRealistic() {
        return realistic;
    }

    public void setRealistic(String realistic) {
        this.realistic = realistic;
    }
}
