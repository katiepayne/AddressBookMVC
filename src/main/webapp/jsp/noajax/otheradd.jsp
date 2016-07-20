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
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayAddressListNoAjax">NoAjaxHome</a></li>
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/newAddressFormNoAjax">Add New Address</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/home">AjaxHome</a></li>
                </ul>    
            </div>

            <div class="container">
                <h1 class="rainbow">New Address Form:</h1>
                <form action="addNewAddressNoAjax" method="POST">
                    <input class="form-control" type="text"  id="addFirstName" name="firstName" placeholder="First Name"/><br>
                    <input class="form-control"  type="text"  id="addLastName"  name="lastName"  placeholder="Last Name"/><br>
                    <input class="form-control"  type="text"  id="addStreet"   name="street"   placeholder="Street"/><br>
                    <input class="form-control"  type="text"  id="addCity"     name="city"     placeholder="City"/><br>
                    <input class="form-control"  type="text"   id="addState"     name="state"     placeholder="State"/><br>
                    <input class="form-control"  type="number"   id="addZipCode"     name="zipCode"     placeholder="Zipcode"/><br><br>
                    <button class="form-control"  type="submit" id="addAddress">Add New Address</button>
                </form>


            </div>



        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>