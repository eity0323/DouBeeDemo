/*
    Suneee Android Client, CollectionActivity
    Copyright (c) 2014 Suneee Tech Company Limited
 */

package com.sien.doubeepk.ui.community;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;

import com.sien.doubeepk.R;
import com.sien.doubeepk.ui.BaseActivity;


/**
 * [社区页面]
 * 
 * @author huxinwu
 * @version 1.0
 * @date 2014-11-6
 * 
 **/
public class CommunityActivity extends BaseActivity implements OnClickListener, OnPageChangeListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_community);

		setHeadVisibility(View.GONE);
		initViews();
	}
	
	public void initViews(){

	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		return getParent().onKeyDown(keyCode, event);
	}
	
	@Override
	public void onClick(View v) {
		switch(v.getId()){
		
		}
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		
	}

	@Override
	public void onPageSelected(int position) {
//		if(!hashset.contains(position)){
//			hashset.add(position);
//			((BaseFragment)fragmentList.get(position)).initViews();
//		}
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//		int position = viewPager.getCurrentItem();
//		((BaseFragment)fragmentList.get(position)).onActivityResult(requestCode, resultCode, data);
	}
	
    BroadcastReceiver dataChageReceiver = new BroadcastReceiver(){
		@Override
		public void onReceive(Context arg0, Intent intent) {
			String command = intent.getAction();
			
//			if(!TextUtils.isEmpty(command)){
//				if((SWITCH_ACTION).equals(command)){
//					int index = intent.getIntExtra("index", 0);
//					viewPager.setCurrentItem(index);
//					return;
//				}
//
//				//刷新公告
//				if((NoticeFragment.REFRESH_ACTION).equals(command)){
//					viewPager.setCurrentItem(0);
//					new Handler().postAtTime(new Runnable() {
//						@Override
//						public void run() {
//							((NoticeFragment)fragmentList.get(0)).onPullDownToRefresh(null);
//						}
//					}, 1000);
//					return;
//				}
//
//				//刷新活动
//				if((CampaignFragment.REFRESH_ACTION).equals(command)){
//					viewPager.setCurrentItem(1);
//					new Handler().postAtTime(new Runnable() {
//						@Override
//						public void run() {
//							((CampaignFragment)fragmentList.get(1)).onPullDownToRefresh(null);
//						}
//					}, 1000);
//					return;
//				}
//			}
		}
    };
    
	@Override
	public void onDestroy() {

		unregisterReceiver(dataChageReceiver);
		super.onDestroy();
	}
}
