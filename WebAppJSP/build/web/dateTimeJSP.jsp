<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>Date and Time</title>
        </head>
        <body><h4>
            Date and Time in New York : <%=request.getAttribute("dateNewYork")%><br/><br/>
            Date and Time in London : <%=request.getAttribute("dateLondon")%><br/><br/>
            Date and Time in San Francisco : <%=request.getAttribute("dateSanFrancisco")%><br/>
            </h4>      
        </body>
    </html>

