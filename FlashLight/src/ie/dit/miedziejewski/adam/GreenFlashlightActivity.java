package ie.dit.miedziejewski.adam;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GreenFlashlightActivity extends Activity implements View.OnClickListener
{
	Button red;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_green_flashlight);
		
		red = (Button)findViewById(R.id.red_button);
        
        red.setOnClickListener(this);
	}
	
	public void onClick(View v) 
    {
		finish();
    }
}