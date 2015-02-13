/*
    Suneee Android Client, HomeActivity
    Copyright (c) 2014 Suneee Tech Company Limited
 */

package com.sien.doubeepk.ui.home;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ScrollView;

import com.sd.core.network.http.HttpException;
import com.sien.doubeepk.ui.BaseActivity;
import com.sien.doubeepk.R;
import com.sien.doubeepk.ui.view.LoadDialog;
import com.sien.doubeepk.ui.view.pulltorefresh.PullToRefreshBase;
import com.sien.doubeepk.ui.view.pulltorefresh.PullToRefreshBase.OnRefreshListener;

/**
 * [首页页面]
 * 
 * @author huxinwu
 * @version 1.0
 * @date 2014-11-6
 * 
 **/

public class HomeActivity extends BaseActivity implements OnClickListener, OnRefreshListener<ScrollView> {

	private static final String TAG = HomeActivity.class.getSimpleName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		setHeadVisibility(View.GONE);
		initView();
	}

	/***
	 * 初始化UI控件
	 */
	private void initView() {

	}

	@Override
	public Object doInBackground(int requestCode) throws HttpException {
//		switch (requestCode) {
//			case Constants.MS_GET_AD_LIST:
//				return mMallAction.adlist(refreshFlag);
//
//			case Constants.MS_GET_HOME_RECOMMEND_LIST:
//				return mMallAction.homeRecommend(refreshFlag);
//
//			case Constants.MS_GET_COMMUNITY_INFO:
//				communityId = PreferencesManager.getInstance(mContext, Constants.SHARE_REFRENCE_PATH).get(Constants.COMMUNITY_ID, "");
//				return mMallAction.communitylist(refreshFlag, communityId);
//		}
		return super.doInBackground(requestCode);
	}

	@Override
	public void onSuccess(int requestCode, Object result) {
//		switch (requestCode) {
//		case Constants.MS_GET_AD_LIST:
//			if (result != null) {
//				AdListResponse res = (AdListResponse) result;
//				if (res.isSuccess()) {
//					loadAdViewPage(res.getData());
//				}
//			}
//			break;
//
//		case Constants.MS_GET_HOME_RECOMMEND_LIST:
//			if (result != null) {
//				HomeRecommendResponse res = (HomeRecommendResponse) result;
//				HomeRecommend home = res.getData();
//				if (res.isSuccess() && home != null) {
//					loadFlashscaleResponse(home.getXianshi());
//					loadFavourableResponse(home.getJuyouhui());
//					loadRecommedResponse(home.getNew_goods());
//				}
//			}
//			break;
//
//		case Constants.MS_GET_COMMUNITY_INFO:
//			if (result != null) {
//				CommunitylistResponse res = (CommunitylistResponse) result;
//				if (res.isSuccess()) {
//					loadCommunityListResponse(res.getData());
//				}
//			}
//
//			mPullToRefreshScrollView.onRefreshComplete();
//			LoadDialog.dismiss(mContext);
//			break;
//		}
	}

	@Override
	public void onFailure(int requestCode, int state, Object result) {
//		mPullToRefreshScrollView.onRefreshComplete();
		LoadDialog.dismiss(mContext);
	}

	/***
	 * 无数据时显示提示
	 * 
	 */
	private void isDataEmpty() {
//		if (mCommunityInfoAdapter.getCount() <= 0 && mRecomSaleAdapter.getCount() <= 0
//				&& mFlashSaleAdapter.getCount() <= 0 && mFavSaleAdapter.getCount() <= 0) {
//			mTvMessageEmpty.setVisibility(View.VISIBLE);
//			mPullToRefreshScrollView.setVisibility(View.GONE);
//		} else {
//			mTvMessageEmpty.setVisibility(View.GONE);
//			mPullToRefreshScrollView.setVisibility(View.VISIBLE);
//		}
	}

	/***
	 * 发出获取广告列表 限时抢购 聚实惠 每日新品请求
	 */
	@Override
	protected void onResume() {
		super.onResume();
//		refreshFlag = false;
//		boolean login_status = PreferencesManager.getInstance(mContext, Constants.SHARE_REFRENCE_PATH).get(Constants.APP_LOGIN_STATUS, false);
//		if (login_status && !StringUtils.isEmpty(communityId)) {
//			request(Constants.MS_GET_COMMUNITY_INFO);
//		} else {
//			request(Constants.MS_GET_COMMUNITY_INFO);
//		}
//
//		if (downTimer != null) {
//			downTimer.stopDown();
//		}
//		request(Constants.MS_GET_HOME_RECOMMEND_LIST);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		return getParent().onKeyDown(keyCode, event);
	}

	@Override
	public void onClick(View v) {
//		switch (v.getId()) {
//		case R.id.flash_sale_title_layout:
//			Intent intent = new Intent(mContext, MainActivity.class);
//			String urlFlash = StringUtils.getAssetsURL("flash_sale");
//			intent.putExtra(WebActivity.URL_KEY, urlFlash);
//			intent.putExtra(MainActivity.CHECK_ID, R.id.radio_cart);
//			mContext.startActivity(intent);
//			break;
//
//		case R.id.favourable_title_layout:
//			intent = new Intent(mContext, MainActivity.class);
//			String urlFav = StringUtils.getAssetsURL("favorable");
//			intent.putExtra(WebActivity.URL_KEY, urlFav);
//			intent.putExtra(MainActivity.CHECK_ID, R.id.radio_cart);
//			mContext.startActivity(intent);
//			break;
//
//		case R.id.recommend_title_layout:
//			intent = new Intent(mContext, MainActivity.class);
//			String urlRec = StringUtils.getAssetsURL("newproduct/system.favourable/淘新品");
//			intent.putExtra(WebActivity.URL_KEY, urlRec);
//			intent.putExtra(MainActivity.CHECK_ID, R.id.radio_cart);
//			mContext.startActivity(intent);
//			break;
//
//		case R.id.tv_message_empty:
//			LoadDialog.show(mContext);
//			sendRequest();
//			break;
//		}
	}

//	/**
//	 * 当ViewPager中页面的状态发生改变时调用
//	 *
//	 * @author Administrator
//	 */
//	private class MyPageChangeListener implements OnPageChangeListener {
//
//		@Override
//		public void onPageScrollStateChanged(int arg0) {
//			isScrollAdFlag = true;
//		}
//
//		@Override
//		public void onPageScrolled(int arg0, float arg1, int arg2) {
//			isScrollAdFlag = true;
//		}
//
//		@Override
//		public void onPageSelected(int position) {
//			adPosition = position;
//			for (int i = 0; i < pointImageViews.length; i++) {
//				pointImageViews[position].setBackgroundResource(R.drawable.point_choosed);
//				if (position != i) {
//					pointImageViews[i].setBackgroundResource(R.drawable.point_not_choosed);
//				}
//			}
//			isScrollAdFlag = false;
//		}
//	}

	@Override
	public void onRefresh(PullToRefreshBase<ScrollView> refreshView) {
//		if (timer != null) {
//			timer.cancel();
//		}
//		if (downTimer != null) {
//			downTimer.stopDown();
//		}
//		refreshFlag = true;
//		sendRequest();
	}

}
