package com.example.abiturientui.egzai;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.abiturientui.Kita.nustatymai;
import com.example.abiturientui.R;

public class egzai extends AppCompatActivity {

/*    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String, List<String>> expandableListDetail;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.egzai);

      /*  expandableListView = findViewById(R.id.expandableListView);
        expandableListDetail = ExpandableListDataPump.getData();
        expandableListTitle = new ArrayList<>(expandableListDetail.keySet());
        expandableListAdapter = new CustomExpandableListAdapter(this, expandableListTitle, expandableListDetail);
        expandableListView.setAdapter(expandableListAdapter);
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        expandableListTitle.get(groupPosition) + " List Expanded.",
                        Toast.LENGTH_SHORT).show();
            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        expandableListTitle.get(groupPosition) + " List Collapsed.",
                        Toast.LENGTH_SHORT).show();

            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Toast.makeText(
                        getApplicationContext(),
                        expandableListTitle.get(groupPosition)
                                + " -> "
                                + expandableListDetail.get(
                                expandableListTitle.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT
                ).show();
                return false;
            }
        });
        */

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.settings:
                startActivity(new Intent(getApplicationContext(), nustatymai.class));
                return true;
            case R.id.search:
                startActivity(new Intent(getApplicationContext(), nustatymai.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void atidarytiAtmintine(View view) {
        Intent intent = new Intent(this, atmintine.class);
        startActivity(intent);

    }
}





/*
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.abiturientui.R;
import com.github.chrisbanes.photoview.PhotoView;

public class egzai extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.egzai);
        //TextView newtext = findViewById(R.id.nuoroda1);
        //newtext.setMovementMethod(LinkMovementMethod.getInstance());
        //PhotoView photoView = findViewById(R.id.egzai1);
        //photoView.setImageResource(R.drawable.egzai1);



    }

}

*/