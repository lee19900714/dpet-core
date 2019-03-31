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
<style>
    .form-group label{width: 85px;}
    .form-group {margin-bottom: 15px !important;}
    .form-inline .form-control {width: 179px !important;}
</style>
<body>
    <div class="frame-header"><span class="page-reload cur">课程列表</span></div>
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
                    <th style="width: 2%;" class="yt">
                       <input type="checkbox" class="allCheck" id="all"><label for="all">&nbsp;&nbsp;&nbsp;</label></th>
                    <th class="sort cur" style="width:3%">课程名
                        <img class="bottom" src="../static/web/img/jt-bottom.png" alt="手机">
                        <img class="top" style="display: none" src="../static/web/img/jt-right-co.png" alt="">
                    </th>
                    <th class="sort cur" style="width: 4%;">课程标题
                        <img class="bottom" src="../static/web/img/jt-bottom.png" alt="反馈内容">
                        <img class="top" style="display: none" src="../static/web/img/jt-right-co.png" alt="">
                    </th>
                    <th class="sort cur" style="width: 4%;">课程描述
                        <img class="bottom" src="../static/web/img/jt-bottom.png" alt="创建时间">
                        <img class="top" style="display: none" src="../static/web/img/jt-right-co.png" alt="">
                    </th>
                    <th class="no-nowrap sort cur" style="width: 4%;">课程类型
                        <img class="bottom" src="../static/web/img/jt-bottom.png" alt="创建人">
                        <img class="top" style="display: none" src="../static/web/img/jt-right-co.png" alt="">
                    </th>
                    <th class="no-nowrap sort cur" style="width: 4%;">上下架状态
                        <img class="bottom" src="../static/web/img/jt-bottom.png" alt="创建人">
                        <img class="top" style="display: none" src="../static/web/img/jt-right-co.png" alt="">
                    </th>
                    <th class="no-nowrap sort cur" style="width: 4%;">时长(分钟)
                        <img class="bottom" src="../static/web/img/jt-bottom.png" alt="创建人">
                        <img class="top" style="display: none" src="../static/web/img/jt-right-co.png" alt="">
                    </th>
                    <th class="no-nowrap sort cur" style="width: 4%;">课程标签
                        <img class="bottom" src="../static/web/img/jt-bottom.png" alt="创建人">
                        <img class="top" style="display: none" src="../static/web/img/jt-right-co.png" alt="">
                    </th>
                    <th class="no-nowrap sort cur" style="width: 4%;">价格
                        (元)
                        <img class="bottom" src="../static/web/img/jt-bottom.png" alt="创建人">
                        <img class="top" style="display: none" src="../static/web/img/jt-right-co.png" alt="">
                    </th>
                    <th class="no-nowrap sort cur" style="width: 4%;">课程难度
                        <img class="bottom" src="../static/web/img/jt-bottom.png" alt="创建人">
                        <img class="top" style="display: none" src="../static/web/img/jt-right-co.png" alt="">
                    </th>
                    <th class="no-nowrap sort cur" style="width: 4%;">详细步骤
                        <img class="bottom" src="../static/web/img/jt-bottom.png" alt="创建人">
                        <img class="top" style="display: none" src="../static/web/img/jt-right-co.png" alt="">
                    </th>
                    <th class="no-nowrap sort cur" style="width: 4%;">训练师
                        <img class="bottom" src="../static/web/img/jt-bottom.png" alt="创建人">
                        <img class="top" style="display: none" src="../static/web/img/jt-right-co.png" alt="">
                    </th>
                    <th class="no-nowrap sort cur" style="width: 4%;">学习次数
                        <img class="bottom" src="../static/web/img/jt-bottom.png" alt="创建人">
                        <img class="top" style="display: none" src="../static/web/img/jt-right-co.png" alt="">
                    </th>
                    <th class="no-nowrap sort cur" style="width: 4%;">参与人数
                        <img class="bottom" src="../static/web/img/jt-bottom.png" alt="创建人">
                        <img class="top" style="display: none" src="../static/web/img/jt-right-co.png" alt="">
                    </th>
                    <th class="no-nowrap sort cur" style="width: 4%;">排序权重
                        <img class="bottom" src="../static/web/img/jt-bottom.png" alt="创建人">
                        <img class="top" style="display: none" src="../static/web/img/jt-right-co.png" alt="">
                    </th>
                    <th class="no-nowrap sort cur" style="width: 4%;">创建时间
                        <img class="bottom" src="../static/web/img/jt-bottom.png" alt="创建人">
                        <img class="top" style="display: none" src="../static/web/img/jt-right-co.png" alt="">
                    </th>
                    <th class="no-nowrap sort cur" style="width: 4%;">修改时间
                        <img class="bottom" src="../static/web/img/jt-bottom.png" alt="创建人">
                        <img class="top" style="display: none" src="../static/web/img/jt-right-co.png" alt="">
                    </th>
                </tr>
            </thead>
            <tbody>
            <#list courses as c>
                <tr>
                    <td>
                        <p>${c_index+1}</p>
                    <td>
                        <p>${c.courseName}</p>
                    </td>
                    <td>
                        <p>${c.courseTitle}</p>
                    </td>
                    <td>
                        <p>${c.courseDesc}</p>
                    </td>
                    <td>
                        <p><#if c.courseType=='1'>散课<#else >系列课程</#if></p>
                    </td>
                    <td>
                        <p><#if c.saleState=='1'>上架<#else >下架</#if></p>
                    </td>
                    <td>
                        <p>${c.courseLengthTime}</p>
                    </td>
                    <td>
                        <p>${c.courseLabel}</p>
                    </td>
                    <td>
                        <p>${c.courseCost}</p>
                    </td>
                    <td>
                        <p><#if c.level=='1'>高<#elseif c.level=='2'>中<#else>低</#if></p>
                    </td>
                    <td>
                        <p>${c.learningStep}</p>
                    </td>
                    <td>
                        <p>${c.trainerInfo}</p>
                    </td>
                    <td>
                        <p>${c.learningTimes}</p>
                    </td>
                    <td>
                        <p>${c.joinerCount}</p>
                    </td>
                    <td>
                        <p>${c.courseOrder}</p>
                    </td>
                    <td>
                        <p>${c.createTime}</p>
                    </td>
                    <td>
                        <p>${c.modifyTime}</p>
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
                        <button class="btn-s"><img src="../static/web/img/left-icon.png" alt="上一页"></button>
                        <#list 1..(page?eval) as t>
                            <#if t gt 5>
                                <a href="/course/courselist" class="">...</a>
                            <#else>
                                <a href="/course/courselist" class="active">${t}</a>
                            </#if>
                        </#list>
                        <button class="btn-s"><img src="../static/web/img/right-icon.png" alt="下一页"></button>
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
                    <h4 class="modal-title" id="myModalLabel">创建课程</h4>
                </div>
                <div class="modal-body">
                    <form class="form-inline">
                        <div class="form-group">
                            <label for="courseName">课程名</label>
                            <input type="text" class="form-control" id="courseName" placeholder="课程名">
                        </div>
                        <div class="form-group">
                            <label for="courseTitle">课程标题</label>
                            <input type="text" class="form-control" id="courseTitle" placeholder="课程标题">
                        </div>
                        <div class="form-group">
                            <label for="courseDesc">课程描述</label>
                            <input type="text" class="form-control" id="courseDesc" placeholder="课程描述">
                        </div>
                        <div class="form-group">
                            <label for="courseType">课程类型</label>
                            <select class="form-control" id="courseType">
                                <option value="1">散课</option>
                                <option value="2">系列课程</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="saleState">上下架状态</label>
                            <select class="form-control" id="saleState">
                                <option value="1">上架</option>
                                <option value="2">下架</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="trainerInfo">训练师</label>
                            <input type="text" class="form-control" id="trainerInfo" placeholder="训练师">
                        </div>
                        <div class="form-group">
                            <label for="courseLengthTime">课程平均时长</label>
                            <input type="text" class="form-control" id="courseLengthTime" placeholder="课程平均时长">
                        </div>
                        <div class="form-group">
                            <label for="courseLabel">课程标签</label>
                            <input type="text" class="form-control" id="courseLabel" placeholder="课程标签">
                        </div>
                        <div class="form-group">
                            <label for="courseCost">课程费用</label>
                            <input type="text" class="form-control" id="courseCost" placeholder="课程费用">
                        </div>
                        <div class="form-group">
                            <label for="level">课程难度</label>
                            <select class="form-control" id="level">
                                <option value="1">高</option>
                                <option value="2">中</option>
                                <option value="3">低</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="learningStep">详细步骤</label>
                            <input type="text" class="form-control" id="learningStep" placeholder="详细步骤">
                        </div>
                        <div class="form-group">
                            <label for="courseOrder">排序权重</label>
                            <input type="text" class="form-control" id="courseOrder" placeholder="排序权重">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputFile">课程封面</label>
                            <input type="file" id="courseImage" name="courseImage" style="display: inline-block;">
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary" onclick="fileUoload();">保存</button>
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

    function fileUoload() {
        //2.通过jq获得input数组
        var $inputArr = $('#myModal input[type=text]');
        var $select = $('#myModal select');
        var map = {};
        //3.循环处理input,并定义结果集
        $inputArr.each(function () {
            //4.将每个input的值放进结果集
            map[$(this).attr("id")] = $(this).val();
        });
        $select.each(function () {
            //4.将每个input的值放进结果集
            map[$(this).attr("id")] = $(this).val();
        });
        //5.打印结果
        console.log(map);
        $.ajaxFileUpload({
            url: '/course/insert',             //用于文件上传的服务器端请求地址
            type: 'post',
            data: map,
            secureuri: false,                   //是否需要安全协议，一般设置为false
            fileElementId: ['courseImage'],        //文件上传域的ID 在这里设置要上传的多个input的ID
            dataType: 'json',                   //返回值类型 一般设置为json
            success: function (data){    //服务器成功响应处理函数
                if (data) {
                    alert("新增成功");

                } else {
                    alert("新增失败");
                }
            }
        });
    }

</script>

</html>