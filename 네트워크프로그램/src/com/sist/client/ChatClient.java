package com.sist.client;
import java.util.*;// StringTokenizer
import java.io.*; // OutputStream , BufferedReader
import java.net.*;// Socket
import javax.swing.*; // JFrame
import java.awt.*;
import java.awt.event.*;
public class ChatClient extends JFrame implements ActionListener,Runnable{
    JTextArea ta;
    JTextField tf;
    JButton b1,b2;
    private String name;
    // 네트워크 관련 라이브러리 
    private Socket s; // 연결 기기
    private OutputStream out; // 서버로 전송 
    private BufferedReader in; // 서버로부터 값 읽기
    public ChatClient()
    {
    	ta=new JTextArea();
    	JScrollPane js=new JScrollPane(ta);
    	ta.setEditable(false);
    	tf=new JTextField(30);
    	tf.setEnabled(false);
    	b1=new JButton("접속");
    	b2=new JButton("종료");
    	
    	JPanel p=new JPanel();
    	p.add(tf);
    	p.add(b1);
    	p.add(b2);
    	
    	add("Center",js);
    	add("South",p);
    	setSize(520, 600);
    	setVisible(true);
    	
    	b1.addActionListener(this);
    	b2.addActionListener(this);// CallBack => 시스템에 의해서 자동 호출 (자바스크립트)
    	tf.addActionListener(this);//enter
    	// CallBack => 대표적인 메소드 
    	// button => 클릭 , mouseClick()
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new ChatClient();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b1)
		{
			name=JOptionPane.showInputDialog("이름 입력:");
			// 서버연결 
			try
			{
				s=new Socket("211.63.89.99",3355);//연결 => 서버에 전화 걸기
				in=new BufferedReader(new InputStreamReader(s.getInputStream()));//서버로부터 값을 받는다 
				out=s.getOutputStream();
			}catch(Exception ex){}
			b1.setEnabled(false);
			tf.setEnabled(true);
			tf.requestFocus();
		}
		if(e.getSource()==b2)
		{
			dispose();//윈도우 메모리 회수 
			System.exit(0);//프로그램 종료
		}
		if(e.getSource()==tf)
		{
			// 입력한 문자열 읽기 
			String msg=tf.getText();
			if(msg.trim().length()<1)// 입력이 안된 상태
				return;
			// 입력값을 서버로 전송 
			try
			{
				out.write(("["+name+"]"+msg+"\n").getBytes());
				// out(서버) => 서버로 전송 
			}catch(Exception ex){}
			//ta.append(msg+"\n");
			// 서버부터 들어오는 데이터를 읽기 시작 
			new Thread(this).start();
			tf.setText("");
		}
	}
	// 서버에서 보내준 데이터를 출력 
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try
		{
		   while(true)
		   {
			   String msg=in.readLine();// 서버에서 보내준 데이터를 받는다 
			   ta.append(msg+"\n");
		   }
		}catch(Exception ex) {}
	}

}
