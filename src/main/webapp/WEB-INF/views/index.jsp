<%@page language="java" contentType="text/html; charset=ISO-8859-1"  isELIgnored="false"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
     <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/styles.css">
    <title>EMPLOYEE-CRUD</title>
   
</head>
<body >
    <div class="container ">
        <h2 class="jumbotron mt-5 text-center">EMPLOYEE CRUD</h2>

        
        <!-- Form for adding student details -->
        <form method="POST" action="saveEmployee" modelAttribute="employee">
                <div class="form-group">
                        <label for="exampleInputEmail1">ID</label>
                        <input type="text" class="form-control" id="id" aria-describedby="emailHelp" name="id">
                      </div>
                      <div class="form-group">
                            <label for="exampleInputEmail1">Name</label>
                            <input type="text" class="form-control" id="name" aria-describedby="emailHelp" name="name">
                          </div>
                <div class="form-group">
                  <label for="exampleInputEmail1">Email </label>
                  <input type="email" class="form-control" id="email" aria-describedby="emailHelp" name="email">
                </div>
                <div class="form-group">
                  <label for="exampleInputPassword1">ContactNo</label>
                  <input type="number" class="form-control" id="contactno" name="contactNo">
                </div>
                
                <button type="submit" class="btn btn-primary">Submit</button>
              </form>


        <table class="table table-striped table-dark mt-5">
                <thead>
                  <tr>
                    <th scope="col">#ID</th>
                    <th scope="col">NAME</th>
                    <th scope="col">E-MAIL</th>
                    <th scope="col">CONTACT NO</th>
                    <th scope="col">UPDATE</th>
                    <th scope="col">DELETE</th>
                  </tr>
                </thead>
                <tbody id="tbodyEle">
                 <core:forEach items="${employeeList }" var="employee">
                 <tr>
                 	<td>${employee.id }</td>
                 	<td>${employee.name }</td>
                 	<td>${employee.email }</td>
                 	<td>${employee.contactNo }</td>
                 	<td><button class='btn btn-primary cursor-pointer'>UPDATE</button></td>
                  <td><a href="deleteEmployee?empId=${employee.id }"><i class='fa fa-trash ' style='color:red;font-size:1.2em; cursor:pointer'></i></a></td>
                 	
                 </tr>
                 
                 </core:forEach>
                </tbody>
              </table>
    </div>

     <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

</body>
</html>