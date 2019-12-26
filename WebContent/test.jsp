<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
	function next() {
		var flag=0;
		LoginPage1.session.setAttribute("flag", flag);
	}
</script>
</head>
<body>
<h1><% String ttype = request.getSession(false).getAttribute("questionname").toString();
			out.println(ttype);%></h1>
	<form>
		<input type="radio" name="ques"> <% String ttype1 = request.getSession(false).getAttribute("op1").toString();
		out.println(ttype1); %><br><br>
		<input type="radio" name="ques"> <% String ttype2 = request.getSession(false).getAttribute("op2").toString();
		out.println(ttype2); %><br><br>
		<input type="radio" name="ques"> <% String ttype3 = request.getSession(false).getAttribute("op3").toString();
		out.println(ttype3); %><br><br>
		<input type="radio" name="ques"> <% String ttype4 = request.getSession(false).getAttribute("op4").toString();
		out.println(ttype4); %><br><br>
		<!-- <button class="btn btm-success" onclick="next()">Next</button>-->
		<hr>
	</form>
	
</body>
</html>