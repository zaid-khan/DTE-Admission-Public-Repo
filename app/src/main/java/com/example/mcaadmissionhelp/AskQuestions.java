package com.example.mcaadmissionhelp;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mcaadmissionhelp.util.Constants;
import com.google.gson.Gson;

import java.util.Collections;
import java.util.List;

import ai.api.AIServiceException;
import ai.api.RequestExtras;
import ai.api.android.AIConfiguration;
import ai.api.android.AIDataService;
import ai.api.android.GsonFactory;
import ai.api.model.AIContext;
import ai.api.model.AIError;
import ai.api.model.AIRequest;
import ai.api.model.AIResponse;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AskQuestions extends AppCompatActivity {

    @BindView(R.id.sendButton)
    ImageButton mSendButton;
    @BindView(R.id.messageEditText)
    EditText mMessageText;
    @BindView(R.id.response)
    TextView mResponse;
    private Gson gson = GsonFactory.getGson();
    private AIDataService aiDataService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_questions);
        ButterKnife.bind(this);
        initService();
    }

    private void initService() {
        final AIConfiguration.SupportedLanguages lang = AIConfiguration.SupportedLanguages.English;
        final AIConfiguration config = new AIConfiguration(Constants.ACCESS_TOKEN,
                lang, AIConfiguration.RecognitionEngine.System);
        aiDataService = new AIDataService(this, config);

    }

    @OnClick(R.id.sendButton)
    void sendRequest() {
        Toast.makeText(getApplicationContext(), "Clicked", Toast.LENGTH_LONG).show();
        final String queryString = mMessageText.getText().toString();
        final AsyncTask<String, Void, AIResponse> task = new AsyncTask<String, Void, AIResponse>() {

            private AIError aiError;

            @Override
            protected AIResponse doInBackground(final String... params) {
                final AIRequest request = new AIRequest();
                String query = params[0];

                if (!TextUtils.isEmpty(query))
                    request.setQuery(query);

                Log.d("Response", gson.toJson(request));
                RequestExtras requestExtras;
                final List<AIContext> contexts = Collections.singletonList(new AIContext("Process"));
                requestExtras = new RequestExtras(contexts, null);

                try {
                    return aiDataService.request(request, requestExtras);
                } catch (final AIServiceException e) {
                    aiError = new AIError(e);
                    return null;
                }
            }

            @Override
            protected void onPostExecute(final AIResponse response) {
                if (response != null) {
                    onResult(response);
                } else {
                    onError(aiError);
                }
            }
        };

        task.execute(queryString);
    }


    private void onResult(final AIResponse response) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Log.d("Response", gson.toJson(response));
                mResponse.setText(gson.toJson(response));

            }

        });
    }

    private void onError(final AIError error) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Log.d("Response", "Error\n" + error.toString());
            }
        });
    }
}
