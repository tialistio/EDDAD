package com.example.com_pc.depression.DiagnosisTest;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.com_pc.depression.MainActivity;
import com.example.com_pc.depression.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;

import java.util.HashMap;
import java.util.Map;


public class diagnosisActivity extends AppCompatActivity {
    private  static final String PREFS_UID = "Userid";
    private final String Defaultuser_id = "";
    public static String user_id;

    public static int radioButtonID = 0;
    public static int selectedId = 0;
    public static String selected ="";
    RadioButton radioButton ;

    public int intcounter;
    public String counter;

    MainActivity main = new MainActivity();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnosis);

        //========================================== get the user id
        SharedPreferences settings = getSharedPreferences(PREFS_UID, Context.MODE_PRIVATE);
        //========================get the value
        user_id = settings.getString(PREFS_UID, Defaultuser_id);
        //========================== upload data


        TextView nextBtn = (TextView)findViewById(R.id.diagBtn);
        nextBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                try{

                    upload_data();
                    Toast.makeText(diagnosisActivity.this, "Id = " + user_id +" succsess", Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    Toast.makeText(diagnosisActivity.this, "upload failed", Toast.LENGTH_SHORT).show();
                }

                Intent bdiStart = new Intent(diagnosisActivity.this, com.example.com_pc.depression.BDITest.bdiStart.class);
                diagnosisActivity.this.startActivity(bdiStart);
                //======================================
            }
        });

    }
//======================================= save data in database function

    public void save_strdata(String questionnum, String answer){

        FirebaseFirestore db;
        db = FirebaseFirestore.getInstance();

        Map<String, Object> newvalue = new HashMap<>();
        newvalue.put(questionnum, answer);

        db.collection("users").document(user_id).update(newvalue);
    }
    //=============================== save boolean
    public void save_data(String questionnum, Boolean answer){

        FirebaseFirestore db;
        db = FirebaseFirestore.getInstance();

        Map<String, Object> newvalue = new HashMap<>();
        newvalue.put(questionnum, answer);

        db.collection("users").document(user_id).update(newvalue);
    }

    //==================================== set database
    public void set_data(String questionnum, int answer){

        FirebaseFirestore db;
        db = FirebaseFirestore.getInstance();

        Map<String, Object> newvalue = new HashMap<>();
        newvalue.put(questionnum, answer);

        db.collection("users").document(user_id).set(newvalue, SetOptions.merge());
    }
//======================================= upload data to database
    public void upload_data(){

        EditText agein = (EditText)findViewById(R.id.edinputage);
        String ages = agein.getText().toString();
        int age = Integer.parseInt(ages);

        //======================= upload data
        set_data("age", age);

        // get the radio button value question 1
        RadioGroup rg1 = (RadioGroup)findViewById(R.id.rg1);
        radioButtonID = rg1.getCheckedRadioButtonId();
        radioButton = (RadioButton)findViewById(radioButtonID);


       String value = radioButton.getText().toString();
       if(value.equals("남")){
           value = "male";
       }
       else {
           value = "female";
       }
       save_strdata("gender", value);

        //===================yes no question save
        //Question 3
        RadioGroup rg2 = (RadioGroup)findViewById(R.id.rg2);
        radioButtonID = rg2.getCheckedRadioButtonId();
        cek_value("smoking", radioButtonID);

        //Question 4
        RadioGroup rg3 = (RadioGroup)findViewById(R.id.rg3);
        radioButtonID = rg3.getCheckedRadioButtonId();
        cek_value("alcohol", radioButtonID);

        //Question 5
        RadioGroup rg4 = (RadioGroup)findViewById(R.id.rg4);
        radioButtonID = rg4.getCheckedRadioButtonId();
        cek_value("troubleWithClassmates", radioButtonID);

        //Question 6
        RadioGroup rg5 = (RadioGroup)findViewById(R.id.rg5);
        radioButtonID = rg5.getCheckedRadioButtonId();
        cek_value("loosingFriend", radioButtonID);

        // Question 7
        RadioGroup rg6 = (RadioGroup)findViewById(R.id.rg6);
        radioButtonID = rg6.getCheckedRadioButtonId();
        cek_value("troubleWithTeacher", radioButtonID);

        //Question 8
        RadioGroup rg7 = (RadioGroup)findViewById(R.id.rg7);
        radioButtonID = rg7.getCheckedRadioButtonId();
        cek_value("troubleWithSiblings", radioButtonID);

        //Question 9
        RadioGroup rg8 = (RadioGroup)findViewById(R.id.rg8);
        radioButtonID = rg8.getCheckedRadioButtonId();
        cek_value("arguingWithParents", radioButtonID);

        //Question 10
        RadioGroup rg9 = (RadioGroup)findViewById(R.id.rg9);
        radioButtonID = rg9.getCheckedRadioButtonId();
        cek_value("parentsArguing", radioButtonID);

        //Question 11 id rg10


        //Question 12
        RadioGroup rg12 = (RadioGroup)findViewById(R.id.rg12);
        radioButtonID = rg12.getCheckedRadioButtonId();
        cek_value("seriouslyIll", radioButtonID);

        //Question 13
        RadioGroup rg13 = (RadioGroup)findViewById(R.id.rg13);
        radioButtonID = rg13.getCheckedRadioButtonId();
        cek_value("familyMemberIll", radioButtonID);

        //Question 14
        RadioGroup rg14 = (RadioGroup)findViewById(R.id.rg14);
        radioButtonID = rg14.getCheckedRadioButtonId();
        radioButton = (RadioButton)findViewById(radioButtonID);

        value = radioButton.getText().toString();
        if(value.equalsIgnoreCase("결혼")){
            value = "married";
        }
        else if(value.equalsIgnoreCase("이혼")){
            value = "divorced";
        }
        else {
            value = "died";
        }
        save_strdata("parentsMartialStatus", value);

        //Question 15
        RadioGroup rg11 = (RadioGroup)findViewById(R.id.rg11);
        radioButtonID = rg11.getCheckedRadioButtonId();
        radioButton = (RadioButton)findViewById(radioButtonID);

        value = radioButton.getText().toString();
        if(value.equalsIgnoreCase("표준이하하")){
           value = "above average";
        }
        else if(value.equalsIgnoreCase("표준")){
            value = "average";
        }
        else {
            value = "below average";
        }
        save_strdata("livingStandard", value);

        //Question 16
        RadioGroup rg16 = (RadioGroup)findViewById(R.id.rg16);
        radioButtonID = rg16.getCheckedRadioButtonId();
        radioButton = (RadioButton)findViewById(radioButtonID);
        cek_value("breakup", radioButtonID);

    }

    public void cek_value(String question, int radioId){
        radioButton = (RadioButton)findViewById(radioButtonID);
        Boolean answr;

        String value = radioButton.getText().toString();
        if(value.equalsIgnoreCase("yes")){
            answr = true;
        }
        else {
            answr = false;
        }

        save_data(question, answr);
    }

}

