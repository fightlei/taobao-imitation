package com.example.taobao.adapter;

import java.util.List;

import javax.crypto.spec.PSource;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MyPagerAdapter extends PagerAdapter{

	private List<ImageView> imageViews_viewPager ;
	
	public MyPagerAdapter(List<ImageView> imageViews_viewPager){
		this.imageViews_viewPager = imageViews_viewPager ;
	}
	public MyPagerAdapter(){
	}
	@Override
	public int getCount() {
		return imageViews_viewPager.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == arg1;
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		//position %= imageViews_viewPager.size();
		//System.out.println(imageViews_viewPager.size());
		//System.out.println("³õÊ¼»¯"+position);
		ViewGroup group = (ViewGroup) imageViews_viewPager.get(position).getParent();
		if(group!=null){
			group.removeAllViews();
		}
		container.addView(imageViews_viewPager.get(position));
		return imageViews_viewPager.get(position);
	}
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		//position %= imageViews_viewPager.size();
		//System.out.println("Ïú»Ù"+position);
		container.removeView((View) object);
	}
}
