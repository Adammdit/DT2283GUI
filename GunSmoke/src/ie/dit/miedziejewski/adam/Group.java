package ie.dit.miedziejewski.adam;

import java.util.ArrayList;
import java.util.List;

public class Group 
{
	public String string;
	public final List<Product> children = new ArrayList<Product>();

	public Group(String string) 
	{
		this.string = string;	
	}
} 
