package ie.dit.miedziejewski.adam;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class MainActivity extends Activity implements OnCheckedChangeListener 
{	
	// Widget GUI
    RadioGroup gravity;
    RadioGroup orientation;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
     // Init Widget GUI
        gravity = (RadioGroup) findViewById(R.id.gravity);
        orientation = (RadioGroup) findViewById(R.id.orientation);

     // Attached on check changed listeners to radio groups
        gravity.setOnCheckedChangeListener(this);
        orientation.setOnCheckedChangeListener(this);
    } 

    public void onCheckedChanged(RadioGroup group, int checkedId)
    {
    	switch (checkedId)
    	{
    		case R.id.horizontal:
    			orientation.setOrientation(LinearLayout.HORIZONTAL);
    			Toast.makeText(this, "HORIZONTAL", Toast.LENGTH_LONG).show();
    			break;
    		case R.id.vertical:
    			orientation.setOrientation(LinearLayout.VERTICAL);
    			Toast.makeText(this, "VERTICAL", Toast.LENGTH_LONG).show();
    			break;
    		case R.id.left:
    			gravity.setGravity(Gravity.LEFT);
    			Toast.makeText(this, "LEFT", Toast.LENGTH_LONG).show();
    			break;
    		case R.id.center:
    			gravity.setGravity(Gravity.CENTER);
    			Toast.makeText(this, "CENTER", Toast.LENGTH_LONG).show();
    			break;
    		case R.id.right:
    			gravity.setGravity(Gravity.RIGHT); 
    			Toast.makeText(this, "RIGHT", Toast.LENGTH_LONG).show();
    			break;
    	}
    }
}
