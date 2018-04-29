package com.epi.epichallenge.activity;

import android.app.Activity;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.epi.epichallenge.R;
import com.epi.epichallenge.domain.User;
import com.epi.epichallenge.task.InscriptionSync;

/**
 * @author Saber Ben Khalifa <dev.saberkhalifda@gmail.com>
 * @date 4/4/18
 * @time 12:01 PM
 * @utitlity Main Activity
 */
public class Inscription extends Activity implements TextWatcher{
    //private Button btnInscription;

    private EditText txtusername;
    private EditText txtNom;
    private EditText txtPrenomn;
    private EditText txtEmail;
    private EditText txtpassword;
    private TextInputLayout nomWrapper;

    private TextInputLayout usernameWrapper;
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

        this.txtusername = this.findViewById(R.id.editTxtusername);
        this.txtusername.addTextChangedListener(this);

        this.nomWrapper = this.findViewById(R.id.nomWrapper);

        this.prenomWrapper = this.findViewById(R.id.prenomWrapper);

        this.emailWrapper = this.findViewById(R.id.emailWrapper);

        this.passWrapper = this.findViewById(R.id.passWrapper);

        this.usernameWrapper = this.findViewById(R.id.usernameWrapper);

        this.btnInscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                inscription();
            }
        });






    }



    /**
     * Event click to add ne person in sqllite database
     */
    private void  inscription() {
       /* String lastName = params[0];
        String fistName = params[1];
        String username = params[2];
        String password = params[3];
        String email = params[4];


        boolean enable =Boolean.parseBoolean(params[5]);
        boolean account_non_expired = Boolean.parseBoolean(params[6]);
        boolean account_non_locked = Boolean.parseBoolean(params[7]);
        boolean credentials_non_expired = Boolean.parseBoolean(params[8]);*/
        if (!isFiedlEmpty()) {

new InscriptionSync(this).execute(txtPrenomn.getText().toString(),txtNom.getText().toString(),txtusername.getText().toString(),
        txtpassword.getText().toString(),txtEmail.getText().toString());




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