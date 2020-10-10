package com.wapazock.groovycomponents.blaze_box;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;

import com.wapazock.groovycomponents.R;


public class blazebox extends FrameLayout {

    public blazebox(@NonNull Context context) {
        super(context);
        init(null);
    }

    public blazebox(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public blazebox(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }


    //references
    TextView header ;
    EditText input ;
    RelativeLayout parentLayout ;
    boolean showHeader;

    //variables
    private static final String TAG = "blazebox";
    private Boolean ANIMATE ;


    private void init(AttributeSet attrs) {
        inflate(getContext(), R.layout.blaze_textbox,this);

        //set references
        header = findViewById(R.id.blaze_header);
        input = findViewById(R.id.blaze_input);
        parentLayout = findViewById(R.id.parentRelative);

        //presets

        header.setVisibility(GONE); //hides the header
        header.setScaleX(0.5f); //set scale to shrink
        header.setScaleY(0.5f);
        ANIMATE = true ;
        //showHeader = false ;

        onTyping(); //add animations

        //set attributes
        setAttributes(attrs);
    }

    private void onTyping() {
        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (ANIMATE) {
                    if (input.getText().toString().isEmpty()) {
                        header.setVisibility(GONE);
                        header.setScaleX(0.5f); //set scale to shrink
                        header.setScaleY(0.5f);
                    } else {
                        if (header.getScaleX() == 0.5f) {
                            Log.d(TAG, "onTextChanged: fire");
                            header.setVisibility(VISIBLE);
                            header.animate().scaleX(1f).setDuration(50);
                            header.animate().scaleY(1f).setDuration(50);
                            invalidate();
                        }
                    }
                }
                else {
                    if (input.getText().toString().isEmpty()) {
                        header.setVisibility(GONE);
                    } else {
                        header.setVisibility(VISIBLE);
                        header.setScaleX(1f);
                        header.setScaleY(1f);
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void setAttributes(AttributeSet attrs) {
        //check if there are attributes
        if (attrs == null)
            return; //break because there are no attributes

        //add attributes into a typed array
        TypedArray attributesArray = getContext().obtainStyledAttributes(attrs,R.styleable.blazebox);

        //set label
        String label = attributesArray.getString(R.styleable.blazebox_label);
        setLabel(label);

        //set style
        String style = attributesArray.getString(R.styleable.blazebox_style);
        setStyle(style);

    }



    private void setHeaderColor(int headerColor) {
        header.setTextColor(headerColor);
    }

    public void showHeader_(boolean showHeader) {
        if (showHeader) {
            header.setScaleY(1f);
            header.setScaleX(1f);
            header.setVisibility(VISIBLE);
        }
    }

    private void setTextSize(float textSize) {
         input.setTextSize(textSize);
    }

    private void setHeight(int height) {
        input.getLayoutParams().height = height ;
    }


    public void setAnimate(Boolean animate) {
        if (animate){
            ANIMATE = true ;
        }
        else {
            ANIMATE = false ;
        }
    }

    public void setFocusable(Boolean focusable){
        if (!focusable){
            input.setFocusable(false);
            input.setFocusableInTouchMode(false);
            setOnTouch();  //to make focusable because it starts of not
        }
    }

    public void setStyle(String style){
        if (style != null) {
            switch (style) {
                case "red":
                    header.setTextColor(getResources().getColor(R.color.red));
                    input.setBackgroundResource(R.drawable.blaze_red);
                    input.setTextColor(getResources().getColor(R.color.red));
                    input.setHintTextColor(getResources().getColor(R.color.red));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                        input.setTextCursorDrawable(R.color.red);
                    }
                    break;
                case "green":
                    header.setTextColor(getResources().getColor(R.color.green));
                    input.setBackgroundResource(R.drawable.blaze_green);
                    input.setHintTextColor(getResources().getColor(R.color.green));
                    input.setTextColor(getResources().getColor(R.color.green));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                        input.setTextCursorDrawable(R.color.green);
                    }
                    break;
                case "yellow":
                    header.setTextColor(getResources().getColor(R.color.yellow));
                    input.setBackgroundResource(R.drawable.blaze_yellow);
                    input.setTextColor(getResources().getColor(R.color.yellow));
                    input.setHintTextColor(getResources().getColor(R.color.yellow));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                        input.setTextCursorDrawable(R.color.yellow);
                    }
                    break;
                case "orange":
                    header.setTextColor(getResources().getColor(R.color.orange));
                    input.setBackgroundResource(R.drawable.blaze_orange);
                    input.setHintTextColor(getResources().getColor(R.color.orange));
                    input.setTextColor(getResources().getColor(R.color.orange));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                        input.setTextCursorDrawable(R.color.orange);
                    }
                    break;
                case "purple":
                    header.setTextColor(getResources().getColor(R.color.purple));
                    input.setBackgroundResource(R.drawable.blaze_purple);
                    input.setHintTextColor(getResources().getColor(R.color.purple));
                    input.setTextColor(getResources().getColor(R.color.purple));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                        input.setTextCursorDrawable(R.color.purple);
                    }
                    break;
                case "black":
                    header.setTextColor(getResources().getColor(R.color.black));
                    input.setBackgroundResource(R.drawable.blaze_black);
                    input.setTextColor(getResources().getColor(R.color.black));
                    input.setHintTextColor(getResources().getColor(R.color.black));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                        input.setTextCursorDrawable(R.color.black);
                    }
                    break;
                case "gray":
                    header.setTextColor(getResources().getColor(R.color.gray));
                    input.setBackgroundResource(R.drawable.blaze_gray);
                    input.setTextColor(getResources().getColor(R.color.gray));
                    input.setHintTextColor(getResources().getColor(R.color.gray));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                        input.setTextCursorDrawable(R.color.gray);
                    }
                    break;
                case "pink":
                    input.setHintTextColor(getResources().getColor(R.color.pink));
                    header.setTextColor(getResources().getColor(R.color.pink));
                    input.setBackgroundResource(R.drawable.blaze_pink);
                    input.setTextColor(getResources().getColor(R.color.pink));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                        input.setTextCursorDrawable(R.color.pink);
                    }
                    break;
            }
        }
    }

    public void setLabel(String label){
        if (label != null) {
            header.setText(label);
            input.setHint(label);
        }
    }

    /*
    This method returns focus to the textbox
     */
    private void setOnTouch() {
        input.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                input.setFocusable(true);
                input.setFocusableInTouchMode(true);
                return false;
            }
        });
    }

}
