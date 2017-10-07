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

        }

    })
})();

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