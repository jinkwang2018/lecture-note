package kr.or.kosta.Action;

//��û�� ���� ó���� ����ϴ� Ŭ����
//ó���� ���
//forward, sendredirect
public class ActionForward {
	private boolean isRedirect =false;
	private String path = null;
	
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
	