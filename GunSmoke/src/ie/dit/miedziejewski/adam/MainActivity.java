package ie.dit.miedziejewski.adam;

import java.text.DecimalFormat;

import android.app.Activity;
import android.os.Bundle;
import android.util.SparseArray;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity
{
	String[] gunName, gunDescription, gunPrice;
	Integer[] qty;
	EditText editQty;
	private static Double orderTotal = 0.00;
	private static TextView tot;
	// more efficient than HashMap for mapping integers to objects
	SparseArray<Group> groups = new SparseArray<Group>();
	ImageView image;
	// define decimal format	
	DecimalFormat df = new DecimalFormat("0.00##");
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		createData();
		ExpandableListView listView = (ExpandableListView) findViewById(R.id.listView);	

		MyExpandableListAdapter adapter = new MyExpandableListAdapter(this, groups);
		listView.setAdapter(adapter);	
		tot = (TextView) findViewById(R.id.cartTotal);
	}
	// Update total value
	public void updateTotal(Double t)
	{
		orderTotal = orderTotal + t;
		// System.out.println("Update called : " + orderTotal);
		tot.setText("€" + String.valueOf(df.format(orderTotal)));
		return;
	}
	
	public void createData() 
	{	
		gunName = getResources().getStringArray(R.array.handgunName);
		gunPrice = getResources().getStringArray(R.array.handgunPrice);
		
		Group handguns = new Group("Handguns");
		
		for(int i=0; i<gunName.length; i++)
		{
			Product e = new Product(gunName[i], "", Double.parseDouble(gunPrice[i]));
			handguns.children.add(e);
		}		

		Group assault = new Group("Assault");
	 
		groups.append(0, handguns);
		groups.append(1, assault);
	}
}
