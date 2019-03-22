package kr.or.kosta.action;

//로직에 대한 제어와 화면에 대한 전달을 제어하는 클래스
public class ActionForward {
	private boolean isRedirect = false; //redirect 하는지 안하는지
	private String path = null; //이동경로가 어딘지
	
	
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
}
