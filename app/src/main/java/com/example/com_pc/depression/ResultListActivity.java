package com.example.com_pc.depression;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class ResultListActivity extends AppCompatActivity {

    private ListView listView;
    private ResultListAdapter adapter;
    private List<Result> resultList;

    FirebaseFirestore db;
    public String date;
    public String listname;

    // user id variabel
    private static final String PREFS_UID = "Userid";
    private final String Defaultuser_id = "";
    public static String user_id;
    //====================

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_list);
        Intent intent = getIntent();

        // initiate the db
        db = FirebaseFirestore.getInstance();

        // get the user_id
        //===========================================
        SharedPreferences settings = getSharedPreferences(PREFS_UID, Context.MODE_PRIVATE);
        //========================get the value
        user_id = settings.getString(PREFS_UID, Defaultuser_id);
        //==================================================================================

        listView =(ListView)findViewById(R.id.listView);
        resultList = new ArrayList<Result>();

        String dateget = get_result_data();
        Toast.makeText(ResultListActivity.this, "dateget : " + dateget , Toast.LENGTH_SHORT).show();

        resultList.add(new Result("BDI 첫 번째 결과",date));
        //resultList.add(new Result("BDI 첫 번째 결과","2018-06-06"));
        //resultList.add(new Result("BDI 두 번째 결과","2018-06-13"));


        adapter = new ResultListAdapter(getApplicationContext(),resultList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent1 = new Intent(getApplicationContext(),ResultActivity.class);
                intent1.putExtra("title",resultList.get(position).getTt1());
                intent1.putExtra("date",resultList.get(position).getTt2());
                startActivity(intent1);
            }
        });
    }

    public String get_result_data(){
        DocumentReference userRef = db.collection("users").document(user_id).collection("BDI").document("answer");

        // check wether the data exist or not
        userRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.isSuccessful()){
                    //Document found in the offline cache
                    DocumentSnapshot document = task.getResult();
                    if(document.exists()){
                        //Toast.makeText(MainActivity.this, "DocumentSnapshot data : " + document.getData(), Toast.LENGTH_SHORT).show();
                        date = task.getResult().getString("date");

                        Toast.makeText(ResultListActivity.this, "date : " + date, Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(ResultListActivity.this, "Document not found", Toast.LENGTH_SHORT).show();
                    }


                }
                else{
                    Toast.makeText(ResultListActivity.this, "get failed with" + task.getException(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        return date;
    }
}
