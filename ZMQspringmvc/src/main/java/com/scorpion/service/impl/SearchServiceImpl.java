package com.scorpion.service.impl;

import com.scorpion.dao.*;
import com.scorpion.pojo.*;
import com.scorpion.service.SearchService;
import com.scorpion.util.data.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Scorpion on 2017/4/19.
 */
@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    private NewsOfCompanyMapper newsOfCompanyMapper;
    @Autowired
    private NewsOfTopCompanyMapper newsOfTopCompanyMapper;
    @Autowired
    private PolicyOfZmqMapper policyOfZmqMapper;
    @Autowired
    private NewsOfSHZmqMapper newsOfSHZmqMapper;
    @Autowired
    private NewsOfOtherZmqMapper newsOfOtherZmqMapper;
    @Autowired
    private PolicyMapper policyMapper;
    @Autowired
    private negativenewsMapper negativenewsMapper;
    @Autowired
    private currentnewsMapper currentnewsMapper;
    @Autowired
    private companyinformationMapper companyinformationMapper;
    /*
    The size of a page.
     */
    final static int pageSize = 10;

    /**
     * 获取所有重点企业新闻
     *
     * @param page
     * @return
     */
    @Override
    public Page<NewsOfCompanyWithBLOBs> queryAllTopNews(int page) {
        Map map = new HashMap<>();
        int countOfNews = newsOfTopCompanyMapper.countAllNews();
        int start = (page - 1) * pageSize;
        map.put("start", start);
        map.put("size", pageSize);
        List<NewsOfCompanyWithBLOBs> dateList = newsOfTopCompanyMapper.selectAllNews(map);

        Page<NewsOfCompanyWithBLOBs> resultPage = new Page(dateList, countOfNews, pageSize);
        return resultPage;
    }

    /**
     * 获取匹配得到的重点企业新闻
     *
     * @param page
     * @param startDate
     * @param endDate
     * @param key
     * @return
     */
    @Override
    public Page<NewsOfCompanyWithBLOBs> queryMatchTopNews(int page, String startDate, String endDate, String key) {
        Map map = new HashMap<>();
        int start = (page - 1) * pageSize;
        map.put("name", key);
        map.put("startDate", startDate);
        map.put("endDate", endDate);
        map.put("start", start);
        map.put("size", pageSize);
        int countOfNews = newsOfTopCompanyMapper.countMatchNews(map);
        List<NewsOfCompanyWithBLOBs> dateList = newsOfTopCompanyMapper.selectMatchNews(map);
        Page<NewsOfCompanyWithBLOBs> resultPage = new Page(dateList, countOfNews, pageSize);
        return resultPage;
    }

    /**
     * 获取企业新闻
     *
     * @param page
     * @return
     */
    @Override
    public Page<NewsOfCompanyWithBLOBs> queryAllNews(int page) {
        Map map = new HashMap<>();
        int countOfNews = newsOfCompanyMapper.countAllNews();
        int start = (page - 1) * pageSize;
        map.put("start", start);
        map.put("size", pageSize);
        List<NewsOfCompanyWithBLOBs> dateList = newsOfCompanyMapper.selectAllNews(map);
        Page<NewsOfCompanyWithBLOBs> resultPage = new Page(dateList, countOfNews, pageSize);
        return resultPage;
    }

    /**
     * 获取匹配得到的企业新闻
     *
     * @param page
     * @param startDate
     * @param endDate
     * @param key
     * @return
     */
    @Override
    public Page<NewsOfCompanyWithBLOBs> queryMatchNews(int page, String startDate, String endDate, String key) {
        Map map = new HashMap<>();
        int start = (page - 1) * pageSize;
        map.put("name", key);
        map.put("startDate", startDate);
        map.put("endDate", endDate);
        map.put("start", start);
        map.put("size", pageSize);
        int countOfNews = newsOfCompanyMapper.countMatchNews(map);
        List<NewsOfCompanyWithBLOBs> dateList = newsOfCompanyMapper.selectMatchNews(map);
        Page<NewsOfCompanyWithBLOBs> resultPage = new Page(dateList, countOfNews, pageSize);
        return resultPage;
    }

    /**
     * 获取自贸区政策
     *
     * @param page
     * @return
     */
    @Override
    public Page<PolicyOfZmqWithBLOBs> queryAllPolicy(int page) {
        Map map = new HashMap<>();
        int countofPolicy = policyOfZmqMapper.countAllZmqPolicy();
        int start = (page - 1) * pageSize;
        map.put("start", start);
        map.put("size", pageSize);
        List<PolicyOfZmqWithBLOBs> dateList = policyOfZmqMapper.selectAllZmqPolicy(map);
        Page<PolicyOfZmqWithBLOBs> resultPage = new Page(dateList, countofPolicy, pageSize);
        return resultPage;
    }

    /**
     * 获取上海自贸区新闻
     *
     * @param page
     * @return
     */
    @Override
    public Page<NewsOfSHZmqWithBLOBs> queryAllSHZmqNews(int page) {
        Map map = new HashMap<>();
        int count = newsOfSHZmqMapper.countAllSHZmqNews();
        int start = (page - 1) * pageSize;
        map.put("start", start);
        map.put("size", pageSize);
        List<NewsOfSHZmqWithBLOBs> dateList = newsOfSHZmqMapper.selectAllSHZmqNews(map);
        Page<NewsOfSHZmqWithBLOBs> resultPage = new Page(dateList, count, pageSize);
        return resultPage;
    }

    /**
     * 获取其他自贸区新闻
     *
     * @param page
     * @return
     */
    @Override
    public Page<NewsOfOtherZmqWithBLOBs> queryAllOtherZmqNews(int page) {
        Map map = new HashMap<>();
        int count = newsOfOtherZmqMapper.countAllOtherZmqNews();
        int start = (page - 1) * pageSize;
        map.put("start", start);
        map.put("size", pageSize);
        List<NewsOfOtherZmqWithBLOBs> dateList = newsOfOtherZmqMapper.selectAllOtherZmqNews(map);
        Page<NewsOfOtherZmqWithBLOBs> resultPage = new Page(dateList, count, pageSize);
        return resultPage;
    }

    /**
     * 匹配得到的上海自贸区新闻
     *
     * @param page
     * @param startDate
     * @param endDate
     * @return
     */
    @Override
    public Page<NewsOfSHZmqWithBLOBs> queryMatchSHZmqNews(int page, String startDate, String endDate) {
        Map map = new HashMap<>();
        int start = (page - 1) * pageSize;
        map.put("startDate", startDate);
        map.put("endDate", endDate);
        map.put("start", start);
        map.put("size", pageSize);
        int countOfNews = newsOfSHZmqMapper.countMatchSHZmqNews(map);
        List<NewsOfSHZmqWithBLOBs> dateList = newsOfSHZmqMapper.selectMatchSHZmqNews(map);
        Page<NewsOfSHZmqWithBLOBs> resultPage = new Page(dateList, countOfNews, pageSize);
        return resultPage;
    }

    /**
     * 匹配得到的其他自贸区新闻
     */
    @Override
    public Page<NewsOfOtherZmqWithBLOBs> queryMatchOtherZmqNews(int page, String startDate, String endDate, String key) {
        Map map = new HashMap<>();
        int start = (page - 1) * pageSize;
        map.put("name", key);
        map.put("startDate", startDate);
        map.put("endDate", endDate);
        map.put("start", start);
        map.put("size", pageSize);
        int countOfNews = newsOfOtherZmqMapper.countMatchOtherZmqNews(map);
        List<NewsOfOtherZmqWithBLOBs> dateList = newsOfOtherZmqMapper.selectMatchOtherZmqNews(map);
        Page<NewsOfOtherZmqWithBLOBs> resultPage = new Page(dateList, countOfNews, pageSize);
        return resultPage;
    }

    /**
     * 根据类别获取政策新闻
     * @param page
     * @param category
     * @return
     */
    @Override
    public Page<PolicyWithBLOBs> queryPolicyNewsByCat(int page, String category) {
        Map map = new HashMap<>();
        int start = (page - 1) * pageSize;
        map.put("cat",category);
        map.put("start", start);
        map.put("size", pageSize);
        int countOfNews = policyMapper.countPolicyByCat(map);
        List<PolicyWithBLOBs> dateList = policyMapper.selectPolicyByCat(map);
        Page<PolicyWithBLOBs> resultPage = new Page(dateList, countOfNews, pageSize);
        return resultPage;
    }

    /**
     * 获取所有政策新闻
     * @param page
     * @param
     * @return
     */
    @Override
    public Page<PolicyWithBLOBs> queryPolicyNews(int page) {
        Map map = new HashMap<>();
        int start = (page - 1) * pageSize;
        map.put("start", start);
        map.put("size", pageSize);
        int countOfNews = policyMapper.countPolicyNews();
        List<PolicyWithBLOBs> dateList = policyMapper.selectPolicyNews(map);
        Page<PolicyWithBLOBs> resultPage = new Page(dateList, countOfNews, pageSize);
        return resultPage;
    }

    /**
     * 条件获取政策新闻
     * @param page
     * @param startDate
     * @param endDate
     * @return
     */
    @Override
    public Page<PolicyWithBLOBs> queryMatchPolicyNews(int page, String startDate, String endDate, String cat) {
        Map map = new HashMap();
        int start = (page - 1) * pageSize;
        map.put("cat", cat);
        map.put("startDate", startDate);
        map.put("endDate", endDate);
        map.put("start", start);
        map.put("size", pageSize);
        int countOfNews = policyMapper.countMatchPolicyNews(map);
        List<PolicyWithBLOBs> dateList = policyMapper.selectMatchPolicyNews(map);
        Page<PolicyWithBLOBs> resultPage = new Page(dateList, countOfNews, pageSize);
        return resultPage;
    }

    /**
     * Negativenews
     * @return
     */
    @Override
    public List<negativenewsWithBLOBs> queryNegativenews() {
        return negativenewsMapper.queryNegativenews();
    }

    /**
     * CurrentNews
     * @return
     */
    @Override
    public List<currentnewsWithBLOBs> queryCurrentnews() {
        return currentnewsMapper.queryCurrentnews();
    }

    @Override
    public List<companyinformation> querycompanyinfo() {
        return companyinformationMapper.queryComInfo();
    }
}
