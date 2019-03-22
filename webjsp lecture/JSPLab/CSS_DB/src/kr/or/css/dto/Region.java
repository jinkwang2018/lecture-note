package kr.or.css.dto;

public class Region {
	private int regionnum;
	private String regionname;
	private String regionicon;
	
	public Region() {
		super();
	}

	public Region(int regionnum, String regionname, String regionicon) {
		super();
		this.regionnum = regionnum;
		this.regionname = regionname;
		this.regionicon = regionicon;
	}
	
	public int getRegionnum() {
		return regionnum;
	}
	
	public void setRegionnum(int regionnum) {
		this.regionnum = regionnum;
	}
	
	public String getRegionname() {
		return regionname;
	}
	
	public void setRegionname(String regionname) {
		this.regionname = regionname;
	}

	public String getRegionicon() {
		return regionicon;
	}

	public void setRegionicon(String regionicon) {
		this.regionicon = regionicon;
	}
	
	
	
}
