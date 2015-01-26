package com.example.micaelacavallo.swirlingcolors;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;


public class MainActivity extends ActionBarActivity {

    Button mCalculate;
    EditText mAmount;
    RadioButton m15Pct;
    RadioButton m20Pct;
    RadioButton mNoTip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prepareButtonCalculate();
        mAmount = (EditText)findViewById(R.id.edit_text_amount);
        m15Pct = (RadioButton)findViewById(R.id.radio_button_15_pct);
        m20Pct = (RadioButton)findViewById(R.id.radio_button_20_pct);
        mNoTip = (RadioButton)findViewById(R.id.radio_button_no_tip);
    }

    private void prepareButtonCalculate() {

        mCalculate = (Button)findViewById(R.id.button);
        mCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!mAmount.getText().toString().isEmpty())
                {
                    Intent intent = new Intent(MainActivity.this, ShowTipActivity.class);
                    double result = Double.parseDouble(mAmount.getText().toString());
                    if (m15Pct.isChecked())
                        result *= 0.15;
                    else if (m20Pct.isChecked()) {
                        result *= 0.20;
                    } else
                        result = 0;

                    intent.putExtra(Intent.EXTRA_TEXT, result);
                    startActivity(intent);
                }

            }
        });
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
}
