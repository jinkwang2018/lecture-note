package kr.or.kosta.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import kr.or.kosta.DTO.empDTO;
import kr.or.kosta.utils.Singleton_ConnectionHelper;

public class empDAO {

			Connection conn= null;
			
			
			//사원(멤버)등록
			public int insert(empDTO empdto){
				PreparedStatement pstmt = null;
				int result = 0;
						 
				try{
					conn = Singleton_ConnectionHelper.getConnection("oracle");
					 String sql="insert into copyemp(empno, ename, job,mgr, hiredate, sal, comm,deptno) values(?,?,?,?,to_date(?),?,?,?)";
					    pstmt = conn.prepareStatement(sql);
					    
					    pstmt.setInt(1, empdto.getEmpno());
					    pstmt.setString(2, empdto.getEname());
					    pstmt.setString(3, empdto.getJob());
					    pstmt.setInt(4, empdto.getMgr());
					    pstmt.setString(5, empdto.getHiredate());
					    pstmt.setInt(6, empdto.getSal());
					    pstmt.setInt(7, empdto.getComm());
					    pstmt.setInt(8, empdto.getDeptno());
						
					result = pstmt.executeUpdate();
					System.out.println(result);
					
				}catch(Exception e){
					//pstmt.executeUpdate(); 시점에 PK 예외가 발생 if 타지 않고 ... 예외처리
					System.out.println("insert() 오류: "+e.getMessage());
					
				}finally{
					if(pstmt != null) try{pstmt.close();}catch(Exception e){}

				}
				return result;
			}
			
			//멤버(사원)수정
			public int update(empDTO empdto) throws ParseException{
				PreparedStatement pstmt = null;
				int result = 0;
				 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
	              java.util.Date date = sdf.parse(empdto.getHiredate());
	              java.sql.Date sqlDate = new Date(date.getTime());

			 
				try{
					conn = Singleton_ConnectionHelper.getConnection("oracle");
					String sql="update copyemp set empno=? , ename=? , job=? , mgr=?, hiredate= ?, sal=?, comm=?, deptno=? where empno=?";
			        
					pstmt = conn.prepareStatement(sql);

						pstmt.setInt(1, empdto.getEmpno());
					    pstmt.setString(2, empdto.getEname());
					    pstmt.setString(3, empdto.getJob());
					    pstmt.setInt(4, empdto.getMgr());
					    pstmt.setDate(5, sqlDate);
					    pstmt.setInt(6, empdto.getSal());
					    pstmt.setInt(7, empdto.getComm());
					    pstmt.setInt(8, empdto.getDeptno());
					    pstmt.setInt(9, empdto.getEmpno());
				
					pstmt.executeUpdate();

					
					result = pstmt.executeUpdate();
					System.out.println(result);
					
				}catch(Exception e){
					//pstmt.executeUpdate(); 시점에 PK 예외가 발생 if 타지 않고 ... 예외처리
					System.out.println("update() 오류: "+e.getMessage());
					
				}finally{
					if(pstmt != null) try{pstmt.close();}catch(Exception e){}

				}

				return result;
			}
			
			
			
			//멤버(사원)삭제
			public int delete(int empno){
				
				PreparedStatement pstmt = null;
				int result = 0;
				
			 
				try{
					conn = Singleton_ConnectionHelper.getConnection("oracle");
					String sql="delete from copyemp where empno=?";
					
					pstmt = conn.prepareStatement(sql);
					
					pstmt.setInt(1, empno);

					
					result = pstmt.executeUpdate();
					System.out.println(result);
					
				}catch(Exception e){
					//pstmt.executeUpdate(); 시점에 PK 예외가 발생 if 타지 않고 ... 예외처리
					System.out.println("delete() 오류: "+e.getMessage());
					
				}finally{
					if(pstmt != null) try{pstmt.close();}catch(Exception e){}

				}
		
				return result;
			}
			
			
			
