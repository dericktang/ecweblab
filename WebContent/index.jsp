<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<!-- ��Ҫ����İ�  -->
<%@page import="java.util.*"%>
<%@page import="java.sql.SQLException"%>
<%@page import="com.ecweblab.dao.impl.SqlActionResultDaoImpl"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>�ҵĿ��</title>
</head>
<body>
	<%
		ArrayList<HashMap> list = new SqlActionResultDaoImpl()
				.getSqlList("SELECT * FROM flight j ");
		System.out.println("-total--" + list.get(0).get("total"));
		for (int i = 1; i < list.size(); i++) {
	%>
	<%=list.get(i).get(0)%>----<%=list.get(i).get(1)%>
	<%
		}
	%>
	
	<%
	HashMap map =new SqlActionResultDaoImpl().getObjMap("SELECT * FROM flight j where flightid=3");
	%>
	<%= map.get("total")%>----<%= map.get(0)%>----<%= map.get(1)%>
	
</body>
</html>