package com.wz.notebookstore.model;

import java.io.Serializable;
import java.util.Date;

public class Pack implements Serializable {
	private Integer packId;//购物车id

    private Integer packUserId;//购物车用户的id

    private Integer packCoverId;//购物车封面的id

    private Integer packStyleId;//购物车内页的id

    private Date packInitDate; //时间

    public Pack() {
		super();
	}

	public Pack(Integer packId, Integer packUserId, Integer packCoverId, Integer packStyleId, Date packInitDate) {
		super();
		this.packId = packId;
		this.packUserId = packUserId;
		this.packCoverId = packCoverId;
		this.packStyleId = packStyleId;
		this.packInitDate = packInitDate;
	}

	public Integer getPackId() {
		return packId;
	}

	public void setPackId(Integer packId) {
		this.packId = packId;
	}

	public Integer getPackUserId() {
		return packUserId;
	}

	public void setPackUserId(Integer packUserId) {
		this.packUserId = packUserId;
	}

	public Integer getPackCoverId() {
		return packCoverId;
	}

	public void setPackCoverId(Integer packCoverId) {
		this.packCoverId = packCoverId;
	}

	public Integer getPackStyleId() {
		return packStyleId;
	}

	public void setPackStyleId(Integer packStyleId) {
		this.packStyleId = packStyleId;
	}

	public Date getPackInitDate() {
		return packInitDate;
	}

	public void setPackInitDate(Date packInitDate) {
		this.packInitDate = packInitDate;
	}

	@Override
	public String toString() {
		return "Pack [packId=" + packId + ", packUserId=" + packUserId + ", packCoverId=" + packCoverId
				+ ", packStyleId=" + packStyleId + ", packInitDate=" + packInitDate + "]";
	}
	
	
}
