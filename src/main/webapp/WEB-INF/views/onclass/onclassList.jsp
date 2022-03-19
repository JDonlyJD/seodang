<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.6.0.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<style>
p { margin:20px 0px;}
</style>

<a href="${pageContext.request.contextPath}/onclass/onclassInsert.do">수업 등록</a>
<c:if test="${count == 0}">
	<div class="result-display">표시할 게시물이 없습니다.</div>
</c:if>
<c:if test="${count > 0}">
<c:forEach var="onclass" items="${list}">
		 <div class="container">
	      <div class="row">
	        <div class="col-4">
	          <div class="card">
	            <img src="https://cdn.imweb.me/thumbnail/20190516/5cdd235224d57.jpg" alt="" class="card-img" />
	            <div class="card-img-overlay">
	              <h5 class="card-title" style="color:white;">${onclass.on_name}</h5>
	             	<p class="card-text">${onclass.on_content}</p>
	            </div>
	          </div>
	        </div>
	      <span> <input type="button" value="수정,삭제" onclick="location.href='onclassModify.do?on_num=${onclass.on_num}'"></span>
	      </div> 
	    </div>
	    </c:forEach>
	<div class="align-center">${pagingHtml}</div>
	</c:if>

    