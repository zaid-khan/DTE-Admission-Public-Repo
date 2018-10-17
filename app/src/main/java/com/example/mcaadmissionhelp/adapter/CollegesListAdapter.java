package com.example.mcaadmissionhelp.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mcaadmissionhelp.R;
import com.example.mcaadmissionhelp.database.College;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CollegesListAdapter extends RecyclerView.Adapter<CollegesListAdapter.ViewCollegesListHolder> {


    private College[] colleges;

    public CollegesListAdapter(College[] colleges) {
        this.colleges = colleges;
    }

    @NonNull
    @Override
    public ViewCollegesListHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_college_list, viewGroup, false);
        return new CollegesListAdapter.ViewCollegesListHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewCollegesListHolder holder, int i) {
        holder.CollegeName.setText(colleges[i].getCollegeName());
        holder.CollegeType.setText(colleges[i].getType());
        holder.CollegeIntake.setText(String.format("Intake : %s", colleges[i].getIntake()));
    }

    @Override
    public int getItemCount() {
        return colleges.length;
    }

    class ViewCollegesListHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.college_name)
        TextView CollegeName;
        @BindView(R.id.college_type)
        TextView CollegeType;
        @BindView(R.id.college_intake)
        TextView CollegeIntake;

        ViewCollegesListHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
