<%-- 
    Document   : index
    Created on : 2023. 4. 17., 오후 9:30:31
    Author     : tjdckscert
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<%@page import="deu.se.ood.model.ch06.*" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">        
        <title>Hikari CP 사용한 주소록 보기</title>
        <script>
            <c:if test="${!empty msg}">
            alert("${msg}");
            </c:if>
        </script>
    </head>
    <body>
        <h1>주소록</h1>
        <hr/>

        <%
            try { 
                HikariConfiguration dbConfig = (HikariConfiguration) request.getAttribute("dbConfig");
                javax.sql.DataSource ds = dbConfig.dataSource();
                Connection conn = ds.getConnection();
                Statement stmt = conn.createStatement();
                String sql = "SELECT * FROM addbook";
                ResultSet rs = stmt.executeQuery(sql);
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>이름</th>
                    <th>이메일</th>
                    <th>전화번호</th>
                </tr>
            </thead>
            <tbody>

                <%          while (rs.next()) {
                        out.println("<tr>");
                        out.println("<td>" + rs.getString("name") + "</td>");
                        out.println("<td>" + rs.getString("email") + "</td>");
                        out.println("<td>" + rs.getString("phone") + "</td>");
                        out.println("</tr>");
                    }
                    rs.close();
                    stmt.close();
                    conn.close();
                %>

            </tbody>
        </table>
        <%
            } catch (Exception ex) {
                out.println("오류가 발생했습니다. (발생 오류: " + ex.getMessage() + ")");
            }
        %>
    </body>
</html>