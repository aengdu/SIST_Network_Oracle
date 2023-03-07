package com.sist.client;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
/*
 *    클래스의 종류 
 *    ----------
 *      추상클래스 : 미완성된 클래스 => 메모리 할당이 불가능 => 사용자가 상속을 받아서 처리 
 *      -------- java.io 
 *      public abstract class ClassName
 *      {
 *          ---------------------------------
 *           인스턴스 변수 설정 
 *          ---------------------------------
 *           생성자 
 *          ---------------------------------
 *           구현된 메소드 
 *          ---------------------------------
 *           선언만된 메소드 
 *           public abstract 리턴형 메소드(매개변수..);
 *          ---------------------------------
 *      }
 *      인터페이스 : 추상클래스의 일종 , 미완성된 클래스 => 클래스 여러개 묶어서 한개의 이름으로 사용 
 *      -------- java.sql => 데이터베이스 종류 (오라클, MySQL,MSSQL,DB2,MariaDB) 
 *      -------- 서울시청 , 안산시청,수원시청 => MSSQL (호환성 유지)  
 *               ------ 오라클 
 *      public interface InterfaceName
 *      {
 *          ---------------------------
 *           인스턴스변수는 설정할 수 없다 
 *           = 상수형 변수만 설정이 가능 
 *           (public static final) int a=10;
 *          ---------------------------
 *           구현이 안된 메소드 
 *           (public abstract) void display();
 *           -----------------
 *          --------------------------- JDK 1.8이상 가능 
 *           구현된 메소드
 *           (public) default void aaa(){}
 *          ---------------------------
 *           구현된 메소드
 *           (public) static void aaa(){}
 *          ---------------------------
 *      }
 *      내부클래스 
 *      = 멤버클래스 (클래스의 내용(변수,메소드)을 공유) ==> static을 이용한다  ==> 쓰레드 , 윈도우 , 서버구축
 *        class A
 *        {
 *            공유할 데이터 
 *            공유할 메소드 
 *            class B
 *            {
 *                A가 가지고 있는 모든 메소드,변수를 사용이 가능(private사용 가능)
 *            }
 *        }
 *       = 익명의 클래스 : 상속을 사용하지 않을 경우가 많다 
 *                      -------------------------- 스프링 , 마이바티스 => 오버라이딩은 익명의 클래스 이용 
 *                      *** 오버라이딩은 상속을 꼭 받아야 가능하다 ? yes/no
 *         class A
 *         {
 *             B b=new B()
 *             {
 *                 public void disp(){}
 *                 // 추가도 가능하다 
 *             }
 *         }
 *         class B
 *         {
 *             public void disp(){}
 *         }
 *      종단클래스 => 사용자 정의는 거의 없다 => java.lang.* (종단 클래스) 
 *        public final class ClassName
 *        {
 *        }
 *        => 상속을 내릴수 없다 ==> String,System,Math,StringBuffer,Wrapper....
 */
public class WaitRoom extends JPanel{
     JTable table1,table2;
     DefaultTableModel model1,model2;
     JTextArea ta;
     JTextField tf;
     JButton b1,b2,b3,b4,b5,b6;
     JLabel la1,la2;
     public WaitRoom()
     {
    	 // 초기화 
    	 // 익명의 클래스 => 상속없이 오버라이딩시에 사용 
    	 String[] col1={"방이름","상태","인원"};
    	 String[][] row1=new String[0][3]; // 한줄에 데이터를 3개 대입 
    	 model1=new DefaultTableModel(row1,col1)
    	 {
            // 편집 방지
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
    		 
    	 };
    	 table1=new JTable(model1);
    	 JScrollPane js1=new JScrollPane(table1);
    	 
    	 String[] col2={"ID","이름","성별"};
    	 String[][] row2=new String[0][3]; // 한줄에 데이터를 3개 대입 
    	 model2=new DefaultTableModel(row2,col2) //익명의 클래스 => 상속없이 오버라이딩
    	 {
            // 편집 방지
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
    		 
    	 };
    	 table2=new JTable(model2);
    	 JScrollPane js2=new JScrollPane(table2);
    	 
    	 ta=new JTextArea();
    	 ta.setEditable(false);
    	 JScrollPane js3=new JScrollPane(ta);
    	 
    	 tf=new JTextField();
    	 
    	 la1=new JLabel("개설된 방정보");
    	 la2=new JLabel("접속한 사용자 정보");
    	 
    	 b1=new JButton("방만들기");
    	 b2=new JButton("방들어가기");
    	 b3=new JButton("쪽지보내기");
    	 b4=new JButton("정보보기");
    	 b5=new JButton("1:1 채팅");
    	 b6=new JButton("종료하기");
    	 
    	 // 배치
    	 setLayout(null);//CSS
    	 // x,y ,width,height ==> top,bottom,left,right , width,height
    	 la1.setBounds(10, 15, 120, 30);
    	 js1.setBounds(10, 50, 750, 450);
    	 
    	 js3.setBounds(10, 510, 750, 250);
    	 tf.setBounds(10, 765, 750, 30);
    	 
    	 la2.setBounds(770, 15, 350, 30);
    	 js2.setBounds(770, 50, 350, 350);
    	 
    	 JPanel p=new JPanel();
    	 p.add(b1);p.add(b2);p.add(b3);p.add(b4);p.add(b5);p.add(b6);
    	 p.setLayout(new GridLayout(3, 2,5,5));
    	 p.setBounds(770, 410, 350, 100);
    	 
    	 add(la1);add(la2);
    	 add(js1);add(js2);add(js3);
    	 add(tf);add(p);
    	 
     }
     
}











