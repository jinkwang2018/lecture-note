package com.example.part9_25;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class HttpRequester {
	
	HttpTask http;
	
	public void request(String url, HashMap<String, String> param, HttpCallback callback) {
		http = new HttpTask(url, param, callback);
		http.execute();
	}
	
	public void cancel() {
		if(http != null)
			http.cancel(true);
	}
	
	private class HttpTask extends AsyncTask<Void, Void, String> {
		String url;
		HashMap<String, String> param;
		HttpCallback callback;
		
		public HttpTask(String url, HashMap<String, String> param, HttpCallback callback) {
			this.url = url;
			this.param = param;
			this.callback = callback;
		}
		
		@Override
		protected String doInBackground(Void... nothing) {
			String response = "";
			String postData = "";
			PrintWriter pw = null;
			BufferedReader in = null;
			
			//add~~~~~~~~~~~~~~

			return response;
		}

		@Override
		protected void onPostExecute(String result) {
			//add~~~~~~~~~~~
			
		}
	}

}
