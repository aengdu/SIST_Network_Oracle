package com.sist.main;
import java.util.*;
import com.sist.dao.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 오라클 연결 
		EmpDAO dao=EmpDAO.newInstance();// 싱글턴 객체 생성 
		/*System.out.println(dao);
		ArrayList<EmpVO> list=dao.empListData();
		for(EmpVO vo:list)
		{
			System.out.println(vo.getEmpno()+" "
					+vo.getEname()+" "
					+vo.getJob()+" "
					+vo.getHiredate().toString()+" "
					+vo.getSal()+" "
					+vo.getDvo().getDname()+" "
					+vo.getDvo().getLoc()+" "
					+vo.getSvo().getGrade());
		}*/
		Scanner scan=new Scanner(System.in);
		/*System.out.print("이름 입력:");
		String ename=scan.next();
		
		ArrayList<EmpVO> list=dao.empFindData(ename);
		for(EmpVO vo:list)
		{
			System.out.println(vo.getEmpno()+" "+vo.getEname()+" "+vo.getJob()+" "
					+vo.getHiredate().toString()+" "
					+vo.getSal());
		}*/
		//EmpVO vo=dao.empSubQueryData(ename.toUpperCase());// 대문자 변환 
		System.out.print("인원 입력:");
		int num=scan.nextInt();
		ArrayList<EmpVO> list=dao.empInlineView(num);
		for(EmpVO vo:list)
		{
			System.out.println(vo.getEmpno()+" "+vo.getEname()+" "+vo.getJob()+" "
					+vo.getHiredate().toString()+" "
					+vo.getSal());
			
		}
		/*System.out.println("사번:"+vo.getEmpno());
		System.out.println("이름:"+vo.getEname());
		System.out.println("직위:"+vo.getJob());
		System.out.println("입사일:"+vo.getHiredate());
		System.out.println("급여:"+vo.getSal());
		//System.out.println("부서명:"+vo.getDvo().getDname());
		//System.out.println("근무지:"+vo.getDvo().getLoc());*/
		
	}

}
