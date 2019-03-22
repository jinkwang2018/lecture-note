package kr.or.css.dto;

public class Theme_DTO {
	private int themenum;
	private String themename;
	private String themeicon;
		
	public Theme_DTO() {
		super();
	}
	
	public Theme_DTO(int themenum, String themename, String themeicon) {
		super();
		this.themenum = themenum;
		this.themename = themename;
		this.themeicon = themeicon;
	}
	
	public int getThemenum() {
		return themenum;
	}
	
	public void setThemenum(int themenum) {
		this.themenum = themenum;
	}
	
	public String getThemename() {
		return themename;
	}
	
	public void setThemename(String themename) {
		this.themename = themename;
	}

	public String getThemeicon() {
		return themeicon;
	}

	public void setThemeicon(String themeicon) {
		this.themeicon = themeicon;
	}
	
	
	
}
