package mnemonic.com.pl.fuelconsumptioncalculator;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.internal.widget.AdapterViewCompat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class EntryList extends ActionBarActivity {

    ListView lk;
    dtbMan lists = new dtbMan(this);
    List<String> nowa = new ArrayList<String>();
    ArrayList<entries> recr = new ArrayList<entries>();
    Button drop;
    Button delete;
    Button main;
    SQLiteDatabase dp;
    SQLiteDatabase dpp;
    int lister=-1;
    String nr;
    String day;
    String fuel;
    String distance;
    String consumption;
    String dayr;
    String fuelr;
    String distancer;
    String consumptionr;
    int no;

    public void recreation(){

        Cursor r = lists.readDtb();


        Log.d("stworzyl kursor i ent","while");
        while(r.moveToNext()){
            entries ent = new entries();
            ent.setIdrefueling(r.getInt(0));
           // no=r.getInt(0);

            nr = Integer.toString(r.getInt(0));
            ent.setRefdate(r.getString(1));
            Log.d("dodal refdate","while");
            day = r.getString(1);
            ent.setLitre(r.getString(2));
            Log.d("dodal litry","while");
            fuel = r.getString(2);
            ent.setKilometres(r.getString(3));
            Log.d("dodal kilometry","while");
            distance = r.getString(3);
            ent.setConsumption(r.getString(4));
            Log.d("dodal consumption","while");
            consumption = r.getString(4);

            recr.add(ent);
            Log.d("dodal ent do array","while");
            // if(cur.isLast()){lists.close(); cur.close();}
            // lk.getAdapter(nowa);
            // lk.setText(lk.getText()+"\n"+fuel+""+distance+""+consumption);

        }
       /* if(no==lister) continue;
        Log.d("przeskoczyl","while");*/
        recr.remove(lister);

        dp = lists.getWritableDatabase();
        lists.delEntr(dp);
        lists.onCreate(dp);
       // dp=dpp;
        Log.d("skasowal i utworzyl baze","while");
        //entries ent2=new entries();
        for(int i=0;i<recr.size();i++){
            Log.d("zaczyna wpisywać","for");
            entries ent2=new entries();
        //addEntry(String litre, String kilometers, String consumption, String da){
        ent2=recr.get(i);
            Log.d("stworzyl ent z array","for");
        lists.addEntry(ent2.getLitre(), ent2.getKilometres(), ent2.getConsumption(), ent2.getRefdate());
            Log.d("dodal do bazy","for");
        }
        lists.close();
        Log.d("zamknal liste","po for");
        r.close();
        Log.d("Zaknal kursor","po for");

    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry_list);
        lk = (ListView) findViewById(R.id.listView);
        lk.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        Cursor cur = lists.readDtb();

        while(cur.moveToNext()){
            nr = Integer.toString(cur.getInt(0));
            day = cur.getString(1);
            fuel = cur.getString(2);
            distance = cur.getString(3);
            consumption = cur.getString(4);
            nowa.add(nr+ ". Date: " +day+"\nFuel amount: "+fuel+"\nDistance: "+distance+"\nConsumption: "+consumption);
           // if(cur.isLast()){lists.close(); cur.close();}
            // lk.getAdapter(nowa);
           // lk.setText(lk.getText()+"\n"+fuel+""+distance+""+consumption);

        }
        lists.close();cur.close();

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                nowa );

        lk.setAdapter(arrayAdapter);
        lk.setSelector(R.drawable.bcgrnd);
        lk.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                lister = position;
                String item = (String) lk.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(),"You selected : " + item, Toast.LENGTH_SHORT).show();

            }

                                  });


        drop = (Button) findViewById(R.id.drop);
        View.OnClickListener lf = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dp = lists.getWritableDatabase();
                lists.delEntr(dp);
                lists.onCreate(dp);
                startActivity(new Intent(getApplicationContext(), start.class));
                dp.close();
                finishActivity(0);
            }
        };
        drop.setOnClickListener(lf);


        main = (Button) findViewById(R.id.main);
        View.OnClickListener mf = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
               //finishActivity(0);
            }
        };
        main.setOnClickListener(mf);


        delete = (Button) findViewById(R.id.delete);
        View.OnClickListener dl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //dp = lists.getWritableDatabase();
                if(lister==-1){ Toast.makeText(getApplicationContext(), "Mark row to delete first ", Toast.LENGTH_SHORT).show();}
                //lists.delOne(dp, lister);
                recreation();

               /* lists.delOne(lister);
                int z = lister;
                for(int i=0;i<nowa.size();i++){
                    if(i==z){nowa.remove(i);}
                }*/
                Toast.makeText(getApplicationContext(),"You deleted row: " +(++ lister), Toast.LENGTH_SHORT).show();
               // dp.close();
               // startActivity(new Intent(getApplicationContext(), EntryList.class));
                finishActivity(0);
                startActivity(new Intent(getApplicationContext(), EntryList.class));
              /*  lists.delEntr(dp);
                lists.onCreate(dp);
                startActivity(new Intent(getApplicationContext(), start.class));
                finish();*/
            }
        };
        delete.setOnClickListener(dl);




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_entry_list, menu);
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
