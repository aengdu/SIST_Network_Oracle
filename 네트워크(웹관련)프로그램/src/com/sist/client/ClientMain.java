package com.sist.client;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import com.sist.dao.*;
// 네트워크 관련 라이브러리 
import java.net.*; // 네트워크 관련 (연결) => Socket
import java.io.*; // 서버와 입출력 => BufferedReader / OutputStream ------ 서버로 요청을 보낼때 사용 
//                                 --------------- 서버에서 보내준 결과을 읽어 온다 
/*
 *      오라클 서버 : OutputStream , BufferedReader : PreparedStatement 
 *      웹 서버 : OutputStream  =========> HttpServletRequest
 *               BufferedReader ========> HttpServletResponse 
 */
import java.util.*;// StringTokenizer : 데이터를 자른다 
public class ClientMain extends JFrame implements ActionListener,Runnable{
	CardLayout card=new CardLayout();
	Login login=new Login();
	WaitRoom wr=new WaitRoom();
	// 네트워크 관련 클래스 
	private Socket s; // 서버 연결용 
	private OutputStream out; // 서버로 요청값을 보낸다 ===> 자체처리 ==> out.write()
	private BufferedReader in;// 서버에서 보내준 값을 받는 역할 ==> 쓰레드이용 ==> in.readLine()
	// 단어 구분 ==> StringTokenizer() 
	// 100|id|name|sex ==> 오라클 (SELECT..) , 웹(파일명 구분)
	private String id;
    public ClientMain()
    {
    	setLayout(card);
    	
    	add("LOGIN",login);
    	add("WR",wr);
    	setSize(1150, 850);
    	setVisible(true);
    	setDefaultCloseOperation(EXIT_ON_CLOSE); // X 버튼 클릭시 메모리 해제
    	login.b1.addActionListener(this);//로그인 
    	wr.b6.addActionListener(this);//나가기
    	wr.tf.addActionListener(this);//채팅 // 300
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
		}catch(Exception ex){}
        new ClientMain();
	}
	@Override
	// 서버에 요청 
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==login.b1)
		{
			String id=login.tf1.getText();
			if(id.trim().length()<1)
			{
				JOptionPane.showMessageDialog(this, "ID를 입력하세요");
				login.tf1.requestFocus();
				return;
			}
			String name=login.tf2.getText();
			if(name.trim().length()<1)
			{
				JOptionPane.showMessageDialog(this, "이름을 입력하세요");
				login.tf2.requestFocus();
				return;
			}
			String sex="";
			if(login.rb1.isSelected())// 남자 라디오버튼이 선택되었을때
			{
				sex="남자";
			}
			else
			{
				sex="여자";
			}
			// 입력된 데이터를 서버로 전송 => 서버는 데이터를 받아서 저장 => 통신시 사용이 가능게 만든다 
			
			connection(id, name, sex);
		}
		// 나가기 
		else if(e.getSource()==wr.b6)
		{
			try
			{
				out.write((900+"|"+id+"\n").getBytes());
			}catch(Exception ex) {}
		}
		// 채팅 요청 
		else if(e.getSource()==wr.tf)
		{
			String msg=wr.tf.getText(); // 사용자가 입력한 값
			if(msg.trim().length()<1) // 입력이 안된 겨우
				return; // 메소드 종료 
			
			try
			{
				// 채팅 문자열 전송 (서버로 전송 => out.write() )
				out.write((300+"|"+msg+"\n").getBytes()); // 웹 => 주소란  ==> 데이터
				// ?데이터&데이터&데이터....
			}catch(Exception ex) {}
			wr.tf.setText("");
		}
	}
	/*
	 *     클라이언트에서 => 요청 / 처리 / 출력 
	 *     클라이언트   /  서버 
	 *     --------    -----
	 *     요청/출력     요청처리만 한다 
	 *     ==> 오라클 / 웹 
	 *     => 클라이언트에서 요청 (로그인 , 로그아웃 , 장바구니 , 예약한다...)
	 *     => 서버에서 클라이언트가 요청한 데이터를 받는다 
	 *        예) ==> 로그인 (id,pwd) , 영화목록 (페이지번호) , 영화 상세 (중복이 안된 데이터)..
	 *        서버에서 처리하는 이유 : 모든 클라이언트가 데이터 공유
	 *        => Socket (언어호환)
	 *           ---------------  카톡 (서버:C,클라이언트 :자바) 
	 *                                 ----- ------------- 
	 *     
	 */
	// 로그인 처리 메소드 => 서버와 연결 
	public void connection(String id,String name,String sex)
	{
		// 전화기 연결 => 전화를 건다 Socket => 생성 
		// 로그인 요청 => 사용자 정보 (id,name,sex) => 서버에서 결과값이 있는 경우 => 받아서 출력 
		try
		{
			// 연결
			s=new Socket("localhost",3355); // localhost => 127.0.0.1 , 실제 IP
			// 서버에서 보내준 데이터 읽기
			in=new BufferedReader(new InputStreamReader(s.getInputStream())); // s는 서버
			// s는 서버의 정보 (서버에서 요청 결과을 서버 메모리에 저장) 
			//  InputStreamReader => 필터 스트림 ==> byte=>char로 변환 
			// 웹에서 많이 등장 (다운로드/업로드)
			// 서버로 전송할 데이터 저장 공간 
			out=s.getOutputStream();//추상 클래스 
			/*
			 *   new를 이용하는 경우 => 일반 클래스 
			 *   new없이 생성 => 추상클래스
			 *   -------------------------------------------------------
			 *      *** 추상클래스 VS 인터페이스 
			 *      => 인터페이스 사용이 거의 대부분을 사용
			 *         -------- 스프링의 기본 
			 *      => 사용처 => 관련된 클래스를 묶어서 사용 
			 *      
			 */
			// 로그인 요청 
			out.write((100+"|"+id+"|"+name+"|"+sex+"\n").getBytes());
		}catch(Exception ex) {}
		// 서버로부터 결과값을 받아와라 ==> Thread (단방향) => 보내기(클라이언트에서 처리) / 읽기(쓰레드) ==> 동시에 수행
		new Thread(this).start();
		
	}
	// 서버에서 보내준 데이터를 출력하는 역할 => 쓰레드 제작 
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try
		{
			while(true)
			{
				// 서버에서 보내준 값을 받는다 
				String msg=in.readLine();
				// 100+"|"+id+"|"+name+"|"+sex
				System.out.println("Server에서 보낸값:"+msg);
				StringTokenizer st=new StringTokenizer(msg,"|");// 정규식 => replaceAll(),split()
				int protocol=Integer.parseInt(st.nextToken());
				// 서버에서 클라이언트 명령 => 기능 100,110...
				switch(protocol)
				{
				  case 100://로그인 처리 
				  {
					  String[] data= {
							  st.nextToken(), //id
							  st.nextToken(), //name
							  st.nextToken()  //sex
					  };
					  wr.model2.addRow(data);
				  }
				  break;
				  case 110://화면 변경 => (로그인창=>대기실) 
				  {
					  id=st.nextToken();// 서버에서 보내준 id를 저장 
					  setTitle(id);// 윈도우 제목 출력 
					  card.show(getContentPane(), "WR");  // 화면을 변경 
				  }
				  break;
				  case 990: // 나가는 사람 (윈도우 종료) 
				  {
					  dispose(); // 메모리 해제
					  System.exit(0);// 프로그램 종료 ==> 모든 명령(서버에서 내린다 ==> 번호)
				  }
				  break;
				  case 900: //남아 있는 사람 처리 
				  {
					  String mid=st.nextToken();
					  String temp="";
					  for(int i=0;i<wr.model2.getRowCount();i++)
					  {
						  temp=wr.model2.getValueAt(i, 0).toString();
						  if(mid.equals(temp))
						  {
							  wr.model2.removeRow(i);
							  break;
						  }
					  }
				  }
				  break;
				  case 300://채팅문장열이 들어온 경우
				  {
					  wr.ta.append(st.nextToken()+"\n");//서버=> 전송 => 받아서 출력 
				  }
				  break;
				}
			}
		}catch(Exception ex){}
	}

}









