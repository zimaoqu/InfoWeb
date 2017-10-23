/**
 * Created by Scorpion on 2017/10/24.
 */


var queryFlag = 1;
var myDate = new Date();//获取系统当前时间
var year = myDate.getFullYear(); //获取完整的年份(4位,1970-????)
var month = myDate.getMonth() + 1; //获取当前月份(0-11,0代表1月)
var day = myDate.getDate(); //获取当前日(1-31)
var gap = 7;
var date1 = '2011-01-01';
var date2 = '2017-10-20';
function changedate1() {
    gap=7;
}
function changedate2() {
    gap=30;
}

(function () {
    queryZmqIndex(1);
})();

var List = new Array();
var dateList = ""
function queryZmqIndex(queryFlag) {
    $.ajax({
        cache: false,
        url: "/zmq/queryZmqIndex",
        type: "GET",
        dataType: "json",
        data: {queryflag: queryFlag, startDate: date1, endDate: date2},
        async: true,
        success: function (data) {
            List = new Array();
            var result = data.indexList;
            dateList = data.dateList;

            for(var i = 0;i<result.length;i++){
                List.push(result[i]);
            }
            graphic();
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



function graphic() {
    // 基于准备好的dom，初始化echarts实例
    var myChart1=null;
    var myChart2=null;
    var myChart3=null;
    var myChart4 = echarts.init(document.getElementById('main4'));
    if(queryFlag==1)
        myChart1 = echarts.init(document.getElementById('main1'));
    if(queryFlag==2)
        myChart2 = echarts.init(document.getElementById('main2'));
    if(queryFlag==3)
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
                name: '搜索指数'
            },
            series: [
                {
                    name: '上海',
                    type: 'line',
                    data: List[10]
                },
                {
                    name: '河南',
                    type: 'line',
                    data: List[2]
                },
                {
                    name: '福建',
                    type: 'line',
                    data: List[0]
                },
                {
                    name: '浙江',
                    type: 'line',
                    data: List[8]
                },
                {
                    name: '广东',
                    type: 'line',
                    data: List[1]
                },
                {
                    name: '四川',
                    type: 'line',
                    data: List[6]
                },
                {
                    name: '陕西',
                    type: 'line',
                    data: List[5]
                },
                {
                    name: '湖北',
                    type: 'line',
                    data: List[3]
                },
                {
                    name: '辽宁',
                    type: 'line',
                    data: List[4]
                },
                {
                    name: '重庆',
                    type: 'line',
                    data: List[9]
                },
                {
                    name: '天津',
                    type: 'line',
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
                name: '搜索指数'
            },
            series: [
                {
                    name: '上海',
                    type: 'line',
                    data: List[10]
                },
                {
                    name: '河南',
                    type: 'line',
                    data: List[2]
                },
                {
                    name: '福建',
                    type: 'line',
                    data: List[0]
                },
                {
                    name: '浙江',
                    type: 'line',
                    data: List[8]
                },
                {
                    name: '广东',
                    type: 'line',
                    data: List[1]
                },
                {
                    name: '四川',
                    type: 'line',
                    data: List[6]
                },
                {
                    name: '陕西',
                    type: 'line',
                    data: List[5]
                },
                {
                    name: '湖北',
                    type: 'line',
                    data: List[3]
                },
                {
                    name: '辽宁',
                    type: 'line',
                    data: List[4]
                },
                {
                    name: '重庆',
                    type: 'line',
                    data: List[9]
                },
                {
                    name: '天津',
                    type: 'line',
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
                name: '搜索指数'
            },
            series: [
                {
                    name: '上海',
                    type: 'line',
                    data: List[10]
                },
                {
                    name: '河南',
                    type: 'line',
                    data: List[2]
                },
                {
                    name: '福建',
                    type: 'line',
                    data: List[0]
                },
                {
                    name: '浙江',
                    type: 'line',
                    data: List[8]
                },
                {
                    name: '广东',
                    type: 'line',
                    data: List[1]
                },
                {
                    name: '四川',
                    type: 'line',
                    data: List[6]
                },
                {
                    name: '陕西',
                    type: 'line',
                    data: List[5]
                },
                {
                    name: '湖北',
                    type: 'line',
                    data: List[3]
                },
                {
                    name: '辽宁',
                    type: 'line',
                    data: List[4]
                },
                {
                    name: '重庆',
                    type: 'line',
                    data: List[9]
                },
                {
                    name: '天津',
                    type: 'line',
                    data: List[7]
                }
            ]
        },
        <!--main4-->
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
            xAxis: [
                {
                    type: 'category',
                    boundaryGap: true,
                    data: function () {
                        var list = [];
                        var myDate = new Date();//获取系统当前时间
                        var year = myDate.getFullYear(); //获取完整的年份(4位,1970-????)
                        var month = myDate.getMonth() + 1; //获取当前月份(0-11,0代表1月)
                        var day = myDate.getDate(); //获取当前日(1-31)
                        for (var i = 1; i <= 7; i++) {
                            list.push(year + '-' + month + '-' + (day - 7 + i));
                        }
                        return list;
                    }()
                }
            ],
            yAxis: {
                type: 'value',
                name: '媒体指数'
            },
            series: [
                {
                    name: '上海',
                    type: 'line',
                    data: function () {
                        var list = [];
                        for (var i = 1; i <= 7; i++) {
                            list.push(Math.round(Math.random() * 30) + 7);
                        }
                        return list;
                    }()
                },
                {
                    name: '河南',
                    type: 'line',
                    data: function () {
                        var list = [];
                        for (var i = 1; i <= 7; i++) {
                            list.push(Math.round(Math.random() * 30) + 7);
                        }
                        return list;
                    }()
                },
                {
                    name: '福建',
                    type: 'line',
                    data: function () {
                        var list = [];
                        for (var i = 1; i <= 7; i++) {
                            list.push(Math.round(Math.random() * 30) + 7);
                        }
                        return list;
                    }()
                },
                {
                    name: '浙江',
                    type: 'line',
                    data: function () {
                        var list = [];
                        for (var i = 1; i <= 7; i++) {
                            list.push(Math.round(Math.random() * 30) + 7);
                        }
                        return list;
                    }()
                },
                {
                    name: '广东',
                    type: 'line',
                    data: function () {
                        var list = [];
                        for (var i = 1; i <= 7; i++) {
                            list.push(Math.round(Math.random() * 30) + 7);
                        }
                        return list;
                    }()
                },
                {
                    name: '四川',
                    type: 'line',
                    data: function () {
                        var list = [];
                        for (var i = 1; i <= 7; i++) {
                            list.push(Math.round(Math.random() * 30) + 7);
                        }
                        return list;
                    }()
                },
                {
                    name: '陕西',
                    type: 'line',
                    data: function () {
                        var list = [];
                        for (var i = 1; i <= 7; i++) {
                            list.push(Math.round(Math.random() * 30) + 7);
                        }
                        return list;
                    }()
                },
                {
                    name: '湖北',
                    type: 'line',
                    data: function () {
                        var list = [];
                        for (var i = 1; i <= 7; i++) {
                            list.push(Math.round(Math.random() * 30) + 7);
                        }
                        return list;
                    }()
                },
                {
                    name: '辽宁',
                    type: 'line',
                    data: function () {
                        var list = [];
                        for (var i = 1; i <= 7; i++) {
                            list.push(Math.round(Math.random() * 30) + 7);
                        }
                        return list;
                    }()
                },
                {
                    name: '重庆',
                    type: 'line',
                    data: function () {
                        var list = [];
                        for (var i = 1; i <= 7; i++) {
                            list.push(Math.round(Math.random() * 30) + 7);
                        }
                        return list;
                    }()
                },
                {
                    name: '天津',
                    type: 'line',
                    data: function () {
                        var list = [];
                        for (var i = 1; i <= 7; i++) {
                            list.push(Math.round(Math.random() * 30) + 7);
                        }
                        return list;
                    }()
                }
            ]
        },

    ]

// 使用刚指定的配置项和数据显示图表。
    if(queryFlag==1)
        myChart1.setOption(options[0]);
    if(queryFlag==2)
        myChart2.setOption(options[1]);
    if(queryFlag==3)
        myChart3.setOption(options[2]);
    myChart4.setOption(options[3]);
}

