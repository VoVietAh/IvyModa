<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous" />
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="style.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.css" />
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
        <div class="row">
          <div class="post-grid d-flex flex-wrap justify-content-between">
          	<c:forEach var="item" items="${items}">
            <div class="col-lg-4 col-sm-12">
              <div class="card border-none me-3">
                <div class="card-image">
                  <a href="/cart/add/${item.id}">
                  <img  src="${item.img}" alt="" class="img-fluid">
                </a>
                </div>
              </div>
              <div class="card-body text-uppercase">
                <div class="card-meta text-muted">
                  <span style="color: var(--primary-color);" class="meta-category">- ${item.price}đ</span>
                </div>
                <h3 class="card-title">
                  <a href="/cart/add/${item.id}">${item.name}</a>
                </h3>
              </div>
            </div>
            </c:forEach>
          </div>
        </div>
      </div>
</body>
</html>