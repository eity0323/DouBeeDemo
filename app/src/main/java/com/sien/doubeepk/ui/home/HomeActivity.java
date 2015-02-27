/*
    Suneee Android Client, HomeActivity
    Copyright (c) 2014 Suneee Tech Company Limited
 */

package com.sien.doubeepk.ui.home;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Toast;

import com.sd.core.network.http.HttpException;
import com.sien.doubeepk.common.Event;
import com.sien.doubeepk.ui.BaseActivity;
import com.sien.doubeepk.R;
import com.sien.doubeepk.ui.test.DateAdapter;
import com.sien.doubeepk.ui.test.DateComparator;
import com.sien.doubeepk.ui.test.DateText;
import com.sien.doubeepk.ui.view.LoadDialog;
import com.sien.doubeepk.ui.view.pulltorefresh.PullToRefreshBase;
import com.sien.doubeepk.ui.view.pulltorefresh.PullToRefreshBase.OnRefreshListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import de.greenrobot.event.EventBus;

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

    // 时间轴列表
    private ListView lvList;
    // 数据list
    private List<DateText> list;
    // 列表适配器
    private DateAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		setHeadVisibility(View.GONE);
		initView();

        EventBus.getDefault().register(this);
	}

	/***
	 * 初始化UI控件
	 */
	private void initView() {
        // findviewbyid
        lvList = (ListView) findViewById(R.id.lv_list);
        list = new ArrayList<DateText>();
        // 添加测试数据
        addData();
        // 将数据按照时间排序
        DateComparator comparator = new DateComparator();
        Collections.sort(list, comparator);
        // listview绑定适配器
        adapter = new DateAdapter(this, list);
        lvList.setAdapter(adapter);
        lvList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                EventBus.getDefault().post(new Event.ItemListEvent("listitem"));
            }
        });
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
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
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

    public void onEventMainThread(Event.ItemListEvent event){
        Toast.makeText(this,"clike item",Toast.LENGTH_SHORT).show();
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

    private void addData() {
        DateText date1 = new DateText("20140710", "撒大声地");
        DateText date2 = new DateText("20140709", "撒萨达");
        DateText date3 = new DateText("20140726", "撒大ADS");
        DateText date4 = new DateText("20140710", "撒达到对萨达撒地");
        DateText date5 = new DateText("20140711", "撒大阿瑟的萨达地");
        DateText date6 = new DateText("20140713", "撒撒大大地");
        DateText date7 = new DateText("20140712", "撒大鼎折覆餗地");
        DateText date8 = new DateText("20140714", "撒大请问阿尔阿斯顿");
        DateText date9 = new DateText("20140709", "撒大亲爱额问问乔恩地");
        DateText date10 = new DateText("20140705", "撒 请问请问地");
        DateText date11 = new DateText("20140729", "撒请问额外确认声地");
        DateText date12 = new DateText("20140725", "撒大按时打算");
        DateText date13 = new DateText("20140716", "撒大爱上大声地");
        DateText date14 = new DateText("20140711", "撒其味无穷地");
        DateText date15 = new DateText("20140710", "撒大请问我期待地");
        DateText date16 = new DateText("20140711", "撒大声萨达");
        DateText date17 = new DateText("20140712", "阿斯达");
        DateText date18 = new DateText("20140711", "撒大声大声道");
        DateText date19 = new DateText("20140715", "阿斯顿撒打算23 ");
        DateText date20 = new DateText("20140723", "范德萨发生");
        DateText date21 = new DateText("20140718", "阿萨德飞洒");
        DateText date22 = new DateText("20140706", "撒打算打算");
        DateText date23 = new DateText("20140714", "撒打算");
        DateText date24 = new DateText("20140726", "轻微的城市的方式");
        DateText date25 = new DateText("20140725", "阿斯达阿斯达现在");
        DateText date26 = new DateText("20140723", "代购费多少自行车");
        DateText date27 = new DateText("20140721", "多撒阿萨德时打算");
        DateText date28 = new DateText("20140716", "爱上大声地啊地");
        DateText date29 = new DateText("20140712", "阿斯蒂芬当我师傅");
        DateText date30 = new DateText("20140710", "撒大声大声道");
        list.add(date1);
        list.add(date2);
        list.add(date3);
        list.add(date4);
        list.add(date5);
        list.add(date6);
        list.add(date7);
        list.add(date8);
        list.add(date9);
        list.add(date10);
        list.add(date11);
        list.add(date12);
        list.add(date13);
        list.add(date14);
        list.add(date15);
        list.add(date16);
        list.add(date17);
        list.add(date18);
        list.add(date19);
        list.add(date20);
        list.add(date21);
        list.add(date22);
        list.add(date23);
        list.add(date24);
        list.add(date25);
        list.add(date26);
        list.add(date27);
        list.add(date28);
        list.add(date29);
        list.add(date30);
    }
}
