<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
<base href="<%=basePath%>">

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>兼果壳后台管理中心</title>
<link rel="icon" type="image/png" href="./back/images/logo.png" />
<link rel="stylesheet" href="./back/css/pintuer.css">
<link rel="stylesheet" href="./back/css/admin.css">
<script src="./back/js/jquery.js"></script>
</head>

<body style="background-color:#f2f9fd;">
	<div class="header bg-main">
		<div class="logo margin-big-left fadein-top">
			<h1>
				<img src="./back/images/logo.png" class="radius-circle rotate-hover"
					height="50" alt="" />管理中心
			</h1>
		</div>
		<div class="head-l">
			<a class="button button-little bg-green" href="../index.html"
				target="_blank"> <span class="icon-home"></span> 前台首页
			</a> &nbsp;&nbsp; <a href="##" class="button button-little bg-blue">
				<span class="icon-wrench"></span> 清除缓存
			</a> &nbsp;&nbsp; <a class="button button-little bg-red"
				href="../clear.action"> <span class="icon-power-off"></span>
				退出登录
			</a>
		</div>
	</div>
	<div class="leftnav">
		<div class="leftnav-title">
			<strong><span class="icon-list"></span>主菜单</strong>
		</div>
		<h2>
			<span class="icon-user"></span>网站前台
		</h2>
		<ul>
			<li><a href="info.html" target="right"><span
					class="icon-caret-right"></span>网站设置</a></li>
			<li><a href="pass.html" target="right"><span
					class="icon-caret-right"></span>修改密码</a></li>
			<li><a href="page.html" target="right"><span
					class="icon-caret-right"></span>单页管理</a></li>
			<li><a href="adv.html" target="right"><span
					class="icon-caret-right"></span>首页轮播</a></li>
			<li><a href="book.html" target="right"><span
					class="icon-caret-right"></span>留言管理</a></li>
			<li><a href="column.html" target="right"><span
					class="icon-caret-right"></span>栏目管理</a></li>
		</ul>
		<h2>
			<span class="icon-pencil-square-o"></span>兼职众招
		</h2>
		<ul>
			<li><a href="add.jsp" target="right"><span
					class="icon-caret-right"></span>兼职发布</a></li>
			<li><a href="cate.html" target="right"><span
					class="icon-caret-right"></span>兼职分类</a></li>
			<li><a href="cate.html" target="right"><span
					class="icon-caret-right"></span>兼职概况</a></li>
			<li><a href="./back/allpartQuery.jsp" target="right"><span
					class="icon-caret-right"></span>全部兼职</a></li>
			<li><a href="list.html" target="right"><span
					class="icon-caret-right"></span>已完成</a></li>
			<li><a href="list.html" target="right"><span
					class="icon-caret-right"></span>未完成</a></li>
			<li><a href="list.html" target="right"><span
					class="icon-caret-right"></span>已过期</a></li>
			<li><a href="feedBack.html" target="right"><span
					class="icon-caret-right"></span>关键字过滤</a></li>
		</ul>
		<h2>
			<span class="icon-pencil-square-o"></span>认证反馈
		</h2>
		<ul>
			<li><a href="informationConfirmation.html" target="right"><span
					class="icon-caret-right"></span>学生信息认证</a></li>
			<li><a href="userManage.html" target="right"><span
					class="icon-caret-right"></span>商家信息认证</a></li>
			<li><a href="feedBack.html" target="right"><span
					class="icon-caret-right"></span>反馈管理</a></li>
		</ul>
		<h2>
			<span class="icon-pencil-square-o"></span>订单管理
		</h2>
		<ul>
			<li><a href="informationConfirmation.html" target="right"><span
					class="icon-caret-right"></span>全部订单</a></li>
			<li><a href="userManage.html" target="right"><span
					class="icon-caret-right"></span>已完成</a></li>
			<li><a href="cate.html" target="right"><span
					class="icon-caret-right"></span>未完成</a></li>
			<li><a href="feedBack.html" target="right"><span
					class="icon-caret-right"></span>已取消</a></li>
		</ul>
		<h2>
			<span class="icon-pencil-square-o"></span>微招圈
		</h2>
		<ul>
			<li><a href="informationConfirmation.html" target="right"><span
					class="icon-caret-right"></span>全部微招</a></li>
			<li><a href="informationConfirmation.html" target="right"><span
					class="icon-caret-right"></span>区块微招()</a></li>
			<li><a href="userManage.html" target="right"><span
					class="icon-caret-right"></span>已完成</a></li>
			<li><a href="cate.html" target="right"><span
					class="icon-caret-right"></span>未完成</a></li>
			<li><a href="feedBack.html" target="right"><span
					class="icon-caret-right"></span>已取消</a></li>
			<li><a href="feedBack.html" target="right"><span
					class="icon-caret-right"></span>关键字过滤</a></li>
		</ul>
		<h2>
			<span class="icon-pencil-square-o"></span>学生商家
		</h2>
		<ul>
			<li><a href="informationConfirmation.html" target="right"><span
					class="icon-caret-right"></span>全部商家</a></li>
			<li><a href="informationConfirmation.html" target="right"><span
					class="icon-caret-right"></span>商家分类</a></li>
			<li><a href="userManage.html" target="right"><span
					class="icon-caret-right"></span>商家信息</a></li>
			<li><a href="feedBack.html" target="right"><span
					class="icon-caret-right"></span>关键字过滤</a></li>
			<li><a href="informationConfirmation.html" target="right"><span
					class="icon-caret-right"></span>全部学生</a></li>
			<li><a href="informationConfirmation.html" target="right"><span
					class="icon-caret-right"></span>学生分类</a></li>
			<li><a href="userManage.html" target="right"><span
					class="icon-caret-right"></span>学生信息</a></li>
			<li><a href="feedBack.html" target="right"><span
					class="icon-caret-right"></span>关键字过滤</a></li>
		</ul>
		<h2>
			<span class="icon-pencil-square-o"></span>信用体系
		</h2>
		<ul>
			<li><a href="userManage.html" target="right"><span
					class="icon-caret-right"></span>全部信用评价</a></li>
			<li><a href="informationConfirmation.html" target="right"><span
					class="icon-caret-right"></span>信用规则调整</a></li>
			<li><a href="informationConfirmation.html" target="right"><span
					class="icon-caret-right"></span>信用等级分类</a></li>
			<li><a href="userManage.html" target="right"><span
					class="icon-caret-right"></span>信用人工调整</a></li>
		</ul>
		<h2>
			<span class="icon-pencil-square-o"></span>网站数据统计
		</h2>
		<ul>
			<li><a href="userManage.html" target="right"><span
					class="icon-caret-right"></span>全部信用评价</a></li>
			<li><a href="informationConfirmation.html" target="right"><span
					class="icon-caret-right"></span>信用规则调整</a></li>
			<li><a href="informationConfirmation.html" target="right"><span
					class="icon-caret-right"></span>信用等级分类</a></li>
			<li><a href="userManage.html" target="right"><span
					class="icon-caret-right"></span>信用人工调整</a></li>
		</ul>
	</div>
	<ul class="bread">
		<li><a href="{:U('Index/info')}" target="right" class="icon-home">
				首页</a></li>
		<li><a href="##" id="a_leader_txt">网站信息</a></li>
		<li><b>当前语言：</b><span style="color:red;">中文</php></span>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;切换语言： <a href="##">中文</a> &nbsp;&nbsp;<a
			href="##">英文</a></li>
	</ul>
	<div class="admin">
		<iframe scrolling="auto" rameborder="0" src="./back/informationConfirmation.html"
			name="right" width="100%" height="100%"></iframe>
	</div>
	<div style="text-align:center;">
		<p>兼果壳 @2016-2017 Designed by Limer</p>
	</div>
