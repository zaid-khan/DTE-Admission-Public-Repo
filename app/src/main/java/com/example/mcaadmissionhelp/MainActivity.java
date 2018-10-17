package com.example.mcaadmissionhelp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.faq)
    void onFaqClick() {
        Intent intent = new Intent(this, FAQ.class);
        startActivity(intent);
    }

    @OnClick(R.id.card_colleges)
    void onCollegesClick() {
        Intent intent = new Intent(this, College.class);
        startActivity(intent);
    }

    @OnClick(R.id.card_ask_questions)
    void onAskQuestionClick() {
        Intent intent = new Intent(this, AskQuestions.class);
        startActivity(intent);
    }


}
