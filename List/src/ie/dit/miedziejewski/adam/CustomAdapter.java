package ie.dit.miedziejewski.adam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends ArrayAdapter<String>
{
	private final Context context;
	private final String[] values;
	
	public CustomAdapter(Context context, String[] values) 
	{
		super(context, R.layout.row, values);
		this.context = context;
		this.values = values;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		View rowView = convertView;
		if(rowView == null)
		{
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			rowView = inflater.inflate(R.layout.row, parent, false);
		}
		
		TextView textView = (TextView)rowView.findViewById(R.id.weekofday);
		ImageView imageView = (ImageView)rowView.findViewById(R.id.weaponeImage);
		textView.setText(values[position]);
 
		// Change icon based on name
		String s = values[position];
 
		System.out.println(s);
 
		if (s.equals("Knife")) {
			imageView.setImageResource(R.drawable.knife);
		} else if (s.equals("Machete")) {
			imageView.setImageResource(R.drawable.machete);
		} else if (s.equals("Maltador")) {
			imageView.setImageResource(R.drawable.maltador);
			
		} else if (s.equals("Galstead")) {
			imageView.setImageResource(R.drawable.galstead);
		} else {
			imageView.setImageResource(R.drawable.throwing);
		}
 
		return rowView;
	}
}
