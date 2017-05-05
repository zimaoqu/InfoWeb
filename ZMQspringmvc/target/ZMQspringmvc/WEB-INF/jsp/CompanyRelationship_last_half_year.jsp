<%--
  Created by IntelliJ IDEA.
  User: Scorpion
  Date: 2017/4/23
  Time: 18:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         import="java.io.File, java.io.FileInputStream, java.io.InputStreamReader"
         import="java.io.BufferedReader, java.io.IOException"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

</head>
<style>
    .nodetext {
        font-size: 20px;
        font-family: SimSun;
        fill: #000000;
    }

    .linetext {
        font-size: 15px;
        font-family: SimSun;
        fill: #0000FF;
        fill-opacity: 0.0;
    }

    .div_desp {
        height: 450px;
        overflow: auto;
    }

    .node_text_pro {
        font-family: "Microsoft YaHei";
        font-size: 16px;
    }

    .arti_font {
        font-family: "Microsoft YaHei";
    }

</style>

<body>
<div class="container-fluid">
    <br/>
    <%@include file="title.jsp" %>
    <br/>
    <div class="col-md-7" id="graph" style="position:relative">
        <div class="row-fluid div_overflow text-center">
            <div class="btn-group">
                <a class="btn btn-default"
                   href="${pageContext.request.contextPath}/zmq/showCompanyRelationship_last_month">近一月</a>
                <a class="btn btn-default"
                   href="${pageContext.request.contextPath}/zmq/showCompanyRelationship_last_season">近一季</a>
                <a class="btn btn-default"
                   href="${pageContext.request.contextPath}/zmq/showCompanyRelationship_last_half_year">近半年</a>
                <a class="btn btn-default active" href="${pageContext.request.contextPath}/zmq/showCompanyRelationship">全部时间</a>
            </div>
        </div>
        <div style="position:absolute;left:100px;top:70px;z-index:0">
            <div><img alt="图不见了" src="${pageContext.request.contextPath}/resources/images/inside.png" height="15px"
                      width="15px"/><span>　区内企业</span></div>
            <div><img alt="图也不见了" src="${pageContext.request.contextPath}/resources/images/outside.png" height="15px"
                      width="15px"/><span>　区外企业</span></div>
        </div>
    </div>
    <div class="col-md-4">
        <p id="description" style="margin-top:50px;"></p>
        <div class="media div_desp">
            <div class="media-body" id="body_head">
            </div>
        </div>
    </div>
    <%
        String sInput = new String();
        try {
            String encoding = "UTF-8";
            File file = new File("C://dict//real_data//half_year(100).txt");
            if (file.isFile() && file.exists()) {
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while ((lineTxt = bufferedReader.readLine()) != null) {
                    sInput += lineTxt;
                }
                bufferedReader.close();
                read.close();
            } else {
                System.out.println("找不到文件！");
            }
        } catch (IOException e) {
            System.out.println("读文件出错！");
            e.printStackTrace();
        }
    %>
    <script type="text/javascript">
        var str = '<%=sInput%>';
        //var str = '{"nodes":[{"name":"三星"},{"name":"特斯拉"},{"name":"三星电子"},{"name":"支付宝"},{"name":"松下"},{"name":"华为"},{"name":"华纳兄弟"},{"name":"日产"},{"name":"爱立信"}],"edges":[{"source":"三星","target":"支付宝","relation":"支付宝与三星的合作，打通了手机支付的顶层技术，当用户在线下消费时，可以用支付宝更安全、便捷地完成手机支付。"},{"source":"三星","target":"特斯拉","relation":"腾讯证券讯日前，英国路透社等媒体报道，韩国三星SDI公司将会给特斯拉提供锂电池，解决Model 3车型的锂电池供应紧张问题。"}]}';
        //var str = '{"nodes":[{"name":"三星"},{"name":"松下"},{"name":"华为"},{"name":"小米"}],"edges":[{"source":"三星","target":"松下","relation":"高通深化与三星的合作，最重要的原因在于智能手机厂商都纷纷开始研发自主处理器，高通的市场地位和出货收到了极大的威胁，加深与三星的合作对于高通出货量有一定稳定作用。"},{"source":"华为","target":"小米","relation":"研究公司IDC的数据显示，由于份额遭到三星电子、华为以及小米的蚕食，HTC去年的智能机份额已从2011年的9.2%萎缩至1.3%。"},{"source":"小米","target":"华为","relation":"最近要是几个手机厂商打牌一定是这样的，小米：“我出5”魅族：“我出6”苹果：“我出7”荣耀：“我出8”华为：“我出9”三星：“我炸!”要不起…　　上面的段子虽是玩笑但反应的问题可不是小问题，三星Note7的爆炸事件对三星的影响是非常非常大的。"}]}';
        var obj = JSON.parse(str);
        var Receivenodes = [];
        var Receiveedges = [];
        for (var i = 0; i < obj.nodes.length; i++) {
            Receivenodes.push({name: obj.nodes[i].name, type: obj.nodes[i].type});
        }
        for (var j = 0; j < obj.edges.length; j++) {

            //s,t 作为公司名称
            var s;
            var t;
            //ints,intt 作为公司名称对应的数字
            var ints = 0;
            var intt = 0;
            s = obj.edges[j].source;
            t = obj.edges[j].target;
            for (var k = 0; k < obj.nodes.length; k++) {
                if (s == obj.nodes[k].name) {
                    ints = k;
                }
                if (t == obj.nodes[k].name) {
                    intt = k;
                }
            }
            //alert(ints)
            //alert(intt)
            Receiveedges.push({
                source: ints,
                target: intt,
                relation: obj.edges[j].relation
            })
        }
        //for(int i = 0;i<str.)
        //nodes.put()
        //alert(Receiveedges[0].relation)
        //alert(Receiveedges[0].source)
        //alert(Receiveedges[0].target)
        var nodes = Receivenodes;
        var edges = Receiveedges;

        var width = 800;
        var height = 600;

        var svg = d3.select("#graph")
            .append("svg")
            .attr("width", width)
            .attr("height", height);

        var force = d3.layout.force()
            .nodes(nodes)		//指定节点数组
            .links(edges)		//指定连线数组
            .size([width, height])	//指定范围
            .linkDistance(200)	//指定连线长度
            .charge(-300);	//相互之间的作用力

        force.start();	//开始作用

        console.log(nodes);
        console.log(edges);

        //力学图运动开始时
        force.on("start", function () {
            console.log("开始");
        });

        //力学图运动结束时
        force.on("end", function () {
            console.log("结束");
        });

        //力学图每一帧
        force.on("tick", function () {
            console.log("进行中");
        });

        //var drag = force.drag()
        //			.on("dragstart",function(d,i){
        //				d.fixed = true;    //拖拽开始后设定被拖拽对象为固定
        //			})

        var color = d3.scale.category20();

        //添加节点
        var svg_nodes = svg.selectAll("circle")
            .data(nodes)
            .enter()
            .append("circle")
            .attr("r", 20)
            .style("fill", function (d) {
                return color(d.type);
            })
            .on("mouseover", function (d, i) {
                $("#body_head").html("");
                $("#body_head").attr("class", "media-body");

                $("#description").html("");
                var title = "<h3 class='media-heading arti_font' id='body_arti'>" + d.name + "</h4>";
                var title_l = "<h4 class='media-heading arti_font' id='body_arti'>相关联系</h4>";
                $("#description").append(title);
                $("#description").append(title_l);

                //显示连接线上的文字
                //edges_text.style("fill-opacity",function(edge){
                //	if( edge.source === d || edge.target === d ){
                //		return 1.0;
                //	}
                //});

                for (var loop = 0; loop < edges.length; loop++) {

                    if (JSON.stringify(edges[loop].source.index) == i || JSON.stringify(edges[loop].target.index) == i) {
                        var s = JSON.stringify(edges[loop].source.index);
                        var t = JSON.stringify(edges[loop].target.index);
                        var temp = JSON.stringify(edges[loop].relation);
                        temp = "<p class='arti_font'>" + temp + "</p>";
                        var re = new RegExp("\"", "g");
                        temp = temp.replace(re, "");
                        re = new RegExp(obj.nodes[s].name, "g");
                        temp = temp.replace(re, "<font style='font-weight:bold;'>" + obj.nodes[s].name + "</font>");
                        re = new RegExp(obj.nodes[t].name, "g");
                        temp = temp.replace(re, "<font style='font-weight:bold;'>" + obj.nodes[t].name + "</font>");

                        $("#body_head").append(temp);
                    }
                }
                /*for(var loop=0;loop<edges.length;loop++)
                 {
                 if(JSON.stringify(edges[loop].source.index)==i || JSON.stringify(edges[loop].target.index)==i)
                 {
                 var s = JSON.stringify(edges[loop].source.index);
                 var t = JSON.stringify(edges[loop].target.index);


                 var temp = JSON.stringify(edges[loop].relation)+"</br>";
                 var re = new RegExp("\"","g");
                 temp = temp.replace(re,"");
                 re = new RegExp(obj.nodes[s].name,"g");
                 temp = temp.replace(re,"<font color='red'>"+obj.nodes[s].name+"</font>");
                 re = new RegExp(obj.nodes[t].name,"g");
                 temp = temp.replace(re,"<font color='red'>"+obj.nodes[t].name+"</font>");

                 $("#description").append(temp);
                 //alert(JSON.stringify(edges[loop].relation));
                 }
                 }*/
                svg_edges.style("stroke-width", function (edge) {
                    if (edge.source === d || edge.target === d) {
                        return 5;
                    }
                });
            })
            .on("mouseout", function (d, i) {

                //隐去连接线上的文字
                //edges_text.style("fill-opacity",function(edge){
                //	if( edge.source === d || edge.target === d ){
                //		return 0.0;
                //	}
                //});
                svg_edges.style("stroke-width", function (edge) {
                    if (edge.source === d || edge.target === d) {
                        return 1;
                    }
                });
            })
            .call(force.drag);	//使得节点能够拖动

        //添加描述节点的文字
        var svg_texts = svg.selectAll("text")
            .data(nodes)
            .enter()
            .append("text")
            //.attr("class","nodetext")
            .attr("class", "node_text_pro")
            .attr("dx", 20)
            .attr("dy", 8)
            .text(function (d) {
                return d.name;
            });

        //添加连线
        var svg_edges = svg.selectAll("line")
            .data(edges)
            .enter()
            .append("line")
            .style("stroke", "#ccc")
            .style("stroke-width", 1);


        force.on("tick", function () {	//对于每一个时间间隔

            //限制结点的边界
            nodes.forEach(function (d, i) {
                d.x = d.x - 20 < 0 ? 20 : d.x;
                d.x = d.x + 20 > width ? width - 20 : d.x;
                d.y = d.y - 20 < 0 ? 20 : d.y;
                d.y = d.y + 20 > height ? height - 20 : d.y;
            });
            //更新连线坐标
            svg_edges.attr("x1", function (d) {
                return d.source.x;
            })
                .attr("y1", function (d) {
                    return d.source.y;
                })
                .attr("x2", function (d) {
                    return d.target.x;
                })
                .attr("y2", function (d) {
                    return d.target.y;
                });

            //更新节点坐标
            svg_nodes.attr("cx", function (d) {
                return d.x;
            })
                .attr("cy", function (d) {
                    return d.y;
                });


            //更新文字坐标
            svg_texts.attr("x", function (d) {
                return d.x;
            })
                .attr("y", function (d) {
                    return d.y + 10;
                });
        });

    </script>
</div>

</body>
</html>