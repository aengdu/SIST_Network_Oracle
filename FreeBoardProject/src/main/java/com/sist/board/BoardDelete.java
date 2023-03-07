package com.sist.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sist.dao.*;
@WebServlet("/BoardDelete")
public class BoardDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     String no=request.getParameter("no");
	     BoardDAO dao=new BoardDAO();
	     dao.boardDelete(Integer.parseInt(no));
	     // 이동 
	     response.sendRedirect("BoardList");
	}

}
