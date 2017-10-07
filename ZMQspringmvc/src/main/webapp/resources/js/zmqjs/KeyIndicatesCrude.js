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

        }

    })
})();

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

