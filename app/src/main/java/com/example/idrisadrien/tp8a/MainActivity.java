package com.example.idrisadrien.tp8a;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button sendSMS;
    private Button call;
    private String smsText;
    private String numero;
    private EditText number;
    private EditText text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // this pour stipuler qu'on utilise la variable de

        this.number = (EditText)findViewById(R.id.numText);
        this.text = (EditText)findViewById(R.id.smsText);




        Button send = (Button)findViewById(R.id.sendSMS);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 smsText = MainActivity.this.text.getText().toString();
                 numero = MainActivity.this.number.getText().toString();

                Uri uri = Uri.parse("smsto:" +  numero);
                Intent intent = new Intent(android.content.Intent.ACTION_SENDTO, uri);
                intent.putExtra("sms_body", smsText);
                startActivity(intent);
            }
        });


        Button call = (Button)findViewById(R.id.callNum);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numero = MainActivity.this.number.getText().toString();

                // Permet d'envoyer une information qu'on veut appeler au système
                Uri telephone = Uri.parse("tel:"+numero);
                Intent secondeActivite = new Intent(Intent.ACTION_DIAL, telephone);
                startActivity(secondeActivite);
            }
        });












    }








}
