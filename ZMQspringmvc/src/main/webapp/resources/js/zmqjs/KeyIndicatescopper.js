/**
 * Created by Vikun on 2017/7/6.
 */
var nameList=[];//柱状图的nameList
var numList=[];//柱状图的numList
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


        }

    })
})();

function graphiccopper(){
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
            left:"center",
            data: ['LME铜']
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
                name: 'LME铜',
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
