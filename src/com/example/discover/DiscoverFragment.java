package com.example.discover;

import java.util.ArrayList;
import java.util.List;

import com.example.taobao.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ListView;

@SuppressLint("NewApi")
public class DiscoverFragment extends Fragment {

	List<Bean> list = new ArrayList<Bean>();
	ListView listView;
	View view;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		view = inflater.inflate(R.layout.discoverfragment, null);
		initDate();
		initView();
		return view;
	}

	private void initDate() {
		// TODO Auto-generated method stub
		list.clear();
		Bean bean = new Bean();
		bean.setType(1);
		bean.setResID(R.drawable.find_1);
		bean.setFirstTitle("ɹ��Ƭ����B��");
		bean.setSecondTitle("���˶��������");
		bean.setViewClick(new clickView());
		list.add(bean);

		bean = new Bean();
		bean.setType(2);
		bean.setResID(R.drawable.find_2);
		bean.setFirstTitle("ɨһɨ�����Ż�");
		bean.setSecondTitle("1�۲����ˣ�");
		bean.setViewClick(new clickView());
		list.add(bean);

		bean = new Bean();
		bean.setType(3);
		bean.setResID(R.drawable.find_3);
		bean.setFirstTitle("����");
		bean.setSecondTitle("����");
		bean.setExpandResID(new int[] { R.drawable.find_g_1,
				R.drawable.find_g_2, R.drawable.find_g_3, R.drawable.find_g_4 });
		bean.setViewClick(new clickView());
		bean.setButClick(new OnClickListener[] { new clickButton(),
				new clickButton(), new clickButton(), new clickButton() });
		list.add(bean);

		bean = new Bean();
		bean.setType(2);
		bean.setResID(R.drawable.find_4);
		bean.setFirstTitle("��Ϸ����");
		bean.setSecondTitle("��ŭС���׷�");
		bean.setViewClick(new clickView());
		list.add(bean);

		bean = new Bean();
		bean.setType(3);
		bean.setResID(R.drawable.find_3);
		bean.setFirstTitle("Ӧ������");
		bean.setSecondTitle("");
		bean.setExpandResID(new int[] { R.drawable.find_g_5,
				R.drawable.find_g_6, R.drawable.find_g_7, R.drawable.find_g_8 });
		bean.setViewClick(new clickView());
		bean.setButClick(new OnClickListener[] { new clickButton(),
				new clickButton(), new clickButton(), new clickButton() });
		list.add(bean);

		bean = new Bean();
		bean.setType(0);
		list.add(bean);

	}

	private void initView() {
		// TODO Auto-generated method stub
		listView = (ListView) view.findViewById(R.id.listView);
		DiscoverAdapter adapter = new DiscoverAdapter(this.getActivity(), list);
		listView.setAdapter(adapter);
	}

	class clickView implements OnClickListener {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Log.e("view", "view");
		}
	}

	class clickButton implements OnClickListener {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Log.e("button", "button");
		}
	}

}
