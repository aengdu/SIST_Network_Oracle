package com.sist.dao;
/*
 *  EMPNO    NOT NULL NUMBER(4)    int
ENAME             VARCHAR2(10)   String
JOB               VARCHAR2(9)    String 
MGR               NUMBER(4)      int
HIREDATE          DATE           Date
SAL               NUMBER(7,2)   int/double
COMM              NUMBER(7,2)   int/double
DEPTNO            NUMBER(2)     int
 */
import java.util.*;
// DESC table; => 정보를 확인하고 만든다 ==> 컬럼명과 변수의 일치 
// VO => Value Object ==> 오라클에서 가지고 오는 데이터를 저장할 목적으로 만든다 
public class EmpVO {
    private int empno,mgr,sal,comm,deptno;
    private String ename,job;
    private Date hiredate;
    private DeptVO dvo=new DeptVO(); // JOIN => 자바 (포함 클래스)
    private SalGradeVO svo=new SalGradeVO(); // JOIN 
    
	public SalGradeVO getSvo() {
		return svo;
	}
	public void setSvo(SalGradeVO svo) {
		this.svo = svo;
	}
	public DeptVO getDvo() {
		return dvo;
	}
	public void setDvo(DeptVO dvo) {
		this.dvo = dvo;
	}
	
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public int getMgr() {
		return mgr;
	}
	public void setMgr(int mgr) {
		this.mgr = mgr;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public int getComm() {
		return comm;
	}
	public void setComm(int comm) {
		this.comm = comm;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
   
}
