package com.sist.main;
/*
 *     ----------|---------  =>  동기화 (싱글 쓰레드)  ==> 단점 (A가 멈추면 => B는 수행할 수 없다)
 *        A           B                                 => 데드락 / 스타베이션 ==> 예외처리 
 *                                                      => 이더넷 (순서없다) => 가격 싸다 
 *     ==> 자동차 (이더넷을 이용) ==> 100조       
 *        
 *     --------------------
 *      A   A   A   A     A
 *        B   B   B   B B....   => 비동기화 (멀티 쓰레드)
 */
public class MainClass_Single {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        long start=System.currentTimeMillis();
        
        for(int i=0;i<100;i++)
        {
        	System.out.print("★");
        }
        long end=System.currentTimeMillis();
        System.out.println("소요시간:"+(end-start));
        
        for(int i=0;i<100;i++)
        {
        	System.out.print("☆");
        }
        end=System.currentTimeMillis();
        System.out.println("소요시간:"+(end-start));
	}

}
