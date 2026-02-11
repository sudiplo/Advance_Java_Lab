<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%
    String n1 = request.getParameter("num1");
    String n2 = request.getParameter("num2");
    String op = request.getParameter("op");
    String result = "";

    if(n1 != null && n2 != null){
        try{
            double a = Double.parseDouble(n1);
            double b = Double.parseDouble(n2);

            switch(op){
                case "+": result = "Result: " + (a+b); break;
                case "-": result = "Result: " + (a-b); break;
                case "*": result = "Result: " + (a*b); break;
                case "/": result = (b!=0) ? "Result: " + (a/b) : "Cannot divide by zero!";
            }
        }catch(Exception e){
            result = "Invalid Input!";
        }
    }
%>

<!DOCTYPE html>
<html>
<head>
<title>Simple Calculator</title>
<style>
    body{
        font-family: Arial;
        background:#f2f6fc;
        text-align:center;
        margin-top:100px;
    }
    .card{
        background:#ffffff;
        padding:20px;
        width:280px;
        margin:auto;
        border-radius:10px;
        box-shadow:0 0 10px #ccc;
    }
    input,select{
        width:90%;
        padding:8px;
        margin:6px;
        border:1px solid #ccc;
        border-radius:5px;
    }
    button{
        padding:8px 15px;
        background:#007bff;
        color:white;
        border:none;
        border-radius:5px;
        cursor:pointer;
    }
    button:hover{
        background:#0056b3;
    }
    h3{
        color:#007bff;
    }
</style>
</head>
<body>

<div class="card">
    <h2>Calculator</h2>
    <form method="post">
        <input type="text" name="num1" placeholder="First Number"
               value="<%= (n1!=null)?n1:"" %>" required>

        <input type="text" name="num2" placeholder="Second Number"
               value="<%= (n2!=null)?n2:"" %>" required>

        <select name="op">
            <option value="+">+</option>
            <option value="-">-</option>
            <option value="*">*</option>
            <option value="/">/</option>
        </select>

        <button type="submit">Calculate</button>
    </form>

    <h3><%= result %></h3>
</div>

</body>
</html>
