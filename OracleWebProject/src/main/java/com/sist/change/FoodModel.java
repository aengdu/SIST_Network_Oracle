package com.sist.change;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import com.sist.dao.*;
public class FoodModel {
   public void foodListData(HttpServletRequest request)
   {
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
	    request.setAttribute("list", list);
   }
}
