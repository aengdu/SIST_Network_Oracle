package com.sist.server;
import java.util.*;
import java.io.*;
import java.net.*;
/*
 *   웹(JSP,MVC,Spring,Spring-Boot) 
 *   ------------------------------
 *     데이터형 (기본형,클래스,배열) 
 *     => 제어 (연산자,제어문)
 *     ------------------------------------> 자바스크립트 (자바 동일=>for)
 *     => Back(자바,오라클) , Front(자바스크립트) => HTML,CSS(퍼블리셔:디자인너) => 정규직은 없다 
 *        ---------------------------------    
 *     => 클래스 (게시판 클래스 , 예약클래스 ...)
 *     => 예외처리 
 *     => 컬렉션 , 제네릭스 
 *     => 라이브러리 (String ....) 
 *         
 *   
 */
public class Server implements Runnable{
    // 클라이언트 정보를 저장하는 공간 ==> 웹 ==> HttpSession 
	private Vector<Client> waitVc=new Vector<Client>();
	/*
	 *    컬렉션 / 제네릭스 
	 *    ---------------
	 *            컬렉션 : 데이터 모음 , 가변형 , 표준화 
	 *            Collection 
	 *               |
	 *        -------------------------
	 *        |          |            |
	 *      List       Set           Map
	 *      List => 데이터를 모아서 브라우저에 전송 할 목적 (데이터베이스에 있는 데이터를 모운다) : ArrayList
	 *      Set => 중복을 제거  : HashSet
	 *      Map => 관리  : HashMap 
	 *      
	 *      제네릭스 <클래스형> => Wrapper  <int> => <Integer>
	 *      ------ 데이터형을 변경 (Object=>지정된 데이터형 변경) 
	 *      ------ 형변환하지 않는다 ==> 소스가 간결하다 ==> 가독성(어떤 데이터형을 첨부여부 확인)
	 *      ------ 제한된 제네릭스 , 지정되지 않은 제네릭스 
	 *             ------------  ------------------ <?>
	 *             <? extends 클래스명> 
	 *             
	 *      정규식 / 어노테이션 / IO(다운로드/업로드)
	 *      ----- 계속 등장 
	 *             -------- MVC => Spring
	 */
	// 서버구동 => ServerSocket생성 
	private ServerSocket ss;
	// 연결번호 => PORT (0~65535)
	private final int PORT=3355;
	// 서버 구동 
	// 시작과 동시에 구동 
	/*
	 *   생성자 
	 *    => 초기화 
	 *    => 시작과 동시에 처리해야되는 기능이 있는 경우 
	 *       --------------
	 *         자동로그인 , 데이터베이스 연결 , 서버구동 , 배치한 화면 UI...
	 */
	public Server()
	{
		try
		{
			ss=new ServerSocket(PORT);//bind():소켓생성,listen():대기상태=> 호출
			System.out.println("Server Start...");
		}catch(Exception ex){}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Server server=new Server();
        new Thread(server).start();
	}
    // 접속시 정보를 받아서 저장 
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try
		{
			while(true)
			{
				Socket s=ss.accept(); // 클라이언트가 접속을 했을때 정보를 얻어 온다 (Socket=>IP,PORT)
				// 발신자 정보 
				// ==> Thread에게 넘겨준다 => 통신을 시작한다 => 멀티 서버 , 1:1 => Echo Server
				Client client=new Client(s);//Thread에 접속자 정보를 넘겨준다 
				client.start();//통신시작
			}
		}catch(Exception ex) {}
	}
   
	// 실제 클라이언트와 통신 ==> 쓰레드 ==> 1:1
	class Client extends Thread
	{
		private String id,name,sex;
		private OutputStream out;// 통신 => 결과값을 보내준다
		private BufferedReader in;// 요청을 받는다
		private Socket s;//연결 기계 =>접속한 클라이언트 정보를 가지고 있다 
		// 초기화
		public Client(Socket s)
		{
			try
			{
				this.s=s;
				in=new BufferedReader(new InputStreamReader(s.getInputStream()));
				out=s.getOutputStream();
			}catch(Exception ex) {}
		}
		// 실제 통신 ==> 서버마다 다르다 (채팅서버 , 웹 서버 , 오라클 서버)
		public void run()
		{
			try
			{
				while(true)
				{
					// 사용자 요청정보 
					String msg=in.readLine();
					// 로그인 요청 100|id|name|sex
					StringTokenizer st=new StringTokenizer(msg,"|");
					int protocol=Integer.parseInt(st.nextToken());//구분자를 자른다 
					switch(protocol)
					{
					   case 100: // 로그인이면 
					   {
						   id=st.nextToken();
						   name=st.nextToken();
						   sex=st.nextToken();
						   
						   // 로직 처리
						   //1. 접속자 모든 사람에게 로그인한 사람의 정보를 전송 
						   messageAll(100+"|"+id+"|"+name+"|"+sex);
						   //2. waitVc에 저장 
						   waitVc.add(this);
						   //2-2 로그인창에서 => 대기실창으로 변경 
						   messageTo(110+"|"+id);
						   //3. 로그인 사람에게 => 접속자 정보를 전체 전송 
						   for(Client user:waitVc)
						   {
							   messageTo(100+"|"+user.id+"|"+user.name+"|"+user.sex);
						   }
					   }
					   break;
					   // 900+"|"+id ==> id를 제거한다 
					   case 900: //나가기면 ...
					   {
						   String mid=st.nextToken();
						   messageAll(900+"|"+id);//테이블에서 id를 제거 (남아 있는 사람처리)
						   // 제거
						   for(int i=0;i<waitVc.size();i++)
						   {
							   Client c=waitVc.get(i);
							   if(c.id.equals(mid))
							   {
								   messageTo(990+"|");// 윈도우를 종료한다 (나가는 사람 처리)
								   waitVc.remove(i);// 저장된 id를 지운다 
								   in.close();
								   out.close(); // 통신을 정지한다 
								   break;// 번호 => 임의로 만든다 ==> 웹(파일명)
								   // login.jsp , exit.jsp.....
								   // 구분 => 숫자,문자열 ...
							   }
						   }
					   }
					   break;
					   case 300:
					   {
						   messageAll(300+"|["+name+"]"+st.nextToken());
					   }
					   break;
					}
					
				}
			}catch(Exception ex) {}
		}
		// 전체적으로 전송
		public synchronized void messageAll(String msg)
		{
		    try
		    {
		    	for(Client client:waitVc)
		    	{
		    		client.messageTo(msg); //  대기실 , 채팅 
		    	}
		    }catch(Exception ex) {}
		}
		// 개인적으로 전송 
		public synchronized void messageTo(String msg)
		{
			try
			{
				out.write((msg+"\n").getBytes());
			}catch(Exception ex) {}
		}
		
	}
}








