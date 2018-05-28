(function () {
    graphicPMI();
    graphicPPI();
    graphicZMQJYPMI();
    graphicZMQJYPPI();
    graphicZMQJCKPMI();
    graphicZMQJCKPPI();
    graphic();
})();

function graphicPMI() {
    var myChart = echarts.init(document.getElementById("graphicPMI"));
    option = {
        title : {
            text: '航运物流服务收入（亿元）与PMI之间的时差相关系数值',
        },
        tooltip : {
            trigger: 'axis'
        },
        legend: {
            data:['','']
        },
        toolbox: {
            show : true,
            feature : {
                mark : {show: true},
                dataView : {show: true, readOnly: false},
                magicType : {show: true, type: ['line', 'bar']},
                restore : {show: true},
                saveAsImage : {show: true}
            }
        },
        calculable : true,
        xAxis : [
            {
                type : 'category',
                boundaryGap : false,
                data : ['-6','-5','-4','-3','-2','-1','0','1','2','3','4','5','6']
            }
        ],
        yAxis : [
            {
                type : 'value',
            }
        ],
        series : [
            {
                name:'PMI',
                type:'line',
                data:[0,0.084331383259422202, 0.077722296794268175,
                    0.16385603025276277, 0.35068999279519358,
                    0.49964715355593026, 0.67935434201950784,
                    0.52660823953785674, 0.38114847439029065,
                    0.21646247529511509, -0.003088566766071674,
                    -0.044395737196996903],
            },
        ]
    };
    myChart.setOption(option);
}

function graphicPPI() {
    var myChart = echarts.init(document.getElementById("graphicPPI"));
    option = {
        title : {
            text: '航运物流服务收入（亿元）与PPI之间的时差相关系数值',
        },
        tooltip : {
            trigger: 'axis'
        },
        legend: {
            data:['','']
        },
        toolbox: {
            show : true,
            feature : {
                mark : {show: true},
                dataView : {show: true, readOnly: false},
                magicType : {show: true, type: ['line', 'bar']},
                restore : {show: true},
                saveAsImage : {show: true}
            }
        },
        calculable : true,
        xAxis : [
            {
                type : 'category',
                boundaryGap : false,
                data : ['-6','-5','-4','-3','-2','-1','0','1','2','3','4','5','6']
            }
        ],
        yAxis : [
            {
                type : 'value',
            }
        ],
        series : [
            {
                name:'PMI',
                type:'line',
                data:[0, 0.20812037936101332, 0.34337653987248756, 0.49046918661700267,
                    0.27687287649088627, 0.48809812975873368, 0.26943987242174822,
                    0.067548516590997421, -0.28786644274216189, -0.1729533434021589,
                    -0.33342972094820189, -0.32351623132830459],
            },
        ]
    };
    myChart.setOption(option);
}
function graphicZMQJYPMI() {
    var myChart = echarts.init(document.getElementById("graphicZMQJYPMI"));
    option = {
        title : {
            text: '自贸区经营总收入（亿元）与PMI之间的时差相关系数值',
        },
        tooltip : {
            trigger: 'axis'
        },
        legend: {
            data:['','']
        },
        toolbox: {
            show : true,
            feature : {
                mark : {show: true},
                dataView : {show: true, readOnly: false},
                magicType : {show: true, type: ['line', 'bar']},
                restore : {show: true},
                saveAsImage : {show: true}
            }
        },
        calculable : true,
        xAxis : [
            {
                type : 'category',
                boundaryGap : false,
                data : ['-6','-5','-4','-3','-2','-1','0','1','2','3','4','5','6']
            }
        ],
        yAxis : [
            {
                type : 'value',
            }
        ],
        series : [
            {
                name:'PMI',
                type:'line',
                data:[-0.05774887748892372, -0.008814737555805944, -0.020561144293388397,
                    0.09042910714306307, 0.021461945924681553, 0.28442800899123133,
                    0.14314928668410354, -0.195346303629256, -0.2041968097263504,
                    -0.2202412952022017, -0.18428636713186403],
            },
        ]
    };
    myChart.setOption(option);
}
function graphicZMQJYPPI() {
    var myChart = echarts.init(document.getElementById("graphicZMQJYPPI"));
    option = {
        title : {
            text: '自贸区经营总收入（亿元）与PPI之间的时差相关系数值',
        },
        tooltip : {
            trigger: 'axis'
        },
        legend: {
            data:['','']
        },
        toolbox: {
            show : true,
            feature : {
                mark : {show: true},
                dataView : {show: true, readOnly: false},
                magicType : {show: true, type: ['line', 'bar']},
                restore : {show: true},
                saveAsImage : {show: true}
            }
        },
        calculable : true,
        xAxis : [
            {
                type : 'category',
                boundaryGap : false,
                data : ['-6','-5','-4','-3','-2','-1','0','1','2','3','4','5','6']
            }
        ],
        yAxis : [
            {
                type : 'value',
            }
        ],
        series : [
            {
                name:'PPI',
                type:'line',
                data:[0.11668072742834491, 0.14886307571394644, 0.1272128236592018,
                    0.03339790607604686, 0.017322663595328112, 0.2325773371636141,
                    0.09122751849628594, 0.12111708676575073, 0.1324189011761638,
                    0.12180985409076442, 0.09209268236890206],
            },
        ]
    };
    myChart.setOption(option);
}
function graphicZMQJCKPMI() {
    var myChart = echarts.init(document.getElementById("graphicZMQJCKPMI"));
    option = {
        title : {
            text: '自贸区进出口贸易收入（亿元）与PMI之间的时差相关系数值',
        },
        tooltip : {
            trigger: 'axis'
        },
        legend: {
            data:['','']
        },
        toolbox: {
            show : true,
            feature : {
                mark : {show: true},
                dataView : {show: true, readOnly: false},
                magicType : {show: true, type: ['line', 'bar']},
                restore : {show: true},
                saveAsImage : {show: true}
            }
        },
        calculable : true,
        xAxis : [
            {
                type : 'category',
                boundaryGap : false,
                data : ['-6','-5','-4','-3','-2','-1','0','1','2','3','4','5','6']
            }
        ],
        yAxis : [
            {
                type : 'value',
            }
        ],
        series : [
            {
                name:'PMI',
                type:'line',
                data:[-0.10854341507545584, 0.05781381627450166, 0.05883206340534906,
                    0.2001694580468081, 0.22958639468052647,
                    0.46, 0.3322103491515386, 0.003293673532805262, -0.17417916016396362,
                    -0.1224442719657253, -0.28234973544585706],
            },
        ]
    };
    myChart.setOption(option);
}
function graphicZMQJCKPPI() {
    var myChart = echarts.init(document.getElementById("graphicZMQJCKPPI"));
    option = {
        title : {
            text: '自贸区进出口贸易收入（亿元）与PPI之间的时差相关系数值',
        },
        tooltip : {
            trigger: 'axis'
        },
        legend: {
            data:['','']
        },
        toolbox: {
            show : true,
            feature : {
                mark : {show: true},
                dataView : {show: true, readOnly: false},
                magicType : {show: true, type: ['line', 'bar']},
                restore : {show: true},
                saveAsImage : {show: true}
            }
        },
        calculable : true,
        xAxis : [
            {
                type : 'category',
                boundaryGap : false,
                data : ['-6','-5','-4','-3','-2','-1','0','1','2','3','4','5','6']
            }
        ],
        yAxis : [
            {
                type : 'value',
            }
        ],
        series : [
            {
                name:'PPI',
                type:'line',
                data:[0.06679259453978809, 0.026017246900964647, -0.005900971460260481, 0.05455238784090766, -0.19929816210268453,
                    0.46, -0.17587522199200362, -0.16285651994655692, -0.11075110446006663,
                    0.03399228065914372, 0.04095056911093915],
            },
        ]
    };
    myChart.setOption(option);
}

