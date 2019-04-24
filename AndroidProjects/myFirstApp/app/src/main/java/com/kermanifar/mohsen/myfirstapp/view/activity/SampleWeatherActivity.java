package com.kermanifar.mohsen.myfirstapp.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.kermanifar.mohsen.myfirstapp.network.ApiServices;
import com.kermanifar.mohsen.myfirstapp.R;
import com.kermanifar.mohsen.myfirstapp.datamodel.WeatherInfo;

public class SampleWeatherActivity extends AppCompatActivity implements ApiServices.onWeatherInfoReceived {

     Button btnGetCurrentWeather;
     ApiServices  apiServices;
     private TextView weatherName;
     private TextView weatherDesp;
     private TextView weatherTemp;
     private TextView weatherHumidity;
     private TextView weatherPressure;
     private TextView weatherTempMin;
     private TextView weatherTempMax;
     private TextView weatherSpeed;
     private TextView weatherDeg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_weather);

        initViews();

        apiServices = new ApiServices(SampleWeatherActivity.this);
        btnGetCurrentWeather = findViewById(R.id.btn_get_api);

        btnGetCurrentWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               apiServices.getCurrentWeather(SampleWeatherActivity.this, "Tehran");

            }
        });


    }


    private void initViews() {
        weatherName = findViewById(R.id.txt_weather_name);
        weatherDesp = findViewById(R.id.txt_weather_description);
        weatherTemp = findViewById(R.id.txt_weather_temp);
        weatherHumidity = findViewById(R.id.txt_weather_humidity);
        weatherPressure = findViewById(R.id.txt_weather_pressure);
        weatherTempMin = findViewById(R.id.txt_weather_temp_min);
        weatherTempMax = findViewById(R.id.txt_weather_temp_max);
        weatherSpeed = findViewById(R.id.txt_weather_speed);
        weatherDeg = findViewById(R.id.txt_weather_temp_deg);
    }


    @Override
    public void onReceive(WeatherInfo weatherInfo) {

            weatherName.setText("نوع آب و هوا :  " +weatherInfo.getWeatherName());
            weatherDesp.setText("توضیح :  " +weatherInfo.getWeatherDescription());
            weatherTemp.setText("دما :  "+String.valueOf(weatherInfo.getWeatherTemp()));
            weatherHumidity.setText("رطوبت :  "+String.valueOf(weatherInfo.getHumidity()));
            weatherPressure.setText("فشار :  " +String.valueOf(weatherInfo.getPressure()));
            weatherTempMin.setText("مینیمم دما : "+String.valueOf(weatherInfo.getMinTemp()));
            weatherTempMax.setText("ماکسیمم هئا "+String.valueOf(weatherInfo.getMaxTemp()));
            weatherSpeed.setText("سرعت :  "+String.valueOf(weatherInfo.getWindSpeed()));
            weatherDeg.setText(String.format("%s + %f", "درجه هوا", weatherInfo.getWindDegree()));

        }




}
