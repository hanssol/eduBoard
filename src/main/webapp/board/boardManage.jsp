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
<script >

$(document).ready(function(){
	$(".boardAddTr").find("button").on("click",function(){
		
		$("#frmAdd").submit();
	})

	$(".boardTr").find("button").on("click",function(){
		var a = $(this).closest(".boardTr").find(".boardNM").children("#boardnum").val();
		$("#boardnum1").val(a);
		var b = $(this).closest(".boardTr").find(".use_yn").children("#yn").val();
		$("#use_yn1").val(b);
		var c = $(this).closest(".boardTr").find(".boardNM").children("#boardname").val();
		$("#boardname1").val(c);
		
		
		$("#frm").submit();
	})
	
	//생성 버튼 눌렀을때에는 기존  controller  타게 하세요
	// 수정 버튼 눌렀을 때  새로운 경로를 타게 해야함  action 의 경로를 변경해야함  attr 이벤트 써서
	
})
</script>
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
						<form id="frmAdd" class="form-horizontal" role="form"
								action="${pageContext.request.contextPath }/boardAdd"
								method="post">
						<input type="hidden" name="userId" id="userId" value="${USER_INFO.userId }"/> 
						<div class="table-responsive">
							<table class="table table-striped">
								<tr class="boardAddTr">
									<td> 게시판 이름 </td>
									<td id="boardAddTd"> <input type="text" name="boardAddname" id="boardAddname"/> </td>
									<td id="boardYNTd">
										<select name="yn" id="yn">
											<option value="yes" selected="selected">사용</option>
											<option value="no" name="use_yn" id="use_yn">미사용</option>
										</select>
									</td>
									<td>
										 <button type="button" id="boardAdd" name="boardAdd" class="btn btn-default pull-right"> 생성 </button>
									</td>
									
								</tr>
						
							</table>
						</div>
						
						</form>
						
						
						<h2 class="sub-header">게시판 수정</h2>
						
						<form id="frm" class="form-horizontal" role="form"
								action="${pageContext.request.contextPath }/boardManagement"
								method="post">
						<input type="hidden" name="boardnum1" id="boardnum1"/> 
						<input type="hidden" name="use_yn1" id="use_yn1"/> 
						<input type="hidden" name="boardname1" id="boardname1" /> 
						
						
						
								
						<div class="table-responsive">
							<table class="table table-striped">
							
								<c:forEach items="${boardList }" var="board">
									<tr class="boardTr">
												<td> 게시판 이름 </td>
												<td class="boardNM"> 
													<input type="text" name="boardname" id="boardname" value="${board.boardname }"/> 
												
													<input type="hidden" name="boardnum" id="boardnum" value="${board.boardnum }"/> 
												</td>
										<c:choose>
											<c:when test="${board.use_yn == 'yes' }">
												<td class="use_yn">
													 <select name="yn" id="yn">
														<option value="yes" selected="selected">사용</option>
														<option value="no" name="use_yn" id="use_yn">미사용</option>
													</select>
												<td>
											</c:when>
											
											<c:otherwise>
												<td class="use_yn">
													<select name="yn" id="yn">
														<option value="yes" name="use_yn" id="use_yn" >사용</option>
														<option value="no" selected="selected">미사용</option>
													</select>
												<td>
											</c:otherwise>
										</c:choose>
											<td>
												 <button type="button" id="useChange" name="useChange" class="btn btn-default pull-right"> 수정 </button>
											</td>
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
						
					</form>

					</div>
				</div>

			</div>
		</div>
	</div>
</body>
</html>
