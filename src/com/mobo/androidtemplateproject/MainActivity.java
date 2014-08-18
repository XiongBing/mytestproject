package com.mobo.androidtemplateproject;
//added something in project3 while the submodule not updated and project2 submodule changed but not project2 not pushed
//added more (after project2 has updated submodule and project3 will not change submodule)    
import java.util.ArrayList;
import java.util.Arrays;

import kankan.wheel.widget.WheelView;
import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends Activity {

	private WheelView wheelAge;// 年龄滚轮控件
	private static final ArrayList<String> AGES = new ArrayList<String>(Arrays.asList("5","6","7","8","9"));
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);
		
		Button btn = (Button) findViewById(R.id.btn_wheel);
		btn.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View arg0) {
				final Dialog diaHappyAge = new Dialog(
						MainActivity.this);
				diaHappyAge.getWindow().requestFeature(
							Window.FEATURE_NO_TITLE);
				diaHappyAge.setCanceledOnTouchOutside(false);
					
				View diaHappyAgeView = LayoutInflater.from(
						MainActivity.this).inflate(
						R.layout.age_dialog_view, null);
				
				wheelAge = (WheelView) diaHappyAgeView
						.findViewById(R.id.age_dialog_wheel);
				
				wheelAge.setVisibleItems(5);
				
				AgeWheelViewAdapter ageWheelAda = new AgeWheelViewAdapter(
						MainActivity.this, AGES);
					
				wheelAge.setViewAdapter(ageWheelAda);

				Button btnConfirm = (Button) diaHappyAgeView
							.findViewById(R.id.btn_confirm_other_age);
					btnConfirm.setOnClickListener(new OnClickListener() {

						@Override
						public void onClick(View arg0) {
							Log.d("MainActivity", "OnClick");
							diaHappyAge.dismiss();
						}
					});

				diaHappyAge.setContentView(diaHappyAgeView);
				diaHappyAge.show();
			}
			
		});
	}
}
