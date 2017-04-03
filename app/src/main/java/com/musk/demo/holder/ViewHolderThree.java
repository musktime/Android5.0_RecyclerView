package com.musk.demo.holder;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.musk.demo.R;
import com.musk.demo.model.DataModelThree;

/**
 * Created by Musk 2017/4/3
 * Email musktime@gmail.com
 * Blog http://blog.csdn.net/musk_time
 * GitHub https://github.com/musktime
 */
public class ViewHolderThree extends AbstractViewHolder<DataModelThree> {

    public ImageView avatar;
    public ImageView contentImg;
    public TextView name;
    public TextView content;

    public ViewHolderThree(View itemView) {
        super(itemView);
        avatar = (ImageView) itemView.findViewById(R.id.avatar);
        contentImg = (ImageView) itemView.findViewById(R.id.content_img);
        name = (TextView) itemView.findViewById(R.id.name);
        content = (TextView) itemView.findViewById(R.id.content);
        itemView.setBackgroundColor(Color.GREEN);
    }

    @Override
    public void bindHolder(DataModelThree model) {
        avatar.setBackgroundResource(model.avatarColor);
        name.setText(model.name);
        content.setText(model.content);
        contentImg.setBackgroundResource(model.contentColor);
    }
}
