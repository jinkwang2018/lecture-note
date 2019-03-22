package kr.or.css.dao;

import java.sql.Date;
import java.util.ArrayList;

import kr.or.css.dto.TimeSheet_DTO;

public class TimeSheet_DAO {
	public ArrayList<TimeSheet_DTO> selectAllTimeSheet(String userid, Date date){
		return null;
	}
	public TimeSheet_DTO selectTimeSheet(Date date, String userid, int hour) {
		return null;
	}
	public int deleteTimeSheet(Date date, String userid, int hour) {
		return 0;
	}
	public int insertTimeSheet(Date date, String userid, int hour) {
		return 0;
	}
	public int updateTimeSheet(Date date, String userid, int hour) {
		return 0;
	}
}
