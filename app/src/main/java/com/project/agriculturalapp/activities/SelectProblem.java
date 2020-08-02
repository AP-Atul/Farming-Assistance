package com.project.agriculturalapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.project.agriculturalapp.R;
import com.project.agriculturalapp.adapters.ProblemShowAdapter;


public class SelectProblem extends AppCompatActivity {

    private ProblemShowAdapter adapter;
    private RecyclerView recyclerView;

    private String[] links;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_problem);

        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Intent[] links=getIntents();

        String[] array=getResources().getStringArray(R.array.problems);

        adapter = new ProblemShowAdapter(this,array,links);

        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        findViewById(R.id.progress).setVisibility(View.GONE);
    }

    public Intent[] getIntents(){
        Intent i1=new Intent(this, TreatmentDetail.class);
        Intent i2=new Intent(this, TreatmentDetail.class);
        Intent i3=new Intent(this, TreatmentDetail.class);
        Intent i4=new Intent(this, TreatmentDetail.class);
        i1.putExtra("image",R.drawable.t1);
        i2.putExtra("image",R.drawable.t2);
        i3.putExtra("image",R.drawable.t3);
        i4.putExtra("image",R.drawable.t4);

        i1.putExtra("info",R.string.prob1);
        i2.putExtra("info",R.string.prob2);
        i3.putExtra("info",R.string.prob3);
        i4.putExtra("info",R.string.prob4);

        Intent[] links={ i1, i2, i3 , i4};

        return links;
    }
}
