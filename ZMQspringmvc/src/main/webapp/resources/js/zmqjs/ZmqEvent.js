var yearList = new Array();
var zname = '上海';
var queryflag = 'shanghai';
function queryEvents(zname,queryflag) {
    $.ajax({
        cache:false,
        url: "/zmq/queryZmqEvent",
        type: "GET",
        dataType: "json",
        data:{zname:zname},
        async: true,
        success:function (data) {
            var result = data.resultList;
            var html = "";
            yearList = Array(20).fill(0);
            var cnt = 0;
            for(var i=0;i<result.length;i++){
                var dataYear =  result[i].date.split("-")[0];
                if(isHere(dataYear)==0){
                    continue;
                }
                else{
                    yearList[cnt] = dataYear;
                    console.log(queryflag+" "+yearList[cnt]);
                    cnt++;
                    html += '<div><h3 id="'+dataYear+'">'+dataYear+'</h3>';
                    for (var j = 0; j < result.length; j++){
                        if(dataYear == result[j].date.split("-")[0]){
                            var dataMonth = result[j].date.split("-")[1];
                            var dataDay = result[j].date.split("-")[2];
                            html+= '<li><span>'+dataMonth+'</span><p><span>'+result[j].event+'</span></p></li>>';
                        }
                    }
                    html += '</div>';
                }
            }

            $("#result").html(html);
        }
        }

    )
}
function  isHere(dataYear) {
    for(var t=0;t < yearList.length;t++){
        if(yearList[t] == dataYear){
            return 0;
        }
    }
    return 1;
}
function shanghaiZmqEvents(){
    zname = '上海';
    queryflag= 'shanghai';
    queryEvents(zname,queryflag);
}
function fujianZmqEvents(){
    zname = '福建';
    queryflag = 'fujian';
    queryEvents(zname,queryflag);
}
function guangdongZmqEvents(){
    zname = '广东';
    queryflag = 'guangdong';
    queryEvents(zname,queryflag);
}
function chongqingZmqEvents(){
    zname = '重庆';
    queryflag = 'chongqing';
    queryEvents(zname,queryflag);
}
function henanZmqEvents(){
    zname = '河南';
    queryflag = 'henan';
    queryEvents(zname,queryflag);
}
function hubeiZmqEvents(){
    zname = '湖北';
    queryflag = 'hubei';
    queryEvents(zname,queryflag);
}
function liaoningZmqEvents(){
    zname = '辽宁';
    queryflag = 'liaoning';
    queryEvents(zname,queryflag);
}
function shanxiZmqEvents(){
    zname = '陕西';
    queryflag = 'shanxi';
    queryEvents(zname,queryflag);
}
function sichuanZmqEvents(){
    zname = '四川';
    queryflag = 'sichuan';
    queryEvents(zname,queryflag);
}
function tianjinZmqEvents(){
    zname = '天津';
    queryflag = 'tianjin';
    queryEvents(zname,queryflag);
}
function zhejiangZmqEvents(){
    zname = '浙江';
    queryflag = 'zhejiang';
    queryEvents(zname,queryflag);
}
