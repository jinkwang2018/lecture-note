package bit.co.kr.naver;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.scribejava.core.model.OAuth2AccessToken;

import bit.co.kr.UserVO;
import bit.co.kr.service;

public class userController {
	private naverLoginBO naverLoginBO;
	private String apiResult = null;
	/* NaverLoginBO */
	@Inject
	private void setNaverLoginBO(naverLoginBO naverLoginBO) {
		this.naverLoginBO = naverLoginBO;
	}

	@RequestMapping(value="/naverLogin", method = RequestMethod.GET)
	public ModelAndView login(HttpSession session) {
		/* 네아로 인증 URL을 생성하기 위하여 getAuthorizationUrl을 호출 */
		String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);
		System.out.println("controller 호출");
		return new ModelAndView("user/naverLogin", "url", naverAuthUrl);
	}

	@RequestMapping(value="/callback",method = RequestMethod.GET)
	public ModelAndView callback(@RequestParam String code, @RequestParam String state, HttpSession session) throws IOException {
		/* 네아로 인증이 성공적으로 완료되면 code 파라미터가 전달되며 이를 통해 access token을 발급 */

		OAuth2AccessToken oauthToken = naverLoginBO.getAccessToken(session, code, state);
		apiResult = naverLoginBO.getUserProfile(oauthToken);
//System.out.println(apiResult);

		JSONObject jsonobj = jsonparse.stringToJson(apiResult, "response");
		String sex = jsonparse.JsonToString(jsonobj, "gender");
		String snsId = jsonparse.JsonToString(jsonobj, "id");
		String name = jsonparse.JsonToString(jsonobj, "name");

		UserVO vo = new UserVO();
		vo.setUser_snsId(snsId);
		vo.setUser_name(name);

		System.out.println(name);
		try {
			vo = service.naverLogin(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		session.setAttribute("login",vo);
		return new ModelAndView("user/loginPost", "result", vo);
	}
}
