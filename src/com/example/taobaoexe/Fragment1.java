package com.example.taobaoexe;

import java.util.ArrayList;
import java.util.List;

import com.example.taobao.R;

import android.annotation.SuppressLint;


import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
@SuppressLint("NewApi")
public class Fragment1 extends Fragment{
	
	static Handler handler ;
	public static Handler getHnadler(){
		return handler;
	}
	TextView nameT,typeNameT,colorT,typeT,priceT,countT;
	ImageView imageView;
	ListView listView;
	View v;
	static List<Goods> list = new ArrayList<Goods>();
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub	
		 v = inflater.inflate(R.layout.list, null);
	//	initView();
		 listView = (ListView) v.findViewById(R.id.listView1);
		initData();
		final MyAdapter adapter = new MyAdapter(inflater);
		listView.setAdapter(adapter);
		handler = new Handler(){
			@Override
			public void handleMessage(Message msg) {
				list.add((Goods)msg.obj);
				adapter.notifyDataSetChanged();
			}
		};
		return v;
	}
	private void initData() {
		// TODO Auto-generated method stub
		Goods good1 = new Goods("死基佬的服装店","时尚男装", "风衣", "20", "2", "红色", R.drawable.find_4);
		list.add(good1);
		if(list.size()>1){
			list.remove(list.size()-1);
		}
		
	}

	
	class MyAdapter extends BaseAdapter{

		LayoutInflater inflater;
		public MyAdapter(LayoutInflater inflater)
		{
			this.inflater = inflater;
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
		public View getView(int position, View view, ViewGroup arg2) {
			// TODO Auto-generated method stub
			
			View v1 = inflater.inflate(R.layout.item1, null);
			nameT = (TextView) v1.findViewById(R.id.name);
			typeNameT = (TextView) v1.findViewById(R.id.typeName);
			colorT = (TextView) v1.findViewById(R.id.color);
			typeT = (TextView) v1.findViewById(R.id.type);
			priceT = (TextView) v1.findViewById(R.id.price);
			countT = (TextView) v1.findViewById(R.id.count);
			imageView = (ImageView) v1.findViewById(R.id.imageView1);
			
			nameT.setText(list.get(position).getName());
			typeNameT.setText(list.get(position).getTypeName());
			colorT.setText(list.get(position).getColor());
			typeT.setText(list.get(position).getType());
			priceT.setText(list.get(position).getPrice()+"￥");
			countT.setText("*"+list.get(position).getCount());
			imageView.setImageResource(list.get(position).getImage());
			
			
			
			
			return v1;
		}
		
	}

}
