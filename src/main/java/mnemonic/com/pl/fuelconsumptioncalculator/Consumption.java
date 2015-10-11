package mnemonic.com.pl.fuelconsumptioncalculator;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Consumption extends ActionBarActivity {

    Button confirm;
    Button btm;
    //View v = new View(this);
   // Consumption.setLayerType(View.LAYER_TYPE_SOFTWARE, null);

    public void addDtbEntry(String ssf, String ssd, String ssc){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        String dt = (dateFormat.format(cal.getTime())).toString(); //2014/08/06 16:00:22

        dtbMan adder = new dtbMan(this);
        adder.addEntry(ssf,ssd,ssc,dt);
        Toast.makeText(getApplicationContext(), "Entry added to the database ", Toast.LENGTH_LONG).show();
        adder.close();
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_consumption);
        setContentView(R.layout.common_relative);
        Intent intentInput = getIntent();
        Bundle bId = intentInput.getExtras();
        final String ssf = (String) bId.getString(registeredCalculation.sff);
        final String ssd = (String) bId.getString(registeredCalculation.sdf);
        final String ssc = (String) bId.getString(registeredCalculation.sdc);
        final TextView textViewToChange = (TextView) findViewById(R.id.yourinfo);
        textViewToChange.setText(ssf);
        final TextView textViewToChange2 = (TextView) findViewById(R.id.dbreginfo1);
        textViewToChange2.setText(ssd);
        final TextView textViewToChange3 = (TextView) findViewById(R.id.carconsumption1);
        textViewToChange3.setText(ssc);
        confirm = (Button) findViewById(R.id.confirm);
        View.OnClickListener lf = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               addDtbEntry(ssf,ssd,ssc);
                finish();
            }
        };
        confirm.setOnClickListener(lf);
        btm = (Button) findViewById(R.id.mmenu);
        View.OnClickListener mm = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(getApplicationContext(), start.class));
                finish();
            }
        };
        btm.setOnClickListener(mm);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_consumption, menu);
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
