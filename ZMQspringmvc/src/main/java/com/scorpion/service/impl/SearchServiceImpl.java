package com.scorpion.service.impl;

import com.scorpion.dao.*;
import com.scorpion.pojo.*;
import com.scorpion.service.SearchService;
import com.scorpion.util.data.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;


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
        List<NewsOfTopCompanyWithBLOBs> dateList = newsOfTopCompanyMapper.selectAllNews(map);

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
        List<NewsOfTopCompanyWithBLOBs> dateList = newsOfTopCompanyMapper.selectMatchNews(map);

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
    public List<negativenewsWithBLOBs> queryNegativenews() {
        return negativenewsMapper.queryNegativenews();
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
//        System.out.println(date1);
//        System.out.println(date2);
//        System.out.println(newsOfCompanyMapper.getQuartervalue(map).size());
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
     * <<<<<<< HEAD
     * <p>
     * =======
     * >>>>>>> c05355fbfbb0e385faf017182ea9d683f9e543ea
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
     * <<<<<<< HEAD
     * <p>
     * =======
     * >>>>>>> c05355fbfbb0e385faf017182ea9d683f9e543ea
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
     * <<<<<<< HEAD
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
    public List getMatchTopComKeywords(int page, String startDate, String endDate, String key) {
        Map map = new HashMap<>();
        List TopkeyList = new ArrayList();
        int start = (page - 1) * pageSize;
        map.put("name", key);
        map.put("startDate", startDate);
        map.put("endDate", endDate);
        map.put("start", start);
        map.put("size", pageSize);
        List<NewsOfTopCompanyWithBLOBs> dateList = newsOfTopCompanyMapper.selectMatchNews(map);
        for (NewsOfTopCompanyWithBLOBs news : dateList) {
            if (!news.getKeywords().isEmpty())
                TopkeyList.add(processKeywords(news.getKeywords()));
        }
        return TopkeyList;
    }


    /**
     * 处理keywords函数  分割之类的
     *
     * @param keywords
     * @return
     */
    static Map processKeywords(String keywords) {
        Map keywordMap = new HashMap<String, Integer>();

        String[] tmp = keywords.split(";");
        for (int i = 0; i < tmp.length; i++) {
            String[] tmp1 = tmp[i].split("/");
            keywordMap.put(tmp1[0], tmp1[1]);
        }
        return keywordMap;
    }

    /**
     * 获取关键词生成热词云
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
}
