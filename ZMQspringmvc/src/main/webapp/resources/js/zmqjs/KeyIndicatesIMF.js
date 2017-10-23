/**
 * Created by Vikun on 2017/7/6.
 */
var nameList=[];//柱状图的nameList
var numList=[];//柱状图的numList
(function () {

    $.ajax({
        cache: false,
        url: "/zmq/queryKeyIndicatesIMF",
        type: "GET",
        dataType: "json",
        data: {},
        async: true,
        success: function (data) {
            nameList = data.nameList;
            China = data.China;
            developing=data.developing;
            Advanced=data.Advanced;
            world=data.world;
            graphicIMF();
            graphicTable14()

        }

    })
})();
function graphicTable14(){
    var str1 = "<table class='gridtable' border='1' cellspacing='0' cellpadding='0'><tr><td width='60'>日期</td>"
    var str2 = "<tr><td width='60'>中国</td>"
    var str3 = "<tr><td width='60'>发展中国家</td>"
    var str4 = "<tr><td width='60'>发达国家</td>"
    var str5 = "<tr><td width='60'>世界</td>"
    nList = eval(nameList)
    ListChina = eval(China)
    ListDeveloping = eval(developing)
    ListAdvanced=eval(Advanced)
    ListWorld=eval(world)
    aList = []
    bList = []
    cList = []
    dList = []
    eList = []

    var count = 0
    for (var i = 0; i < nList.length; i++) {
        if ((i+1) % 15 == 0 && i > 0) {
            str1 = str1 + "<td width='60'>" + nList[i] + "</td>" + "</tr>"
            str2 = str2 + "<td width='60'>" + ListChina[i] + "</td>" + "</tr>"
            str3 = str3 + "<td width='60'>" + ListDeveloping[i] + "</td>" + "</tr>"
            str4= str4 + "<td width='60'>" + ListAdvanced[i] + "</td>" + "</tr>"
            str5= str5 + "<td width='60'>" + ListWorld[i] + "</td>" + "</tr>"
            aList[count] = str1
            bList[count] = str2
            cList[count] = str3
            dList[count] = str4
            eList[count] = str5
            count += 1
            str1 = "<tr><td width='60'>日期</td>"
            str2 = "<tr><td width='60'>中国</td>"
            str3 = "<tr><td width='60'>发展中国家</td>"
            str4 = "<tr><td width='60'>发达国家</td>"
            str5 = "<tr><td width='60'>世界</td>"

        } else {
            str1 = str1 + "<td width='60'>" + nList[i] + "</td>"
            str2 = str2 + "<td width='60'>" + ListChina[i] + "</td>"
            str3 = str3 + "<td width='60'>" + ListDeveloping[i] + "</td>"
            str4 = str4 + "<td width='60'>" + ListAdvanced[i] + "</td>"
            str5 = str5 + "<td width='60'>" + ListWorld[i] + "</td>"
        }
    }

    var a = ""

    for (var i = 0; i < aList.length; i++) {
        a += aList[i]
        a += bList[i]
        a += cList[i]
        a += dList[i]
        a += eList[i]
    }
    document.getElementById("tbl").innerHTML = a + "</table>";
}
function graphicIMF(){
    var myChart = echarts.init(document.getElementById("graphicIMF"));
    option = {
        title: {
            text: 'IMF经济增长预期',
            subtext: '（上年=100）'
        },
        tooltip: {
            trigger: 'axis',
            // axisPointer: {    //横线
            //     type: 'cross',
            //     label: {
            //         backgroundColor: '#6a7985'
            //     }
            // }
        },
        legend: {
            left:'center',
            data: ['中国','发展中国家','发达国家','发达国家','世界']
        },
        calculable: true,
        xAxis: [
            {
                type: 'category',
                boundaryGap : false,
                data:nameList,
                show: true,           //横坐标显示
            }
        ],
        yAxis: [
            {
                // type: 'value',

                // data:nameList,
                //  show: true,           //纵坐标显示
            }
        ],
        series: [
            {
                name: '中国',
                type: 'line',
                data: China,
                itemStyle: {
                    normal: {
                        color:'red'
                    },
                    // label: {
                    //         show: false,
                    //         position: 'on',
                    //         formatter: '{b}{c}',
                    //         textStyle: {
                    //             color: '#000000'
                    //         }
                    // }
                }
            },
            {
                name: '发展中国家',
                type: 'line',
                data: developing,
                itemStyle: {
                    normal: {
                        color: 'blue'
                    },
                    // label: {
                    //         show: false,
                    //         position: 'on',
                    //         formatter: '{b}{c}',
                    //         textStyle: {
                    //             color: '#000000'
                    //         }
                    // }
                }
            },
            {
                name: '发达国家',
                type: 'line',
                data: Advanced,
                itemStyle: {
                    normal: {
                        color: 'yellow'
                    },
                    // label: {
                    //         show: false,
                    //         position: 'on',
                    //         formatter: '{b}{c}',
                    //         textStyle: {
                    //             color: '#000000'
                    //         }
                    // }
                }
            },
            {
                name: '世界',
                type: 'line',
                data: world,
                itemStyle: {
                    normal: {
                        color: 'purple'
                    },
                    // label: {
                    //         show: false,
                    //         position: 'on',
                    //         formatter: '{b}{c}',
                    //         textStyle: {
                    //             color: '#000000'
                    //         }
                    // }
                }
            },

        ]
    }
    myChart.setOption(option);
}