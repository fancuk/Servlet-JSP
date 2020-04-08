<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head></head>
<body>
<h3>우리 짱짱한 팀원들~!</h3>
<table>
    <thead>
    <tr>
        <th>이름</th>
        <th>전공</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="s" items="${sl }">
        <tr>
            <td>${s.name }</td>
            <td>${s.major } </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>