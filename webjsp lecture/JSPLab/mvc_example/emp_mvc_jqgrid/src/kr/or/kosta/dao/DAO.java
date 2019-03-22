package kr.or.kosta.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import kr.or.kosta.dto.DTO;
import kr.or.kosta.utils.Singleton_ConnectionHelper;

public class DAO {
   Connection conn = null;
   public int countemp(){
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      int rowcount = 0;
	      
	      try{
	         conn = Singleton_ConnectionHelper.getConnection("oracle");
	         String sql = "select * from emp";
	         pstmt = conn.prepareStatement(sql);
	         rs = pstmt.executeQuery();
	         
	         while(rs.next()){
	        	 rowcount++;
	         }
	      }catch(Exception e){
	         System.out.println(e.getMessage());
	      }finally {
	         Singleton_ConnectionHelper.close(pstmt);
	      }
	      return rowcount;
	   }
   // 1.사원정보 전체보기
   public ArrayList<DTO> EmpList(){
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      ArrayList<DTO> dtolist = new ArrayList<>();
      
      try {
         conn = Singleton_ConnectionHelper.getConnection("oracle");
         String sql = "select * from emp";
         pstmt = conn.prepareStatement(sql);
                  
         rs = pstmt.executeQuery();
         
         while(rs.next()){
            DTO dto = new DTO();
            dto.setEmpno(rs.getString("empno"));
            dto.setEname(rs.getString("ename"));
            dto.setJob(rs.getString("job"));
            dto.setMgr(rs.getString("mgr"));
            dto.setHiredate(rs.getDate("hiredate"));
            dto.setSal(rs.getString("sal"));
            dto.setComm(rs.getString("comm"));
            dto.setDeptno(rs.getString("deptno"));
            dtolist.add(dto);
         }
         
      } catch (Exception e) {
         System.out.println(e.getMessage());
      }finally{
         Singleton_ConnectionHelper.close(rs);
         Singleton_ConnectionHelper.close(pstmt);
      }
      return dtolist;
   }
   
   // 2.사원정보 추가하기
   public int InsertList(DTO dto){
      PreparedStatement pstmt = null;

      int rowcount=0;
      
      try {
         conn = Singleton_ConnectionHelper.getConnection("oracle");
         String sql = "insert into emp(empno, ename, job, mgr, hiredate, sal, comm, deptno) values(?,?,?,?,?,?,?,?)"; 
         pstmt = conn.prepareStatement(sql);
                  
         pstmt.setString(1, dto.getEmpno());
         pstmt.setString(2, dto.getEname());
         pstmt.setString(3, dto.getJob());
         pstmt.setString(4, dto.getMgr());
         pstmt.setDate(5, dto.getHiredate());
         //pstmt.setDate(5, (Date) dto.getHiredate());
         pstmt.setString(6, dto.getSal());
         pstmt.setString(7, dto.getComm());
         pstmt.setString(8, dto.getDeptno());
         rowcount = pstmt.executeUpdate();
         
      } catch (Exception e) {
         System.out.println(e.getMessage());
      }finally{
         Singleton_ConnectionHelper.close(pstmt);
      }
      return rowcount;
   }
   
   // 3.사원정보 수정하기(empno, ename 제외하고 찾는건 ename값 받아와서 찾음)
   public int UpdateList(DTO dto){
	   PreparedStatement pstmt = null;
	      
	      int rowcount = 0;
	      System.out.println( "getDeptno"+dto.getDeptno());
	      
	         try{
	            conn = Singleton_ConnectionHelper.getConnection("oracle");
	            String sql="update emp set job=?, mgr=?, sal=?, comm=?, deptno=? where empno=?";
	            pstmt = conn.prepareStatement(sql);
	            System.out.println( "getJob"+dto.getJob());
	            pstmt.setString(1, dto.getJob());
	            pstmt.setString(2, dto.getMgr());
	            pstmt.setString(3, dto.getSal());
	            pstmt.setString(4, dto.getComm());
	            pstmt.setString(5, dto.getDeptno());
	            pstmt.setString(6, dto.getEmpno());
	                       
	            rowcount=pstmt.executeUpdate();      

	         }catch(Exception e){
	            System.out.println(e.getMessage());
	         }finally {
	            Singleton_ConnectionHelper.close(pstmt);
	         }
	         return rowcount;
   }
   
