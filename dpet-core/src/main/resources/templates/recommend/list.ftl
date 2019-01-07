<#include "/layout/layout.ftl" />
<#assign title="推荐统计"/>
<#assign base="/v2"/>
<@html>
<link rel="stylesheet" type="text/css" href="${base}/static/datepicker/css/datetimepicker.css">
<link rel="stylesheet" type="text/css" href="${base}/static/datepicker/css/dropdown.css">
<script type="text/javascript" src="${base}/static/datepicker/js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="${base}/static/datepicker/js/bootstrap-datetimepicker.zh-CN.js"></script>
<div class="mainwrap">
	<div class="ftab">
		<div class="ftab-top" style="margin-top:30px;margin-bottom:30px;margin-left:40%;display:none;">
			<div class="col-sm-2">
				<label style="font-size:20px;">查询日期</label>
			</div>
			<div class="col-sm-3" style="margin-left:-6%">
				<input class="form-control" type="text" value="" id="search_date" autocomplete="off">
			</div>
			<a href="javascript:void(0);" class="btn btn-info" id="search">
				<i class="glyphicon glyphicon-search"></i> 搜索
			</a>
		</div>
		<div class="ftab-cont">
			<table class="table table-bordered" id="content_table" style="width:80%;margin-left:10%;font-size:16px;">
				<thead>
					<tr>
						<th width="200">微信昵称</th>
						<th width="100">手机号</th>
						<th width="150">系统id</th>
						<th width="100">推荐数量</th>
					</tr>
				</thead>
				<tbody id="contentList">
				</tbody>
			</table>
		</div>
	</div>
</div>

<script type="text/javascript">
$(function(){
	//初始化今天
	var today = getLocalTime2(new Date(), "yyyy-MM-dd");
	$("#search_date").val(today);
	loadSContent();
	$("#search_date").datetimepicker({
		language: "zh-CN",
		minView: "month",//设置只显示到月份
		format : "yyyy-mm-dd",//日期格式
		autoclose:true,//选中关闭
		todayBtn: true//今日按钮
	});
	$("#search").click(function(){
		loadSContent();
	});
});

function loadSContent(){
	var date = $("#search_date").val();
	$('#contentList').empty();
	$.ajax({
		url:"${base}/recommend/listData",
		data:{date:date},
		datatype:'json',
		success:function(data){
			var result = data.data;
			if(result.length == 0){
				var tr = '<tr><td colspan="4">无相关数据</td></tr>';
				$('#contentList').append(tr);
			}else{
				for(var i in result) {
					var c = result[i];
					var tr = '<tr>'
						   + '	<td>'+c.wechatNickname+'</td>'
						   + '	<td>'+c.phone+'</td>'
						   + '	<td>'+c.id+'</td>'
						   + '	<td>'+c.number+'</td>'
						   + '</tr>';
					$('#contentList').append(tr);
				}
			}
        }
	});
}
</script>
</@html>
