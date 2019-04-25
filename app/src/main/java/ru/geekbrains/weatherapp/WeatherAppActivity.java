package ru.geekbrains.weatherapp;

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
import java.util.Locale;

import static ru.geekbrains.weatherapp.R.id.parameter_temperature;

public class WeatherAppActivity extends AppCompatActivity {

    private static final String TAG = "WeatherAppActivity";



    Date currentDate = new Date();
    SimpleDateFormat formatForDateNow = new SimpleDateFormat("E dd.MM.yyyy 'время' hh:mm:ss", Locale.getDefault());
    private TextView dateView;
    private ImageView sunIcon;
    private Button mRefreshButton;

    private TextView temperatureParameter;
    private TextView humidityParameter;
    private TextView pressureParameter;

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

        Log.d(TAG, "onCreate(Bundle) called");
        setContentView(R.layout.activity_weatherapp);

        dateView = findViewById(R.id.dateView);
        dateView.setText(formatForDateNow.format(currentDate));
        dateView.setVisibility(View.INVISIBLE);

        sunIcon = findViewById(R.id.sunnyIcon);
        sunIcon.setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.sun));
        sunIcon.setVisibility(View.INVISIBLE);

        temperatureParameter = findViewById(parameter_temperature);
        temperatureParameter.setVisibility(View.INVISIBLE);
        humidityParameter = findViewById(R.id.parameter_humidity);
        humidityParameter.setVisibility(View.INVISIBLE);
        pressureParameter = findViewById(R.id.parameter_pressure);
        pressureParameter.setVisibility(View.INVISIBLE);

        location = findViewById(R.id.location);
        location.setVisibility(View.INVISIBLE);

        mRefreshButton = findViewById(R.id.button_refresh);
        mRefreshButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(WeatherAppActivity.this, R.string.toast_refresh,
                        Toast.LENGTH_SHORT).show();

                dateView.setVisibility(View.VISIBLE);
                sunIcon.setVisibility(View.VISIBLE);
                location.setVisibility(View.VISIBLE);

                temperatureParameter.setText("Температура 23 градуса" );
                temperatureParameter.setVisibility(View.VISIBLE);

                humidityParameter.setText("Влажность 67%");
                humidityParameter.setVisibility(View.VISIBLE);

                pressureParameter.setText("Давление 1002 мбар");
                pressureParameter.setVisibility(View.VISIBLE);

            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart() called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
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
