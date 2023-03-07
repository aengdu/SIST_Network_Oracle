<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.*,com.sist.dao.*"%>
<%
    // 자바 코딩 영역 
    // 1. 사용자가 보내준 데이터를 받는다 
    String strPage=request.getParameter("page"); // request,response => 내장 객체 
    if(strPage==null)
    	strPage="1"; // default 
    int curpage=Integer.parseInt(strPage);
    // 2. 오라클 연동 (DAO)
    FoodDAO dao=new FoodDAO();
    // 3. 데이터를 받는다 
    ArrayList<FoodVO> list=dao.foodListData(curpage);
    // 4. HTML을 이용해서 출력 
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
   /*border:1px black solid;
   height: 700px;
   width: 1200px;*/
}
.row {
   margin: 0px auto; /*가운데 정렬*/
   width: 960px;
}
</style>
</head>
<body>
   <div class="container">
     <div class="row">
       <%
            for(FoodVO vo:list)
            {
       %>
		         <div class="col-md-3">
				    <div class="thumbnail">
				      <a href="#">
				        <img src="<%=vo.getPoster() %>" alt="Lights" style="width:100%" class="img-rounded">
				        <div class="caption">
				          <p><%=vo.getName() %>&nbsp;<span style="color:orange"><%=vo.getScore() %></span></p>
				        </div>
				      </a>
				    </div>
				  </div>
	 <%
            }
	 %>
     </div>
     <div style="height: 20px"></div><!-- 공백주기 -->
     <div class="row">
       <div class="text-center">
           <ul class="pagination">
			  <li><a href="list.jsp?page=1">1</a></li>
			  <li class="active"><a href="list.jsp?page=2">2</a></li>
			  <li><a href="list.jsp?page=3">3</a></li>
			  <li><a href="list.jsp?page=4">4</a></li>
			  <li><a href="list.jsp?page=5">5</a></li>
			</ul>
       </div>
     </div>
   </div>
</body>
</html>





