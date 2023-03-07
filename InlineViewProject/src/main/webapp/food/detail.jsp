<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.*,com.sist.dao.*"%>
<%
    //1. 보내준 데이터를 받는다 ?fno=10
    String fno=request.getParameter("fno");
    FoodDAO dao=new FoodDAO();
    FoodVO vo=dao.foodDetailData(Integer.parseInt(fno));
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
   width: 960px;
}
h1{
   text-align: center
}
</style>
</head>
<body>
   <div class="container">
     <div class="row">
       <table class="table">
        <tr>
         <%
            StringTokenizer st=new StringTokenizer(vo.getPoster(),"^");
            while(st.hasMoreTokens())
            {
         %>
               <td class="text-center"><img src=<%=st.nextToken() %> style="width:100%"></td>
         <%
         
            }
         %>
        </tr>
       </table>
     </div>
     <div style="height: 20px"></div>
     <div class="col-sm-8">
      <!-- 정보 -->
      <table class="table">
        <tr>
         <td colspan="2"><h3><%=vo.getName() %>&nbsp;<span style="color:orange"><%=vo.getScore() %></span></h3></td>
        </tr>
        <tr>
          <th width=20% style="color:#999">주소</th>
          <td width=80%><%=vo.getAddress() %></td>
        </tr>
        <tr>
          <th width=20% style="color:#999">전화</th>
          <td width=80%><%=vo.getTel() %></td>
        </tr>
        <tr>
          <th width=20% style="color:#999">음식종류</th>
          <td width=80%><%=vo.getType() %></td>
        </tr>
        <tr>
          <th width=20% style="color:#999">주차</th>
          <td width=80%><%=vo.getParking() %></td>
        </tr>
        <tr>
          <th width=20% style="color:#999">가격대</th>
          <td width=80%><%=vo.getPrice() %></td>
        </tr>
        <tr>
          <th width=20% style="color:#999">시간</th>
          <td width=80%><%=vo.getTime() %></td>
        </tr>
        <tr>
          <th width=20% style="color:#999">메뉴</th>
          <td width=80%><%=vo.getMenu() %></td>
        </tr>
      </table>
     </div>
     <div class="col-sm-4">
      <!-- 지도 -->
     </div>
   </div>
</body>
</html>






