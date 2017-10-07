/**
 * Created by Vikun on 2017/7/6.
 */
var nameList=[];//柱状图的nameList
var numListPPI=[];//柱状图的numList
var numListCPI=[];//柱状图的numList
(function () {

    $.ajax({
        cache: false,
        url: "/zmq/queryKeyIndicatesPPI",
        type: "GET",
        dataType: "json",
        data: {},
        async: true,
        success: function (data) {
            nameList = data.nameList;
            numListPPI = data.numListPPI;
            numListCPI = data.numListCPI;
            graphicPPIandCPI();
            graphicTable1();

        }

    })
})();

function graphicTable1(){
    var str1="<table  border='1' cellspacing='0' cellpadding='0'><tr><td>日期</td>"
    var str2="<tr><td>PPI</td>"
    var str3="<tr><td>CPI</td>"

    var str4="<tr><td>日期</td>"
    var str5="<tr><td>PPI</td>"
    var str6="<tr><td>CPI</td>"

    var str7="<tr><td>日期</td>"
    var str8="<tr><td>PPI</td>"
    var str9="<tr><td>CPI</td>"
    var str10="<tr><td>日期</td>"
    var str11="<tr><td>PPI</td>"
    var str12="<tr><td>CPI</td>"
    nList=eval(nameList)
    ListPPI=eval(numListPPI)
    ListCPI=eval(numListCPI)
    for(var i=0;i<32;i++){
        str1=str1+"<td>"+nList[i]+"</td>"
        str2=str2+"<td>"+ListCPI[i]+"</td>"
        str3=str3+"<td>"+ListPPI[i]+"</td>"
    }
    str1=str1+"</tr>"
    str2=str2+"</tr>"
    str3=str3+"</tr>"

    for(var i=32;i<64;i++){
        str4=str4+"<td>"+nList[i]+"</td>"
        str5=str5+"<td>"+ListCPI[i]+"</td>"
        str6=str6+"<td>"+ListPPI[i]+"</td>"
    }
    str4=str4+"</tr>"
    str5=str5+"</tr>"
    str6=str6+"</tr>"


    for(var i=64;i<96;i++){
        str7=str7+"<td>"+nList[i]+"</td>"
        str8=str8+"<td>"+ListCPI[i]+"</td>"
        str9=str9+"<td>"+ListPPI[i]+"</td>"
    }
    str7=str7+"</tr>"
    str8=str8+"</tr>"
    str9=str9+"</tr><tr></tr>"
    for(var i=96;i<numListPPI.length;i++){
        str10=str10+"<td>"+nList[i]+"</td>"
        str11=str11+"<td>"+ListCPI[i]+"</td>"
        str12=str12+"<td>"+ListPPI[i]+"</td>"
    }
    str10=str10+"</tr>"
    str11=str11+"</tr>"
    str12=str12+"</tr>"

    document.getElementById("tbl").innerHTML=str1+str2+str3+str4+str5+str6+str7+str8+str9+str10+str11+str12+"</table>";
}

function graphicPPIandCPI(){
    var myChart = echarts.init(document.getElementById("graphicPPIandCPI"));
    option = {
        title: {
            text: '工业生产者出厂价格指数(PPI) && 居民消费价格指数(CPI)',
            subtext: '（上年同月=100）'
        },
        tooltip: {
            trigger: 'axis',

        },
        legend: {
            left:"center",
            data: ['PPI','CPI']
        },
        calculable: true,
        xAxis: [
            {
                boundaryGap : false,
                data:nameList,
                show: true,           //横坐标显示
            }
        ],
        yAxis: [
            {
            }
        ],
        series: [
            {
                name: 'CPI',
                type: 'line',
                data: numListCPI,
                itemStyle: {
                    normal: {
                        color:'#000cc3'
                    },
                    label: {
                        show: false,
                        position: 'on',
                        formatter: '{b}{c}',
                        textStyle: {
                            color: '#000000'
                        }
                    }
                }
            },
            {
                name: 'PPI',
                type: 'line',
                data: numListPPI,
                itemStyle: {
                    normal: {
                        color:'#c3239c'
                    },
                    label: {
                        normal: {
                            show: true,
                            position: '2007年01月'
                        }
                    }
                }
            }


        ]
    }
    myChart.setOption(option);
}
