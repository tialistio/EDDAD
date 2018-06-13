package com.example.com_pc.depression.BDITest;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.com_pc.depression.MainActivity;
import com.example.com_pc.depression.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.SetOptions;
import com.google.firebase.firestore.Transaction;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class bdiActivity extends AppCompatActivity {
    private  static final String PREFS_UID = "Userid";
    private final String Defaultuser_id = "";
    public static String user_id;


    public static int bdiSum = 0;
    public static int radioButtonID = 0;
    public static int selectedId = 0;
    public static String selected ="";
    View radioButton ;

    FirebaseFirestore db ;
    public static double counter;
    public String BDIname;
    public int bdiname;

    public int bdiname1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bdi);
        //========================================== get the user id
        SharedPreferences settings = getSharedPreferences(PREFS_UID, Context.MODE_PRIVATE);
        //========================get the value
        user_id = settings.getString(PREFS_UID, Defaultuser_id);

        //=================================================================================

        //==================================================================================
        // get the counter
        /*try {
            db.collection("users").document(user_id).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {
                    counter = documentSnapshot.getDouble("counter");

                    //Toast.makeText(bdiActivity.this, "counter = "+ String.valueOf(counter), Toast.LENGTH_SHORT).show();

                    counter = counter + 1 ;

                    Map<String, Object> newvalue = new HashMap<>();
                    newvalue.put("counter", counter);

                    db.collection("users").document(user_id).update(newvalue);

                    // Make the BDI name


                    Toast.makeText(bdiActivity.this, "BDIname = "+ counter, Toast.LENGTH_SHORT).show();
                }
            });
        }
        catch (Exception e){
            e.printStackTrace();
        }
*/
        //======================
        TextView bdiBtn = (TextView)findViewById(R.id.btnext_bdiBtn1);
        bdiBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                // get the counter
                try {
                    db.collection("users").document(user_id).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot documentSnapshot) {
                            counter = documentSnapshot.getDouble("counter");

                            //Toast.makeText(bdiActivity.this, "counter = "+ String.valueOf(counter), Toast.LENGTH_SHORT).show();

                            counter = counter + 1 ;

                            Map<String, Object> newvalue = new HashMap<>();
                            newvalue.put("counter", counter);

                            db.collection("users").document(user_id).update(newvalue);

                            // Make the BDI name


                            Toast.makeText(bdiActivity.this, "BDIname = "+ counter, Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                catch (Exception e){
                    e.printStackTrace();
                }

                //====================== upload the date
                db = FirebaseFirestore.getInstance();
                Date currentTime = Calendar.getInstance().getTime();
                String date = currentTime.toString();
                //bdi_save_stringdata("date", date);

                //======================
                bdiSum = 0;
                upload_score();
                //update_counter();
                Toast.makeText(bdiActivity.this, "Id = " + user_id, Toast.LENGTH_SHORT).show();
                Intent bdiIntent2 = new Intent(bdiActivity.this,bdiFinish.class);
                bdiActivity.this.startActivity(bdiIntent2);
            }
        });
