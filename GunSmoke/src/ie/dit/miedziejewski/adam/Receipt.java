package ie.dit.miedziejewski.adam;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Receipt extends Activity implements View.OnClickListener 
{
	String formName, formEmail;
	TextView receiptName;
	Button cnf;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_receipt);
		receiptName = (TextView) findViewById(R.id.receiptName);
		//formName = getIntent().getExtras().getString("name").toString();
		//formEmail = getIntent().getExtras().getString("email").toString();
		cnf = (Button)findViewById(R.id.confirm);
		cnf.setOnClickListener(this);
		
		//receiptName.setText(formName);
	}
	/*
	protected void sendEmail() 
	{
		Intent email = new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_EMAIL, new String[] { "adam.miedziejewski@mydit.ie" });
        // email.putExtra(Intent.EXTRA_CC, new String[]{ to});
        // email.putExtra(Intent.EXTRA_BCC, new String[]{to});
        email.putExtra(Intent.EXTRA_SUBJECT, "subject");
        email.putExtra(Intent.EXTRA_TEXT, "message");

        // need this to prompts email client only
        email.setType("message/rfc822");

        //startActivity(Intent.createChooser(email, "Choose an Email client :"));
	} */
	
	@Override
	public void onClick(View v) 
	{
		//sendEmail();
		/*
		Intent i = new Intent(Intent.ACTION_SEND);
		i.setType("message/rfc822");
		i.putExtra(Intent.EXTRA_EMAIL  , new String[]{formEmail});
		i.putExtra(Intent.EXTRA_SUBJECT, "subject of email");
		i.putExtra(Intent.EXTRA_TEXT   , "body of email");
		try {
		    startActivity(Intent.createChooser(i, "Send mail..."));
		} catch (android.content.ActivityNotFoundException ex) {
		    Toast.makeText(Receipt.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
	}
		*/
		
	}
}
