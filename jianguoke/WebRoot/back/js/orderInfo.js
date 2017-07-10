//订单id,招聘信息ID,手机号查询方法
function searchInfo(search, url) {
	if (search) {
		$.ajax({
					type: "POST",
					url : url,
					data : {
						"data" : search
					},
					dataType : "json",
					success : function(msg) {
						if (msg.length>0) {
							if (msg.fail) {
								/*
								 * $(".tab-head").hide(); $("#order-info
								 * tr:not(:first)").empty("");
								 * 
								 * var $cen=$('<tr></tr>'); var $td=$('<td>'+data.fail+'</td>')
								 * $cen.append($td);
								 * $("#order-info").append($cen);
								 */
								alert("抱歉数据库中没有该记录");	
							} else {
								var count = 0;
								console.log(msg);
								/*var info = $.parseJSON(data);*/
								/*console.log(allInfo);*/
								$(".tab-head").show();
								$("#order-info tr:not(:first)").empty("");
								$.each(msg,function(index, data) {
											var result;
											var index = index + 1;
											count++;
											console.log(data.order_state);
											switch(data.order_state){
											case 20:
												 result="已取消";
												break;
											case 21:
											result="未完成";
												break;
											case 22:
											 result="已完成";
												break;
											default:
												break;
											}
											var $tr = $('<tr></tr>');
											var number = $('<td>' + 1 + '</td>')
											var order_id = $('<td>' + data.order_id
													+ '</td>');
											var rec_infoid = $('<td>' + data.rec_infoid
											+'</td>');
											var state = $('<td>' + result
													+ '</td>');
											var sell_id=$('<td>' + data.sell_id
													+ '</td>');
											var access = $('<td>' + data.stu_id
													+ '</td>');
											var salary = $('<td>' + data.order_salary
													+ '</td>');
											var starttime = $('<td>'
													+ data.order_starttime + '</td>');
											var endtime = $('<td>' + data.order_endtime
													+ '</td>');
											var details = $("<td><a class='button border-main' style='cursor:pointer;'><span class='icon-edit'></span>查看详情</a> </td>");

											$tr.append(number).append(order_id).append(rec_infoid).append(sell_id).append(
													state).append(access)
													.append(salary).append(starttime)
													.append(endtime).append(details);
											$("#order-info").append($tr);
										
										 });

								var btn = $("<tr><td colspan='2'><span class='search-records'></span></td><td colspan='6'><div class='pagelist'><a href=''>上一页</a> <span class='current'>1</span><a href=''>2</a><a href=''>3</a><a href=''>下一页</a><a href=''>尾页</a></div></td></tr>");
								$("#order-info").append(btn);
								$(".search-records").text("共检索到" + count + "条记录");
					        }
		                    
		                    }
						else if(msg.length==0) {
							$(".tab-head").hide();
							$("#order-info tr:not(:first)").empty("");
							var $tr=$("<tr style='text-align:center;font-size:16px;color:#f00;'><td>很抱歉，数据库中没有此记录！！！</td></tr>")
							$("#order-info").append($tr);
						}
		                }
		            })
		        }
	else {
	    alert("请正确输入");
		}
}
//订单分类查询方法
function ajax(message,url){
$.ajax({
			type: "GET",
			url : url,
			data:{
				"type":message
			},
			dataType : "json",
			success : function(msg) {
				var count = 0;
				console.log(msg);
				$(".tab-head").show();
				$("#order-info tr:not(:first)").empty("");
				$.each(msg,function(index, data) {
									var result;
									var index = index + 1;
									count++;
									switch(data.order_state){
									case 20:
										 result="已取消";
										break;
									case 21:
									result="未完成";
										break;
									case 22:
									 result="已完成";
										break;
									default:
										break;
									}
									var $tr = $('<tr></tr>');
									var number = $('<td>' + index + '</td>')
									var order_id = $('<td>' + data.order_id
											+ '</td>');
									var rec_infoid = $('<td>' + data.rec_infoid
									+'</td>');
									var sell_id=$('<td>' + data.sell_id
											+ '</td>');
									var state = $('<td>' + result
											+ '</td>');
									var access = $('<td>' + data.stu_id
											+ '</td>');
									var salary = $('<td>' + data.order_salary
											+ '</td>');
									var starttime = $('<td>'
											+ data.order_starttime + '</td>');
									var endtime = $('<td>' + data.order_endtime
											+ '</td>');
									var details = $("<td><a class='button border-main' style='cursor:pointer;'><span class='icon-edit'></span>查看详情</a> </td>");

									$tr.append(number).append(order_id).append(rec_infoid).append(sell_id).append(
											state).append(access)
											.append(salary).append(starttime)
											.append(endtime).append(details);
									$("#order-info").append($tr);
								})
			var btn = $("<tr><td colspan='2'><span class='search-records'></span></td><td colspan='6'><div class='pagelist'><a href=''>上一页</a> <span class='current'>1</span><a href=''>2</a><a href=''>3</a><a href=''>下一页</a><a href=''>尾页</a></div></td></tr>");
			$("#order-info").append(btn);
				$(".search-records").text("共检索到" + count + "条记录");
			}
		});
};
//通用ajax二次封装方法
var myAjax = function(opt){
    $.ajax(
    {   url:opt['url'],
        type:opt['method'],
        data:opt['data'],
        dataType:opt['dataType'],
        success:function(msg){
              opt['callBack'](msg);
        }
    });
}      

