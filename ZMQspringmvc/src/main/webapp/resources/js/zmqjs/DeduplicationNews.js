/**
 * Created by Scorpion on 2017/10/26.
 */
var pageNo = 2;
$(window).scroll(function(){
    var scrollTop = $(this).scrollTop();
    var scrollHeight = $(document).height();
    var windowHeigth = $(this).height();
    if (scrollTop + windowHeigth > (scrollHeight-1)) {
        queryData(key,pageNo);
    }
})

function queryData(key,page){
    var color = ['point-green','point-red','point-blue','point-yellow','point-purple'];
    $.ajax({
        cache: false,
        url: "/zmq/queryNewsTitleDateAndUrl",
        type: "GET",
        dataType: "json",
        data: {key:key, page: page},
        async: true,
        success: function(data){
            pageNo += 1;
            var html = '';
            for(var i = 0; i < data.size; i++){
                var colorNum = parseInt(Math.random()*5);
                html += '<section>'
                    +'<span class="point-time '+color[colorNum]+'"></span>'
                    +'<time datetime="'+ data.dateList[i] +'">'
                    +	'<span>' + data.dateList[i].split('-')[1]+'.'+data.dateList[i].split('-')[2]+ '</span>'
                    +	'<span>'+ data.dateList[i].split('-')[0] +'</span>'
                    +'</time>'
                    +'<aside>'
                    +'<p class="things">'+'<a href="'+data.urlList[i]+'"target="_blank" >' + data.titleList[i] + '</a></p>'
                    +'</aside>'
                    +'</section>'
            }
            $("#news").append(html);
        },
        erroor: function(){
            alert("啦啦啦o(^▽^)o出错啦");
        }
    })
}