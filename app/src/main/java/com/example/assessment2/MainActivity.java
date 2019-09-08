package com.example.assessment2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    //declare variables
    EditText editCustName, editPostCode;
    //send to next activity screen button
    Button sendDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //find customer name + suburb input view ID
        editCustName = (EditText) findViewById(R.id.editCustName);
        editPostCode = (EditText) findViewById(R.id.editPostCode);
        sendDetails = (Button) findViewById(R.id.btnToNextScreen);

        sendDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), cust_data.class);
                intent.putExtra("name", editCustName.getText().toString());
                intent.putExtra("0000", editPostCode.getText().toString());
                startActivity(intent);
            }
        });
    }

    //implicit intent to open web page
    public void openAmazon(View v) {
        String webPage = "https://www.amazon.com";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(webPage));
        startActivity(intent);
    }
}
