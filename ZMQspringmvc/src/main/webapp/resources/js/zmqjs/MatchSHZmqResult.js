/**
 * Created by Scorpion on 2017/4/22.
 * Ajax获取条件查询的上海自贸区新闻的结果
 */
$(function () {
    var doc = window.doc = {
        dync: {
            cp: 1,		//当前页码
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

    doc.init();
    queryData(1, startDate, endDate);
});


function pager(page, totalPages, totalRecords) {
    pagination.generPageHtml({
        pno: page,
        totalPages: totalPages,
        totalRecords: totalRecords,
        click: function (n) {
            this.selectPage(n);
            doc.dync.cp = n;
            queryData(n, doc.dync.startDate, doc.dync.endDate);
        }
    }, true);
}


function queryData(page, startDate, endDate) {
    $.ajax({
        cache: false,
        url: "/zmq/matchSHZmqNews",
        type: "GET",
        dataType: "json",
        data: {page: page, startDate: startDate, endDate: endDate},
        async: true,
        success: function (data) {
            //$("#key").val(key);
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
            $("#content_none").hide();
            html = template("rslt", data);
            html = changeHtml(html);
            $("#result").html(html);
            winHistory();
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
    $("#startDate").val(e.state.startDate);
    $("#endDate").val(e.state.endDate);
    $.get(e.state.url).done(queryData(1, e.state.startDate, e.state.endDate));
};

//浏览器历史状态
function winHistory() {
    var title = "重点企业新闻";
    document.title = title;
    var url = "/zmq/matchSHZmqNews?startDate=" + doc.dync.startDate + "&endDate="
        + doc.dync.endDate
    var state = {title: title, url: url, startDate: doc.dync.startDate, endDate: doc.dync.endDate};
    history.replaceState(state, title, url);
}

function bind() {
    var url = window.location.href;
    // var keyword = decodeURI(url.substring(url.indexOf("=")+1, url.indexOf("&")));
    $("#startDate").val(startDate);
    $("#endDate").val(endDate);

    //响应回车事件
    $(document).keyup(function (event) {
        if (event.keyCode == 13) {
            doc.dync.startDate = $("#startDate").val();
            doc.dync.endDate = $("#endDate").val();
            queryData(1, doc.dync.startDate, doc.dync.endDate);
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
        doc.dync.startDate = $("#startDate").val();
        doc.dync.endDate = $("#endDate").val();
        queryData(1, doc.dync.startDate, doc.dync.endDate);
    });

}