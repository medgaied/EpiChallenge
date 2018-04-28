package com.epi.epichallenge.Activity;
import com.epi.epichallenge.R;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class connexion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);


        Button valider = findViewById(R.id.btnConnexion);



        valider.setOnClickListener(new View.OnClickListener() {
            EditText login = findViewById(R.id.editTxtuser);
            EditText password = findViewById(R.id.editTxtPassword);

            @Override
            public void onClick(View v) {
                // TextView textloginnonv = findViewById(R.id.txtverif1);
                // TextView textpasswordnonv = findViewById(R.id.txtverif2);

                if (!login.getText().toString().equals("") && !password.getText().toString().equals(""))
                {

                }

                else {
//saidkh007
                    //said123456
                    }
                    //textpasswordnonv.setVisibility(TextView.VISIBLE);


                }


                // Toast toast= Toast.makeText(MainActivity.this,"Input vide",Toast.LENGTH_SHORT);
                //toast.show();


        });

    }


}