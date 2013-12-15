package com.example.knowledgegame;

import java.util.Random;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore.Images;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class Image extends Activity {

	ImageView iv;

	TextView tv;
	Images im;
	int check;
	static int n;
	static int score = 0;
	Button high, low, change;
	Context context;
	static int count=0;
	RadioButton rb1, rb2, rb3, rb4;

	String ans = "",temp="";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.image);
		Button btn=(Button)findViewById(R.id.button2);
		tv = (TextView) findViewById(R.id.textV);
		iv=(ImageView)findViewById(R.id.imageView1);
		tv.setText("choose the correct one ?");
		RadioGroup rg=(RadioGroup)findViewById(R.id.radioGroup1);
		
		rb1 = (RadioButton) findViewById(R.id.radio0);
		rb2 = (RadioButton) findViewById(R.id.radio1);
		rb3 = (RadioButton) findViewById(R.id.radio2);
		rb4 = (RadioButton) findViewById(R.id.radio3);
		rg.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				if (group.getCheckedRadioButtonId() != -1) {
					int id = group.getCheckedRadioButtonId();
					View radioButton = group.findViewById(id);
					int radioId = group.indexOfChild(radioButton);
					RadioButton btn = (RadioButton) group.getChildAt(radioId);
					ans = (String) btn.getText();
					

				}				
				
			}
		});
	if(count>=5)
	{
		final Dialog dialog = new Dialog(Image.this);
		dialog.setContentView(R.layout.level2);

		dialog.setTitle("Knowledge Game");
		Button b = (Button) dialog.findViewById(R.id.button1);
		b.setText("you are the winner");
		Button ok = (Button) dialog.findViewById(R.id.button2);

		ok.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				dialog.dismiss();
				Intent in=new Intent(Image.this,GameActivity.class);
				
				startActivity(in);
			
				
				
			}
		});
		dialog.show();
	}
		n = showRandomNum(1, 8);
		if (n == 1) {
		Drawable r = getResources().getDrawable(R.drawable.ame);

			
			rb1.setText("America");
			rb2.setText("uk");
			rb3.setText("India");
			rb4.setText("Landon");
			temp="America";
			
			/*
			if(rb1.isChecked()){
			
			}
*/
			iv.setImageDrawable(r);
		} else if (n == 2) {
			Drawable r = getResources().getDrawable(R.drawable.bill);
			
			
			rb1.setText("BillGates");
			rb2.setText("ambani");
			rb3.setText("Lakshmi Mittal");
			rb4.setText("William H. Gates");
			temp="BillGates";
			
			if (rb1.isChecked()) {
				count++;

			}

			iv.setImageDrawable(r);
			}
		else if (n == 3) {
			Drawable r = getResources().getDrawable(R.drawable.efil);
			

			iv.setImageDrawable(r);
			rb1.setText("brazil");
			rb2.setText("usa");
			rb3.setText("australia");
			rb4.setText("Landon");
			temp="brazil";
		} else if (n == 4) {
			Drawable r = getResources().getDrawable(R.drawable.egipt);
			

			iv.setImageDrawable(r);
			rb1.setText("egift");
			rb2.setText("koreya");
			rb3.setText("china");
			rb4.setText("brazil");
			temp="egift";
		} else if (n == 5) {
			Drawable r = getResources().getDrawable(R.drawable.fedrer);

			iv.setImageDrawable(r);
			rb1.setText("anderson");
			rb2.setText("johnson");
			rb3.setText("fedrer");
			rb4.setText("nadel");
			temp="fedrer";
		} else if (n == 6) {
			Drawable r = getResources().getDrawable(R.drawable.insteen);

			iv.setImageDrawable(r);

			iv.setImageDrawable(r);
			rb1.setText("insteen");
			rb2.setText("Linus Pauling,");
			rb3.setText("Alan Turing ");
			rb4.setText("Gallileo");
			temp="insteen";
		} else if (n == 7) {
			Drawable r = getResources().getDrawable(R.drawable.sach);

			iv.setImageDrawable(r);
			rb1.setText("sachin");
			rb2.setText("sehwag");
			rb3.setText("dravid");
			rb4.setText("laxman");
			temp="sachin";
		}

		else if (n == 8) {
			Drawable r = getResources().getDrawable(R.drawable.d);

			iv.setImageDrawable(r);
			rb1.setText("agra");
			rb2.setText("delhi");
			rb3.setText("mumbai");
			rb4.setText("rajasthan");
			temp="agra";
		}
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(ans.equals(temp))
				{
					MediaPlayer mp = MediaPlayer.create(Image.this, R.raw.aps);
					mp.start();
					Intent it=new Intent(Image.this,Image.class);
					count++;
					startActivity(it);
				}
				else
				{
					
					finish();
					Toast.makeText(getApplicationContext(),ans ,60).show();
				}
			}
		});

	}
		
	private int showRandomNum(int i, int j) {
		// TODO Auto-generated method stub
		Random rnum = new Random();
		rnum.setSeed(System.currentTimeMillis());
		if (i > j) {
			throw new IllegalArgumentException("StartNo cannot exceed EndNo.");
		}
		long ran = (long) j - (long) i + 1;
		long fraction = (long) (ran * rnum.nextDouble());
		int ranum = (int) (fraction + i);
		return ranum;

	}
	

	
}
