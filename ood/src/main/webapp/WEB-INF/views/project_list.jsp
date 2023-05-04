<%-- 
    Document   : product_list
    Created on : 2023. 3. 4., 오후 8:34:18
    Author     : skylo
--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>JSP 교재 내용</title>
        <link rel="stylesheet" type="text/css"
              href="${pageContext.request.contextPath}/css/my_style.css">
        <script>
            <c:if test="${!empty msg}">
            alert("${msg}");
            </c:if>
        </script>
    </head>
    <body>
        <h1>JSP 교재 내용</h1>

        <div class="box">
            <ol>
                <li><a href="ch01/old">1장 (교재 방식)</a></li>
                <li><a href="ch01/new">1장 (Spring 방식)</a></li>
                <li><a href="ch02">2장</a></li>
                <li><a href="ch03/simple_page_directive">3장 page 지시어</a></li>
                <li><a href="ch03/include">3장 include 지시어</a></li>
                <li><a href="ch03/error_page/index1">3장 error page 없는 경우</a></li>
                <li><a href="ch03/error_page/index2">3장 error page 있는 경우</a></li>
                <li><a href="ch03/project/simple_page">3장 page 지시어 (@PathVariable 사용: simple_page, error1, error2, include)</a></li>
                <li><a href="ch04/beans">4장 Beans 사용</a></li>
                <li><a href="ch04/include">4장 IncludeTest2</a></li>
                <li><a href="ch04/forward">4장 ForwardTest</a></li>
                <li><a href="ch05/eltest">5장 ELTest</a></li>
                <li><a href="ch05/elimplicitobject">5장 ELImplicitObjectTest</a></li>
                <li><a href="ch05/simpletagtest/1">5장 SimpleTagTest1</a></li>
                <li><a href="ch05/simpletagtest/2">5장 SimpleTagTest2 (첫 번째 수정)</a></li>
                <li><a href="ch05/simpletagtest/3">5장 SimpleTagTest3 (두 번째 수정)</a></li>
                <li><a href="ch05/tagfiletest">5장 TagFileTest</a></li>
                <li><a href="ch05/beanstest">5장 BeansTest (일반 목적 액션 사용 예제)</a></li>
                <li><a href="ch05/tagfiletest/1">5장 TagFileTest (5.4.3 조건부 액션)</a></li>
                <li><a href="ch05/tagfiletest/2">5장 TagFileTest (5.4.4 반복 액션)</a></li>
                <li><a href="ch05/urltest">5장 UrlTest</a></li>
                <li><a href="ch06/showtable1">6장 ShowTable1</a></li>
                <li><a href="ch06/showtable2">6장 ShowTable2</a></li>
                <li><a href="ch06/inserttable">6장 InsertTable (제어기에서 필요한 데이터
                        객체 불러 일 수행)</a></li>
                <li><a href="ch06/hikari_cp">6장 Hikari CP</a></li>
                <!-- li><a href="ch06/hikari_jndi">6장 Hikari JNDI (not implemented))</a></li -->
                <li><a href="ch06/jpa/show">6장 JPA 실습: 주소록</a></li>
                <li><a href="ch07/upload">7장 파일 올리기</a></li>
                <li><a href="ch07/download">7장 파일 내려받기</a></li>
                <li><a href="ch08/init_parameter">8장 웹 초기화</a></li>
                <li><a href="ch08/filter">8장 필터를 이용한 파일 내려받기</a></li>
            </ol>
        </div>

    </body>
</html>