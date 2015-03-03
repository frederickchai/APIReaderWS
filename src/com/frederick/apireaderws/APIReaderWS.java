package com.frederick.apireaderws;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

public class APIReaderWS {
	private static AsyncHttpClient client = new AsyncHttpClient();
	
	public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler){
		  client.setTimeout(700000);
		  get(url, params, true, responseHandler);
	  }
	
	  /*
	   *	GET 
	   */
	
	  public static void get(String url, RequestParams params, boolean useAbsoluteURL, AsyncHttpResponseHandler responseHandler) {
		  if(useAbsoluteURL)
			  client.get(getAbsoluteUrl(url), params, responseHandler);
		  else{
			  client.get(url, params, responseHandler);
		  }
	  }
	  
	  private static String getAbsoluteUrl(String relativeUrl) {
	      return ConfigWsData.BASE_URL + relativeUrl;
	  }
	  
	  
	  /*
	   *	POST 
	   */
	  public static void post(String url, RequestParams params, boolean useAbsoluteURL, AsyncHttpResponseHandler responseHandler) {
			if(useAbsoluteURL){
				client.post(getAbsoluteUrl(url), params, responseHandler);
			}
			else{
				client.get(url, params, responseHandler);
			}
		  }
		  
		  public static void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
		      post(url,params,true,responseHandler);
		  }
	  
}
