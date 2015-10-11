package mnemonic.com.pl.fuelconsumptioncalculator;

import android.app.Activity;
import android.content.*;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.view.View.*;
import android.widget.Toast;


public class start extends Activity {


public void fastCalc(){
   /* Intent i = new Intent(this,fastCalculation.class);
    startActivity(i);*/
    startActivity(new Intent(getApplicationContext(), fastCalculation.class));
}

    public void regCalc(){
   /* Intent i = new Intent(this,fastCalculation.class);
    startActivity(i);*/
        startActivity(new Intent(getApplicationContext(), registeredCalculation.class));
    }
    public void dromader(View v){
        Toast.makeText(getApplicationContext(), "not yet supported", Toast.LENGTH_SHORT).show();
    }

    public void history(){
        startActivity(new Intent(getApplicationContext(), EntryList.class));
    }


    Button fast;
    Button calc;
    Button hist;
    Button man;
    Button quitter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        fast = (Button) findViewById(R.id.bfast);
        calc = (Button) findViewById(R.id.bcalc);
        hist = (Button) findViewById(R.id.bhist);
        quitter = (Button) findViewById(R.id.exit);
       OnClickListener lf = new OnClickListener() {
            @Override
            public void onClick(View v) {
                fastCalc();
                 }
            };
        fast.setOnClickListener(lf);
        OnClickListener lc = new OnClickListener() {
            @Override
        public void onClick(View v){
                regCalc();
            }
        };
        calc.setOnClickListener(lc);
       // calc=(Button) findViewById(R.id.bcalc);
        //hist.setOnClickListener(lh);
        OnClickListener lh = new OnClickListener() {
            @Override
            public void onClick(View v){
            //startActivity(new Intent(getApplicationContext(), dtbMan.class));
            history();
            }
        };
        hist.setOnClickListener(lh);

        OnClickListener lq = new OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        };
        quitter.setOnClickListener(lq);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_start, menu);
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
