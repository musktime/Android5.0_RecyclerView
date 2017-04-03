package com.musk.demo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.musk.demo.holder.AbstractViewHolder;
import com.musk.demo.holder.ViewHolderOne;
import com.musk.demo.holder.ViewHolderThree;
import com.musk.demo.holder.ViewHolderTwo;
import com.musk.demo.model.DataModelOne;
import com.musk.demo.model.DataModelThree;
import com.musk.demo.model.DataModelTwo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Musk 2017/4/3
 * Email musktime@gmail.com
 * Blog http://blog.csdn.net/musk_time
 * GitHub https://github.com/musktime
 */
public class DemoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int TYPE_ONE = 1;
    public static final int TYPE_TWO = 2;
    public static final int TYPE_THREE = 3;

    private List<DataModelOne> list1;
    private List<DataModelTwo> list2;
    private List<DataModelThree> list3;

    private LayoutInflater mInflater;
    private List<Integer> types = new ArrayList<>();
    private Map<Integer, Integer> positions = new HashMap<>();

    public DemoAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    public void addList(List<DataModelOne> list1, List<DataModelTwo> list2, List<DataModelThree> list3) {
        addListByType(TYPE_ONE, list1);
        addListByType(TYPE_TWO, list2);
        addListByType(TYPE_THREE, list3);
        this.list1 = list1;
        this.list2 = list2;
        this.list3 = list3;
    }

    private void addListByType(int type, List list) {
        positions.put(type, types.size());
        for (int i = 0; i < list.size(); i++) {
            types.add(type);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return types.get(position);
    }

    @Override
    public int getItemCount() {
        return types.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_ONE:
                return new ViewHolderOne(mInflater.inflate(R.layout.item_one, parent, false));
            case TYPE_TWO:
                return new ViewHolderTwo(mInflater.inflate(R.layout.item_two, parent, false));
            case TYPE_THREE:
                return new ViewHolderThree(mInflater.inflate(R.layout.item_three, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);
        int realPosition = position - positions.get(viewType);
        switch (viewType) {
            case TYPE_ONE:
                ((ViewHolderOne) holder).bindHolder(list1.get(realPosition));
                break;
            case TYPE_TWO:
                ((ViewHolderTwo) holder).bindHolder(list2.get(realPosition));
                break;
            case TYPE_THREE:
                ((ViewHolderThree) holder).bindHolder(list3.get(realPosition));
                break;
        }
    }
}