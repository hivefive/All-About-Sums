package com.ebookfrenzy.allaboutsums;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import java.util.Random;


public class GameActivity extends AppCompatActivity {

    public EditText firstNumberField;
    public EditText secondNumberField;
    public int firstNumber;
    public int secondNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);


        firstNumber = random();

        firstNumberField = (EditText) findViewById(R.id.numberOne);
        firstNumberField.setKeyListener(null);
        firstNumberField.setText("" + firstNumber);

        secondNumber = random();

        secondNumberField = (EditText) findViewById(R.id.numberTwo);
        secondNumberField.setKeyListener(null);
        secondNumberField.setText("" + secondNumber);
    }

    public static int random() {
        Random generator = new Random();

        int x = generator.nextInt(100);
        return x;
    }

    public static int calculateSum(Integer firstNumber, Integer secondNumber) {
        int sum = firstNumber * secondNumber;
        return sum;
    }

    public void matchSums() {
        EditText sumField = (EditText) findViewById(R.id.sumNumber);
        int submittedSum = Integer.parseInt(sumField.getText().toString());

        int correctSum = calculateSum(firstNumber, secondNumber);

        TextView resultField = (TextView) findViewById(R.id.gameResult);

        if(submittedSum == correctSum) {
            resultField.setText("BRAVO");
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game, menu);
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
