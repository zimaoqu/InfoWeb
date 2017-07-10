/**
 * Created by Vikun on 2017/7/8.
 */
$(function() {

    $('.J_dropdown').each(function() {
        var _this = $(this);
        var $sel = _this.find('.dropdown-sel');
        var $option = _this.find('.dropdown-option');
        var $as = $option.children('li').children('a');
        var index = -1;

        $sel.click(function(e) {
            e.stopPropagation();
            $option.toggle();
        });
        $(document).click(function() {
            $option.hide();
        });
        $option.on('click', 'li', function() {
            var selTxt = $(this).children('a').text();
            $sel.val(selTxt);
        });

        $sel.keyup(function(e) {
            var keycode = e.keyCode;
            if (keycode === 38) {
                console.log(index);
                if (index === -1) {
                    index = $as.length - 1;
                    $($as[index]).addClass('hover').parent().siblings().children('a').removeClass('hover');
                } else if (index === -1 || index === 0) {
                    index = $as.length - 1;
                    $($as[index]).addClass('hover').parent().siblings().children('a').removeClass('hover');
                } else {
                    index--;
                    $($as[index]).addClass('hover').parent().siblings().children('a').removeClass('hover');
                }
            } else if (keycode === 40) {
                if (index === ($as.length - 1)) {
                    index = 0;
                    $($as[index]).addClass('hover').parent().siblings().children('a').removeClass('hover');
                } else {
                    index++;
                    $($as[index]).addClass('hover').parent().siblings().children('a').removeClass('hover');
                }
            } else if (keycode === 13) {
                $sel.val($($as[index]).text());
                $option.hide();
            }
        });

    });


});