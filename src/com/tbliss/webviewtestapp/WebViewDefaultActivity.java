package com.tbliss.webviewtestapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

@SuppressLint("SetJavaScriptEnabled")
public class WebViewDefaultActivity extends Activity {
	
	private WebView webView;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.webview);
		
		webView = (WebView) findViewById(R.id.webview_layout_default);
		webView.getSettings().setJavaScriptEnabled(true);
		Bundle extras = getIntent().getExtras(); 
		if(extras !=null) {
		    String url = extras.getString("url");
		    webView.loadUrl(url);
		} else {
			webView.loadUrl("http://www.finance.yahoo.com");
		}
	}
}
