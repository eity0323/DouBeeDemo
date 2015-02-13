package com.sien.doubeepk.ui.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.sien.doubeepk.R;


public class AddMenuDialog extends Dialog implements
		View.OnClickListener {
	private Context mContext;
	private RelativeLayout mReleaseAnnouceLayout;
	private RelativeLayout mCreateGroupLayout;
	private RelativeLayout mCreateCampainLayout;
	private RelativeLayout mJoinCommunityLayout;

	public AddMenuDialog(Context context) {
		super(context);
		mContext = context;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.layout_topright_menu_dialog);
		this.initWindowParams();
		this.initView();
	}

	public AddMenuDialog(Context context, int theme) {
		super(context, theme);
		mContext = context;
	}

	private void initWindowParams() {
		Window window = getWindow();
		window.setGravity(Gravity.TOP | Gravity.RIGHT);
		window.setBackgroundDrawableResource(android.R.color.transparent);
		WindowManager.LayoutParams params = window.getAttributes();
		params.y = (int) this.mContext.getResources().getDimension(
				R.dimen.top_bar_height);
		window.setAttributes(params);
	}

	public void initView() {
		this.mReleaseAnnouceLayout = (RelativeLayout) this
				.findViewById(R.id.release_annoucement);
		this.mReleaseAnnouceLayout.setOnClickListener(this);
		this.mCreateGroupLayout = (RelativeLayout) this
				.findViewById(R.id.create_group);
		this.mCreateGroupLayout.setOnClickListener(this);
		this.mCreateCampainLayout = (RelativeLayout) this
				.findViewById(R.id.create_campain);
		this.mCreateCampainLayout.setOnClickListener(this);
		this.mJoinCommunityLayout = (RelativeLayout) this
				.findViewById(R.id.join_community);
		this.mJoinCommunityLayout.setOnClickListener(this);
		this.mJoinCommunityLayout.setVisibility(View.GONE);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.release_annoucement:
			this.dismiss();
//			try {
//				ImageInfoDao dao = DBManager.getInstance(mContext).getDaoSession().getImageInfoDao();
//				dao.deleteAll();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			startActivityCheckLogin(NoticeAddActivity.class, true);
			break;

		case R.id.create_group:
			this.dismiss();
//			startActivityCheckLogin(AddMultiRoom.class, true);
			break;

		case R.id.create_campain:
			this.dismiss();
//			try {
//				ImageInfoDao dao = DBManager.getInstance(mContext).getDaoSession().getImageInfoDao();
//				dao.deleteAll();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			startActivityCheckLogin(CampaignAddActivity.class, true);
			break;

		case R.id.join_community:
			this.dismiss();
//			startActivityCheckLogin(null, true);
			break;
		}
	}

	/**
	 * 跳转到Activity
	 * @param cls
	 * @param isCheckCalTalk
	 */
	@SuppressWarnings("rawtypes")
	private void startActivityCheckLogin(Class cls, boolean isCheckCalTalk){
		//检查是否登陆，如果没有登陆弹出提示框
//		boolean loginflag = CommonUtils.isLogin(mContext);
//		if(loginflag){
//			if(isCheckCalTalk && StringUtils.isCanTalk(mContext)){
//				NToast.shortToast(mContext, "您已被禁言，暂时不能执行该操作");
//			}else{
//				if(cls != null){
//					Intent intent = new Intent(mContext, cls);
//					mContext.startActivity(intent);
//				}
//			}
//		}else{
//			Intent intent = new Intent(mContext, LoginActivity.class);
//			intent.putExtra("isReLogin", true);
//			mContext.startActivity(intent);
//		}
	}
}
