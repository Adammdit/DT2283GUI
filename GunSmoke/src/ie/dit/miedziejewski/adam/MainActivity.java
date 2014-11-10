package ie.dit.miedziejewski.adam;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener
{
	String[] handgunName, assaultName, handgunDescription, assaultDescription, handgunPrice, assaultPrice;
	Integer[] qty;
	Button btn;
	Intent i;
	private static Double orderTotal = 0.00;
	private static TextView tot;
	// more efficient than HashMap for mapping integers to objects
	SparseArray<Group> groups = new SparseArray<Group>();
	// define decimal format	
	DecimalFormat df = new DecimalFormat("0.00##");
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn = (Button)findViewById(R.id.checkout);
		// Assigning listener to button
		btn.setOnClickListener(this);
		// receive user name and email with intent  
		i = getIntent();

		createData();
		ExpandableListView listView = (ExpandableListView) findViewById(R.id.listView);	

		MyExpandableListAdapter adapter = new MyExpandableListAdapter(this, groups);
		listView.setAdapter(adapter);	
		tot = (TextView) findViewById(R.id.cartTotal);
		
		btn.setOnClickListener(new OnClickListener() 
		{
	        @Override
	        public void onClick(View v) 
	        {
	        	if (orderTotal > Double.parseDouble(i.getStringExtra("budget")))
	    		{
	    			Toast.makeText(MainActivity.this, "Value of your shopping is over your budget. " +
	    					"Remove some of your items and try again.",
	    					Toast.LENGTH_SHORT).show();
	    		}
	    		
	        	else
	        	{
	        		Intent intent = new Intent(MainActivity.this, Receipt.class);
	        		ArrayList<Product> sold = new ArrayList<Product>();
		        	
		        	for(int i = 0; i < groups.size(); i++)
		        	{
		        	    int key = groups.keyAt(i);
		        	    Group value = groups.valueAt(i);
		        	    
		        	    Iterator<Product> itr = value.children.iterator();
		        	    while (itr.hasNext()) 
		        	    {
		        	        Product element = itr.next();
		        	        if(element.getQuantity() > 0)
		        	        {
		        	        	System.out.printf(element.getName() + " " + "%n");
		        	        	sold.add(element);
		        	        }
		        	        
		        	    }
		        	}
		        	//System.out.printf(sold.get(2).getName() + " " + "%n");
		        	
		    		intent.putExtra("formName", i.getStringExtra("name"));
		    		intent.putExtra("formLicence", i.getStringExtra("licence"));
		        	intent.putExtra("formEmail", i.getStringExtra("email"));
		        	intent.putExtra("formBudget", i.getStringExtra("budget"));
		        	intent.putExtra("formAge", i.getStringExtra("age"));
		        	intent.putExtra("formGender", i.getStringExtra("gender"));
		        	intent.putExtra("formJob", i.getStringExtra("job"));
		        	//intent.putExtra("list", sold);
		        	intent.putParcelableArrayListExtra("productsList", sold);
		            startActivity(intent);
		            finish();
	        	}
	        	
	        }	
		});
	}
	
	// Update total value
	public void updateTotal(Double t)
	{
		orderTotal = orderTotal + t;
		tot.setText("TOTAL : €" + String.valueOf(df.format(orderTotal)));
		return;
	}
	
	public void createData() 
	{	
		handgunName = getResources().getStringArray(R.array.handgunName);
		handgunPrice = getResources().getStringArray(R.array.handgunPrice);
		handgunDescription = getResources().getStringArray(R.array.handgunDescription);
		assaultName = getResources().getStringArray(R.array.assaultName);
		assaultPrice = getResources().getStringArray(R.array.assaultPrice);
		assaultDescription = getResources().getStringArray(R.array.assaultDescription);
		
		Group handguns = new Group("Handguns");
		Group assault = new Group("Assault");
		Group shotguns = new Group("Shotguns");
		Group melee = new Group("Melee");
		Group accessories = new Group("Accessories");
		
		for(int i=0; i<handgunName.length; i++)
		{
			Product e = new Product(handgunName[i], handgunDescription[i], Double.parseDouble(handgunPrice[i]));
			handguns.children.add(e);
		}		
		for(int i=0; i<assaultName.length; i++)
		{
			Product e2 = new Product(assaultName[i], assaultDescription[i], Double.parseDouble(assaultPrice[i]));
			assault.children.add(e2);
		}
		
	 
		groups.append(0, handguns);
		groups.append(1, assault);
		groups.append(2, shotguns);
		groups.append(3, melee);
		groups.append(4, accessories);
	}

	@Override
	public void onClick(View v) 
	{

	}
}


