/**
 * Created by Scorpion on 2017/4/21.
 * Ajax获取条件查询的企业新闻的结果
 */
var startDate='1990-01-01'
var endDate='2020-01-01'
$(function () {
    var doc = window.doc = {
        dync: {
            cp: 1,		//当前页码
            key: key,
            startDate: startDate,
            endDate: endDate

        },
        bindFunc: function () {
            bind();
        },
        init: function () {
            doc.bindFunc();
        }
    };
    console.log(startDate);
    console.log(endDate);
    console.log(key);
    doc.init();
    queryData(1, startDate, endDate, key);
});


function pager(page, totalPages, totalRecords) {
    pagination.generPageHtml({
        pno: page,
        totalPages: totalPages,
        totalRecords: totalRecords,
        click: function (n) {
            this.selectPage(n);
            doc.dync.cp = n;
            queryData(n, doc.dync.startDate, doc.dync.endDate, doc.dync.key);
        }
    }, true);
}

function queryData(page, startDate, endDate, key) {
    $.ajax({
        cache: false,
        url: "/zmq/matchCompanyNews",
        type: "GET",
        dataType: "json",
        data: {page: page, startDate: startDate, endDate: endDate, key: key},
        async: true,
        success: function (data) {
            //console.log(data);
            //$("#key").val(key);
            doc.dync.key = key;
            doc.dync.startDate = startDate;
            doc.dync.endDate = endDate;
            var html = "";
            $("#records").text(data.totalRecords);
            if (!data.totalRecords) {
                $("#result").html("");
                $("#content_none").show();
                pager(page, data.totalPages, data.totalRecords);
                return;
            }
            console.log(data.resultList.length);
            for (var i = 0; i < data.resultList.length; i++) {
                html += '<div id="' + i + '" onmouseover="drawpic(this)"><h3><b ><font size="4">' + data.resultList[i].title
                    + '</font></b></h3>' + data.resultList[i].date
                    + '</p><p>' + data.resultList[i].description + '</p><a class="btn btn-default" href='
                    + data.resultList[i].url + ' target="_blank">原文»</a>&nbsp;<font color="blue">'
                    + data.resultList[i].name + '</font></div>';
            }
            $("#resultNews").html(html);
            pager(page, data.totalPages, data.totalRecords);
        },
        erroor: function () {
            alert("啦啦啦o(^▽^)o出错啦");
        }
    });
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
    var title = "重点企业新闻";
    document.title = title;
    var url = ctx + "/zmq/matchCompanyNews?startDate=" + doc.dync.startDate + "&endDate="
        + doc.dync.endDate + "&key=" + doc.dync.key;
    var state = {title: title, url: url, startDate: doc.dync.startDate, endDate: doc.dync.endDate, key: doc.dync.key};
    history.replaceState(state, title, url);
}

function bind() {
    var url = window.location.href;
    // var keyword = decodeURI(url.substring(url.indexOf("=")+1, url.indexOf("&")));
    $("#key").val(key);
    $("#startDate").val(startDate);
    $("#endDate").val(endDate);

    //响应回车事件
    $(document).keyup(function (event) {
        if (event.keyCode == 13) {
            doc.dync.key = $("#key").val();
            doc.dync.startDate = $("#startDate").val();
            doc.dync.endDate = $("#endDate").val();
            queryData(1, doc.dync.startDate, doc.dync.endDate, doc.dync.key);
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
        queryData(1, doc.dync.startDate, doc.dync.endDate, doc.dync.key);
    });

}
/**
 * Created by Scorpion on 2017/3/20.
 */

