package com.myapp.zarnimyosettwin.dynamicloadrecyclertest.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by ZNMSW on 16/3/18.
 */

public abstract class BaseViewHolder<W> extends RecyclerView.ViewHolder implements View.OnClickListener {

    private W mData;

    public BaseViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView); // here we change
        itemView.setOnClickListener(this);
    }

    public abstract void setData(W data);
}
