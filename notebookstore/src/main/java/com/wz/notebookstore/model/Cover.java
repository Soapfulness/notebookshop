package com.wz.notebookstore.model;

import java.io.Serializable;

public class Cover implements Serializable {
	
	private Integer coverId;

    private String coverName;

    private String coverColor;

    private String coverSize;

    private String coverImage;

    private Double coverPrice;

    public Cover() {
		super();
	}

	public Cover(Integer coverId, String coverName, String coverColor, String coverSize, String coverImage,
			Double coverPrice) {
		super();
		this.coverId = coverId;
		this.coverName = coverName;
		this.coverColor = coverColor;
		this.coverSize = coverSize;
		this.coverImage = coverImage;
		this.coverPrice = coverPrice;
	}

	public Integer getCoverId() {
		return coverId;
	}

	public void setCoverId(Integer coverId) {
		this.coverId = coverId;
	}

	public String getCoverName() {
		return coverName;
	}

	public void setCoverName(String coverName) {
		this.coverName = coverName;
	}

	public String getCoverColor() {
		return coverColor;
	}

	public void setCoverColor(String coverColor) {
		this.coverColor = coverColor;
	}

	public String getCoverSize() {
		return coverSize;
	}

	public void setCoverSize(String coverSize) {
		this.coverSize = coverSize;
	}

	public String getCoverImage() {
		return coverImage;
	}

	public void setCoverImage(String coverImage) {
		this.coverImage = coverImage;
	}

	public Double getCoverPrice() {
		return coverPrice;
	}

	public void setCoverPrice(Double coverPrice) {
		this.coverPrice = coverPrice;
	}

	@Override
	public String toString() {
		return "Cover [coverId=" + coverId + ", coverName=" + coverName + ", coverColor=" + coverColor + ", coverSize="
				+ coverSize + ", coverImage=" + coverImage + ", coverPrice=" + coverPrice + "]";
	}
	

}
