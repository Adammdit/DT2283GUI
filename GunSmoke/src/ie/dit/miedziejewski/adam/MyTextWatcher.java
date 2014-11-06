package ie.dit.miedziejewski.adam;

import java.text.DecimalFormat;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

class MyTextWatcher implements TextWatcher
{
	private View view;
	public MyTextWatcher(View view) 
	{
		this.view = view;
	}
	 
	public void beforeTextChanged(CharSequence s, int start, int count, int after) 
	{
	   //do nothing
	}
	public void onTextChanged(CharSequence s, int start, int before, int count) 
	{
	   //do nothing
	}
	public void afterTextChanged(Editable s) 
	{    
		DecimalFormat df = new DecimalFormat("0.00##");
		String qtyString = s.toString().trim();
		int quantity = qtyString.equals("") ? 0:Integer.valueOf(qtyString);
	    
		EditText qtyView = (EditText) view.findViewById(R.id.qty);
		Product product = (Product) qtyView.getTag();
	    
		if(product.getQuantity() != quantity)
		{   
			Double currPrice = product.getExt();
		    Double extPrice = quantity * product.getPrice();
		    Double priceDiff = Double.valueOf(df.format(extPrice - currPrice));
		 
		    product.setQuantity(quantity);
		    product.setExt(extPrice);
		    
		    /*
		    TextView ext = (TextView) view.findViewById(R.id.ext);
		    if(product.getQuantity() != 0){
		     ext.setText("$" + df.format(product.getExt()));
		    }
		    else {
		     ext.setText("");
		    }
		    */ 
		if(product.getQuantity() != 0)
		{
			qtyView.setText(String.valueOf(product.getQuantity()));
		}
		else 
		{
			qtyView.setText("");
		}
		     
		    // orderTotal += priceDiff;
		    // TextView cartTotal = (TextView) findViewById(R.id.cartTotal);
		    // cartTotal.setText(df.format(orderTotal));
		    
		}
	    return;
	}
}