//============================================================================================

        //==========================================================================================
    }
    public String get_score(){

        RadioGroup gr21 = (RadioGroup)findViewById(R.id.gr21);
        int radioButtonID = gr21.getCheckedRadioButtonId();
        View radioButton = gr21.findViewById(radioButtonID);
        int selectedId = gr21.indexOfChild(radioButton);
        selected = String.valueOf(selectedId);

        return selected;
    }

    public void upload_score(){

        RadioGroup gr1 = (RadioGroup)findViewById(R.id.gr1);
        radioButtonID = gr1.getCheckedRadioButtonId();
        radioButton = gr1.findViewById(radioButtonID);
        selectedId = gr1.indexOfChild(radioButton);
        selected = String.valueOf(selectedId);
        bdi_save_data("Q1", selectedId);
        add_sum(selectedId);
        //Toast.makeText(bdiActivity.this, "anwser = "+selected, Toast.LENGTH_SHORT).show();

        RadioGroup gr2 = (RadioGroup)findViewById(R.id.gr2);
        radioButtonID = gr2.getCheckedRadioButtonId();
        radioButton = gr2.findViewById(radioButtonID);
        selectedId = gr2.indexOfChild(radioButton);
        selected = String.valueOf(selectedId);
        bdi_save_data("Q2", selectedId);
        add_sum(selectedId);

        RadioGroup gr3 = (RadioGroup)findViewById(R.id.gr3);
        radioButtonID = gr3.getCheckedRadioButtonId();
        radioButton = gr3.findViewById(radioButtonID);
        selectedId = gr3.indexOfChild(radioButton);
        selected = String.valueOf(selectedId);
        bdi_save_data("Q3", selectedId);
        add_sum(selectedId);

        RadioGroup gr4 = (RadioGroup)findViewById(R.id.gr4);
        radioButtonID = gr4.getCheckedRadioButtonId();
        radioButton = gr4.findViewById(radioButtonID);
        selectedId = gr4.indexOfChild(radioButton);
        selected = String.valueOf(selectedId);
        bdi_save_data("Q4", selectedId);
        add_sum(selectedId);

        RadioGroup gr5 = (RadioGroup)findViewById(R.id.gr5);
        radioButtonID = gr5.getCheckedRadioButtonId();
        radioButton = gr5.findViewById(radioButtonID);
        selectedId = gr5.indexOfChild(radioButton);
        selected = String.valueOf(selectedId);
        bdi_save_data("Q5", selectedId);
        add_sum(selectedId);

        RadioGroup gr6 = (RadioGroup)findViewById(R.id.gr6);
        radioButtonID = gr6.getCheckedRadioButtonId();
        radioButton = gr6.findViewById(radioButtonID);
        selectedId = gr6.indexOfChild(radioButton);
        selected = String.valueOf(selectedId);
        bdi_save_data("Q6", selectedId);
        add_sum(selectedId);

        RadioGroup gr7 = (RadioGroup)findViewById(R.id.gr7);
        radioButtonID = gr7.getCheckedRadioButtonId();
        radioButton = gr7.findViewById(radioButtonID);
        selectedId = gr7.indexOfChild(radioButton);
        selected = String.valueOf(selectedId);
        bdi_save_data("Q7", selectedId);
        add_sum(selectedId);

        RadioGroup gr8 = (RadioGroup)findViewById(R.id.gr8);
        radioButtonID = gr8.getCheckedRadioButtonId();
        radioButton = gr8.findViewById(radioButtonID);
        selectedId = gr8.indexOfChild(radioButton);
        selected = String.valueOf(selectedId);
        bdi_save_data("Q8", selectedId);
        add_sum(selectedId);

        RadioGroup gr9 = (RadioGroup)findViewById(R.id.gr9);
        radioButtonID = gr9.getCheckedRadioButtonId();
        radioButton = gr9.findViewById(radioButtonID);
        selectedId = gr9.indexOfChild(radioButton);
        selected = String.valueOf(selectedId);
        bdi_save_data("Q9", selectedId);
        add_sum(selectedId);

        RadioGroup gr10 = (RadioGroup)findViewById(R.id.gr10);
        radioButtonID = gr10.getCheckedRadioButtonId();
        radioButton = gr10.findViewById(radioButtonID);
        selectedId = gr10.indexOfChild(radioButton);
        selected = String.valueOf(selectedId);
        bdi_save_data("Q10", selectedId);
        add_sum(selectedId);

        RadioGroup gr11 = (RadioGroup)findViewById(R.id.gr11);
        radioButtonID = gr11.getCheckedRadioButtonId();
        radioButton = gr11.findViewById(radioButtonID);
        selectedId = gr11.indexOfChild(radioButton);
        selected = String.valueOf(selectedId);
        bdi_save_data("Q11", selectedId);
        add_sum(selectedId);

        RadioGroup gr12 = (RadioGroup)findViewById(R.id.gr12);
        radioButtonID = gr12.getCheckedRadioButtonId();
        radioButton = gr12.findViewById(radioButtonID);
        selectedId = gr12.indexOfChild(radioButton);
        selected = String.valueOf(selectedId);
        bdi_save_data("Q12", selectedId);
        add_sum(selectedId);

        RadioGroup gr13 = (RadioGroup)findViewById(R.id.gr13);
        radioButtonID = gr13.getCheckedRadioButtonId();
        radioButton = gr13.findViewById(radioButtonID);
        selectedId = gr13.indexOfChild(radioButton);
        selected = String.valueOf(selectedId);
        bdi_save_data("Q13", selectedId);
        add_sum(selectedId);

        RadioGroup gr14 = (RadioGroup)findViewById(R.id.gr14);
        radioButtonID = gr14.getCheckedRadioButtonId();
        radioButton = gr14.findViewById(radioButtonID);
        selectedId = gr14.indexOfChild(radioButton);
        selected = String.valueOf(selectedId);
        bdi_save_data("Q14", selectedId);
        add_sum(selectedId);

        RadioGroup gr15 = (RadioGroup)findViewById(R.id.gr15);
        radioButtonID = gr15.getCheckedRadioButtonId();
        radioButton = gr15.findViewById(radioButtonID);
        selectedId = gr15.indexOfChild(radioButton);
        selected = String.valueOf(selectedId);
        bdi_save_data("Q15", selectedId);
        add_sum(selectedId);

        RadioGroup gr16 = (RadioGroup)findViewById(R.id.gr16);
        radioButtonID = gr16.getCheckedRadioButtonId();
        radioButton = gr16.findViewById(radioButtonID);
        selectedId = gr16.indexOfChild(radioButton);
        selected = String.valueOf(selectedId);
        bdi_save_data("Q16", selectedId);
        add_sum(selectedId);

        RadioGroup gr17 = (RadioGroup)findViewById(R.id.gr17);
        radioButtonID = gr17.getCheckedRadioButtonId();
        radioButton = gr17.findViewById(radioButtonID);
        selectedId = gr17.indexOfChild(radioButton);
        selected = String.valueOf(selectedId);
        bdi_save_data("Q17", selectedId);
        add_sum(selectedId);

        RadioGroup gr18 = (RadioGroup)findViewById(R.id.gr18);
        radioButtonID = gr18.getCheckedRadioButtonId();
        radioButton = gr18.findViewById(radioButtonID);
        selectedId = gr18.indexOfChild(radioButton);
        selected = String.valueOf(selectedId);
        bdi_save_data("Q18", selectedId);
        add_sum(selectedId);

        RadioGroup gr19 = (RadioGroup)findViewById(R.id.gr19);
        radioButtonID = gr19.getCheckedRadioButtonId();
        radioButton = gr19.findViewById(radioButtonID);
        selectedId = gr19.indexOfChild(radioButton);
        selected = String.valueOf(selectedId);
        bdi_save_data("Q19", selectedId);
        add_sum(selectedId);

        RadioGroup gr20 = (RadioGroup)findViewById(R.id.gr20);
        radioButtonID = gr20.getCheckedRadioButtonId();
        radioButton = gr20.findViewById(radioButtonID);
        selectedId = gr20.indexOfChild(radioButton);
        selected = String.valueOf(selectedId);
        bdi_save_data("Q20", selectedId);
        add_sum(selectedId);

        RadioGroup gr21 = (RadioGroup)findViewById(R.id.gr21);
        radioButtonID = gr21.getCheckedRadioButtonId();
        radioButton = gr21.findViewById(radioButtonID);
        selectedId = gr21.indexOfChild(radioButton);
        selected = String.valueOf(selectedId);
        bdi_save_data("Q21", selectedId);
        add_sum(selectedId);

        bdi_save_data("score",bdiSum);



    }

    public void bdi_set_data(String questionnum, int answer){

        if(answer==-1){
            answer=0;
        }
        FirebaseFirestore db;
        db = FirebaseFirestore.getInstance();

        Map<String, Object> newvalue = new HashMap<>();
        newvalue.put(questionnum, answer);


        if(counter==1.0) {
            db.collection("users").document(user_id).collection("BDI1").document("answer").set(newvalue);
        }
        else if(counter==2.0){
            db.collection("users").document(user_id).collection("BDI2").document("answer").set(newvalue);
        }
        else {
            db.collection("users").document(user_id).collection("BDI3").document("answer").set(newvalue);
        }

    }

    public void bdi_save_data(String questionnum, int answer){

        if(answer==-1){
            answer=0;
        }
        FirebaseFirestore db;
        db = FirebaseFirestore.getInstance();

        Map<String, Object> newvalue = new HashMap<>();
        newvalue.put(questionnum, answer);


        if(counter==1.0) {
            db.collection("users").document(user_id).collection("BDI1").document("answer").update(newvalue);
        }
        else if(counter==2.0){
            db.collection("users").document(user_id).collection("BDI2").document("answer").update(newvalue);
        }
        else {
            db.collection("users").document(user_id).collection("BDI3").document("answer").update(newvalue);
        }

    }


    public void bdi_save_stringdata(String questionnum, String answer){

        FirebaseFirestore db;
        db = FirebaseFirestore.getInstance();

        Map<String, Object> newvalue = new HashMap<>();
        newvalue.put(questionnum, answer);

        Toast.makeText(bdiActivity.this, "inside counter = " + counter, Toast.LENGTH_SHORT).show();
        if(counter==1.0) {
            db.collection("users").document(user_id).collection("BDI1").document("answer").set(newvalue);
        }
        else if(counter==2.0){
            db.collection("users").document(user_id).collection("BDI2").document("answer").set(newvalue);
        }
        else {
            db.collection("users").document(user_id).collection("BDI3").document("answer").set(newvalue);
        }

    }
    public void add_sum(int score){
        bdiSum = bdiSum + score ;
    }


}
