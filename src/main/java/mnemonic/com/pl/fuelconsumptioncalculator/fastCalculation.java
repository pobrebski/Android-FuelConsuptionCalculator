package mnemonic.com.pl.fuelconsumptioncalculator;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.*;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class fastCalculation extends ActionBarActivity {



    Button calculate;
    Button mmen;
    EditText ef;
    EditText ed;

    String sf;
    String sd;
    String sc;

    float f;
    float d;
    float c;
    public static final String sff="key";
    public static final String sdf="key2";

    boolean a=false;



    protected boolean validation(){ /*boolean*/
       ef=(EditText)findViewById(R.id.enterfuel);
       ed=(EditText)findViewById(R.id.enterdistance);

           sf = (ef.getText() + "").trim();
           sd = (ed.getText() + "").trim();

            if (sf.length() > 0 && sd.length() > 0) {
                a = true;
                //return true;
            }
            if (sf.length() > 0 && sd.length() == 0) {
                a = false;
                Toast.makeText(getApplicationContext(), "Enter distance ", Toast.LENGTH_SHORT).show();
            }
            if (sf.length() == 0 && sd.length() > 0) {
                a = false;
                Toast.makeText(getApplicationContext(), "Enter fuel amount ", Toast.LENGTH_SHORT).show();
            }
            if (sf.length() == 0 && sd.length() == 0) {
                a = false;
                Toast.makeText(getApplicationContext(), "Enter amounts ", Toast.LENGTH_SHORT).show();
            }

       return a;
      // if (a==false) {fastCalc(); finish();};
   }


    protected void calcCon(String calf, String calcd){
        f = Float.parseFloat(calf); //String.format("%.2f", floatValue);
        d = Float.parseFloat(calcd);
        c=f/d*100;
        sc = String.format("%.2f", c); //Float.toString(c);
        final TextView textViewToChange = (TextView) findViewById(R.id.consumption);
        textViewToChange.setText(sc);


    }


    public void okk(){
        Toast.makeText(getApplicationContext(), a+" ", Toast.LENGTH_SHORT).show();
    }

    public void fastCalc(){

        startActivity(new Intent(getApplicationContext(), fastCalculation.class));
    }

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_fast_calculation);
         setContentView(R.layout.common_activity);
       calculate = (Button) findViewById(R.id.Calculate);
         mmen = (Button) findViewById(R.id.quitf);
        OnClickListener lf = new OnClickListener() {
            @Override
            public void onClick(View v) {

                validation();
                if(a==true) calcCon(sf,sd);

            }
        };
        calculate.setOnClickListener(lf);

         OnClickListener lq = new OnClickListener() {
             @Override
             public void onClick(View v) {
                 finish();
             }
         };
         mmen.setOnClickListener(lq);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_fast_calculation, menu);
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
}
