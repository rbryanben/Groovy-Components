package com.wapazock.groovycomponents.twilight;

import android.content.Context;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.wapazock.groovycomponents.R;

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
    private TextView header ;

    /*
      This initialization method will set all references and variables as well as the presets
     */
    private void  init(AttributeSet set){
          //set view
          inflate(getContext(), R.layout.twilight_textbox,this);

          //reference
          input = findViewById(R.id.textInput);
          marker = findViewById(R.id.marker);
          header = findViewById(R.id.textView);

          //presets
          marker.setAlpha(0f); //hide marker
          header.setScaleX(0.8f); // shrink header
          header.setScaleY(0.8f);

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
                         marker.animate().alpha(0f).setDuration(100); //animate to 0 marker
                          animateHeader(100,0.8f); //shrink and hide header


                      }
                      else {
                          marker.animate().alpha(1f).setDuration(100); // animate to 1 marker

                          animateHeader(100,1f); //enlarge header
                      }
              }

              @Override
              public void afterTextChanged(Editable s) {

              }
          });


    }


    /*
       This function will animate the header
     */
    public void animateHeader(int duration , float scale){
         header.animate().scaleY(scale).setDuration(duration);
         header.animate().scaleX(scale).setDuration(duration);
    }
}
