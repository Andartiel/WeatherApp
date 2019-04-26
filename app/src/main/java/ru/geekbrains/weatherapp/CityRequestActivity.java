package ru.geekbrains.weatherapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CityRequestActivity extends AppCompatActivity {

    private static final String TAG = "CityRequestActivity";

    private int startWeatherAppActivityKey = 1234;
    static final String keyForCityData = "keyForCityDada";

    private EditText mCityRequestView;
    private Button mSearchButton;

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
}
