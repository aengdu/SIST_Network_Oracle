package com.sist.dao;
/*
 *   book
		BOOKID    NOT NULL NUMBER(2)    
		BOOKNAME           VARCHAR2(40) 
		PUBLISHER          VARCHAR2(40) 
		PRICE              NUMBER(8)
		매칭 
		---
		문자형 : CHAR,VARCHAR2,CLOB ==> String
		숫자형 : NUMBER => 저장된 데이터 실수 = double
		                             정수 = int
		날짜형 : DATE => java.util.Date
 */
// 캡슐화 (변수 은닉화 => 메소드를 통해서 접근이 가능)
public class BookVO {
    private int bookid,price;
    private String bookname,publisher;
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	   
   
}
