package org.green.loginrooms;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextUserName;
    private EditText editTextPassword;
    private Button buttonLogin;
    private TextView textViewSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextUserName = findViewById(R.id.editTextUserName);
        editTextPassword = findViewById(R.id.editTextPassword);
        textViewSignUp = findViewById(R.id.textViewSignUp);

        buttonLogin = findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = editTextUserName.getText().toString();
                String password = editTextPassword.getText().toString();
                new LoginAsync().execute(userName, password);
            }
        });


        textViewSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
    }

    public class LoginAsync extends AsyncTask<String, Void, User>{

        @Override
        protected User doInBackground(String... strings) {
            return DatabaseManager.getInstance().getDatabase().userDao().login(strings[0], strings[1]);
        }

        @Override
        protected void onPostExecute(User user) {
            super.onPostExecute(user);
            if (user != null) {
                Snackbar.make(buttonLogin, "Hello! " + user.getUserName(), Snackbar.LENGTH_SHORT).show();
            } else {
                Snackbar.make(buttonLogin, "User doesn't exist!", Snackbar.LENGTH_SHORT).show();
            }
        }
    }
}
