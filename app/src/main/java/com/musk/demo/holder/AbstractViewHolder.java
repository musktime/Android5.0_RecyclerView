package com.musk.demo.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Musk 2017/4/3
 * Email musktime@gmail.com
 * Blog http://blog.csdn.net/musk_time
 * GitHub https://github.com/musktime
 */

public abstract class AbstractViewHolder<T> extends RecyclerView.ViewHolder {

    public AbstractViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bindHolder(T model);
}