package com.scorpion.service;

import com.scorpion.pojo.*;
import com.scorpion.util.data.Page;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Scorpion on 2017/4/19.
 */
public interface SearchService {
    /*
    获取事件新闻
     */
    List<eventnewsWithBLOBs> getEventNews(String companyName, int flag);

    /*
    获取所有重点企业新闻，根据page
     */
    public Page<NewsOfCompanyWithBLOBs> queryAllTopNews(int page);

    /*
    根据条件匹配重点企业新闻
     */
    public Page<NewsOfCompanyWithBLOBs> queryMatchTopNews(int page, String startDate, String endDate, String key, String industry);

    /*
    获取所有企业新闻，根据page
     */
    public Page<NewsOfCompanyWithBLOBs> queryAllNews(int page);

    /*
   根据企业名称和page获取20个数据
   */
    public List<NewsOfCompanyWithBLOBs> queryCompanyNewsSizeTwenty(String name,int page);
    /*

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
    public List<negativenewsWithBLOBs> queryNegativenews(int page);

    /*
    queryCurrentnews
     */
    public List<currentnewsWithBLOBs> queryCurrentnews();

    public Page<NewsOfIndustryWithBLOBs> queryAllIndustryNews(int page);

    public Page<NewsOfIndustryWithBLOBs> queryMatchIndustryNews(int page, String startDate, String endDate, String key);

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

    /*
    企业历史演变用的
     */
    List<String> getComListHis();

    List<bignews> getHisEvents(String companyName);

    /*
    公司名称：事件分析
     */
    List<String> getComlist();

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

    HashMap<String, Integer> getKeywords(String companyName);

    HashMap<String, Integer> getCountSource(String companyName);

    List<currentnewsWithBLOBs> getHotNews(String companyName);

    List<currentnewsWithBLOBs> getSensiveNews(String companyName);

    //字符串处理
    public ArrayList<String> splitStr(String str);

    /*
    (企业声誉分析用到的)
     */
    double getCurreputation(String companyName);

    List<String> getDemoComList();


    /*
    获取新闻关键词（普通companynews）
     */
    public List getComKeywords(int page);

    /*
    获取其他自贸区新闻关键词
     */
    public List getOtherZmqKeywords(int page);

    /*
    获取其他自贸区新闻的关键词
     */
    public List getSHZmqKeywords(int page);

    /*
    获取时间匹配新闻关键词（普通companynews）
     */
    public List getMatchComKeywords(int page, String startDate, String endDate, String key);

    /*
    获取时间匹配其他自贸区新闻关键词
     */
    public List getMatchOtherZmqKeywords(int page, String startDate, String endDate, String key);

    /*
    获取时间匹配上海自贸区新闻关键词
     */
    public List getMatchSHZmqKeywords(int page, String startDate, String endDate);

    /*
    获取新闻关键词（Top companynews）
     */
    public List getTopComKeywords(int page);

    /*
    获取时间匹配新闻关键词（Top companynews）
     */
    public List getMatchTopComKeywords(int page, String startDate, String endDate, String key, String industry);

    /*
    获取行业新闻关键词
     */
    public List getIndustryKeywords(int page);

    /*
    获取匹配条件行业新闻关键词
     */
    public List getMatchIndustryKeywords(int page, String startDate, String endDate, String key);

    /*
    获取top每个公司的新闻数
     */
    public List<ComNameNewsCount> TopNewsCount();

    List<ComNameNewsCount> getTopMatchNewsCount(String startDate, String endDate);

    /*
    获取每个公司的新闻数
     */
    public List<ComNameNewsCount> NewsCount();

    List<ComNameNewsCount> getMatchNewsCount(String startDate, String endDate);

    public List<ComNameNewsCount> CompanyWarningCount();

    public List<ComNameNewsCount> CompanyWarningBeforeCount();

    public List<PredictedandRealistic> CompanyPredictWarning(String CompanyNumberflag);

    public List<ComNameNewsCount> OtherZmqNewsCount();

    public List<ComNameNewsCount> getMatchOtherZmqNewsCount(String startDate, String endDate);

    public List<ComNameNewsCount> IndustryNewsCount();

    public List<ComNameNewsCount> getMatchIndustryNewsCount(String startDate, String endDate);

    /*
    获取所有GDP数据
     */
    public List<IndicateOfGDPCountry> queryAllGDPCountry();

    /*
    获取上海地区GDP数据
     */
    public List<IndicateOfGDPSH> queryAllGDPSH();

    /*
    获取全国PPI数据
     */
    public List<IndicateOfPPI> queryAllPPI();

    /*
    获取全国CPI数据
     */
    public List<IndicateOfCPI> queryAllCPI();

    /*
    获取全国进出口总额数据
     */
    public List<IndicateOfExportImport> queryAllExportImport();

    /*
    获取中国BDI数据
     */
    public List<IndicateOfBDI> queryAllBDI();

    /*
   获取PMI数据
* */
    public List<Pmi> queryAllPmi();

    /*
        获取全国税收Pmi数据
    * */
    public List<TaxCountry> queryAllTaxCountry();

    /*
       获取铜价格数据
   * */
    public List<copper> queryAllcopper();

    /*
      获取布伦特原油价格数据
  * */
    public List<crude_btl> queryAllcrude_btl();

    /*
     获取WTI原油价格数据
 * */
    public List<crude_wti> queryAllcrude_wti();

    /*
   获取美元人民币汇率
* */
    public List<dollar_exchange_rate_of_rmb> queryAlldollar_exchange_rate_of_rmb();

    /**
     * @return 获取imf预测数据
     */
    public List<imf> querryAllimf();

    /*
            获区社会消费品零售总额
     */
    public List<TotalRetailSalesOfConsumerGoods> queryAllTRSC();


    /*
    获得行业列表
     */
    public List<String> getIndustryList();

    /*
    获取某个行业的公司
     */
    public List<String> getComOfIndustry(String industry);

    /*

     */
    public List<IndustryCount> TopNewsIndustryCount();

    /*
    （垄断、合并等关键词匹配的新闻）
     */
    List<TopKeyAttentionWithBLOBs> queryNewsOfAttKey(int pageNo);
    /*
    通过id获取新闻信息
     */
    public bignews GetBignewsbyid(String bignewsid);

    String getPosNumString(String name, String gap);

    String getNegNumString(String name, String gap);

    String getHealthValueString(String name, String gap);

    List<String> getTopComList();

    double getHealthValue(String name);

    List<String> getComHealthList();

    List<List<Integer>> queryZmqIndex(int flag);

    List<CreditScore> getCreditScore();
    List<String> getDateList();

    List<List<Integer>> queryZmqMediaIndex();

    int getIndexAll(String tmp,String startDate,String endDate);

    int getIndexMobile(String tmp,String startDate,String endDate);

    List<ZmqEvent> queryZmqEvent(String name);

}