			//멤버(사원) select one (수정용)
			public empDTO getMember(int empno){
				
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				empDTO empdto = new empDTO();

				
				try{
				conn = Singleton_ConnectionHelper.getConnection("oracle");
				String sql = "select empno, ename, job, mgr, TO_CHAR(hiredate, 'YYYY-MM-DD'), sal, comm, deptno from copyemp where empno=?";
				pstmt = conn.prepareStatement(sql);
				

				pstmt.setInt(1, empno );
				
				rs = pstmt.executeQuery();
				
				while(rs.next()){
					empdto = new empDTO();
					
					empdto = new empDTO(); 
					empdto.setEmpno(rs.getInt(1));
					empdto.setEname(rs.getString(2));
					empdto.setJob(rs.getString(3));
					empdto.setMgr(rs.getInt(4));
					empdto.setHiredate(rs.getString(5));
					empdto.setSal(rs.getInt(6));
					empdto.setComm(rs.getInt(7));
					empdto.setDeptno(rs.getInt(8));
				}
				
				
			}catch(Exception e){
				//pstmt.executeUpdate(); 시점에 PK 예외가 발생 if 타지 않고 ... 예외처리
				System.out.println("getMember() 오류: "+e.getMessage());
				
			}finally{
				if(pstmt != null) try{pstmt.close();}catch(Exception e){}

			}
				
				return empdto;
			}
			
			
////////////////////search/////////////////////////////			
			
			//멤버(사원) select one (검색 결과 수)
			public int countMember(String name){
				
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				int count = 0;
				
				try{
				conn = Singleton_ConnectionHelper.getConnection("oracle");
				 String sql="select count(*) from copyemp where ename like ?";
	             pstmt = conn.prepareStatement(sql);
	             pstmt.setString(1, '%' + name + '%');
	             rs = pstmt.executeQuery();
	             rs.next();
	             count = rs.getInt(1); //조회건수
	             
				}catch(Exception e){
					//pstmt.executeUpdate(); 시점에 PK 예외가 발생 if 타지 않고 ... 예외처리
					System.out.println("countMember() 오류: "+e.getMessage());
					
				}finally{
					if(pstmt != null) try{pstmt.close();}catch(Exception e){}
				}
			
				
				return count;
			}
			
			
			//멤버(사원) select one (autocomplete)
			public ResultSet autokey(String keyword){
				
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				
				
				try{
				conn = Singleton_ConnectionHelper.getConnection("oracle");
				String sql="select ename  from copyemp where ename like '%" + keyword + "%'";

		         pstmt = conn.prepareStatement(sql);

		         rs = pstmt.executeQuery();
		  
		        
				
			}catch(Exception e){
				//pstmt.executeUpdate(); 시점에 PK 예외가 발생 if 타지 않고 ... 예외처리
				System.out.println("search() 오류: "+e.getMessage());
				
			}finally{
				if(pstmt != null) try{pstmt.close();}catch(Exception e){}

			}
				return rs;
			}
			
			
			
