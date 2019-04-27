package ru.geekbrains.weatherapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class CityRequestActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private static final String TAG = "CityRequestActivity";

    private int startWeatherAppActivityKey = 1234;
    static final String keyForCityData = "keyForCityDada";

    private EditText mCityRequestView;
    private Button mSearchButton;

    private Switch mTemperatureParameterSwitch;
    private Switch mHumidityParameterSwitch;
    private Switch mPressureParameterSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate() CityRequestActivity called");
        setContentView(R.layout.activity_city_request);

        initViews();
        setOnClickCityRequestView();
        setOnClickSearchButton();

    }

    private void initViews() {
        mCityRequestView = findViewById(R.id.city_request);
        mSearchButton = findViewById(R.id.button_search);
        mTemperatureParameterSwitch = findViewById(R.id.switch_temperature);
        if (mTemperatureParameterSwitch != null) {
            mTemperatureParameterSwitch.setOnCheckedChangeListener(this);
        }
        mHumidityParameterSwitch = findViewById(R.id.switch_humidity);
        if ( mHumidityParameterSwitch != null) {
            mHumidityParameterSwitch.setOnCheckedChangeListener(this);
        }
        mPressureParameterSwitch = findViewById(R.id.switch_pressure);
        if (mPressureParameterSwitch != null) {
            mPressureParameterSwitch.setOnCheckedChangeListener(this);
        }
    }

    private void setOnClickCityRequestView() {
        mCityRequestView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCityRequestView.setText("");
            }
        });
    }

    public void setOnClickSearchButton() {
        mSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String CityName = mCityRequestView.getText().toString();
                Intent intent = new Intent(CityRequestActivity.this, WeatherAppActivity.class);
                intent.putExtra(keyForCityData, CityName);
                startActivityForResult(intent, startWeatherAppActivityKey);
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() CityRequestActivity called");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() CityRequestActivity called");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() CityRequestActivity called");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() CityRequestActivity called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart() CityRequestActivity called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() CityRequestActivity called");
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        Toast.makeText(this, "Отслеживание переключения: " + (isChecked ? "on" : "off"),
                Toast.LENGTH_SHORT).show();
    }
}
