package com.example.taobaoexe;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RadioButton;

import com.example.taobao.R;

@SuppressLint("NewApi")
public class Fragment4 extends Fragment {

	RadioButton b1, b2, b3;
	Context context;
	private FragmentManager manager;
	private FragmentTransaction transaction;

	Fragment1 frg1;
	Fragment2 frg2;
	Fragment3 frg3;
	View v;

	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		v = inflater.inflate(R.layout.fragment4_activity_main, null);
		b3 = (RadioButton) v.findViewById(R.id.b3);
		b1 = (RadioButton) v.findViewById(R.id.b1);
		b2 = (RadioButton) v.findViewById(R.id.b2);
		frg1 = new Fragment1();
		frg2 = new Fragment2();
		frg3 = new Fragment3();
		manager = getFragmentManager();
		transaction = manager.beginTransaction();
		transaction.add(R.id.contentLine, frg1);
		transaction.add(R.id.contentLine, frg2);
		transaction.add(R.id.contentLine, frg3);

		transaction.show(frg1);
		transaction.hide(frg2);
		transaction.hide(frg3);

		transaction.commit();
		b3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				manager = getFragmentManager();
				transaction = manager.beginTransaction();
				transaction.show(frg3);
				transaction.hide(frg2);
				transaction.hide(frg1);
				transaction.commit();
			}
		});
		b1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				manager = getFragmentManager();
				transaction = manager.beginTransaction();
				transaction.show(frg1);
				transaction.hide(frg2);
				transaction.hide(frg3);
				transaction.commit();
			}
		});
		b2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				manager = getFragmentManager();
				transaction = manager.beginTransaction();
				transaction.show(frg2);
				transaction.hide(frg1);
				transaction.hide(frg3);
				transaction.commit();
			}
		});
		return v;
	}

}
