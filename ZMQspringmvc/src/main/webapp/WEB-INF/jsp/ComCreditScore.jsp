<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/resources/css/ComCreditScore.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.2.6.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/zmqjs/ComCreditScore.js"></script>
</head>

<body>
<div class="container-fluid">
    <br/>
    <%@include file="title.jsp" %>
    <br/>

    <table id="travel" >

    
    <thead>    
    	<tr>
            <th scope="col" rowspan="2">企业名称</th>
            <th scope="col" colspan="22">指标</th>
            <th scope="col" rowspan="2">评分</th>
        </tr>

        <tr>
            <th scope="col">上海海关违规次数</th>
            <th scope="col">上海海关走私次数</th>
            <th scope="col">纳税人信誉等级评定</th>
            <th scope="col">是否在异常经营名录清单</th>
            <th scope="col">欠税额度</th>
            <th scope="col">是否在失信名单</th>
            <th scope="col">每股收益率</th>
            <th scope="col">净资产收益率</th>
            <th scope="col">总资产净利率</th>
            <th scope="col">应收账款周转率</th>
            <th scope="col">存款周转率</th>
            <th scope="col">资产负债率</th>
            <th scope="col">流动比率</th>
            <th scope="col">速动比率</th>
            <th scope="col">市场占有率</th>
            <th scope="col">资产保值增值率</th>
            <th scope="col">罚款额度</th>
            <th scope="col">检疫违规次数</th>
            <th scope="col">电燃气欠费额度</th>
            <th scope="col">行政处罚次数</th>
            <th scope="col">发票违法额度</th>
            <th scope="col">偷税额度</th>
        </tr>
    </thead>
      
    <tbody id = "content">

    </tbody>
</table>
</div>
</body>
</html>