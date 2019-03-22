package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import DTO.Dept;
import UTIL.Singleton_Helper;

/*
 목적 : DB연결 -> CRUD작업
 
 CRUD
 1.전체조회 select deptno , dname , loc from dept
 2.조건조회 select deptno , dname , loc from dept where deptno=?
 3.삽입       insert into dept(deptno,dname,loc) values(?,?,?)
 4.수정       update dept set dname = ? , loc = ? where deptno = ?
 5.삭제       delete from dept where deptno = ?
 parameter 처리 , return값 처리
 */
public class DeptDao {
	// DB연결 작업

	// 1.multi row >>전체 조회
	public List<Dept> getDeptAllList() {
		// select deptno , dname , loc from dept
		List<Dept> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = Singleton_Helper.getConnection("oracle");
			String sql = "select deptno , dname , loc from dept";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Dept dept = new Dept(); // 다른 객체를 만들어야 하므로 밖에 쓰면 안된다.
				dept.setDeptno(rs.getInt("deptno"));
				dept.setDname(rs.getString("dname"));
				dept.setLoc(rs.getString("loc"));
				list.add(dept); // 배열에 객체 추가
				/*
				 * Dept 설계 생성자 public Dept(int deptno , ...){ this.deptno = deptno;... }
				 * while(rs.next()){ list.add(new dept(rs.getInt("deptno"),...); }
				 */
			}
		} catch (Exception e) {
			e.getStackTrace();
			System.out.println(e.getMessage());
		} finally {
			Singleton_Helper.close(rs);
			Singleton_Helper.close(pstmt);
		}
		return list;
	}

	// 2.single row >> 조건 조회
	public Dept getDeptListByDeptno(int deptno) {
		// select deptno , dname , loc from dept where deptno=?
		Dept dept = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = Singleton_Helper.getConnection("oracle");
			String sql = "select deptno , dname , loc from dept where deptno=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				dept = new Dept();
				dept.setDeptno(rs.getInt("deptno"));
				dept.setDname(rs.getString("dname"));
				dept.setLoc(rs.getString("loc"));

			}
		} catch (Exception e) {
			e.getStackTrace();
			System.out.println(e.getMessage());
		} finally {
			Singleton_Helper.close(rs);
			Singleton_Helper.close(pstmt);
		}
		return dept;
	}

	// 3.insert
	public int insertDept(Dept dept) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		int row = 0;
		try {
			conn = Singleton_Helper.getConnection("oracle");
			String sql = "insert into dept(deptno,dname,loc) values(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dept.getDeptno());
			pstmt.setString(2, dept.getDname());
			pstmt.setString(3, dept.getLoc());
			row = pstmt.executeUpdate();
			if (row > 0) {
				System.out.println(dept.toString());
			} else {
				System.out.println("row count :" + row);
			}

		} catch (Exception e) {
			e.getStackTrace();
			System.out.println(e.getMessage());
		} finally {
			Singleton_Helper.close(pstmt);
		}
		return row;
	}

	// 4.update
	public int updateDept(Dept dept) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		int row = 0;
		Scanner sc = new Scanner(System.in);
		try {
			conn = Singleton_Helper.getConnection("oracle");
			String sql = "update dept set dname = ? , loc = ? where deptno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dept.getDname());
			pstmt.setString(2, dept.getLoc());
			pstmt.setInt(3, dept.getDeptno());
			row = pstmt.executeUpdate();
			if (row > 0) {
				System.out.println("row count :" + row);
			} else {
				System.out.println("row count :" + row);
			}

		} catch (Exception e) {
			e.getStackTrace();
			System.out.println(e.getMessage());
		} finally {
			Singleton_Helper.close(pstmt);
		}
		return row;
	}

	// 5.delete
	public int deleteDept(int deptno) {
		// delete from dept where deptno = ?
		Connection conn = null;
		PreparedStatement pstmt = null;
		int row = 0;
		Scanner sc = new Scanner(System.in);
		try {
			conn = Singleton_Helper.getConnection("oracle");
			String sql = "delete from dept where deptno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			row = pstmt.executeUpdate();
			if (row > 0) {
				System.out.println("row count :" + row);
			} else {
				System.out.println("row count :" + row);
			}

		} catch (Exception e) {
			e.getStackTrace();
			System.out.println(e.getMessage());
		} finally {
			Singleton_Helper.close(pstmt);
		}
		return row;
	}

	// 6.search
	public List<Dept> getDeptListByDname(String dname) {
		// select deptno , dname , loc from dept where deptno=?
		List<Dept> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = Singleton_Helper.getConnection("oracle");
			String sql = "select deptno , dname , loc from dept where dname like '%' || ? || '%'";
			/*
			 * select empno,ename from emp 
			 * where deptno in(select deptno from emp where ENAME LIKE '%T%');
			 * 
			 */

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dname);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Dept dept = new Dept();
				dept.setDeptno(rs.getInt("deptno"));
				dept.setDname(rs.getString("dname"));
				dept.setLoc(rs.getString("loc"));

				list.add(dept);

			}
		} catch (Exception e) {
			e.getStackTrace();
			System.out.println(e.getMessage());
		} finally {
			Singleton_Helper.close(rs);
			Singleton_Helper.close(pstmt);
		}
		return list;
	}

}
