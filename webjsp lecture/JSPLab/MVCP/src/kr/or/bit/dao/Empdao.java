package kr.or.bit.dao;

import java.util.*;
import kr.or.bit.utils.Emp;
import kr.or.bit.utils.Singleton_Helper;
import java.sql.*;

public class Empdao {

	Connection cn = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;

	public Empdao() {
		cn = Singleton_Helper.getConnection("oracle");
	}

	public int deleteEmp(int empno) {
		// delete from memo where id=?
		int row = 0;

		try {
			String sql = "delete from emp where empno=?";
			pstmt = cn.prepareStatement(sql);
			pstmt.setInt(1, empno);
			row = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			Singleton_Helper.close(pstmt);
		}
		return row;
	}

	public int insertEmp(Emp emp) {
		// insert into memo(id,email,content) values(?,?,?)
		int resultrow = 0;
		PreparedStatement pstmt = null;
		try {

			String sql = "INSERT INTO EMP VALUES(?,?,?,?,?,?,?,?)";
			// 사번 이름 잡 mgr hir sal comm dept
			pstmt = cn.prepareStatement(sql);
			pstmt.setInt(1, emp.getEmpno());
			pstmt.setString(2, emp.getEname());
			pstmt.setString(3, emp.getJob());
			pstmt.setInt(4, emp.getMgr());
			pstmt.setString(5, emp.getHiredate());
			pstmt.setInt(6, emp.getSal());
			pstmt.setInt(7, emp.getComm());
			pstmt.setInt(8, emp.getDeptno());

			resultrow = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("Insert :" + e.getMessage());
		} finally {
			Singleton_Helper.close(pstmt);
		}

		return resultrow;
	}

	public Emp emp_search(int empno) {
		Emp temp = null;
		String sql = "select * from emp where empno = " + "'" + empno + "'";
		
		try {
			Statement stmt = cn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				temp = new Emp(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8));
				//return temp;
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			Singleton_Helper.close(rs);

		}
		return temp;
	}
	
	public ArrayList<Emp> dept_search(int deptno) {
		ArrayList<Emp> list = new ArrayList<Emp>();
		Emp temp = null;
		String sql = "select * from emp where deptno = " + "'" + deptno + "'";
		
		try {
			Statement stmt = cn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				temp = new Emp(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8));
				list.add(temp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			Singleton_Helper.close(rs);
			
		}
		return list;
	}

	// Read : 여러건 데이터(where 조건이 없어요)
	public ArrayList<Emp> getEmpList() throws SQLException {
		// select id,email,content from memo

		// Class.forName("oracle.jdbc.OracleDriver");
		// conn =
		// DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","kosta","1004");
		// 위 코드 생략

		PreparedStatement pstmt = null;
		String sql = "select empno,ename,job,mgr,hiredate,sal,comm,deptno from emp";
		pstmt = cn.prepareStatement(sql);

		ResultSet rs = pstmt.executeQuery();

		ArrayList<Emp> EmpDtolist = new ArrayList<Emp>();

		while (rs.next()) {
			Emp dto = new Emp();
			dto.setEmpno(rs.getInt("empno"));
			dto.setEname(rs.getString("ename"));
			dto.setJob(rs.getString("job"));
			dto.setMgr(rs.getInt("mgr"));
			dto.setHiredate(rs.getString("hiredate"));
			dto.setSal(rs.getInt("sal"));
			dto.setComm(rs.getInt("comm"));
			dto.setDeptno(rs.getInt("deptno"));

			EmpDtolist.add(dto);
		}

		Singleton_Helper.close(rs);
		Singleton_Helper.close(pstmt);

		return EmpDtolist;
	}

	public int updateemp(Emp emp) {
		int rowcount = 0;
		// 수정 버튼에서 loaction 으로 가면서 parameter empno값가져오기 String empno =
		// request.getParameter("empno");

		try {
			cn = Singleton_Helper.getConnection("oracle");
			String sql = "update emp set ename=? , job=?,mgr=? ,sal=? , comm=? , deptno=? where empno=?";
			pstmt = cn.prepareStatement(sql);

			pstmt.setString(1, emp.getEname());
			pstmt.setString(2, emp.getJob());
			pstmt.setInt(3, emp.getMgr());
			pstmt.setInt(4, emp.getSal());
			pstmt.setInt(5, emp.getComm());
			pstmt.setInt(6, emp.getDeptno());
			pstmt.setInt(7, emp.getEmpno());

			rowcount = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			Singleton_Helper.close(pstmt);
		}

		return rowcount;
	}

}
