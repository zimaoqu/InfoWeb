/**
 * Created by Vikun on 2017/7/6.
 */
var nameList = [];//柱状图的nameList
var numListPPI = [];//柱状图的numList
var numListCPI = [];//柱状图的numList
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

function graphicTable1() {
    var str1 = "<table class='gridtable' border='1' cellspacing='0' cellpadding='0'><tr><td>日期</td>"
    var str2 = "<tr><td>PPI</td>"
    var str3 = "<tr><td>CPI</td>"
    nList = eval(nameList)
    ListPPI = eval(numListPPI)
    ListCPI = eval(numListCPI)
    aList = []
    bList = []
    cList = []

    var count = 0
    for (var i = 0; i < nList.length; i++) {
        if ((i+1) % 15 == 0 && i > 0) {
            str1 = str1 + "<td>" + nList[i] + "</td>" + "</tr>"
            str2 = str2 + "<td>" + ListCPI[i] + "</td>" + "</tr>"
            str3 = str3 + "<td>" + ListPPI[i] + "</td>" + "</tr>"
            aList[count] = str1
            bList[count] = str2
            cList[count] = str3
            count += 1
            str1 = "<tr><td>日期</td>"
            str2 = "<tr><td>PPI</td>"
            str3 = "<tr><td>CPI</td>"
        } else {
            str1 = str1 + "<td>" + nList[i] + "</td>"
            str2 = str2 + "<td>" + ListCPI[i] + "</td>"
            str3 = str3 + "<td>" + ListPPI[i] + "</td>"
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

function graphicPPIandCPI() {
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
            left: "right",
            data: ['PPI', 'CPI']
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
            {}
        ],
        series: [
            {
                name: 'CPI',
                type: 'line',
                data: numListCPI,
                itemStyle: {
                    normal: {
                        color: '#000cc3'
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
                        color: '#c3239c'
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
