<%@page import="kr.or.yhs.user.model.UserVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>게시판 관리</title>

<!-- css,js -->
<%@include file="/common/basicLib.jsp" %>

</head>

<body>
	<!-- header -->
	<%@include file="/common/header.jsp" %>
	<div class="container-fluid">
		<div class="row">

			<!-- left -->
			<%@include file="/common/left.jsp" %>
			
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">게시판 생성</h2>
						<div class="table-responsive">
							<table class="table table-striped">
								<ul>
									<li>
										<input type="text" name="board" value="자유게시판"/>
										<select name="yn">
											<option value="사용" selected="selected">사용</option>
											<option value="미사용">미사용</option>
										</select>
									</li>
									
								</ul>
<%-- 								<% 
// 									List<UserVo> userList = (List<UserVo>)request.getAttribute("userList");
							%> --%>
								<!-- userList의 데이터를 한건 조회해서
									 pageContext.setAttribute("user",vo); -->
								<c:forEach items="${userList}" var="user">
								<tr>
									<td>${user.userId}</td>
									<td>${user.name}</td>
									<td>${user.alias}</td>
									<td></td>
								
								</tr>
									
								</c:forEach>
<%-- 								<% 
// 										for(int i=0;i<userList.size();i++){
// 										out.write("<tr>");
// 										out.write("<td>"+userList.get(i).getUserId()+"</td>");
// 										out.write("<td>"+userList.get(i).getName()+"</td>");
// 										out.write("<td>"+userList.get(i).getalias()+"</td>");
// 										out.write("<td>"+"</td>");
// 										out.write("</tr>");
// 									}
								%> --%>
								
								
							</table>
						</div>

						<a class="btn btn-default pull-right">게시판 등록</a>

					</div>
				</div>

			</div>
		</div>
	</div>
</body>
</html>
