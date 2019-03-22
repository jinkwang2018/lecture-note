package kr.or.bmark.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bmark.action.Action;
import kr.or.bmark.action.ActionForward;
import kr.or.bmark.dao.mainBoardDao;
import kr.or.bmark.dto.evalData;

public class DislikeOkService implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward;
		
		try {
			String data = "";
			int mnbid = Integer.parseInt(request.getParameter("sname"));
			int bad = Integer.parseInt(request.getParameter("bad"));
			String userid = (String)request.getSession().getAttribute("userid");
			
			if(userid != null) {
				mainBoardDao dao = new mainBoardDao();
				evalData edata = dao.isRecommend(mnbid, userid);
				//System.out.println(mnbid + "/" + bad);
				// edata가 null이라면, 아직 평가를 하지않은 사람!!
				if(edata == null) {
					if(dao.setDislike(mnbid)) {
						edata = new evalData(mnbid, userid, "F");
						dao.setUserEval(edata);
						data = "평가 감사드립니다><!!_" + (bad + 1);
					}else {
						data = "비정상적인 접근입니다. 잠시후 다시 시도해주세요!!_" + bad;
					}
				// 이미 평가를 한 사람!!
				}else {
					data = "\'" + userid + "\'님께서는 해당 사이트에 대하여 ";
					if(edata.getEval().equals("T")) {
						data += "이미 \'추천\' 하셨습니다.\n";
						data += "평가일: " + edata.getEvalday() + "_" + bad;
					}else {
						data += "\'비추천\'을 \'취소\' 하셨습니다.\n";
						data += "평가일: " + edata.getEvalday() + "_" + (bad-1);
						dao.setunDisLike(mnbid);		// 메인북마크 비추천 -1
						dao.deleteUserEval(edata);	// 해당 사용자의 평가 유무 데이터베이스에서 삭제
					}
				}
			}else {
				data = "로그인이 필요한 서비스입니다._"  + bad;
			}
			
			//System.out.println(data);
			request.setAttribute("data", data);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/views/main/site_dislike.jsp");
		return forward;
	}
	
}
