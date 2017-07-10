/**
 * Created by Vikun on 2017/7/6.
 */
var nameList=[];//柱状图的nameList
var numList=[];//柱状图的numList
(function () {

    $.ajax({
        cache: false,
        url: "/zmq/queryKeyIndicatesExportImport",
        type: "GET",
        dataType: "json",
        data: {},
        async: true,
        success: function (data) {
            numList = data.numList;
            nameList = data.nameList;
            graphicExportImport();

        }

    })
})();

function graphicExportImport(){
    var myChart = echarts.init(document.getElementById("graphicExportImport"));
    option = {
        title: {
            text: '进出口总额',
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
                // type: 'value',

                // data:nameList,
                //  show: true,           //纵坐标显示
            }
        ],
        series: [
            {
                name: '进出口总额',
                type: 'line',
                data: numList,
                itemStyle: {
                    normal: {
                        color:'#0db2c3'
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
            }]
    }
    myChart.setOption(option);
}