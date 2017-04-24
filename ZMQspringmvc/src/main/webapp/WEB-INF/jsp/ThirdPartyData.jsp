<%--
  Created by IntelliJ IDEA.
  User: Scorpion
  Date: 2017/4/23
  Time: 15:01
  第三方数据
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <link href="${pageContext.request.contextPath}/resources/css/pagination.css" rel="stylesheet">


    <title>中国自由贸易试验区大数据管理与分析平台</title>

</head>

<body>
<div class="container-fluid">
    <br/>
    <%@include file="title.jsp" %>
    <br/>

</div>
<div class="row-fluid">
    <div class="col-xs-8 span8">
        <div class="news">
            <div id="3" class="p1">
                <h3>
                    <b><font size="4">[数据报告] 中国跨境进口电商市场专题研究报告（2015 PDF 版）</font></b>
                </h3>
                <p>
                    2015-7-16
                </p>
                <p> 易观智库《2015中国跨境进口电商市场专题研究报告》核心内容：跨境进口电商发展现状解析；跨境进口电商典型厂商分析；跨境进口电商发展趋势分析；中国跨境进口电商产业链
                </p>
                <p>
                    <a class="btn btn-default" href="http://www.useit.com.cn/thread-9659-1-1.html" target="_blank">原文
                        »</a>
                    <button type="button" class="btn btn-default" onclick="download()">下载</button>
                </p>
            </div>
            <div id="3" class="p1">
                <h3>
                    <b><font size="4">中国自贸区发展报告（2016）精读</font></b>
                </h3>
                <p>
                    2016-9-20
                </p>
                <p>
                    进入21世纪之后，随着多边贸易体制发展受阻，区域一体化有了迅速发展，尤其是以美国为主导、以TPP为代表的新贸易规则正在确立之中。而国际贸易规则的变革，使得自由贸易区和自由贸易园区这类国际经济合作政策工具的内涵有了新的变化。
                </p>
                <p>
                    <a class="btn btn-default" href="http://www.cssn.cn/zk/zk_zkbg/201609/t20160920_3207040.shtml"
                       target="_blank">原文
                        »</a>
                </p>
            </div>
            <div id="1" class="p1">
                <h3>
                    <b><font size="4">[数据报告] 2015年跨境电商投资于市场调查报告（附多份数据）</font></b>
                </h3>
                <p>
                    2015-6-29
                </p>
                <p>
                    跨境电商2015年火了，在淘宝或天猫取得成功的店主，正想着从跨境电商业务中扩大业务。而之前，并没有赶上中国电子商务发展步伐的人，不想再错过这一次的机遇。那跨境电商到底有没有投资价值？他的行业背景是什么？行业限制是什么？有哪些资源能够帮我们快速学习和成长。我们从网络上收集了一些关于跨境电商的资料，希望对大家的学习有帮助。
                </p>
                <p>
                    <a class="btn btn-default" href="http://www.useit.com.cn/thread-9545-1-1.html" target="_blank">原文
                        »</a>
                </p>
            </div>
            <div id="2" class="p1">
                <h3>
                    <b><font size="4">[实用理论] 国内跨境电商平台盘点，细数跨境电商的十大模式</font></b>
                </h3>
                <p>
                    2015-7-5
                </p>
                <p>
                    典型案例：天猫国际。天猫在跨境这方面通过和自贸区的合作，在各地保税物流中心建立了各自的跨境物流仓。它在宁波、上海、重庆、杭州、郑州、广州6个城市试点跨境电商贸易保税区、产业园签约跨境合作，全面铺设跨境网点。规避了基本法律风险，同时获得了法律保障，压缩了消费者从订单到接货的时间，提高了海外直发服务的便捷性。使得跨境业务在“灰色地带”打开了“光明之门”。
                </p>
                <p>
                    <a class="btn btn-default" href="http://www.useit.com.cn/thread-9569-1-5.html" target="_blank">原文
                        »</a>
                </p>
            </div>
            <script type="text/javascript">
                function download() {
                    window.location.href = "/InfoWeb/china2015.pdf";
                }
            </script>
        </div>
    </div>
</div>
</body>
</html>


