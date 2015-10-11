package mnemonic.com.pl.fuelconsumptioncalculator;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class registeredCalculation extends ActionBarActivity {

    Button calculate;
    Button mmenn;
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
    public static final String sdc="key3";

   /* private void dtbRecord(float f, float d, float c) {
        dtbMan adder = new dtbMan(this);
        adder.addEntry(f,d,c);
    }*/

    public void cons(){
   Intent i = new Intent(registeredCalculation.this, Consumption.class);
        i.putExtra(sff,sf);
        i.putExtra(sdf,sd);
        i.putExtra(sdc,sc);
    startActivity(i);
        //startActivity(new Intent(getApplicationContext(), Consumption.class));
    }

   /* public void catcher(){

        try{
            Intent intentInput = getIntent();
            Bundle bundleInputData = intentInput.getExtras();
            sf = bundleInputData.getString(fastCalculation.sff);
            sd = bundleInputData.getString(fastCalculation.sdf);}
        catch(Exception e){} finally {}


    }*/
    //String sfi = bundleInputData.getString(fastCalculation.sff);
    //String sdi = bundleInputData.getString(fastCalculation.sdf);
    // String fa=ef.getText()+"";
    // String da=ed.getText()+"";


    boolean a=false;



    protected boolean validation(){ /*boolean*/
        ef=(EditText)findViewById(R.id.regenterfuel);
        ed=(EditText)findViewById(R.id.regenterdistance);

        sf = (ef.getText() + "").trim();
        sd = (ed.getText() + "").trim();
        //   f = Float.parseFloat(sf);
        //   d = Float.parseFloat(sd);


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
        sf = String.format("%.2f", f);
        sd = String.format("%.2f", d);
        final TextView textViewToChange = (TextView) findViewById(R.id.consumption);
        textViewToChange.setText(sc);
        //dtbRecord(f,d,c);
       // dtbMan adder = new dtbMan(this);
       // adder.addEntry(calf,calcd,sc);
       // Toast.makeText(getApplicationContext(), "Entry added to the database ", Toast.LENGTH_LONG).show();
    }




   /* @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("enterfuel", sf);
        outState.putString("enterdistance", sd);
        super.onSaveInstanceState(outState);
    }*/

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // TODO Auto-generated method stub
        super.onSaveInstanceState(outState);
        outState.putString("fuels", (String) ef.getText().toString());
        outState.putString("distances", (String) ed.getText().toString());
        outState.putString("calculations", sc);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onRestoreInstanceState(savedInstanceState);
        ef.setText(savedInstanceState.getString("fuels"));
        ed.setText(savedInstanceState.getString("distances"));
    }


    public void okk(){
        Toast.makeText(getApplicationContext(), a+" ", Toast.LENGTH_SHORT).show();
    }

    public void fastCalc(){
   /* Intent i = new Intent(this,fastCalculation.class);
    startActivity(i);*/
        startActivity(new Intent(getApplicationContext(), registeredCalculation.class));

    }

    // public void fastCalc2(){
   /* Intent i = new Intent(this,fastCalculation.class);
    startActivity(i);*/
       /* Intent i = new Intent(getApplicationContext(), fastCalculation.class);
        i.putExtra(sff,(String) ef.getText().toString());
        i.putExtra(sdf,(String) ed.getText().toString());
        startActivity(i);

    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_registered_calculation);
        setContentView(R.layout.common_registered);
       /* if(savedInstanceState!=null){
        ef.setText(savedInstanceState.getString("fuels"));
        ed.setText(savedInstanceState.getString("distances"));}*/

        // String gotfuel = bundleInputData.getString(fastCalculation.sf);
        // String gotDistance = bundleInputData.getString(fastCalculation.sd);

        calculate = (Button) findViewById(R.id.regCalculate);
        View.OnClickListener lf = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validation();
                if(a==true) {calcCon(sf,sd); cons(); finish();}


            }
        };
        calculate.setOnClickListener(lf);

        mmenn = (Button) findViewById(R.id.quitff);
        View.OnClickListener lq = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        };
        mmenn.setOnClickListener(lq);


    }

    //odtworzenie danych z pamieci po zabiciu
   /* public void onRestoreInstanceState(Bundle savedInstanceState) {
        // Always call the superclass so it can restore the view hierarchy
        super.onRestoreInstanceState(savedInstanceState);

        // Restore state members from saved instance

        mCurrentScore = savedInstanceState.getInt(STATE_SCORE);
        mCurrentLevel = savedInstanceState.getInt(STATE_LEVEL);
    }*/



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_registered_calculation, menu);
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
