package com.example.taobao.bean;

import java.util.ArrayList;
import java.util.List;

public class HomeBean {
	private int which ;
	private int type ;
	private int images_listView [];
	private String title ;
	public int getType() {
		return type;
	}
	public int getWhich() {
		return which;
	}
	public void setWhich(int which) {
		this.which = which;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int[] getImages_listView() {
		return images_listView;
	}
	public void setImages_listView(int[] images_listView) {
		this.images_listView = images_listView;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public HomeBean(int type, int[] images_listView, String title) {
		super();
		this.type = type;
		this.images_listView = images_listView;
		this.title = title;
	}
	public HomeBean() {

	}
	public static List<HomeBean> getStandHomeBeans(){
		List<HomeBean> homeBeans = new ArrayList<HomeBean>();
		for (int i = 1; i < 5; i++) {
			HomeBean homeBean = new HomeBean();
			homeBean.setType(i);
			homeBean.setWhich(1); //代表主页上的listView
			homeBeans.add(homeBean);
		}
		return homeBeans;
	}
}
