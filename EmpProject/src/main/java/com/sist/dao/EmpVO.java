package com.sist.dao;
// 사원 한명에 대한 데이터를 모아서 브라우저로 전송목적 (변수)
import java.util.*;
/*
 *   emp => 사원정보가 저장                       자바 
 *   empno NUMBER ========================>   int
 *   ename VARCHAR2  =====================> String
 *   job VARCHAR2  =======================> String
 *   mgr NUMBER   ========================> int
 *   hiredate DATE =======================> java.util.Date (java.sql)
 *   sal NUMBER    int
 *   comm NUMBER   int 
 *   deptno NUMBER int
 *   ----------------------------------VO는 오라클 테이블의 컬럼과 매칭 
 */
public class EmpVO {
    private int empno,mgr,sal,comm,deptno;
    private String ename,job;
    private Date hiredate;
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
