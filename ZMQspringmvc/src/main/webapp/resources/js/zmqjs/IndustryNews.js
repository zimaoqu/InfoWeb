/**
 * Created by Scorpion on 2017/7/11.
 */

(function () {
    var doc = window.doc = {
        dync: {
            cp: 1		//当前页码
        },
        bindFunc: function () {
            bind();
        },
        init: function () {
            doc.bindFunc();
        }
    };

    doc.init();
    queryData(1);
})();


function pager(page, totalPages, totalRecords) {
    pagination.generPageHtml({
        pno: page,
        totalPages: totalPages,
        totalRecords: totalRecords,
        click: function (n) {
            this.selectPage(n);
            doc.dync.cp = n;
            queryData(n);
        }
    }, true);
}

var worddata = new Array();
var namelist=[];
var nameList=[];//柱状图的nameList
var numList=[];//柱状图的numList
function queryData(page) {
    $.ajax({
        cache: false,
        url: "/zmq/queryIndustryNews",
        type: "GET",
        dataType: "json",
        data: {page: page},
        async: true,
        success: function (data) {
            console.log($("#result").html())
            var html = "";
            var html2 = "";

            $("#records").text(data.totalRecords);
            if (!data.totalRecords) {
                $("#result").html("");
                $("#content_none").show();
                pager(page, data.totalPages, data.totalRecords);
                return;
            }
            worddata = new Array();
            numList = data.numList;
            nameList = data.nameList;
            for (var i = 0; i < data.resultList.length; i++) {
                console.log(data.resultList[i].category)
                html += '<div id="' + i + '" onmouseover="drawpic(this)"><h3><b ><font size="4">' + data.resultList[i].title
                    + '</font></b></h3>' + data.resultList[i].date
                    + '</p><p>' + data.resultList[i].description + '</p><a class="btn btn-default" href='
                    + data.resultList[i].url + ' target="_blank">原文»</a>&nbsp;<font color="blue">'
                    + data.resultList[i].category + '</font></div>';
                namelist[i]=data.resultList[i].name;
                var keywordData = [];
                for (var key in data.keywords[i]) {
                    keywordData.push({
                        name: key,
                        value: data.keywords[i][key]
                    })
                }
                worddata.push(keywordData);
            }
            $("#result").html(html);

            //保持两个div高度一致
            document.getElementById("right").style.height = document.getElementById("left").offsetHeight + "px";
            graphic();
            winHistory();
            pager(page, data.totalPages, data.totalRecords);
        },
        erroor: function () {
            alert("啦啦啦o(^▽^)o出错啦");
        }
    });
}
function drawpic(obj) {
    var id = obj.id;
    var comname = namelist[id];
    $(".wordcloud").each(function () {
        var myChart = echarts.init(this);
        option = {
            title: {
                text: "关键词词云图"
            },
            tooltip: {},
            series: [{
                type: 'wordCloud',
                gridSize: 20,
                sizeRange: [12, 50],
                rotationRange: [0, 0],
                shape: 'circle',
                textStyle: {
                    normal: {
                        color: function () {
                            return 'rgb(' + [
                                    Math.round(Math.random() * 160),
                                    Math.round(Math.random() * 160),
                                    Math.round(Math.random() * 160)
                                ].join(',') + ')';
                        }
                    },
                    emphasis: {
                        shadowBlur: 10,
                        shadowColor: '#333'
                    }
                },
                data: worddata[id]
            }]
        };

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    });
}
function graphic(){
    var myChart = echarts.init(document.getElementById("graphic"));
    option = {
        title: {
            text: '行业新闻量统计',
        },
        tooltip: {},
        legend: {
            // y:'top',
            left:'center',
            data: ['新闻量']
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
                name: '新闻量',
                type: 'bar',
                barwidth:'25%',
                data: numList,
                itemStyle: {
                    normal: {
                        color: function (params) {
                            // build a color map as your need.
                            var colorList = [
                                '#5E5AAE', '#B5C334', '#FCCE10', '#E87C25', '#27727B',
                                '#FE8463', '#9BCA63', '#FAD860', '#F3A43B', '#60C0DD',
                                '#5E5AAE', '#B5C334', '#FCCE10', '#E87C25', '#27727B',
                                '#FE8463', '#9BCA63', '#FAD860', '#F3A43B', '#60C0DD',
                                '#5E5AAE', '#B5C334', '#FCCE10', '#E87C25', '#27727B',
                                '#FE8463', '#9BCA63', '#FAD860', '#F3A43B', '#60C0DD',
                                '#5E5AAE', '#B5C334', '#FCCE10', '#E87C25', '#27727B',
                                '#FE8463', '#9BCA63', '#FAD860', '#F3A43B', '#60C0DD',
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

function changeHtml(html) {
    html = html.replace(/&lt;/gi, "<");
    html = html.replace(/&gt;/gi, ">");
    //html = html.replace(/&nbsp;/gi, "");
    return html;
}

window.onpopstate = function (e) {
    document.title = e.state.title;
    $.get(e.state.url).done(queryData(1));
};

//浏览器历史状态
function winHistory() {
    var title = "重中之重企业新闻";
    document.title = title;
    var url = "/zmq/queryCompanyNews";
    var state = {title: title, url: url};
    history.replaceState(state, title, url);
}

function bind() {
    var url = window.location.href;
    // var keyword = decodeURI(url.substring(url.indexOf("=")+1, url.indexOf("&")));
    // $("#key").val(key);

    //响应回车事件
    $(document).keyup(function (event) {
        if (event.keyCode == 13) {
            queryData(1);
        }
    });

    //动态查询
    // $("#key").livesearch({
    //     searchCallback: queryData,
    //     innerText: "",
    //     queryDelay: 500,
    //     minimumSearchLength: 1
    // });

    //点击查询
    $("#sub").click(function () {
        queryData(1);
    });

}
