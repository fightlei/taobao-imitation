package com.example.discover;

import android.view.View.OnClickListener;

public class Bean {

	int type;// 1£¬2£¬3
	int resID;
	String firstTitle;
	String secondTitle;
	int[] expandResID = new int[4];
	OnClickListener viewClick = null;

	public OnClickListener getViewClick() {
		return viewClick;
	}

	public void setViewClick(OnClickListener viewClick) {
		this.viewClick = viewClick;
	}

	public OnClickListener[] getButClick() {
		return butClick;
	}

	public void setButClick(OnClickListener[] butClick) {
		this.butClick = butClick;
	}

	OnClickListener[] butClick = new OnClickListener[4];

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getResID() {
		return resID;
	}

	public void setResID(int resID) {
		this.resID = resID;
	}

	public String getFirstTitle() {
		return firstTitle;
	}

	public void setFirstTitle(String firstTitle) {
		this.firstTitle = firstTitle;
	}

	public String getSecondTitle() {
		return secondTitle;
	}

	public void setSecondTitle(String secondTitle) {
		this.secondTitle = secondTitle;
	}

	public int[] getExpandResID() {
		return expandResID;
	}

	public void setExpandResID(int[] expandResID) {
		this.expandResID = expandResID;
	}

}