			//멤버(사원) select one (검색 회원 출력)
			public ArrayList<empDTO> search(String name){
				
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				empDTO empdto = null;
				ArrayList<empDTO> emplist = new ArrayList<empDTO>();

				
				try{
				conn = Singleton_ConnectionHelper.getConnection("oracle");
				String sql="select empno, ename, job, mgr, TO_CHAR(hiredate, 'YYYY-MM-DD'), sal, comm, deptno from copyemp where ename like '%" + name + "%'";

		         pstmt = conn.prepareStatement(sql);

		         rs = pstmt.executeQuery();
		         
		        
		         while(rs.next()){
		         empdto = new empDTO();
					
		         	empdto.setEmpno(rs.getInt(1));
					empdto.setEname(rs.getString(2));
					empdto.setJob(rs.getString(3));
					empdto.setMgr(rs.getInt(4));
					empdto.setHiredate(rs.getString(5));
					empdto.setSal(rs.getInt(6));
					empdto.setComm(rs.getInt(7));
					empdto.setDeptno(rs.getInt(8));
					emplist.add(empdto);
		         }
		        
				
			}catch(Exception e){
				//pstmt.executeUpdate(); 시점에 PK 예외가 발생 if 타지 않고 ... 예외처리
				System.out.println("search() 오류: "+e.getMessage());
				
			}finally{
				if(pstmt != null) try{pstmt.close();}catch(Exception e){}

			}
				return emplist;
			}
			
			
			
			
			
			
			//멤버(사원) select All
			public ArrayList<empDTO> getMemberList(){
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				empDTO empdto ;
				ArrayList<empDTO> emplist  = new ArrayList<empDTO>();
			
				
				try{
				conn = Singleton_ConnectionHelper.getConnection("oracle");
				String sql = "select empno, ename, job, mgr, TO_CHAR(hiredate, 'YYYY-MM-DD'), sal, comm, deptno from copyemp";
				pstmt = conn.prepareStatement(sql);
				
				rs = pstmt.executeQuery();
				
				while(rs.next()){
					empdto = new empDTO(); 
					empdto.setEmpno(rs.getInt(1));
					empdto.setEname(rs.getString(2));
					empdto.setJob(rs.getString(3));
					empdto.setMgr(rs.getInt(4));
					empdto.setHiredate(rs.getString(5));
					empdto.setSal(rs.getInt(6));
					empdto.setComm(rs.getInt(7));
					empdto.setDeptno(rs.getInt(8));
					emplist.add(empdto);

				}
				
				}catch(Exception e){
					//pstmt.executeUpdate(); 시점에 PK 예외가 발생 if 타지 않고 ... 예외처리
					System.out.println("getMemberList() 오류: "+e.getMessage());
					
				}finally{
					if(pstmt != null) try{pstmt.close();}catch(Exception e){}

				}
				
				return emplist;
			}
			
			
			//부서검색 부서명가져오기
			public ArrayList<empDTO> d_name(){
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				empDTO empdto = null;
				ArrayList<empDTO> dnamlist = new ArrayList<empDTO>();

				
				try{
				conn = Singleton_ConnectionHelper.getConnection("oracle");
				String sql="SELECT  dname FROM dept";

		         pstmt = conn.prepareStatement(sql);
		      
		         rs = pstmt.executeQuery();
		         
		        
		         while(rs.next()){
		         empdto = new empDTO();
					empdto.setDname(rs.getString(1));
					dnamlist.add(empdto);
		         }
		        
				
			}catch(Exception e){
				//pstmt.executeUpdate(); 시점에 PK 예외가 발생 if 타지 않고 ... 예외처리
				System.out.println("search() 오류: "+e.getMessage());
				
			}finally{
				if(pstmt != null) try{pstmt.close();}catch(Exception e){}

			}
				return dnamlist;
			}
			
			//멤버(사원) select one 부서검색
			public ArrayList<empDTO> serachDept(String dname){
				
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				empDTO empdto = null;
				ArrayList<empDTO> emplist = new ArrayList<empDTO>();

				
				try{
				conn = Singleton_ConnectionHelper.getConnection("oracle");
				String sql="SELECT  d.dname, e.empno , e.ename , e.sal , e.job FROM copyemp e join copydept d ON e.deptno = d.deptno WHERE dname=?";

		         pstmt = conn.prepareStatement(sql);
		         pstmt.setString(1, dname);
		         rs = pstmt.executeQuery();
		         
		        
		         while(rs.next()){
		         empdto = new empDTO();
					empdto.setDname(rs.getString(1));
		         	empdto.setEmpno(rs.getInt(2));
					empdto.setEname(rs.getString(3));
					empdto.setSal(rs.getInt(4));
					empdto.setJob(rs.getString(5));
				
					emplist.add(empdto);
		         }
		        
				
			}catch(Exception e){
				//pstmt.executeUpdate(); 시점에 PK 예외가 발생 if 타지 않고 ... 예외처리
				System.out.println("search() 오류: "+e.getMessage());
				
			}finally{
				if(pstmt != null) try{pstmt.close();}catch(Exception e){}

			}
				return emplist;
			}
			
}
