package org.green.loginrooms;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    private EditText editTextId;
    private EditText editTextUserName;
    private EditText editTextPassword;
    private Button buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editTextId = findViewById(R.id.editTextId);
        editTextUserName = findViewById(R.id.editTextUserName);
        editTextPassword = findViewById(R.id.editTextPassword);

        buttonRegister = findViewById(R.id.buttonRegister);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User();
                user.setId(editTextId.getText().toString());
                user.setUserName(editTextUserName.getText().toString());
                user.setPassword(editTextPassword.getText().toString());

                new RegisterAsync().execute(user);
            }
        });
    }

    public class RegisterAsync extends AsyncTask<User, Void, Void> {

        @Override
        protected Void doInBackground(User... users) {
            DatabaseManager.getInstance().getDatabase().userDao().insertUser(users[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Snackbar.make(buttonRegister, "User Registered!", Snackbar.LENGTH_SHORT).show();
            RegisterActivity.this.finish();
        }
    }

}
