package com.myapp.zarnimyosettwin.dynamicloadrecyclertest.viewholders;

import android.view.View;
import android.widget.TextView;

import com.myapp.zarnimyosettwin.dynamicloadrecyclertest.R;
import com.myapp.zarnimyosettwin.dynamicloadrecyclertest.models.EmployeeListItem;

import butterknife.BindView;

public class EmployeeViewHolder extends BaseViewHolder<EmployeeListItem> {
    @BindView(R.id.txt_employee_name)
    TextView txtEmpName;
    @BindView(R.id.txt_employee_email)
    TextView txtEmpEmail;
    @BindView(R.id.txt_employee_phone)
    TextView txtEmpPhone;

    public EmployeeViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(EmployeeListItem data) {
        txtEmpEmail.setText(data.getEmail());
        txtEmpName.setText(data.getName());
        txtEmpPhone.setText(data.getPhone());
    }

    @Override
    public void onClick(View v) {

    }
}
