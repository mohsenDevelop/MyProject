package com.kermanifar.mohsen.myfirstapp.network;

import android.content.Context;
import android.util.Log;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.kermanifar.mohsen.myfirstapp.datamodel.Post;
import com.kermanifar.mohsen.myfirstapp.datamodel.WeatherInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ApiServices {

    private Context context;

    public ApiServices(Context context) {

        this.context = context;
    }

    private static final String TAG = "ApiServices";

    public void getCurrentWeather(final onWeatherInfoReceived onWeatherInfoReceived, String city) {

        final JsonObjectRequest request = new JsonObjectRequest(JsonObjectRequest.Method.GET,
                "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&apikey=3df6e0ab6af018692eb7280f6ee4e0d8",
                null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.i(TAG, "onResponse: " + response.toString());

                   onWeatherInfoReceived.onReceive(parseResponseToWeatherInfo(response));

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "onErrorResponse: " + error.toString() );
                onWeatherInfoReceived.onReceive(null);

            }
        });

        request.setRetryPolicy(new DefaultRetryPolicy(8000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(request);
    }

    public void getPosts(final onPostsReceived onPostsReceived) {
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, "http://192.168.1.3:8080/7learnApi/showjsons.php", null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                List<Post> posts = new ArrayList<>();

                for (int i = 0; i < response.length() ; i++) {
                    Post post = new Post();

                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        post.setPostId(jsonObject.getInt("post_id"));
                        post.setPostTitle(jsonObject.getString("post_title"));
                        post.setPostContent(jsonObject.getString("post_content"));
                        post.setPostImageUrl(jsonObject.getString("post_imagurl"));
                        post.setPostDate(jsonObject.getString("post_date"));

                        posts.add(post);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                onPostsReceived.onReceived(posts);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "onErrorResponse: "+ error);
                onPostsReceived.onReceived(null);

            }
        });

        request.setRetryPolicy(new DefaultRetryPolicy(18000, 4, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        Volley.newRequestQueue(context).add(request);
        

    }

    private WeatherInfo parseResponseToWeatherInfo(JSONObject response) {

        WeatherInfo weatherInfo = new WeatherInfo();

        try {
            JSONArray weatherJsonArray = response.getJSONArray("weather");
            JSONObject weatherJsonObject = weatherJsonArray.getJSONObject(0);

            weatherInfo.setWeatherName(weatherJsonObject.getString("main"));
            weatherInfo.setWeatherDescription(weatherJsonObject.getString("description"));

            JSONObject mainJsonObject = response.getJSONObject("main");
            weatherInfo.setWeatherTemp(mainJsonObject.getDouble("temp"));
            weatherInfo.setHumidity(mainJsonObject.getInt("humidity"));
            weatherInfo.setPressure(mainJsonObject.getInt("pressure"));
            weatherInfo.setMaxTemp(mainJsonObject.getDouble("temp_max"));
            weatherInfo.setMinTemp(mainJsonObject.getDouble("temp_min"));

            JSONObject windJsonObject = response.getJSONObject("wind");
            weatherInfo.setWindSpeed(windJsonObject.getDouble("speed"));
            weatherInfo.setWindDegree(windJsonObject.getDouble("deg"));

            return weatherInfo;

        } catch (JSONException e) {
            e.printStackTrace();

            return null;

        }

    }



    public interface onPostsReceived {
        void onReceived(List<Post> posts);
    }

    public interface onWeatherInfoReceived {
        void onReceive(WeatherInfo weatherInfo);
    }
}
