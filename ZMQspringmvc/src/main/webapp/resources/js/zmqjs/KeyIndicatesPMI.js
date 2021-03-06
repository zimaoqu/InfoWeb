/**
 * Created by Vikun on 2017/7/6.
 */
var nameList=[];//柱状图的nameList
var numList=[];//柱状图的numList
(function () {

    $.ajax({
        cache: false,
        url: "/zmq/queryKeyIndicatesPMI",
        type: "GET",
        dataType: "json",
        data: {},
        async: true,
        success: function (data) {
            numList = data.numList;
            nameList = data.nameList;
            graphicPMI();
            graphicTable4()
        }

    })
})();
function graphicTable4(){
    var str1 = "<table class='gridtable' border='1' cellspacing='0' cellpadding='0'><tr><td width='60'>日期</td>"
    var str2 = "<tr><td width='60'>PMI指数</td>"
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
            str2 = "<tr><td width='60'>PMI指数</td>"
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
function graphicPMI(){
    var myChart = echarts.init(document.getElementById("graphicPMI"));
    option = {
        title: {
            text: '食品制造业工业生产者出厂价格指数(PMI)',
            // subtext: '（上年=100）'
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
            data: ['每日值'],
            show:true
        },
        calculable: true,
        xAxis: [
            {
                type: 'category',
                boundaryGap : false,  //端空白,即图形从0开始
                data:nameList,
                show: true,           //横坐标显示（默认）
            }
        ],
        yAxis: [
            {
                type: 'value',
                min:45,
                max:55,
                show: true,           //纵坐标显示
            }
        ],
        series: [
            {
                name: 'PMI',
                type: 'line',
                smooth:true,   //去掉圆点，让曲线变得平滑
                areaStyle: {normal: {}},
                data: numList,
                itemStyle: {
                    normal: {
                        color:'rgb(255, 70, 131)'
                    },
                    areaStyle: {    //轴体颜色渐变
                        normal: {
                            color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                                offset: 0,
                                color: 'rgb(255, 158, 68)'
                            }, {
                                offset: 1,
                                color: 'rgb(255, 70, 131)'
                            }])
                        }
                    }
                    //     label: {
                    //             show: false,
                    //             position: 'on',
                    //             formatter: '{b}{c}',
                    //             textStyle: {
                    //                 color: '#000000'
                    //             }
                    //     }
                }
            }]
    }
    myChart.setOption(option);
}