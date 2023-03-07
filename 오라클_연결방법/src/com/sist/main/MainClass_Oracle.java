package com.sist.main;
import java.sql.*;

/*
 *    자바 
 *    ----
 *      최종 => 네트워크 / 데이터베이스 => 자바라이브러리 (JDBC)  => 라이브러리(외부 => MyBatis, JPA)
 *             -------  ---------- 
 *             
 *             bit > byte(8bit)=>한글자 > word(단어) > row(record) > table (구분이 되어 있다)
 *                                                  ------------  ------ 2차원구조 
 *                                                     문장         파일 
 *             -------------------------------
 *                id     pwd     name  ==> 구분자 (컬럼) => 멤버변수 
 *             -------------------------------
 *               aaa   1234      홍길동  ===> record , row , tuple ==> 객체 
 *             -------------------------------
 *               bbb   1234      박문수
 *             -------------------------------
 *               ccc   1234      심청이
 *             -------------------------------
 *              도메인
 *              
 *              emp 
 *              -----------------------------------------------
 *               empno  ename  job mgr hiredate sal comm deptno
 *               사번    이름   직위  사수  입사일   급여  성과급 부서번호
 *              -----------------------------------------------
 *              -- 14명 
 *             
 *             오라클의 명령어 (SQL)
 *             ------------------
 *              DQL : SELECT => 데이터를 검색 
 *                    SELECT * | column명...
 *                    FROM table_name
 *                    [
 *                        
 *                    ]
 *                     문법 => 연산자 => 함수 => 조인 => 서브쿼리
 *              DML : 데이터 조작언어 
 *                    INSERT => 데이터 추가 (회원가입 , 글쓰기 , 댓글달기)
 *                    UPDATE => 데이터 수정 
 *                    DELETE => 데이터 삭제 
 *              ----------------------------------------------- CURD(프로그래머)
 *              DDL : 데이터 정의 언어
 *                    => 데이터 저장 공간  ==> CREATE 
 *                       ------------- TABLE , 보안=>가상 테이블 (View)
 *                                     Sequence(자동 증가번호) , Index(검색, SORT) , PL/SQL
 *                    => 저장공간 수정 ==> ALTER
 *                    => 저장공간 삭제 ==> DROP
 *                    => 잘라내기  ==> TRANCATE
 *                    => 테이블명 변경 => RENAME
 *              ----------------------------------------------- DBA 
 *              DCL : 제어언어 
 *                    GRANT = 권한 부여 
 *                    REVOKE = 권한 해제 
 *                    ----------------- DBA
 *              TCL : 트랜잭션 (일괄 처리)
 *                    COMMIT : 저장 (정상적인 저장) 
 *                    ROLLBACK : 취소 
 *              ------------------------------------ 그대로 자바에서 전송 
 *              => 제약조건 , 데이터베이스 모델링 
 *              
 */
public class MainClass_Oracle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        try
        {
        	// 드라이버 등록 (thin) => ojdbc8.jar 
        	Class.forName("oracle.jdbc.driver.OracleDriver"); // mysql ==> com.mysql.cj.Driver
        	// 오라클 연결 
        	String url="jdbc:oracle:thin:@localhost:1521:XE"; // 자동 설정 
        	/*
        	 *   데이터베이스 : 폴더 
        	 *   테이블 : 파일 
        	 *   컬럼 : 클래스의 인스턴스변수 
        	 *   ROW , RECORD : 객체 데이터 
        	 */
        	Connection conn=DriverManager.getConnection(url,"hr","happy");
        	//  conn hr/happy
        	// SQL문장 전송 
        	String sql="SELECT ename,job,hiredate FROM emp";
        	PreparedStatement ps=conn.prepareStatement(sql);
        	// SQL문장만 오라클로 전송 
        	ResultSet rs=ps.executeQuery();
        	// 실행 결과를 가지고 있다 
        	// 실행 결과값 가지고 오기 
        	/*
        	 *   KING                 PRESIDENT          81/11/17       7839
        	 *   String                String             Date          int
        	 */
        	while(rs.next()) //cursor위치 맨위로 이동 
        	{
        		System.out.println(rs.getString(1)+" "
        				+rs.getString(2)+" "
        				+rs.getDate(3).toString());
        	}
        }catch(Exception ex){ex.printStackTrace();}
	}

}









