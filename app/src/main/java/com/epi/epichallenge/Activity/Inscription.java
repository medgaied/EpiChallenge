package com.epi.epichallenge.Activity;

import android.content.Intent;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.os.Bundle;

import com.epi.epichallenge.R;
import com.epi.epichallenge.domain.User;

/**
 * @author Saber Ben Khalifa <dev.saberkhalifda@gmail.com>
 * @date 4/4/18
 * @time 12:01 PM
 * @utitlity Main Activity
 */
public class Inscription extends AppCompatActivity implements TextWatcher{
    //private Button btnInscription;

    private EditText txtNom;
    private EditText txtPrenomn;
    private EditText txtEmail;
    private EditText txtpassword;
    private TextInputLayout nomWrapper;
    private TextInputLayout prenomWrapper;
    private TextInputLayout emailWrapper;
    private TextInputLayout passWrapper;
    private Button btnInscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        this.btnInscription = this.findViewById(R.id.btnInscription);

        this.txtNom = this.findViewById(R.id.editTxtNom);
        this.txtNom.addTextChangedListener(this);

        this.txtPrenomn = this.findViewById(R.id.editTxtPrenom);
        this.txtPrenomn.addTextChangedListener(this);

        this.txtEmail = this.findViewById(R.id.editTxtEmail);
        this.txtEmail.addTextChangedListener(this);

        this.txtpassword = this.findViewById(R.id.editTxtPassword);
        this.txtpassword.addTextChangedListener(this);

        this.nomWrapper = this.findViewById(R.id.nomWrapper);
        this.prenomWrapper = this.findViewById(R.id.prenomWrapper);
        this.emailWrapper = this.findViewById(R.id.emailWrapper);
        this.passWrapper = this.findViewById(R.id.passWrapper);


        this.btnInscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addPerson();
            }
        });






    }



    /**
     * Event click to add ne person in sqllite database
     */
    private void addPerson() {
        if (!isFiedlEmpty()) {
            User user = new User();
            user.setLastName(txtPrenomn.getText().toString());
            user.setFirstName(txtNom.getText().toString());
            user.setEmail(txtEmail.getText().toString());
            user.setPassword(txtpassword.getText().toString());



            txtNom.setText("");
            txtPrenomn.setText("");
            txtpassword.setText("");
            txtEmail.setText("");

        }
    }

    /**
     * Validate if field is empty or not
     * @return
     */
    private boolean isFiedlEmpty() {
        boolean empty = false;
        if (txtNom.getText().toString().isEmpty()) {
            nomWrapper.setError("Nom est obligatoire");
            empty = true;
        } else
            nomWrapper.setError(null);

        if (txtPrenomn.getText().toString().isEmpty()) {
            prenomWrapper.setError("Prénom est obligatoire");
            empty = true;
        }else
            txtPrenomn.setError(null);

        if (txtEmail.getText().toString().isEmpty()) {
            emailWrapper.setError("Email est obligatoire");
            empty = true;
        }else
            txtEmail.setError(null);

        if (txtpassword.getText().toString().isEmpty()) {
            passWrapper.setError("Mot de passe est obligatoire");
            empty = true;
        }else
            txtpassword.setError(null);
        return empty;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        isFiedlEmpty();
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}