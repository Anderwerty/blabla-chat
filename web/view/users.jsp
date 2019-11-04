<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="messages"/>

<html lang="param.locale">
<head>
    <title>Users</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

<div class="copyright">
    <div class="container">
        <a href="?locale=en">en</a>
        <a href="?locale=ru">ru</a>
    </div>
</div>

<div class="row col-md-6">
    <table class="table table-striped table-dark">
        <thead>
        <tr>
            <th scope="col"><fmt:message key="users.user.id"/></th>
            <th scope="col"><fmt:message key="users.user.name"/></th>
            <th scope="col"><fmt:message key="users.user.surname"/></th>
            <th scope="col"><fmt:message key="users.user.email"/></th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.surname}</td>
                <td>${user.email}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<nav aria-label="Navigation for гіукі">
    <ul class="pagination">
        <c:if test="${currentPage != 1}">
            <li class="page-item"><a class="page-link"
                                     href="user?recordsPerPage=${recordsPerPage}&currentPage=${currentPage-1}">Previous</a>
            </li>
        </c:if>

        <c:forEach begin="1" end="${noOfPages}" var="i">
            <c:choose>
                <c:when test="${currentPage eq i}">
                    <li class="page-item active"><a class="page-link">
                            ${i} <span class="sr-only">(current)</span></a>
                    </li>
                </c:when>
                <c:otherwise>
                    <li class="page-item"><a class="page-link"
                                             href="user?recordsPerPage=${recordsPerPage}&currentPage=${i}">${i}</a>
                    </li>
                </c:otherwise>
            </c:choose>
        </c:forEach>

        <c:if test="${currentPage lt noOfPages}">
            <li class="page-item"><a class="page-link"
                                     href="user?recordsPerPage=${recordsPerPage}&currentPage=${currentPage+1}">Next</a>
            </li>
        </c:if>
    </ul>
</nav>

</body>
</html>
