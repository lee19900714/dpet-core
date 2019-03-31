<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>登陆帐号</title>
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <link rel="stylesheet" href="../static/web/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="../static/web/css/frame.css">
    <link rel="stylesheet" href="../static/web/css/addClass.css">
    <link href="../static/umeditor/themes/default/css/umeditor.css" type="text/css" rel="stylesheet">
    <script type="text/javascript" src="../static/umeditor/third-party/jquery.min.js"></script>
    <script type="text/javascript" src="../static/umeditor/third-party/template.min.js"></script>
    <script type="text/javascript" charset="utf-8" src="../static/umeditor/umeditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="../static/umeditor/umeditor.js"></script>
    <script type="text/javascript" src="../static/umeditor/lang/zh-cn/zh-cn.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<style>
    .form-group label{width: 85px;}
    .form-group {margin-bottom: 15px !important;}
    .form-inline .form-control {width: 179px !important;}
</style>

<body>
    <div class="frame-header"><span class="page-reload cur">文章列表</span></div>
    <!--操作栏-->
    <div class="operates clearfix" style="overflow: auto;white-space: nowrap; font-size: 0;">
        <div class="pull-left left-inp defualt">
            <button class="btn delete pramary" type="button" data-toggle="modal" data-target="#myModal">增加</button>
        </div>
    </div>
    <!--表格-->
    <div class="table-wrapper pl27">
        <table class="table text-center">
            <thead>
                <tr>
                    <th class="sort cur" style="width:2%">序号
                        <img class="bottom" src="../static/web/img/jt-bottom.png" alt="序号">
                        <img class="top" style="display: none" src="../static/web/img/jt-right-co.png" alt="">
                    </th>
                    <th class="sort cur" style="width:6%">文章名
                        <img class="bottom" src="../static/web/img/jt-bottom.png" alt="文章名">
                        <img class="top" style="display: none" src="../static/web/img/jt-right-co.png" alt="">
                    </th>
                    <th class="sort cur" style="width: 4%;">标题
                        <img class="bottom" src="../static/web/img/jt-bottom.png" alt="标题">
                        <img class="top" style="display: none" src="../static/web/img/jt-right-co.png" alt="">
                    </th>
                    <th class="sort cur" style="width: 4%;">内容
                        <img class="bottom" src="../static/web/img/jt-bottom.png" alt="内容">
                        <img class="top" style="display: none" src="../static/web/img/jt-right-co.png" alt="">
                    </th>
                    <th class="sort cur" style="width: 4%;">封面
                        <img class="bottom" src="../static/web/img/jt-bottom.png" alt="封面">
                        <img class="top" style="display: none" src="../static/web/img/jt-right-co.png" alt="">
                    </th>
                    <th class="sort cur" style="width: 2%;">点击量
                        <img class="bottom" src="../static/web/img/jt-bottom.png" alt="点击量">
                        <img class="top" style="display: none" src="../static/web/img/jt-right-co.png" alt="">
                    </th>
                    <th class="sort cur" style="width: 2%;">收藏量
                        <img class="bottom" src="../static/web/img/jt-bottom.png" alt="收藏量">
                        <img class="top" style="display: none" src="../static/web/img/jt-right-co.png" alt="">
                    </th>
                    <th class="sort cur" style="width: 2%;">排序
                        <img class="bottom" src="../static/web/img/jt-bottom.png" alt="排序">
                        <img class="top" style="display: none" src="../static/web/img/jt-right-co.png" alt="">
                    </th>
                    <th class="sort cur" style="width: 4%;">创建时间
                        <img class="bottom" src="../static/web/img/jt-bottom.png" alt="创建时间">
                        <img class="top" style="display: none" src="../static/web/img/jt-right-co.png" alt="">
                    </th>
                    <th class="sort cur" style="width: 4%;">修改时间
                        <img class="bottom" src="../static/web/img/jt-bottom.png" alt="创建时间">
                        <img class="top" style="display: none" src="../static/web/img/jt-right-co.png" alt="">
                    </th>
                    <th class="no-nowrap sort cur" style="width: 4%;">创建人
                        <img class="bottom" src="../static/web/img/jt-bottom.png" alt="创建人">
                        <img class="top" style="display: none" src="../static/web/img/jt-right-co.png" alt="">
                    </th>
                    <th class="no-nowrap sort cur" style="width: 4%;">操作
                        <img class="bottom" src="../static/web/img/jt-bottom.png" alt="操作">
                        <img class="top" style="display: none" src="../static/web/img/jt-right-co.png" alt="">
                    </th>
                </tr>
            </thead>
            <tbody>
            <#list articles as p>
                <tr>
                    <td>
                        <p>${p_index+1}</p>
                    <td>
                        <p>${p.articleName}</p>
                    </td>
                    <td>
                        <p>${p.articleTitle}</p>
                    </td>
                    <td>
                        <p>${p.articleContent}</p>
                    </td>
                    <td>
                        <p>${p.articlePicUrl}</p>
                    </td>
                    <td>
                        <p>${p.readCount}</p>
                    </td>
                    <td>
                        <p>${p.collCount}</p>
                    </td>
                    <td>
                        <p>${p.articleOrder}</p>
                    </td>
                    <td>
                        <p>${p.createTime}</p>
                    </td>
                    <td>
                        <p>${p.modifyTime}</p>
                    </td>
                    <td>
                        <p>${p.createId}</p>
                    </td>
                    <td>
                        <p> <a href="#" class="glyphicon glyphicon-list-alt"></a>
                            <a href="#" class="glyphicon glyphicon-pencil"></a>
                            <a href="#" class="glyphicon glyphicon-remove"></a>
                        </p>
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
                        <#list 1..(page?eval) as t>
                            <#if t gt 5>
                                <a href="/article/articlelist" class="">...</a>
                            <#else>
                                <a href="/article/articlelist" class="active">${t}</a>
                            </#if>
                        </#list>
                        <button class="btn-s"><img src="../static/web/img/right-icon.png" alt=""></button>
                    </div>
                </div>
            </div>
            <div class="fr tb5" style="text-align: left;padding-right: 30px;position: absolute; right: 0; top: 0;">
                <input type="text" style="width: 40px;height: 26px;" class="text-center" onkeyup="value=value.replace(/[^\d]/g,'')"> 行/页
            </div>
        </div>
    </div>

    <!-- Modal -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">创建文章</h4>
                </div>
                <div class="modal-body">
                    <form class="form-inline">
                        <div class="form-group">
                            <label for="courseName">文章名</label>
                            <input type="text" class="form-control" id="courseName" placeholder="课程名">
                        </div>
                        <div class="form-group">
                            <label for="courseTitle">标题</label>
                            <input type="text" class="form-control" id="courseTitle" placeholder="课程标题">
                        </div>
                        <div class="form-group">
                            <label for="courseDesc">排序</label>
                            <input type="text" class="form-control" id="courseDesc" placeholder="课程描述">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputFile">封面</label>
                            <input type="file" id="articlePicUrl" name="articlePicUrl" style="display: inline-block;">
                        </div>
                        <div>
                            <label for="exampleInputFile">内容</label>
                            <script type="text/plain" id="myEditor" style="width:1000px;height:240px;"></script>
                            <script>var um = UM.getEditor('myEditor');</script>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary" onclick="creatArticle();">保存</button>
                </div>
            </div>
        </div>
    </div>

</body>
<script src="../static/web/plugin/jquery/jquery.js"></script>
<script src="../static/web/bootstrap/js/bootstrap.min.js"></script>
<script src="../static/web/js/frame-base.js"></script>
<script src="../static/web/js/ajaxfileupload.js"></script>
<script>
    $('#myModal').modal(options);
</script>
</html>