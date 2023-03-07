package com.sist.dao;

import java.util.Date;

/*
 *  ORDERID   NOT NULL NUMBER(2) 
	CUSTID             NUMBER(2) 
	BOOKID             NUMBER(2) 
	SALEPRICE          NUMBER(8) 
	ORDERDATE          DATE   
 */
public class OrdersVO {
    private int orderid,custid,bookid,saleprice;
    private Date orderdate;
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public int getCustid() {
		return custid;
	}
	public void setCustid(int custid) {
		this.custid = custid;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public int getSaleprice() {
		return saleprice;
	}
	public void setSaleprice(int saleprice) {
		this.saleprice = saleprice;
	}
	public Date getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}
	   
}
