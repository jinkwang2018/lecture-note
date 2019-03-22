package kr.or.bit.dao;

import java.sql.Connection; 
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kr.or.bit.dto.BookDto;
import kr.or.bit.dto.NoteDto;


public class NoteDao {
DataSource datasource = null;
	
	public NoteDao() throws NamingException {
		Context context = new InitialContext();
		datasource = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
	}
	
	
	public List getBookSearchList(String book_title,String id) throws SQLException {
		PreparedStatement pstmt = null;
		String sql = "select book_no, book_title from Book where book_title like ? AND id=? ORDER BY book_no DESC";

		Connection conn= datasource.getConnection();
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "%"+book_title+"%");
		pstmt.setString(2, id);
		ResultSet rs = pstmt.executeQuery();
		
		ArrayList<BookDto> booklist = new ArrayList<BookDto>();
		 
		while(rs.next()) {
			BookDto b = new BookDto();
			b.setBook_no((rs.getInt(1)));
			b.setBook_title((rs.getString(2)));
			booklist.add(b);
		}
		rs.close();
		pstmt.close();
		conn.close(); 
		
		return booklist;
	}
	
	public List getNoteSearchList(String note_title,String id) throws SQLException {

		PreparedStatement pstmt = null;
		String sql = "select note_num, note_title, id, note_content ,TO_CHAR(note_date,'yyyy/mm/dd') , book_no from NOTE where note_title like ? AND id=? ORDER BY note_num DESC";

		Connection conn= datasource.getConnection();

		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "%"+note_title+"%");
		pstmt.setString(2, id);
		ResultSet rs = pstmt.executeQuery();
		
		ArrayList<NoteDto> notelist = new ArrayList<NoteDto>();
		 
		while(rs.next()) {
			NoteDto n = new NoteDto();
			n.setNote_num(rs.getInt(1));
			n.setNote_title(rs.getString(2));
			n.setId(rs.getString(3));
			n.setNote_content(rs.getString(4));
			n.setNote_date(rs.getString(5));
			n.setBook_no(rs.getInt(6));
			
			notelist.add(n);
		}
		
		rs.close();
		pstmt.close();
		conn.close(); //반환하기
		
		return notelist;
	}
	
	
	public int deleteBook(int book_no) throws SQLException {
		int resultrow = 0;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		Connection conn = null;
		try {
			String sql = "delete from NOTE where book_no=?";
			String sql2 = "delete from BOOK where book_no=?";
		
			conn = datasource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, book_no);
			resultrow = pstmt.executeUpdate();
			
			pstmt2 = conn.prepareStatement(sql2);
			pstmt2.setInt(1, book_no);
			resultrow = pstmt2.executeUpdate();

		} catch (Exception e) {
			System.out.println("delete :" + e.getMessage());
		} finally {
			pstmt.close();
			pstmt2.close();
			conn.close();
		}
		return resultrow;
	}
	
	public List getSelectNoteList(int book_no) throws SQLException {
		PreparedStatement pstmt = null;
		String sql = "select note_num, note_title, id, note_content ,TO_CHAR(note_date,'yyyy/mm/dd'), book_no from NOTE where book_no=? ORDER BY note_num DESC";
		
		Connection conn= datasource.getConnection();

		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, book_no);

		ResultSet rs = pstmt.executeQuery();
		
		ArrayList<NoteDto> notelist = new ArrayList<NoteDto>();
		 
		while(rs.next()) {
			NoteDto n = new NoteDto();
			n.setNote_num(rs.getInt(1));
			n.setNote_title(rs.getString(2));
			n.setId(rs.getString(3));
			n.setNote_content(rs.getString(4));
			n.setNote_date(rs.getString(5));
			n.setBook_no(rs.getInt(6));
			
			notelist.add(n);
		}
		
		rs.close();
		pstmt.close();
		conn.close(); 
		
		return notelist;
	}
	
	
	public int insertBook(BookDto book) throws SQLException {
		int resultrow=0;
		PreparedStatement pstmt = null;
		Connection conn = null;
		try {   
			   String sql="insert into BOOK(book_no,book_title,id) values(BOOK_SEQ.NEXTVAL,?,?)";
			   conn= datasource.getConnection();
			   pstmt = conn.prepareStatement(sql);
			   pstmt.setString(1, book.getBook_title());
			   pstmt.setString(2, book.getId());
			   
			   resultrow = pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("Insert :" + e.getMessage());
		}finally {
			pstmt.close();
			conn.close();
		}
		return resultrow;
	}
	
	
	public List getBookList(String id) throws SQLException {
		PreparedStatement pstmt = null;
		String sql = "select book_no, book_title from BOOK where id =? ORDER BY book_no DESC";
		
		Connection conn= datasource.getConnection();

		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();
		
		ArrayList<BookDto> booklist = new ArrayList<BookDto>();
		 
		while(rs.next()) {
			BookDto b = new BookDto();
			b.setBook_no(rs.getInt(1));
			b.setBook_title(rs.getString(2));
			booklist.add(b);
		}
		
		rs.close();
		pstmt.close();
		conn.close(); //반환하기
		
		return booklist;
	}
	
	public int updateNote(NoteDto note) throws SQLException{
		int resultrow=0;
		PreparedStatement pstmt = null;
		Connection conn = null;
	try{
		String sql="update note set note_title =?,note_content=?,note_date=sysdate,book_no=? where note_num=?";
		conn= datasource.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, note.getNote_title());
		pstmt.setString(2, note.getNote_content());
		pstmt.setInt(3, note.getBook_no());
		pstmt.setInt(4, note.getNote_num());
		
		resultrow =pstmt.executeUpdate();
	
	}catch(Exception e) {
		System.out.println("delete :" + e.getMessage());
	}finally{
		pstmt.close();
		conn.close();
	}
	return resultrow;
}
	
	public NoteDto getNoteSelect(int note_num) throws SQLException {
		PreparedStatement pstmt = null;
		String sql = "select note_num, note_title, id, note_content, book_no from NOTE where note_num= ?";
		
		Connection conn= datasource.getConnection();

		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, note_num);
		ResultSet rs = pstmt.executeQuery();
		 
		rs.next(); 
		NoteDto n = new NoteDto();
		n.setNote_num(rs.getInt(1));
		n.setNote_title(rs.getString(2));
		n.setId(rs.getString(3));
		n.setNote_content(rs.getString(4));
		n.setBook_no(rs.getInt(5));
		
		rs.close();
		pstmt.close();
		conn.close();
		
		return n;
	}
	
	public int deleteNote(int note_num) throws SQLException{
			int resultrow=0;
			PreparedStatement pstmt = null;
			Connection conn = null;
		try{
			String sql="delete from NOTE where note_num=?";
			conn= datasource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, note_num);
			resultrow =pstmt.executeUpdate();

		}catch(Exception e) {
			System.out.println("delete :" + e.getMessage());
		}finally{
			pstmt.close();
			conn.close();
		}
		return resultrow;
	}

	public int insertNote(NoteDto note) throws SQLException {
		int resultrow=0;
		PreparedStatement pstmt = null;
		Connection conn = null;
		try {
			   String sql="insert into NOTE(note_num, note_title, id, note_content,note_date, book_no) values(NOTE_SEQ.NEXTVAL,?,?,?,sysdate,?)";
			   conn= datasource.getConnection();
			   pstmt = conn.prepareStatement(sql);
			   pstmt.setString(1, note.getNote_title());
			   pstmt.setString(2, note.getId());
			   pstmt.setString(3, note.getNote_content());
			   pstmt.setInt(4, note.getBook_no());
			 
			   resultrow = pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("Insert :" + e.getMessage());
		}finally {
			pstmt.close();
			conn.close();
		}
		return resultrow;
	}
	
	public List getNoteList(String id) throws SQLException {
		PreparedStatement pstmt = null;
		String sql = "select note_num, note_title, id, note_content ,TO_CHAR(note_date,'yyyy/mm/dd'), book_no from NOTE where id=? ORDER BY note_num DESC";
		
		Connection conn= datasource.getConnection();

		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();
		
		ArrayList<NoteDto> notelist = new ArrayList<NoteDto>();
		 
		while(rs.next()) {
			NoteDto n = new NoteDto();
			n.setNote_num(rs.getInt(1));
			n.setNote_title(rs.getString(2));
			n.setId(rs.getString(3));
			n.setNote_content(rs.getString(4));
			n.setNote_date(rs.getString(5));
			n.setBook_no(rs.getInt(6));
			
			notelist.add(n);
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		
		return notelist;
	}
}