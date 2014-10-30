package ie.dit.miedziejewski.adam;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity 
{
	Button green;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        green = (Button)findViewById(R.id.green_button);
        
        green.setOnClickListener(new View.OnClickListener() 
        {
			@Override
			public void onClick(View arg0) 
			{
				Intent intent = new Intent 
				    	(MainActivity.this, GreenFlashlightActivity.class);
				    	startActivity(intent);
			}
		});
    }

}
