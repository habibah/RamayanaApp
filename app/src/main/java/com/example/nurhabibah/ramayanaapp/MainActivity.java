package com.example.nurhabibah.ramayanaapp;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    EditText editTextHarga, editTextDiskon;
    TextView textViewHasil;
    Button btnHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextHarga = (EditText) findViewById(R.id.hargaAsli);
        editTextDiskon = (EditText) findViewById(R.id.besarDiskon);

        textViewHasil = (TextView) findViewById(R.id.harga);
        btnHasil = (Button) findViewById(R.id.buttonHarga);
        btnHasil.setOnClickListener(this);

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

    @Override
    public void onClick(View v) {

            String inputHarga = editTextHarga.getText().toString();
            String inputDiskon = editTextDiskon.getText().toString();

            double hargaC = Double.parseDouble(inputHarga);
            double diskonPersen = Double.parseDouble(inputDiskon);
            double hargaBaru = 0;


        if (diskonPersen >= 45 && diskonPersen <= 75)
            {
                diskonPersen = diskonPersen/100;
                hargaBaru = (hargaC - (hargaC * diskonPersen));
                textViewHasil.setText("Rp" + " " +  String.valueOf(hargaBaru));
            }
        else {
            textViewHasil.setText("diskon harus di antara  45% - 75%");
        }

    }
}
