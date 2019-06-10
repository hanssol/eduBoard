<%@page import="kr.or.yhs.board.model.BoardVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
$(document).ready(function(){
	$(".boardnum").on("click",function(){
		var boardnum = $(this).find(".boardnum").text();
		$(".boardnum").val(boardnum);
		$("#frm").submit();	
	})
})	
	
</script>


<div class="col-sm-3 col-md-2 sidebar">
	<ul class="nav nav-sidebar">
		<li class="active"><a href="#">Main <span class="sr-only">(current)</span></a></li>
		
		<li class="active">
			<a href="${pageContext.request.contextPath}/boardManagement">게시판관리</a>
		</li>
		
		<c:forEach items="${boardListY }" var="board" >
			<li class="boardnum active">
				<a href="${pageContext.request.contextPath}/board?boardnum=${board.boardnum}">${board.boardname }</a>
			</li>
		</c:forEach>
		
		
	</ul>
</div>