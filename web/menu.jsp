<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${empty login}">
    |<a href="login.jsp"><font face="arial,sans-serif">Login<font></a>|
|<a href="newEstudiante.jsp"><font face="arial,sans-serif">Register<font></a>|

</c:if>
<c:if test="${not empty login}">
    |<a href="EstudianteServlet?action=logout"><font face="arial,sans-serif">Logout</font></a>|
    |<a href="EstudianteServlet?action=list"><font face="arial,sans-serif">Lista de Materias</font></a>|

</c:if>



    |<a href="EstudianteServlet?action=about"><font face="arial,sans-serif">About</font></a>|
<hr/>