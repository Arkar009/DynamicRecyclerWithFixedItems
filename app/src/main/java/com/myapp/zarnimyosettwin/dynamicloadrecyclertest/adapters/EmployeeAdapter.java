package com.myapp.zarnimyosettwin.dynamicloadrecyclertest.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.myapp.zarnimyosettwin.dynamicloadrecyclertest.R;
import com.myapp.zarnimyosettwin.dynamicloadrecyclertest.models.BaseModel;
import com.myapp.zarnimyosettwin.dynamicloadrecyclertest.models.EmployeeListItem;
import com.myapp.zarnimyosettwin.dynamicloadrecyclertest.viewholders.BaseViewHolder;
import com.myapp.zarnimyosettwin.dynamicloadrecyclertest.viewholders.EmployeeViewHolder;

import java.util.List;

public class EmployeeAdapter extends BaseRecyclerAdapter<BaseViewHolder, BaseModel> {
    List<EmployeeListItem> employeeListItems;
    public EmployeeAdapter(Context context, List<EmployeeListItem> employeeListItems) {
        super(context);
        this.employeeListItems = employeeListItems;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_employee, parent, false);
        return new EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.setData(employeeListItems.get(position));
    }

    @Override
    public int getItemCount() {
        return employeeListItems.size();
    }
}
