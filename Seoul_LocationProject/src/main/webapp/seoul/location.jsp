<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="com.sist.dao.*,java.util.*"%>
<%
    // 데이터를 가지고 온다 => 자바 
    LocationDAO dao=new LocationDAO();
    ArrayList<LocationVO> list=dao.locationListData();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
   margin-top: 50px;
}
.row{
   margin: 0px auto;
   width: 1200px;
}
h1{
   text-align: center
}
</style>
</head>
<body>
  <div class="container">
   <div class="row">
     <%
        for(LocationVO vo:list)
        {
     %>
            <div class="col-md-3">
			    <div class="thumbnail">
			      <a href="#">
			        <img src="<%=vo.getPoster() %>" alt="Lights" style="width:100%">
			        <div class="caption">
			          <p><%=vo.getTitle() %></p>
			        </div>
			      </a>
			    </div>
			  </div>
     <%
        }
     %>
   </div>
  </div>
</body>
</html>






