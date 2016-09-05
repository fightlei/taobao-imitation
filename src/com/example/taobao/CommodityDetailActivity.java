package com.example.taobao;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.taobao.adapter.MyBaseAdapter;
import com.example.taobao.adapter.MyPagerAdapter;
import com.example.taobao.bean.HomeBean;
import com.example.taobaoexe.Fragment1;
import com.example.taobaoexe.Goods;

public class CommodityDetailActivity extends Activity {

	Button gang1, gang2, mei1, mei2, sum, sub, black, white , sure;
	TextView show;
	ViewPager viewPager_detailShow;
	ImageButton imageButton;
	List<ImageView> viewPagers_dataSet;
	List<HomeBean> homebeans_cd;
	ListView listView_cd;
	int images_detailShow[] = { R.drawable.detail_show_1,
			R.drawable.detail_show_2, R.drawable.detail_show_3,
			R.drawable.detail_show_4, R.drawable.detail_show_5,
			R.drawable.detail_show_6 };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_commo_detail);
		initView();
		initData();
	}

	private void initData() {
		viewPagers_dataSet = new ArrayList<ImageView>();
		for (int i = 0; i < images_detailShow.length; i++) {
			ImageView imageView = new ImageView(getApplicationContext());
			imageView.setImageResource(images_detailShow[i]);
			viewPagers_dataSet.add(imageView);
		}
		MyPagerAdapter adapter = new MyPagerAdapter(viewPagers_dataSet);
		viewPager_detailShow.setAdapter(adapter);
		homebeans_cd = new ArrayList<HomeBean>();
		for (int i = 0; i < 10; i++) {
			HomeBean homeBean = new HomeBean();
			homeBean.setWhich(2);
			homebeans_cd.add(homeBean);
		}
		MyBaseAdapter adapter2 = new MyBaseAdapter(homebeans_cd,
				getApplicationContext());
		listView_cd.setAdapter(adapter2);
		listView_cd.setFocusable(false);
		listView_cd.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent intent = new Intent(Intent.ACTION_VIEW, Uri
						.parse("http://yecaoly.taobao.com"));
				startActivity(intent);
			}
		});
	}

	private void initView() {
		imageButton = (ImageButton) findViewById(R.id.actionbar_back);
		listView_cd = (ListView) findViewById(R.id.listView_commo_detail);
		viewPager_detailShow = (ViewPager) findViewById(R.id.view_pager_detail);
		imageButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				try {
					finish();
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void showDialog(View v) {
		final int id = v.getId();
		final AlertDialog dialog = new AlertDialog.Builder(
				CommodityDetailActivity.this).create();
		dialog.show();
		Window window = dialog.getWindow();
		window.setContentView(R.layout.window_shoppingcar);
		window.setGravity(Gravity.BOTTOM);
		window.setLayout(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		window.setWindowAnimations(R.style.animShoppingCar);
		gang1 = (Button) ((LinearLayout) window.findViewById(R.id.ll_gang))
				.getChildAt(0);
		gang1.setTag(0);
		gang2 = (Button) ((LinearLayout) window.findViewById(R.id.ll_gang))
				.getChildAt(1);
		gang2.setTag(0);
		for (int i = 0; i < 2; i++) {
			((LinearLayout) window.findViewById(R.id.ll_gang)).getChildAt(i)
					.setOnClickListener(new OnClickListener() {

						@Override
						public void onClick(View v) {
							if (((Integer) v.getTag()) == 0) {
								gang1.setBackgroundResource(R.drawable.circularbtn);
								gang2.setBackgroundResource(R.drawable.circularbtn);
								gang1.setTag(0);
								gang2.setTag(0);
								v.setBackgroundResource(R.drawable.noclickstyle);
								v.setTag(1);
							} else {
								v.setBackgroundResource(R.drawable.circularbtn);
								v.setTag(0);
							}
						}
					});

		}
		mei1 = (Button) ((LinearLayout) window.findViewById(R.id.ll_mei))
				.getChildAt(0);
		mei1.setTag(0);
		mei2 = (Button) ((LinearLayout) window.findViewById(R.id.ll_mei))
				.getChildAt(1);
		mei2.setTag(0);
		for (int i = 0; i < 2; i++) {
			((LinearLayout) window.findViewById(R.id.ll_mei)).getChildAt(i)
					.setOnClickListener(new OnClickListener() {

						@Override
						public void onClick(View v) {
							if (((Integer) v.getTag()) == 0) {
								mei1.setBackgroundResource(R.drawable.circularbtn);
								mei2.setBackgroundResource(R.drawable.circularbtn);
								mei1.setTag(0);
								mei2.setTag(0);
								v.setBackgroundResource(R.drawable.noclickstyle);
								v.setTag(1);
							} else {
								v.setBackgroundResource(R.drawable.circularbtn);
								v.setTag(0);
							}
						}
					});

		}
		black = (Button) ((LinearLayout) window.findViewById(R.id.ll_color))
				.getChildAt(0);
		black.setTag(0);
		white = (Button) ((LinearLayout) window.findViewById(R.id.ll_color))
				.getChildAt(1);
		white.setTag(0);
		for (int i = 0; i < 2; i++) {
			((LinearLayout) window.findViewById(R.id.ll_color)).getChildAt(i)
					.setOnClickListener(new OnClickListener() {

						@Override
						public void onClick(View v) {
							if (((Integer) v.getTag()) == 0) {
								black.setBackgroundResource(R.drawable.circularbtn);
								white.setBackgroundResource(R.drawable.circularbtn);
								black.setTag(0);
								white.setTag(0);
								v.setBackgroundResource(R.drawable.noclickstyle);
								v.setTag(1);
							} else {
								v.setBackgroundResource(R.drawable.circularbtn);
								v.setTag(0);
							}
						}
					});

		}
		sum = (Button) window.findViewById(R.id.btn_sumsum);
		sub = (Button) window.findViewById(R.id.btn_sub);
		show = (TextView) window.findViewById(R.id.textview_show);
		sum.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				show.setText((Integer.parseInt(show.getText().toString().trim())+1)+"");
			}
		});
		sub.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if(Integer.parseInt(show.getText().toString().trim())<=1){
					Toast.makeText(getApplicationContext(), "购买数量不能低于1件", 1).show();
				}else{
					show.setText((Integer.parseInt(show.getText().toString().trim())-1)+"");
				}
			}
		});
		sure = (Button) window.findViewById(R.id.btn_sure);
		sure.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(id==R.id.ib_shoppingcar){
					Toast.makeText(getApplicationContext(), "添加到购物车成功", 1).show();
					Goods good1 = new Goods("尽在恋上猫女衣坊 http://yecaoly.taobao.com","时尚女衣", "32G 港版", "49", "2", "白色", R.drawable.detail_show_1);
					Message message = new Message();
					message.obj = good1 ;
					Fragment1.getHnadler().sendMessage(message);
					dialog.cancel();
				}
				if(id==R.id.ib_buynow){
					Intent intent = new Intent(CommodityDetailActivity.this,ConfirmActivity.class);
					startActivity(intent);
					//跳转
				}
			}
		});
	}
}
