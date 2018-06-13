package com.example.com_pc.depression.NaiveBayes;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.com_pc.depression.NaiveBayes.DataObject.DepressionData;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.SetOptions;

import java.util.Map;

public class Algorithm extends AppCompatActivity{

    public static final String TAG = "user";

    FirebaseFirestore mFirestore;
    Button buttonGet;
    TextView text1;
    double depressed;
    double depressedMale;
    double allMale;
    double probability;
    double total;
    double score;
    DepressionData depressionData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_algorithm);
        mFirestore = FirebaseFirestore.getInstance();
        depressionData = new DepressionData();


        // Get user data
        buttonGet.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                final DocumentReference docDepressionData =mFirestore.collection("Userdata").document("data");

                final DocumentReference docUserData = mFirestore.collection("Users").document("1");

                final CollectionReference colBDI3 = mFirestore.collection("Users").document("1").collection("BDI3");

                final Query queryBDI3 = colBDI3.orderBy("date", Query.Direction.DESCENDING).limit(1);
//
                // Fetch BDI3 result
                queryBDI3.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                {
                                    score = document.getDouble("score");
                                }
                            }
                        }
                    }
                });

                docUserData.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        depressionData = documentSnapshot.toObject(DepressionData.class);
                        Log.d(TAG, "DocumentSnapshot successfully written");
                    }

                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d(TAG, "DocumentSnapshot failes");
                    }
                });

                docDepressionData.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        depressionData = documentSnapshot.toObject(DepressionData.class);
                        Log.d(TAG, "DocumentSnapshot successfully written");
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d(TAG, "DocumentSnapshot failed");
                    }
                });

                depressionData.setScore(score);

                Map<String, Object> updatedData = depressionData.dataUpdate();

                docDepressionData.set(updatedData, SetOptions.merge()).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "DocumentSnapshot successfully written");
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d(TAG, "DocumentSnapshot failes");
                    }
                });

                return false;
            }
        });
    }
    public void calculate(){
        double depResult = depressionData.depProbability();
        double notDepResult = depressionData.notDepProbability();

        double depResultProb = depResult/(depResult+notDepResult);
        double notDepResultProb = notDepResult/(depResult+notDepResult);
    }
}