function graphic() {
    var myChart = echarts.init(document.getElementById("graphic"));
    option = {
        title : {
            text: 'PMI和航运物流服务收入走势图',
        },
        tooltip : {
            trigger: 'axis'
        },
        legend: {
            data:['PMI','航运物流服务收入']
        },
        toolbox: {
            show : true,
            feature : {
                mark : {show: true},
                dataView : {show: true, readOnly: false},
                magicType : {show: true, type: ['line', 'bar']},
                restore : {show: true},
                saveAsImage : {show: true}
            }
        },
        calculable : true,
        xAxis : [
            {
                type : 'category',
                boundaryGap : false,
                data : ['2014-01','2014-02','2014-03','2014-04','2014-05','2014-06','2014-07',
                    '2014-08','2014-09','2014-10','2014-11','2014-12','2015-01','2015-02','2015-03',
                    '2015-04','2015-05','2015-06','2015-07','2015-08','2015-09','2015-10','2015-11',
                    '2015-12','2016-01','2016-02','2016-03','2016-04','2016-05','2016-06','2016-07',
                    '2016-08','2016-09','2016-10','2016-11','2016-12','2017-01','2017-02','2017-03',
                    '2017-04','2017-05','2017-06','2017-07',]
            }
        ],
        yAxis : [
            {
                type : 'value',
                min:48,
                max:52,
                position: 'left',
            },
            {
                'type' : 'value',
                'min':80,
                'max':135,
                'position': 'right',
            }
        ],
        series : [
            {
                name:'PMI',
                type:'line',
                data:[51.0, 50.5, 50.2, 50.3, 50.4, 50.8, 51.0, 51.7, 51.1, 51.1, 50.8,
                    50.3, 50.1, 49.8, 49.9, 50.1, 50.1, 50.2, 50.2, 50.0, 49.7, 49.8, 49.8,
                    49.6, 49.7, 49.4, 49.0, 50.2, 50.1, 50.1, 50.0, 49.9, 50.4, 50.4, 51.2,
                    51.7, 51.4, 51.3, 51.6, 51.8, 51.2, 51.2],
                yAxisIndex: 0,
            },
            {
                name:'航运物流服务收入',
                type:'line',
                data:[81.0, 89.0, 85.0, 87.0, 88.0, 105.0, 100.0, 130.0, 115.0, 105.0, 100.0,
                    95.0, 101.0, 81.0, 98.0, 105.0, 115.0, 90.0, 110.0, 100.0, 90.0, 100.0, 105.0,
                    105.0, 90.0, 80.0, 87.0, 95.0, 93.0, 100.0, 93.0, 92.0, 104.0, 106.0, 110.0,
                    129.0, 100.0, 97.0, 111.0, 114.0, 111.0, 118.0],
                yAxisIndex: 1,
            }
        ]
    };
    myChart.setOption(option);
}