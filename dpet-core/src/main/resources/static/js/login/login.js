var dataMap = {};
var user_type;
var school_id;
var uuid;

toastr.options = {
		  "closeButton": true,
		  "debug": false,
		  "progressBar": true,
		  "positionClass": "toast-top-center",
		  "onclick": null,
		  "showDuration": "400",
		  "hideDuration": "1000",
		  "timeOut": "1500",
		  "extendedTimeOut": "1000",
		  "showEasing": "swing",
		  "hideEasing": "linear",
		  "showMethod": "fadeIn",
		  "hideMethod": "fadeOut"
		};
var msk = $('<div id="msk"></div>').css({
	'width':'100%',
	'height':$(window).height(),
	'position':'absolute',
	'top':0,
	'left':0,
	'bottom':0,
	'background':'rgba(0,0,0,.4)',
	'z-index':1
});

function bindSuperAdminBtnClickEvent(){
	$('#btn-SuperAdmin').on('click',function(){
		$('body').append(msk);
		$('.tc-tit').html("超级管理员登录");
		$('#inputUserType').val("003099");
		$('#SuperAdmin-tc').show();
		$('#msk').on('click',function(e){
			e.stopPropagation();
			$(this).remove();
			$('#SuperAdmin-tc').hide();
		});
	});
}
function bindAdminBtnClickEvent(){
	$('#btn-Admin').on('click',function(){
		$('body').append(msk);
		$('#SuperAdmin-tc').show();
		$('#msk').on('click',function(e){
			e.stopPropagation();
			$(this).remove();
			$('#SuperAdmin-tc').hide();
		});
	});
}

//忘记密码功能
function bindForgetPassWordClickEvent(){
	$('#forget').on('click',function(){
		$('#SuperAdmin-tc').hide();
		$('body').append(msk);
		$('.tc-tit').html("忘记密码");
		$('#phone1').empty();
		$('#validateCode').empty();
		$('#fpassword').empty();
		$('#fpass_word').click();
		$('#forgetPassword').show();
		$('#msk').on('click',function(e){
			e.stopPropagation();
			$(this).remove();
			$('#forgetPassword').hide();
		});
	});
}

//获取验证码
function bindValidateCodeBtnClickEvent(){
	$('#getValidateCode').on('click',function(){
		settime($('#getValidateCode'));
		$.myajax({
			url:"/userAction/getValidateCode",
			data:{phone:$('#phone1').val()},
			datatype:'json',
			success:function(data){}
		});
	});
}

//修改密码
function bindUpdateForgetPassword(){
	$('#changeBtn').on('click',function(){
		var phone = $('#phone1').val();
		var validateCode = $('#validateCode').val();
		var fpassword = $('#fpassword').val();
		if (phone==null || phone == ''
			||validateCode == null || validateCode == ''
			||fpassword == null || fpassword == ''){
			toastr.info("电话号码、验证码或者新密码不能为空!","提示");
		} else {
			$.myajax({
				url:"/userAction/forgetPassword",
				data:{phone:phone,password:fpassword,validate_code:validateCode},
				datatype:'json',
				success:function(data){
					$('#changeBtn').attr('disabled','disabled');
					toastr.info("密码修改成功,请重新登录!","提示");			
					setShowDuration();
				}
			});
		}
	});
}
var showDuration=1; 
function setShowDuration() {
	if (showDuration == 0) { 
		window.location.href = window.location.href;
	} else { 
		--showDuration; 
		setTimeout(function(){				//设置倒计时速度时时间走起来
			setShowDuration();
		},1000);
	} 	
}

var countdown=60; 							//设置倒计时最大时间
function settime(val) { 
	if (countdown == 0) { 
		val.val("重新发送验证码");
		val.attr("disabled",false);
	} else { 
		val.val("重新发送("+countdown+")");
		--countdown; 
		setTimeout(function(){				//设置倒计时速度时时间走起来
			settime(val);
		},1000);
	} 	
}

function bindAgentBtnClickEvent(){
	$('.btn-agent').on('click',function(){
		$('body').append(msk);
		$('#SuperAdmin-tc').show();
		$('#msk').on('click',function(e){
			e.stopPropagation();
			$(this).remove();
			$('#SuperAdmin-tc').hide();
		});
	});
}

function bindLoginClickEvent(){
	$("#loginBtn").unbind("click").on('click', function() {
		$('#pass_word').val($.md5($("#password").val()));
		$('#loginForm').submit();
	});
}

function bindSubmitCallBackEvent(){
	$(".loginForm").ajaxForm({
	    beforeSend: function() {
	    	toastr.clear();
	    },
	    success: function(data) {
	    	var code = data.code;
	    	if (code != 1&&code != undefined) {
	    		toastr.options = {
	    				  "closeButton": true,
	    				  "debug": false,
	    				  "progressBar": true,
	    				  "positionClass": "toast-top-center",
	    				  "onclick": null,
	    				  "showDuration": "400",
	    				  "hideDuration": "1000",
	    				  "timeOut": "1500",
	    				  "extendedTimeOut": "1000",
	    				  "showEasing": "swing",
	    				  "hideEasing": "linear",
	    				  "showMethod": "fadeIn",
	    				  "hideMethod": "fadeOut"
	    				};
	    		toastr.info(data.msg,"提示");
	    		return;
	    	}
	    	var user = data.result.data;
	    	localStorage.setItem('username', user.userame);
	    	localStorage.setItem('phone', user.phone);
	    	window.location.href = "/indexAction/index";
	    },
	    error:function(err){
	      toastr.options = {
                "closeButton": true,
                "debug": false,
                "progressBar": true,
                "positionClass": "toast-top-center",
                "onclick": null,
                "showDuration": "400",
                "hideDuration": "1000",
                "timeOut": "1500",
                "extendedTimeOut": "1000",
                "showEasing": "swing",
                "hideEasing": "linear",
                "showMethod": "fadeIn",
                "hideMethod": "fadeOut"
              };
          toastr.info('未请求到服务器！',"提示");
	    }
	});
} 

function bindBackDefaulLoginClickEvent(){
	$("#aBackDefaultLogin").unbind("click").on('click', function() {
		$('#scanLoginForm').hide();
		$('#userInfoForm').hide();
		$('#loginForm').show();
	});
};

function bindBackScanLoginClickEvent(){
	$("#aBackScanLogin").unbind("click").on('click', function() {
		$('#userInfoForm').hide();
		$('#loginForm').hide();
		$('#scanLoginForm').show();
	});
};


function getUuid() {
    var s = [];
    var hexDigits = "0123456789abcdef";
    for (var i = 0; i < 36; i++) {
        s[i] = hexDigits.substr(Math.floor(Math.random() * 0x10), 1);
    }
    s[14] = "4";  // bits 12-15 of the time_hi_and_version field to 0010
    s[19] = hexDigits.substr((s[19] & 0x3) | 0x8, 1);  // bits 6-7 of the clock_seq_hi_and_reserved to 01
    s[8] = s[13] = s[18] = s[23] = "";
    uuid = s.join("");
    return uuid;
}
