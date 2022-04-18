<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Phone Store</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div>
            <h2>Choose feature</h2>
            <form method="post" action="MainController">
                <input type="submit" name="btnAction" value="Generate Data" />
                <input type="submit" name="btnAction" value="Check Data" />
                <input type="submit" name="btnAction" value="Load Data" />
            </form>
            <h2>
                <font color="green">
                ${requestScope.SUCCESS}
                </font>
                <font color="green">
                ${requestScope.SUCCESS_CREATE}
                </font>
            </h2>
            <c:if test="${requestScope.SUCCESS_CREATE ne null }">
                <p>Click on the image to download it:<p>
                    <a href="MainController?btnAction=Dowload Data" download="fileXML">
                        <img src="https://www.phoca.cz/images/projects/phoca-download-r.png" width="100" height="100">
                    </a>
                </c:if>
                    <c:forEach var="list" items="${sessionScope.LISTPRODUCTS}" varStatus="counters">
                    <table>
                        <tr>
                        <td>${list.productId}</td>
                        <td>${list.productName}</td>
                        <td>${list.price}</td>
                        <td>${list.image}</td>
                        <td>${list.creationDate}</td>
                        <td>${list.categoryId}</td>
                    </tr>
                    </table>
                    </c:forEach>
        </div>
    </body>
</html>
