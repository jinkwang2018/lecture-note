package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.BoardDao;
import kr.or.bit.dto.BoardDto;

public class BoardWriteService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		BoardDao dao = new BoardDao();
		BoardDto boarddata = new BoardDto();
		MultipartRequest multi = null;
		int sizeLimit = 10 * 1024 * 1024 ; // 10메가입니다.

		String savePath = request.getRealPath("/upload");
		System.out.println("savePath : " + savePath);
		multi = new MultipartRequest(request, savePath, sizeLimit, "UTF-8", new DefaultFileRenamePolicy()); // 업로드하는 코드 한줄
		System.out.println(request.getContentType());
		boarddata.setBoard_filename(multi.getFilesystemName("board_filename"));
		boarddata.setBoard_title(multi.getParameter("board_title"));
		boarddata.setId(multi.getParameter("id"));
		boarddata.setBoard_content(multi.getParameter("board_content"));

		int result = dao.writeok(boarddata);
		if(result>0) {
			System.out.println("글 입력 성공");
			request.setAttribute("result", "success");
		}
		else {
			System.out.println("글 입력 실패");
			request.setAttribute("result", "fail");
		}

		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/board/BoardWriteok.jsp");
  
		return forward;
	}

}
