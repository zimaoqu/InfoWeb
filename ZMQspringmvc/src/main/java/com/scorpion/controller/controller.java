package com.scorpion.controller;


import com.scorpion.pojo.*;
import com.scorpion.service.SearchService;
import com.scorpion.util.data.Page;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.*;


/**
 * Created by Scorpion on 2017/4/19.
 */
@Controller
@RequestMapping("/zmq")
public class controller {

    @Autowired
    private SearchService searchService;

    /**
     * 展示Home.jsp
     *
     * @return
     */
    @RequestMapping("showHome")
    public ModelAndView showHome() {
        return new ModelAndView("home");
    }


    /**
     * 跳转到重点企业新闻的界面
     *
     * @return
     */
    @RequestMapping("showTopCompanyNews")
    public ModelAndView showTopCompanyNews(ModelMap modelMap) {
        String industry = "";
        //行业选择下拉列表
        List<String> companyList = searchService.getIndustryList();
        industry = "<option>" + " " + "</option>";
        for (int i = 0; i < companyList.size(); i++) {
            industry = industry + "<option>" + companyList.get(i) + "</option>";
        }
        modelMap.put("industry", industry);
        return new ModelAndView("TopCompanyNews", modelMap);
    }

    /**
     * 跳转到根据时间、企业名称条件查询的重点企业新闻的界面
     *
     * @return
     */
    @RequestMapping("showTopMatchResult")
    public ModelAndView showTopMatchResult(String startDate, String endDate, String key, String industry, ModelMap modelMap) {
        String industryList = "";
        //行业选择下拉列表
        List<String> companyList = searchService.getIndustryList();
        industryList = "<option>" + industry + "</option>";
        for (int i = 0; i < companyList.size(); i++) {
            industryList = industryList + "<option>" + companyList.get(i) + "</option>";
        }
        modelMap.put("industry", industry);
        modelMap.addAttribute("startDate", startDate);
        modelMap.addAttribute("endDate", endDate);
        modelMap.addAttribute("key", key);
        modelMap.addAttribute("industryList", industryList);
        return new ModelAndView("TopMatchResult", modelMap);
    }

    /**
     * 跳转到企业新闻的界面
     *
     * @return
     */
    @RequestMapping("showCompanyNews")
    public ModelAndView showCompanyNews() {
        return new ModelAndView("CompanyNews");
    }

    /**
     * 跳转到根据时间、企业名称条件查询的企业新闻的界面
     */
    @RequestMapping("showMatchResult")
    public ModelAndView showMatchResult(String startDate, String endDate, String key, ModelMap modelMap) {
        modelMap.addAttribute("startDate", startDate);
        modelMap.addAttribute("endDate", endDate);
        modelMap.addAttribute("key", key);
        return new ModelAndView("MatchResult", modelMap);
    }

    /**
     * 跳转到自贸区政策的页面
     *
     * @return
     */
    @RequestMapping("showZmqPolicy")
    public ModelAndView showZmqPolicy() {
        return new ModelAndView("ZmqPolicy");
    }

    /**
     * 跳转到上海自贸区新闻的界面
     *
     * @return
     */
    @RequestMapping("showSHZmqNews")
    public ModelAndView showSHZmqNews() {
        return new ModelAndView("SHZmqNews");
    }

    /**
     * 跳转到其他自贸区新闻
     *
     * @return
     */
    @RequestMapping("showOtherZmqNews")
    public ModelAndView showOtherZmqNews() {
        return new ModelAndView("OtherZmqNews");
    }

    /**
     * 跳转到根据时间条件查询的上海自贸区新闻的界面
     */
    @RequestMapping("showMatchSHZmqResult")
    public ModelAndView showMatchSHZmqResult(String startDate, String endDate, ModelMap modelMap) {
        modelMap.addAttribute("startDate", startDate);
        modelMap.addAttribute("endDate", endDate);
        return new ModelAndView("MatchSHZmqResult", modelMap);
    }

    /**
     * 跳转到根据时间、名称条件查询的其他自贸区新闻的界面
     */
    @RequestMapping("showMatchOtherZmqResult")
    public ModelAndView showMatchOtherZmqResult(String startDate, String endDate, String key, ModelMap modelMap) {
        modelMap.addAttribute("startDate", startDate);
        modelMap.addAttribute("endDate", endDate);
        modelMap.addAttribute("key", key);
        return new ModelAndView("MatchOtherZmqResult", modelMap);
    }

    /**
     * 上海自贸区舆情评价
     *
     * @return
     */
    @RequestMapping("showSHZmqPublicOpinionEvaluation")
    public ModelAndView showSHZmqPublicOpinionEvaluation() {
        return new ModelAndView("SHZmqPublicOpinionEvaluation");
    }

    /**
     * 上海自贸区健康态势
     *
     * @return
     */
    @RequestMapping("showSHZmqHealthTendency")
    public ModelAndView showSHZmqHealthTendency() {
        return new ModelAndView("SHZmqHealthTendency");
    }

    /**
     * 自贸区对比
     *
     * @return
     */
    @RequestMapping("showZmqCompare")
    public ModelAndView showZmqCompare() {
        return new ModelAndView("ZmqCompare");
    }

    /**
     * 企业事件分析界面
     *
     * @return
     */
    @RequestMapping("showEventRelationship")
    public ModelAndView showEventRelationship(ModelMap modelMap, HttpServletRequest request) {

        String companyName = (request.getParameter("com") != null) ? request.getParameter("com") : "捷豹路虎汽车贸易（上海）有限公司";
        String temp = (request.getParameter("flag") != null) ? request.getParameter("flag") : "1";

        int flag = Integer.parseInt(temp);

        String selectdiscomsstr = "";
        List<eventnewsWithBLOBs> Eventnews = new ArrayList<eventnewsWithBLOBs>();
        Eventnews = searchService.getEventNews(companyName, flag);

        //企业选择下拉列表
        List<String> companyList = searchService.getComlist();
        selectdiscomsstr = "<option>" + companyName + "</option>";
        for (int i = 0; i < companyList.size(); i++) {
            selectdiscomsstr = selectdiscomsstr + "<option>" + companyList.get(i) + "</option>";
        }

        modelMap.put("maincom", companyName);
        modelMap.put("eventnews", Eventnews);
        modelMap.put("selectdiscomsstr", selectdiscomsstr);
        return new ModelAndView("EventRelationship", modelMap);
    }

