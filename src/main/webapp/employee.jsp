<%--
  Created by IntelliJ IDEA.
  User: luuhu
  Date: 5/21/2021
  Time: 7:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
<h1 class="text-center">Create Employee</h1>
<div class="container">
    <form method="post" action="/employee/create">
        <div class="form-group">
            <label for="name">Name</label>
            <input type="text" class="form-control" id="name" aria-describedby="emailHelp" name="name">
        </div>
        <div class="form-group">
            <label for="name">birth day</label>
            <input type="text" class="form-control" aria-describedby="emailHelp" name="birthday">
        </div>
        <div class="form-group">
            <label for="name">Address</label>
            <input type="text" class="form-control" aria-describedby="emailHelp" name="address">
        </div>

        <div class="form-group">
            <label for="name">Position</label>
            <input type="text" class="form-control" aria-describedby="emailHelp" name="position">
        </div>

        <div class="form-group">
            <label for="name">Department</label>
            <input type="text" class="form-control" aria-describedby="emailHelp" name="department">
        </div>

        <button type="submit" class="btn btn-primary">Submit</button>
        <button type="reset" class="btn btn-primary">Reset</button>
    </form>
</div>

<script>
    document.querySelector("button[type='reset']").addEventListener("click", e => {
        const inputs = document.querySelectorAll("input");
        for (let i = 0; i < inputs.length; i++) {
            inputs[i].value = "";
        }
    })
</script>
</body>
</html>
