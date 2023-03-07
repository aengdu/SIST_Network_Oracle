package com.sist.dao;
/*
 *  FNO     NOT NULL NUMBER  (int)       
	NAME    NOT NULL VARCHAR2(1000) (String) 
	SCORE   NOT NULL NUMBER(2,1)    (double)
	ADDRESS NOT NULL VARCHAR2(1000)  (String)
	TEL     NOT NULL VARCHAR2(20)    (String)
	TYPE    NOT NULL VARCHAR2(50)    (String)
	PRICE            VARCHAR2(60)    (String)
	TIME             VARCHAR2(60)    (String)
	PARKING          VARCHAR2(60)    (String)
	MENU             VARCHAR2(1000)  (String)
	HIT              NUMBER          int
	POSTER           VARCHAR2(2000) (String)
 */
public class FoodVO {
    private int fno,hit;
    private double score;
    private String name,address,tel,type,price,time,parking,menu,poster;
	public int getFno() {
		return fno;
	}
	public void setFno(int fno) {
		this.fno = fno;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
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
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getParking() {
		return parking;
	}
	public void setParking(String parking) {
		this.parking = parking;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
    
    
}
