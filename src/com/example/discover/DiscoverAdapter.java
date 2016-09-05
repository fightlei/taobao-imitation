package com.example.discover;

import java.util.List;

import com.example.taobao.R;

import android.R.color;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DiscoverAdapter extends BaseAdapter {

	List<Bean> list;
	Context context;

	public DiscoverAdapter(Context applicationContext, List<Bean> list) {
		this.list = list;
		this.context = applicationContext;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return list.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		Bean bean = list.get(arg0);
		int type = bean.getType();
		if (type == 0) {
			LayoutInflater inflater = LayoutInflater.from(context);
			View view = inflater.inflate(R.layout.discoveritem0, null);
			return view;
		} else if (type == 1) {
			LayoutInflater inflater = LayoutInflater.from(context);
			View view = inflater.inflate(R.layout.discoveritem1, null);
			ImageView imageView = (ImageView) view
					.findViewById(R.id.imageView1);
			TextView textView1 = (TextView) view.findViewById(R.id.textView1);
			TextView textView2 = (TextView) view.findViewById(R.id.textView2);
			imageView.setImageResource(bean.getResID());
			textView1.setText(bean.getFirstTitle());
			textView2.setText(bean.getSecondTitle());
			view.setOnClickListener(bean.getViewClick());
			return view;
		} else if (type == 2) {
			LayoutInflater inflater = LayoutInflater.from(context);
			View view = inflater.inflate(R.layout.discoveritem2, null);
			ImageView imageView = (ImageView) view
					.findViewById(R.id.imageView1);
			TextView textView1 = (TextView) view.findViewById(R.id.textView1);
			TextView textView2 = (TextView) view.findViewById(R.id.textView2);
			LinearLayout expandLinearLayout = (LinearLayout) view
					.findViewById(R.id.expandLinearLayout);
			expandLinearLayout.setVisibility(View.GONE);
			imageView.setImageResource(bean.getResID());
			textView1.setText(bean.getFirstTitle());
			textView2.setText(bean.getSecondTitle());
			view.setOnClickListener(bean.getViewClick());
			return view;
		} else if (type == 3) {
			LayoutInflater inflater = LayoutInflater.from(context);
			View view = inflater.inflate(R.layout.discoveritem2, null);
			ImageView imageView = (ImageView) view
					.findViewById(R.id.imageView1);
			TextView textView1 = (TextView) view.findViewById(R.id.textView1);
			TextView textView2 = (TextView) view.findViewById(R.id.textView2);
			imageView.setImageResource(bean.getResID());
			textView1.setText(bean.getFirstTitle());
			textView2.setText(bean.getSecondTitle());
			ImageButton[] imageButton = new ImageButton[4];
			imageButton[0] = (ImageButton) view.findViewById(R.id.imageButton1);
			imageButton[1] = (ImageButton) view.findViewById(R.id.imageButton2);
			imageButton[2] = (ImageButton) view.findViewById(R.id.imageButton3);
			imageButton[3] = (ImageButton) view.findViewById(R.id.imageButton4);
			int[] expandResID = bean.getExpandResID();
			OnClickListener[] butClick = bean.getButClick();
			for (int i = 0; i < imageButton.length; i++) {
				imageButton[i].setImageResource(expandResID[i]);
				imageButton[i].setOnClickListener(butClick[i]);
			}
			view.setOnClickListener(bean.viewClick);
			return view;
		} else
			return null;

	}

	class ViewHolder {
		ImageView imageView;
		TextView textView1;
		TextView textView2;
		ImageButton[] imageButton;
		LinearLayout expandLinearLayout;
	}
}
