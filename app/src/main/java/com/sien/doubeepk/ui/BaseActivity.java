package com.sien.doubeepk.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.sd.core.common.ActivityPageManager;
import com.sd.core.network.async.AsyncTaskManager;
import com.sd.core.network.async.OnDataListener;
import com.sd.core.utils.NToast;
import com.sd.core.network.http.HttpException;
import com.sien.doubeepk.R;


/**
 * Created by suneee012 on 2015/2/11.
 */
public class BaseActivity extends FragmentActivity implements OnDataListener {

    protected Context mContext;
    private AsyncTaskManager mAsyncTaskManager;
    private ViewFlipper mContentView;
    protected RelativeLayout layout_head;
    protected Button btn_back;
    protected Button btn_right;
    protected TextView tv_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_base);
        mContext = this;

        // 初始化公共头部
        mContentView = (ViewFlipper) super.findViewById(R.id.layout_container);
        layout_head = (RelativeLayout) super.findViewById(R.id.layout_head);
        btn_back = (Button) super.findViewById(R.id.btn_back);
        btn_right = (Button) super.findViewById(R.id.btn_right);
        tv_title = (TextView) super.findViewById(R.id.tv_title);

        // 初始化异步框架
        mAsyncTaskManager = AsyncTaskManager.getInstance(mContext);
        // Activity管理
        ActivityPageManager.getInstance().addActivity(this);

    }

    @Override
    public void setContentView(View view) {
        if (mContentView.getChildCount() > 1) {
            mContentView.removeViewAt(1);
        }
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT, 1);
        mContentView.addView(view, lp);
    }

    @Override
    public void setContentView(int layoutResID) {
        View view = LayoutInflater.from(this).inflate(layoutResID, null);
        setContentView(view);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityPageManager.unbindReferences(mContentView);
        ActivityPageManager.getInstance().removeActivity(this);
        mContentView = null;
        mContext = null;
    }

    /**
     * 发送请求（需要检查网络）
     * @param requsetCode 请求码
     */
    public void request(int requsetCode) {
        mAsyncTaskManager.request(requsetCode, this);
    }

    /**
     * 发送请求
     * @param requsetCode 请求码
     * @param isCheckNetwork 是否需检查网络，true检查，false不检查
     */
    public void request(int requsetCode, boolean isCheckNetwork) {
        mAsyncTaskManager.request(requsetCode, isCheckNetwork, this);
    }

    /**
     * 取消请求
     * @param requsetCode
     */
    public void cancelRequest(int requsetCode) {
        mAsyncTaskManager.cancelRequest(requsetCode);
    }

    /**
     * 取消所有请求
     */
    public void cancelRequest() {
        mAsyncTaskManager.cancelRequest();
    }

    @Override
    public Object doInBackground(int requestCode) throws HttpException {
        return null;
    }

    @Override
    public void onSuccess(int requestCode, Object result) {

    }

    @Override
    public void onFailure(int requestCode, int state, Object result) {
        switch (state) {
            // 网络不可用给出提示
            case AsyncTaskManager.HTTP_NULL_CODE:
                NToast.shortToast(mContext, R.string.common_network_unavailable);
                break;

            // 网络有问题给出提示
            case AsyncTaskManager.HTTP_ERROR_CODE:
                NToast.shortToast(mContext, R.string.common_network_error);
                break;

            // 请求有问题给出提示
            case AsyncTaskManager.REQUEST_ERROR_CODE:
                //NToast.shortToast(mContext, R.string.common_request_error);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    /**
     * 重新启动当前页面
     */
    protected void reLoad() {
        Intent intent = getIntent();
        overridePendingTransition(0, 0);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        finish();
        overridePendingTransition(0, 0);
        startActivity(intent);
    }

    /**
     * 设置头部是否可见
     *
     * @param visibility
     */
    public void setHeadVisibility(int visibility) {
        layout_head.setVisibility(visibility);
    }

    /**
     *设置标题
     */
    public void setTitle(int titleId) {
        tv_title.setText(getString(titleId));
    }

    /**
     * 设置标题
     * @param title
     */
    public void setTitle(String title) {
        tv_title.setText(title);
    }

    /**
     * 设置右边按钮为隐藏
     */
    public void setBtnRightGone(){
        btn_right.setVisibility(View.GONE);
    }

    /**
     * 设置右边按钮为“完成样式”
     */
    public void setBtnRightCompleteStyle(){
        btn_right.setBackground(null);
        btn_right.setText(getString(R.string.finish));
    }

    /**
     * 设置右边按钮为“下一步样式”
     */
    public void setBtnRightNextStepStyle(){
        btn_right.setBackground(null);
        btn_right.setText(getString(R.string.next_step));
    }

    /**
     * 设置右边按钮为“编辑样式”
     */
    public void setBtnRightEditStyle(){
        btn_right.setBackground(null);
        btn_right.setText(getString(R.string.edit));
    }

    /**
     * 设置右边按钮为“下一步样式”
     */
    public void setBtnRightComitStyle(){
        btn_right.setBackground(null);
        btn_right.setText(getString(R.string.comit));
    }

    /**
     * 返回按钮点击事件，子类可以重载该方法
     */
    public void onBack(View v){
        this.finish();
    }

    /**
     * 右按钮点击事件，子类可以重载该方法
     */
    public void onRight(View v){
        NToast.shortToast(mContext, "请重载onRight方法");
    }

    protected void startActivity(Class<?> clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }

}