</body>
<script type="text/javascript">
	$(function() {
		$(".leftnav h2").click(function() {
			$(this).next().slideToggle(200);
			$(this).toggleClass("on");
		});
		$(".leftnav ul li a").click(function() {
			$("#a_leader_txt").text($(this).text());
			var strHtml;
			var thishref = $(this).attr("href");
			$(".leftnav ul li a").removeClass("on");
			$(this).addClass("on");
	 	/* $.ajax({
	            type: "Post",
	            url: "markPage.action",
	            //dataType: "html",
	            data: {
	            	mark:"hrefcookie",
	                thishref:thishref
	            },
	            success: function(msg) {
	            	if (JSON.parse(msg).length === 0) {
	                    strHtml = "目前还没有找到数据";
	                }
	            	var a=JSON.parse(msg);
	            	a["admin_phone"];
	            	//each用于list集合读取，单条
	                $.each(JSON.parse(msg), function(index, info) {
	                	alert(info.toString());
	                    strHtml +=info["admin_phone"];
	                    alert(info["admin_phone"]+info.admin_phone);
	                    strHtml +=info["admin_password"];
	                    strHtml +=info["admin_name"];	                    
	                });
	            	//alert(a["admin_phone"]);
	            }
	        });		 */
		});
	});
</script>
</html>
