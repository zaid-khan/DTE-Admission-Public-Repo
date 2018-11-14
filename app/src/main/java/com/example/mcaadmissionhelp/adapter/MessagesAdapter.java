package com.example.mcaadmissionhelp.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.mcaadmissionhelp.R;
import com.example.mcaadmissionhelp.database.Message;

import java.util.List;
import java.util.Objects;


public class MessagesAdapter extends ArrayAdapter<Message> {

    public MessagesAdapter(Context context, int resource, List<Message> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.item_message, parent, false);
        }

        TextView messageTextViewFrom = convertView.findViewById(R.id.messageTextViewFrom);
        TextView messageTextViewTo = convertView.findViewById(R.id.messageTextViewTo);
        CardView toCardView = convertView.findViewById(R.id.cardTo);
        CardView fromCardView = convertView.findViewById(R.id.cardFrom);


        Message message = getItem(position);
        if (Objects.requireNonNull(message).getFromUser() == 0) {
            messageTextViewTo.setText(Objects.requireNonNull(message).getMessage());
            toCardView.setVisibility(View.VISIBLE);
            fromCardView.setVisibility(View.GONE);

        } else {
            messageTextViewFrom.setText(Objects.requireNonNull(message).getMessage());
            fromCardView.setVisibility(View.VISIBLE);
            toCardView.setVisibility(View.GONE);

        }
        return convertView;
    }

}
