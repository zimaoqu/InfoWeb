package com.scorpion.controller;


import com.scorpion.pojo.*;
import com.scorpion.service.SearchService;
import com.scorpion.util.data.Page;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


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
    public ModelAndView showTopCompanyNews() {
        return new ModelAndView("TopCompanyNews");
    }

    /**
     * 跳转到根据时间、企业名称条件查询的重点企业新闻的界面
     *
     * @return
     */
    @RequestMapping("showTopMatchResult")
    public ModelAndView showTopMatchResult(String startDate, String endDate, String key, ModelMap modelMap) {
        modelMap.addAttribute("startDate", startDate);
        modelMap.addAttribute("endDate", endDate);
        modelMap.addAttribute("key", key);
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
     * 企业事件分析界面
     *
     * @return
     */
    @RequestMapping("showEventRelationship")
    public ModelAndView showEventRelationship() {
        return new ModelAndView("EventRelationship");
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
     * @param modelMap
     * @return
     */
    @RequestMapping("showAbnormalWarning")
    public ModelAndView showAbnormalWarning(ModelMap modelMap){
        return new ModelAndView("AbnormalWarning",modelMap);
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
        Page<NewsOfCompanyWithBLOBs> resultPage = searchService.queryAllTopNews(pageNo);
        List<NewsOfCompanyWithBLOBs> resultList = resultPage.getContent();
        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();
        json.put("resultList", resultList);
        json.put("totalRecords", resultPage.getTotalRecords());
        json.put("totalPages", resultPage.getTotalPages());
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
    public void matchTopCompanyNews(HttpServletResponse response, String page, String startDate, String endDate, String key) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        int pageNo = page == null ? 1 : Integer.parseInt(page);
        System.out.println(key);
        Page<NewsOfCompanyWithBLOBs> resultPage = searchService.queryMatchTopNews(pageNo, startDate, endDate, key);
        List<NewsOfCompanyWithBLOBs> resultList = resultPage.getContent();
        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();
        json.put("resultList", resultList);
        json.put("totalRecords", resultPage.getTotalRecords());
        json.put("totalPages", resultPage.getTotalPages());
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
        System.out.println("queryCompanyNews");
        int pageNo = page == null ? 1 : Integer.parseInt(page);
        Page<NewsOfCompanyWithBLOBs> resultPage = searchService.queryAllNews(pageNo);
        List<NewsOfCompanyWithBLOBs> resultList = resultPage.getContent();
        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();
        json.put("resultList", resultList);
        json.put("totalRecords", resultPage.getTotalRecords());
        json.put("totalPages", resultPage.getTotalPages());
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
        System.out.println("matchCompanyNews");
        int pageNo = page == null ? 1 : Integer.parseInt(page);
        Page<NewsOfCompanyWithBLOBs> resultPage = searchService.queryMatchNews(pageNo, startDate, endDate, key);
        List<NewsOfCompanyWithBLOBs> resultList = resultPage.getContent();
        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();
        json.put("resultList", resultList);
        json.put("totalRecords", resultPage.getTotalRecords());
        json.put("totalPages", resultPage.getTotalPages());
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
        Page<NewsOfSHZmqWithBLOBs> resultPage = searchService.queryAllSHZmqNews(pageNo);
        List<NewsOfSHZmqWithBLOBs> resultList = resultPage.getContent();
        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();
        json.put("resultList", resultList);
        json.put("totalRecords", resultPage.getTotalRecords());
        json.put("totalPages", resultPage.getTotalPages());
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
        Page<NewsOfOtherZmqWithBLOBs> resultPage = searchService.queryAllOtherZmqNews(pageNo);
        List<NewsOfOtherZmqWithBLOBs> resultList = resultPage.getContent();
        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();
        json.put("resultList", resultList);
        json.put("totalRecords", resultPage.getTotalRecords());
        json.put("totalPages", resultPage.getTotalPages());
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
        System.out.println("matchSHZmqNews");
        int pageNo = page == null ? 1 : Integer.parseInt(page);
        Page<NewsOfSHZmqWithBLOBs> resultPage = searchService.queryMatchSHZmqNews(pageNo, startDate, endDate);
        List<NewsOfSHZmqWithBLOBs> resultList = resultPage.getContent();
        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();
        json.put("resultList", resultList);
        json.put("totalRecords", resultPage.getTotalRecords());
        json.put("totalPages", resultPage.getTotalPages());
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
        Page<NewsOfOtherZmqWithBLOBs> resultPage = searchService.queryMatchOtherZmqNews(pageNo, startDate, endDate, key);
        List<NewsOfOtherZmqWithBLOBs> resultList = resultPage.getContent();
        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();
        json.put("resultList", resultList);
        json.put("totalRecords", resultPage.getTotalRecords());
        json.put("totalPages", resultPage.getTotalPages());
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
    public void queryPolicyNews(HttpServletResponse response,String page) throws IOException {
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
        System.out.println("matchPolicyNewws");

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
}
