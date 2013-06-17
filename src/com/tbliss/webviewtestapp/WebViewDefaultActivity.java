package com.tbliss.webviewtestapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;

@SuppressLint("SetJavaScriptEnabled")
public class WebViewDefaultActivity extends Activity {
	private static final String LOG_TAG = "WebViewDefaultActivity";

	private WebView webView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.webview);
		
		webView = (WebView) findViewById(R.id.webview_layout_default);
		
		Bundle extras = getIntent().getExtras();
		if (extras.getBoolean("javascript")) {
			Log.i(LOG_TAG, "Enabling Javascript");
			webView.getSettings().setJavaScriptEnabled(true);
		}
		if (extras.getBoolean("domStorage")) {
			Log.i(LOG_TAG, "Enabling DOM storage");
			webView.getSettings().setDomStorageEnabled(true);
		}
		if (extras.getBoolean("appCache")) {
			Log.i(LOG_TAG, "Enabling AppCache");
			webView.getSettings().setAppCacheMaxSize(1024*1024*8); // cache size to 8mb
			String appCachePath = getApplicationContext().getCacheDir().getAbsolutePath();
			webView.getSettings().setAppCachePath(appCachePath);
			webView.getSettings().setAllowFileAccess(true);
			webView.getSettings().setAppCacheEnabled(true);
		}
		
		String url = extras.getString("url");
		webView.loadUrl(url);
	}
}
