package com.lionroar.mokslobaze.Mokslai.Lietuviu;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.lionroar.mokslobaze.R;

import java.util.HashMap;
import java.util.List;

public class lietuviu extends AppCompatActivity {

    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String, List<String>> expandableListDetail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lietuviu);

        Resources res = getResources();
        String[] epocha = res.getStringArray(R.array.epocha_array);
        Button button;

        for (int i = 0; i < 11; i++) {
            String buttonID = "ltb" + i;
            int resID = res.getIdentifier(buttonID, "id", getPackageName());
            button = findViewById(resID);
            button.setText(epocha[i]);
        }

        /*expandableListView = findViewById(R.id.expandableListView);
        expandableListDetail = ExpandableListDataPumpLT.getData();
        expandableListTitle = new ArrayList<>(expandableListDetail.keySet());
        expandableListAdapter = new CustomExpandableListAdapter(this, expandableListTitle, expandableListDetail);
        expandableListView.setAdapter(expandableListAdapter);


        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                return false;
            }
        });
*/
    }

    public void atidarytiLietuviu(View view) {
        Toast.makeText(this, R.string.tobuliname, Toast.LENGTH_SHORT).show();
        //Intent intent = new Intent(this, lietuviu.class);
        //astartActivity(intent);
    }

    public void atidarytiLietuviuVertinima(View view) {
        Intent intent = new Intent(this, lietuviu_vertinimas.class);
        startActivity(intent);
    }

}
