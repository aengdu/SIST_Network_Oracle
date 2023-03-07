package com.sist.main;
import java.util.*;
import com.sist.dao.*;
public class UserMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        StudentVO vo=new StudentVO();
        System.out.print("이름 입력:");
        vo.setName(scan.next());
        System.out.print("국어 입력:");
        vo.setKor(scan.nextInt());
        System.out.print("영어 입력:");
        vo.setEng(scan.nextInt());
        System.out.print("수학 입력:");
        vo.setMath(scan.nextInt());
        
        StudentDAO dao=new StudentDAO();
        dao.studentInsert(vo);
        System.out.println("저장 완료!!");
        
        ArrayList<StudentVO> list=dao.studentListData();
        for(StudentVO svo:list)
        {
        	System.out.println(svo.getHakbun()+" "
        			+svo.getName()+" "
        			+svo.getKor()+" "
        			+svo.getEng()+" "
        			+svo.getMath()+" "
        			+svo.getTotal()+" "
        			+svo.getAvg());
        }
	}

}
