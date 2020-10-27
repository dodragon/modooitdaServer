package com.baobab.m.vo;

public class PageSearchVO {
    private String location;
    private String searchWord;
    private String div;
    private double longitude;
    private double latitude;
	private int topPageInt;
	private int botPageInt;
	public PageSearchVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PageSearchVO(String location, String searchWord, String div, double longitude, double latitude,
			int topPageInt, int botPageInt) {
		super();
		this.location = location;
		this.searchWord = searchWord;
		this.div = div;
		this.longitude = longitude;
		this.latitude = latitude;
		this.topPageInt = topPageInt;
		this.botPageInt = botPageInt;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getSearchWord() {
		return searchWord;
	}
	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}
	public String getDiv() {
		return div;
	}
	public void setDiv(String div) {
		this.div = div;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public int getTopPageInt() {
		return topPageInt;
	}
	public void setTopPageInt(int topPageInt) {
		this.topPageInt = topPageInt;
	}
	public int getBotPageInt() {
		return botPageInt;
	}
	public void setBotPageInt(int botPageInt) {
		this.botPageInt = botPageInt;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + botPageInt;
		result = prime * result + ((div == null) ? 0 : div.hashCode());
		long temp;
		temp = Double.doubleToLongBits(latitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		temp = Double.doubleToLongBits(longitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((searchWord == null) ? 0 : searchWord.hashCode());
		result = prime * result + topPageInt;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PageSearchVO other = (PageSearchVO) obj;
		if (botPageInt != other.botPageInt)
			return false;
		if (div == null) {
			if (other.div != null)
				return false;
		} else if (!div.equals(other.div))
			return false;
		if (Double.doubleToLongBits(latitude) != Double.doubleToLongBits(other.latitude))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (Double.doubleToLongBits(longitude) != Double.doubleToLongBits(other.longitude))
			return false;
		if (searchWord == null) {
			if (other.searchWord != null)
				return false;
		} else if (!searchWord.equals(other.searchWord))
			return false;
		if (topPageInt != other.topPageInt)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PageSearchVO [location=" + location + ", searchWord=" + searchWord + ", div=" + div + ", longitude="
				+ longitude + ", latitude=" + latitude + ", topPageInt=" + topPageInt + ", botPageInt=" + botPageInt
				+ "]";
	}
}
