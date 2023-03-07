package com.sist.board;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sist.dao.*;
@WebServlet("/BoardDetail")
public class BoardDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
    // 서버에 의해서 자동으로 호출되는 메소드 
	// 사용자  요청을 했을때 마다 호출 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 사용자가 보내준 데이터를 받는다   ?no=10
		String no=request.getParameter("no");
		// 2. 변환 코드 => 자바를 실행하고 어떤 파일을 브라우저에 전송할지 여부를 설정 
		// 브라우저 : html: text/html , xml : text/xml , json : text/plain 
		response.setContentType("text/html;charset=UTF-8"); // HTML안에 한글을 포함 
		// 3. 사용자 브라우저 읽어 갈 수 있게 메모리 위치 지정 
		PrintWriter out=response.getWriter();
		// 4. 오라클에서 데이터를 가지고 온다 
		BoardDAO dao=new BoardDAO();
		BoardVO vo=dao.boardDetailData(Integer.parseInt(no));
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
		 out.println("<th width=20% class=text-center>번호</th>");
		 out.println("<td width=30% class=text-center>"+vo.getNo()+"</td>");
		 out.println("<th width=20% class=text-center>작성일</th>");
		 out.println("<td width=30% class=text-center>"+vo.getRegdate().toString()+"</td>");
		 out.println("</tr>");
		 
		 out.println("<tr>");
		 out.println("<th width=20% class=text-center>이름</th>");
		 out.println("<td width=30% class=text-center>"+vo.getName()+"</td>");
		 out.println("<th width=20% class=text-center>조회수</th>");
		 out.println("<td width=30% class=text-center>"+vo.getHit()+"</td>");
		 out.println("</tr>");
		 
		 out.println("<tr>");
		 out.println("<th width=20% class=text-center>제목</th>");
		 out.println("<td colspan=3 class=text-center>"+vo.getSubject()+"</td>");
		 out.println("</tr>");
		 
		 out.println("<tr>");
		 out.println("<td colspan=4 class=text-left valign=top height=200><pre>"+vo.getContent()+"</pre></td>");
		 out.println("</tr>");
		 
		 out.println("<tr>");
		 out.println("<td colspan=4 class=text-right>");
		 out.println("<a href=# class=\"btn btn-xs btn-danger\">수정</a>");
		 out.println("<a href=BoardDelete?no="+vo.getNo()+" class=\"btn btn-xs btn-warning\">삭제</a>");
		 out.println("<a href=BoardList class=\"btn btn-xs btn-info\">목록</a>");
		 out.println("</td>");
		 out.println("</tr>");
		 
		 out.println("</table>");
		 out.println("</div>");
		 out.println("</div>");
		 out.println("</body>");
		 out.println("</html>");
	}

}
