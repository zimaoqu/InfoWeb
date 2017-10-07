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
        }
    })
})();

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