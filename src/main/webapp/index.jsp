<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" 		prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" 	prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 			prefix="c"%>
<!doctype html>
<html lang="en">
<head>
    <title>Restaurant</title>
<body>
<h2>Hello Heroku!</h2>

<form:form id="form" method="post" modelAttribute="hello">

    <form:input path="from" />
    <form:input path="to" />
    <select id="cumpliment" name="cumpliment">
        <option value=""></option>
        <option value="HELLO">hello</option>
        <option value="HUG">hug</option>
    </select>

    <form:errors path="messageFromUser" cssClass="errorMessage" element="div" />

    <button type="submit" class="btn">Submit</button>

</form:form>
<ul>
    <c:forEach items="${messages}" var="message">
        <li>${message.from} sends a ${message.cumpliment} to ${message.to}</li>
    </c:forEach>
</ul>
</body>
</html>
