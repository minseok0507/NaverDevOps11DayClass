$(function(){
    $("ul.list img").click(function(){
        var imgSrc = $(this).attr("src");
        var imgTitle = $(this).attr("title");
        $(".wall>h1").html(imgTitle);
        $(".wall").css("background-image",`url(${imgSrc})`);
    })
})