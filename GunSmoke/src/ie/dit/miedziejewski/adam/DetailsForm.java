package ie.dit.miedziejewski.adam;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class DetailsForm extends Activity implements OnItemSelectedListener
{
	EditText name, age, email, budget;
	Button next;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_details_form);
		next = (Button) findViewById(R.id.continueButton);
		// Assigning listener to button
		next.setOnClickListener(new OnClickListener() 
		{
	        @Override
	        public void onClick(View v) {
	        	Intent i = new Intent(DetailsForm.this, MainActivity.class);
	            startActivity(i);
	            // close this activity
	            finish();
	        }
	    });

		// Reference: The following code is from 
        // http://developer.android.com/guide/topics/ui/controls/spinner.html
        Spinner jobSpiner = (Spinner) findViewById(R.id.jobSpinner);
        jobSpiner.setOnItemSelectedListener(this);
		// Create an ArrayAdapter using the string array and a default spinner layout
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
		        R.array.jobTitles, android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		jobSpiner.setAdapter(adapter);
        // Reference complete
	}
	
	
	
	public void onItemSelected(AdapterView<?> parent, View view, 
            int pos, long id) 
	{
        // An item was selected. You can retrieve the selected item using
		String selected = parent.getItemAtPosition(pos).toString();
		Toast.makeText(this, selected, Toast.LENGTH_LONG).show();
    }

    public void onNothingSelected(AdapterView<?> parent) 
    {
        // Another interface callback
    }
    /*
    public void onClick(View view) 
	{
    	// This method will be executed once the timer is over
        // Start your app main activity
        Intent i = new Intent(DetailsForm.this, MainActivity.class);
        startActivity(i);
        // close this activity
        finish();
	}*/
}
