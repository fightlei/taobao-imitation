package com.example.taobao;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.qr_codescan.MipcaActivityCapture;
import com.example.taobao.adapter.MyBaseAdapter;
import com.example.taobao.bean.HomeBean;

@SuppressLint("NewApi")
public class Fragment1 extends Fragment {
	
	ImageButton scanf ;
	Context context;
	
	public Context getContext() {
		return context;
	}
	public void setContext(Context context) {
		this.context = context;
	}

	ListView listView_home ;
	TextView textView ;
	View view ;
	//Handler handler_search ;
	public static List<ImageView> imageViews_viewPager ;
	int images_viewPager [] = {R.drawable.menu_viewpager_2,R.drawable.menu_viewpager_3,R.drawable.menu_viewpager_1
			,R.drawable.menu_viewpager_4,R.drawable.menu_viewpager_5};
	
	  @Override
	  public View onCreateView(LayoutInflater inflater, ViewGroup container,
	  		Bundle savedInstanceState) {
	  	view=inflater.inflate(R.layout.activity_main, null);
	  	initView();
		initData();
		MyBaseAdapter adapter2 = new MyBaseAdapter(HomeBean.getStandHomeBeans(),context);
		listView_home.setAdapter(adapter2);
	  	return view;
	  }
	private void initData() {
		for (int i = 0; i < images_viewPager.length; i++) {
			ImageView imageView = new ImageView(context);
			imageView.setImageResource(images_viewPager[i]);
			imageView.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					//bug
					Intent intent = new Intent(context,CommodityDetailActivity.class);
					startActivity(intent);
				}
			});
			imageViews_viewPager.add(imageView);
		}
	}

	private void initView() {
		scanf = (ImageButton) view.findViewById(R.id.scanf);
		imageViews_viewPager = new ArrayList<ImageView>();
		listView_home = (ListView) ( view.findViewById(R.id.listView_home));
		textView = (TextView) view.findViewById(R.id.textview_search) ;
		textView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(context,SearchActivity.class);
				startActivity(intent);
			}
		});
		scanf.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(context, MipcaActivityCapture.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(intent);
			}
		});
	}
	
}
