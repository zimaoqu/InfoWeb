<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.scorpion.pojo.eventnewsWithBLOBs" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: Scorpion
  Date: 2017/4/21
  Time: 21:12
  企业事件分析
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <link href="${pageContext.request.contextPath}/resources/css/chinaz.css" rel="stylesheet">

</head>


<body>
<div class="container-fluid">
    <br/>
    <%@include file="title.jsp" %>
    <br/>
    <%
        String maincom = request.getAttribute("maincom").toString();
        String selectdiscomsstr=request.getAttribute("selectdiscomsstr").toString();
        List<eventnewsWithBLOBs> eventnews=(ArrayList<eventnewsWithBLOBs>)request.getAttribute("eventnews");
    %>
    <div class="row-fluid">
        <div  class="col-xs-8 span8">
            <span style="font-size:20px;">
                重点企业：
                <select name="selectcompany" id="selectcompany"  style="width:200px;">
                    "<%=selectdiscomsstr%>"
                </select>
                类别：
                <select name="cla" id="cla" style="width:200px;">
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                    <option value="6">6</option>
                </select>

                <button id="subcom">提交</button>
            </span>
            <script type="text/javascript">
                $("#subcom").click(function () {
                    tmp = $("#selectcompany option:selected").text();
                    flag = $("#cla option:selected").text();
                    req = "${pageContext.request.contextPath}/zmq/showEventRelationship?com=" + tmp+"&&flag="+flag
                    $.post(req,
                        {
                            //companyname:tmp
                        },
                        function () {
                            location.href = "${pageContext.request.contextPath}/zmq/showEventRelationship?com=" + tmp+"&&flag="+flag
                        });
                });
            </script>
        </div>
        <div class="wrapper">
            <div class="history">
                <div class="start-history">
                    <p class="cc_history"><%=selectdiscomsstr%></p>
                    <p class="next_history">PHYLOGENY</p>
                    <div class="history_left">
                    <%
                        for(int i=0;i<eventnews.size();i=i+2) {
                            eventnewsWithBLOBs n = eventnews.get(i);
                            //System.out.println(eventnews.size());
                            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            String _title = n.getTitle();
                            if(_title.length()>32){
                                _title = _title.substring(0,32);
                            }
                            String _date = formatter.format(n.getDate());
                            String _year = _date.substring(0,4);
                            System.out.println(_date);
                            String _month = _date.substring(5,7);
                            String _url = n.getUrl();
                    %>
                    <%
                        if(i==0){
                    %>
                    <p class="history_L year2006">
                    <%
                        }
                        else{
                    %>
                    <p class="history_L year2009">
                    <%
                        }
                    %>
                        <span class="history_2006_span"><%=_year%></span>
                        <b class="history_2006_b">
                            <span class="history_l_month"><%=_month%><br/>月</span>
                            <span class="history_l_text"><%=_title%><br/></span>
                        </b>
                    </p>
                    <%
                        }
                    %>
                    </div>

                    <div class="history-img">
                        <img class="history_img" src="${pageContext.request.contextPath}/resources/images/history.png" alt="">
                    </div>

                    <div class="history_right">
                    <%
                        for(int i=1;i<eventnews.size();i=i+2) {
                            eventnewsWithBLOBs n = eventnews.get(i);
                            //System.out.println(eventnews.size());
                            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            String _title1 = n.getTitle();
                            String _date1 = formatter.format(n.getDate());
                            String _year1 = _date1.substring(0,4);
                            System.out.println(_date1);
                            String _month1 = _date1.substring(5,7);
                            String _url1 = n.getUrl();
                    %>
                    <%
                        if(i==1){
                    %>
                        <p class="history_R history_r_2005">
                    <%
                        }
                        else{
                    %>
                        <p class="history_R year2009">
                    <%
                        }
                    %>
                            <span class="history_2005_span"><%=_year1%></span>
                            <b class="history_2005_b">
                                <span class="history_r_month"><%=_month1%><br/>月</span>
                                <span class="history_r_text"><%=_title1%></span>
                            </b>
                        </p>
                        <%
                            }
                        %>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="clear"></div>
            </div>
        </div>
    </div>
</div>

</body>
<script src="${pageContext.request.contextPath}/resources/js/jquery.slidy.js"></script>
<script>
    $(window).scroll(function(){
        var msg = $(".history-img");
        var item = $(".history_L");
        var items = $(".history_R");
        var windowHeight = $(window).height();
        var Scroll = $(document).scrollTop();
        if((msg.offset().top - Scroll -windowHeight)<=0){
            msg.fadeIn(1500);
        }
        for(var i=0;i<item.length;i++){
            if(($(item[i]).offset().top - Scroll - windowHeight)<= -100){
                $(item[i]).animate({marginRight:'0px'},'50','swing');
            }
        }
        for(var i=0;i<items.length;i++){
            if(($(items[i]).offset().top - Scroll - windowHeight)<= -100){
                $(items[i]).animate({marginLeft:'0px'},'50','swing');
            }
        }});

</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.mousewheel.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.easing.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/feedback.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/pageresponse.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.mousewheel.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resourcesjs/jquery.easing.js"></script>
</html>