<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="style.css">
        <!-- Optional theme-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">    
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    </head>
    <body>
        <jsp:include page="menu.jsp"></jsp:include>
        <h1><font face="arial,sans-serif">Hello World!</font></h1>
        <div class="container well">
            <div align="center">
            <form action="EstudianteServlet?action=insert" method="post">
                <table>
                    <tr>
                        <th><label><b><font face="arial,sans-serif">Username:</font></b></label></th>
                        <th>
                            <input type="text" placeholder="Enter Username" class="form-control" name="name" required=""/>
                        </th>
                    </tr>
                    <tr>
                        <th><label><b><font face="arial,sans-serif">Password:</font></b></label></th>
                        <th>
                            <input type="password" placeholder="Enter Password" class="form-control" name="password" required=""/>
                        </th>
                    </tr>
                    <tr>
                        <th><label><b>Photo:</b></label></th>
                        <th>
                            <!--Hay que agregar el ingreso de fotos-->
                            <input type="txt" placeholder="Enter photo" class="form-control" name="photo"/>
                        </th>
                    </tr>
                    <div class="break"></div>
                    </div>
                    <tr>
                        <td colspan="2">
                            <input class="btn icon-btn btn-success" type="submit" name="action" value="Insert">
                            <span class="glyphicon glyphicon-ok-sign"></span>
                            <input class="btn icon-btn btn-lg" type="reset" name="action" value="Reset">
                            <span class="glyphicon glyphicon-remove"></span>
                        </td>
                    </tr>
                </table>    
            </form>
                </div>
            <br>
        </div>
    </body>
</html>

