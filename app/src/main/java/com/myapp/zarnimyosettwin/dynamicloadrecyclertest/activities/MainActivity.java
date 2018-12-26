package com.myapp.zarnimyosettwin.dynamicloadrecyclertest.activities;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.myapp.zarnimyosettwin.dynamicloadrecyclertest.R;
import com.myapp.zarnimyosettwin.dynamicloadrecyclertest.adapters.EmployeeAdapter;
import com.myapp.zarnimyosettwin.dynamicloadrecyclertest.models.BaseModel;
import com.myapp.zarnimyosettwin.dynamicloadrecyclertest.models.EmployeeListItem;
import com.myapp.zarnimyosettwin.dynamicloadrecyclertest.models.NetworkResponse;
import com.myapp.zarnimyosettwin.dynamicloadrecyclertest.network.RetrofitBuilder;
import com.myapp.zarnimyosettwin.dynamicloadrecyclertest.utils.Loading;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.recycler_view_employee_list)
    RecyclerView recyclerView;
    private EmployeeAdapter employeeAdapter;
    List<EmployeeListItem> employeeListItemsFromNetwork = new ArrayList<>();
    List<EmployeeListItem> employeeListItemsToBind = new ArrayList<>();
    List<EmployeeListItem> tempList = new ArrayList<>();
    int fromIndex = 0, toIndex = 2;
    Timer buttonTimer = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onBindUI();
        getQuestionFromNetwork(123);
    }

    private void timer() {

        buttonTimer.schedule(new TimerTask() {

            @Override
            public void run() {
                runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        fromIndex += 2;
                        toIndex += 2;
                        if (toIndex <= employeeListItemsFromNetwork.size()) {
                            tempList = employeeListItemsFromNetwork.subList(fromIndex, toIndex); // add to temp list
                            employeeListItemsToBind.clear(); // clear previous data
                            for (EmployeeListItem employeeListItem : tempList) {
                                employeeListItemsToBind.add(employeeListItem); // add to list that will be bind with RecyclerView
                            }
                            employeeAdapter.notifyDataSetChanged();
                            timer();
                        } else {
                            buttonTimer.cancel();
                            Toast.makeText(getApplicationContext(), "No more Data", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
            }
        }, 3000);
    }

    private void onBindUI() {
        ButterKnife.bind(this, this);
        employeeAdapter = new EmployeeAdapter(getApplicationContext(), employeeListItemsToBind);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setHasFixedSize(false);
        recyclerView.setAdapter(employeeAdapter);

    }

    private void getQuestionFromNetwork(int id) {
        RetrofitBuilder.buildRetrofit();
        Loading.showLoading(MainActivity.this);
        Call<NetworkResponse> call = RetrofitBuilder.api.getQuestion(id);
        call.enqueue(new Callback<NetworkResponse>() {
            @Override
            public void onResponse(Call<NetworkResponse> call, Response<NetworkResponse> response) {
                //Log.e("Response", response.body() + "");
                Loading.hideLoading(MainActivity.this);

                employeeListItemsFromNetwork.clear();
                employeeListItemsFromNetwork = response.body().getEmployeeList(); // list from network
                tempList = employeeListItemsFromNetwork.subList(fromIndex, toIndex); // add to temp list

                employeeListItemsToBind.clear(); // clear previous data
                for (EmployeeListItem employeeListItem : tempList) {
                    employeeListItemsToBind.add(employeeListItem); // add to list that will be bind with RecyclerView
                }
                employeeAdapter.notifyDataSetChanged();
                timer(); // to load with time interval to show
            }

            @Override
            public void onFailure(Call<NetworkResponse> call, Throwable t) {
                Loading.hideLoading(MainActivity.this);
                Log.e("Error", t + "");
            }
        });
    }
}
