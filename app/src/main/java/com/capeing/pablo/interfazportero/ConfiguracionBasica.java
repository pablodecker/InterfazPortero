package com.capeing.pablo.interfazportero;

import android.provider.Telephony;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class ConfiguracionBasica extends AppCompatActivity {
    EditText etTe1,etTe2,etTe3,etTe4,etTe5;
    Switch swHab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion_basica);


        //getActionBar().setDisplayHomeAsUpEnabled(true);

        etTe1 = (EditText) findViewById(R.id.etTelefono1);
        etTe2 = (EditText) findViewById(R.id.etTelefono2);
        etTe3 = (EditText) findViewById(R.id.etTelefono3);
        etTe4 = (EditText) findViewById(R.id.etTelefono4);
        etTe5 = (EditText) findViewById(R.id.etTelefono5);
        swHab = (Switch) findViewById(R.id.switchHabilitacion);
    }

    public void enviar_config(View v){
        String phoneNo = "3415555781";//textPhoneNo.getText().toString();
        String sms = "Config: Te1:" + etTe1.getText().toString() + etTe2.getText().toString();

        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNo, null, sms, null, null);
            Toast.makeText(getApplicationContext(), "SMS Sent!", Toast.LENGTH_LONG).show();
        }
        catch (Exception e) {
            Toast.makeText(getApplicationContext(),"SMS faild, please try again later!",Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: //hago un case por si en un futuro agrego mas opciones
                Log.i("ActionBar", "Atrás!");
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    */
}