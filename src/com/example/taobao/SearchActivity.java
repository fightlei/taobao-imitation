package com.example.taobao;

import java.util.ArrayList;
import java.util.List;

import com.example.taobao.adapter.MyBaseAdapter;
import com.example.taobao.bean.HomeBean;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ListView;

public class SearchActivity extends Activity{

	ImageButton button ;
	ListView listView_serach ;
	List< HomeBean> beans ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);
		initView();
		initData();
	}
	private void initData() {
		beans = new ArrayList<HomeBean>();
		for(int i = 0 ; i < 10 ; i ++){
			HomeBean bean = new HomeBean();
			bean.setWhich(3);
			beans.add(bean);
		}
		MyBaseAdapter adapter = new MyBaseAdapter(beans, getApplicationContext());
		listView_serach.setAdapter(adapter);
	}
	private void initView() {
		button = (ImageButton) findViewById(R.id.actionbar_back_search);
		listView_serach = (ListView) findViewById(R.id.listView_search);
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}
}
