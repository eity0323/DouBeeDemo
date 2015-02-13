package com.sien.doubeepk.ui.search;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.sd.core.network.http.HttpException;
import com.sien.doubeepk.ui.BaseActivity;
import com.sien.doubeepk.R;
import com.sien.doubeepk.ui.MainActivity;
import com.sien.doubeepk.ui.view.pulltorefresh.PullToRefreshBase;
import com.sien.doubeepk.ui.view.pulltorefresh.PullToRefreshBase.OnRefreshListener2;


public class SearchActivity extends BaseActivity implements OnClickListener, OnItemClickListener, TextWatcher, OnRefreshListener2<ListView> {
	
	private final String searchKey = "searchKey";
	

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_search);
		initView();

	}

	@SuppressWarnings("unchecked")
	private void initView() {
		this.setHeadVisibility(View.GONE);

	}

	@Override
	public void onClick(View v) {

	}

	private void searchWithInput() {

	}

	@Override
	public void beforeTextChanged(CharSequence s, int start, int count, int after) {
		
	}

	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {

	}

	@Override
	public void afterTextChanged(Editable s) {

	}

	@Override
	public Object doInBackground(int requestCode) throws HttpException {

		return super.doInBackground(requestCode);
	}

	@Override
	public void onSuccess(int requestCode, Object result) {
		super.onSuccess(requestCode, result);

	}

	@Override
	public void onFailure(int requestCode, int state, Object result) {
		super.onFailure(requestCode, state, result);

	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
			Intent intent = new Intent();
			intent.setClass(mContext, MainActivity.class);
			intent.putExtra(MainActivity.CHECK_ID, R.id.radio_home);
			startActivity(intent);
			finish();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
	
	/**
	 * 返回按钮点击事件，子类可以重载该方法
	 */
	public void onBack(View v){
		Intent intent = new Intent();
		intent.setClass(mContext, MainActivity.class);
		intent.putExtra(MainActivity.CHECK_ID, R.id.radio_home);
		startActivity(intent);
		finish();
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

	}

	@Override
	public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {

	}

	@Override
	public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {

	}
}
