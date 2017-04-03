package com.musk.demo.holder;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.musk.demo.R;
import com.musk.demo.model.DataModelOne;

/**
 * Created by Musk 2017/4/3
 * Email musktime@gmail.com
 * Blog http://blog.csdn.net/musk_time
 * GitHub https://github.com/musktime
 */
public class ViewHolderOne extends AbstractViewHolder<DataModelOne> {

    public ImageView avatar;
    public TextView name;

    public ViewHolderOne(View itemView) {
        super(itemView);
        avatar = (ImageView) itemView.findViewById(R.id.avatar);
        name = (TextView) itemView.findViewById(R.id.name);
        itemView.setBackgroundColor(Color.DKGRAY);
    }

    @Override
    public void bindHolder(DataModelOne model) {
        avatar.setBackgroundResource(model.avatarColor);
        name.setText(model.name);
    }
}
