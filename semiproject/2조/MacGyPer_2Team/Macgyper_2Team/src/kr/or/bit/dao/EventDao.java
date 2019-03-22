package kr.or.bit.dao;

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

import kr.or.bit.dto.EventDto;

public class EventDao {
DataSource datasource = null;
	
	public EventDao() throws NamingException {
		Context context = new InitialContext();
		datasource = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
		
	}
	
	public List getEventList(String id) throws Exception {
				
				PreparedStatement pstmt = null;
				String sql = "select id,event_id,event_title,event_content,event_startdate,event_enddate,event_color from event where id=?";
				
				//연결 객체 얻기
				Connection conn= datasource.getConnection();
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				ResultSet rs = pstmt.executeQuery();
				
				ArrayList<EventDto> eventlist = new ArrayList<EventDto>();
				 
				while(rs.next()) {
					EventDto e = new EventDto();
					e.setUser_id(rs.getString("id"));;
					e.setEvent_id(rs.getInt("event_id"));
					e.setEvent_title(rs.getString("event_title"));
					e.setEvent_content(rs.getString("event_content"));
					e.setEvent_startdate(rs.getString("event_startdate"));
					e.setEvent_enddate(rs.getString("event_enddate"));
					e.setEvent_color(rs.getString("event_color"));
					eventlist.add(e);
				}
				
				rs.close();
				pstmt.close();
				conn.close(); //반환하기
				return eventlist;
		
	}
	public int insertEvent(EventDto edto) throws SQLException {
		int resultrow=0;
		PreparedStatement pstmt = null;
		Connection conn = null;
		try {
			   
			   String insert_sql="insert into event(id, event_id, event_title, event_content,event_startdate, event_enddate,event_color) values(?,event_no.nextval,?,?,TO_DATE(?,'yyyy-mm-dd hh24:mi:ss'),TO_DATE(?,'yyyy-mm-dd hh24:mi:ss'),?)";
			   conn= datasource.getConnection();
			   pstmt = conn.prepareStatement(insert_sql);
			   pstmt.setString(1, edto.getUser_id());
			   pstmt.setString(2, edto.getEvent_title());
			   pstmt.setString(3, edto.getEvent_content());
			   pstmt.setString(4, edto.getEvent_startdate());
			   pstmt.setString(5, edto.getEvent_enddate());
			   pstmt.setString(6, edto.getEvent_color());
			
			   resultrow = pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("Insert :" + e.getMessage());
		}finally {
			pstmt.close();
			conn.close();
		}
 
		return resultrow;
	}
	
	public int deleteEvent(int event_id) throws Exception {
		int resultrow=0;
		PreparedStatement pstmt = null;
		Connection conn = null;

		try {
			String delete_sql = "delete from event where event_id=?";
			conn = datasource.getConnection();
			pstmt = conn.prepareStatement(delete_sql);
			pstmt.setInt(1, event_id);
			
			resultrow = pstmt.executeUpdate();
			
		} catch (Exception ex) {
			System.out.println("Delete 에러 : " + ex);
		} finally {
			pstmt.close();
			conn.close();
		}
		return resultrow;
	}
	
	public int updateEvent(EventDto edto) throws Exception {
		int resultrow=0;
		PreparedStatement pstmt = null;
		Connection conn = null;
		try {
			String update_sql = "update event set event_title=?,event_content=?,event_startdate=TO_DATE(?,'yyyy-mm-dd hh24:mi:ss'),event_enddate=TO_DATE(?,'yyyy-mm-dd hh24:mi:ss'),event_color=? where event_id=?";
			conn = datasource.getConnection();
			pstmt = conn.prepareStatement(update_sql);
			pstmt.setString(1, edto.getEvent_title());
			pstmt.setString(2, edto.getEvent_content());
			pstmt.setString(3, edto.getEvent_startdate());
			pstmt.setString(4, edto.getEvent_enddate());
			pstmt.setString(5, edto.getEvent_color());
			pstmt.setInt(6, edto.getEvent_id());
			
			resultrow = pstmt.executeUpdate();
		} catch (Exception ex) {
			System.out.println("event 수정 에러 : " + ex);
		} finally {
			pstmt.close();
			conn.close();
		}
		return resultrow;
	}
	
	
	

}
