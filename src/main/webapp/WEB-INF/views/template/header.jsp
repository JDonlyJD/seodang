<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!-- 상단 시작 -->
<div class="container">
	<div class="flexdisplay">
		<div class="logo">
			<a href="${pageContext.request.contextPath }/main/main.do" class="align-left"><b>서당개3년</b></a>
		</div>
		<div class="menu clearfix">
			<a href="${pageContext.request.contextPath}/onclass/onclassList.do" class="menu-item"><b>온라인</b></a>
			<a href="${pageContext.request.contextPath}/offclass/offclassList.do" class="menu-item"><b>오프라인</b></a>
			<a href="#" class="menu-item"><b>키트</b></a>
		</div>
		<div class="login align-right">
	    	<c:if test="${!empty session_user_num && !empty session_user_photo}">
	    		<img src="${pageContext.request.contextPath}/user/photoView.do" 
	    	                        width="25" height="25" class="my-photo">
	    	</c:if>
	    	<c:if test="${!empty session_user_num && empty session_user_photo}">
	    		<img src="${pageContext.request.contextPath}/resources/images/face.png" 
	    	                        width="25" height="25" class="my-photo">
	    	</c:if>
			<c:if test="${!empty session_user_num}">
				[<span>${session_user_name}</span>]
				<a href="${pageContext.request.contextPath}/user/logout.do">로그아웃</a>
			</c:if>
			<c:if test="${empty session_user_num}">
				<a href="${pageContext.request.contextPath}/user/registerUser.do">회원가입</a>
				<a href="${pageContext.request.contextPath}/user/login.do">로그인</a>
			</c:if>
			<c:if test="${!empty session_user_num && session_user_auth == 2}">
				<a href="${pageContext.request.contextPath}/user/myPage.do">MY페이지</a>
			</c:if>
			<a href="${pageContext.request.contextPath}/main/main.do">홈으로</a>
		</div>
	</div>
	</div>
	<div class="align-right">
		<a href="#" class="logo">게시판</a>
		<a href="#" class="logo">Q&amp;A</a>
	</div>
<div>
<!-- 상단 끝 -->