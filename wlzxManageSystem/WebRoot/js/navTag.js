/**
 * tag导航标签
 * @authors Your Name (you@example.org)
 * @date    2015-05-19 21:51:06
 * @version $Id$
 */

$(document).ready(function(){
    $('.nav ul li a').click(function(){
        $('.nav ul li a').removeClass('navActive');
        $(this).attr('class','navActive');
    })
});