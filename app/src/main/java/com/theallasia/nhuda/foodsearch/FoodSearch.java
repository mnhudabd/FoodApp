package com.theallasia.nhuda.foodsearch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.jar.Attributes;

public class FoodSearch extends AppCompatActivity {
    private EditText UserName;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private TextView regButton;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        UserName = (EditText)findViewById(R.id.etUName);
        Password = (EditText)findViewById(R.id.etPassword);
        Info = (TextView)findViewById(R.id.tvInfo);
        regButton = (TextView)findViewById(R.id.tvSignUp);
        Login = (Button)findViewById(R.id.btnLogin);

        Info.setText("No of attampts remaining: 5");

        Login.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View view){
                validate(UserName.getText().toString(), Password.getText().toString());
            }
        });

        regButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(FoodSearch.this, SignUp.class));
            }
        });

    }

    private void validate(String userName, String userPassword){
        if((userName.equals("admin")) && (userPassword.equals("1234"))){
            Intent intent = new Intent(FoodSearch.this, FoodActivity.class);
            startActivity(intent);
        }else{
            counter--;

            Info.setText("No of attempts remaining: " + String.valueOf(counter));

            if(counter == 0){
                Login.setEnabled(false);
            }
        }

    }
}
