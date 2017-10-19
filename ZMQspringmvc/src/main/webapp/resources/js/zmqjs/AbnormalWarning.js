/**
 * Created by Scorpion on 2017/10/4.
 * used for ajax abnormal warning table
 */
var pageSize = 30;
var currentPage = 1;
var totalPage = 10;

(function () {
    queryForPages();
})();

function queryForPages() {
    $.ajax({
        cache: false,
        url: "/zmq/queryAbnormalWarning",
        type: "GET",
        dataType: "json",
        data: {page: currentPage},
        async: true,
        success: function (data) {
            var result = data.abnormalwarning;
            var result_key = data.attentionKey;
            var tbody_content = "";
            var tbody_content2 = "";
            for (var i = 0; i < result_key.length; i++) {
                tbody_content2 += '<tr>'
                    + '<td>' + result_key[i].id + '</td>'
                    + '<td style="width: 320px"><a href="' + result_key[i].url + ' target="_blank">' + result_key[i].title + '</a></td>'
                    + '<td style="width: 91px;height: 34px">' + result_key[i].date + '</td>'
                    + '<td>' + result_key[i].name + '</td>'
                    + '<td><font color="red">' + result_key[i].word + '</font></td>'
                    + '<td><input type="submit" value="发送"/></td>'
                    + '<td><input type="button" value="未读"/></td>'
                    + '</tr>'
            }
            for (var i = 0; i < result.length; i++) {
                tbody_content += '<tr>'
                    + '<td>' + result[i].id + '</td>'
                    + '<td style="width: 320px"><a href=" + result[i].url + "target="_blank">' + result[i].title + '</a></td>'
                    + '<td style="width: 91px;height: 34px">' + result[i].date + '</td>'
                    + '<td>' + result[i].relcompany + '</td>'
                    + '<td>' + result[i].oreitationvalue + '</td>'
                    + '<td><input type="submit" value="发送"/></td>'
                    + '<td><input type="button" value="未读"/></td>'
                    + '</tr>'
            }
            $("#tablelsw").html(tbody_content);
            $("#tablelsw2").html(tbody_content2);
            IniButtonEvent();
        }
    });
}

function GoToFirstPage() {
    currentPage = 1;
    queryForPages();
}
function GoToPrePage() {
    if (currentPage > 1)
        currentPage--;
    queryForPages();
}
function GoToNextPage() {
    if (currentPage < totalPage)
        currentPage++;
    queryForPages();
}

function GoToEndPage() {
    currentPage = totalPage;
    queryForPages();
}
function IniButtonEvent() {
    var Items = document.getElementsByTagName("input");
    for (var i = 0; i < Items.length; i++) {
        var objTmp = Items[i];
        if (objTmp.type == "button") {
            objTmp.onclick = ButtonClickRead;
        }
        else if(objTmp.type == "submit"){
            objTmp.onclick = prom;
        }
    }
}
function prom()
{
    var name=prompt("请输入您的邮箱","");//将输入的内容赋给变量 name ，
    //这里需要注意的是，prompt有两个参数，前面是提示的话，后面是当对话框出来后，在对话框里的默认值
    if(name)//如果返回的有内容
    {
        alert("已发送至："+ name)
    }
}

function ButtonClickRead() {
    var Items = document.getElementsByTagName("input");
    for (var i = 0; i < Items.length; i++) {
        var objTmp = Items[i];
        if (objTmp.type == "button") {
            //判断是否是按钮
            //window.event.srcElement触发当前事件的元素
            //用来判断是否是当前单击的按钮
            if (objTmp == window.event.srcElement) {
                if (objTmp.value == "已读") {
                    objTmp.value = "未读";
                } else if (objTmp.value == "未读") {
                    objTmp.value = "已读";
                }
            }
        }
    }
}
