<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <head>
        <link rel="stylesheet" href="/Cats2/styles/styles.css">
    </head>
    <body>
        <p>Cat coat colors & markings:</p>
        <ul>
            <c:forEach var="cat" items="${cats}">
                <li>
                    <div><a href="main?choice=${cat.color}">${cat.color} Cat</a></div><br>
                </li>
            </c:forEach>
        </ul>
    </body>
</html>
