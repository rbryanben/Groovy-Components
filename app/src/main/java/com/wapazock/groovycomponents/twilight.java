package com.wapazock.groovycomponents;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/*
   This is the class for twilight Edit Text , which is part of the Groovy Components
 */
public class twilight extends FrameLayout {

    public twilight(@NonNull Context context) {
        super(context);
        init(null);
    }

    public twilight(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public twilight(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }


    //references
    private EditText input ;
    private RelativeLayout marker ;

    /*
      This initialization method will set all references and variables as well as the presets
     */
    private void  init(AttributeSet set){
          //set view
          inflate(getContext(),R.layout.twilight_textbox,this);

          //reference
          input = findViewById(R.id.textInput);
          marker = findViewById(R.id.marker);

          //presets
          marker.setVisibility(GONE); //hide marker

          /*
             When user starts typing show marker , and clear when user clears text
           */
          input.addTextChangedListener(new TextWatcher() {
              @Override
              public void beforeTextChanged(CharSequence s, int start, int count, int after) {

              }

              @Override
              public void onTextChanged(CharSequence s, int start, int before, int count) {
                      if (input.getText().toString().isEmpty()){
                          marker.setVisibility(GONE);
                      }
                      else {
                          marker.setVisibility(VISIBLE);
                      }
              }

              @Override
              public void afterTextChanged(Editable s) {

              }
          });

    }
}
