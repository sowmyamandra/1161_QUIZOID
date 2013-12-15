package com.example.knowledgegame;

import java.io.IOException;
import java.util.ArrayList;

import javax.security.auth.Destroyable;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class Demo extends Activity {

	Dbhandler myDbHelper;
	SQLiteDatabase Mydatabase;
	ArrayList<String> aa;
	String s1, s2, s3, s4, s5, s6, ans="";
	// String s1="a",s2="d",s3="d",s4="e",s5="r",s6="f",ans="3";
	static int count = 0, temp;
	static int level = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.questions);
		Button btn1=(Button)findViewById(R.id.button2);
		Button btn = (Button) findViewById(R.id.button1);
		TextView tv = (TextView) findViewById(R.id.textView1);
		TextView tv1 = (TextView) findViewById(R.id.textView2);
		tv1.setVisibility(3);
		System.out.println("level............."+level);
		tv1.setText("LEVEL1 STARTED");
		RadioGroup group = (RadioGroup) findViewById(R.id.radioGroup1);
		final RadioButton rb = (RadioButton) findViewById(R.id.radio0);
		final RadioButton rb1 = (RadioButton) findViewById(R.id.radio1);
		final RadioButton rb2 = (RadioButton) findViewById(R.id.radio2);
		final RadioButton rb3 = (RadioButton) findViewById(R.id.radioButton1);
		this.myDbHelper = new Dbhandler(this);
		FetchingData();
		Mydatabase = myDbHelper.getReadableDatabase();
		System.out.println("hhhhhhhhhhhhhh" + temp + "fdsfgfff" + count);
		String s = "";

		if (count >= 0 && count < 5 || temp == 0 || level == 1) {
			level = 1;
			s = myDbHelper.Retrieval(Mydatabase, level);

		}

		if (count >= 5 && count <= 10 || temp >= 10 || level == 2) {
			if (count == 5) {
				final Dialog dialog = new Dialog(Demo.this);
				dialog.setContentView(R.layout.level2);

				dialog.setTitle("Level 2");
				Button b = (Button) dialog.findViewById(R.id.button1);
				b.setText("Start 2 level");
				Button dbut = (Button) dialog.findViewById(R.id.button2);

				dbut.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						dialog.dismiss();
					}
				});
				dialog.show();
			}
			tv1.setText("LEVEL2 STARTED");
			level = 1;
			level++;

			s = myDbHelper.Retrieval(Mydatabase, level);

		}
		if (count >= 10 && count <= 15) {
			if (count == 10) {
				final Dialog dialog = new Dialog(Demo.this);
				dialog.setContentView(R.layout.level2);
				dialog.setTitle("Level 3");
				Button b = (Button) dialog.findViewById(R.id.button1);
				b.setText("Start Level 3");
				Button dbut = (Button) dialog.findViewById(R.id.button2);

				dbut.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						dialog.dismiss();
					}
				});
				dialog.show();
			}


			tv1.setText("LEVEL3 STARTED");
			level = 2;
			level++;

			s = myDbHelper.Retrieval(Mydatabase, level);
		}
		if (count >= 15 && count <= 20) {
			if (count == 15) {
				final Dialog dialog = new Dialog(Demo.this);
				dialog.setContentView(R.layout.level2);
				dialog.setTitle("Level 4");
				Button b = (Button) dialog.findViewById(R.id.button1);
				b.setText("Start Level 4");
				Button dbut = (Button) dialog.findViewById(R.id.button2);

				dbut.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						dialog.dismiss();
					}
				});
				dialog.show();
			}

			tv1.setText("LEVEL4 STARTED");
			level = 3;
			level++;

			s = myDbHelper.Retrieval(Mydatabase, level);
		}
		if(count>=20)
		{
			final Dialog dialog = new Dialog(Demo.this);
			dialog.setContentView(R.layout.level2);

			dialog.setTitle("Knowledge Game");
			Button b = (Button) dialog.findViewById(R.id.button1);
			b.setText("you did it");
			Button ok = (Button) dialog.findViewById(R.id.button2);

			ok.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
					dialog.dismiss();
					moveTaskToBack(true);
				
					
					
				}
			});
			dialog.show();
		}
		btn1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				count=0;
				temp=0;
				level=1;
				Intent it=new Intent( Demo.this,GameActivity.class);
				startActivity(it);
				 Demo.this.finish();
			moveTaskToBack(true);
			}
		});
		
		

