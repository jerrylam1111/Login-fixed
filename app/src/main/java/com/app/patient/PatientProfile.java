package com.app.patient;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import org.w3c.dom.Text;

import java.lang.ref.Reference;
import java.sql.DataTruncation;
import java.util.HashMap;
import java.util.Map;

public class PatientProfile extends AppCompatActivity{

    public static final String NAME_KEY = "name";
    public static final String GENDER_KEY = "gender";
    public static final String DOB_KEY = "dob";
    public static final String PHONE_KEY = "phone";
    public static final String EMERGENCYCONTACT_KEY = "emergencyContact";
    public static final String EMERGENCYPHONE_KEY = "emergencyPhone";
    public static final String EMAIL_KEY = "email";
    public static final String HEIGHT_KEY = "height";
    public static final String WEIGHT_KEY = "weight";
    public static final String DOCTOR_KEY = "doctor";
    public static final String DOCTORTYPE_KEY = "doctorType";
    public static final String MEDCONDITION_KEY = "medCondition";
    private static final String TAG = "MainActivity";
    private Button saveButton;

    private DocumentReference mDocRef = FirebaseFirestore.getInstance().document("profile/patient");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patient_profile);

        /*
        saveButton = (Button) findViewById(R.id.saveBtn);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }


        });*/
    }
        public void openDialog() {
            Dialog dialog = new Dialog();
            dialog.show(getSupportFragmentManager(), "dialog");
        }


        public void saveProfile(View view){
            EditText editName = (EditText) findViewById(R.id.editName);
            EditText editGender = (EditText) findViewById(R.id.editGender);
            EditText editDOB = (EditText) findViewById(R.id.editDOB);
            EditText editPhone = (EditText) findViewById(R.id.editPhone);
            EditText editEmergencyContact = (EditText) findViewById(R.id.editEmergencyContact);
            EditText editEmergencyPhone = (EditText) findViewById(R.id.editEmergencyPhone);
            EditText editEmail = (EditText) findViewById(R.id.editEmail);
            EditText editHeight = (EditText) findViewById(R.id.editHeight);
            EditText editWeight = (EditText) findViewById(R.id.editWeight);
            EditText editDoctor = (EditText) findViewById(R.id.editDoctor);
            EditText editDoctorType = (EditText) findViewById(R.id.editDoctorType);
            EditText editMedCondition = (EditText) findViewById(R.id.editMedConditions);

            String nameText = editName.getText().toString();
            String genderText = editGender.getText().toString();
            String dobText = editDOB.getText().toString();
            String phoneText = editPhone.getText().toString();
            String emergencyContactText = editEmergencyContact.getText().toString();
            String emergencyPhoneText = editEmergencyPhone.getText().toString();
            String emailText = editEmail.getText().toString();
            String heightText = editHeight.getText().toString();
            String weightText = editWeight.getText().toString();
            String doctorText = editDoctor.getText().toString();
            String doctorTypeText = editDoctorType.getText().toString();
            String medConditionText = editMedCondition.getText().toString();


            if(nameText.isEmpty()
                    || dobText.isEmpty()
                    || phoneText.isEmpty()
                    || emergencyContactText.isEmpty()
                    || emergencyPhoneText.isEmpty()
                    || emailText.isEmpty())
            { return; }

            Map<String, Object> dataToSave = new HashMap<String, Object>();
            dataToSave.put(NAME_KEY, nameText);
            dataToSave.put(GENDER_KEY, genderText);
            dataToSave.put(DOB_KEY, dobText);
            dataToSave.put(PHONE_KEY, phoneText);
            dataToSave.put(EMERGENCYCONTACT_KEY, emergencyContactText);
            dataToSave.put(EMERGENCYPHONE_KEY, emergencyPhoneText);
            dataToSave.put(EMAIL_KEY, emailText);
            dataToSave.put(HEIGHT_KEY, heightText);
            dataToSave.put(WEIGHT_KEY, weightText);
            dataToSave.put(DOCTOR_KEY, doctorText);
            dataToSave.put(DOCTORTYPE_KEY, doctorTypeText);
            dataToSave.put(MEDCONDITION_KEY, medConditionText);

            mDocRef.set(dataToSave).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Log.d(TAG, "Document has been saved!");
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Log.w(TAG, "Document was not saved!", e);
                }
            });




            }

    }

