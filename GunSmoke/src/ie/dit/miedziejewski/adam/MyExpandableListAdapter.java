package ie.dit.miedziejewski.adam;

import java.text.DecimalFormat;
import android.app.Activity;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MyExpandableListAdapter extends BaseExpandableListAdapter 
{
	String[] handgunName;
	// hashmap used to store gun names with associated names of the pictures

	private final SparseArray<Group> groups;
	public LayoutInflater inflater;
	public Activity activity;
	// Reference: The following code is from 
	// http://www.androidhive.info/2013/07/android-expandable-list-view-tutorial/
	public MyExpandableListAdapter(Activity act, SparseArray<Group> groups) 
	{
		activity = act;
		this.groups = groups;
		inflater = act.getLayoutInflater();
		
	}


	@Override
	public Object getChild(int groupPosition, int childPosition) 
	{
		return groups.get(groupPosition).children.get(childPosition);
	}
	
	@Override
	public long getChildId(int groupPosition, int childPosition) 
	{
		return 0;
	}
	
	
	@Override
	public View getChildView(int groupPosition, final int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) 
	{
		DecimalFormat df = new DecimalFormat("0.00##");
		final Product children = (Product) getChild(groupPosition, childPosition);
		View rowView = convertView;
		
		if (rowView == null) 
		{
			rowView = inflater.inflate(R.layout.listrow_details, null);
			EditText quantity = (EditText) rowView.findViewById(R.id.qty);
			
			quantity.setFocusableInTouchMode(true);
			quantity.requestFocus();
			
			//attach the TextWatcher listener to the EditText
		    quantity.addTextChangedListener(new MyTextWatcher(rowView));
		}
		

		EditText quantity = (EditText) rowView.findViewById(R.id.qty);
		quantity.setTag(children);
		
		quantity.setSelection(quantity.getText().length());
		
		if(children.getQuantity() != 0)
		{
		    quantity.setText(String.valueOf(children.getQuantity()));
		}
		else 
		{
		    quantity.setText("");
		}
		
		TextView name = (TextView) rowView.findViewById(R.id.weaponeName);
		name.setText(children.getName());
		TextView price = (TextView) rowView.findViewById(R.id.weaponPrice);
		price.setText("€" + df.format(children.getPrice()));
		
		TextView ext = (TextView) rowView.findViewById(R.id.weaponExt);
		
		if(children.getQuantity() != 0)
		{
			ext.setText("€" + df.format(children.getExt()));
		}
		else 
		{
		    ext.setText("");
		}	
		
		ImageView imageView = (ImageView)rowView.findViewById(R.id.weaponeImage);
		
		rowView.setOnClickListener(new OnClickListener() 
		{
			@Override
			public void onClick(View v) 
			{
				Toast.makeText(activity, children.getDescription(),
				Toast.LENGTH_SHORT).show();
			}
		});
		
		
		if (name.getText().equals("Commander .45ACP")) {	
			imageView.setImageResource(R.drawable.acp45);}
		else if (name.getText().equals("Rossi R851")) {
			imageView.setImageResource(R.drawable.acp5);}
		else if (name.getText().equals("ATI .22LR")) {
			imageView.setImageResource(R.drawable.ati);}
		else if (name.getText().equals("Charter 38SPL")) {
			imageView.setImageResource(R.drawable.charter);}
		else if (name.getText().equals("PANTERA .45ACP")) {
			imageView.setImageResource(R.drawable.pantera);}
		else if (name.getText().equals("Armscor 38SPL")) {
			imageView.setImageResource(R.drawable.spl38);}
		else if (name.getText().equals("Taurus 357MAG")) {
			imageView.setImageResource(R.drawable.taurus);}
		else if (name.getText().equals("Adams 5.56")) {
			imageView.setImageResource(R.drawable.adams);}
		else if (name.getText().equals("Adcor E 223")) {
			imageView.setImageResource(R.drawable.adcor);}
		else if (name.getText().equals("ATI GSG .22LR")) {
			imageView.setImageResource(R.drawable.atigsg);}
		else if (name.getText().equals("Anderson M4 5.56")) {
			imageView.setImageResource(R.drawable.anderson);}
		else if (name.getText().equals("Armalite 223")) {
			imageView.setImageResource(R.drawable.armalite);}
		else if (name.getText().equals("Armalite 7.62")) {
			imageView.setImageResource(R.drawable.armlite2);}
		else if (name.getText().equals("Armalite .50")) {
			imageView.setImageResource(R.drawable.armlite3);}
		else if (name.getText().equals("Arsenal SAM-7")) {
			imageView.setImageResource(R.drawable.arsenal);}
		else if (name.getText().equals("1927 M1 45")) {
			imageView.setImageResource(R.drawable.m1927);}
		else if (name.getText().equals("Barrett .50BMG")) {
			imageView.setImageResource(R.drawable.barrett);}
		else if (name.getText().equals("Akkar MC3")) {
			imageView.setImageResource(R.drawable.akkar);}
		else if (name.getText().equals("Beretta A400")) {
			imageView.setImageResource(R.drawable.beretta);}
		else if (name.getText().equals("KOFS SX")) {
			imageView.setImageResource(R.drawable.kofs);}
		else if (name.getText().equals("ADT SW")) {
			imageView.setImageResource(R.drawable.adt);}
		else if (name.getText().equals("ADT VENOM")) {
			imageView.setImageResource(R.drawable.adtv);}
		else if (name.getText().equals("Taylors")) {
			imageView.setImageResource(R.drawable.taylors);}
		else if (name.getText().equals("Boker")) {
			imageView.setImageResource(R.drawable.boker);}
		else if (name.getText().equals("Browning")) {
			imageView.setImageResource(R.drawable.browning);}
		else if (name.getText().equals("Kukri")) {
			imageView.setImageResource(R.drawable.kukri);}
		else if (name.getText().equals("Machete")) {
			imageView.setImageResource(R.drawable.machete);}
		else if (name.getText().equals("Katana")) {
			imageView.setImageResource(R.drawable.katana);}
		else if (name.getText().equals("Bastard")) {
			imageView.setImageResource(R.drawable.bastard);}
		else if (name.getText().equals("Inferno")) {
			imageView.setImageResource(R.drawable.inferno);}
		else if (name.getText().equals("Barnett")) {
			imageView.setImageResource(R.drawable.barnett);}
		else if (name.getText().equals("Vortex")) {
			imageView.setImageResource(R.drawable.vortex);}
		else if (name.getText().equals("Diamond")) {
			imageView.setImageResource(R.drawable.diamond);}
		else if (name.getText().equals("Brodhead")) {
			imageView.setImageResource(R.drawable.allen);}
		else if (name.getText().equals("Apex Sight")) {
			imageView.setImageResource(R.drawable.apex);}
		else{} 
		return rowView;
	}
	// Reference complete
	@Override
	public int getChildrenCount(int groupPosition) 
	{
		return groups.get(groupPosition).children.size();
	}

	@Override
	public Object getGroup(int groupPosition) 
	{
		return groups.get(groupPosition);
	}

	@Override
	public int getGroupCount() 
	{
		return groups.size();
	}

	@Override
	public void onGroupCollapsed(int groupPosition) 
	{
		super.onGroupCollapsed(groupPosition);
	}

	@Override
	public void onGroupExpanded(int groupPosition) 
	{
		super.onGroupExpanded(groupPosition);
	}

	@Override
	public long getGroupId(int groupPosition) 
	{
		return 0;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) 
	{

		if (convertView == null) 
		{
			convertView = inflater.inflate(R.layout.listrow_group, null);
		}
		
		
		Group group = (Group) getGroup(groupPosition);
		((CheckedTextView) convertView).setText(group.string);
		((CheckedTextView) convertView).setChecked(isExpanded);
		
		
		return convertView;
	}

	@Override
	public boolean hasStableIds() 
	{
		return false;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) 
	{
		return false;
	}
}


