package com.example.taobao;


import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;

@SuppressLint("NewApi")
public class Fragment5 extends Fragment {
	Context context;
	TextView textView;
	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view=inflater.inflate(R.layout.activity_main5, null);
		
		view.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT));
		//view.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
//		textView=(TextView)view.findViewById(R.id.thinking);
//		textView.setOnClickListener(new OnClickListener() {
//			
//			@SuppressLint("NewApi")
//			@Override
//			public void onClick(View arg0) {
//				Intent intent=new Intent(context,Fragment5_SecondActivity.class);
//				intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//				context.startActivity(intent);
//				
//			}
//		});
		return view;
	}
}
