/**
 * Created by Scorpion on 2017/4/24.
 * 点击五个分类来ajax获取政策新闻
 */
function getByCategory(cat) {
    $(".policy_btn").removeClass('btn-sp');
    $("#startDate").val("");
    $("#endDate").val("");
    switch (cat){
        case 'hg':
            $("#cat").val('hg');
            var changeclass = "btn policy_btn btn-sp";
            document.getElementById("custom").setAttribute('class',changeclass);
            break;
        case 'sw':
            $("#cat").val('sw');
            var changeclass = "btn policy_btn btn-sp";
            document.getElementById("bussiness").setAttribute('class',changeclass);
            break;
        case 'shuiw':
            $("#cat").val('shuiw');
            var changeclass = "btn policy_btn btn-sp";
            document.getElementById("tax").setAttribute('class',changeclass);
            break;
        case 'gs':
            $("#cat").val('gs');
            var changeclass = "btn policy_btn btn-sp";
            document.getElementById("industry").setAttribute('class',changeclass);
            break;
        case 'zljd':
            $("#cat").val('zljd');
            var changeclass = "btn policy_btn btn-sp";
            document.getElementById("quality").setAttribute('class',changeclass);
            break;
        default:
            break;
    }

    var doc = window.doc = {
        dync: {
            cp: 1,		//当前页码
            cat: cat
        },
        bindFunc: function () {
            bind();
        },
        init: function () {
            doc.bindFunc();
        }
    };
    doc.init();
    queryData(doc.dync.cat, 1);
};


function pager(page, totalPages, totalRecords) {
    pagination.generPageHtml({
        pno: page,
        totalPages: totalPages,
        totalRecords: totalRecords,
        click: function (n) {
            this.selectPage(n);
            doc.dync.cp = n;
            queryData(doc.dync.cat, n);
        }
    }, true);
}


function queryData(cat, page) {
    $.ajax({
        cache: false,
        url: "/zmq/queryPolicyNewsByCat",
        type: "GET",
        dataType: "json",
        data: {cat: cat, page: page},
        async: true,
        success: function (data) {
            doc.dync.cat = cat;
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
    $.get(e.state.url).done(queryData(e.state.cat, 1));
};

//浏览器历史状态
function winHistory() {
    var title = "中国自由贸易试验区大数据管理与分析平台";
    document.title = title;
    var url = "/zmq/queryPolicyNewsByCat?cat=" + doc.dync.cat;
    var state = {title: title, url: url, cat: doc.dync.cat};
    history.replaceState(state, title, url);
}

function bind() {
    var url = window.location.href;
    // var keyword = decodeURI(url.substring(url.indexOf("=")+1, url.indexOf("&")));
    // $("#key").val(key);


    //动态查询
    // $("#key").livesearch({
    //     searchCallback: queryData,
    //     innerText: "",
    //     queryDelay: 500,
    //     minimumSearchLength: 1
    // });

    //点击查询
    $("#sub").click(function () {
        queryData(doc.dync.cat, 1);
    });

}