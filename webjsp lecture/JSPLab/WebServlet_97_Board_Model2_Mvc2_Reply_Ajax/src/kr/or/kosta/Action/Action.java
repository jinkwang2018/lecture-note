package kr.or.kosta.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * M : DTO, DAO, SERVICE
 * V : 
 * C : controller : ����ó���� ���ҷ��� (��û �帧)
 * 	=> ���� ó���ڵ� > �ٸ� ���������� (SERVICE)
 */
public interface Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
