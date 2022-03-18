<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!-- 상단 시작 -->
<h2 class="align-center">Star Hompy</h2>
<div class="align-right">
    <c:if test="${!empty user_num && !empty user_photo}">
    	<img src="${pageContext.request.contextPath}/user/photoView.do" 
    	                        width="25" height="25" class="my-photo">
    </c:if>
    <c:if test="${!empty user_num && empty user_photo}">
    	<img src="${pageContext.request.contextPath}/resources/images/face.png" 
    	                        width="25" height="25" class="my-photo">
    </c:if>
	<c:if test="${!empty user_num}">
		[<span>${user_name}</span>]
		<a href="${pageContext.request.contextPath}/user/logout.do">로그아웃</a>
	</c:if>
	<c:if test="${empty user_num}">
		<a href="${pageContext.request.contextPath}/user/registerUser.do">회원가입</a>
		<a href="${pageContext.request.contextPath}/user/login.do">로그인</a>
	</c:if>
	<c:if test="${!empty user_num && user_auth == 2}">
		<a href="${pageContext.request.contextPath}/user/myPage.do">MY페이지</a>
	</c:if>
	<c:if test="${!empty user_num && user_auth == 3}">
		<a href="${pageContext.request.contextPath}/onclass/onclassList.do">온라인</a>
	</c:if>
	<a href="${pageContext.request.contextPath}/main/main.do">홈으로</a>
</div>
<!-- 상단 끝 -->