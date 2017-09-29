/**
 * Created by Scorpion on 2017/4/21.
 * Ajax获取条件查询的重点企业新闻的结果
 */
$(function () {
    var doc = window.doc = {
        dync: {
            cp: 1,		//当前页码
            key: key,
            startDate: startDate,
            endDate: endDate,
            industry: industry

        },
        bindFunc: function () {
            bind();
        },
        init: function () {
            doc.bindFunc();
        }
    };

    doc.init();
    console.log(industry);
    queryData(1, startDate, endDate, key, industry);
});


function pager(page, totalPages, totalRecords) {
    pagination.generPageHtml({
        pno: page,
        totalPages: totalPages,
        totalRecords: totalRecords,
        click: function (n) {
            this.selectPage(n);
            doc.dync.cp = n;
            queryData(n, doc.dync.startDate, doc.dync.endDate, doc.dync.key, doc.dync.industry);
        }
    }, true);
}

var worddata = new Array();
var namelist = [];
var nameList = [];//柱状图的nameList
var numList = [];//柱状图的numList
function queryData(page, startDate, endDate, key) {
    $.ajax({
        cache: false,
        url: "/zmq/matchTopCompanyNews",
        type: "GET",
        dataType: "json",
        data: {page: page, startDate: startDate, endDate: endDate, key: key, industry: industry},
        async: true,
        success: function (data) {
            //$("#key").val(key);
            doc.dync.key = key;
            doc.dync.startDate = startDate;
            doc.dync.endDate = endDate;
            doc.dync.industry = industry;
            var html = "";
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
                html += '<div id="' + i + '" onmouseover="drawpic(this)"><h3><b ><font size="4">' + data.resultList[i].title
                    + '</font></b></h3>' + data.resultList[i].date
                    + '</p><p>' + data.resultList[i].description + '</p><a class="btn btn-default" href='
                    + data.resultList[i].url + ' target="_blank">原文»</a>&nbsp;<font color="blue">'
                    + data.resultList[i].name + '</font></div>';
                namelist[i] = data.resultList[i].name;
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
                text: comname + "关键词词云图"
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
function graphic() {
    var myChart = echarts.init(document.getElementById("graphic"));
    option = {
        title: {
            text: '新闻最多公司Top10',
        },
        tooltip: {},
        legend: {
            data: ['新闻量']
        },
        toolbox: {
            show: true,
        },
        calculable: true,
        xAxis: [{}],
        yAxis: [
            {
                data: nameList,
                show: false
            }
        ],
        series: [
            {
                name: '新闻量',
                type: 'bar',
                data: numList,
                itemStyle: {
                    normal: {
                        color: function (params) {
                            // build a color map as your need.
                            var colorList = [
                                '#5E5AAE', '#B5C334', '#FCCE10', '#E87C25', '#27727B',
                                '#FE8463', '#9BCA63', '#FAD860', '#F3A43B', '#60C0DD',
                            ];
                            return colorList[params.dataIndex]
                        },
                        label: {
                            show: true,
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
    $("#key").val(e.state.key);
    $("#startDate").val(e.state.startDate);
    $("#endDate").val(e.state.endDate);
    $.get(e.state.url).done(queryData(1, e.state.startDate, e.state.endDate));
};

//浏览器历史状态
function winHistory() {
    var title = "重中之重企业新闻";
    document.title = title;
    var url = "/zmq/matchTopCompanyNews?startDate=" + doc.dync.startDate + "&endDate="
        + doc.dync.endDate + "&key=" + doc.dync.key + "industry=" + doc.dync.industry;
    var state = {
        title: title, url: url, startDate: doc.dync.startDate, endDate: doc.dync.endDate, key: doc.dync.key,
        industry: industry
    };
    history.replaceState(state, title, url);
}

function bind() {
    var url = window.location.href;
    // var keyword = decodeURI(url.substring(url.indexOf("=")+1, url.indexOf("&")));
    $("#key").val(key);
    $("#startDate").val(startDate);
    $("#endDate").val(endDate);
    $("#industry").val(industry);


    //响应回车事件
    $(document).keyup(function (event) {
        if (event.keyCode == 13) {
            doc.dync.key = $("#key").val();
            doc.dync.startDate = $("#startDate").val();
            doc.dync.endDate = $("#endDate").val();
            doc.dync.industry = $("#industry").val();
            queryData(1, doc.dync.startDate, doc.dync.endDate, doc.dync.key,doc.dync.industry);
        }
    });


    // //动态查询
    // $("#key").livesearch({
    //     searchCallback: queryData,
    //     innerText: "",
    //     queryDelay: 500,
    //     minimumSearchLength: 1
    // });

    //点击查询
    $("#sub").click(function () {
        doc.dync.key = $("#key").val();
        doc.dync.startDate = $("#startDate").val();
        doc.dync.endDate = $("#endDate").val();
        doc.dync.industry = $("#industry").val();
        queryData(1, doc.dync.startDate, doc.dync.endDate, doc.dync.key, doc.dync.industry);
    });

}
/**
 * Created by Scorpion on 2017/3/20.
 */

