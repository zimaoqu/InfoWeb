package com.scorpion.pojo;

/**
 * 这个类是在企业声誉分析用到的自己创建的
 */
public class CompanyInfo{
    String name;
    double reputation;
    double health;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getReputation() {
        return reputation;
    }

    public void setReputation(double reputation) {
        this.reputation = reputation;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }
}
