package com.tbliss.webviewtestapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
	private static final String LOG_TAG = "WebView Test App";

	private Context context;

	private EditText editTextUrl;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		context = this;
		setContentView(R.layout.activity_main);
		editTextUrl = (EditText)findViewById(R.id.editText_url);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	/**
	 * Called when user clicks button to load default WebView. No special settings should be set.
	 */
	public void loadWebviewDefault(View view) {
		String url = getUrl();
		Log.i(LOG_TAG, "Loading default WebView: " + url);

		Intent intent = new Intent(context, WebViewDefaultActivity.class);
		intent.putExtra("url", url);
		startActivity(intent);
	}

	public void loadBrowser(View view) {
		String url = getUrl();
		Log.i(LOG_TAG, "Loading browser: " + url);

		Uri uri = Uri.parse(url);
		Intent intent = new Intent(Intent.ACTION_VIEW, uri);
		startActivity(intent);
	}

	private String getUrl() {
		return editTextUrl.getText().toString();
	}
}
