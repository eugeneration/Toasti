package com.example.Toasti;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
	
	private ListView mContactsListView;
	private ArrayAdapter<Integer> mAdapter;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        final Context mContext = (Context) this;
        
        
        
        mContactsListView = (ListView) findViewById(R.id.contacts_list);
        
        
        // temporary button
        final Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	Intent menuIntent = new Intent(mContext, CallActivity.class);
            	startActivity(menuIntent);
            }
        });
        
        // set up the array adapter
        
    }
    
    //
    public static ArrayList<Integer> getItems() {
		ArrayList<Integer> items = new ArrayList<Integer>();
		for (int i = 0; i < 1000; i++) {
			items.add(i);
		}
		return items;
	}
    
    public ListView getContactsListView() {
		return mContactsListView;
	}
}
