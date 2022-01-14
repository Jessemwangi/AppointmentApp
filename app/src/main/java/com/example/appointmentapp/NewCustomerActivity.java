package com.example.appointmentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NetworkResponse;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.toolbox.JsonObjectRequest;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class NewCustomerActivity extends AppCompatActivity {
EditText cust_full_name,cust_contacts,Txtemail,TxtPassword;
Spinner SpWard;
RadioGroup GPgender;
Button btnReg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_customer);

        cust_full_name=findViewById(R.id.cust_full_name);
        cust_contacts=findViewById(R.id.cust_contacts);
        Txtemail=findViewById(R.id.Txtemail);
        TxtPassword=findViewById(R.id.TxtPassword);
        SpWard=findViewById(R.id.SpWard);
        GPgender=findViewById(R.id.GPgender);

        btnReg=findViewById(R.id.btnReg);

        btnReg.setOnClickListener(v -> {
            try {
                register();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        try {
            fillspward();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void fillspward() throws JSONException
    {
        JSONObject jsonObject=new JSONObject();
        JsonObjectRequest Newrequest = new JsonObjectRequest(

                Request.Method.GET,URLS.getmaindepat,jsonObject,response -> {
            try{
                    String Maindept = response.toString();

//                SpinnerAdapter adapter;
//                SpWard.setAdapter(adapter);
                }
                catch (Exception e){
                    Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
                }
        }, volleyError -> {
//                    progressDialog.dismiss();
            String message = null;
            if (volleyError instanceof NetworkError) {
                Toast.makeText(this, " Cannot connect to Internet...Please check your connection!", Toast.LENGTH_LONG).show();
            } else if (volleyError instanceof ServerError) {
                message = "The server could not be found. Please try again after some time!!";
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
            } else if (volleyError instanceof AuthFailureError) {
                message = "Authentication Failed...Please check your Permissions!";
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
            } else if (volleyError instanceof ParseError) {
                message = "Parsing error! Please try again after some time!!";
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
            } else if (volleyError instanceof NoConnectionError) {
                message = "Cannot connect to Internet...Please check your connection!";
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
            } else if (volleyError instanceof TimeoutError) {
                message = "Connection TimeOut! Please check your internet connection.";
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), volleyError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }) {


            @Override
            protected Response parseNetworkResponse(NetworkResponse response) {
                return null;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
//               User user = SharedPrefManager.getInstance(getApplicationContext()).getToken();
//                String Token = user.getJwtToken();
//                params.put("Authorization", "Bearer " + Token);
                return params;
            }

        };
//        Mysingleton.getInstance(getApplicationContext()).addToRequestQueue(request);
    }


    public void register() throws JSONException {
        JSONObject jsonObject=new JSONObject();

        jsonObject.put("custEmail","jesse");
        jsonObject.put("custFullName","peter");
        jsonObject.put("custPass","null");
        jsonObject.put("custWard","soy");
        jsonObject.put("custID","1");
        jsonObject.put("custContacts","099786767673");
        jsonObject.put("gender","male");

/*
* {
"custEmail": "jesse",
    "custFullName": "peter",
    "custPass": "null",
    "custWard": "soy",
    "custID": "1",
    "custContacts": "099786767673",
    "gender": "male"
}
* */        JsonObjectRequest request = new JsonObjectRequest
                (Request.Method.POST, URLS.REGISTER, jsonObject, response -> {

                    try {

                        Toast.makeText(this, response.toString(), Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();

                    }
                }, volleyError -> {
//                    progressDialog.dismiss();
                    String message = null;
                    if (volleyError instanceof NetworkError) {
                        Toast.makeText(this, " Cannot connect to Internet...Please check your connection!", Toast.LENGTH_LONG).show();
                    } else if (volleyError instanceof ServerError) {
                        message = "The server could not be found. Please try again after some time!!";
                        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                    } else if (volleyError instanceof AuthFailureError) {
                        message = "Authentication Failed...Please check your Permissions!";
                        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                    } else if (volleyError instanceof ParseError) {
                        message = "Parsing error! Please try again after some time!!";
                        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                    } else if (volleyError instanceof NoConnectionError) {
                        message = "Cannot connect to Internet...Please check your connection!";
                        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                    } else if (volleyError instanceof TimeoutError) {
                        message = "Connection TimeOut! Please check your internet connection.";
                        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), volleyError.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }) {


            @Override
            protected Response parseNetworkResponse(NetworkResponse response) {
                return null;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
//               User user = SharedPrefManager.getInstance(getApplicationContext()).getToken();
//                String Token = user.getJwtToken();
//                params.put("Authorization", "Bearer " + Token);
                return params;
            }

        };
        Mysingleton.getInstance(getApplicationContext()).addToRequestQueue(request);
    }
}