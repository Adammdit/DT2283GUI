package ie.dit.miedziejewski.adam;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class DetailsForm extends Activity 
{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_details_form);
		
        // Reference: The following code is from 
        // http://developer.android.com/guide/topics/ui/controls/spinner.html
        Spinner jobSpiner = (Spinner) findViewById(R.id.jobSpinner);
		// Create an ArrayAdapter using the string array and a default spinner layout
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
		        R.array.jobTitles, android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		jobSpiner.setAdapter(adapter);
        // Reference complete
	}
}
