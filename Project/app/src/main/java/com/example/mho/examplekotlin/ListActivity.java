package com.example.mho.examplekotlin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mauricio Hernández on 09-Nov-17.
 */

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        TextView title = findViewById(R.id.text_title_list);
        if(getIntent() != null){
            Bundle extras = getIntent().getExtras();
            String titleLabel = extras.getString("UserKotlin", "");
            title.setText(titleLabel);
        }

        RecyclerView list = findViewById(R.id.list);

        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        list.setLayoutManager(linearLayoutManager);
        list.setAdapter(new ListAdapter(getData()));
    }

    private List<BasicPOJO> getData(){
        List<BasicPOJO> basicPOJOList = new ArrayList<>();
        for(int i=0; i<10; i++){
            basicPOJOList.add(new BasicPOJO("Title "+i, "Desc "+i));
        }

        return basicPOJOList;
    }
}
