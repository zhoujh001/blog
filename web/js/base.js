/**
 * Created by Administrator on 2015/3/5.
 */
$(document).ready(function () {
    $('ul li').click(function () {
        $('ul li').removeClass("active");
        $(this).addClass("active");
        return false;
    });
});