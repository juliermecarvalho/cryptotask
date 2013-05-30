package br.com.qualidata.servico;

import org.json.JSONObject;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

public class ReadWeatherJSONFeedTask extends AsyncTask
<String, Void, String> {
    protected String doInBackground(String... urls) {
    	WebService w = new WebService();
        return w.get(urls[0]);
    }

    public void onPostExecute(String result, Context context) {
        try {
            JSONObject jsonObject = new JSONObject(result);
            JSONObject weatherObservationItems = 
                new JSONObject(jsonObject.getString("weatherObservation"));

            Toast.makeText(context, 
                weatherObservationItems.getString("clouds") + 
             " - " + weatherObservationItems.getString("stationName"), 
             Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Log.d("ReadWeatherJSONFeedTask", e.getLocalizedMessage());
        }          
    }
}