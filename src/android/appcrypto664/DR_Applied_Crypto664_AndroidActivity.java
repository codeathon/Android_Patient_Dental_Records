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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;



public class DR_Applied_Crypto664_AndroidActivity extends Activity {
    /** Called when the activity is first created. */
	
	private TextView welcome;
	private TextView signout;
	
	private Button home;
	
	private ImageView imgbutton1;
	private ImageView imgbutton2;
	
	private String temp;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.appcrypto664_dental_records);
        this.initcontrol();
    }
     
    private void initcontrol() {
    	
    	welcome=(TextView)findViewById(R.id.dr_welcome);
    	signout=(TextView)findViewById(R.id.dr_signout);
    	
    	home=(Button)findViewById(R.id.dr_home);
    	
    	imgbutton1=(ImageView)findViewById(R.id.dr_img1);
    	imgbutton2=(ImageView)findViewById(R.id.dr_img2);
    	
		Bundle bundle = this.getIntent().getExtras();
		temp = bundle.getString("key");
		welcome.setVisibility(0);
		welcome.setText(temp);
    	
		home.setOnClickListener(new Button.OnClickListener(){ public void onClick(View v) { DROnClickHome(); }});
    	signout.setOnClickListener(new TextView.OnClickListener() { public void onClick(View v) { SOOnClick();}});
		
    }
    
	private void DROnClickHome() {
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