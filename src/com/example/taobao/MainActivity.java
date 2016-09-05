package com.example.taobao;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.taobao.adapter.MyBaseAdapter;
import com.example.taobao.bean.HomeBean;

public class MainActivity extends Activity {
	
	ListView listView_home ;
	TextView textView ;
	//Handler handler_search ;
	public static List<ImageView> imageViews_viewPager ;
	int images_viewPager [] = {R.drawable.menu_viewpager_2,R.drawable.menu_viewpager_3,R.drawable.menu_viewpager_1
			,R.drawable.menu_viewpager_4,R.drawable.menu_viewpager_5};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
		initData();
		MyBaseAdapter adapter2 = new MyBaseAdapter(HomeBean.getStandHomeBeans(),getApplicationContext());
		listView_home.setAdapter(adapter2);
		//autoPlay();

	}

	

	private void initData() {
		for (int i = 0; i < images_viewPager.length; i++) {
			ImageView imageView = new ImageView(getApplicationContext());
			imageView.setImageResource(images_viewPager[i]);
			imageView.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent intent = new Intent(MainActivity.this,CommodityDetailActivity.class);
					startActivity(intent);
				}
			});
			imageViews_viewPager.add(imageView);
		}
//		handler = new Handler(){
//			@Override
//			public void handleMessage(Message msg) {
//				Intent intent = new Intent(MainActivity.this,SearchActivity.class);
//			}
//		};
	}

	private void initView() {
		imageViews_viewPager = new ArrayList<ImageView>();
		listView_home = (ListView) findViewById(R.id.listView_home);
		textView = (TextView) findViewById(R.id.textview_search) ;
		textView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this,SearchActivity.class);
				startActivity(intent);
			}
		});
	}
	
	public void autoPlay(final ViewPager viewPager) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							viewPager.setCurrentItem((viewPager.getCurrentItem() + 1)%imageViews_viewPager.size());
						}
					});
				}
			}
		}).start();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	


}
