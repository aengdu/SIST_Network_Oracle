<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.*,com.sist.dao.*"%>
<%
    LocationDAO dao=new LocationDAO();
    ArrayList<ZipcodeVO> list=dao.postfind();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
  <ul>
    <%
       for(ZipcodeVO vo:list)
       {
    %>
          <li><%=vo.getZipcode() %>&nbsp;<%=vo.getAddress() %></li>
    <%
       }
    %>
  </ul>
</body>
</html>