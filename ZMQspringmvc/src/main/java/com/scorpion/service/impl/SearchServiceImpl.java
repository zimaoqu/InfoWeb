package com.scorpion.service.impl;

import com.scorpion.dao.*;
import com.scorpion.pojo.*;
import com.scorpion.service.SearchService;
import com.scorpion.util.data.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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
    @Autowired
    private democompanyMapper democompanyMapper;
    @Autowired
    private eventnewsMapper eventnewsMapper;
    @Autowired
    private bignewsMapper bignewsMapper;
    @Autowired
    private IndicateOfGDPCountryMapper indicateOfGDPCountryMapper;
    @Autowired
    private IndicateOfGDPSHMapper indicateOfGDPSHMapper;
    @Autowired
    private IndicateOfPPIMapper indicateOfPPIMapper;
    @Autowired
    private IndicateOfCPIMapper indicateOfCPIMapper;
    @Autowired
    private IndicateOfExportImportMapper indicateOfExportImportMapper;
    @Autowired
    private IndicateOfBDIMapper indicateOfBDIMapper;
    @Autowired
    private PmiMapper PmiMapper;
    @Autowired
    private TaxCountryMapper TaxCountryMapper;
    @Autowired
    private  TotalRetailSalesOfConsumerGoodsMapper TotalRetailSalesOfConsumerGoodsMapper;
    @Autowired
    private  copperMapper copperMapper;
    @Autowired
    private  crude_btlMapper crude_btlMapper;
    @Autowired
    private  crude_wtiMapper crude_wtiMapper;
    @Autowired
    private  dollar_exchange_rate_of_rmbMapper dollar_exchange_rate_of_rmbMapper;

    @Autowired
    private  imfMapper imfMapper;
    @Autowired
    private NewsOfIndustryMapper newsOfIndustryMapper;
    @Autowired
    private TopCompanyInfoMapper topCompanyInfoMapper;
    @Autowired
    private TopKeyAttentionMapper topKeyAttentionMapper;
    /*
    The size of a page.
     */
    final static int pageSize = 10;
    final static int pageSizeOfAbnormal = 10;

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
        List<NewsOfTopCompanyWithBLOBs> dateList = newsOfTopCompanyMapper.selectAllNews(map);
        //处理html，含有公司名字变蓝
        for (NewsOfTopCompanyWithBLOBs news : dateList) {
            String html = news.getHtml();
            String name = news.getName();
            Abstract_Cut cut = new Abstract_Cut();//class在后面定义了
            String res_abs = cut.cut_sentence(html, name);
            if (res_abs == null) {
                news.setDescription(news.getDescription());
            } else {
                processStr p = new processStr();
                ArrayList<String> kstr = new ArrayList<String>();
                kstr = p.splitStr(name);
                //多加了个匹配词raw_cor_name也标蓝
                kstr.add(name);
                res_abs = p.addFont_Blue(res_abs, kstr);
                if (news.getDescription().length() > 300)
                    news.setDescription("..." + res_abs + "...");
            }

        }
        Page<NewsOfCompanyWithBLOBs> resultPage = new Page(dateList, countOfNews, pageSize);
        return resultPage;
    }

    /**
     * 获取新闻事件
     *
     * @param companyName
     * @return
     */
    public List<eventnewsWithBLOBs> getEventNews(String companyName, int flag) {
        Map map = new HashMap();
        map.put("relComName", companyName.trim());
        map.put("flag", flag);
        List<eventnewsWithBLOBs> eventnews = eventnewsMapper.getEventNews(map);
        return eventnews;
    }

    public List<String> getComlist() {
        return eventnewsMapper.getComlist();
    }

    ;

    /**
     * 企业历史演变
     *
     * @return
     */
    @Override
    public List<String> getComListHis() {
        return bignewsMapper.getComList();
    }


    @Override
    public List<bignews> getHisEvents(String companyName) {
        Map map = new HashMap();
        map.put("relComName", companyName.trim());
        List<bignews> eventHis = bignewsMapper.getHisEvents(map);
        return eventHis;
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
    public Page<NewsOfCompanyWithBLOBs> queryMatchTopNews(int page, String startDate, String endDate, String key,String industry) {
        Map map = new HashMap<>();
        int start = (page - 1) * pageSize;
        map.put("name", key);
        map.put("startDate", startDate);
        map.put("endDate", endDate);
        map.put("start", start);
        map.put("industry", industry);
        map.put("size", pageSize);
        int countOfNews = newsOfTopCompanyMapper.countMatchNews(map);
        List<NewsOfTopCompanyWithBLOBs> dateList = newsOfTopCompanyMapper.selectMatchNews(map);
        //处理html，含有公司名字变蓝
        for (NewsOfTopCompanyWithBLOBs news : dateList) {
            String html = news.getHtml();
            String name = news.getName();
            Abstract_Cut cut = new Abstract_Cut();//class在后面定义了
            String res_abs = cut.cut_sentence(html, name);
            if (res_abs == null) {
                news.setDescription(news.getDescription());
            } else {
                processStr p = new processStr();
                ArrayList<String> kstr = new ArrayList<String>();
                kstr = p.splitStr(name);
                //多加了个匹配词raw_cor_name也标蓝
                kstr.add(name);
                res_abs = p.addFont_Blue(res_abs, kstr);
                if (news.getDescription().length() > 300)
                    news.setDescription("..." + res_abs + "...");
            }

        }
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
        //处理html，含有公司名字变蓝
        for (NewsOfCompanyWithBLOBs news : dateList) {
            String html = news.getHtml();
            String name = news.getName();
            Abstract_Cut cut = new Abstract_Cut();//class在后面定义了
            String res_abs = cut.cut_sentence(html, name);
            if (res_abs == null) {
                news.setDescription(news.getDescription());
            } else {
                processStr p = new processStr();
                ArrayList<String> kstr = new ArrayList<String>();
                kstr = p.splitStr(name);
                //多加了个匹配词raw_cor_name也标蓝
                kstr.add(name);
                res_abs = p.addFont_Blue(res_abs, kstr);
                if (news.getDescription().length() > 300)
                    news.setDescription("..." + res_abs + "...");
            }

        }
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
        //处理html，含有公司名字变蓝
        for (NewsOfCompanyWithBLOBs news : dateList) {
            String html = news.getHtml();
            String name = news.getName();
            Abstract_Cut cut = new Abstract_Cut();//class在后面定义了
            String res_abs = cut.cut_sentence(html, name);
            if (res_abs == null) {
                news.setDescription(news.getDescription());
            } else {
                processStr p = new processStr();
                ArrayList<String> kstr = new ArrayList<String>();
                kstr = p.splitStr(name);
                //多加了个匹配词raw_cor_name也标蓝
                kstr.add(name);
                res_abs = p.addFont_Blue(res_abs, kstr);
                if (news.getDescription().length() > 300)
                    news.setDescription("..." + res_abs + "...");

            }

        }
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
     *
     * @param page
     * @param category
     * @return
     */
    @Override
    public Page<PolicyWithBLOBs> queryPolicyNewsByCat(int page, String category) {
        Map map = new HashMap<>();
        int start = (page - 1) * pageSize;
        map.put("cat", category);
        map.put("start", start);
        map.put("size", pageSize);
        int countOfNews = policyMapper.countPolicyByCat(map);
        List<PolicyWithBLOBs> dateList = policyMapper.selectPolicyByCat(map);
        Page<PolicyWithBLOBs> resultPage = new Page(dateList, countOfNews, pageSize);
        return resultPage;
    }

    /**
     * 获取所有政策新闻
     *
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
     *
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
     *
     * @return
     */
    @Override
    public List<negativenewsWithBLOBs> queryNegativenews(int page) {
        Map map = new HashMap();
        int start = (page - 1) * pageSizeOfAbnormal;
        map.put("start", start);
        map.put("size", pageSizeOfAbnormal);
        return negativenewsMapper.queryNegativenews(map);
    }

    @Override
    public List<TopKeyAttentionWithBLOBs> queryNewsOfAttKey(int page) {
        Map map = new HashMap();
        int start = (page - 1) * pageSizeOfAbnormal;
        map.put("start", start);
        map.put("size", pageSizeOfAbnormal);
        return topKeyAttentionMapper.queryNewsOfAttKey(map);
    }

    /**
     * CurrentNews
     *
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


    /**
     * 获取oreitationvalue
     *
     * @param companyName
     * @param date1
     * @param date2
     * @return
     */
    @Override
    public List<Double> getQuartervalue(String companyName, String date1, String date2) {
        Map map = new HashMap();
        map.put("companyName", companyName);
        map.put("date1", date1);
        map.put("date2", date2);
        return newsOfCompanyMapper.getQuartervalue(map);
    }

    /**
     * 正面新闻量
     *
     * @param companyName
     * @param date1
     * @param date2
     * @return
     */
    @Override
    public int getPosnum(String companyName, String date1, String date2) {
        Map map = new HashMap();
        map.put("companyName", companyName);
        map.put("date1", date1);
        map.put("date2", date2);
        return newsOfCompanyMapper.getPosnum(map);
    }

    /**
     * 负面新闻量
     *
     * @param companyName
     * @param date1
     * @param date2
     * @return
     */
    @Override
    public int getNegnum(String companyName, String date1, String date2) {
        Map map = new HashMap();
        map.put("companyName", companyName);
        map.put("date1", date1);
        map.put("date2", date2);
        return newsOfCompanyMapper.getNegnum(map);
    }

    /**
     * 所有公司名字
     *
     * @return
     */
    @Override
    public List<String> getComList() {
        return newsOfCompanyMapper.getComList();
    }

    /**
     * 根据公司名字获取所有时间段的正面新闻量
     *
     * @param companyName
     * @return
     */
    @Override
    public int getAllTimePosnums(String companyName) {
        Map map = new HashMap();
        map.put("companyName", companyName);
        return newsOfCompanyMapper.getAllTimePosnum(map);
    }

    /**
     * 根据公司名字获取所有时间段的中立新闻量
     *
     * @param companyName
     * @return
     */
    @Override
    public int getAllTimeNeunums(String companyName) {
        Map map = new HashMap();
        map.put("companyName", companyName);
        return newsOfCompanyMapper.getAllTimeNeunum(map);
    }

    /**
     * 根据公司名字获取所有时间段的负面新闻量
     *
     * @param companyName
     * @return
     */
    @Override
    public int getAllTimeNegnums(String companyName) {
        Map map = new HashMap();
        map.put("companyName", companyName);
        return newsOfCompanyMapper.getAllTimeNegnum(map);
    }

    /**
     * 根据公司名字来获取正面新闻
     *
     * @param companyName
     * @return
     */
    @Override
    public List<NewsOfCompanyWithBLOBs> getPosnews(String companyName) {
        Map map = new HashMap();
        map.put("companyName", companyName);
        return newsOfCompanyMapper.getPosnews(map);
    }

    /**
     * 根据公司名字来获取中立新闻
     *
     * @param companyName
     * @return
     */
    @Override
    public List<NewsOfCompanyWithBLOBs> getNeunews(String companyName) {
        Map map = new HashMap();
        map.put("companyName", companyName);
        return newsOfCompanyMapper.getNeunews(map);
    }

    /**
     * 根据公司名字来获取负面新闻
     *
     * @param companyName
     * @return
     */
    @Override
    public List<NewsOfCompanyWithBLOBs> getNegnews(String companyName) {
        Map map = new HashMap();
        map.put("companyName", companyName);
        return newsOfCompanyMapper.getNegnews(map);
    }

    /**
     * 获取公司完整的名字
     *
     * @param name
     * @return
     */
    @Override
    public String getCompanyName(String name) {
        Map map = new HashMap();
        map.put("companyName", name);
        return newsOfCompanyMapper.getCompanyName(map);
    }

    /**
     * get Curreputation
     *
     * @param companyName
     * @return
     */
    @Override
    public double getCurreputation(String companyName) {
        Map map = new HashMap();
        map.put("companyName", companyName);
        return democompanyMapper.getCurreputation(map);
    }

    @Override
    public List<String> getDemoComList() {
        return democompanyMapper.getComList();
    }

    /**
     * 获取普通新闻对应的关键字
     *
     * @param page
     * @return
     */
    @Override
    public List getComKeywords(int page) {
        Map map = new HashMap<>();
        List keyList = new ArrayList();
        int start = (page - 1) * pageSize;
        map.put("start", start);
        map.put("size", pageSize);
        List<NewsOfCompanyWithBLOBs> dateList = newsOfCompanyMapper.selectAllNews(map);
        for (NewsOfCompanyWithBLOBs news : dateList) {
            if (!news.getKeywords().isEmpty())
                keyList.add(processKeywords(news.getKeywords()));
        }
        return keyList;
    }

    /**
     * 获取上海自贸区新闻的关键字
     *
     * @param page
     * @return
     */
    @Override
    public List getSHZmqKeywords(int page) {
        Map map = new HashMap();
        List keyList = new ArrayList();
        int start = (page - 1) * pageSize;
        map.put("start", start);
        map.put("size", pageSize);
        List<NewsOfSHZmqWithBLOBs> dateList = newsOfSHZmqMapper.selectAllSHZmqNews(map);
        for (NewsOfSHZmqWithBLOBs news : dateList) {
            if (!news.getKeywords().isEmpty())
                keyList.add(processKeywords(news.getKeywords()));
        }
        return keyList;
    }

    /**
     * 获取其他自贸区新闻的关键字
     *
     * @param page
     * @return
     */
    @Override
    public List getOtherZmqKeywords(int page) {
        Map map = new HashMap();
        List keyList = new ArrayList();
        int start = (page - 1) * pageSize;
        map.put("start", start);
        map.put("size", pageSize);
        List<NewsOfOtherZmqWithBLOBs> dateList = newsOfOtherZmqMapper.selectAllOtherZmqNews(map);
        for (NewsOfOtherZmqWithBLOBs news : dateList) {
            if (!news.getKeywords().isEmpty())
                keyList.add(processKeywords(news.getKeywords()));
        }
        return keyList;
    }

    /**
     * 获取普通新闻对应的关键字(时间等匹配条件)
     *
     * @param page
     * @param startDate
     * @param endDate
     * @param key
     * @return
     */
    @Override
    public List getMatchComKeywords(int page, String startDate, String endDate, String key) {
        Map map = new HashMap<>();
        List keyList = new ArrayList();
        int start = (page - 1) * pageSize;
        map.put("name", key);
        map.put("startDate", startDate);
        map.put("endDate", endDate);
        map.put("start", start);
        map.put("size", pageSize);
        List<NewsOfCompanyWithBLOBs> dateList = newsOfCompanyMapper.selectMatchNews(map);
        for (NewsOfCompanyWithBLOBs news : dateList) {
            if (!news.getKeywords().isEmpty())
                keyList.add(processKeywords(news.getKeywords()));
        }
        return keyList;
    }

    /**
     * 根据匹配条件获取上海自贸区新闻的关键词
     *
     * @param page
     * @param startDate
     * @param endDate
     * @return
     */
    @Override
    public List getMatchSHZmqKeywords(int page, String startDate, String endDate) {
        Map map = new HashMap<>();
        List keyList = new ArrayList();
        int start = (page - 1) * pageSize;
        map.put("startDate", startDate);
        map.put("endDate", endDate);
        map.put("start", start);
        map.put("size", pageSize);
        List<NewsOfSHZmqWithBLOBs> dateList = newsOfSHZmqMapper.selectMatchSHZmqNews(map);
        for (NewsOfSHZmqWithBLOBs news : dateList) {
            if (!news.getKeywords().isEmpty())
                keyList.add(processKeywords(news.getKeywords()));
        }
        return keyList;
    }

    /**
     * 根据匹配条件获取其他自贸区新闻的关键词
     *
     * @param page
     * @param startDate
     * @param endDate
     * @param key
     * @return
     */
    @Override
    public List getMatchOtherZmqKeywords(int page, String startDate, String endDate, String key) {
        Map map = new HashMap<>();
        List keyList = new ArrayList();
        int start = (page - 1) * pageSize;
        map.put("name", key);
        map.put("startDate", startDate);
        map.put("endDate", endDate);
        map.put("start", start);
        map.put("size", pageSize);
        List<NewsOfOtherZmqWithBLOBs> dateList = newsOfOtherZmqMapper.selectMatchOtherZmqNews(map);
        for (NewsOfOtherZmqWithBLOBs news : dateList) {
            if (!news.getKeywords().isEmpty())
                keyList.add(processKeywords(news.getKeywords()));
        }
        return keyList;
    }

    /**
     * 获取Top新闻对应的关键字
     *
     * @param page
     * @return
     */
    @Override
    public List getTopComKeywords(int page) {
        Map map = new HashMap<>();
        List TopkeyList = new ArrayList();
        int start = (page - 1) * pageSize;
        map.put("start", start);
        map.put("size", pageSize);
        List<NewsOfTopCompanyWithBLOBs> dateList = newsOfTopCompanyMapper.selectAllNews(map);
        for (NewsOfTopCompanyWithBLOBs news : dateList) {
            if (!news.getKeywords().isEmpty())
                TopkeyList.add(processKeywords(news.getKeywords()));
        }
        return TopkeyList;
    }

    /**
     * 获取Top新闻对应的关键字(时间等匹配条件)
     *
     * @param page
     * @param startDate
     * @param endDate
     * @param key
     * @return
     */
    @Override
    public List getMatchTopComKeywords(int page, String startDate, String endDate, String key, String industry) {
        Map map = new HashMap<>();
        List TopkeyList = new ArrayList();
        int start = (page - 1) * pageSize;
        map.put("name", key);
        map.put("startDate", startDate);
        map.put("endDate", endDate);
        map.put("start", start);
        map.put("industry", industry);
        map.put("size", pageSize);
        List<NewsOfTopCompanyWithBLOBs> dateList = newsOfTopCompanyMapper.selectMatchNews(map);
        for (NewsOfTopCompanyWithBLOBs news : dateList) {
            if (!news.getKeywords().isEmpty())
                TopkeyList.add(processKeywords(news.getKeywords()));
        }
        return TopkeyList;
    }

    /**
     * 获取Top新闻对应的关键字(时间等匹配条件)
     *
     * @param startDate
     * @param endDate
     * @return
     */
    @Override
    public List<ComNameNewsCount> getTopMatchNewsCount(String startDate, String endDate) {
        Map map = new HashMap<>();
        map.put("startDate", startDate);
        map.put("endDate", endDate);
        List<ComNameNewsCount> MatchNewsCount = newsOfTopCompanyMapper.getTopMatchNewsCount(map);
        return MatchNewsCount;
    }

    /**
     * 获取企业新闻对应的关键字(时间等匹配条件)
     *
     * @param startDate
     * @param endDate
     * @return
     */
    @Override
    public List<ComNameNewsCount> getMatchNewsCount(String startDate, String endDate) {
        Map map = new HashMap<>();
        map.put("startDate", startDate);
        map.put("endDate", endDate);
        List<ComNameNewsCount> MatchNewsCount = newsOfCompanyMapper.getMatchNewsCount(map);
        return MatchNewsCount;
    }

    @Override
    public List<ComNameNewsCount> TopNewsCount() {
        return newsOfTopCompanyMapper.TopNewsCount();
    }

    @Override
    public List<ComNameNewsCount> NewsCount() {
        return newsOfCompanyMapper.NewsCount();
    }

    @Override
    public List<ComNameNewsCount> OtherZmqNewsCount() {
        return newsOfOtherZmqMapper.OtherZmqNewsCount();
    }

    @Override
    public List<ComNameNewsCount> getMatchOtherZmqNewsCount(String startDate, String endDate) {
        Map map = new HashMap<>();
        map.put("startDate", startDate);
        map.put("endDate", endDate);
        List<ComNameNewsCount> MatchOtherZmqNewsCount = newsOfOtherZmqMapper.getMatchOtherZmqNewsCount(map);
        return MatchOtherZmqNewsCount;
    }

    /*
    行业数据分析的新闻展示代码
     */
    @Override
    public Page<NewsOfIndustryWithBLOBs> queryAllIndustryNews(int page) {
        Map map = new HashMap<>();
        int countOfNews = newsOfIndustryMapper.countAllNews();
        int start = (page - 1) * pageSize;
        map.put("start", start);
        map.put("size", pageSize);
        List<NewsOfIndustryWithBLOBs> dateList = newsOfIndustryMapper.selectAllNews(map);
        //处理html，含有公司名字变蓝
        for (NewsOfIndustryWithBLOBs news : dateList) {
            String html = news.getHtml();
            String name = news.getName();
            Abstract_Cut cut = new Abstract_Cut();//class在后面定义了
            String res_abs = cut.cut_sentence(html, name);
            if (res_abs == null) {
                news.setDescription(news.getDescription());
            } else {
                processStr p = new processStr();
                ArrayList<String> kstr = new ArrayList<String>();
                kstr = p.splitStr(name);
                //多加了个匹配词raw_cor_name也标蓝
                kstr.add(name);
                res_abs = p.addFont_Blue(res_abs, kstr);
                if (news.getDescription().length() > 300)
                    news.setDescription("..." + res_abs + "...");
            }

        }
        Page<NewsOfIndustryWithBLOBs> resultPage = new Page(dateList, countOfNews, pageSize);
        return resultPage;
    }

    @Override
    public Page<NewsOfIndustryWithBLOBs> queryMatchIndustryNews(int page, String startDate, String endDate,String key) {
        Map map = new HashMap<>();
        int start = (page - 1) * pageSize;
        map.put("name", key);
        map.put("startDate", startDate);
        map.put("endDate", endDate);
        map.put("start", start);
        map.put("size", pageSize);
        int countOfNews = newsOfCompanyMapper.countMatchNews(map);
        List<NewsOfIndustryWithBLOBs> dateList = newsOfIndustryMapper.selectMatchNews(map);
        //处理html，含有公司名字变蓝
        for (NewsOfIndustryWithBLOBs news : dateList) {
            String html = news.getHtml();
            String name = news.getName();
            Abstract_Cut cut = new Abstract_Cut();//class在后面定义了
            String res_abs = cut.cut_sentence(html, name);
            if (res_abs == null) {
                news.setDescription(news.getDescription());
            } else {
                processStr p = new processStr();
                ArrayList<String> kstr = new ArrayList<String>();
                kstr = p.splitStr(name);
                //多加了个匹配词raw_cor_name也标蓝
                kstr.add(name);
                res_abs = p.addFont_Blue(res_abs, kstr);
                if (news.getDescription().length() > 300)
                    news.setDescription("..." + res_abs + "...");

            }

        }
        Page<NewsOfIndustryWithBLOBs> resultPage = new Page(dateList, countOfNews, pageSize);
        return resultPage;
    }

    @Override
    public List getIndustryKeywords(int page) {
        Map map = new HashMap<>();
        List keyList = new ArrayList();
        int start = (page - 1) * pageSize;
        map.put("start", start);
        map.put("size", pageSize);
        List<NewsOfIndustryWithBLOBs> dateList = newsOfIndustryMapper.selectAllNews(map);
        for (NewsOfIndustryWithBLOBs news : dateList) {
            if (!news.getKeywords().isEmpty())
                keyList.add(processKeywords(news.getKeywords()));
        }
        return keyList;
    }

    @Override
    public List getMatchIndustryKeywords(int page, String startDate, String endDate,String key) {
        Map map = new HashMap<>();
        List keyList = new ArrayList();
        int start = (page - 1) * pageSize;
        map.put("name", key);
        map.put("startDate", startDate);
        map.put("endDate", endDate);
        map.put("start", start);
        map.put("size", pageSize);
        List<NewsOfIndustryWithBLOBs> dateList = newsOfIndustryMapper.selectMatchNews(map);
        for (NewsOfIndustryWithBLOBs news : dateList) {
            if (!news.getKeywords().isEmpty())
                keyList.add(processKeywords(news.getKeywords()));
        }
        return keyList;
    }

    @Override
    public List<ComNameNewsCount> IndustryNewsCount() {
        return newsOfIndustryMapper.NewsCount();
    }

    @Override
    public List<ComNameNewsCount> getMatchIndustryNewsCount(String startDate, String endDate) {
        Map map = new HashMap<>();
        map.put("startDate", startDate);
        map.put("endDate", endDate);
        List<ComNameNewsCount> MatchIndustryNewsCount = newsOfIndustryMapper.getMatchNewsCount(map);
        return MatchIndustryNewsCount;
    }






    /**
     *
     * 获取全国GDP指标
     *
     *
     */
    @Override
    public List<IndicateOfGDPCountry> queryAllGDPCountry() {
        List<IndicateOfGDPCountry> GDPCountryList = indicateOfGDPCountryMapper.selectAllGDPCountry();
        return GDPCountryList;
    }

    /**
     *
     * 获取上海地区GDP指标
     *
     *
     */
    @Override
    public List<IndicateOfGDPSH> queryAllGDPSH() {
        List<IndicateOfGDPSH> GDPSHList = indicateOfGDPSHMapper.selectAllGDPSH();
        return GDPSHList;
    }

    /**
     *
     * 获取全国PPI指标
     *
     *
     */
    @Override
    public List<IndicateOfPPI> queryAllPPI() {
        List<IndicateOfPPI> PPIList = indicateOfPPIMapper.selectAllPPI();
        return PPIList;
    }

    /**
     *
     * 获取全国CPI指标
     *
     *
     */
    @Override
    public List<IndicateOfCPI> queryAllCPI() {
        List<IndicateOfCPI> CPIList = indicateOfCPIMapper.selectAllCPI();
        return CPIList;
    }

    /**
     *
     * 获取全国进出口总额指标
     *
     *
     */
    @Override
    public List<IndicateOfExportImport> queryAllExportImport() {
        List<IndicateOfExportImport> ExportImportList = indicateOfExportImportMapper.selectAllExportImport();
        return ExportImportList;
    }

    /**
     *
     * 获取中国BDI指标
     *
     *
     */
    @Override
    public List<IndicateOfBDI> queryAllBDI() {
        List<IndicateOfBDI> BDIList = indicateOfBDIMapper.selectAllBDI();
        return BDIList;
    }
    /*
 获取pmi
 * */
    public List<Pmi> queryAllPmi(){
        List<Pmi> pmiList=PmiMapper.selectAllPMI();
        return pmiList;
    }
    /*
     获取全国税收Pmi数据
 * */
    public  List<TaxCountry> queryAllTaxCountry(){
        List<TaxCountry> taxCountrieyList=TaxCountryMapper.selectAllTaxCountry();
        return taxCountrieyList;
    }

    /*
            获区社会消费品零售总额
     */
    public List<TotalRetailSalesOfConsumerGoods> queryAllTRSC(){
        List<TotalRetailSalesOfConsumerGoods> trsc=TotalRetailSalesOfConsumerGoodsMapper.selectAllTRSC();
        return  trsc;
    }


    /*
      获取铜价格数据
  * */
    public List<copper> queryAllcopper(){
        List<copper> coppers = copperMapper.selectAllCopper();
        return  coppers;
    }

    /*
      获取布伦特原油价格数据
  * */
    public List<crude_btl> queryAllcrude_btl(){
        List<crude_btl> crude_btls= crude_btlMapper.selectAllCrude_btl();
        return  crude_btls;
    }

    /*
     获取WTI原油价格数据
 * */
    public List<crude_wti> queryAllcrude_wti(){
        List<crude_wti> crude_wtis=crude_wtiMapper.selectAllCrude_wti();
        return  crude_wtis;
    }
    /*
   获取美元人民币汇率
* */
    public List<dollar_exchange_rate_of_rmb> queryAlldollar_exchange_rate_of_rmb(){
        List<dollar_exchange_rate_of_rmb> dollar_exchange_rate_of_rmbs=dollar_exchange_rate_of_rmbMapper.selectAllPdollar_exchange_rate_of_rmb();
        return  dollar_exchange_rate_of_rmbs;
    }

    /**
     * @return
     * 获取imf预测数据
     */
    public List<imf> querryAllimf(){
        List<imf> imfs=imfMapper.selectAllimf();
        return  imfs;
    }

    /*

    /**
     * 处理keywords函数  分割之类的
     *
     * @param keywords
     * @return
     */
    static Map processKeywords(String keywords) {
        Map keywordMap = new HashMap<String, Integer>();

        if (keywords != null) {
            String[] tmp = keywords.split(";");
            for (int i = 0; i < tmp.length; i++) {
                String[] tmp1 = tmp[i].split("/");
                if (tmp1.length == 2) {
                    keywordMap.put(tmp1[0], tmp1[1]);
                }
            }
        }

        return keywordMap;
    }

    /**
     * 获取关键词生成热词云
     *
     * @param companyName
     * @return
     */

    @Override
    public HashMap<String, Integer> getKeywords(String companyName) {
        HashMap<String, Integer> wordcloud = new HashMap<String, Integer>();
        Map map = new HashMap();
        map.put("relComName", companyName.trim());
        List<String> key = currentnewsMapper.getKeywords(map);
        for (String k : key) {
            ArrayList<String> kwl = splitStr(k);
            for (int i = 0; i < kwl.size(); i++) {
                String word = kwl.get(i);
                if (wordcloud.containsKey(word)) {
                    Integer num = wordcloud.get(word);
                    num++;
                    wordcloud.put(word, num);
                } else {
                    wordcloud.put(word, 1);
                }
            }
        }
        return wordcloud;
    }

    /**
     * 统计新闻来源
     *
     * @param companyName
     * @return
     */
    @Override
    public HashMap<String, Integer> getCountSource(String companyName) {
        HashMap<String, Integer> source = new HashMap<String, Integer>();
        Map map = new HashMap();
        map.put("relComName", companyName.trim());
        List<SourceOfNews> sourceres = currentnewsMapper.getCountSource(map);
        int count = 0;
        for (SourceOfNews n : sourceres) {
            String sourcename = n.getSource().trim();
            String sourcenum = Integer.toString(n.getNum());
            if (!sourcename.equals("其他")) {
                source.put(sourcename, Integer.valueOf(sourcenum));
                count++;
            }
            if (count >= 9) {
                break;
            }
        }
        return source;
    }

    /**
     * 获取热点新闻
     *
     * @param companyName
     * @return
     */
    @Override
    public List<currentnewsWithBLOBs> getHotNews(String companyName) {
        Map map = new HashMap();
        map.put("relComName", companyName.trim());
        List<currentnewsWithBLOBs> hotnews = currentnewsMapper.getHotNews(map);
        return hotnews;
    }

    /**
     * 获取敏感新闻
     *
     * @param companyName
     * @return
     */
    @Override
    public List<currentnewsWithBLOBs> getSensiveNews(String companyName) {
        System.out.println("getCountSourceInService:" + companyName);
        Map map = new HashMap();
        map.put("relComName", companyName.trim());
        List<currentnewsWithBLOBs> sensivenews = currentnewsMapper.getSensiveNews(map);
        return sensivenews;
    }

    /**
     * keywords字段处理
     *
     * @param str
     * @return
     */
    @Override
    public ArrayList<String> splitStr(String str) {
        //str="产品/4;召回/3;进行/2;监督/3;";
        ArrayList<String> res = new ArrayList<String>();
        if (str != null) {
            String[] temp = str.split(";");
            for (int i = 0; i < temp.length; i++) {
                String[] temp1 = temp[i].split("/");
                res.add(temp1[0]);//仅保留关键词，不要词频
            }
        }
        return res;
    }

    public List<ComNameNewsCount> CompanyWarningCount() {
        List<ComNameNewsCount> dateNow = negativenewsMapper.ComMonthNewsCount();
        List<ComNameNewsCount> dateBefore = negativenewsMapper.ComMonthBeforeNewsCount();
        List<ComNameNewsCount> warningCom = new ArrayList();
        int n = 0;
        for (int i = 0; i < dateNow.size(); i++) {
            for (int j = 0; j < dateBefore.size(); j++) {
                ComNameNewsCount c = new ComNameNewsCount();
                if (dateNow.get(i).getName().equals(dateBefore.get(j).getName())) {
                    if (dateNow.get(i).getCount() > dateBefore.get(j).getCount() * 2 && dateNow.get(i).getCount() > 0) {
                        c.setCount(dateNow.get(i).getCount());
                        c.setName(dateNow.get(i).getName());
                        warningCom.add(c);
                    }
                }
            }
        }
        return warningCom;
    }

    public List<ComNameNewsCount> CompanyWarningBeforeCount() {
        return negativenewsMapper.ComMonthBeforeNewsCount();
    }
    public List<PredictedandRealistic> CompanyPredictWarning() {
        List<PredictedandRealistic> predicteddata = negativenewsMapper.PredictedRealisticString();
        List<PredictedandRealistic> Warningname  = new ArrayList<>();
        //List<Integer> WarningName = new ArrayList<>();
        //for(int i = 0;i<predicteddata.size();i++)WarningName.set(i,0);
        for(int i = 0;i<predicteddata.size();i++) {
            String predict ="";
//            System.out.print(i+","+predicteddata.size());
//            String arrp3 = predicteddata.get(i).getPredicted();
//            System.out.print(i+","+predicteddata.get(i).getPredicted());
            String[] arrp = predicteddata.get(i).getPredicted().split(";");
            String[] arrr = predicteddata.get(i).getRealistic().split(";");
            String name = predicteddata.get(i).getName().split("=")[1];
            name = name.split("}")[0];
//            for(int p=0;p<arrp.length;p++)
//            System.out.println(arrp[p]);
            double sump=0,sumr=0,avgp=0,avgr=0,variance=0;
            double[] arrp2 =new double[arrp.length];
            double[] arrr2 =new double[arrr.length];
            int j = 0;
            for(j = 0;j<arrp.length;j++) {//平均值
                arrp2[j] = Double.valueOf(arrp[j]);
                arrr2[j] = Double.valueOf(arrr[j]);
                sump += arrp2[j];
                sumr += arrr2[j];
            }
            avgp=sump/arrp.length;avgr=sumr/arrr.length;
            for(j = 0;j<arrp.length;j++){
                arrp2[j] = arrp2[j]*avgr/avgp;//只对趋势评估
                predict += arrp2[j];
                predict += ";";
            }
            for(j = 0;j<arrp.length;j++) {
                variance += (arrp2[j]-arrr2[j])*(arrp2[j]-arrr2[j])*((j+1)/2/arrp.length+1/2);//带权方差
            }
            if(variance/avgp>avgp){
                Warningname.add(predicteddata.get(i));
                Warningname.get(Warningname.size()-1).setPredicted(predict);
                Warningname.get(Warningname.size()-1).setName(name);
            }
        }
        return Warningname;
    }

    @Override
    public List<String> getIndustryList() {
        return topCompanyInfoMapper.getIndustryList();
    }

    @Override
    public List<String> getComOfIndustry(String industry) {
        Map map = new HashMap();
        map.put("hy", industry.trim());
        return topCompanyInfoMapper.getComOfIndustry(map);
    }

    /**
     * 重中之重行业新闻统计
     * @return
     */
    @Override
    public List<IndustryCount> TopNewsIndustryCount() {
        return newsOfTopCompanyMapper.TopNewsIndustryCount();
    }
}

//前面name变蓝用到的
class Abstract_Cut {
    public String cut_sentence(String text, String target) {
        String res = new String();
        int pos = text.indexOf(target);
        if (pos == -1) return null;
        int pos_v = pos;
        while (pos > 0 && text.charAt(pos) != '。') {
            pos--;
        }
        //System.out.println(pos);
        while (pos_v < text.length() && text.charAt(pos_v) != '。') {
            pos_v++;
        }
        //System.out.println(pos_v);
        res = text.substring(pos + 1, pos_v);
        return res;
    }
}

class processStr {
    /**
     * 将str中的关键词加上<font color=\"red\"><\\/font>
     * 使其在网页显示时标红
     *
     * @param str
     * @param keyStr
     * @return
     */
    public String addFont(String str, ArrayList<String> keyStr) {
        for (int i = 0; i < keyStr.size(); i++) {
            String replace = "<font color=\"red\">" + keyStr.get(i) + "<\\/font>";
            Pattern p = Pattern.compile(keyStr.get(i));
            Matcher m = p.matcher(str);
            str = m.replaceAll(replace);
        }
        return str;
    }

    public String addFont_Blue(String str, ArrayList<String> keyStr) {
        for (int i = 0; i < keyStr.size(); i++) {
            String replace = "<font color=\"blue\">" + keyStr.get(i) + "<\\/font>";
            Pattern p = Pattern.compile(keyStr.get(i));
            Matcher m = p.matcher(str);
            str = m.replaceAll(replace);
        }
        return str;
    }

    /**
     * 字符串分割，取出关键词，不要词频及其他，字符串如str="产品/4;召回/3;进行/2;监督/3;";
     * 将关键词保存在ArrayList<String>
     *
     * @param str
     * @return
     */
    public ArrayList<String> splitStr(String str) {
        //str="产品/4;召回/3;进行/2;监督/3;";
        ArrayList<String> res = new ArrayList<String>();
        if (str != null) {
            String[] temp = str.split(";");
            for (int i = 0; i < temp.length; i++) {
                String[] temp1 = temp[i].split("/");
                res.add(temp1[0]);//仅保留关键词，不要词频
            }
        }
        return res;
    }
}
