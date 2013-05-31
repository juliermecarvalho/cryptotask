package br.com.qualidata.servico;


import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

public class ReadWeatherJSONFeedTask extends AsyncTask
<String, Void, String> {
	private Context context;
	public ReadWeatherJSONFeedTask(Context context){
		 this.context = context;
	}
	
    protected String doInBackground(String... urls) {
    	WebService w = new WebService();
        return w.post(urls[0]);
    }
   
    public void onPostExecute(String result) {
        try {


            //Toast.makeText(this.context, "jsonObject.toString()",   Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Log.d("ReadWeatherJSONFeedTask", e.getLocalizedMessage());
        }          
    }
}