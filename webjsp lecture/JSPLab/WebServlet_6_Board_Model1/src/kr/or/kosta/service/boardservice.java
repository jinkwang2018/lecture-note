package kr.or.kosta.service;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;

import kr.or.kosta.dao.boarddao;
import kr.or.kosta.dto.board;
import kr.or.kosta.dto.reply;

public class boardservice {
	private static boardservice instance = new boardservice();	
	private boardservice(){};
	public static boardservice getInstance() {
		return instance;
	}
	//서비스 요청(글목록보기)
	public List<board> list(int cpage , int pagesize) throws Exception{
		boarddao dao = new boarddao();
		return dao.list(cpage, pagesize);
	}
	
	//서비스(글목록 총 건수 구하기)
	public int totalboardcount() throws Exception {
		boarddao dao = new boarddao();
		return dao.totalboardCount();
	}
	
	
	//서비스 요청 (글쓰기)
	public int writeOK(board boardata) throws Exception  {
		boarddao dao = new boarddao();
		int result = dao.writeok(boardata);
		return result;
	}
	
	//서비스 (글 상세 보기)
	public board content(int idx) throws Exception {
		return new boarddao().getContent(idx);
	}
	
	//서비스(글 상세 조회시 조회수 증가)
	public boolean addReadNum(String idx) throws Exception {
		return new boarddao().getReadNum(idx);
	}
	
	//서비스(게시물 상세조회 > 답글 쓰기(rewriteok)
	public int rewriteok(board boardata) throws Exception {
		boarddao dao = new boarddao();
		return dao.reWriteOk(boardata);
	}
	
	//서비스(덧글 입력하기) reply 테이블
	public int replywrite(int idx_fk, String writer, String userid, String content,String pwd) throws Exception {
		return new boarddao().replywrite(idx_fk, writer, userid, content, pwd);
	}
	
	//서비스 (덧글 목록 리스트) reply 테이블 
	public List<reply> replylist(String idx_fk) throws Exception{
		return new boarddao().replylist(idx_fk);
	}
	
	//서비스(게시글 삭제하기) jspboard , reply
	public int board_delete(String idx , String pwd) throws SQLException, NamingException {
		return new boarddao().deleteok(idx, pwd);
	}
	
	//서비스(댓글 삭제하기)
	public int replydelete(String no , String pwd) throws NamingException {
		return new boarddao().replyDelete(no, pwd);
	}
	
	//게시글 편집 데이터 조회 서비스
	public board board_editlist(String idx) throws SQLException, NamingException{
		return new boarddao().getEditContent(idx);
	}
			
	//게시글 편집 수정하기 서비스
	//기존과 다르게 객체를 parameter 가 아니라
	//request 객체의 주소를 받아서 처리하는 방식으로
	public int board_edit(HttpServletRequest req) throws SQLException, NamingException{
		return new boarddao().boardedit(req);
	}
}








