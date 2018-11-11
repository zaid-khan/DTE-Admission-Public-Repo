package com.example.mcaadmissionhelp;

import android.net.http.SslError;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.example.mcaadmissionhelp.util.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WebViewActivity extends AppCompatActivity {

    @BindView(R.id.web_view)
    WebView mWebView;
    private String Url;
    private ActionBar mActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        mActionBar = getSupportActionBar();
        ButterKnife.bind(this);
        int flag = getIntent().getIntExtra(Constants.FLAG, Constants.DEFAULT_FLAG);
        mWebView.getSettings().setJavaScriptEnabled(true);

        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return false;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                if (flag == 3) {
                    mWebView.loadUrl("javascript:document.getElementsByClassName('content2').scrollIntoView();");
                } else {
                    mWebView.loadUrl("javascript:document.getElementById('content').scrollIntoView();");
                }
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                if (handler != null) {
                    handler.proceed();
                } else {
                    super.onReceivedSslError(view, null, error);
                }
            }
        });
        switch (flag) {
            case 1:
                Url = "https://mca18.dtemaharashtra.org/mca18/index.php/hp_controller/fees";
                // Url="https://retail.onlinesbi.com/retail/login.htm";
                mActionBar.setTitle(getString(R.string.fees));

                //mWebView.loadUrl("javascript:document.getElementById('content').scrollIntoView();");
                break;
            case 2:
                Url = "https://mca18.dtemaharashtra.org/mca18/index.php/hp_controller/impDates";
                mActionBar.setTitle(getString(R.string.important_dates));
                break;
            case 3:
                Url = "https://mca18.dtemaharashtra.org/mca18/index.php";
                mActionBar.setTitle(getString(R.string.latest_notification));
                break;
            case 4:
                Url = "https://mca18.dtemaharashtra.org/mca18/index.php/hp_controller/fn_nri";
                mActionBar.setTitle(getString(R.string.j_k_and_nri_candidates));
                break;
            case 5:
                Url = "file:///android_asset/aboutussections/index.html";
                mActionBar.setTitle(getString(R.string.developers));
                break;
            case 6:
                Url = "file:///android_asset/aboutussections/contactdte.html";
                mActionBar.setTitle(getString(R.string.contact_dte));
                break;

        }
        mWebView.loadUrl(Url);
    }
}
