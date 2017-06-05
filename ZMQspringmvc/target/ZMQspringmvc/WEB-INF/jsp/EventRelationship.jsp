<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.scorpion.pojo.eventnewsWithBLOBs" %><%--
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
        <div class="col-xs-8 span8">
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
            <div class="news">
                <div >
                    <p style="text-align:center"><b><font size='4'>事件新闻</font></b></p>

                    <table border="1">
                        <tr>
                            <th style="text-align:center;">时间</th>
                            <th style="text-align:center;">事件</th>
                            <th style="text-align:center;">内容</th>
                        </tr>
                        <%
                            for(int i=0;i<eventnews.size();i++) {
                                eventnewsWithBLOBs n = eventnews.get(i);
                                System.out.println(eventnews.size());
                        %>
                        <tr>
                            <%
                                String _title = n.getTitle();
                                String _date = n.getDate().toString();
                                String _url = n.getUrl();
                            %>
                            <td style="width: 80px;text-align:center"><%=_date%></td>
                            <td style="width: 600px;text-align:center"><%=_title%></td>
                            <td style="width: 70px;text-align:center"><a href="<%=_url%>" target="_blank">查看</a></td>
                        </tr>
                        <%
                            }
                        %>
                    </table>
                </div>

            </div>
    </div>
</div>
</div>

</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.mousewheel.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.easing.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/feedback.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/pageresponse.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.mousewheel.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resourcesjs/jquery.easing.js"></script>
</html>