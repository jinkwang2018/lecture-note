package com.example.part9_25;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class HttpImageRequester {
	
	HttpImageTask http;
	
	public void request(String url, HashMap<String, String> param, HttpImageCallback callback) {
		http = new HttpImageTask(url, param, callback);
		http.execute();
	}
	
	public void cancel() {
		if(http != null)
			http.cancel(true);
	}

	private class HttpImageTask extends AsyncTask<Void, Void, Bitmap> {
		String url;
		HashMap<String, String> param;
		HttpImageCallback callback;
		
		public HttpImageTask(String url, HashMap<String, String> param, HttpImageCallback callback) {
			this.url = url;
			this.param = param;
			this.callback = callback;
		}
		
		@Override
		protected Bitmap doInBackground(Void... nothing) {
			Bitmap response = null;
			String postData = "";
			PrintWriter pw = null;
			
			//add~~~~~~~~~~~~~~
			
			return response;
		}

		@Override
		protected void onPostExecute(Bitmap result) {
			//add~~~~~~~~~~~~
			
		}
	}
}
