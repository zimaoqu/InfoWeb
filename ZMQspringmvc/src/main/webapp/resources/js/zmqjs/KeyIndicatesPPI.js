/**
 * Created by Vikun on 2017/7/6.
 */
var nameList=[];//柱状图的nameList
var numListPPI=[];//柱状图的numList
var numListCPI=[];//柱状图的numList
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

        }

    })
})();

function graphicPPIandCPI(){
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
            left:"center",
            data: ['PPI','CPI']
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
                name: 'CPI',
                type: 'line',
                data: numListCPI,
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
                name: 'PPI',
                type: 'line',
                data: numListPPI,
                itemStyle: {
                    normal: {
                        color:'#c3239c'
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
