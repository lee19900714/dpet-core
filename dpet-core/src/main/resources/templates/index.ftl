<!doctype html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>宠到后台管理系统</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <link rel="stylesheet" href="../static/web/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="../static/web/css/base.css">
    <link rel="stylesheet" href="../static/web/css/frame.css">
    <link rel="stylesheet" href="../static/web/css/addClass.css">
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
    <!-- common-head -->
    <div class="common-head clearfix">
        <a class="logo" href="index.html">
            <img src="../static/web/img/logo.png" alt="">
        </a>
        <div class="info clearfix">
            <a href="#">站点首页</a> |
            <a href="#">更新首页缓存</a>
        </div>
        <div class="right pull-right text-right" id="hovpad">
            <dl class="user-wrapper">
                <dt><span class="time">欢迎您</span>eewxh@163.com <img src="../static/web/img/headjt.png" alt=""><img class="active" src="../static/web/img/headjt-active.png" alt=""></dt>
                <dd>
                    <div class="head clearfix">
                        <a href="javascript:void()">我的账户</a>
                        <span></span>
                        <a href="login.html">安全退出</a>
                    </div>
                </dd>
            </dl>
            <dl class="msg-wrapper">
                <dt class="clearfix"><img src="../static/web/img/msg.png" alt=""><img class="active" src="../static/web/img/msg-active.png" alt=""><span> 消息 </span></dt>
            </dl>
        </div>
    </div>
    <!-- common-head -->
        <!--侧栏-->
    <div class="side-bar">
        <div class="content">
            <dl>
                <dt style="border-top: none;">用户管理 <img class="b" src="../static/web/img/jt-right-co.png" alt=""><img class="r" src="../static/web/img/jt-bottom.png" alt=""></dt>
                <dd>
                    <a href="#view/userList.html">用户信息</a>
                </dd>
            </dl>
            <dl>
                <dt >宠物管理 <img class="b" src="../static/web/img/jt-right-co.png" alt=""><img class="r" src="../static/web/img/jt-bottom.png" alt=""></dt>
                <dd>
                    <a href="#view/shopList.html">宠物信息 </a>
                </dd>
            </dl>
            <dl>
                <dt >课程管理 <img class="b" src="../static/web/img/jt-right-co.png" alt=""><img class="r" src="../static/web/img/jt-bottom.png" alt=""></dt>
                <dd>
                    <a href="#/course/courselist">课程列表 </a>
                    <a href="#">上传视频 </a>
                </dd>
            </dl>
            <dl>
                <dt>订单管理 <img class="b" src="../static/web/img/jt-right-co.png" alt=""><img class="r" src="../static/web/img/jt-bottom.png" alt=""></dt>
                <dd>
                    <a href="#">订单列表 </a>
                </dd>
            </dl>
            <dl>
                <dt>文章管理 <img class="b" src="../static/web/img/jt-right-co.png" alt=""><img class="r" src="../static/web/img/jt-bottom.png" alt=""></dt>
                <dd>
                    <a href="#/article/articlelist" >文章列表 </a>
                    <a href="#view/main.html" >文章收藏统计 </a>
                </dd>
            </dl>
            <dl>
                <dt>意见反馈 <img class="b" src="../static/web/img/jt-right-co.png" alt=""><img class="r" src="../static/web/img/jt-bottom.png" alt=""></dt>
                <dd>
                    <a href="#/feedback/feedbacklist">反馈列表 </a>
                </dd>
            </dl>
            <dl>
                <dt>推送信息 <img class="b" src="../static/web/img/jt-right-co.png" alt=""><img class="r" src="../static/web/img/jt-bottom.png" alt=""></dt>
                <dd>
                    <a href="#">推送列表 </a>
                </dd>
            </dl>
        </div>
    </div>
    <!--内容部分-->
    <div id="main" >
        <div   style="-webkit-overflow-scrolling:touch;overflow:auto;height: 100%;">
            <iframe class="scroll" src="../static/web/view/main.html" id="ghrzFrame" frameborder="no" border="0"></iframe>
        </div>
    </div>
</body>
<script src="../static/web/js/jquery-1.11.3.js"></script>
        

<script>
//首次加载至url
var u = window.location.href.split('#')[1];
$('#main iframe').attr('src',u);
$('.side-bar dd a[href="#'+ $('#main iframe').attr('src') + '"]').addClass('active');


//侧栏菜单
$(function() {
    $('.side-bar dt').click(function() {
        var dd = $(this).siblings('dd');
        dd.slideToggle();
        $(this).find('.b').toggle()
        $(this).find('.r').toggle()
    });
    $('.side-bar dd a').click(function() {
        $('.side-bar dd a').removeClass('active');
        $(this).addClass('active');
        //页面显示控制
        var url = $(this).attr('href').substring(1);
        var f = $('#main iframe');
        f.attr('src', url);
    });
});

$('#hovpad dl').on('click', function(e) {
    var dd = $(this).find('dd');
    if (dd.css('display') === 'none') {
        dd.show();
        $(this).addClass('active');
    } else {
        dd.hide();
        $(this).removeClass('active');
    }
    e.stopPropagation();
});
$('#hovpad dl').hover(function(e) {
    var dd = $(this).find('dd');
    dd.show();
    $(this).addClass('active');
}, function(e) {
    var dd = $(this).find('dd');
    dd.hide();
    $(this).removeClass('active');
})
$('body').on('click', function() {
    $('#hovpad dl').removeClass('active');
})

    
</script>

</html>