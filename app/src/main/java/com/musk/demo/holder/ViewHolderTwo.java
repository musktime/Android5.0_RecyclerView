package com.musk.demo.holder;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.musk.demo.R;
import com.musk.demo.model.DataModelTwo;

/**
 * Created by Musk 2017/4/3
 * Email musktime@gmail.com
 * Blog http://blog.csdn.net/musk_time
 * GitHub https://github.com/musktime
 */
public class ViewHolderTwo extends AbstractViewHolder<DataModelTwo> {

    public ImageView avatar;
    public TextView name;
    public TextView content;

    public ViewHolderTwo(View itemView) {
        super(itemView);
        avatar = (ImageView) itemView.findViewById(R.id.avatar);
        name = (TextView) itemView.findViewById(R.id.name);
        content = (TextView) itemView.findViewById(R.id.content);
        itemView.setBackgroundColor(Color.GRAY);
    }

    @Override
    public void bindHolder(DataModelTwo model) {
        avatar.setBackgroundResource(model.avatarColor);
        name.setText(model.name);
        content.setText(model.content);
    }
}
