package com.example.taobao.adapter;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;

import com.example.taobao.Fragment1;
import com.example.taobao.MainActivity;
import com.example.taobao.R;
import com.example.taobao.SearchActivity;
import com.example.taobao.bean.HomeBean;

public class MyBaseAdapter extends BaseAdapter {

	public static ViewPager viewPager;
	private List<HomeBean> homeBeans;
	private Context context;

	public MyBaseAdapter(List<HomeBean> homeBeans) {
		this.homeBeans = homeBeans;
	}

	public MyBaseAdapter(List<HomeBean> homeBeans, Context context) {
		this.homeBeans = homeBeans;
		this.context = context;
	}

	public MyBaseAdapter(Context context) {
		this.context = context;
	}

	public MyBaseAdapter() {
	}

	@Override
	public int getCount() {
		return homeBeans.size();
	}

	@Override
	public Object getItem(int position) {
		return homeBeans.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = null;
		// which=1代表主页上的ListView ,which=2代表宝贝详情上的ListView ,
		// which=3代表搜索页面的ListView
		int which = homeBeans.get(position).getWhich();
		if (which == 1) {
			switch (homeBeans.get(position).getType()) {
			case 1:
				System.out.println("HAERE ------>  ");
				view = LayoutInflater.from(context).inflate(
						R.layout.item_content, null);
				viewPager = (ViewPager) view.findViewById(R.id.viewPager);
				MyPagerAdapter adapter = new MyPagerAdapter(
						Fragment1.imageViews_viewPager);
				viewPager.setAdapter(adapter);
				new com.example.taobao.fragment.MainActivity().autoPlay(viewPager ,Fragment1.imageViews_viewPager);
				for (int i = 0; i < 4; i++) {
					((LinearLayout) view.findViewById(R.id.ll1_content))
							.getChildAt(i).setOnClickListener(
									new OnClickListener() {

										@Override
										public void onClick(View v) {
											Intent intent = new Intent(context,SearchActivity.class);
											intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
											context.startActivity(intent);
										}
									});
					((LinearLayout) view.findViewById(R.id.ll2_content))
							.getChildAt(i).setOnClickListener(
									new OnClickListener() {

										@Override
										public void onClick(View v) {
											Intent intent = new Intent(context,SearchActivity.class);
											intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
											context.startActivity(intent);
										}
									});
				}

				break;
			case 2:
				view = LayoutInflater.from(context).inflate(
						R.layout.item_recommend, null);
				break;
			case 3:
				view = LayoutInflater.from(context).inflate(
						R.layout.item_special, null);
				break;
			case 4:
				view = LayoutInflater.from(context).inflate(R.layout.item_hot,
						null);
				break;
			default:
				break;
			}
			return view;
		} else if (which == 2) {
			return view = LayoutInflater.from(context).inflate(
					R.layout.item_commoditydetail, null);
		} else if (which == 3) {
			return view = LayoutInflater.from(context).inflate(
					R.layout.item_search, null);
		}
		return view;
	}

}
