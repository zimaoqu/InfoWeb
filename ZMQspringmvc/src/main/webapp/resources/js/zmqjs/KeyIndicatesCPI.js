/**
 * Created by Vikun on 2017/7/6.
 */
var nameList=[];//柱状图的nameList
var numList=[];//柱状图的numList
(function () {

    $.ajax({
        cache: false,
        url: "/zmq/queryKeyIndicatesCPI",
        type: "GET",
        dataType: "json",
        data: {},
        async: true,
        success: function (data) {
            numList = data.numList;
            nameList = data.nameList;
            graphicCPI();

        }

    })
})();

function graphicCPI(){
    var myChart = echarts.init(document.getElementById("graphicCPI"));
    option = {
        title: {
            text: '居民消费价格指数(CPI)',
            subtext: '（上年同月=100）'
        },
        tooltip: {
            trigger: 'axis',

        },
        legend: {
            x:'center',
            data: ['月份值']
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
            }
        ],
        series: [
            {
                name: 'CPI',
                type: 'line',
                step: 'start',
                data: numList,
                itemStyle: {
                    normal: {
                        color:'#5793F3'
                        },
                //
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