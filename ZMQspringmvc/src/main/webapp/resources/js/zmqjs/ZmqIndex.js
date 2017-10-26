/*
 * Created by Scorpion on 2017/10/24.
 */


var queryFlag = 1;
var tmp = '上海自贸区';
var currentDate = new Date();//获取系统当前时间
var endDate = new Date(currentDate.getTime() - 7 * 24 * 3600 * 1000);  //从系统时间开始算
//var endDate = DateToString(new Date(currentDate.getTime()-7*24*3600*1000));  //从系统时间开始算
//var startDate = DateToString(currentDate);
console.log(currentDate);

var gap = 7;
// var date1 = '2011-01-01';
// var date2 = '2017-10-20';
function changedate1() {
    endDate = new Date(currentDate.getTime() - 7 * 24 * 3600 * 1000);
    //endDate = DateToString(new Date(currentDate.getTime()-7*24*3600*1000));  //从系统时间开始算
    gap = 7;
    queryDataToCal();
}
function changedate2() {
    endDate = new Date(currentDate.getTime() - 30 * 24 * 3600 * 1000);
    //endDate = DateToString(new Date(currentDate.getTime()-30*24*3600*1000));
    gap = 30;
    queryDataToCal();
}

(function () {
    queryZmqIndex(1);
    queryMediaIndex();
    queryDataToCal();
})();

var List = new Array();
var mediaList = new Array();
var dateList = "";

var indexAll = null;
var indexMobile = null;
var overYear = null;//整体同比
var allCircle = null;//整体环比
var mobileYear = null;//移动同比
var mobileCircle = null;//移动环比
//网络关注度获取
function queryZmqIndex(queryFlag) {
    $.ajax({
        cache: false,
        url: "/zmq/queryZmqIndex",
        type: "GET",
        dataType: "json",
        data: {queryflag: queryFlag},
        async: true,
        success: function (data) {
            List = new Array();
            var result = data.indexList;
            dateList = data.dateList;

            for (var i = 0; i < result.length; i++) {
                List.push(result[i]);
            }
            graphic();
        }
    });
}
//媒体热度获取
function queryMediaIndex() {
    $.ajax({
        cache: false,
        url: "/zmq/queryZmqMediaIndex",
        type: "GET",
        dataType: "json",
        data: {},
        async: true,
        success: function (data) {
            mediaList = new Array();
            var result = data.mediaIndexList;
            dateList = data.dateList
            for (var i = 0; i < result.length; i++) {
                mediaList.push(result[i]);
            }
            graphic2();
        }
    });
}

function queryDataToCal() {
    $.ajax({
        cache: false,
        url: "/zmq/queryCalResult",
        type: "GET",
        dataType: "json",
        data: {tmp: tmp, startDate: endDate, endDate: currentDate, gap: gap},
        async: true,
        success: function (data) {
            indexAll = data.indexAll;
            indexMobile = data.indexMobile;
            overYear = data.overYear;
            allCircle = data.allCircle;
            mobileYear = data.mobileYear;
            mobileCircle = data.mobileCircle;
            editTable();
            // List = new Array();
            // var result = data.indexList;
            // dateList = data.dateList;
            //
            // for (var i = 0; i < result.length; i++) {
            //     List.push(result[i]);
            // }
            // graphic();
        }
    });
}
function allTrends() {
    queryFlag = 1;
    queryZmqIndex(queryFlag);
}
function pcTrends() {
    queryFlag = 2;
    queryZmqIndex(queryFlag);
}
function wiseTrends() {
    queryFlag = 3;
    queryZmqIndex(queryFlag);
}
function last7daysIndex() {
    tmp = $("#zmqName option:selected").text();
    queryDataToCal();
}
function last30daysIndex() {
    tmp = $("#zmqName2 option:selected").text();
    queryDataToCal();
}

