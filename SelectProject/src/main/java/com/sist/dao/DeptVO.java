package com.sist.dao;
/*
 *  DEPTNO NOT NULL NUMBER     ===> int  
	DNAME           VARCHAR2(20) => String
	LOC             VARCHAR2(20) => String 
 */
public class DeptVO {
    private int deptno;
    private String dname;
    private String loc;
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
   
   
}
