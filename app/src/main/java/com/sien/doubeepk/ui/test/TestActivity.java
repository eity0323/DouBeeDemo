/*
    Suneee Android Client, HomeActivity
    Copyright (c) 2014 Suneee Tech Company Limited
 */

package com.sien.doubeepk.ui.test;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.sien.doubeepk.R;

import java.util.List;

public class TestActivity extends Activity {
    // 时间轴列表
    private ListView lvList;
    // 数据list
    private List<DateText> list;
    // 列表适配器
    private DateAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

    }
}