//		if (count >= 20) {
//			
//			if(count==20){
//
//			final Dialog dialog = new Dialog(Demo.this);
//			dialog.setContentView(R.layout.level2);
//			dialog.setTitle("Level 5");
//			Button b = (Button) dialog.findViewById(R.id.button1);
//			b.setText("Start Level 5");
//			Button dbut = (Button) dialog.findViewById(R.id.button2);
//
//			dbut.setOnClickListener(new OnClickListener() {
//
//				@Override
//				public void onClick(View v) {
//					// TODO Auto-generated method stub
//					Intent in = new Intent(Demo.this, Image.class);
//					startActivity(in);
//				}
//			});
//			dialog.show();
//			}
//		}

		// final String s="sa,dg,dg,ht,th,ju";
		// tv.setText(s);
		String[] ar = s.split(",");

		for (int i = 0; i < ar.length; i++) {
			s1 = ar[0];
			s2 = ar[1];
			s3 = ar[2];
			s4 = ar[3];
			s5 = ar[4];
			s6 = ar[5];

		}
		// Toast.makeText(getApplicationContext(), s6, 60).show();
		tv.setText(s1);
		rb.setText(s2);
		rb1.setText(s3);
		rb2.setText(s4);
		rb3.setText(s5);

		group.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				try {

					if (group.getCheckedRadioButtonId() != -1) {
						int id = group.getCheckedRadioButtonId();
						View radioButton = group.findViewById(id);
						int radioId = group.indexOfChild(radioButton);
						RadioButton btn = (RadioButton) group
								.getChildAt(radioId);
						ans = (String) btn.getText();

					}

				} catch (Exception e) {
					// TODO: handle exception
					Toast.makeText(getApplicationContext(),
							"plese select any one", 60).show();

				}
			}
		});

		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(ans==null || ans=="")
				{
					Toast.makeText(getApplicationContext(),
							"plese select any one", 60).show();
				}
				if (ans.equalsIgnoreCase(s6)) {
					// Toast.makeText(getApplicationContext(),
					// "correct"+count,60).show();
					count++;
					temp = count;
					MediaPlayer mp = MediaPlayer.create(Demo.this, R.raw.aps);
					mp.start();
					Intent it = new Intent(Demo.this, Demo.class);
					startActivity(it);
				} else if(ans!=""){
					// Toast.makeText(getApplicationContext(),
					// "incorrect",60).show();
					level = 1;
					temp = count;
					Intent it = new Intent(Demo.this, Answer.class);
					startActivity(it);
				}

			}
		});

	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		
		
		super.onDestroy();
	}

	@Override
	

	public boolean onKeyDown(int keyCode, KeyEvent event) {
		/*if (Integer.parseInt(android.os.Build.VERSION.SDK) < 5
				&& keyCode == KeyEvent.KEYCODE_BACK
				&& event.getRepeatCount() == 0) {
			Log.d("CDA", "onKeyDown Called");
			onBackPressed();
		}*/

		return super.onKeyDown(keyCode, event);
	}

	public void onBackPressed() {
		Log.d("CDA", "onBackPressed Called");
		Intent setIntent = new Intent(Intent.ACTION_MAIN);
		setIntent.addCategory(Intent.CATEGORY_HOME);
		setIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		startActivity(setIntent);

		return;
	}

	private void FetchingData() {

		// TODO Auto-generated method stub
		try {

			myDbHelper.onCreateDataBase();

		} catch (IOException ioe) {

			throw new Error("Unable to create database");

		}
		try {

			myDbHelper.openDataBase();
			Mydatabase = myDbHelper.getWritableDatabase();
			System.out.println("executed");

		} catch (SQLException sqle) {

			throw sqle;

		}
	}

}
