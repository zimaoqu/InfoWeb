/**
 * Created by Vikun on 2017/7/6.
 */
var nameList = [];//柱状图的nameList
var numList = [];//柱状图的numList
(function () {

    $.ajax({
        cache: false,
        url: "/zmq/queryKeyIndicatescopper",
        type: "GET",
        dataType: "json",
        data: {},
        async: true,
        success: function (data) {
            nameList = data.nameList;
            numList = data.numList;
            graphiccopper();
            graphicTable9();

        }

    })
})();
function graphicTable9() {
    var str1 = "<table class='gridtable' border='1' cellspacing='0' cellpadding='0'><tr><td width='60'>日期</td>"
    var str2 = "<tr><td width='60'>国际铜价</td>"
    nList = eval(nameList)
    ListGDP = eval(numList)
    aList = []
    bList = []
    var count = 0
    for (var i = 0; i < nList.length; i++) {
        if ((i + 1) % 14 == 0 && i > 0) {
            str1 = str1 + "<td width='60'>" + nList[i] + "</td>" + "</tr>"
            str2 = str2 + "<td width='60'>" + ListGDP[i] + "</td>" + "</tr>"
            aList[count] = str1
            bList[count] = str2
            count += 1
            str1 = "<tr><td width='60'>日期</td>"
            str2 = "<tr><td width='60'>国际铜价</td>"
        } else {
            str1 = str1 + "<td width='60'>" + nList[i] + "</td>"
            str2 = str2 + "<td width='60'>" + ListGDP[i] + "</td>"
        }
    }
    var a = ""

    for (var i = 0; i < aList.length; i++) {
        a += aList[i]
        a += bList[i]
    }
    document.getElementById("tbl").innerHTML = a + "</table>";
}
function graphiccopper() {
    var myChart = echarts.init(document.getElementById("graphiccopper"));
    option = {
        title: {
            text: '国际铜价',
            subtext: '（上年同月=100）'
        },
        tooltip: {
            trigger: 'axis',

        },
        legend: {
            left: "center",
            data: ['LME铜']
        },
        calculable: true,
        xAxis: [
            {
                boundaryGap: false,
                data: nameList,
                show: true,           //横坐标显示
            }
        ],
        yAxis: [
            {
                min: 5000,
                max: 9000
            }
        ],
        series: [
            {
                name: 'LME铜',
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
            }

        ]
    }
    myChart.setOption(option);
}
