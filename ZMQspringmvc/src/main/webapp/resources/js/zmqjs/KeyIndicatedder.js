/**
 * Created by Vikun on 2017/7/6.
 */
var nameList = [];//柱状图的nameList
var numListPPI = [];//柱状图的numList
var numListCPI = [];//柱状图的numList
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
            num1List = data.num1List;
            console.log(num1List)
            graphicdder();
            graphicTable3()

        }

    })
})();
function graphicTable3() {
    var str1 = "<table class='gridtable' border='1' cellspacing='0' cellpadding='0'><tr><td width='90'>日期</td>"
    var str2 = "<tr><td width='90'>美元人民币汇率</td>"
    var str3 = "<tr><td width='90'>欧元人民币汇率</td>"
    nList = eval(nameList)
    ListGDP = eval(numList)
    ListBound=eval(num1List)
    aList = []
    bList = []
    cList = []
    var count = 0
    for (var i = 0; i < nList.length; i++) {
        if ((i+1) % 14== 0 && i > 0) {
            str1 = str1 + "<td width='90'>" + nList[i] + "</td>" + "</tr>"
            str2 = str2 + "<td width='90'>" + ListGDP[i] + "</td>" + "</tr>"
            str3 = str3 + "<td width='90'>" + ListBound[i] + "</td>" + "</tr>"
            aList[count] = str1
            bList[count] = str2
            cList[count] =str3
            count += 1
            str1 = "<tr><td width='90'>日期</td>"
            str2 = "<tr><td width='90'>美元人民币汇率</td>"
            str3 = "<tr><td width='90'>欧元人民币汇率</td>"
        } else {
            str1 = str1 + "<td width='90'>" + nList[i] + "</td>"
            str2 = str2 + "<td width='90'>" + ListGDP[i] + "</td>"
            str3 = str3 + "<td width='90'>" + ListBound[i] + "</td>"
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
function graphicdder() {
    var myChart = echarts.init(document.getElementById("graphicdder"));
    option = {
        title: {
            text: '人民币汇率中间价',
            subtext: '（上年同月=100）'
        },
        tooltip: {
            trigger: 'axis',

        },
        legend: {
            left: "center",
            data: ['美元兑-人民币','欧元兑-人民币']
        },
        calculable: true,
        xAxis: [
            {
                // boundaryGap: false,
                data: nameList,
                show: true,           //横坐标显示
            }
        ],
        yAxis: [
            {
                type: 'value',
                // boundaryGap: [0, '100%'],
                // data:nameList,
                show: true,           //纵坐标显示
            }
        ],
        series: [
            {
                name: '美元兑-人民币',
                type: 'line',
                data: numList,
                itemStyle: {
                    normal: {
                        color: '#468cc3'
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
                name: '欧元兑-人民币',
                type: 'line',
                data: num1List,
                itemStyle: {
                    normal: {
                        color: '#F621c3'
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
