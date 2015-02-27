/*
    Suneee Android Client, MainActivity
    Copyright (c) 2014 Suneee Tech Company Limited
 */

package com.sien.doubeepk.ui;

import android.app.ActivityGroup;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.TabHost;

import com.sd.core.common.ActivityPageManager;
import com.sien.doubeepk.R;
import com.sien.doubeepk.ui.cart.CartActivity;
import com.sien.doubeepk.ui.catalog.CategoryActivity;
import com.sien.doubeepk.ui.community.CommunityActivity;
import com.sien.doubeepk.ui.home.HomeActivity;
import com.sien.doubeepk.ui.mine.MineActivity;
import com.sien.doubeepk.ui.search.SearchActivity;
import com.sien.doubeepk.ui.view.AddMenuDialog;
import com.sien.doubeepk.utils.StringUtils;


/**
 * [主页框架]
 * 
 * @author huxinwu
 * @version 1.0
 * @date 2014-3-1
 * 
 **/
@SuppressWarnings("deprecation")
public class MainActivity extends ActivityGroup implements OnCheckedChangeListener, OnClickListener {

	public static String COMMAND_ID = "command";
	public static String CHECK_ID = "checkId";
	private int RESULT_LGOIN_ACTION = 1;

	private TabHost tabHost;
	private RadioGroup radioGroup;
	private RelativeLayout layout_head;
	private ImageButton searchImBt;
	private ImageButton addImBt;
	private AddMenuDialog addMenuDialog;
	private Button btn_cart;
	private int lastCheckId = R.id.radio_home;
	public static int checkId = 0;
	private String weburl;
	private int newscount = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Intent homeIntent = new Intent(this, HomeActivity.class);
		Intent categoryIntent = new Intent(this, CategoryActivity.class);
		Intent communityIntent = new Intent(this, CommunityActivity.class);
		Intent mineIntent = new Intent(this, MineActivity.class);
		Intent cartIntent = new Intent(this, CartActivity.class);

		btn_cart = (Button) this.findViewById(R.id.btn_cart);
		btn_cart.setOnClickListener(this);
		this.searchImBt = (ImageButton) this.findViewById(R.id.ibtn_search);
		this.addImBt = (ImageButton) this.findViewById(R.id.ibtn_add);
		this.searchImBt.setOnClickListener(this);
		this.addImBt.setOnClickListener(this);

		weburl = StringUtils.getAssetsURL("shoppingcart");
		layout_head = (RelativeLayout) findViewById(R.id.layout_head);
		tabHost = (TabHost) findViewById(R.id.tabhost);
		tabHost.setup(getLocalActivityManager());
		tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("tab1").setContent(homeIntent));
		tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator("tab2").setContent(categoryIntent));
		tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator("tab3").setContent(communityIntent));
		tabHost.addTab(tabHost.newTabSpec("tab4").setIndicator("tab4").setContent(cartIntent));
		tabHost.addTab(tabHost.newTabSpec("tab5").setIndicator("tab5").setContent(mineIntent));
		radioGroup = (RadioGroup) super.findViewById(R.id.radioGroup_menu);
		radioGroup.setOnCheckedChangeListener(this);

	}

	@Override
	public void onCheckedChanged(RadioGroup arg0, int checkedId) {
		switch (checkedId) {
		case R.id.radio_home:
			tabHost.setCurrentTab(0);
			lastCheckId = R.id.radio_home;
			checkId = 0;
			break;

		case R.id.radio_category:
			tabHost.setCurrentTab(1);
			lastCheckId = R.id.radio_category;
			checkId = 1;
			break;

		case R.id.radio_collection:
			 checkId = 2;
             tabHost.setCurrentTab(2);
             lastCheckId = R.id.radio_collection;
			 break;

		case R.id.radio_cart:
            checkId = 3;
			tabHost.setCurrentTab(3);
            lastCheckId = R.id.radio_cart;
			break;
		}
	}

	/**
	 * 切换tab
	 * 
	 * @param checkedId
	 */
	public void switchTab(int checkedId) {
		radioGroup.check(checkedId);
		lastCheckId = checkedId;
	}

	@Override
	protected void onNewIntent(Intent intent) {
		if (intent != null) {
			int checkId = intent.getIntExtra(CHECK_ID, R.id.radio_home);
			switchTab(checkId);
//
//			//处理活动刷新
//			String command = intent.getStringExtra(COMMAND_ID);
//			if(CampaignFragment.REFRESH_ACTION.equals(command)){
//				Intent intent1 = new Intent();
//				intent1.putExtra("index", 1);
//				intent1.setAction(CampaignFragment.REFRESH_ACTION);
//				sendBroadcast(intent1);
//			}
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if(requestCode == RESULT_LGOIN_ACTION && resultCode == 129){
			switchTab(R.id.radio_collection);
		}
//		Activity currentActivity = getLocalActivityManager().getCurrentActivity();
//		if (currentActivity instanceof BaseActivity) {
//			((BaseActivity) currentActivity).onActivityResult(requestCode, resultCode, data);
//		}
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
//			MessageDialog dialog = new MessageDialog(MainActivity.this,
//					getString(R.string.common_title_tips),
//					getString(R.string.common_confirm),
//					getString(R.string.common_cancel),
//					getString(R.string.common_exit));
//			dialog.setBtn1ClickListener(new OnClickListener() {
//				@Override
//				public void onClick(View v) {
//					LruCacheManager.getInstance().evictAll();
					ActivityPageManager.getInstance().exit(MainActivity.this);
//				}
//			});
//			dialog.show();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.ibtn_add:
				if (null == addMenuDialog) {
					addMenuDialog = new AddMenuDialog(this, R.style.dialog);
					addMenuDialog.show();
				} else if (null != addMenuDialog && addMenuDialog.isShowing()) {
					addMenuDialog.dismiss();
					addMenuDialog = null;
				} else if (null != addMenuDialog && !addMenuDialog.isShowing()) {
					addMenuDialog.dismiss();
					addMenuDialog = null;
					addMenuDialog = new AddMenuDialog(this, R.style.dialog);
					addMenuDialog.show();
				}
				break;

			case R.id.ibtn_search:
				Intent intent = new Intent(this, SearchActivity.class);
				this.startActivity(intent);
				break;
		}
	}

	/**
	 * 切换到社区页面
	 * 
	 * @param index
	 */
	public void changeToCommunity(int index) {
		switchTab(R.id.radio_collection);
//		// 发送广播
//		Intent intent = new Intent();
//		intent.putExtra("index", index);
//		intent.setAction(CommunityActivity.SWITCH_ACTION);
//		sendBroadcast(intent);
	}

}
