/**
 * Created by Vikun on 2017/7/6.
 */
var nameList=[];//柱状图的nameList
var numList=[];//柱状图的numList
(function () {

    $.ajax({
        cache: false,
        url: "/zmq/queryKeyIndicatesTRSCG",
        type: "GET",
        dataType: "json",
        data: {},
        async: true,
        success: function (data) {
            numList = data.numList;
            nameList = data.nameList;
            graphicTRSCG();
            graphicTable2();

        }

    })
})();
function graphicTable2(){
    var str1="<table  border='1' cellspacing='0' cellpadding='0'><tr><td>日期</td>"
    var str2="<tr ><td width='50'>社会消费品零售总额</td>"
    numList=eval(numList);
    nameList=eval(nameList);
    for(var i=0; i<numList.length;i++){
        str1=str1+"<td width='50'>"+nameList[i]+"</td>"
        str2=str2+"<td width='50'>"+numList[i]+"</td>"
    }
    str1=str1+"</tr>"
    str2=str2+"</tr>"
    document.getElementById("tbl").innerHTML=str1+str2+"</table>";
}

function graphicTRSCG(){
    var myChart = echarts.init(document.getElementById("graphicTRSCG"));
    option = {
        title: {
            text: '社会消费品零售总额',
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
            data: ['年']
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
                name: '社会消费品零售总额',
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