package com.example.mycompany.myndklibapp;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    TextView tv;
    Button button;
    EditText num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        // Example of a call to a native method
        tv = (TextView) findViewById(R.id.sample_text);
        //Setting font for tv , Typeface is alt+enter
        Typeface face = Typeface.createFromAsset(getAssets(),
                "KlinicSlabMedium.otf");
        tv.setTypeface(face);

        //For taking user input
        num = (EditText) findViewById(R.id.inputnumber) ;

        //The buttone
        button = (Button)findViewById(R.id.button);
        button.setText("Submit");
        button.setTypeface(face);


        final int fourtyTwo = MyNativeClass.fourtyTwo();
        String tmp= String.valueOf(fourtyTwo); //Converting fourtyTwo to strin gso that it can print out
        if (fourtyTwo == 42) {
            //tv.setText(tmp);
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value=num.getText().toString(); //Getting from EditText

                tv.setText(value); //Viewing on TextView
                int finalValue= Integer.parseInt(value);     //CONVERT TO INTEGER


                ///////////////////FUNCTION CALL
                double fac = MyNativeClass.factorial(finalValue);
                //View
                String temp= String.valueOf(fac); //Converting fac to string so that it can print out
                tv.setText(temp);                //Viewing on TextView
            }
        });

        //tv.setText(fourtyTwo);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
