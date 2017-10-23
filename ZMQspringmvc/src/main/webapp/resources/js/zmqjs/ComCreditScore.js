$(document).ready(function () {

    $('tbody tr').hover(function () {
        $(this).addClass('odd');
    }, function () {
        $(this).removeClass('odd');
    });
    $.ajax({
        cache: false,
        url: "/zmq/queryComCreditScore",
        type: "GET",
        dataType: "json",
        data: {},
        async: true,
        success: function (data) {
            var result = data.result;
            var content = "";
            for (var i = 0; i < result.length; i++) {
                var temp = result[i];
                content += '<tr>'
                    + '<td>' + temp.qymc + '</td>' + '<td>' + temp.x1 + '</td>' + '<td>' + temp.x2 + '</td>'
                    + '<td>' + temp.x3 + '</td>' + '<td>' + temp.x4 + '</td>' + '<td>' + temp.x5 + '</td>'
                    + '<td>' + temp.x6 + '</td>' + '<td>' + temp.x7 + '</td>' + '<td>' + temp.x8 + '</td>'
                    + '<td>' + temp.x9 + '</td>' + '<td>' + temp.x10 + '</td>' + '<td>' + temp.x11 + '</td>'
                    + '<td>' + temp.x12 + '</td>' + '<td>' + temp.x13 + '</td>' + '<td>' + temp.x14 + '</td>'
                    + '<td>' + temp.x15 + '</td>' + '<td>' + temp.x16 + '</td>' + '<td>' + temp.x17 + '</td>'
                    + '<td>' + temp.x18 + '</td>' + '<td>' + temp.x19 + '</td>' + '<td>' + temp.x20 + '</td>'
                    + '<td>' + temp.x21 + '</td>' + '<td>' + temp.x22 + '</td>' + '<td>' + temp.pred + '</td>'
                    + '</tr>'
            }
            $("#content").html(content);
        }
    });

});