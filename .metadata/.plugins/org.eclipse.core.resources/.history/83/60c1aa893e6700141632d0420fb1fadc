package ie.dit.miedziejewski.adam;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Date;

public class MainActivity extends Activity implements View.OnClickListener 
{
	// Widget GUI
	Button btn, btn2;
	EditText input;
	TextView output;

	@Override
	public void onCreate(Bundle icicle) 
	{
		super.onCreate(icicle);	
		setContentView(R.layout.activity_main);	
		
		// Init Widget GUI
		input = (EditText)findViewById(R.id.editText1);
		output = (TextView) findViewById(R.id.textView2);
		btn = (Button)findViewById(R.id.button);
		btn2 = (Button)findViewById(R.id.button1);
		
		btn2.setOnClickListener(this);
		// Text watcher
		input.addTextChangedListener(new TextWatcher() 
		{	 
			public void afterTextChanged(Editable s) {}
			 
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
			 
			public void onTextChanged(CharSequence s, int start, int before, int count) 
			{		
			   output.setText(s);
			}
		});
	}
		
	public void onClick(View view) 
	{
		updateTime();
	}
	
	private void updateTime() 
	{
		btn.setText(new Date().toString());
	}
}
