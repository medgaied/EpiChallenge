package com.epi.epichallenge.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.epi.epichallenge.R;
import com.epi.epichallenge.task.InscriptionSync;
import com.epi.epichallenge.task.LoginSync;

/**
 * @author Saber Ben Khalifa <dev.saberkhalifda@gmail.com>
 * @date 4/4/18
 * @time 12:01 PM
 * @utitlity Main Activity
 */
public class Connexion extends Activity implements TextWatcher{
    //private Button btnConnexion;

    private EditText txtusername;
    private EditText txtpassword;

    private TextInputLayout usernameWrapper;
    private TextInputLayout passWrapper;
    private Button btnConnexion;
    private Button btnInscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion
        );

        this.btnConnexion = this.findViewById(R.id.btnConnexion);
        this.btnInscription = this.findViewById(R.id.btnInscription);
        this.txtpassword = this.findViewById(R.id.editTxtPassword);
        this.txtpassword.addTextChangedListener(this);

        this.txtusername = this.findViewById(R.id.editTxtusername);
        this.txtusername.addTextChangedListener(this);



        this.passWrapper = this.findViewById(R.id.passWrapper);
        this.usernameWrapper = this.findViewById(R.id.usernameWrapper);

        this.btnConnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                connexion();
            }
        });
        this.btnInscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Connexion.this,Inscription.class);
                startActivity(intent);
                finish();
            }
        });






    }



    /**
     * Event click to add ne person in sqllite database
     */
    private void  connexion() {
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
           new LoginSync(this).execute(txtusername.getText().toString(),txtpassword.getText().toString());
        }
    }

    /**
     * Validate if field is empty or not
     * @return
     */
    private boolean isFiedlEmpty() {
        boolean empty = false;
        if (txtusername.getText().toString().isEmpty()) {
            usernameWrapper.setError("Nom d'utilisateur est obligatoire");
            empty = true;
        }else
            usernameWrapper.setError(null);
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