package com.baobab.m.vo;

import java.util.List;

public class AnterMainVO {
	private List<MainListTotalVO> mainListVO;
	private List<MainCpListTitleVO> mainTitle;
	private List<AdImagesVO> adImgVOList;
	private int version;
	public AnterMainVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AnterMainVO(List<MainListTotalVO> mainListVO, List<MainCpListTitleVO> mainTitle,
			List<AdImagesVO> adImgVOList, int version) {
		super();
		this.mainListVO = mainListVO;
		this.mainTitle = mainTitle;
		this.adImgVOList = adImgVOList;
		this.version = version;
	}
	public List<MainListTotalVO> getMainListVO() {
		return mainListVO;
	}
	public void setMainListVO(List<MainListTotalVO> mainListVO) {
		this.mainListVO = mainListVO;
	}
	public List<MainCpListTitleVO> getMainTitle() {
		return mainTitle;
	}
	public void setMainTitle(List<MainCpListTitleVO> mainTitle) {
		this.mainTitle = mainTitle;
	}
	public List<AdImagesVO> getAdImgVOList() {
		return adImgVOList;
	}
	public void setAdImgVOList(List<AdImagesVO> adImgVOList) {
		this.adImgVOList = adImgVOList;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adImgVOList == null) ? 0 : adImgVOList.hashCode());
		result = prime * result + ((mainListVO == null) ? 0 : mainListVO.hashCode());
		result = prime * result + ((mainTitle == null) ? 0 : mainTitle.hashCode());
		result = prime * result + version;
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
		AnterMainVO other = (AnterMainVO) obj;
		if (adImgVOList == null) {
			if (other.adImgVOList != null)
				return false;
		} else if (!adImgVOList.equals(other.adImgVOList))
			return false;
		if (mainListVO == null) {
			if (other.mainListVO != null)
				return false;
		} else if (!mainListVO.equals(other.mainListVO))
			return false;
		if (mainTitle == null) {
			if (other.mainTitle != null)
				return false;
		} else if (!mainTitle.equals(other.mainTitle))
			return false;
		if (version != other.version)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "AnterMainVO [mainListVO=" + mainListVO + ", mainTitle=" + mainTitle + ", adImgVOList=" + adImgVOList
				+ ", version=" + version + "]";
	}
}
