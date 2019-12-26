<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*,java.util.*" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%//out.print(request.getSession(false).getAttribute("aquesid"));
//out.print(request.getSession(false).getAttribute("useroption"));

Object s;
 s = request.getSession(false).getAttribute("useroption");

String s1 =s.toString();



out.println( "a l :"+s1);

try {
	
	Class.forName("oracle.jdbc.driver.OracleDriver");  
	  
	//step2 create  the connection object  
	Connection con=DriverManager.getConnection(  
	"jdbc:oracle:thin:@localhost:1522:Quiz","system","Password");
	
	Statement stmt = con.createStatement();
	
	String sql = "select * from Questions";
	
	ResultSet rs = stmt.executeQuery(sql);
	
	while(rs.next()){
		
		out.println(rs.getString(2)+"<br>");
	}
	
	
}catch(Exception e){
	e.printStackTrace();
}


%>
</body>
</html>