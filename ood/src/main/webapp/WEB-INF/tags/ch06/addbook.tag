<%-- 
    Document   : addbook
    Created on : 2023. 4. 17., 오후 9:16:17
    Author     : tjdckscert
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@attribute name="user" required="true" %>
<%@attribute name="password" required="true"%>
<%@attribute name="schema" required="true"%>
<%@attribute name="table" required="true"%>
<sql:setDataSource var="dataSrc"
                   url="jdbc:mysql://${mysql_server_ip}:${mysql_server_port}/${schema}?serverTimezone=Asia/Seoul"
                   driver="com.mysql.cj.jdbc.Driver"
                   user="${user}" password="${password}" />

<sql:query var="rs" dataSource="${dataSrc}">
    SELECT * FROM ${table}
</sql:query>

<table border="1">
    <thead>
        <tr>
            <th>이름</th>
            <th>이메일</th>
            <th>전화번호</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="row" items="${rs.rows}">
            <tr>
                <td>${row.name}</td>
                <td>${row.email}</td>
                <td>${row.phone}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>