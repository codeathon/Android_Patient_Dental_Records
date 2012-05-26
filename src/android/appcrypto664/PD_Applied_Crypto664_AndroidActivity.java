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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;



public class PD_Applied_Crypto664_AndroidActivity extends Activity {
    /** Called when the activity is first created. */
	
	private EditText fname;
	private EditText lname;
	private EditText sex;
	private EditText dob;
	private EditText age;
	private EditText mstatus;
	private EditText address;
	private EditText cellno;
	
	private TextView welcome;
	private TextView signout;
	
	private Button home;
	
	private DataBaseHelper dbh;
	private SQLiteDatabase myDataBase;
	
	private Cursor c;
	
	private String temp;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.appcrypto664_personal_details);
        this.initcontrol();
    }
     
    private void initcontrol() {
	
    	fname=(EditText)findViewById(R.id.pd_firstname);
    	lname=(EditText)findViewById(R.id.pd_lname);
    	sex=(EditText)findViewById(R.id.pd_sex);
    	dob=(EditText)findViewById(R.id.pd_dob);
    	age=(EditText)findViewById(R.id.pd_age);
    	mstatus=(EditText)findViewById(R.id.pd_mstatus);
    	address=(EditText)findViewById(R.id.pd_address);
    	cellno=(EditText)findViewById(R.id.pd_cellno);
   
    	welcome=(TextView)findViewById(R.id.pd_welcome);
    	signout=(TextView)findViewById(R.id.pd_signout);
    	
    	home=(Button)findViewById(R.id.pd_home);
    	
    	
		Bundle bundle = this.getIntent().getExtras();
		temp = bundle.getString("key");
		welcome.setVisibility(0);
		welcome.setText(temp);
    	
		dbh = new DataBaseHelper(this);
 		try {			
 			dbh.createDataBase();
 		} catch (IOException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 		
 		dbh.openDataBase();
 		
 		c = dbh.getPersonalDetails(temp);
 		c.moveToFirst();
		
		fname.setText(c.getString(c.getColumnIndex("fname")).toString());
		lname.setText(c.getString(c.getColumnIndex("lname")).toString());
		age.setText(c.getString(c.getColumnIndex("age")).toString());
		sex.setText(c.getString(c.getColumnIndex("sex")).toString());
		dob.setText(c.getString(c.getColumnIndex("dob")).toString());
		address.setText(c.getString(c.getColumnIndex("address")).toString());
		mstatus.setText(c.getString(c.getColumnIndex("mstatus")).toString());
		cellno.setText(c.getString(c.getColumnIndex("cellno")).toString());
		
		c.close();
		dbh.close();
		
		home.setOnClickListener(new Button.OnClickListener(){ public void onClick(View v) { PDOnClickHome(); }});
    	signout.setOnClickListener(new TextView.OnClickListener() { public void onClick(View v) { SOOnClick();}});
    }
   
	private void PDOnClickHome() {
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