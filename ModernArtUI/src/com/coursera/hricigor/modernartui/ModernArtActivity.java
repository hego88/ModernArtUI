package com.coursera.hricigor.modernartui;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class ModernArtActivity extends Activity implements
		OnSeekBarChangeListener {
	private static final String TAG = ModernArtActivity.class.getName();

	private static SeekBar mSeekBar;

	private static List<View> mListView;
	private static LinearLayout mLinearLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.modern_art_layout);

		mLinearLayout = (LinearLayout) findViewById(R.id.linear_layout);

		mSeekBar = (SeekBar) findViewById(R.id.seekBar);
		mSeekBar.setMax(255);
		mSeekBar.setOnSeekBarChangeListener(this);

		mListView = new ArrayList<View>();
		addViewsToList();

		changeColor(0);
	}

	
	public void addViewsToList() {
		mListView.add(findViewById(R.id.view1));
		mListView.add(findViewById(R.id.view2));
		mListView.add(findViewById(R.id.view3));
		mListView.add(findViewById(R.id.view4));
		mListView.add(findViewById(R.id.view5));
		mListView.add(findViewById(R.id.view6));
		mListView.add(findViewById(R.id.view7));
		mListView.add(findViewById(R.id.view8));
		mListView.add(findViewById(R.id.view9));
	}
	
	// Changing color acorgint to SeekBar position
	public void changeColor(int progress) {

		mLinearLayout.setBackgroundColor(Color.rgb(0 + progress, 0 + progress,
				0 + progress));

		mListView.get(0).setBackgroundColor(
				Color.rgb(0 + progress, 0 + progress, 255 - progress));
		mListView.get(1).setBackgroundColor(
				Color.rgb(255 - progress, 255 - progress, 0 + progress));
		mListView.get(2).setBackgroundColor(
				Color.rgb(0 + progress, 0 + progress, 255 - progress));

		mListView.get(3).setBackgroundColor(
				Color.rgb(255 - progress, 255 - progress, 0 + progress));
		mListView.get(4).setBackgroundColor(Color.rgb(255, 255, 255));
		mListView.get(5).setBackgroundColor(
				Color.rgb(255 - progress, 255 - progress, 0 + progress));

		mListView.get(6).setBackgroundColor(
				Color.rgb(0 + progress, 0 + progress, 255 - progress));
		mListView.get(7).setBackgroundColor(
				Color.rgb(255 - progress, 255 - progress, 0 + progress));
		mListView.get(8).setBackgroundColor(
				Color.rgb(0 + progress, 0 + progress, 255 - progress));

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == R.id.more_information) {
			new ModernArtDialog().show(getFragmentManager(), TAG);
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onProgressChanged(SeekBar seekBar, int progress,
			boolean fromUser) {
		changeColor(progress);
	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub

	}
}
