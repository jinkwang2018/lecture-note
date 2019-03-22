package kr.or.kosta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kr.or.kosta.dto.Emp;

public class Empdao {
	static DataSource ds;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public Empdao() throws NamingException {
		Context context = new InitialContext();
		ds = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
	   }
	
	public Emp getEmpListByEmpno(int empno) throws SQLException {
		conn=ds.getConnection();
		Emp emp = new Emp();
		try {
			String sql = "select empno,ename, job, mgr, hiredate, sal, nvl(comm, 0) comm, deptno from Emp where empno=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empno);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				emp.setMgr(rs.getInt("mgr"));
				emp.setHiredate(rs.getDate("hiredate"));
				emp.setSal(rs.getInt("sal"));
				emp.setComm(rs.getInt("comm"));
				emp.setDeptno(rs.getInt("deptno"));
			}
			System.out.println("요요 " + emp);
		} catch (Exception e) {
			

		} finally {
			if(pstmt!=null)try {pstmt.close();}catch(Exception e) {}
			if(conn!=null)try {conn.close();}catch(Exception e) {}
			if(rs!=null)try {rs.close();}catch(Exception e) {}
		}
		return emp;
	}
	
	public ArrayList<Emp> getEmpListByDeptno(int deptno) throws SQLException {
		ArrayList<Emp> dlist = new ArrayList<Emp>();
		conn=ds.getConnection();
		try {
			String sql = "select empno,ename, job, mgr, hiredate, sal, nvl(comm, 0) comm, deptno from Emp where deptno=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Emp e = new Emp();
				e.setEmpno(rs.getInt("empno"));
				e.setEname(rs.getString("ename"));
				e.setJob(rs.getString("job"));
				e.setMgr(rs.getInt("mgr"));
				e.setHiredate(rs.getDate("hiredate"));
				e.setSal(rs.getInt("sal"));
				e.setComm(rs.getInt("comm"));
				e.setDeptno(rs.getInt("deptno"));
				dlist.add(e);
			}

		} catch (Exception e) {
			

		} finally {
			if(pstmt!=null)try {pstmt.close();}catch(Exception e) {}
			if(conn!=null)try {conn.close();}catch(Exception e) {}
			if(rs!=null)try {rs.close();}catch(Exception e) {}
		}
		return dlist;
	}

	public ArrayList<Emp> getEmpList() throws SQLException {
		conn=ds.getConnection();
		String sql = "select empno,ename,job,mgr,hiredate,sal,comm,deptno from emp";
		pstmt = conn.prepareStatement(sql);

		ResultSet rs = pstmt.executeQuery();

		ArrayList<Emp> emplist = new ArrayList<Emp>();

		while (rs.next()) {
			Emp m = new Emp();
			m.setEmpno(rs.getInt("empno"));
			m.setEname(rs.getString("ename"));
			m.setJob(rs.getString("job"));
			m.setMgr(rs.getInt("mgr"));
			m.setHiredate(rs.getDate("hiredate"));
			m.setSal(rs.getInt("sal"));
			m.setComm(rs.getInt("comm"));
			m.setDeptno(rs.getInt("deptno"));

			emplist.add(m);
			System.out.println("ename: " + m.getEname());
		}

		if(pstmt!=null)try {pstmt.close();}catch(Exception e) {}
		if(conn!=null)try {conn.close();}catch(Exception e) {}
		if(rs!=null)try {rs.close();}catch(Exception e) {}

		return emplist;

	}
	
	public ArrayList<Emp> getEmpList(int cp) throws SQLException {
		conn=ds.getConnection();
		String sql = "";
		if(cp == -1) {
			sql = "select empno,ename,job,mgr,hiredate,sal,comm,deptno from emp";
		}else {
			sql= "select * from " + 
				    "( select rownum rn , EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO " +
			            " from ( "+
			                     " SELECT * FROM " +
					             " emp" + 
			                 " ) where rownum <= ? " + 
					") where rn >= ?";
		}
		
		pstmt = conn.prepareStatement(sql);
		
		if(cp != -1) {
			int start = cp * 2 + 1;
			int end = start + 1;
			pstmt.setInt(1, end);
			pstmt.setInt(2, start);
		}		
		
		ResultSet rs = pstmt.executeQuery();
		
		ArrayList<Emp> emplist = new ArrayList<Emp>();
		
		while (rs.next()) {
			Emp m = new Emp();
			m.setEmpno(rs.getInt("empno"));
			m.setEname(rs.getString("ename"));
			m.setJob(rs.getString("job"));
			m.setMgr(rs.getInt("mgr"));
			m.setHiredate(rs.getDate("hiredate"));
			m.setSal(rs.getInt("sal"));
			m.setComm(rs.getInt("comm"));
			m.setDeptno(rs.getInt("deptno"));
			
			emplist.add(m);
			System.out.println("ename: " + m.getEname());
		}
		
		if(pstmt!=null)try {pstmt.close();}catch(Exception e) {}
		if(conn!=null)try {conn.close();}catch(Exception e) {}
		if(rs!=null)try {rs.close();}catch(Exception e) {}
		
		return emplist;
		
	}
	
	public ArrayList<Integer> getDeptnoList() throws SQLException {
			conn=ds.getConnection();	
			String sql = "select DISTINCT deptno from emp order by deptno asc";
			pstmt = conn.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			
			ArrayList<Integer> deptnoList = new ArrayList<Integer>();
			 
			while(rs.next()) {
				deptnoList.add(rs.getInt("deptno"));
			}
			if(pstmt!=null)try {pstmt.close();}catch(Exception e) {}
			if(conn!=null)try {conn.close();}catch(Exception e) {}
			if(rs!=null)try {rs.close();}catch(Exception e) {}
			
			return deptnoList;
	   }
	
	public int updateEmp(int empno, String ename, String job, int mgr, String hiredate, int sal, int comm, int deptno) throws SQLException {
		int result = 0;
		conn=ds.getConnection();
		try {
			String sql = "update emp set ename=?, job=?, mgr=?, hiredate= ?, sal=?, comm=?, deptno=? where empno=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ename);
			pstmt.setString(2, job);
			pstmt.setInt(3, mgr);
			pstmt.setString(4, hiredate);
			pstmt.setInt(5, sal);
			pstmt.setInt(6, comm);
			pstmt.setInt(7, deptno);
			pstmt.setInt(8, empno);
			
			result = pstmt.executeUpdate();
			System.out.println(result);
		} catch (Exception e1) {
			System.out.println("Update : " + e1.getMessage());
		} finally {
			if(pstmt!=null)try {pstmt.close();}catch(Exception e) {}
			if(conn!=null)try {conn.close();}catch(Exception e) {}
		}

		return result;
	}
	public int insertEmp(int empno, String ename,String job,int mgr,String hiredate,int sal,int comm,int deptno) throws SQLException {
		//insert into memo(id,email,content) values(?,?,?)
		int resultrow=0;
		conn=ds.getConnection();
		try {
			   
			   String sql="insert into emp(empno, ename, job, mgr, hiredate, sal, comm, deptno) values(?,?,?,?,?,?,?,?)";
			   
			   pstmt = conn.prepareStatement(sql);
			   pstmt.setInt(1, empno);
			   pstmt.setString(2, ename);
			   pstmt.setString(3, job);
			   pstmt.setInt(4, mgr);
			   pstmt.setString(5, hiredate);
			   pstmt.setInt(6, sal);
			   pstmt.setInt(7, comm);
			   pstmt.setInt(8, deptno);
			   
			   resultrow = pstmt.executeUpdate();
			System.out.println(hiredate);
		}catch(Exception e) {
			System.out.println("Insert :" + e.getMessage());
		}finally {
			if(pstmt!=null)try {pstmt.close();}catch(Exception e) {}
			if(conn!=null)try {conn.close();}catch(Exception e) {}
		}
 
		return resultrow;
	}
	public int deleteEmp(String empno) throws SQLException {
	      // delete from memo where id=?
		conn=ds.getConnection();
			int rs = 0;
			try {
					String sql = "delete from emp where empno=?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, empno);
					
					rs = pstmt.executeUpdate();
			}catch (Exception e) {
				
			}finally {
				if(pstmt!=null)try {pstmt.close();}catch(Exception e) {}
				if(conn!=null)try {conn.close();}catch(Exception e) {}
			}
			return rs;
		}
	public int totalEmpCount() throws SQLException {
		conn=ds.getConnection();
		int totalcount = 0;
		try {
			String sql="select count(*) cnt from emp";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				totalcount = rs.getInt("cnt");
			}
		}catch (Exception e) {
			
		}finally {
			if(pstmt!=null)try {pstmt.close();}catch(Exception e) {}
			if(conn!=null)try {conn.close();}catch(Exception e) {}
			if(rs!=null)try {rs.close();}catch(Exception e) {}
}
		return totalcount;
	}
	public List<Emp> list(int cpage, int pagesize){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Emp> list = null;
		try {
			String sql= 	"select * from " + 
						    "( select empno,ename,job,mgr,hiredate,sal,comm,deptno" +
					            " from emp where rownum <= ? " + 
							") where rn >= ?";
			pstmt = conn.prepareStatement(sql);
			
			int start = cpage * pagesize - (pagesize -1);
			int end = cpage * pagesize;
			
			pstmt.setInt(1, end);
			pstmt.setInt(2, start);
			
			rs = pstmt.executeQuery();
			
			list = new ArrayList<>();
			while(rs.next()) {
				//순번	제목	  글쓴이	날짜	조회수
				Emp e = new Emp();
				e.setEmpno(rs.getInt("empno"));
				e.setEname(rs.getString("ename"));
				e.setJob(rs.getString("job"));
				e.setMgr(rs.getInt("mgr"));
				e.setHiredate(rs.getDate("hiredate"));
				e.setSal(rs.getInt("sal"));
				e.setComm(rs.getInt("comm"));
				e.setDeptno(rs.getInt("deptno"));
				
				list.add(e);
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null)try {pstmt.close();}catch(Exception e) {}
			if(conn!=null)try {conn.close();}catch(Exception e) {}
			if(rs!=null)try {rs.close();}catch(Exception e) {}
			}
		return list;
	}
}

