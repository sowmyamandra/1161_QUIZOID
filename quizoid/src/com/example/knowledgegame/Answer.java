package com.example.knowledgegame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Answer extends Activity{
	String retrieve;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.answer);
		Bundle b=getIntent().getExtras();
		final Button btn=(Button)findViewById(R.id.button1);
		if(b!=null)
		{
			retrieve=b.getString("s");
			if(retrieve.equalsIgnoreCase("nextpage"))
			{
				btn.setText("Level 2");
			}
		}
		else
		{
			btn.setText("Tryagain");	
		}
		
		
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent it=new Intent(Answer.this,GameActivity.class);
				startActivity(it);
			}
		});
		
	}

}
