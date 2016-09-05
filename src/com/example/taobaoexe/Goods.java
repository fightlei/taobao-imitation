package com.example.taobaoexe;

public class Goods {
	
	String name;
	String typeName;
	String type;
	String price;
	String count;
	String color;
	Integer Image;
	

	public Goods(String name, String typeName, String type, String price,
			String count, String color,Integer image) {
		this.name = name;
		this.typeName = typeName;
		this.type = type;
		this.price = price;
		this.count = count;
		this.color = color;
		this.Image = image;
	}
	public Integer getImage() {
		return Image;
	}
	public void setImage(int image) {
		Image = image;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}

}
