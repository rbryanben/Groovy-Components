package com.wapazock.groovycomponents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.wapazock.groovycomponents.blaze_box.blazebox;
import com.wapazock.groovycomponents.twilight.twilight;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

     //this is a list of cities in Zimbabwe
    ArrayList<String> ZIMBABWEAN_CITIES = new ArrayList();

    //variables
    private static final String TAG = "MainActivity";

    //references
    private twilight address , email ;
    private Button login ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //references
        address = findViewById(R.id.address);
        email = findViewById(R.id.email);
        login = findViewById(R.id.login);


        //populate zim cities
        populateZimCities();

        //login on click
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String addressString = address.getText(); //get address
                String emailString = email.getText(); // get email

                //check if the address is zimbabwean
                if (isFromZimbabwe(addressString)){
                    Log.d(TAG, "onClick: is from Zimbabwe");
                }
                else {
                    //show toast person should be from zimbabwe
                    Toast.makeText(MainActivity.this,"You should be from Zimbabwe", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    /*
       This function checks if a string contains a city from zimbabwe
     */
    public boolean isFromZimbabwe(String address){
        for (String city : ZIMBABWEAN_CITIES){
            if (address.contains(city)){
                return true ;
            }
        }

        return false ;
    }


    /*
      This procedure will populate zim cities
     */
    private void populateZimCities() {
        ZIMBABWEAN_CITIES.add("Harare");
        ZIMBABWEAN_CITIES.add("Bulawayo");
        ZIMBABWEAN_CITIES.add("Mutare");
        ZIMBABWEAN_CITIES.add("Gweru");
        ZIMBABWEAN_CITIES.add("Gwanda");
    }
}