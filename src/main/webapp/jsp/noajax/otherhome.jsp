<%-- 
    Document   : home
    Created on : Jul 13, 2016, 3:07:43 PM
    Author     : apprentice
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Address Book</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/rainbow.css" rel="stylesheet">

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
        

    </head>
    <body>
        <div class="container">
            <h1 class="rainbow">Address Book</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/displayAddressListNoAjax">NoAjaxHome</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/newAddressFormNoAjax">Add New Address</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/home">AjaxHome</a></li>
                </ul>    
            </div>
            <h2 class="rainbow">Home Page</h2>


            <c:forEach var="address" items="${addressList}">
                <div 
                    <c:if test="${contact.state == 'Ky'}">style="color:blue"</c:if>
                    <c:if test="${contact.lastName == 'Reindeer'}">style="color:brown"</c:if>
                        >

                    <s:url value="deleteAddressNoAjax" var="deleteAddress_url">
                        <s:param name="addressID" value="${address.addressID}" />
                    </s:url>

                    <!-- do it again, for an edit link! -->
                    <s:url value="bob" var ="editAddress_url">
                        <s:param name="addressID" value="${address.addressID}" />
                    </s:url>

                    <b>Name:</b> ${address.firstName} ${address.lastName} <br/>
                    <b>Street:</b> ${address.street} <br />
                    <b>City:</b> ${address.city} <br />
                    <b>State:</b> ${address.state} <br />
                    <b>Zip Code:</b> ${address.zipCode} <br />
                    <!-- -->
                    <a href="${deleteAddress_url}">Delete</a> | <a href="${editAddress_url}">Edit</a>
                </div>

                <hr/>


            </c:forEach>

        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>