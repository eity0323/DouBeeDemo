/*
    Suneee Android Client, MoerActivity
    Copyright (c) 2014 Suneee Tech Company Limited
 */

package com.sien.doubeepk.ui.mine;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;

import com.sien.doubeepk.ui.BaseActivity;
import com.sien.doubeepk.R;

/**
 * [我页面]
 * 
 * @author huxinwu
 * @version 1.0
 * @date 2014-11-6
 * 
 **/
public class MineActivity extends BaseActivity implements OnClickListener {

		@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mine);
		setHeadVisibility(View.GONE);
		initViews();
	}

	@Override
	protected void onResume() {
		initUser();
		super.onResume();
	}

	private void initUser() {

	}

	private void initViews() {

	}

	private void setOnclickListener(View... views) {
		if (null != views && views.length > 0)
			for (View view : views) {
				view.setOnClickListener(this);
			}
	}

	@Override
	public void onClick(View v) {
//		if (v == mTopLoginView || v == mIconIv) {
//			startActivityCheckLogin(PersonalActivity.class);
//		}
//
//		else if (v == mAllOrderTv) {
//			startWebActivity("order", "TRADE_ALL");
//		}
//
//		else if (v == mPendingPaymentOrderView) {
//			startWebActivity("order", "WAIT_BUYER_PAY");
//		}
//
//		else if (v == mReceivedOrdersView) {
//			startWebActivity("order", "WAIT_BUYER_CONFIRM_GOODS");
//		}
//
//		else if (v == mReviewOrdersView) {
//			startWebActivity("order", "TRADE_EVALUATE");
//		}
//
//		else if (v == mPersonSettingsView) {
//			startActivityCheckLogin(PersonalSettingActivity.class);
//		}
//
//		else if (v == mAboutView) {
//			startActivity(AboutActivity.class);
//		}
//
//		else if (v == mMyFavortiesView) {
//			startWebActivity("fanvirite");
//		}
//		else if(v == clientServiceView){
//			Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:4000-266-818"));
//            startActivity(intent);
//		}
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		return getParent().onKeyDown(keyCode, event);
	}

	/**
	 * 跳转到WebActivity
	 * 
	 * @param model
	 * @param params
	 */
	private void startWebActivity(String model, String... params) {
		// 检查是否登陆，如果没有登陆弹出提示框
//		boolean loginflag = CommonUtils.isLogin(mContext);
//		if (loginflag) {
//			Intent intent = new Intent(mContext, MainActivity.class);
//			String url = StringUtils.getAssetsURL(model, params);
//			intent.putExtra(WebActivity.URL_KEY, url);
//			intent.putExtra(MainActivity.CHECK_ID, R.id.radio_cart);
//			mContext.startActivity(intent);
//		} else {
//			Intent intent = new Intent(mContext, LoginActivity.class);
//			intent.putExtra("isReLogin", true);
//			mContext.startActivity(intent);
//		}
	}

	/**
	 * 跳转到Activity
	 * 
	 * @param cls
	 */
	@SuppressWarnings("rawtypes")
	private void startActivityCheckLogin(Class cls) {
		// 检查是否登陆，如果没有登陆弹出提示框
//		boolean loginflag = CommonUtils.isLogin(mContext);
//		if (loginflag) {
//			Intent intent = new Intent(mContext, cls);
//			mContext.startActivity(intent);
//		} else {
//			Intent intent = new Intent(mContext, LoginActivity.class);
//			intent.putExtra("isReLogin", true);
//			mContext.startActivity(intent);
//		}
	}
}
