package android.appcrypto664;

import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;



public class Home_Applied_Crypto664_AndroidActivity extends Activity {
    /** Called when the activity is first created. */
	
	private Button personal_details;
	private Button dental_records;
	private Button treatment_history;
	private Button reports;
	
	private TextView welcome;
	private TextView signout;
	
	private String str,temp;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.appcrypto664_home);
        this.initcontrol();
    }
     
    private void initcontrol() {
	
    	personal_details=(Button)findViewById(R.id.home_pd);
    	dental_records=(Button)findViewById(R.id.home_dr);
    	treatment_history=(Button)findViewById(R.id.home_th);
    	reports=(Button)findViewById(R.id.home_report);
   
    	welcome=(TextView)findViewById(R.id.home_welcome);
    	signout=(TextView)findViewById(R.id.home_singout);
    	
		Bundle bundle = this.getIntent().getExtras();
		temp = bundle.getString("key");
		welcome.setVisibility(0);
		welcome.setText("Welcome " + temp);
    	
    	personal_details.setOnClickListener(new Button.OnClickListener() { public void onClick(View v) { PDOnClick(); }}); 
    	dental_records.setOnClickListener(new Button.OnClickListener() { public void onClick(View v) { DROnClick();}});
    	treatment_history.setOnClickListener(new Button.OnClickListener() { public void onClick(View v) { THOnClick();}});
    	reports.setOnClickListener(new Button.OnClickListener() { public void onClick(View v) { RPOnClick(); }});
    	signout.setOnClickListener(new TextView.OnClickListener() { public void onClick(View v) { SOOnClick();}});
    	
    }

	private void PDOnClick() {
    	Intent myIntent = new Intent();
    	myIntent.setClass(this, PD_Applied_Crypto664_AndroidActivity.class);
    	Bundle bundle = new Bundle();
    	bundle.putString("key", temp);
    	myIntent.putExtras(bundle);
    	startActivityForResult(myIntent,0);	
	}
	
	private void DROnClick() {
		Intent myIntent = new Intent();
		myIntent.setClass(this, DR_Applied_Crypto664_AndroidActivity.class);
		Bundle bundle = new Bundle();
		bundle.putString("key", temp);
		myIntent.putExtras(bundle);
		startActivityForResult(myIntent,0);
	}
	
	private void THOnClick() {
		Intent myIntent = new Intent();
    	myIntent.setClass(this, Home_Applied_Crypto664_AndroidActivity.class);
    	Bundle bundle = new Bundle();
    	bundle.putString("key", temp);
    	myIntent.putExtras(bundle);
    	startActivityForResult(myIntent,0);
	}
	
	private void RPOnClick() {
		Intent myIntent = new Intent();
    	myIntent.setClass(this, Home_Applied_Crypto664_AndroidActivity.class);
    	Bundle bundle = new Bundle();
    	bundle.putString("key", temp);
    	myIntent.putExtras(bundle);
    	startActivityForResult(myIntent,0);	
	}
	
	private void SOOnClick() {
		Intent myIntent = new Intent();
    	myIntent.setClass(this, Applied_Crypto664_AndroidActivity.class);
    	
    	startActivityForResult(myIntent,0);
	}
}