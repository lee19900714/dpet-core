<#-- 页面Layout宏 -->
<#assign title="保车连"/>
<#macro html>
<!DOCTYPE html>
<!--[if ie 6]>
<html class="ie6 lt-ie9 lt-ie8" lang="zh-CN">
<![endif]-->
<!--[if ie 7]>
<html class="ie7 lt-ie9 lt-ie8" lang="zh-CN">
<![endif]-->
<!--[if ie 8]>
<html class="ie8 lt-ie9" lang="zh-CN">
<![endif]-->
<!--[if ie 9]>
<html class="ie9" lang="zh-CN">
<![endif]-->
<!--[if !ie]><!-->
<html lang="zh-CN">
<!--<![endif]-->
<head>
	<meta charset="UTF-8" />
	<title>${title}</title>
	<link rel="stylesheet" type="text/css" href="${base}/static/hplus/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="${base}/static/hplus/css/font-awesome.min.css">
	<link href="${base}/static/article/css/style.min.css" rel="stylesheet">
	<link href="${base}/static/hplus/css/plugins/toastr/toastr.min.css" rel="stylesheet" type="text/css" />
	<link href="${base}/static/hplus/css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
	
	<script type="text/javascript" src="${base}/static/hplus/js/jquery.min.js"></script>
	<script type="text/javascript" src="${base}/static/js/alerts.js"></script>
	<script type="text/javascript" src="${base}/static/js/myajax.js"></script>
	<script type="text/javascript" src="${base}/static/hplus/js/bootstrap.min.js?v=3.3.5"></script>
	<script src="${base}/static/hplus/js/plugins/toastr/toastr.min.js"></script>
	<script type="text/javascript" src="${base}/static/hplus/js/bootstrap-paginator.js"></script>
	<script type="text/javascript" src="${base}/static/js/functionUtil.js"></script>
	<script src="${base}/static/hplus/js/plugins/sweetalert/sweetalert.min.js"></script>
</head>
<body>
	<#nested>
<script>
function getLocalTime(nS, format) { 
	return new Date(parseInt(nS)).format(format);
} 

function getLocalTime2(date, format) { 
	return date.format(format);
} 

Date.prototype.format = function(format) {
       var date = {
              "M+": this.getMonth() + 1,
              "d+": this.getDate(),
              "h+": this.getHours(),
              "m+": this.getMinutes(),
              "s+": this.getSeconds(),
              "q+": Math.floor((this.getMonth() + 3) / 3),
              "S+": this.getMilliseconds()
       };
       if (/(y+)/i.test(format)) {
              format = format.replace(RegExp.$1, (this.getFullYear() + '').substr(4 - RegExp.$1.length));
       }
       for (var k in date) {
              if (new RegExp("(" + k + ")").test(format)) {
                     format = format.replace(RegExp.$1, RegExp.$1.length == 1
                            ? date[k] : ("00" + date[k]).substr(("" + date[k]).length));
              }
       }
       return format;
}
</script>
</body>
</html>
</#macro>
