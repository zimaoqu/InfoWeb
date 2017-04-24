/**
 * Created by Scorpion on 2017/4/24.
 * 根据时间来匹配政策新闻
 */
function getPolicyByCondition() {
    var cat = $("#cat").val();
    var startDate = $("#startDate").val();
    var endDate = $("#endDate").val();
    console.log(cat.length);
    console.log(startDate);
    console.log(endDate);

    var doc = window.doc = {
        dync: {
            cp: 1,		//当前页码
            cat: cat,
            startDate: startDate,
            endDate: endDate

        },
        bindFunc: function () {
            bind1();
        },
        init: function () {
            doc.bindFunc();
        }
    };
    console.log(cat)
    doc.init();
    queryData1(1, startDate, endDate, cat);
};


function pager(page, totalPages, totalRecords) {
    pagination.generPageHtml({
        pno: page,
        totalPages: totalPages,
        totalRecords: totalRecords,
        click: function (n) {
            this.selectPage(n);
            doc.dync.cp = n;
            queryData1(n, doc.dync.startDate, doc.dync.endDate, doc.dync.cat);
        }
    }, true);
}


function queryData1(page, startDate, endDate, cat) {
    console.log(cat);
    $.ajax({
        cache: false,
        url: "/zmq/matchPolicyNews",
        type: "GET",
        dataType: "json",
        data: {page: page, startDate: startDate, endDate: endDate, cat: cat},
        async: true,
        success: function (data) {
            $("#startDate").val(startDate);
            $("#endDate").val(endDate);
            //$("#key").val(key);
            doc.dync.cat = cat;
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
            for (var i = 0; i < data.resultList.length; i++) {
                html += '<h3><b><font size="4">' + data.resultList[i].title
                    + '</font></b></h3><p>' + data.resultList[i].date
                    + '</p><p>' + data.resultList[i].description + '</p><p><a class="btn btn-default" href='
                    + data.resultList[i].url + ' target="_blank">原文»</a>&nbsp;';
            }
            // html = template("rslt", data);
            // html = changeHtml(html);
            //document.getElementById("result").innerHTML = html;
            $("#result").html(html);
            winHistory1();
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
    $("#cat").val(e.state.cat);
    $("#startDate").val(e.state.startDate);
    $("#endDate").val(e.state.endDate);
    $.get(e.state.url).done(queryData(1, e.state.startDate, e.state.endDate));
};

//浏览器历史状态
function winHistory1() {
    var title = "中国自由贸易试验区大数据管理与分析平台";
    document.title = title;
    var url = "/zmq/matchPolicyNews?startDate=" + doc.dync.startDate + "&endDate="
        + doc.dync.endDate + "&cat=" + doc.dync.cat;
    var state = {title: title, url: url, startDate: doc.dync.startDate, endDate: doc.dync.endDate, cat: doc.dync.cat};
    history.replaceState(state, title, url);
}

function bind1() {
    var url = window.location.href;
    // var keyword = decodeURI(url.substring(url.indexOf("=")+1, url.indexOf("&")));
    $("#cat").val(cat);
    $("#startDate").val(startDate);
    $("#endDate").val(endDate);

    //响应回车事件
    $(document).keyup(function (event) {
        if (event.keyCode == 13) {
            doc.dync.cat = $("#cat").val();
            doc.dync.startDate = $("#startDate").val();
            doc.dync.endDate = $("#endDate").val();
            queryData(1, doc.dync.startDate, doc.dync.endDate, doc.dync.cat);
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
        doc.dync.cat = $("#cat").val();
        doc.dync.startDate = $("#startDate").val();
        doc.dync.endDate = $("#endDate").val();
        queryData(1, doc.dync.startDate, doc.dync.endDate, doc.dync.cat);
    });

}