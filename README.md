# Groovy-Components
Stylish Android UI Components

<img src="https://user-images.githubusercontent.com/63599157/95677636-1265f000-0bc7-11eb-814b-ed73413642c3.gif" width=300 /> 

# Installation
In you project level build.gradle add
     
     allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

In your app level build.gradle

    dependencies {
		implementation 'com.github.rbryanben:Groovy-Components:1.0'
	}
  
# Usage
  
    <com.wapazock.groovycomponents.blaze_box.blazebox
        android:layout_width="match_parent"
        android:layout_height="70dp"
        app:layout_constraintTop_toTopOf="parent"
        android:layout_marginLeft="20dp"
        android:layout_marginRight="20dp"
        app:label="username"/>
	
# XML Attributes

    app:label="enter label here"
    app:style="enter your style here" 
	
Styles include {blue , purple, red , green , blue, orange , yellow ,black , gray , pink } 
 	
#  Attributes
These Attributes are accessed programatically 
    
    setHeaderColor(int headerColor); 
    showHeader_(boolean showHeader);
    setTextSize(float textSize);
    setHeight(int height);
    setAnimate(Boolean animate);
    setFocusable(Boolean focusable); //will set if the textbox should start focused
    setStyle(String style);
    setLabel(String label);
