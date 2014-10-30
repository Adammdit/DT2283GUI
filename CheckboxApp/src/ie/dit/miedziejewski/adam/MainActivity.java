package ie.dit.miedziejewski.adam;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.Toast;
 
public class MainActivity extends Activity 
{
	private CheckBox checkBox1;
 
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		addListenerOnChkIos();
	}
 
  public void addListenerOnChkIos() 
  {
	  checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
 
	  checkBox1.setOnClickListener(new OnClickListener() 
	  { 
		  @Override
		  public void onClick(View v) 
		  {
			  if (((CheckBox) v).isChecked()) 
			  {
				  checkBox1.setText("Checked");
				  Toast.makeText(MainActivity.this, "Bro, try Android :)", Toast.LENGTH_LONG).show();
			  }
			  else
			  {
				  checkBox1.setText("Not checked");
			  }
		  }
	  });
  }
}
