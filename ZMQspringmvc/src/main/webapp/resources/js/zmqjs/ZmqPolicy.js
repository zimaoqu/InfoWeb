/**
 * Created by Scorpion on 2017/4/22.
 * ajax异步访问自贸区政策
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


function queryData(page) {
    $.ajax({
        cache: false,
        url: "/zmq/queryZmqPolicy",
        type: "GET",
        dataType: "json",
        data: {page: page},
        async: true,
        success: function (data) {
            console.log($("#result").html())
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
                    + data.resultList[i].url + ' target="_blank">原文»</a>&nbsp;<font color="blue">'
                    + data.resultList[i].name + '</font>';
            }
            // html = template("rslt", data);
            // html = changeHtml(html);
            //document.getElementById("result").innerHTML = html;
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
    $.get(e.state.url).done(queryData(1));
};

//浏览器历史状态
function winHistory() {
    var title = "重中之重企业新闻";
    document.title = title;
    var url = "/zmq/queryZmqPolicy";
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
