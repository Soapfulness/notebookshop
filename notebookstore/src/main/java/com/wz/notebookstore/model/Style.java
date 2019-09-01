package com.wz.notebookstore.model;

import java.io.Serializable;

public class Style implements Serializable {
	
	private Integer styleId;

    private String styleName;

    private String styleColor;

    private String styleMaterial;

    private String styleImage;

    private Double stylePrice;

    public Style() {
		super();
	}

	public Style(Integer styleId, String styleName, String styleColor, String styleMaterial, String styleImage,
			Double stylePrice) {
		super();
		this.styleId = styleId;
		this.styleName = styleName;
		this.styleColor = styleColor;
		this.styleMaterial = styleMaterial;
		this.styleImage = styleImage;
		this.stylePrice = stylePrice;
	}

	public Integer getStyleId() {
		return styleId;
	}

	public void setStyleId(Integer styleId) {
		this.styleId = styleId;
	}

	public String getStyleName() {
		return styleName;
	}

	public void setStyleName(String styleName) {
		this.styleName = styleName;
	}

	public String getStyleColor() {
		return styleColor;
	}

	public void setStyleColor(String styleColor) {
		this.styleColor = styleColor;
	}

	public String getStyleMaterial() {
		return styleMaterial;
	}

	public void setStyleMaterial(String styleMaterial) {
		this.styleMaterial = styleMaterial;
	}

	public String getStyleImage() {
		return styleImage;
	}

	public void setStyleImage(String styleImage) {
		this.styleImage = styleImage;
	}

	public Double getStylePrice() {
		return stylePrice;
	}

	public void setStylePrice(Double stylePrice) {
		this.stylePrice = stylePrice;
	}

	@Override
	public String toString() {
		return "Style [styleId=" + styleId + ", styleName=" + styleName + ", styleColor=" + styleColor
				+ ", styleMaterial=" + styleMaterial + ", styleImage=" + styleImage + ", stylePrice=" + stylePrice
				+ "]";
	}
	
	
}