    /**
     * 企业历史演变（孙鑫）
     *
     * @param modelMap
     * @param request
     * @return
     */
    @RequestMapping("showHistoricalEvolution")
    public ModelAndView showHistoricalEvolution(ModelMap modelMap, HttpServletRequest request) {
        String companyName = (request.getParameter("com") != null) ? request.getParameter("com") : "捷豹路虎（中国）投资有限公司";
        String selectdiscomsstr = "";
        List<bignews> eventsHis = searchService.getHisEvents(companyName);
        //企业选择下拉列表
        List<String> companyList = searchService.getComListHis();
        selectdiscomsstr = "<option>" + companyName + "</option>";
        for (int i = 0; i < companyList.size(); i++) {
            selectdiscomsstr = selectdiscomsstr + "<option>" + companyList.get(i) + "</option>";
        }

        modelMap.put("maincom", companyName);
        modelMap.put("eventnews", eventsHis);
        modelMap.put("selectdiscomsstr", selectdiscomsstr);
        return new ModelAndView("HistoricalEvolution", modelMap);
    }


    /**
     * 第三方数据
     *
     * @return
     */
    @RequestMapping("showThirdPartyData")
    public ModelAndView showThirdPartyData() {
        return new ModelAndView("ThirdPartyData");
    }

    /**
     * 潜在关系
     *
     * @return
     */
    @RequestMapping("showPotentialRelationship")
    public ModelAndView showPotentialRelationship() {
        return new ModelAndView("PotentialRelationship");
    }

    /**
     * 企业关系
     *
     * @return
     */
    @RequestMapping("showCompanyRelationship")
    public ModelAndView showCompanyRelationship() {
        return new ModelAndView("CompanyRelationship");
    }

    @RequestMapping("showCompanyRelationship_last_month")
    public ModelAndView showCompanyRelationship_last_month() {
        return new ModelAndView("CompanyRelationship_last_month");
    }

    @RequestMapping("showCompanyRelationship_last_season")
    public ModelAndView showCompanyRelationship_last_season() {
        return new ModelAndView("CompanyRelationship_last_season");
    }

    @RequestMapping("showCompanyRelationship_last_half_year")
    public ModelAndView showCompanyRelationship_last_half_year() {
        return new ModelAndView("CompanyRelationship_last_half_year");
    }

    @RequestMapping("showPolicyNews")
    public ModelAndView showPolicyNews() {
        return new ModelAndView("PolicyNews");
    }


    /**
     * 返回企业预警页面
     *
     * @param modelMap
     * @return
     */
    @RequestMapping("showAbnormalWarning")
    public ModelAndView showAbnormalWarning(ModelMap modelMap) {
        List<currentnewsWithBLOBs> queryCurNews = searchService.queryCurrentnews();
        List<companyinformation> queryComInfo = searchService.querycompanyinfo();
        List<ComNameNewsCount> warningCount = searchService.CompanyWarningCount();
        List<ComNameNewsCount> warningBeforeCount = searchService.CompanyWarningBeforeCount();
        List<Integer> BeforeCount = new ArrayList<>();
        for (int i = 0; i < warningCount.size(); i++) {
            for (int j = 0; j < warningBeforeCount.size(); j++)
                if (warningCount.get(i).getName().equals(warningBeforeCount.get(j).getName())) {
                    BeforeCount.add(warningBeforeCount.get(j).getCount());
                }
        }
        modelMap.put("queryCurNews", queryCurNews);
        modelMap.put("queryComInfo", queryComInfo);
        modelMap.put("warningCount", warningCount);
        modelMap.put("BeforeCount", BeforeCount);
        return new ModelAndView("AbnormalWarning", modelMap);
    }

