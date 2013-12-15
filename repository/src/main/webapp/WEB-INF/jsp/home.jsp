<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%--
 - Author   : Dynastymasra
 - Name     : Dimas Ragil T
 - Email    : dynastymasra@gmail.com
 - LinkedIn : http://www.linkedin.com/in/dynastymasra
 - Blogspot : dynastymasra.wordpress.com | dynastymasra.blogspot.com
--%>

<html>
<head>
    <title>Spring Rest Extjs</title>
    <link rel="stylesheet" type="text/css"
          href="<c:url value='/resources/extjs/resources/css/ext-all-gray-debug.css'/>">
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/extjs/resources/css/style.css'/> ">

    <script type="text/javascript">
        var cleanUrl = function (path) {
            var indexOfJSessionId = path.indexOf(";jsessionid");
            if (indexOfJSessionId != -1) {
                path = path.substring(0, indexOfJSessionId);
            }
            return path;
        };

        var Config = {};
        Config.api = cleanUrl("<c:url value='/api'/>"),
                Config.mahasiswaUrl = Config.api + "/mahasiswa",
                Config.studyClubUrl = Config.api + "/studyClub";
    </script>
    <script type="text/javascript" src="<c:url value='/resources/extjs/ext-all-dev.js'/> "></script>
    <script type="text/javascript" src="<c:url value='/resources/app/appl.js'/> "></script>
</head>
<body></body>
</html>