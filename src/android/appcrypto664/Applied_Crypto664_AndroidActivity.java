package android.appcrypto664;

import java.lang.String;
import java.io.IOException;
import java.lang.String;
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



public class Applied_Crypto664_AndroidActivity extends Activity {
    /** Called when the activity is first created. */
	
	private EditText username;
	private EditText password;
	
	private TextView result;
	
	private Button login;
	
	private DataBaseHelper dbh;
	private SQLiteDatabase myDataBase;
	
	private Cursor c;
	
	private String str;
	
	private String key;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.appcrypto664_login);
        this.initcontrol();
    }
     
    private void initcontrol() {
    	
/*        ImageView myImageView= (ImageView)findViewById(R.id.imageView2);
    	Animation myFadeInAnimation = AnimationUtils.loadAnimation(this,R.anim.fadein);
    	myImageView.startAnimation(myFadeInAnimation); //Set animation to your ImageView
  */  	
    	username=(EditText)findViewById(R.id.login_uname);
    	username.setText("");
    	
    	password=(EditText)findViewById(R.id.login_pswd);
    	password.setText("");
    	
    	result=(TextView)findViewById(R.id.login_result);
    	result.setText("");
    	result.setVisibility(4);
    	
    	login=(Button)findViewById(R.id.login_button);
 		login.setOnClickListener(new Button.OnClickListener() { public void onClick(View v) { loginOnClick();}});	
    }

	private void loginOnClick() {
		
		dbh = new DataBaseHelper(this);
 		try {			
 			dbh.createDataBase();
 		} catch (IOException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 		
 		dbh.openDataBase();
 		c = dbh.getLogin(username.getText().toString());
 		
 		if(!c.moveToFirst()) {
    		result.setVisibility(0);
    		result.setText("Incorrect username.");
    		c.close();
    		dbh.close();
/*    		Intent myIntent = new Intent();
    		myIntent.setClass(this, Applied_Crypto664_AndroidActivity.class);
    		startActivityForResult(myIntent,0);	
 */		}
 		else if(c.getString(c.getColumnIndex("pswd")).toString().equals(password.getText().toString())) {
    		Intent myIntent = new Intent();
    		myIntent.setClass(this, Home_Applied_Crypto664_AndroidActivity.class);
    		Bundle bundle = new Bundle();
    		bundle.putString("key", c.getString(c.getColumnIndex("uname")).toString());
    		myIntent.putExtras(bundle);
    		c.close();
    		dbh.close();
    		startActivityForResult(myIntent,0);
		}
    	else if(!c.getString(c.getColumnIndex("pswd")).toString().equals(password.getText().toString())) {
    		result.setVisibility(0);
    		result.setText("Incorrect password.");
    		c.close();
    		dbh.close();
/*    		Intent myIntent = new Intent();
    		myIntent.setClass(this, Applied_Crypto664_AndroidActivity.class);
    		startActivityForResult(myIntent,0);
 */   	}
	}
}