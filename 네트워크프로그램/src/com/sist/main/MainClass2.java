package com.sist.main;
// => Thread상속 => 상속이 안되는 클래스 => 윈도우 
/*
 *     class Window extends JFrame implements Runnable
 *     {
 *     }
 *     
 *     ==> 두가지일을 동시 
 *         = IO (단방향) 읽기/쓰기
 *         = 클라이언트 => 본인이 동작 / 서버에서 들어오는 값 
 *                      ---------------------------- 
 */
class MyThread2 implements Runnable // 쓰레드에 동작만 만들어 준다 
{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try
		{
			for(int i=1;i<=10;i++)
			{
				System.out.println(Thread.currentThread()+":"+i);
				// 현재 동작하고 있는 쓰레드 이름
				Thread.sleep(300);
			}
		}catch(Exception ex) {}
	}
	
}
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        MyThread2 t1=new MyThread2();
        new Thread(t1).start();// t1이 가지고 있는 run()롤 호출 
	}

}
