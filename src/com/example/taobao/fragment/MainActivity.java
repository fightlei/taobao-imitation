package com.example.taobao.fragment;

import java.util.List;

import com.example.discover.DiscoverFragment;
import com.example.taobao.Fragment1;
import com.example.taobao.Fragment2;
import com.example.taobao.Fragment5;
import com.example.taobao.R;
import com.example.taobaoexe.Fragment4;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

@SuppressLint("NewApi")
public class MainActivity extends Activity {
	RadioGroup radioGroup;
	FragmentManager fragmentManager;
	FragmentTransaction fragmentTransaction;
	Fragment1 fragment1;
	Fragment2 fragment2;
	DiscoverFragment fragment3 ;
	Fragment4 fragment4;
	Fragment5 fragment5;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_main);
		radioGroup = (RadioGroup) findViewById(R.id.radiogroup);
		fragment1 = new Fragment1();
		fragment2 = new Fragment2();
		fragment3 = new DiscoverFragment();
		fragment4 = new Fragment4();
		fragment5 = new Fragment5();
		fragment1.setContext(getApplicationContext());
		fragment2.setContext(getApplicationContext());
		// fragment3.setContext(getApplicationContext());
		fragment4.setContext(getApplicationContext());
		fragment5.setContext(getApplicationContext());
		fragmentManager = getFragmentManager();
		fragmentTransaction = fragmentManager.beginTransaction();
		fragmentTransaction.replace(R.id.ll1, fragment1);
		fragmentTransaction.addToBackStack(null);
		fragmentTransaction.commit();
		radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@SuppressLint("NewApi")
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				RadioButton button = (RadioButton) findViewById(arg1);
				switch (arg1) {
				case R.id.r1:
					fragmentTransaction = fragmentManager.beginTransaction();
					fragmentTransaction.replace(R.id.ll1, fragment1);
					fragmentTransaction.addToBackStack(null);
					fragmentTransaction.commit();
					break;
				case R.id.r2:
					fragmentTransaction = fragmentManager.beginTransaction();
					fragmentTransaction.replace(R.id.ll1, fragment2);
					fragmentTransaction.addToBackStack(null);
					fragmentTransaction.commit();
					break;
				 case R.id.r3:
				 fragmentTransaction=fragmentManager.beginTransaction();
				 fragmentTransaction.replace(R.id.ll1, fragment3);
				 fragmentTransaction.addToBackStack(null);
				 fragmentTransaction.commit();
				 break;
				case R.id.r4:
					fragmentTransaction = fragmentManager.beginTransaction();
					fragmentTransaction.replace(R.id.ll1, fragment4);
					fragmentTransaction.addToBackStack(null);
					fragmentTransaction.commit();
					break;
				case R.id.r5:
					fragmentTransaction = fragmentManager.beginTransaction();
					fragmentTransaction.replace(R.id.ll1, fragment5);
					fragmentTransaction.addToBackStack(null);
					fragmentTransaction.commit();
					break;
				}
			}
		});
	}
	public void autoPlay(final ViewPager viewPager , final List<ImageView> imageViews_viewPager) {
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
}
