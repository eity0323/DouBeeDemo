/*
    Suneee Android Client, CategoryActivity
    Copyright (c) 2014 Suneee Tech Company Limited
 */

package com.sien.doubeepk.ui.catalog;

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
 * [买买页面]
 * 
 * @author huxinwu
 * @version 1.0
 * @date 2014-11-6
 * 
 **/
public class CategoryActivity extends BaseActivity implements OnRefreshListener<ScrollView>, OnClickListener {

		@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_category);
		setHeadVisibility(View.GONE);
		initViews();
	}

	/**
	 * 页面初始化
	 */
	private void initViews() {

	}

	@Override
	public Object doInBackground(int requestCode) throws HttpException {
//		switch (requestCode) {
//			case HOTSALE_CODE:
//				return action.hotsale(refreshFlag);
//
//			case CATEGORYLIST_CODE:
//				return action.categorylist(refreshFlag);
//		}
		return super.doInBackground(requestCode);
	}

	@Override
	public void onSuccess(int requestCode, Object result) {
//		switch (requestCode) {
//		case HOTSALE_CODE:
//			if (result != null) {
//				HotsaleResponse res = (HotsaleResponse) result;
//				if (res.isSuccess()) {
//					hotList = new ArrayList<Goods>();
//					int index = 0;
//					if (res.getData() != null
//							&& res.getData().getList() != null
//							&& res.getData().getList().size() > 0) {
//						for (Goods bean : res.getData().getList()) {
//							hotList.add(bean);
//							if (index == 2) {
//								break;
//							}
//							index++;
//						}
//						if (hotAdapter.getDataSet() != null
//								&& hotAdapter.getDataSet().size() > 0) {
//							hotAdapter.removeAll();
//						}
//						hotAdapter.addData(hotList);
//						hotAdapter.notifyDataSetChanged();
//					}
//				}
//			}
//			isDataEmpty();
//			break;
//
//		case CATEGORYLIST_CODE:
//			if (refreshFlag) {
//				mPullToRefreshScrollView.onRefreshComplete();
//				refreshFlag = false;
//			}
//			if (result != null) {
//				CategorylistResponse res = (CategorylistResponse) result;
//				if (res.isSuccess()) {
//					if (res.getData() != null
//							&& res.getData().size() > 0) {
//						categoryList = res.getData();
//						if (categoryAdapter.getDataSet() != null
//								&& categoryAdapter.getDataSet().size() > 0) {
//							categoryAdapter.removeAll();
//						}
//						categoryAdapter.addData(categoryList);
//						categoryAdapter.notifyDataSetChanged();
//					}
//				}
//			}
//			isDataEmpty();
//			LoadDialog.dismiss(mContext);
//			break;
//		}
	}

	@Override
	public void onFailure(int requestCode, int state, Object result) {
		super.onFailure(requestCode, state, result);
//		if (refreshFlag) {
//			mPullToRefreshScrollView.onRefreshComplete();
//			refreshFlag = false;
//		}
		LoadDialog.dismiss(mContext);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		return getParent().onKeyDown(keyCode, event);
	}

	@Override
	public void onRefresh(PullToRefreshBase<ScrollView> refreshView) {
//		refreshFlag = true;
//		sendRequest();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
//		switch (v.getId()) {
//		case R.id.tv_message_empty:
//			sendRequest();
//			break;
//		}
	}

}
