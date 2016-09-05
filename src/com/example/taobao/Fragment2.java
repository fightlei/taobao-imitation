package com.example.taobao;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;


@SuppressLint("NewApi")
public class Fragment2 extends Fragment {
	Context context ;
	
    ListView listView;
    List<Map<String,Object>> mlist=new ArrayList<Map<String,Object>>();
    private int imgs[]={R.drawable.tao_1,R.drawable.tao_3,R.drawable.detail_show_1,R.drawable.detail_show_2,
    		R.drawable.detail_show_3,R.drawable.detail_show_4,R.drawable.detail_show_5,R.drawable.detail_show_6};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
    		Bundle savedInstanceState) {
    	View view=inflater.inflate(R.layout.activity_main2, null);
		listView=(ListView) view.findViewById(R.id.listView1);
		for(int i=0;i<imgs.length;i++){
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("imgs", imgs[i]);
		mlist.add(map);
		}
		MyAdapter adapter=new MyAdapter();
		listView.setAdapter(adapter);
    	return view;
    }
    

	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}

	class MyAdapter extends BaseAdapter{

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return mlist.size();
		}

		@Override
		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return mlist.get(arg0);
		}

		@Override
		public long getItemId(int arg0) {
			// TODO Auto-generated method stub
			return arg0;
		}

		@Override
		public View getView(int arg0, View arg1, ViewGroup arg2) {
			// TODO Auto-generated method stub
			View view;
			LayoutInflater inflater=LayoutInflater.from(context);
			if(arg0==0){
				view=inflater.inflate(R.layout.list2_1, null);
				ImageView imageView=(ImageView) view.findViewById(R.id.imageView1);
				imageView.setImageResource(imgs[0]);
			}else{
			    view=inflater.inflate(R.layout.list2_2, null);
				ImageView imageView=(ImageView) view.findViewById(R.id.imageView2);
				imageView.setImageResource(imgs[arg0]);
			}
			return view;
		}
	}
}
