package com.musk.demo;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.musk.demo.model.DataModelOne;
import com.musk.demo.model.DataModelThree;
import com.musk.demo.model.DataModelTwo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Musk 2017/4/2
 * Email musktime@gmail.com
 * Blog http://blog.csdn.net/musk_time
 * GitHub https://github.com/musktime
 */
public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private DemoAdapter mAdapter;

    private int[] colors = {android.R.color.holo_green_dark, android.R.color.holo_blue_dark,
            android.R.color.holo_red_dark};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv);
        final GridLayoutManager glManager = new GridLayoutManager(this, 2);
        glManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int type = mRecyclerView.getAdapter().getItemViewType(position);
                if (type == DemoAdapter.TYPE_THREE) {
                    return glManager.getSpanCount();
                } else {
                    return 1;
                }
            }
        });
        mRecyclerView.setLayoutManager(glManager);
        mAdapter = new DemoAdapter(this);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                GridLayoutManager.LayoutParams params = (GridLayoutManager.LayoutParams) view.getLayoutParams();
                int spanSize = params.getSpanSize();
                int spanIndex = params.getSpanIndex();
                outRect.top = 20;
                if (spanSize != glManager.getSpanCount()) {
                    if (spanIndex == 0) {
                        outRect.right = 10;
                    } else {
                        outRect.left = 10;
                    }
                }
            }
        });
        initData();
    }

    private void initData() {
        List<DataModelOne> dataList1 = new ArrayList<DataModelOne>();
        for (int i = 0; i < 10; i++) {
            DataModelOne model = new DataModelOne();
            model.avatarColor = colors[0];
            model.name = "name:" + i;
            dataList1.add(model);
        }
        List<DataModelTwo> dataList2 = new ArrayList<DataModelTwo>();
        for (int i = 0; i < 10; i++) {
            DataModelTwo model = new DataModelTwo();
            model.avatarColor = colors[1];
            model.name = "name:" + i;
            model.content = "content:" + i;
            dataList2.add(model);
        }
        List<DataModelThree> dataList3 = new ArrayList<DataModelThree>();
        for (int i = 0; i < 10; i++) {
            DataModelThree model = new DataModelThree();
            model.avatarColor = colors[2];
            model.name = "name:" + i;
            model.content = "content" + i;
            model.contentColor = colors[2];
            dataList3.add(model);
        }
        mAdapter.addList(dataList1, dataList2, dataList3);
        mAdapter.notifyDataSetChanged();
    }
}