package com.scorpion.service;

import com.scorpion.pojo.*;
import com.scorpion.util.data.Page;

import java.text.ParseException;
import java.util.List;

/**
 * Created by Scorpion on 2017/4/19.
 */
public interface SearchService {
    /*
    获取所有重点企业新闻，根据page
     */
    public Page<NewsOfCompanyWithBLOBs> queryAllTopNews(int page);

    /*
    根据条件匹配重点企业新闻
     */
    public Page<NewsOfCompanyWithBLOBs> queryMatchTopNews(int page, String startDate, String endDate, String key);

    /*
    获取所有企业新闻，根据page
     */
    public Page<NewsOfCompanyWithBLOBs> queryAllNews(int page);

    /*
    根据条件匹配企业新闻
     */
    public Page<NewsOfCompanyWithBLOBs> queryMatchNews(int page, String startDate, String endDate, String key);

    /*
    获取所有自贸区政策
     */
    public Page<PolicyOfZmqWithBLOBs> queryAllPolicy(int page);

    /*
    获取所有上海自贸区新闻
     */
    public Page<NewsOfSHZmqWithBLOBs> queryAllSHZmqNews(int page);

    /*
    根据条件匹配企业新闻
     */
    public Page<NewsOfSHZmqWithBLOBs> queryMatchSHZmqNews(int page, String startDate, String endDate);

    /*
    获取所有其他自贸区新闻
     */
    public Page<NewsOfOtherZmqWithBLOBs> queryAllOtherZmqNews(int page);

    /*
    根据条件匹配企业新闻
     */
    public Page<NewsOfOtherZmqWithBLOBs> queryMatchOtherZmqNews(int page, String startDate, String endDate, String key);

    /*
    分类获取政策新闻
     */
    public Page<PolicyWithBLOBs> queryPolicyNewsByCat(int page, String category);

    /*
    获取所有政策新闻
     */
    public Page<PolicyWithBLOBs> queryPolicyNews(int page);

    /*
    条件匹配政策新闻
     */
    public Page<PolicyWithBLOBs> queryMatchPolicyNews(int page, String startDate, String endDate, String key);

    /*
    queryNegativenews
     */
    public List<negativenewsWithBLOBs> queryNegativenews();

    /*
    queryCurrentnews
     */
    public List<currentnewsWithBLOBs> queryCurrentnews();

    /*
    queryCompanyinformation
     */
    public List<companyinformation> querycompanyinfo();

    /*
    获取健康值的
     */
    List<Double> getQuartervalue(String companyName, String date1, String date2);

    /*
    某个时间段正负新闻量以及所有公司名字
     */
    int getPosnum(String companyName, String date1, String date2);
    int getNegnum(String companyName, String date1, String date2);
    List<String> getComList();


    /*(企业舆情评价用到的)
    根据公司的名字来获取正面、中立、负面新闻的篇数(所有时间段),正面、中立、负面新闻
     */
    int getAllTimePosnums(String companyName);
    int getAllTimeNeunums(String companyName);
    int getAllTimeNegnums(String companyName);
    List<NewsOfCompanyWithBLOBs> getPosnews(String companyName);
    List<NewsOfCompanyWithBLOBs> getNeunews(String companyName);
    List<NewsOfCompanyWithBLOBs> getNegnews(String companyName);
    String getCompanyName(String name);
}
