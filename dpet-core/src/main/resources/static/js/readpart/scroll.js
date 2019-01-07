var topHeight = 0; //头部高度变化
	var liArray = []; //章节高度数组排列
	var listBlock ; // 章节目录
	var bodyHeight;
	window.onload = function() {
		var articleHeader = document.getElementsByClassName("article-header")[0]; //头部
		var articleContent = document.getElementsByClassName("article-content")[0]; //主体
		bodyHeight = document.getElementsByTagName('body')[0].clientHeight;
		topHeight = articleHeader.clientHeight;
		listBlock = document.getElementsByClassName("list-block");
		liArray.push(topHeight + 70);
		for(var i = 0 , liHeight = 15 + liArray[0]; i < listBlock.length; i++){
			liHeight += listBlock[i].offsetHeight;
			liArray.push(liHeight);
		}
		liArray.push(60+liArray[liArray.length-1]);
		$(".num").unbind().bind("click",function(){
			isTrue = false;
			var nums = parseInt($(this).text()) - 1;
			topScroll = liArray[nums];
			$('#scroll').animate({
		        scrollTop: topScroll
		    }, 500);
			$(".num").removeClass("active");
			$(this).addClass("active");
			return;
		});
		document.getElementById('scroll').onscroll = function() {
			var lastLi = articleHeader.offsetHeight;
			var t = this.scrollTop;
			if(t<(85 + topHeight)){
		 		if($(".num").eq(0).hasClass("active")){
		 			return
		 		}else{
		 			$(".num").removeClass("active");
		 			$(".num").eq(0).addClass("active");
		 		}
		 	}else{
		 		if(t >= this.scrollHeight - bodyHeight){
			 		$(".num").removeClass("active");
			 		$(".num").eq(listBlock.length-1).addClass("active");
			 		return ;
				}else{
					for(var m = 2; m<listBlock.length+3; m++){
			 			if(t>=liArray[m-2] && t < liArray[m-1]){
			 				if($(".num").eq(m-2).hasClass("active")){
					 			return
					 		}else{
					 			$(".num").removeClass("active");
					 			$(".num").eq(m-2).addClass("active");
					 		}
					 	}
				 	}
				}
		 	}
	    };
	}
	