/**
 * Created by Vikun on 2017/7/6.
 */
var nameList=[];//柱状图的nameList
var numListbtl=[];//柱状图的numList
var numListwti=[];//柱状图的numList
(function () {

    $.ajax({
        cache: false,
        url: "/zmq/queryKeyIndicatesCrude",
        type: "GET",
        dataType: "json",
        data: {},
        async: true,
        success: function (data) {
            nameList = data.nameList;
            numListbtl = data.numListbtl;
            numListwti = data.numListwti;
            graphicCrude();
            graphicTable10();
        }

    })
})();
function graphicTable10() {
    var str1 = "<table class='gridtable' border='1' cellspacing='0' cellpadding='0'><tr><td>日期</td>"
    var str2 = "<tr><td>布特伦</td>"
    var str3 = "<tr><td>wti</td>"
    nList = eval(nameList)
    Listbtl = eval(numListbtl)
    ListWTI = eval(numListwti )
    aList = []
    bList = []
    cList = []

    var count = 0
    for (var i = 0; i < nList.length; i++) {
        if ((i+1) % 15 == 0 && i > 0) {
            str1 = str1 + "<td>" + nList[i] + "</td>" + "</tr>"
            str2 = str2 + "<td>" + ListWTI[i] + "</td>" + "</tr>"
            str3 = str3 + "<td>" + Listbtl[i] + "</td>" + "</tr>"
            aList[count] = str1
            bList[count] = str2
            cList[count] = str3
            count += 1
            str1 = "<tr><td>日期</td>"
            str2 = "<tr><td>布特伦</td>"
            str3 = "<tr><td>wti</td>"
        } else {
            str1 = str1 + "<td>" + nList[i] + "</td>"
            str2 = str2 + "<td>" + ListWTI[i] + "</td>"
            str3 = str3 + "<td>" + Listbtl[i] + "</td>"
        }
    }

    var a = ""

    for (var i = 0; i < aList.length; i++) {
        a += aList[i]
        a += bList[i]
        a += cList[i]
    }
    document.getElementById("tbl").innerHTML = a + "</table>";
}
function graphicCrude(){
    var myChart = echarts.init(document.getElementById("graphicCrude"));
    option = {
        title: {
            text: '国际油价',
            subtext: '（上年同月=100）'
        },
        tooltip: {
            trigger: 'axis',

        },
        legend: {
            left:"center",
            data: ['布特伦','WTI']
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
                name: '布特伦',
                type: 'line',
                data: numListbtl,
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
            },
            {
                name: 'WTI',
                type: 'line',
                data: numListwti,
                itemStyle: {
                    normal: {
                        color:'#c3239c'
                    },
                    label: {
                        normal: {
                            show: true,
                        }
                    }
                }
            }


        ]
    }
    myChart.setOption(option);
}

