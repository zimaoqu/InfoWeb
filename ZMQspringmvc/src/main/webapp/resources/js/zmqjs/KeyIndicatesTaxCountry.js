/**
 * Created by Vikun on 2017/7/6.
 */
var nameList=[];//柱状图的nameList
var numList=[];//柱状图的numList
(function () {

    $.ajax({
        cache: false,
        url: "/zmq/queryKeyIndicatesTaxCountry",
        type: "GET",
        dataType: "json",
        data: {},
        async: true,
        success: function (data) {
            numList = data.numList;
            nameList = data.nameList;
            graphicTaxCountry();
            graphicTable8();
        }
    })
})();
function graphicTable8(){
    var str1 = "<table class='gridtable' border='1' cellspacing='0' cellpadding='0'><tr><td width='60'>日期</td>"
    var str2 = "<tr><td width='60'>税务部门税收总额</td>"
    nList = eval(nameList)
    ListGDP = eval(numList)
    aList = []
    bList = []
    var count = 0
    for (var i = 0; i < nList.length; i++) {
        if ((i+1) % 15 == 0 && i > 0) {
            str1 = str1 + "<td width='60'>" + nList[i] + "</td>" + "</tr>"
            str2 = str2 + "<td width='60'>" + ListGDP[i] + "</td>" + "</tr>"
            aList[count] = str1
            bList[count] = str2
            count += 1
            str1 = "<tr><td width='60'>日期</td>"
            str2 = "<tr><td width='60'>税务部门税收总额</td>"
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
function graphicTaxCountry(){
    var myChart = echarts.init(document.getElementById("graphicTaxCountry"));
    option = {
        title: {
            text: '全国税收总额',
        },
        tooltip: {},
        legend: {
            left:'center',
            data: ['季度值(单位：亿元 )']
        },
        toolbox: {
            show: true,
        },
        calculable: true,
        xAxis: [
            {
                data:nameList,
                show: true,           //横坐标显示
            }
        ],
        yAxis: [
            {
                // data:nameList,
                // show: true,           //纵坐标显示
            }
        ],
        series: [
            {
                name: '全国税收总额',
                type: 'bar',
                barwidth:'30%',
                data: numList,
                itemStyle: {
                    normal: {
                        color: function (params) {
                            // build a color map as your need.
                            var colorList = [
                                '#5E5AAE', '#B5C334', '#FCCE10', '#E87C25',
                                '#5E5AAE', '#B5C334', '#FCCE10', '#E87C25',
                                '#5E5AAE', '#B5C334', '#FCCE10', '#E87C25',
                                '#5E5AAE', '#B5C334', '#FCCE10', '#E87C25',
                                '#5E5AAE', '#B5C334', '#FCCE10', '#E87C25',
                                '#5E5AAE', '#B5C334', '#FCCE10', '#E87C25',
                                '#5E5AAE', '#B5C334', '#FCCE10', '#E87C25',
                                '#5E5AAE', '#B5C334', '#FCCE10', '#E87C25',
                                '#5E5AAE', '#B5C334', '#FCCE10', '#E87C25',
                                '#5E5AAE', '#B5C334', '#FCCE10', '#E87C25',
                                '#5E5AAE', '#B5C334', '#FCCE10', '#E87C25',
                                '#5E5AAE', '#B5C334', '#FCCE10', '#E87C25',



                            ];
                            return colorList[params.dataIndex]
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
            }]
    }
    myChart.setOption(option);
}