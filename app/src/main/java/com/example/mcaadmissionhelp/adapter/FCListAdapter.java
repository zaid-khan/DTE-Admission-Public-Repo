package com.example.mcaadmissionhelp.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mcaadmissionhelp.R;
import com.example.mcaadmissionhelp.database.FC;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FCListAdapter extends RecyclerView.Adapter<FCListAdapter.ViewFCsListHolder> {

    private FC[] fcs;

    public FCListAdapter(FC[] fcs) {
        this.fcs = fcs;
    }

    @NonNull
    @Override
    public ViewFCsListHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_fc_list, viewGroup, false);
        return new FCListAdapter.ViewFCsListHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewFCsListHolder holder, int i) {
        holder.FCName.setText(String.format("%s - %s", fcs[i].getCode(), fcs[i].getCollegeName()));
        holder.FCAddress.setText(fcs[i].getAddress());
    }

    @Override
    public int getItemCount() {
        return fcs.length;
    }


    class ViewFCsListHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.fc_name)
        TextView FCName;
        @BindView(R.id.fc_address)
        TextView FCAddress;

        ViewFCsListHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
