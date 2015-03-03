package com.frederick.apireaderws;

import org.json.JSONObject;
import com.frederick.apireaderws.APIReaderWS;
import com.loopj.android.http.JsonHttpResponseHandler;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		obtenerData();
		
	}

	private void obtenerData() {
		APIReaderWS.get(ConfigWsData.ws_prefix, null, new JsonHttpResponseHandler("ISO-8859-1") {	
			@Override
			public void onFailure(int statusCode, Throwable e, JSONObject errorResponse) {
				super.onFailure(statusCode, e, errorResponse);
				/*
				 *  CASO FALIDO
				 */
				Log.i("CONECTION ERROR", "ERROR");
			}

			@Override
            public void onSuccess(JSONObject object) {
            	try {
            		
            		Log.i("DATA", object.toString());
				
            	} catch (Exception e) {
					/*
					 *  DAMN EVERYTHING GO TO HELL !!! 
					 */
            		Log.i("EXCEPTION ERROR", "ERROR");
				}
            }
        });
	}
}
