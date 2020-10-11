# Groovy-Components
Stylish Android UI Components



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
		implementation 'com.github.User:Repo:1.0'
	}
  
# Usage
  
    <com.wapazock.groovycomponents.blaze_box.blazebox
        android:layout_width="match_parent"
        android:layout_height="70dp"
        app:layout_constraintTop_toTopOf="parent"
        android:layout_marginLeft="20dp"
        android:layout_marginRight="20dp"
        app:label="username"/>
