package com.sist.dao;
/*
 *     CUSTID  NOT NULL NUMBER(2)    
		NAME             VARCHAR2(40) 
		ADDRESS          VARCHAR2(50) 
		PHONE            VARCHAR2(20)
 */
public class CustomerVO {
    private int custid;
    private String name,address,phone;
    private OrdersVO ovo=new OrdersVO(); //JOIN
	public int getCustid() {
		return custid;
	}
	public void setCustid(int custid) {
		this.custid = custid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public OrdersVO getOvo() {
		return ovo;
	}
	public void setOvo(OrdersVO ovo) {
		this.ovo = ovo;
	}
   
}
