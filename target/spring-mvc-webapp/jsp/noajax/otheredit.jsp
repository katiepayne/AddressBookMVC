<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
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
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayAddressListNoAjax">NoAjaxHome</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/newAddressFormNoAjax">Add Address</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/home">AjaxHome</a></li>
                </ul>    
            </div>

            <div class="container">
                <h1 class="rainbow">Edit Address Form:</h1>
                <c:if test="${address == null}">
                    <h1>I'm sorry. That address #${param.addressID} does not exist.</h1>
                </c:if>

                <c:if test="${address != null}">
                    <sf:form action="editAddressNoAjax" method="POST" modelAttribute="address">
                        <sf:input class="form-control"  type="text"  id="editFirstName" path="firstName" placeholder="First Name"/><br>
                        <sf:errors path="firstName"></sf:errors>
                        <sf:input class="form-control"  type="text"  id="editLastName"  path="lastName"  placeholder="Last Name"/><br>
                        <sf:errors path="lastName"></sf:errors>
                        <sf:input class="form-control"  type="text"  id="editStreet"   path="street"   placeholder="Street"/><br>
                        <sf:errors path="street"></sf:errors>
                        <sf:input class="form-control"  type="text" id="editCity"     path="city"     placeholder="City"/><br>
                        <sf:errors path="city"></sf:errors>
                        <sf:input class="form-control"  type="text"   id="editState"     path="state"     placeholder="State"/><br>
                        <sf:errors path="state"></sf:errors>
                        <sf:input class="form-control"  type="number" id="editZipCode"   path="zipCode"   placeholder="Zip Code"/><br><br>
                        <sf:errors path="zipCode"></sf:errors>
                        <sf:hidden path="addressID"/>
                        <button class="form-control"  type="submit" id="addAddress">Add New Address</button>
                    </sf:form>
                </c:if>


            </div>

        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>