function graphic() {
    // 基于准备好的dom，初始化echarts实例
    var myChart1 = null;
    var myChart2 = null;
    var myChart3 = null;

    if (queryFlag == 1)
        myChart1 = echarts.init(document.getElementById('main1'));
    if (queryFlag == 2)
        myChart2 = echarts.init(document.getElementById('main2'));
    if (queryFlag == 3)
        myChart3 = echarts.init(document.getElementById('main3'));


    var options = [
        <!--main1-->
        {
            tooltip: {
                trigger: 'axis'
            },
            legend: {
                data: ['上海', '河南', '福建', '浙江', '广东', '四川', '陕西', '湖北', '辽宁', '重庆', '天津'],
                left: '40%',
                selected: {
                    '河南': false,
                    '福建': false,
                    '浙江': false,
                    '广东': false,
                    '四川': false,
                    '陕西': false,
                    '湖北': false,
                    '辽宁': false,
                    '重庆': false,
                    '天津': false,
                },
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '3%',
                containLabel: true
            },
            toolbox: {
                show: true,
                feature: {
                    dataview: {
                        show: true,
                        readonly: true
                    },
                    saveAsImage: {
                        show: true
                    }
                }
            },
            dataZoom: [{
                type: 'inside',
                start: 90,
                end: 100
            }, {
                start: 0,
                end: 10,
                handleIcon: 'M10.7,11.9v-1.3H9.3v1.3c-4.9,0.3-8.8,4.4-8.8,9.4c0,5,3.9,9.1,8.8,9.4v1.3h1.3v-1.3c4.9-0.3,8.8-4.4,8.8-9.4C19.5,16.3,15.6,12.2,10.7,11.9z M13.3,24.4H6.7V23h6.6V24.4z M13.3,19.6H6.7v-1.4h6.6V19.6z',
                handleSize: '80%',
                handleStyle: {
                    color: '#fff',
                    shadowBlur: 3,
                    shadowColor: 'rgba(0, 0, 0, 0.6)',
                    shadowOffsetX: 2,
                    shadowOffsetY: 2
                }
            }],
            xAxis: [
                {
                    type: 'category',
                    boundaryGap: true,
                    data: dateList
                }

            ],
            yAxis: {
                type: 'value',
                name: '网络关注热度'
            },
            series: [
                {
                    name: '上海',
                    type: 'line',
                    smooth: true,
                    data: List[10]
                },
                {
                    name: '河南',
                    type: 'line',
                    smooth: true,
                    data: List[2]
                },
                {
                    name: '福建',
                    type: 'line',
                    smooth: true,
                    data: List[0]
                },
                {
                    name: '浙江',
                    type: 'line',
                    smooth: true,
                    data: List[8]
                },
                {
                    name: '广东',
                    type: 'line',
                    smooth: true,
                    data: List[1]
                },
                {
                    name: '四川',
                    type: 'line',
                    smooth: true,
                    data: List[6]
                },
                {
                    name: '陕西',
                    type: 'line',
                    smooth: true,
                    data: List[5]
                },
                {
                    name: '湖北',
                    type: 'line',
                    smooth: true,
                    data: List[3]
                },
                {
                    name: '辽宁',
                    type: 'line',
                    smooth: true,
                    data: List[4]
                },
                {
                    name: '重庆',
                    type: 'line',
                    smooth: true,
                    data: List[9]
                },
                {
                    name: '天津',
                    type: 'line',
                    smooth: true,
                    data: List[7]
                }
            ]
        },
        <!--main2-->
        {
            tooltip: {
                trigger: 'axis'
            },
            legend: {
                data: ['上海', '河南', '福建', '浙江', '广东', '四川', '陕西', '湖北', '辽宁', '重庆', '天津'],
                left: '40%',
                selected: {
                    '河南': false,
                    '福建': false,
                    '浙江': false,
                    '广东': false,
                    '四川': false,
                    '陕西': false,
                    '湖北': false,
                    '辽宁': false,
                    '重庆': false,
                    '天津': false,
                },
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '3%',
                containLabel: true
            },
            toolbox: {
                show: true,
                feature: {
                    dataview: {
                        show: true,
                        readonly: true
                    },
                    saveAsImage: {
                        show: true
                    }
                }
            },
            dataZoom: [{
                type: 'inside',
                start: 90,
                end: 100
            }, {
                start: 0,
                end: 10,
                handleIcon: 'M10.7,11.9v-1.3H9.3v1.3c-4.9,0.3-8.8,4.4-8.8,9.4c0,5,3.9,9.1,8.8,9.4v1.3h1.3v-1.3c4.9-0.3,8.8-4.4,8.8-9.4C19.5,16.3,15.6,12.2,10.7,11.9z M13.3,24.4H6.7V23h6.6V24.4z M13.3,19.6H6.7v-1.4h6.6V19.6z',
                handleSize: '80%',
                handleStyle: {
                    color: '#fff',
                    shadowBlur: 3,
                    shadowColor: 'rgba(0, 0, 0, 0.6)',
                    shadowOffsetX: 2,
                    shadowOffsetY: 2
                }
            }],
            xAxis: [
                {
                    type: 'category',
                    boundaryGap: true,
                    data: dateList
                }

            ],
            yAxis: {
                type: 'value',
                name: '网络关注热度'
            },
            series: [
                {
                    name: '上海',
                    type: 'line',
                    smooth: true,
                    data: List[10]
                },
                {
                    name: '河南',
                    type: 'line',
                    smooth: true,
                    data: List[2]
                },
                {
                    name: '福建',
                    type: 'line',
                    smooth: true,
                    data: List[0]
                },
                {
                    name: '浙江',
                    type: 'line',
                    smooth: true,
                    data: List[8]
                },
                {
                    name: '广东',
                    type: 'line',
                    smooth: true,
                    data: List[1]
                },
                {
                    name: '四川',
                    type: 'line',
                    smooth: true,
                    data: List[6]
                },
                {
                    name: '陕西',
                    type: 'line',
                    smooth: true,
                    data: List[5]
                },
                {
                    name: '湖北',
                    type: 'line',
                    smooth: true,
                    data: List[3]
                },
                {
                    name: '辽宁',
                    type: 'line',
                    smooth: true,
                    data: List[4]
                },
                {
                    name: '重庆',
                    type: 'line',
                    smooth: true,
                    data: List[9]
                },
                {
                    name: '天津',
                    type: 'line',
                    smooth: true,
                    data: List[7]
                }
            ]
        },
        <!--main3-->
        {
            tooltip: {
                trigger: 'axis'
            },
            legend: {
                data: ['上海', '河南', '福建', '浙江', '广东', '四川', '陕西', '湖北', '辽宁', '重庆', '天津'],
                left: '40%',
                selected: {
                    '河南': false,
                    '福建': false,
                    '浙江': false,
                    '广东': false,
                    '四川': false,
                    '陕西': false,
                    '湖北': false,
                    '辽宁': false,
                    '重庆': false,
                    '天津': false,
                },
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '3%',
                containLabel: true
            },
            toolbox: {
                show: true,
                feature: {
                    dataview: {
                        show: true,
                        readonly: true
                    },
                    saveAsImage: {
                        show: true
                    }
                }
            },
            dataZoom: [{
                type: 'inside',
                start: 90,
                end: 100
            }, {
                start: 0,
                end: 10,
                handleIcon: 'M10.7,11.9v-1.3H9.3v1.3c-4.9,0.3-8.8,4.4-8.8,9.4c0,5,3.9,9.1,8.8,9.4v1.3h1.3v-1.3c4.9-0.3,8.8-4.4,8.8-9.4C19.5,16.3,15.6,12.2,10.7,11.9z M13.3,24.4H6.7V23h6.6V24.4z M13.3,19.6H6.7v-1.4h6.6V19.6z',
                handleSize: '80%',
                handleStyle: {
                    color: '#fff',
                    shadowBlur: 3,
                    shadowColor: 'rgba(0, 0, 0, 0.6)',
                    shadowOffsetX: 2,
                    shadowOffsetY: 2
                }
            }],
            xAxis: [
                {
                    type: 'category',
                    boundaryGap: true,
                    data: dateList
                }

            ],
            yAxis: {
                type: 'value',
                name: '网络关注热度'
            },
            series: [
                {
                    name: '上海',
                    type: 'line',
                    smooth: true,
                    data: List[10]
                },
                {
                    name: '河南',
                    type: 'line',
                    smooth: true,
                    data: List[2]
                },
                {
                    name: '福建',
                    type: 'line',
                    smooth: true,
                    data: List[0]
                },
                {
                    name: '浙江',
                    type: 'line',
                    smooth: true,
                    data: List[8]
                },
                {
                    name: '广东',
                    type: 'line',
                    smooth: true,
                    data: List[1]
                },
                {
                    name: '四川',
                    type: 'line',
                    smooth: true,
                    data: List[6]
                },
                {
                    name: '陕西',
                    type: 'line',
                    smooth: true,
                    data: List[5]
                },
                {
                    name: '湖北',
                    type: 'line',
                    smooth: true,
                    data: List[3]
                },
                {
                    name: '辽宁',
                    type: 'line',
                    smooth: true,
                    data: List[4]
                },
                {
                    name: '重庆',
                    type: 'line',
                    smooth: true,
                    data: List[9]
                },
                {
                    name: '天津',
                    type: 'line',
                    smooth: true,
                    data: List[7]
                }
            ]
        },
        <!--main4-->


    ]

// 使用刚指定的配置项和数据显示图表。
    if (queryFlag == 1)
        myChart1.setOption(options[0]);
    if (queryFlag == 2)
        myChart2.setOption(options[1]);
    if (queryFlag == 3)
        myChart3.setOption(options[2]);

}
function graphic2() {
    var myChart4 = echarts.init(document.getElementById('main4'));
    var option = [{
        tooltip: {
            trigger: 'axis'
        },
        legend: {
            data: ['上海', '河南', '福建', '浙江', '广东', '四川', '陕西', '湖北', '辽宁', '重庆', '天津'],
            left: '40%',
            selected: {
                '河南': false,
                '福建': false,
                '浙江': false,
                '广东': false,
                '四川': false,
                '陕西': false,
                '湖北': false,
                '辽宁': false,
                '重庆': false,
                '天津': false,
            },
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        toolbox: {
            show: true,
            feature: {
                dataview: {
                    show: true,
                    readonly: true
                },
                saveAsImage: {
                    show: true
                }
            }
        },
        dataZoom: [{
            type: 'inside',
            start: 90,
            end: 100
        }, {
            start: 0,
            end: 10,
            handleIcon: 'M10.7,11.9v-1.3H9.3v1.3c-4.9,0.3-8.8,4.4-8.8,9.4c0,5,3.9,9.1,8.8,9.4v1.3h1.3v-1.3c4.9-0.3,8.8-4.4,8.8-9.4C19.5,16.3,15.6,12.2,10.7,11.9z M13.3,24.4H6.7V23h6.6V24.4z M13.3,19.6H6.7v-1.4h6.6V19.6z',
            handleSize: '80%',
            handleStyle: {
                color: '#fff',
                shadowBlur: 3,
                shadowColor: 'rgba(0, 0, 0, 0.6)',
                shadowOffsetX: 2,
                shadowOffsetY: 2
            }
        }],
        xAxis: [
            {
                type: 'category',
                boundaryGap: true,
                data: dateList
            }

        ],
        yAxis: {
            type: 'value',
            name: '媒体热度'
        },
        series: [
            {
                name: '上海',
                type: 'line',
                smooth: true,
                data: mediaList[10]
            },
            {
                name: '河南',
                type: 'line',
                smooth: true,
                data: mediaList[2]
            },
            {
                name: '福建',
                type: 'line',
                smooth: true,
                data: mediaList[0]
            },
            {
                name: '浙江',
                type: 'line',
                smooth: true,
                data: mediaList[8]
            },
            {
                name: '广东',
                type: 'line',
                smooth: true,
                data: mediaList[1]
            },
            {
                name: '四川',
                type: 'line',
                smooth: true,
                data: mediaList[6]
            },
            {
                name: '陕西',
                type: 'line',
                smooth: true,
                data: mediaList[5]
            },
            {
                name: '湖北',
                type: 'line',
                smooth: true,
                data: mediaList[3]
            },
            {
                name: '辽宁',
                type: 'line',
                smooth: true,
                data: mediaList[4]
            },
            {
                name: '重庆',
                type: 'line',
                smooth: true,
                data: mediaList[9]
            },
            {
                name: '天津',
                type: 'line',
                smooth: true,
                data: mediaList[7]
            }
        ]
    }]
    myChart4.setOption(option[0]);
}

function DateToString(date) {
    var year = date.getFullYear(); //获取完整的年份(4位,1970-????)
    var month = date.getMonth() + 1; //获取当前月份(0-11,0代表1月)
    var day = date.getDate(); //获取当前日(1-31)
    return year + "-" + month + "-" + day;
}
//指数概况
// var mydate1 = getDate(date2);
// var days7 = new Date(mydate1.getTime() - 7 * 24 * 3600 * 1000);   //7天前，从10-20 开始算
// var mydate2 = getDate(date2);
// var days30 = new Date(mydate2.getTime() - 30 * 24 * 3600 * 1000); //30天前，从10-20 开始算

/*
 *整体搜索指数和移动搜索指数
 * searchIndex = the sum of 7days' indexs / 7
 */
function editTable() {
    if (gap == 7) {
        $("#c1").html(indexAll);
        $("#c2").html(indexMobile);
        if (overYear > 0)
            $("#c5").html(overYear + "% ↑")
        else {
            $("#c5").html(overYear * -1 + "% ↓")
        }

        if (allCircle > 0)
            $("#c6").html(allCircle + "% ↑")
        else
            $("#c6").html(allCircle * -1 + "% ↓")
        if (mobileYear > 0)
            $("#c7").html(mobileYear + "% ↑")
        else
            $("#c7").html(mobileYear * -1 + "% ↓")
        if (mobileCircle > 0)
            $("#c8").html(mobileCircle + "% ↑")
        else
            $("#c8").html(mobileCircle * -1 + "% ↓")

    } else {
        $("#c3").html(indexAll);
        $("#c4").html(indexMobile);
        if (overYear > 0)
            $("#c9").html(overYear + "% ↑")
        else
            $("#c9").html(overYear * -1 + "% ↓")
        if (allCircle > 0)
            $("#c10").html(allCircle + "% ↑")
        else
            $("#c10").html(allCircle * -1 + "% ↓")
        if (mobileYear > 0)
            $("#c11").html(mobileYear + "% ↑")
        else
            $("#c11").html(mobileYear * -1 + "% ↓")
        if (mobileCircle > 0)
            $("#c12").html(mobileCircle + "% ↑")
        else
            $("#c12").html(mobileCircle * -1 + "% ↓")
    }

}
