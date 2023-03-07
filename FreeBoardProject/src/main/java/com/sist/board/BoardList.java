package com.sist.board;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import com.sist.dao.*;
@WebServlet("/BoardList")
public class BoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//////////////////////////// 오라클 연결 => 데이터 읽기
		BoardDAO dao=new BoardDAO();
		ArrayList<BoardVO> list=dao.boardListData();
		//////////////////////////////////////////////////
		
		 response.setContentType("text/html;charset=UTF-8");
		 PrintWriter out=response.getWriter();
		 
		 out.println("<html>");
		 out.println("<head>");
		 out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">");
		 out.println("<style>");
		 out.println(".container{margin-top:50px}");
		 out.println(".row{margin:0px auto;width:900px}");
		 out.println("h1{text-align:center}");
		 out.println("</style>");
		 out.println("</head>");
		 out.println("<body>");
		 out.println("<div class=container>");
		 out.println("<h1>자유게시판</h1>");
		 out.println("<div class=row>");
		 out.println("<table class=table>");
		 out.println("<tr>");
		 out.println("<td>");
		 out.println("<a href=\"BoardInsert\" class=\"btn btn-sm btn-primary\">새글</a>");
		 out.println("</td>");
		 out.println("</tr>");
		 out.println("</table>");
		 out.println("<table class=table>");
		 out.println("<tr class=success>");
		 out.println("<th class=text-center width=10%>번호</th>");
		 out.println("<th class=text-center width=45%>제목</th>");
		 out.println("<th class=text-center width=15%>이름</th>");
		 out.println("<th class=text-center width=20%>작성일</th>");
		 out.println("<th class=text-center width=10%>조회수</th>");
		 out.println("</tr>");
		 ////////////////////////////////////// Data 출력 위치
		 for(BoardVO vo:list)
		 {
			 
			 out.println("<tr>");
			 out.println("<td class=text-center width=10%>"+vo.getNo()+"</td>");
			 out.println("<td width=45%><a href=BoardDetail?no="+vo.getNo()+">"+vo.getSubject()+"</a></td>");
			 out.println("<td class=text-center width=15%>"+vo.getName()+"</td>");
			 out.println("<td class=text-center width=20%>"+vo.getDbday()+"</td>");
			 out.println("<td class=text-center width=10%>"+vo.getHit()+"</td>");
			 out.println("</tr>");
			 
		 }
		 //////////////////////////////////////
		 out.println("</table>");
		 out.println("</div>");
		 out.println("</div>");
		 out.println("</body>");
		 out.println("</html>");
		 
		 
	}

}
