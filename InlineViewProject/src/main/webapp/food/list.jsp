<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.*,com.sist.dao.*"%>
<%
    // 자바 코딩 
    FoodDAO dao=new FoodDAO();
	String strPage=request.getParameter("page"); // 선택된 값을 받아 온다 
	if(strPage==null)// 처음에는 선택을 못하기 때문에 
	{
		strPage="1";
	}
	int totalpage=dao.foodTotalPage();// 총페이지 구하기 
	int curpage=Integer.parseInt(strPage); // 현재 페이지 (사용자 요청한 것에 따라 달라진다 )
	ArrayList<FoodVO> list=dao.foodListData(curpage); // 현재페이지에 대한 데이터를 오라클로부터 읽어 온다 
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
          for(FoodVO vo:list)
          {
       %>
             <div class="col-md-3">
			    <div class="thumbnail">
			      <a href="detail.jsp?fno=<%=vo.getFno()%>">
			        <img src="<%= vo.getPoster() %>" alt="Lights" style="width:100%">
			        <div class="caption">
			          <p><%= vo.getName() %></p>
			        </div>
			      </a>
			    </div>
			  </div>  
       <%
          }
       %>
     </div>
     <div style="height: 30px"></div>
     <div class="row">
       <div class="text-center">
         <a href="list.jsp?page=<%=curpage>1?curpage-1:curpage %>" class="btn btn-sm btn-danger">이전</a>
           <%=curpage %> page / <%=totalpage %> pages
         <a href="list.jsp?page=<%=curpage<totalpage?curpage+1:curpage %>" class="btn btn-sm btn-danger">다음</a>
       </div>
     </div>
   </div>
</body>
</html>













