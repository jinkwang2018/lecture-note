package kr.or.bmark.service;

import kr.or.bmark.dao.categoryDao;
import kr.or.bmark.dto.category;


public class AdminPopService {
	    //카테고리 추가
		public int writeOK(category category) throws Exception  {
			categoryDao dao = new categoryDao();
			int result = dao.writeok(category);
			return result;
		}
		
		//카테고리삭제
		public int deleteOK(category category) throws Exception  {
			categoryDao dao = new categoryDao();
			int result = dao.deleteok(category);
			return result;
		}
}
