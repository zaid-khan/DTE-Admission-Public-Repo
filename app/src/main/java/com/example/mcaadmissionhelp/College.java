package com.example.mcaadmissionhelp;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.example.mcaadmissionhelp.adapter.CollegesListAdapter;
import com.example.mcaadmissionhelp.adapter.FCListAdapter;
import com.example.mcaadmissionhelp.util.URLs;
import com.example.mcaadmissionhelp.util.ViewFilesDividerItemDecoration;
import com.example.mcaadmissionhelp.util.VolleySingleton;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class College extends AppCompatActivity {

    @BindView(R.id.attendees_list)
    RecyclerView mCollegesRecyclerView;
    @BindView(R.id.progress_bar)
    ProgressBar mProgressBar;
    private CollegesListAdapter mCollegesListAdapter;
    private FCListAdapter mFcListAdapter;
    private ActionBar mActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_college);
        mActionBar = getSupportActionBar();
        ButterKnife.bind(this);
        int flag = getIntent().getIntExtra("Flag", 0);
        switch (flag) {
            case 1:
                getColleges();
                break;
            case 2:
                getFCs();
                mActionBar.setTitle("FC List");
                break;
            case 3:
                getARCs();
                mActionBar.setTitle("ARC List");
                break;
        }
    }

    private void getColleges() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URLs.URL_COLLEGES,
                response -> {

                    try {
                        Log.d("res", "onResponse: " + response);
                        JSONObject obj = new JSONObject(response);
                        Gson gson = new Gson();
                        com.example.mcaadmissionhelp.database.College[] colleges = gson.fromJson(obj.getJSONArray("Users").toString(), com.example.mcaadmissionhelp.database.College[].class);
                        mCollegesListAdapter = new CollegesListAdapter(colleges);
                        mCollegesRecyclerView.setAdapter(mCollegesListAdapter);
                        mCollegesRecyclerView.addItemDecoration(new ViewFilesDividerItemDecoration(getApplicationContext()));
                        mProgressBar.setVisibility(View.GONE);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                },
                error -> Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show()) {

            @Override
            protected Map<String, String> getParams() {
                return new HashMap<>();
            }

        };
        VolleySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);
    }


    private void getFCs() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URLs.URL_FCS,
                response -> {

                    try {
                        Log.d("res", "onResponse: " + response);
                        JSONObject obj = new JSONObject(response);
                        Gson gson = new Gson();
                        com.example.mcaadmissionhelp.database.FC[] fcs = gson.fromJson(obj.getJSONArray("FCs").toString(), com.example.mcaadmissionhelp.database.FC[].class);
                        mFcListAdapter = new FCListAdapter(fcs);
                        mCollegesRecyclerView.setAdapter(mFcListAdapter);
                        mCollegesRecyclerView.addItemDecoration(new ViewFilesDividerItemDecoration(getApplicationContext()));
                        mProgressBar.setVisibility(View.GONE);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                },
                error -> Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show()) {

            @Override
            protected Map<String, String> getParams() {
                return new HashMap<>();
            }

        };
        VolleySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);
    }

    private void getARCs() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URLs.URL_ARCS,
                response -> {

                    try {
                        Log.d("res", "onResponse: " + response);
                        JSONObject obj = new JSONObject(response);
                        Gson gson = new Gson();
                        com.example.mcaadmissionhelp.database.FC[] fcs = gson.fromJson(obj.getJSONArray("ARCs").toString(), com.example.mcaadmissionhelp.database.FC[].class);
                        mFcListAdapter = new FCListAdapter(fcs);
                        mCollegesRecyclerView.setAdapter(mFcListAdapter);
                        mCollegesRecyclerView.addItemDecoration(new ViewFilesDividerItemDecoration(getApplicationContext()));
                        mProgressBar.setVisibility(View.GONE);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                },
                error -> Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show()) {

            @Override
            protected Map<String, String> getParams() {
                return new HashMap<>();
            }

        };
        VolleySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);
    }

}
