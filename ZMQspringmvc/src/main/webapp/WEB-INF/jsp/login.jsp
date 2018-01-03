<%--
  Created by IntelliJ IDEA.
  User: Scorpion
  Date: 2017/8/18
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/resources/css/loginReset.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/loginStructure.css" rel="stylesheet">
    <title>Login</title>
    <style>
        #divcenter {
            margin: 0 auto;
            width: 700px;
            height: 300px
        }
    </style>
</head>
<body>
<br>
<div id="divcenter">
    <h1 style="text-align: center;font-size: 260%">
        中国自由贸易试验区大数据管理与分析平台
    </h1>
</div>
<form class="box login" action="${pageContext.request.contextPath}/Login/login">
    <fieldset class="boxBody">
        <label>Username</label>
        <input type="text" tabindex="1" name="username" required>
        <label>Password</label>
        <input type="password" tabindex="2" name="password" required>
    </fieldset>
    <footer>
        <input type="submit" class="btnLogin" value="Login" tabindex="4">
    </footer>
</form>
<script type="text/javascript">
    window.onload = function(){
        var config = {
            vx: 4,
            vy:  4,
            height: 2,
            width: 2,
            count: 100,
            color: "121, 162, 185",
            stroke: "100,200,180",
            dist: 6000,
            e_dist: 20000,
            max_conn: 10
        }
        CanvasParticle(config);
    }
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/canvas-particle.js"></script>
</body>
</html>
