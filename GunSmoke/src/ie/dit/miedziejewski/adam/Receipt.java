package ie.dit.miedziejewski.adam;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import android.widget.Toast;

public class Receipt extends Activity implements View.OnClickListener 
{
	TextView receiptName, receiptLicence, receiptEmail, soldItems, soldTotal;
	Button cnf;
	Intent i;
	String emailBody = "";

	MainActivity main = new MainActivity();	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_receipt);
		receiptName = (TextView) findViewById(R.id.receiptName);
		receiptLicence = (TextView) findViewById(R.id.receiptLicence);
		receiptEmail = (TextView) findViewById(R.id.receiptEmail);
		soldItems = (TextView) findViewById(R.id.soldItems);
		soldTotal = (TextView) findViewById(R.id.soldTotal);		
		// attache button widget and listener
		cnf = (Button)findViewById(R.id.confirm);
		cnf.setOnClickListener(this);
		// get intent
		i = getIntent();
		// get data from intent
	    ArrayList<Product> sold = i.getParcelableArrayListExtra("productsList");	
        receiptName.setText("Name: " + i.getStringExtra("formName"));
        receiptLicence.setText("Licence No: " + i.getStringExtra("formLicence"));
        receiptEmail.setText("Email: " + i.getStringExtra("formEmail"));
        receiptEmail.setText("TOTAL : " + i.getStringExtra("total"));
        // Constructing email body
        soldItems.setLineSpacing(2, 1); // UPDATE HERE		
        soldItems.setText("List of items:\n", BufferType.EDITABLE);
        Double preVatTotal = 0.00; 
        for (int k=0; k < sold.size(); k++)
        {
        	soldItems.append(sold.get(k).getName() + " :     " + Double.toString(sold.get(k).getPrice()) + " x " + sold.get(k).getQuantity() + " = €" + sold.get(k).getExt() + "\n");
        	emailBody = emailBody + sold.get(k).getName() + " :     " + Double.toString(sold.get(k).getPrice()) + " x " + sold.get(k).getQuantity() + " = €" + sold.get(k).getExt() + "\n";
        	preVatTotal = preVatTotal + sold.get(k).getExt();
        }
        soldTotal.setText("TOTAL : €" + preVatTotal + " + VAT : €" + Math.round((preVatTotal*0.21)*100.00)/100.00 + " = €" + Math.round((preVatTotal*1.21)*100.00)/100.00);
        emailBody = emailBody + "TOTAL : €" + Math.round((preVatTotal)*100.00)/100.00 + " + VAT : €" + Math.round((preVatTotal*0.21)*100.00)/100.00 + " = €" + Math.round((preVatTotal*1.21)*100.00)/100.00;
	}
	// if button clicked send an email
	// Reference: The following code is from 
	// http://stackoverflow.com/questions/2197741/how-can-i-send-emails-from-my-android-application
	@Override
	public void onClick(View v) 
	{
		Intent i2 = new Intent(Intent.ACTION_SEND);
		i2.setType("message/rfc822");
		i2.putExtra(Intent.EXTRA_EMAIL  , new String[]{i.getStringExtra("formEmail")});
		i2.putExtra(Intent.EXTRA_SUBJECT, "Receipt:");
		i2.putExtra(Intent.EXTRA_TEXT   , emailBody);
		try {
		    startActivity(Intent.createChooser(i2, "Send mail..."));
		} catch (android.content.ActivityNotFoundException ex) {
		    Toast.makeText(Receipt.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
		}	
	}
	// Reference complete
}
