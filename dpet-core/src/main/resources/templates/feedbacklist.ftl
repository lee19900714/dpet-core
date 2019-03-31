<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>登陆帐号</title>
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <link rel="stylesheet" href="../static/web/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="../static/web/css/frame.css">
    <link rel="stylesheet" href="../static/web/css/addClass.css">
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
    <div class="frame-header"><span class="page-reload cur">反馈信息</span></div>
    <!--表格-->
    <div class="table-wrapper pl27">
        <table class="table text-center">
            <thead>
                <tr>
                    <th style="width: 2%;" class="yt">
                       <input type="checkbox" class="allCheck" id="all"><label for="all">&nbsp;&nbsp;&nbsp;</label></th>
                    <th class="sort cur" style="width:6%">手机
                        <img class="bottom" src="../static/web/img/jt-bottom.png" alt="手机">
                        <img class="top" style="display: none" src="../static/web/img/jt-right-co.png" alt="">
                    </th>
                    <th class="sort cur" style="width: 4%;">反馈内容
                        <img class="bottom" src="../static/web/img/jt-bottom.png" alt="反馈内容">
                        <img class="top" style="display: none" src="../static/web/img/jt-right-co.png" alt="">
                    </th>
                    <th class="sort cur" style="width: 4%;">创建时间
                        <img class="bottom" src="../static/web/img/jt-bottom.png" alt="创建时间">
                        <img class="top" style="display: none" src="../static/web/img/jt-right-co.png" alt="">
                    </th>
                    <th class="no-nowrap sort cur" style="width: 4%;">创建人
                        <img class="bottom" src="../static/web/img/jt-bottom.png" alt="创建人">
                        <img class="top" style="display: none" src="../static/web/img/jt-right-co.png" alt="">
                    </th>
                </tr>
            </thead>
            <tbody>
                <#list proposals as p>
                <tr>
                    <td>
                        <p>${p_index+1}</p>
                    <td>
                        <p>${p.phoneNo}</p>
                    </td>
                    <td>
                        <p>${p.proposal}</p>
                    </td>
                    <td>
                        <p>${p.createTime}</p>
                    </td>
                    <td>
                        <p>${p.createId}</p>
                    </td>
                </tr>
                </#list>
            </tbody>
        </table>
    </div>
      <div class="table-tel clearfix">
        <div style="border-bottom: 1px solid #fff; overflow: hidden;" class="no-hover">
            <div class="fl tb1" style="text-align: center;  ">
                <input type="checkbox" class="allCheck" id="all"><label for="all">&nbsp;&nbsp;&nbsp;</label>
            </div>
            <div class="tab-margin clearfix " style="width: 400px; position: absolute; left: 50%; margin-left: -120px;"">
                <div class="fl tb3" style="width: 225px;float: left;">
                    <div class="page-wrapper text-left">
                        <button class="btn-s"><img src="../static/web/img/left-icon.png" alt=""></button>
                        <a href="#" class="active">1</a>
                        <a href="#" class="">2</a>
                        <a href="#" class="">3</a>
                        <button class="btn-s"><img src="../static/web/img/right-icon.png" alt=""></button>
                    </div>
                </div>
            </div>
            <div class="fr tb5" style="text-align: left;padding-right: 30px;position: absolute; right: 0; top: 0;">
                <input type="text" style="width: 40px;height: 26px;" class="text-center" onkeyup="value=value.replace(/[^\d]/g,'')"> 行/页
            </div>
        </div>
    </div>
</body>
<script src="../static/web/plugin/jquery/jquery.js"></script>
<script src="../static/web/js/frame-base.js"></script>

</html>