    /**
     * ajax获取abnormalwarning
     *
     * @param response
     * @param page     ZCH edit at 2017.10.04
     */
    @ResponseBody
    @RequestMapping("queryAbnormalWarning")
    public void queryAbnormalWarning(HttpServletResponse response, String page) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        int pageNo = page == null ? 1 : Integer.parseInt(page);
        List<negativenewsWithBLOBs> queryNegNews = searchService.queryNegativenews(pageNo);
        List<TopKeyAttentionWithBLOBs> attentionKey = searchService.queryNewsOfAttKey(pageNo);
        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();
        json.put("abnormalwarning", queryNegNews);
        json.put("attentionKey", attentionKey);
        out.print(json);
    }

    /**
     * 企业预警（张翔）
     *
     * @param modelMap
     * @param request
     * @return
     */
    @RequestMapping("showAbnomalComWarning")
    public ModelAndView AbnomalComWarnin(ModelMap modelMap, HttpServletRequest request) {

//        String selectdiscomsstr = "";
//        List<bignews> eventsHis = searchService.getHisEvents(companyName);
//        //企业选择下拉列表
//        List<String> companyList = searchService.getComListHis();

        List<PredictedandRealistic> WarningCom = searchService.CompanyPredictWarning();
        List<Double> pre = new ArrayList<>();
        List<Double> rea = new ArrayList<>();
        List<List<Double>> predicteddata = new ArrayList<>();
        List<List<Double>> realisticdata = new ArrayList<>();
        List<String> WarningName = new ArrayList<>();
        String companyName = (request.getParameter("com") != null) ? request.getParameter("com") : WarningCom.get(0).getName();
//        System.out.println(companyName);
        for (int i = 0; i < WarningCom.size(); i++) {
            String[] arrp = WarningCom.get(i).getPredicted().split(";");
            String[] arrr = WarningCom.get(i).getRealistic().split(";");
            pre = new ArrayList<>();
            rea = new ArrayList<>();
            for (int j = 0; j < arrp.length; j++) {
                pre.add(Double.valueOf(arrp[j]));
                rea.add(Double.valueOf(arrr[j]));
            }
            predicteddata.add(pre);
            realisticdata.add(rea);
            WarningName.add(WarningCom.get(i).getName());
            for (int j = 0; j < WarningName.size(); j++) {
                if (WarningName.get(j).equals(companyName)) {
                    pre = predicteddata.get(j);
                    rea = realisticdata.get(j);
                }
            }
        }

        modelMap.put("predictedData", pre);
        modelMap.put("realisticData", rea);
        modelMap.put("warningName", WarningName);
        modelMap.put("mainCom", companyName);

//        modelMap.put("maincom", companyName);
//        modelMap.put("eventnews", eventsHis);
//        modelMap.put("selectdiscomsstr", selectdiscomsstr);
        return new ModelAndView("AbnomalComWarning", modelMap);
    }

    /**
     * 企业健康态势
     *
     * @param request
     * @return
     */
    //之前的取法，很慢，下面的新方法暂时性解决这个问题
    /*@RequestMapping("showComHealthTendencyTest")
    public ModelAndView showComHealthTendencyTest(ModelMap modelMap, HttpServletRequest request) {
        String companyName = (request.getParameter("com") != null) ? request.getParameter("com") : "上海三星半导体有限公司";
        String timeGap = (request.getParameter("by") != null) ? request.getParameter("by") : "month";
        int[] posnum = new int[100];
        int[] negnum = new int[100];
        DecimalFormat df = new DecimalFormat("#.##");
        double[] healthvalue = new double[100];
        String selectdiscomsstr = "";
        int igap = 0;
        if (timeGap.equals("quarter")) {
            igap = 3;
        } else if (timeGap.equals("month")) {
            igap = 1;
        }
        int counti = 0;
        for (int year = 2014; year <= 2016; year++) {
            for (int i = 1; i <= 11; i = i + igap) {
                String date1 = Integer.toString(year) + "-" + Integer.toString(i) + "-" + "1";
                String date2 = Integer.toString(year) + "-" + Integer.toString(i + igap) + "-" + "1";
                double sum = 0.0;
                List<Double> quartervalue = searchService.getQuartervalue(companyName, date1, date2);
                for (int j = 0; j < quartervalue.size(); j++) {
                    if (quartervalue.get(j) != null)
                        sum += quartervalue.get(j);
                }
                healthvalue[counti] = Double.parseDouble(df.format(sum));
                posnum[counti] = searchService.getPosnum(companyName, date1, date2);
                negnum[counti] = searchService.getNegnum(companyName, date1, date2);
                counti++;
            }
        }
        //企业选择下拉列表
        List<String> companyList = searchService.getComList();
        for (int i = 0; i < companyList.size(); i++) {
            selectdiscomsstr = selectdiscomsstr + "<option>" + companyList.get(i) + "</option>";
        }
        modelMap.put("maincompany", companyName);
        modelMap.put("mainby", timeGap);
        modelMap.put("healthvalue", healthvalue);
        modelMap.put("maincompany", companyName);
        modelMap.put("posnum", posnum);
        modelMap.put("negnum", negnum);
        modelMap.put("selectdiscomsstr", selectdiscomsstr);
        return new ModelAndView("ComHealthTendency", modelMap);
    }*/

    //改进企业健康态势
    @RequestMapping("showComHealthTendency")
    public ModelAndView showComHealthTendency(ModelMap modelMap, HttpServletRequest request) {
        String companyName = (request.getParameter("com") != null) ? request.getParameter("com") : "上海三星半导体有限公司";
        String timeGap = (request.getParameter("by") != null) ? request.getParameter("by") : "month";
        int[] posnum = new int[100];
        int[] negnum = new int[100];
        double[] healthvalue = new double[100];
        String selectdiscomsstr = "";
        //企业选择下拉列表
        List<String> companyList = searchService.getComList();
        for (int i = 0; i < companyList.size(); i++) {
            selectdiscomsstr = selectdiscomsstr + "<option>" + companyList.get(i) + "</option>";
        }
        String posString = searchService.getPosNumString(companyName, timeGap);
        String negString = searchService.getNegNumString(companyName, timeGap);
        String healthString = searchService.getHealthValueString(companyName, timeGap);
        String[] a = posString.split(",");
        String[] b = negString.split(",");
        String[] c = healthString.split(",");
        for (int i = 0; i < a.length; i++)
            posnum[i] = new Integer(a[i]);
        for (int i = 0; i < b.length; i++)
            negnum[i] = new Integer(b[i]);
        for (int i = 0; i < c.length; i++)
            healthvalue[i] = new Double(c[i]);
        modelMap.put("maincompany", companyName);
        modelMap.put("mainby", timeGap);
        modelMap.put("healthvalue", healthvalue);
        modelMap.put("maincompany", companyName);
        modelMap.put("posnum", posnum);
        modelMap.put("negnum", negnum);
        modelMap.put("selectdiscomsstr", selectdiscomsstr);
        return new ModelAndView("ComHealthTendency", modelMap);
    }

    /**
     * 企业舆情评价
     *
     * @param request
     * @return
     */
    @RequestMapping("showComPublicOpinionEvaluation")
    public ModelAndView showComPublicOpinionEvaluation(ModelMap modelMap, HttpServletRequest request) {

        String companyName = (request.getParameter("com") != null) ? request.getParameter("com") : "上海三星半导体有限公司";

        String selectdiscomsstr = "";
        String completename = searchService.getCompanyName(companyName);
        HashMap<String, Integer> wordcloud = new HashMap<String, Integer>();
        HashMap<String, Integer> source = new HashMap<String, Integer>();
        List<currentnewsWithBLOBs> hotnews = new ArrayList<currentnewsWithBLOBs>();
        List<currentnewsWithBLOBs> sensivenews = new ArrayList<currentnewsWithBLOBs>();

        //热词提取
        wordcloud = searchService.getKeywords(companyName);

        //新闻来源统计
        source = searchService.getCountSource(companyName);

        //热点新闻获取
        hotnews = searchService.getHotNews(companyName);

        //敏感新闻获取
        sensivenews = searchService.getSensiveNews(companyName);

        //企业选择下拉列表
        List<String> companyList = searchService.getComList();
        selectdiscomsstr = "<option>" + companyName + "</option>";
        for (int i = 0; i < companyList.size(); i++) {
            selectdiscomsstr = selectdiscomsstr + "<option>" + companyList.get(i) + "</option>";
        }

        modelMap.put("wordcloud", wordcloud);
        modelMap.put("source", source);
        modelMap.put("hotnews", hotnews);
        modelMap.put("sensivenews", sensivenews);
        modelMap.put("maincom", companyName);
        modelMap.put("selectdiscomsstr", selectdiscomsstr);
        return new ModelAndView("ComPublicOpinionEvaluation", modelMap);
    }


    /**
     * 企业声誉分析
     *
     * @param modelMap
     * @return
     */
    @RequestMapping("showComReputationAnalysis")
    public ModelAndView showComReputationAnalysis(ModelMap modelMap) {
        List<CompanyInfo> comInfo = new ArrayList();
        List<String> companyList = searchService.getTopComList();
        for (String companyName : companyList) {
            double sumreputation = 0.0;
            double sumhealth = 0.0;
            CompanyInfo c = new CompanyInfo();
            c.setName(companyName);
            List<String> demolist = searchService.getDemoComList();
            if (demolist.contains(companyName) && searchService.getComHealthList().contains(companyName)) {
                sumreputation = searchService.getCurreputation(companyName);
                sumhealth = searchService.getHealthValue(companyName);
                if ((sumreputation != 0) || (sumhealth != 0)){
                    c.setReputation(sumreputation);
                    c.setHealth(sumhealth);
                    comInfo.add(c);
                }

            }
            /*List<Double> quartervalue = searchService.getQuartervalue(companyName, "2016-11-1", "2016-12-1");
            for (int j = 0; j < quartervalue.size(); j++) {
                if (quartervalue.get(j) != null)
                    sumhealth += quartervalue.get(j);
            }*/

        }
        modelMap.put("comInfo", comInfo);
        return new ModelAndView("ComReputationAnalysis", modelMap);
    }

    /**
     * Ajax获取重点企业新闻列表
     *
     * @param response
     * @param page
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping("queryTopCompanyNews")
    public void queryTopCompanyNews(HttpServletResponse response, String page) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        int pageNo = page == null ? 1 : Integer.parseInt(page);
        List keywords = searchService.getTopComKeywords(pageNo);
        Page<NewsOfCompanyWithBLOBs> resultPage = searchService.queryAllTopNews(pageNo);
        List<NewsOfCompanyWithBLOBs> resultList = resultPage.getContent();
        List<ComNameNewsCount> newsCount = searchService.TopNewsCount();//调用新闻量类

        List<IndustryCount> topIndustryCounts = searchService.TopNewsIndustryCount();//行业新闻量
        List<String> industryList = new ArrayList<>();
        List<Integer> countList = new ArrayList<>();
        for (IndustryCount industryCount : topIndustryCounts) {
            industryList.add(industryCount.getIndustry());
            countList.add(industryCount.getCount());
        }
        List<String> nameList = new ArrayList<>();
        List<Integer> numList = new ArrayList<>();
        for (ComNameNewsCount instance : newsCount) {
            nameList.add(instance.getName());
            numList.add(instance.getCount());
        }
        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();
        json.put("resultList", resultList);
        json.put("totalRecords", resultPage.getTotalRecords());
        json.put("totalPages", resultPage.getTotalPages());
        json.put("nameList", nameList);
        json.put("numList", numList);
        json.put("industryList", industryList);
        json.put("countList", countList);
        json.put("keywords", keywords);
        out.print(json);
    }

    /**
     * 根据起止时间以及企业名称来搜索重点新闻
     *
     * @param response
     * @param page
     * @param startDate
     * @param endDate
     * @param key
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping("matchTopCompanyNews")
    public void matchTopCompanyNews(HttpServletResponse response, String page, String startDate, String endDate, String key, String industry) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        int pageNo = page == null ? 1 : Integer.parseInt(page);
        if (startDate == "") {
            startDate = "1990-01-01";
        }
        if (endDate == "")
            endDate = "2020-12-31";
        List keywords = searchService.getMatchTopComKeywords(pageNo, startDate, endDate, key, industry);
        Page<NewsOfCompanyWithBLOBs> resultPage = searchService.queryMatchTopNews(pageNo, startDate, endDate, key, industry);
        List<ComNameNewsCount> MatchNewsCount = searchService.getTopMatchNewsCount(startDate, endDate);
        //行业新闻量统计
        List<IndustryCount> topIndustryCounts = searchService.TopNewsIndustryCount();//行业新闻量
        List<String> industryList = new ArrayList<>();
        List<Integer> countList = new ArrayList<>();
        for (IndustryCount industryCount : topIndustryCounts) {
            industryList.add(industryCount.getIndustry());
            countList.add(industryCount.getCount());
        }
        List<String> nameList = new ArrayList<>();
        List<Integer> numList = new ArrayList<>();
        for (ComNameNewsCount instance : MatchNewsCount) {
            nameList.add(instance.getName());
            numList.add(instance.getCount());
        }
        List<NewsOfCompanyWithBLOBs> resultList = resultPage.getContent();
        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();
        json.put("resultList", resultList);
        json.put("totalRecords", resultPage.getTotalRecords());
        json.put("totalPages", resultPage.getTotalPages());
        json.put("keywords", keywords);
        json.put("nameList", nameList);
        json.put("industryList", industryList);
        json.put("countList", countList);
        json.put("numList", numList);
        out.print(json);
    }

    /**
     * Ajax获取企业新闻列表
     *
     * @param response
     * @param page
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping("queryCompanyNews")
    public void queryCompanyNews(HttpServletResponse response, String page) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        int pageNo = page == null ? 1 : Integer.parseInt(page);
        List keywords = searchService.getComKeywords(pageNo);
        Page<NewsOfCompanyWithBLOBs> resultPage = searchService.queryAllNews(pageNo);
        List<NewsOfCompanyWithBLOBs> resultList = resultPage.getContent();
        List<ComNameNewsCount> newsCount = searchService.NewsCount();//调用新闻量类
        List<String> nameList = new ArrayList<>();
        List<Integer> numList = new ArrayList<>();
        for (ComNameNewsCount instance : newsCount) {
            nameList.add(instance.getName());
            numList.add(instance.getCount());
        }
        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();
        json.put("resultList", resultList);
        json.put("totalRecords", resultPage.getTotalRecords());
        json.put("totalPages", resultPage.getTotalPages());
        json.put("keywords", keywords);
        json.put("nameList", nameList);
        json.put("numList", numList);
        out.print(json);
    }

    /**
     * 根据起止时间以及企业名称来搜索新闻
     *
     * @param response
     * @param page
     * @param startDate
     * @param endDate
     * @param key
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping("matchCompanyNews")
    public void matchCompanyNews(HttpServletResponse response, String page, String startDate, String endDate, String key) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        int pageNo = page == null ? 1 : Integer.parseInt(page);
        if (key == null)
            key = "";
        List keywords = searchService.getMatchComKeywords(pageNo, startDate, endDate, key);
        Page<NewsOfCompanyWithBLOBs> resultPage = searchService.queryMatchNews(pageNo, startDate, endDate, key);
        List<NewsOfCompanyWithBLOBs> resultList = resultPage.getContent();
        List<ComNameNewsCount> MatchNewsCount = searchService.getMatchNewsCount(startDate, endDate);
        List<String> nameList = new ArrayList<>();
        List<Integer> numList = new ArrayList<>();
        for (ComNameNewsCount instance : MatchNewsCount) {
            nameList.add(instance.getName());
            numList.add(instance.getCount());
        }
        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();
        json.put("resultList", resultList);
        json.put("totalRecords", resultPage.getTotalRecords());
        json.put("totalPages", resultPage.getTotalPages());
        json.put("nameList", nameList);
        json.put("numList", numList);
        json.put("keywords", keywords);

        out.print(json);
    }

    /**
     * 自贸区政策
     *
     * @param response
     * @param page
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping("queryZmqPolicy")
    public void queryZmqPolicy(HttpServletResponse response, String page) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        int pageNo = page == null ? 1 : Integer.parseInt(page);
        Page<PolicyOfZmqWithBLOBs> resultPage = searchService.queryAllPolicy(pageNo);
        List<PolicyOfZmqWithBLOBs> resultList = resultPage.getContent();
        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();
        json.put("resultList", resultList);
        json.put("totalRecords", resultPage.getTotalRecords());
        json.put("totalPages", resultPage.getTotalPages());
        out.print(json);
    }

    @ResponseBody
    @RequestMapping("querySHZmqNews")
    public void querySHZmqNews(HttpServletResponse response, String page) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        int pageNo = page == null ? 1 : Integer.parseInt(page);
        List keywords = searchService.getSHZmqKeywords(pageNo);
        Page<NewsOfSHZmqWithBLOBs> resultPage = searchService.queryAllSHZmqNews(pageNo);
        List<NewsOfSHZmqWithBLOBs> resultList = resultPage.getContent();
        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();
        json.put("resultList", resultList);
        json.put("totalRecords", resultPage.getTotalRecords());
        json.put("totalPages", resultPage.getTotalPages());
        json.put("keywords", keywords);
        out.print(json);
    }

    /**
     * 返回其他自贸区所有新闻
     *
     * @param response
     * @param page
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping("queryOtherZmqNews")
    public void queryOtherZmqNews(HttpServletResponse response, String page) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        int pageNo = page == null ? 1 : Integer.parseInt(page);
        List keywords = searchService.getOtherZmqKeywords(pageNo);
        Page<NewsOfOtherZmqWithBLOBs> resultPage = searchService.queryAllOtherZmqNews(pageNo);
        List<NewsOfOtherZmqWithBLOBs> resultList = resultPage.getContent();
        List<ComNameNewsCount> newsCount = searchService.OtherZmqNewsCount();//调用新闻量类
        List<String> nameList = new ArrayList<>();
        List<Integer> numList = new ArrayList<>();
        for (ComNameNewsCount instance : newsCount) {
            nameList.add(instance.getName());
            numList.add(instance.getCount());
        }
        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();
        json.put("resultList", resultList);
        json.put("totalRecords", resultPage.getTotalRecords());
        json.put("totalPages", resultPage.getTotalPages());
        json.put("keywords", keywords);
        json.put("nameList", nameList);
        json.put("numList", numList);
        out.print(json);
    }

    /**
     * 返回匹配得到的上海自贸区新闻
     *
     * @param response
     * @param page
     * @param startDate
     * @param endDate
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping("matchSHZmqNews")
    public void matchSHZmqNews(HttpServletResponse response, String page, String startDate, String endDate) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        int pageNo = page == null ? 1 : Integer.parseInt(page);
        List keywords = searchService.getMatchSHZmqKeywords(pageNo, startDate, endDate);
        Page<NewsOfSHZmqWithBLOBs> resultPage = searchService.queryMatchSHZmqNews(pageNo, startDate, endDate);
        List<NewsOfSHZmqWithBLOBs> resultList = resultPage.getContent();
        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();
        json.put("resultList", resultList);
        json.put("totalRecords", resultPage.getTotalRecords());
        json.put("totalPages", resultPage.getTotalPages());
        json.put("keywords", keywords);
        out.print(json);
    }

    /**
     * 返回匹配得到的其他自贸区新闻
     *
     * @param response
     * @param page
     * @param startDate
     * @param endDate
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping("matchOtherZmqNews")
    public void matchOtherZmqNews(HttpServletResponse response, String page, String startDate, String endDate, String key) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        int pageNo = page == null ? 1 : Integer.parseInt(page);
        List keywords = searchService.getMatchOtherZmqKeywords(pageNo, startDate, endDate, key);
        Page<NewsOfOtherZmqWithBLOBs> resultPage = searchService.queryMatchOtherZmqNews(pageNo, startDate, endDate, key);
        List<NewsOfOtherZmqWithBLOBs> resultList = resultPage.getContent();
        List<ComNameNewsCount> MatchNewsCount = searchService.getMatchNewsCount(startDate, endDate);
        List<String> nameList = new ArrayList<>();
        List<Integer> numList = new ArrayList<>();
        for (ComNameNewsCount instance : MatchNewsCount) {
            nameList.add(instance.getName());
            numList.add(instance.getCount());
        }

        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();
        json.put("resultList", resultList);
        json.put("totalRecords", resultPage.getTotalRecords());
        json.put("totalPages", resultPage.getTotalPages());
        json.put("keywords", keywords);
        json.put("nameList", nameList);
        json.put("numList", numList);
        out.print(json);
    }


    /**
     * 分类获取政策新闻
     *
     * @param response
     * @param cat
     * @param page
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping("queryPolicyNewsByCat")
    public void queryPolicyNewsByCat(HttpServletResponse response, String cat, String page) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        int pageNo = page == null ? 1 : Integer.parseInt(page);
        String category = cat;
        Page<PolicyWithBLOBs> resultPage = searchService.queryPolicyNewsByCat(pageNo, category);
        List<PolicyWithBLOBs> resultList = resultPage.getContent();
        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();
        json.put("resultList", resultList);
        json.put("totalRecords", resultPage.getTotalRecords());
        json.put("totalPages", resultPage.getTotalPages());
        out.print(json);
    }

    /**
     * 获取所有政策新闻
     *
     * @param response
     * @param page
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping("queryPolicyNews")
    public void queryPolicyNews(HttpServletResponse response, String page) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        int pageNo = page == null ? 1 : Integer.parseInt(page);
        Page<PolicyWithBLOBs> resultPage = searchService.queryPolicyNews(pageNo);
        List<PolicyWithBLOBs> resultList = resultPage.getContent();
        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();
        json.put("resultList", resultList);
        json.put("totalRecords", resultPage.getTotalRecords());
        json.put("totalPages", resultPage.getTotalPages());
        out.print(json);
    }

    /**
     * 根据条件来匹配政策新闻
     *
     * @param response
     * @param page
     * @param startDate
     * @param endDate
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping("matchPolicyNews")
    public void matchPolicyNews(HttpServletResponse response, String page, String startDate, String endDate, String cat) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");

        int pageNo = page == null ? 1 : Integer.parseInt(page);
        Page<PolicyWithBLOBs> resultPage = searchService.queryMatchPolicyNews(pageNo, startDate, endDate, cat);
        List<PolicyWithBLOBs> resultList = resultPage.getContent();
        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();
        json.put("resultList", resultList);
        json.put("totalRecords", resultPage.getTotalRecords());
        json.put("totalPages", resultPage.getTotalPages());
        out.print(json);
    }

    /*
    行业数据分析版块的代码
     */

    /**
     * 跳转到行业分类新闻
     *
     * @return
     */
    @RequestMapping("showIndustryNews")
    public ModelAndView showIndustryNews() {
        return new ModelAndView("IndustryNews");
    }

    @RequestMapping("showMatchIndustryNews")
    public ModelAndView showMatchIndustryNews(String startDate, String endDate, String key, ModelMap modelMap) {
        modelMap.addAttribute("startDate", startDate);
        modelMap.addAttribute("endDate", endDate);
        modelMap.addAttribute("key", key);
        return new ModelAndView("MatchIndustryNews");
    }

    @ResponseBody
    @RequestMapping("queryIndustryNews")
    public void queryIndustryNews(HttpServletResponse response, String page) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        int pageNo = page == null ? 1 : Integer.parseInt(page);
        List keywords = searchService.getIndustryKeywords(pageNo);
        Page<NewsOfIndustryWithBLOBs> resultPage = searchService.queryAllIndustryNews(pageNo);
        List<NewsOfIndustryWithBLOBs> resultList = resultPage.getContent();
        List<ComNameNewsCount> newsCount = searchService.IndustryNewsCount();//调用新闻量类
        List<String> nameList = new ArrayList<>();
        List<Integer> numList = new ArrayList<>();
        for (ComNameNewsCount instance : newsCount) {
            nameList.add(instance.getName());
            numList.add(instance.getCount());
        }
        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();
        json.put("resultList", resultList);
        json.put("totalRecords", resultPage.getTotalRecords());
        json.put("totalPages", resultPage.getTotalPages());
        json.put("nameList", nameList);
        json.put("numList", numList);
        json.put("keywords", keywords);
        out.print(json);
    }

    @ResponseBody
    @RequestMapping("matchIndustryIndustryNews")
    public void matchIndustryIndustryNews(HttpServletResponse response, String page, String startDate, String endDate, String key) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        int pageNo = page == null ? 1 : Integer.parseInt(page);
        if (key == null)
            key = "";
        List keywords = searchService.getMatchIndustryKeywords(pageNo, startDate, endDate, key);
        Page<NewsOfIndustryWithBLOBs> resultPage = searchService.queryMatchIndustryNews(pageNo, startDate, endDate, key);
        List<NewsOfIndustryWithBLOBs> resultList = resultPage.getContent();
        List<ComNameNewsCount> MatchNewsCount = searchService.getMatchIndustryNewsCount(startDate, endDate);
        List<String> nameList = new ArrayList<>();
        List<Integer> numList = new ArrayList<>();
        for (ComNameNewsCount instance : MatchNewsCount) {
            nameList.add(instance.getName());
            numList.add(instance.getCount());
        }
        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();
        json.put("resultList", resultList);
        json.put("totalRecords", resultPage.getTotalRecords());
        json.put("totalPages", resultPage.getTotalPages());
        json.put("nameList", nameList);
        json.put("numList", numList);
        json.put("keywords", keywords);

        out.print(json);
    }

    @RequestMapping("queryKeyByFlag")
    public ModelAndView queryKeyByFlag(ModelMap modelMap, HttpServletRequest request) {
        String flag = (request.getParameter("flag") != null) ? request.getParameter("flag") : "1";
        modelMap.put("flag", flag);
        return new ModelAndView("KeyIndicates", modelMap);
    }


    /**
     * 跳到关键指标监控页面
     *
     * @return
     */
    @RequestMapping("showKeyIndicates")
    public ModelAndView showKeyIndicates() {
        return new ModelAndView("KeyIndicates");
    }

    /**
     * 关键指标监控-全国GDP
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("queryKeyIndicatesGDPCountry")
    public void queryKeyIndicatesGDPCountry(HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        List<IndicateOfGDPCountry> GDPCountryCount = searchService.queryAllGDPCountry();//查询GDP数据
        List<String> nameList = new ArrayList<>();
        List<String> numList = new ArrayList<>();
        for (IndicateOfGDPCountry instance : GDPCountryCount) {
            nameList.add(instance.getSeasonName());
            numList.add(instance.getData());
        }
        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();
        json.put("nameList", nameList);
        json.put("numList", numList);
        out.print(json);
    }

    /**
     * 关键指标监控-上海地区GDP
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("queryKeyIndicatesGDPSH")
    public void queryKeyIndicatesGDPSH(HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
//        System.out.println(12312);
        List<IndicateOfGDPSH> GDPSHCount = searchService.queryAllGDPSH();//查询上海地区GDP数据
        List<String> nameList = new ArrayList<>();
        List<String> numList = new ArrayList<>();
        for (IndicateOfGDPSH instance : GDPSHCount) {
            nameList.add(instance.getSeasonName());
            numList.add(instance.getData());
        }
        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();
        json.put("nameList", nameList);
        json.put("numList", numList);
        out.print(json);
    }

    /**
     * 关键指标监控-全国PPI
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("queryKeyIndicatesPPI")
    public void queryKeyIndicatesPPI(HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        List<String> nameList = new ArrayList<>();
        List<String> numListPPI = new ArrayList<>();
        List<String> numListCPI = new ArrayList<>();
//        System.out.println(12312);
        List<IndicateOfPPI> PPICount = searchService.queryAllPPI();//查询全国PPI数据
        for (IndicateOfPPI instance : PPICount) {

//            System.out.println(instance.getSeason());
            numListPPI.add(instance.getData());
        }
        List<IndicateOfCPI> CPICount = searchService.queryAllCPI();//查询全国PPI数据
        for (IndicateOfCPI instance : CPICount) {
            nameList.add(instance.getSeason());
            numListCPI.add(instance.getData());
        }
        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();
        json.put("nameList", nameList);
        json.put("numListPPI", numListPPI);
        json.put("numListCPI", numListCPI);
        out.print(json);
    }


    /**
     * 关键指标监控-全国进出口总额
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("queryKeyIndicatesExportImport")
    public void queryKeyIndicatesExportImport(HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
//        System.out.println(12312);
        List<IndicateOfExportImport> ExportImportCount = searchService.queryAllExportImport();//查询全国PPI数据
        List<String> nameList = new ArrayList<>();
        List<String> numList = new ArrayList<>();
        for (IndicateOfExportImport instance : ExportImportCount) {
            nameList.add(instance.getSeason());
            numList.add(instance.getData());
        }
        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();
        json.put("nameList", nameList);
        json.put("numList", numList);
        out.print(json);
    }

    /**
     * 关键指标监控-中国BDI指标
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("queryKeyIndicatesBDI")
    public void queryKeyIndicatesBDI(HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
//        System.out.println(12312);
        List<IndicateOfBDI> BDICount = searchService.queryAllBDI();//查询全国PPI数据
        List<String> nameList = new ArrayList<>();
        List<String> numList = new ArrayList<>();
        for (IndicateOfBDI instance : BDICount) {
            nameList.add(instance.getSeason());
            numList.add(instance.getData());
        }
        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();
        json.put("nameList", nameList);
        json.put("numList", numList);
        out.print(json);
    }

    @RequestMapping("queryKeyIndicatesPMI")
    public void queryKeyIndicatesPMI(HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        List<Pmi> PMICount = searchService.queryAllPmi();//查询全国PMI数据
        List<Date> nameList = new ArrayList<>();
        List<Float> numList = new ArrayList<>();
        for (Pmi instance : PMICount) {
            nameList.add(instance.getDate());
            numList.add(instance.getPmivalues());
        }
        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();
        json.put("nameList", nameList);
        json.put("numList", numList);
        out.print(json);
    }

    @RequestMapping("queryKeyIndicatescopper")
    public void queryKeyIndicatescopper(HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        List<copper> copperCount = searchService.queryAllcopper();//查询全国PMI数据
        List<Date> nameList = new ArrayList<>();
        List<Float> numList = new ArrayList<>();
        for (copper instance : copperCount) {
            nameList.add(instance.getDate());
            numList.add(instance.getSettlement());
        }
        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();
        json.put("nameList", nameList);
        json.put("numList", numList);
        out.print(json);
    }

    @RequestMapping("queryKeyIndicatedder")
    public void queryKeyIndicatedder(HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        List<dollar_exchange_rate_of_rmb> derrCount = searchService.queryAlldollar_exchange_rate_of_rmb();//查询全国PMI数据
        List<String> nameList = new ArrayList<>();
        List<Float> numList = new ArrayList<>();
        for (dollar_exchange_rate_of_rmb instance : derrCount) {
            nameList.add(instance.getDate());
            numList.add(instance.getSettlement());
        }
        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();
        json.put("nameList", nameList);
        json.put("numList", numList);
        out.print(json);
    }

    @RequestMapping("queryKeyIndicatesTaxCountry")
    public void queryKeyIndicatesTaxCountry(HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        List<TaxCountry> TaxCoutry = searchService.queryAllTaxCountry();//查询全国PMI数据
        ArrayList<String> nameList = new ArrayList<>();
        List<Float> numList = new ArrayList<>();
        for (TaxCountry instance : TaxCoutry) {
            nameList.add(instance.getDate());
            numList.add(instance.getValues());
        }
        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();
        json.put("nameList", nameList);
        json.put("numList", numList);
        out.print(json);
    }

    @RequestMapping("queryKeyIndicatesTRSCG")
    public void queryKeyIndicatesTRSCG(HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        List<TotalRetailSalesOfConsumerGoods> TRSCG = searchService.queryAllTRSC();//查询全国PMI数据
        ArrayList<String> nameList = new ArrayList<>();
        List<String> numList = new ArrayList<>();
        for (TotalRetailSalesOfConsumerGoods instance : TRSCG
                ) {
            nameList.add(instance.getYear());
            numList.add(instance.getValue());
        }
        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();
        json.put("nameList", nameList);
        json.put("numList", numList);
        out.print(json);
    }

    @RequestMapping("queryKeyIndicatesCrude")
    public void queryKeyIndicatesCrude(HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        List<crude_btl> crudebtlCount = searchService.queryAllcrude_btl();//查询全国PMI数据
        List<String> nameList = new ArrayList<>();
        List<String> numListbtl = new ArrayList<>();
        List<String> numListwti = new ArrayList<>();
        for (crude_btl instance : crudebtlCount) {
            nameList.add(instance.getDate());
            numListbtl.add(instance.getPrice());
        }
        List<crude_wti> crudewtiCount = searchService.queryAllcrude_wti();
        for (crude_wti instance : crudewtiCount) {
            numListwti.add(instance.getPrice());
        }
        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();
        json.put("nameList", nameList);
        json.put("numListbtl", numListbtl);
        json.put("numListwti", numListwti);
        out.print(json);
    }

    @RequestMapping("queryKeyIndicatesIMF")
    public void queryKeyIndicatesIMF(HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        List<String> nameList = new ArrayList<>();
        List<Float> China = new ArrayList<>();
        List<Float> developing = new ArrayList<>();
        List<Float> Advanced = new ArrayList<>();
        List<Float> world = new ArrayList<>();
        List<imf> imfCount = searchService.querryAllimf();//查询全国PPI数据
        for (imf instance : imfCount) {
            nameList.add(instance.getYear());
            China.add(instance.getChina());
            developing.add(instance.getEmergingMarketAndDevelopingEconomies());
            Advanced.add(instance.getAdvancedEconomies());
            world.add(instance.getWorld());
        }

        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();
        json.put("nameList", nameList);
        json.put("China", China);
        json.put("developing", developing);
        json.put("Advanced", Advanced);
        json.put("world", world);
        out.print(json);
    }


    /**
     * 跳到关键指标监控页面gdp页面
     *
     * @return
     */
    @RequestMapping("keyIndicateInit")
    public ModelAndView keyIndicateInit() {
        return new ModelAndView("keyIndicateInit");
    }

    /**
     * 跳到关键指标监控页面GDP页面
     *
     * @return
     */
    @RequestMapping("IndicateGDP")
    public ModelAndView IndicateGDP() {
        return new ModelAndView("IndicateGDP");
    }

    /**
     * 跳到关键指标监控页面PPI&CPI页面
     *
     * @return
     */
    @RequestMapping("IndicatepcPage")
    public ModelAndView IndicatepcPage() {
        return new ModelAndView("IndicatepcPage");
    }

    /**
     * 跳到关键指标监控页面ExportImport页面
     *
     * @return
     */
    @RequestMapping("IndicateExportImport")
    public ModelAndView IndicateExportImport() {
        return new ModelAndView("IndicateExportImport");
    }

    /**
     * 跳到关键指标监控页面油价页面
     *
     * @return
     */
    @RequestMapping("IndicateBDI")
    public ModelAndView IndicateBDI() {
        return new ModelAndView("IndicateBDI");
    }

    /**
     * 跳到关键指标监控页面TaxCountry页面
     *
     * @return
     */
    @RequestMapping("IndicateTaxCountry")
    public ModelAndView IndicateTaxCountry() {
        return new ModelAndView("IndicateTaxCountry");
    }


    /**
     * 跳到关键指标监控页面社会消费品零售总额页面
     *
     * @return
     */
    @RequestMapping("IndicateTRSCG")
    public ModelAndView IndicateTRSCG() {
        return new ModelAndView("IndicateTRSCG");
    }

    /**
     * 跳到关键指标监控页面PMI页面
     *
     * @return
     */
    @RequestMapping("IndicatePMI")
    public ModelAndView IndicatePMI() {
        return new ModelAndView("IndicatePMI");
    }

    /**
     * 跳到关键指标监控页面铜价页面
     *
     * @return
     */
    @RequestMapping("Indicatecopper")
    public ModelAndView Indicatecopper() {
        return new ModelAndView("Indicatecopper");
    }

    /**
     * 跳到关键指标监控页面油价页面
     *
     * @return
     */
    @RequestMapping("IndicateCrude")
    public ModelAndView IndicateCrude() {
        return new ModelAndView("IndicateCrude");
    }

    /**
     * 跳到关键指标监控页面油价页面
     *
     * @return
     */
    @RequestMapping("IndicateIMF")
    public ModelAndView IndicateIMF() {
        return new ModelAndView("IndicateIMF");
    }

    /**
     * 跳到关键指标监控页面油价页面
     *
     * @return
     */
    @RequestMapping("Indicatedder")
    public ModelAndView Indicatedder() {
        return new ModelAndView("Indicatedder");
    }


}


