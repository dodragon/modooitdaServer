package com.baobab.m.vo;

import java.util.List;

public class ShowPokeVO {
	private CPInfoVO cpInfoVO;
	private List<CPmainImgVO> imgVoList;
	private PokeVO pokeVO;
	
	public ShowPokeVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ShowPokeVO(CPInfoVO cpInfoVO, List<CPmainImgVO> imgVoList, PokeVO pokeVO) {
		super();
		this.cpInfoVO = cpInfoVO;
		this.imgVoList = imgVoList;
		this.pokeVO = pokeVO;
	}

	public CPInfoVO getCpInfoVO() {
		return cpInfoVO;
	}

	public void setCpInfoVO(CPInfoVO cpInfoVO) {
		this.cpInfoVO = cpInfoVO;
	}

	public List<CPmainImgVO> getImgVoList() {
		return imgVoList;
	}

	public void setImgVoList(List<CPmainImgVO> imgVoList) {
		this.imgVoList = imgVoList;
	}

	public PokeVO getPokeVO() {
		return pokeVO;
	}

	public void setPokeVO(PokeVO pokeVO) {
		this.pokeVO = pokeVO;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpInfoVO == null) ? 0 : cpInfoVO.hashCode());
		result = prime * result + ((imgVoList == null) ? 0 : imgVoList.hashCode());
		result = prime * result + ((pokeVO == null) ? 0 : pokeVO.hashCode());
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
		ShowPokeVO other = (ShowPokeVO) obj;
		if (cpInfoVO == null) {
			if (other.cpInfoVO != null)
				return false;
		} else if (!cpInfoVO.equals(other.cpInfoVO))
			return false;
		if (imgVoList == null) {
			if (other.imgVoList != null)
				return false;
		} else if (!imgVoList.equals(other.imgVoList))
			return false;
		if (pokeVO == null) {
			if (other.pokeVO != null)
				return false;
		} else if (!pokeVO.equals(other.pokeVO))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ShowPokeVO [cpInfoVO=" + cpInfoVO + ", imgVoList=" + imgVoList + ", pokeVO=" + pokeVO + "]";
	}
}
