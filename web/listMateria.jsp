
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <style>
            table {
                font-family: arial, sans-serif;
                border-collapse: collapse;
                width: 100%;
            }

            td, th {
                border: 1px solid #dddddd;
                text-align: left;
                padding: 8px;
            }

            tr:nth-child(even) {
                background-color: #dddddd;
            }
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="menu.jsp"></jsp:include>
        <h1> <center> <font face="arial,sans-serif">Lista de Materias</font> <center></h1> 

            <table>
                <tr>
                    <th>Codigo</th>
                    <th>Nombre</th>
                    <th>Creditos</th>
                    <th>Horario</th>
                    <th>Capacidad</th>
                    <th>Seleccionar</th>
                </tr>
                
            <c:forEach var="a" items="${materias}">


                <tr>
                    <td>${a.code}</td>
                    <td>${a.name}</td>
                    <td>${a.credits}</td>
                    <td>${a.horary}</td>
                    <td>${a.capacity}</td>
                    <td> <a onclick="return confirm('Esta seguro?')" href="EstudianteServlet?action=enrollment&id=${a.code}">Aceptar</a> </td>
              
                </tr>
                <hr/>
            </c:forEach>        
        </table>
    </body>
</html>


