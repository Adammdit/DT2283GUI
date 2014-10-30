package ie.dit.miedziejewski.adam;


import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends ListActivity 
{
	String[] melee;

    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
		super.onCreate(savedInstanceState);
		
		melee = getResources().getStringArray(R.array.melee);
        // setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_main, sys));
        setListAdapter(new CustomAdapter(this, melee));
        
        ListView listView = getListView();
		listView.setTextFilterEnabled(true);
		/*
		listView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
			    // When clicked, show a toast with the TextView text
			    Toast.makeText(getApplicationContext(),
				((TextView) view).getText(), Toast.LENGTH_SHORT).show();
			}
		});*/
    }

    // http://www.mkyong.com/android/android-listview-example/

}