   // 4.사원정보 삭제하기(ename값 받아와서)
   public int deleteList(String delete){
      PreparedStatement pstmt = null;
      int rowcount = 0;
      
      try{
         conn = Singleton_ConnectionHelper.getConnection("oracle");
         String sql = "delete from emp where empno=?";
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, delete);
         rowcount = pstmt.executeUpdate();

      }catch(Exception e){
         System.out.println(e.getMessage());
      }finally {
         Singleton_ConnectionHelper.close(pstmt);
      }
      return rowcount;
   }
   
   // 5. 사원정보 검색하기
   public ArrayList<DTO> SearchList(String select_name , String select_type){
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      ArrayList<DTO> dtolist = new ArrayList<>();
	      
	      String select_qry = "";
	      
	      if("empno".equals(select_type)){
	    	  //사원번호 검색
	    	  select_qry = "empno";
	      }else if("ename".equals(select_type)){
	    	  //사원이름 검색
	    	  select_qry = "ename";
	      }else if("sal".equals(select_type)){
	    	  //사원 월급 검색
	    	  select_qry = "sal";
	      }
	    	  
	      try{
	         conn = Singleton_ConnectionHelper.getConnection("oracle");
	         //String sql="select * from emp where "+select_type+" like ?";
	         //String sql="select * from emp where empno like ?"; //원본
	         String sql="select * from emp where "+select_qry+" like ?";
	         
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, '%' + select_name + '%');
	         rs = pstmt.executeQuery();
	         
	         System.out.println("DAO 들어왔늬 :"+select_name);
	         while(rs.next()){
	             DTO dto = new DTO();
	            dto.setEmpno(rs.getString("empno"));
	            dto.setEname(rs.getString("ename"));
	            dto.setJob(rs.getString("job"));
	            dto.setMgr(rs.getString("mgr"));
	            dto.setHiredate(rs.getDate("hiredate"));
	            dto.setSal(rs.getString("sal"));
	            dto.setComm(rs.getString("comm"));
	            dto.setDeptno(rs.getString("deptno"));
	           
	            dtolist.add(dto);
	         }
	         
	      }catch(Exception e){
	         System.out.println(e.getMessage());
	      }finally {
	         Singleton_ConnectionHelper.close(rs);
	         Singleton_ConnectionHelper.close(pstmt);
	      }
	      return dtolist;
	   }
   // 6. 사원정보 건내받기(empno 값 받아와서)
public DTO ViewList(String empno){
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      DTO dto = null;
      
      try {
         conn = Singleton_ConnectionHelper.getConnection("oracle");
         String sql = "select empno, ename, job, mgr, hiredate, sal, comm, deptno from emp where empno = ?";
         pstmt = conn.prepareStatement(sql);
		 pstmt.setString(1, empno);
         rs = pstmt.executeQuery();
         while(rs.next()){
            dto = new DTO();
            dto.setEmpno(rs.getString("empno"));
            dto.setEname(rs.getString("ename"));
            dto.setJob(rs.getString("job"));
            dto.setMgr(rs.getString("mgr"));
            dto.setHiredate(rs.getDate("hiredate"));
            dto.setSal(rs.getString("sal"));
            dto.setComm(rs.getString("comm"));
            dto.setDeptno(rs.getString("deptno"));
		 }
      } catch(Exception e){
         System.out.println(e.getMessage());
      } finally {
         Singleton_ConnectionHelper.close(rs);
         Singleton_ConnectionHelper.close(pstmt);
      }
      return dto;
   }







public ArrayList<DTO> SearchList2(String select_deptno){
	PreparedStatement pstmt = null;
    ResultSet rs = null;
    ArrayList<DTO> dtolist = new ArrayList<>();

    
    try{
       conn = Singleton_ConnectionHelper.getConnection("oracle");
       String sql="select * from emp where deptno=?";
       
       pstmt = conn.prepareStatement(sql);
       pstmt.setString(1, select_deptno);
       rs = pstmt.executeQuery();
       
       while(rs.next()){
           DTO dto = new DTO();
          dto.setEmpno(rs.getString("empno"));
          dto.setEname(rs.getString("ename"));
          dto.setJob(rs.getString("job"));
          dto.setMgr(rs.getString("mgr"));
          dto.setHiredate(rs.getDate("hiredate"));
          dto.setSal(rs.getString("sal"));
          dto.setComm(rs.getString("comm"));
          dto.setDeptno(rs.getString("deptno"));
          dtolist.add(dto);
       }
       
    }catch(Exception e){
       System.out.println(e.getMessage());
    }finally {
       Singleton_ConnectionHelper.close(rs);
       Singleton_ConnectionHelper.close(pstmt);
    }
    return dtolist;
 }
}