package com.sist.main;
import java.util.*;
import com.sist.dao.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        SeoulDAO dao=new SeoulDAO();
        ArrayList<SeoulVO> list=dao.seoulListData(1);
        System.out.println("========================== 서울 명소 =========================");
        for(SeoulVO vo:list)
        {
        	System.out.println(vo.getNo()+"."+vo.getTitle());
        }
        System.out.println("========================== 서울 자연 & 관광 ====================");
        list=dao.seoulListData(2);
        for(SeoulVO vo:list)
        {
        	System.out.println(vo.getNo()+"."+vo.getTitle());
        }
        System.out.println("========================== 서울 쇼핑 ====================");
        list=dao.seoulListData(3);
        for(SeoulVO vo:list)
        {
        	System.out.println(vo.getNo()+"."+vo.getTitle());
        }
        
	}

}
