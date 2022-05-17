<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name = "current" %>
<div style="justify-content:center;">
<c:url value = "/study/studyBoard/" var = "listUrl"></c:url>
<c:url value = "/study/studyWrite/" var = "insertUrl"></c:url>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="${listUrl }"><i class = "fa-solid fa-house"></i></a>
    <div class="navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link ${current == 'list' ? 'active' : '' }" href="${listUrl }"> 목록보기</a>
        </li>
        <li class="nav-item">
          <a class="nav-link ${current == 'insert' ? 'active' : '' }" href="${insertUrl }">글쓰기</a>
        </li>
      </ul>
    </div>
  </div>
</nav>
</div>