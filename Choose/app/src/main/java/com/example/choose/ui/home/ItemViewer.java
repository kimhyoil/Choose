package com.example.choose.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.choose.R;

public class ItemViewer extends LinearLayout {
    TextView title, desc;
    ImageView imageView;

    public ItemViewer(Context context) {
        super(context);
        init(context);
    }

    public void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.item_giftlist, this, true);
        title = (TextView) findViewById(R.id.item_title);
        desc = (TextView) findViewById(R.id.item_desc);
        imageView = (ImageView) findViewById(R.id.item_image);
    }

    public void setItem(ItemData item) {
        title.setText(item.getName());
        desc.setText(item.getDesc());
        imageView.setImageResource(Integer.parseInt(item.getImage()));
    }
}
