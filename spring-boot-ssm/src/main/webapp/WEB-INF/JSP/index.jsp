<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>显示用户信息</title>
		<link rel="stylesheet" type="text/css" href="/static/css/new.css" />
		<script src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
	</head>
	<body>
		<input type="hidden" name="next" value="5"/>
		<table border="" align="center" width="50%">
			<tr>
				<th>编号</th>
				<th>姓名</th>
				<th>性别</th>
			</tr>
			<c:forEach items="${page.list}" var="user">
				<tr class="data">
					<td>${user.id}</td>
					<td>${user.name}</td>
					<td>${user.sex}</td>
				</tr>
			</c:forEach>
			<tr>
				<td id="cz" colspan="3">
					<%-- <a href="showuser">首页</a>
					<c:if test="${page.pageNum<page.pages}">
					<a href="showuser?pageNum=${page.pageNum+1}">下一页</a>
					</c:if>
					<c:if test="${page.pageNum>1}">
					<a href="showuser?pageNum=${page.pageNum-1}">上一页</a>
					</c:if>
					<a href="showuser?pageNum=${page.pages}">尾页</a>
					<a href="#">当前${page.pageNum}页</a>
					<a href="#">共${page.pages}页</a> --%>
					<a href="#" name="1" onclick="page(this)">首页</a>
					<c:if test="${page.pageNum<page.pages}">
					<a href="#" name="${page.pageNum+1}" onclick="page(this)">下一页</a>
					</c:if>
					<c:if test="${page.pageNum>1}">
					<a href="#" name="${page.pageNum-1}" onclick="page(this)">上一页</a>
					</c:if>
					<a href="#" name="${page.pages}" onclick="page(this)">尾页</a>
					<a href="#">当前${page.pageNum}页</a>
					<a href="#">共${page.pages}页</a>
					<button onclick="down()">导出Excel</button>
				</td>
			</tr>
		</table>
	</body>
	<script type="text/javascript">
		function down(){
			window.location.href="/down" 
		}
		function page(obj){
			var pageNum = $(obj).attr('name');
			$.ajax({
				url:'showuser',
				type:'POST',
				async:true,
				data:{pageNum:pageNum},
				dataType:'json',
				  success:function(data){//data是成功后，接收的返回值
				 	$(".data").remove();
				  	var list = data.list;
				  	var htl = "";
					for(i in list){
						htl+="<tr class='data'>"
						+"<td>"+list[i].id+"</td>"
						+"<td>"+list[i].name+"</td>"
						+"<td>"+list[i].sex+"</td>"
						+"</tr>"
					}
					$("tr:first").after(htl);
					$("#cz").find("a").remove();
					var alabel = "<a href='#' name='1' onclick='page(this)'>首页</a>";
					if(data.pageNum<data.pages){
						alabel+="<a href='#' name='"+(data.pageNum+1)+"' onclick='page(this)'>下一页 </a>";
					}
					if(data.pageNum>1){
						alabel+="<a href='#' name='"+(data.pageNum-1)+"' onclick='page(this)'>上一页</a>";
					}
					alabel+="<a href='#' name='"+data.pages+"' onclick='page(this)'>尾页</a>"
					+"<a href='#'>当前"+data.pageNum+"页</a>"
					+"<a href='#'>共"+data.pages+"页</a>";
					$("tr:last").children("td").prepend(alabel);
				  }
			})
		}
	</script>
</html>