/*var test = function(){
var opt = {
     url:'demo.php',
     method:'post',
     data:{key:'a',value:'1'},
    callBack:scss
}
myAjax(opt);
}
function scss(res){   alert(res);}*/

$(function() {
	ajax("全部订单","../orderInfoAll.action");//页面初始化全部订单列表
	$("#salary-query").click(function(){
		var minsalary=$(".min-sal").val();
		var maxsalary=$(".max-sal").val();
		console.log(minsalary);
		console.log(maxsalary);
		if(minsalary&&maxsalary>minsalary){
			myAjax({
				url:"../orderSalary.action",
				type:"POST",
				data:{"min-salary":minsalary,"max-salary":maxsalary},
				dataType:"json",
				callBack:salaryQuery
				
			})
		}
		else{
			alert("输入格式有问题")
		}
		
	})
	$("#search-id").keydown(function(event) {
		if (event.keyCode == 13) {
			var search = $("#search-id").val();
			var url = "../fuzzyQuery.action";
			$("#search-id").val("");
			searchInfo(search, url);
		}
	});
	//监听输入框单击回车事件
	$("#search").click(function() {
		var search = $("#search-id").val();
		var url = "../fuzzyQuery.action";
		$("#search-id").val("");
		searchInfo(search, url);
	});
	$("#order-select").change(function() {
		var url;
		var value = $(this).find("option:selected").text();
		switch (value) {
		case "全部订单":
			url = "../orderInfoAll.action";
			ajax(value, url);
			break;
		case "已完成订单":
			url ="../othersOrderInfo.action";
			ajax(value,url);
			break;
		case "未完成订单":
			url="../othersOrderInfo.action";
			ajax(value,url);
			break;
		case "已取消订单":
			url="../othersOrderInfo.action";
			ajax(value,url);
			break;
			default:break;
		}
	});
	$("#order-info tbody").on("click","a.border-main",function(event){
		/*stopBubble(event);*/
		
		var $rec_id=$(this).parent().siblings().eq(2).text();
		var $sell_id=$(this).parent().siblings().eq(3).text();
		$(".order-id").text($(this).parent().siblings().eq(1).text());
		$(".user-phone").text($(this).parent().siblings().eq(5).text());
		$(".order-salary").text($(this).parent().siblings().eq(6).text());
		$(".state").text($(this).parent().siblings().eq(4).text());
		$(".order-starttime").text($(this).parent().siblings().eq(7).text());
		$(".order-endtime").text($(this).parent().siblings().eq(8).text());
		myAjax({
			url:"../orderDetails.action",
			type:"GET",
			data:{"rec_id":$rec_id,"sell_id":$sell_id},
			dataType:"json",
			callBack:joinQuery
			
		})
		$("#myModal").modal("show");
		
	})
	/*$("#order-info tbody").on("click","tr",function(){
	alert($(this).find("td").eq(2).text());
})*/
	/*$(".but").click(function(){

		$(".mask-layer").hide();
		$(".pop-up").hide();
	})*/

});
//连接查询订单详情
function joinQuery(data){
	console.log(data);
	if(data.success){
		$(".order-type").text(data.order_details[0]);
		$(".work-content").text(data.order_details[3]);
		$(".order-publish").text(data.order_details[4]);
		$(".order-publish-address").text(data.order_details[6]);
		$(".order-publish-phone").text(data.order_details[5]);
		}
	else if(data.failed==1005){
		$(".order-type").text("");
		$(".work-content").text("");
		$(".order-publish").text("");
		$(".order-publish-address").text("");
		$(".order-publish-phone").text("");
	}
	}
//根据订单薪酬筛选查询
function salaryQuery(msg){
	console.log(msg);
}
//阻止冒泡事件
function stopBubble(e){
	if(e && e.stopPropagation){
	e.stopPropagation();	//w3c
	}else window.event.cancelBubble=true; //IE
	}
/*
 * function del(id){ if(confirm("您确定要删除吗?")){
 *  } }
 * 
 * $("#checkall").click(function(){ $("input[name='id[]']").each(function(){ if
 * (this.checked) { this.checked = false; } else { this.checked = true; } }); })
 * function DelSelect(){ var Checkbox=false;
 * $("input[name='id[]']").each(function(){ if (this.checked==true) {
 * Checkbox=true; } }); if (Checkbox){ var t=confirm("您确认要删除选中的内容吗？"); if
 * (t==false) return false; } else{ alert("请选择您要删除的内容!"); return false; } }
 */