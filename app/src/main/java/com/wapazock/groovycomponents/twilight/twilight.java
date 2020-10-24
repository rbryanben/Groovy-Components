package com.wapazock.groovycomponents.twilight;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.solver.state.Reference;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.wapazock.groovycomponents.R;

import java.lang.invoke.ConstantCallSite;

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

    private ImageView icon ;
    private ConstraintLayout back ;

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

          back = findViewById(R.id.body);
          icon = findViewById(R.id.icon);

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


          if (set == null){  //don't do anything if the set is null
              return;
          }
          /*
             set attributes
           */
          TypedArray attributes = getContext().obtainStyledAttributes(set , R.styleable.twilight);
          String label = attributes.getString(R.styleable.twilight_label_); // label

        String style =  attributes.getString(R.styleable.twilight_style_); //set theme
        if (style != null) {
            switch (style) {
                case "blue":
                    back.setBackgroundResource(R.drawable.twilight_blue);
                    break;
                case "green":
                    back.setBackgroundResource(R.drawable.twilight_green);
                    break;
                case "orange":
                    back.setBackgroundResource(R.drawable.twilight_orange);
                    break;
                case "pink":
                    back.setBackgroundResource(R.drawable.twilight_pink);
                    break;
                case "purple":
                    back.setBackgroundResource(R.drawable.twilight_purple);
                    break;
                case "red":
                    back.setBackgroundResource(R.drawable.twilight_red);
                    break;
                case "yellow":
                    back.setBackgroundResource(R.drawable.twilight_yellow);
                    break;

            }
        }
        header.setText(label);

        int iconSet = attributes.getResourceId(R.styleable.twilight_icon_ , R.drawable.ic_location); //set icon
        icon.setImageResource(iconSet);

        int textColor = attributes.getColor(R.styleable.twilight_text_color_, Color.WHITE); //text color
        input.setTextColor(textColor);

        int headerColor = attributes.getColor(R.styleable.twilight_header_color_ , Color.WHITE); //set header color
        header.setTextColor(headerColor);

        int hintColor = attributes.getColor(R.styleable.twilight_hint_color_, Color.WHITE); //set hint color
        input.setHintTextColor(hintColor);

        String hintText = attributes.getString(R.styleable.twilight_hint_text_); // hint text
        input.setHint(hintText);

        int markerColor = attributes.getColor(R.styleable.twilight_marker_color, Color.WHITE);  //marker color
        marker.setBackgroundColor(markerColor);
    }

    private static final String TAG = "twilight";


    /*
       This procedure will animate the header
     */
    public void animateHeader(int duration , float scale){
         header.animate().scaleY(scale).setDuration(duration);
         header.animate().scaleX(scale).setDuration(duration);
    }

    /*
       This is a procedure to set the style programmatically
     */
    public void setStyle(String style){
        switch (style) {
            case "blue":
                back.setBackgroundResource(R.drawable.twilight_blue);
                break;
            case "green":
                back.setBackgroundResource(R.drawable.twilight_green);
                break;
            case "orange":
                back.setBackgroundResource(R.drawable.twilight_orange);
                break;
            case "pink":
                back.setBackgroundResource(R.drawable.twilight_pink);
                break;
            case "purple":
                back.setBackgroundResource(R.drawable.twilight_purple);
                break;
            case "red":
                back.setBackgroundResource(R.drawable.twilight_red);
                break;
            case "yellow":
                back.setBackgroundResource(R.drawable.twilight_yellow);
                break;
        }
    }

    /*
      This procedure will set the icon programmatically
     */
    public void setIcon(int iconImage){
        icon.setImageResource(iconImage);
    }

    /*
      This procedure will set the text color
     */
    public void setTextColor(int Color){
        input.setTextColor(Color);
    }

    /*
      This procedure will set the header color programmatically
     */
    public void setHeaderColor(int headerColor){
        header.setTextColor(headerColor);
    }

    /*
      This procedure will set the hint color
     */
    public  void setHintColor(int color){
        input.setHintTextColor(color);
    }


    /*
      This function will get you the style
     */
    public int getStyle(){
         return back.getSolidColor();
    }

    /*
       This function will get you the text
     */
    public String getText(){
        return input.getText().toString();
    }


    /*
      This function will get you the text color
     */
    public int getTextColor(){
        return input.getTextColors().getDefaultColor();
    }

    /*
      This function will get you the text hint
     */
    public String getHint(){
        return input.getHint().toString();
    }

    /*
       This function returns the marker color
     */
    public int getMarkerColor(){
        return marker.getSolidColor();
    }
}
