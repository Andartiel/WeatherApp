package ru.geekbrains.weatherapp;

import android.annotation.SuppressLint;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

import static ru.geekbrains.weatherapp.R.id.parameter_temperature;

public class WeatherAppActivity extends AppCompatActivity {

    private static final String TAG = "WeatherAppActivity";
    private static final int TEMPERATURE = 23;


    Date currentDate = new Date();
    SimpleDateFormat formatForDateNow = new SimpleDateFormat("E dd.MM.yyyy 'время' hh:mm:ss");
    private TextView dateView;
    private ImageView sunIcon;
    private Button mRefreshButton;

    private TextView temperatureParameter;
    private TextView humidityParameter;
    private TextView preassureParameter;

    private TextView location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String instanceState;
        if (savedInstanceState == null) {
            instanceState = "Приветствую!";
        } else {
            instanceState = "Повторный запуск!";
        }
        Toast.makeText(getApplicationContext(), instanceState + " - onCreate()", Toast.LENGTH_SHORT).show();

        Log.d(TAG, "onCreate(Bundle) called");
        setContentView(R.layout.activity_weatherapp);

        dateView = (TextView) findViewById(R.id.dateView);
        dateView.setText(formatForDateNow.format(currentDate));
        dateView.setVisibility(View.INVISIBLE);

        sunIcon = (ImageView) findViewById(R.id.sunnyIcon);
        sunIcon.setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.sun));
        sunIcon.setVisibility(View.INVISIBLE);

        temperatureParameter = (TextView) findViewById(parameter_temperature);
        temperatureParameter.setVisibility(View.INVISIBLE);
        humidityParameter = (TextView) findViewById(R.id.parameter_humidity);
        humidityParameter.setVisibility(View.INVISIBLE);
        preassureParameter = (TextView) findViewById(R.id.parameter_preassure);
        preassureParameter.setVisibility(View.INVISIBLE);

        location = (TextView) findViewById(R.id.location);
        location.setVisibility(View.INVISIBLE);

        mRefreshButton = (Button) findViewById(R.id.button_refresh);
        mRefreshButton.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View v) {
                Toast.makeText(WeatherAppActivity.this, R.string.toast_refresh,
                        Toast.LENGTH_SHORT).show();

                dateView.setVisibility(View.VISIBLE);
                sunIcon.setVisibility(View.VISIBLE);
                location.setVisibility(View.VISIBLE);

                temperatureParameter.setText("Температура 23 градуса" );

//                решил оставить на всякий, больше похоже на костыль, но работает(эквивалент строчки 83)
//                temperatureParameter.setText(getString(R.string.parameter_temperature) + " " + TEMPERATURE +
//                        " " + getString(R.string.measure_temperature));

                temperatureParameter.setVisibility(View.VISIBLE);

                humidityParameter.setText("Влажность 67%");
                humidityParameter.setVisibility(View.VISIBLE);

                preassureParameter.setText("Давление 1002 мбар");
                preassureParameter.setVisibility(View.VISIBLE);


            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called");
        Toast.makeText(getApplicationContext(), "onStart()", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called");
        Toast.makeText(getApplicationContext(), "onResume()", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called");
        Toast.makeText(getApplicationContext(), "onPause()", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called");
        Toast.makeText(getApplicationContext(), "onStop()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart() called");
        Toast.makeText(getApplicationContext(), "onRestart()", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
        Toast.makeText(getApplicationContext(), "onDestroy()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestoreInstanceState(Bundle saveInstanceState) {
        super.onRestoreInstanceState(saveInstanceState);
        Toast.makeText(getApplicationContext(), "Поворот экрана!! - onRestoreInstanceState()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onSaveInstanceState(Bundle saveInstanceState) {
        super.onSaveInstanceState(saveInstanceState);
        Log.d(TAG, "onSaveInstanceState() called");
        Toast.makeText(getApplicationContext(), "onSaveInstanceState()", Toast.LENGTH_SHORT).show();
    }


}
