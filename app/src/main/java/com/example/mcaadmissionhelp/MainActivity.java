package com.example.mcaadmissionhelp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.mcaadmissionhelp.util.Constants;

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
        intent.putExtra("Flag", 1);
        startActivity(intent);
    }

    @OnClick(R.id.card_fc)
    void onFCsClick() {
        Intent intent = new Intent(this, College.class);
        intent.putExtra("Flag", 2);
        startActivity(intent);
    }

    @OnClick(R.id.card_arc)
    void onARCsClick() {
        Intent intent = new Intent(this, College.class);
        intent.putExtra("Flag", 3);
        startActivity(intent);
    }

    @OnClick(R.id.card_ask_questions)
    void onAskQuestionClick() {
        Intent intent = new Intent(this, AskQuestions.class);
        startActivity(intent);
    }

    @OnClick(R.id.card_fees)
    void onFeesClick() {
        Intent intent = new Intent(this, WebViewActivity.class);
        intent.putExtra(Constants.FLAG, Constants.FEES_FLAG);
        startActivity(intent);
    }

    @OnClick(R.id.card_imp_dates)
    void onImpDatesClick() {
        Intent intent = new Intent(this, WebViewActivity.class);
        intent.putExtra(Constants.FLAG, Constants.IMP_DATES_FLAG);
        startActivity(intent);
    }

    @OnClick(R.id.card_admission_steps)
    void onAdmissionStepsClick() {
        Intent intent = new Intent(this, AdmissionProcess.class);
        startActivity(intent);
    }

    @OnClick(R.id.card_latest_notification)
    void onNotificationClick() {
        Intent intent = new Intent(this, WebViewActivity.class);
        intent.putExtra(Constants.FLAG, Constants.NOTIFICATION_FLAG);
        startActivity(intent);
    }

    @OnClick(R.id.card_jk_nri)
    void onJkNriClick() {
        Intent intent = new Intent(this, WebViewActivity.class);
        intent.putExtra(Constants.FLAG, Constants.JK_NRI_FLAG);
        startActivity(intent);
    }

    @OnClick(R.id.developers)
    void onDevelopersClick() {
        Intent intent = new Intent(this, WebViewActivity.class);
        intent.putExtra(Constants.FLAG, Constants.DEVELOPERS_FLAG);
        startActivity(intent);
    }

    @OnClick(R.id.card_contact_dte)
    void onContactDTEClick() {
        Intent intent = new Intent(this, WebViewActivity.class);
        intent.putExtra(Constants.FLAG, Constants.CONTACT_DTE_FLAG);
        startActivity(intent);
    }

    @OnClick(R.id.card_allotment)
    void onInstituteWiseAllotmentClick() {
        Intent intent = new Intent(this, WebViewActivity.class);
        intent.putExtra(Constants.FLAG, Constants.INSTITUTE_WISE_ALLOTMENT);
        startActivity(intent);
    }

    @OnClick(R.id.card_eligibility)
    void onEligibiltyClick() {
        Intent intent = new Intent(this, WebViewActivity.class);
        intent.putExtra(Constants.FLAG, Constants.ELIGIBILITY);
        startActivity(intent);
    }
}
