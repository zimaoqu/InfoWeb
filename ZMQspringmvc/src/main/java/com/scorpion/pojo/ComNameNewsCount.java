package com.scorpion.pojo;

/**
 * Created by xiang on 2017/5/11.
 */
public class ComNameNewsCount {
    //新闻量最多的公司
    private String name;
    private Integer num;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return num;
    }

    public void setCount(Integer count) {
        this.num = count;
    }
}
