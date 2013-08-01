package com.example.zipsearch_call;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MainActivity extends Activity {

	private final static int REQUEST_ZIPSEARCH = 101;

	TextView textViewZip;
	TextView textViewPref;
	TextView textViewAddress;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		textViewZip = (TextView) findViewById(R.id.textViewZip);
		textViewPref = (TextView) findViewById(R.id.textViewPref);
		textViewAddress = (TextView) findViewById(R.id.textViewAddress);
		findViewById(R.id.buttonCall).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				callZipSearch();
			}
		});
	}

	private void callZipSearch() {
		Intent intent = new Intent("com.luckofwise.zipsearch.ACTION_SEARCH");
		startActivityForResult(intent, REQUEST_ZIPSEARCH);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == REQUEST_ZIPSEARCH && resultCode == RESULT_OK) {
			textViewZip.setText(data.getStringExtra("extra.ZIP"));
			textViewPref.setText(data.getStringExtra("extra.PREF"));
			textViewAddress.setText(data.getStringExtra("extra.ADDRESS"));
		}
	}

}
