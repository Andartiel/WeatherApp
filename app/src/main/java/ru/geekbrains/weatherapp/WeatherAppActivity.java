package ru.geekbrains.weatherapp;

import android.content.Intent;
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

import static ru.geekbrains.weatherapp.R.id.city_request;
import static ru.geekbrains.weatherapp.R.id.parameter_temperature;

public class WeatherAppActivity extends AppCompatActivity {

    private static final String TAG = "WeatherAppActivity";

    private int startCityRequestActivityKey = 4321;


    Date currentDate = new Date();
    SimpleDateFormat formatForDateNow = new SimpleDateFormat("E dd.MM.yyyy 'время' hh:mm:ss", Locale.getDefault());
    private TextView mDateView;

    private ImageView mSunIcon;
    private Button mRefreshButton;
    private Button mBackButton;

    private TextView mTemperatureParameter;
    private TextView mHumidityParameter;
    private TextView mPressureParameter;

    private TextView mLocation;

    static final String keyForCityData = "keyForCityDataForWeatherAppActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "onCreate(Bundle) WeatherAppActivity called");
        setContentView(R.layout.activity_weatherapp);

       initViews();
       setOnClickRefreshButton();
       setOnClickBackButton();

    }

    private void initViews(){
        mDateView = findViewById(R.id.dateView);
        mDateView.setText(formatForDateNow.format(currentDate));


        mSunIcon = findViewById(R.id.sunnyIcon);
        mSunIcon.setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.sun));

        mTemperatureParameter = findViewById(parameter_temperature);
        mHumidityParameter = findViewById(R.id.parameter_humidity);
        mPressureParameter = findViewById(R.id.parameter_pressure);


        mLocation = findViewById(R.id.location);
        String GetLocation = getIntent().getStringExtra(CityRequestActivity.keyForCityData);
        mLocation.setText(GetLocation);

        mRefreshButton = findViewById(R.id.button_refresh);
        mBackButton = findViewById(R.id.button_back);

    }

    private void setOnClickRefreshButton(){

        mRefreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(WeatherAppActivity.this, R.string.toast_refresh,
                        Toast.LENGTH_SHORT).show();
                mTemperatureParameter.setText(R.string.parameter_temperature_result);
                mHumidityParameter.setText(R.string.parameter_humidity_result);
                mPressureParameter.setText(R.string.parameter_pressure_result);
            }
        });
    }

    private void setOnClickBackButton(){

        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WeatherAppActivity.this, CityRequestActivity.class);
                startActivityForResult(intent, startCityRequestActivityKey);
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() WeatherAppActivity called");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() WeatherAppActivity called");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() WeatherAppActivity called");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() WeatherAppActivity called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart() WeatherAppActivity called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() WeatherAppActivity called");
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
