package com.example.assessment2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class cust_data extends AppCompatActivity {
    //receive details
    TextView name;
    TextView postCode;
    TextView custArea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cust_data);

        //get details
        name = (TextView) findViewById(R.id.getCustName);
        postCode = (TextView) findViewById(R.id.getPostCode);
        custArea = (TextView) findViewById(R.id.custSuburbString);

        //set text on screen
        name.setText(getIntent().getStringExtra("name"));
        postCode.setText(getIntent().getStringExtra("0000"));

        //get postCode value and convert to int
        String postCodeValue = postCode.getText().toString();
        int postV;

        try {
            postV = Integer.parseInt(postCodeValue.trim());
        } catch (NumberFormatException e) {
            postV = 0;
        }

        //if >2999 and < 4000, customer lives in VIC. else does not
        if (postV > 2999 && postV < 4000) {
            custArea.setText(getIntent().getStringExtra("name") + " lives in VIC");
        } else {
            custArea.setText(getIntent().getStringExtra("name") + " does not live in VIC");
        }
    }

    //previous screen activity button
    public void previousActBtn(View view) {
        Intent previousIntent = new Intent(cust_data.this, MainActivity.class);
        startActivity(previousIntent);
    }
}
