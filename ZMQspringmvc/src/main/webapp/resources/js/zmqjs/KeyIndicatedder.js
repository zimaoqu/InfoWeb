/**
 * Created by Vikun on 2017/7/6.
 */
var nameList=[];//柱状图的nameList
var numListPPI=[];//柱状图的numList
var numListCPI=[];//柱状图的numList
(function () {

    $.ajax({
        cache: false,
        url: "/zmq/queryKeyIndicatedder",
        type: "GET",
        dataType: "json",
        data: {},
        async: true,
        success: function (data) {
            nameList = data.nameList;
            numList = data.numList;
            graphicdder();
            graphicTable3()

        }

    })
})();
function graphicTable3(){
    var str1="<table  border='1' cellspacing='0' cellpadding='0'><tr><td>日期</td>"
    var str2="<tr ><td width='50'>收盘汇率</td>"
    numList=eval(numList);
    nameList=eval(nameList);
    for(var i=0; i<numList.length;i++){
        str1=str1+"<td width='50'>"+nameList[i]+"</td>"
        str2=str2+"<td width='50'>"+numList[i]+"</td>"
    }
    str1=str1+"</tr>"
    str2=str2+"</tr>"
    document.getElementById("tbl").innerHTML=str1+str2+"</table>";
}
function graphicdder(){
    var myChart = echarts.init(document.getElementById("graphicdder"));
    option = {
        title: {
            text: '美元兑人民币汇率',
            subtext: '（上年同月=100）'
        },
        tooltip: {
            trigger: 'axis',

        },
        legend: {
            left:"center",
            data: ['美元兑人民币汇率']
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
                name: '美元兑人民币汇率',
                type: 'line',
                data: numList,
                itemStyle: {
                    normal: {
                        color:'#468cc3'
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
            }

        ]
    }
    myChart.setOption(option);
}
