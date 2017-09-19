package org.green.loginrooms;

import android.database.sqlite.SQLiteConstraintException;
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
                user.setUserName(editTextUserName.getText().toString());
                user.setPassword(editTextPassword.getText().toString());

                Phones phones = new Phones();
                phones.setCellPhone("3208378947");
                phones.setHomePhone("7490322");
                phones.setWorkPhone("01800010202010");

                user.setPhones(phones);
                //user.setRoleId(1);

                new RegisterAsync().execute(user);
            }
        });
    }

    public class RegisterAsync extends AsyncTask<User, Void, SQLiteConstraintException> {

        @Override
        protected SQLiteConstraintException doInBackground(User... users) {
            try{
                DatabaseManager.getInstance().getDatabase().userDao().insertUser(users[0]);
            }catch (SQLiteConstraintException exception){
                return exception;
            }
            return null;
        }

        @Override
        protected void onPostExecute(SQLiteConstraintException aVoid) {
            super.onPostExecute(aVoid);
            if(aVoid != null){
                Snackbar.make(buttonRegister, aVoid.getMessage(), Snackbar.LENGTH_SHORT).show();
            } else {
                Snackbar.make(buttonRegister, "User Registered!", Snackbar.LENGTH_SHORT).show();

                RegisterActivity.this.finish();
            }

        }
    }

}
