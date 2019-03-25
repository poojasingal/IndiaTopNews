package com.pooja.indiatopnews.VollyApi;

import android.app.ProgressDialog;
import android.content.Context;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class GetApiCall {

    ProgressDialog progressDialog;
    Context context;

    String empCode,yearMonth,dateTime,toDate,param1,param2;
    public void getProduct(ProgressDialog progressDialog, final Context context, String url, final String empCode, final String yearMonth, final String dateTime, final String toDate, final String param1, final String param2) {
        try {

            this.progressDialog = progressDialog;
            this.context = context;
            this.empCode = empCode;
            this.yearMonth = yearMonth;
            this.dateTime = dateTime;
            this.toDate = toDate;
            this.param1 = param1;
            this.param2 = param2;
          /*  GetCredentials getCredentials = new GetCredentials(context);
            userCredentials = getCredentials.Credentials();*/
            RequestQueue queue = Volley.newRequestQueue(context);
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, null, createMyReqSuccessListener(), createMyReqErrorListener()) {
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String, String> headers = new HashMap<>();
                    headers.put("companycode", "0001");
                    headers.put("employeecode", empCode);

                    headers.put("yearmonth", yearMonth);
                    headers.put("datetime", dateTime);
                    headers.put("assmyr", yearMonth);
                    headers.put("deptcode", yearMonth);
                    //call student detail here
                    headers.put("class", param1);
                    headers.put("section", yearMonth);
                    headers.put("busroute", dateTime);


                    return headers;
                }
            };
            int socketTimeout = 16000;//16 seconds - change to what you want
            RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
            jsonObjectRequest.setRetryPolicy(policy);
            // Add the request to the RequestQueue.
            queue.add(jsonObjectRequest);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public Response.Listener<JSONObject> createMyReqSuccessListener() {
        return new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    progressDialog.dismiss();
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        };
    }

    private Response.ErrorListener createMyReqErrorListener() {
        return new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                try {
                    if (progressDialog==null){
                    }else {
                        progressDialog.dismiss();
                    }
                    String body;
                    Gson gson = new Gson();
                    if (error.networkResponse!=null) {
                       /* body = new String(error.networkResponse.data, "UTF-8");
                        ExMessage exMessage = null;
                        try {
                            exMessage = gson.fromJson(body.toString(), ExMessage.class);
                            Toast.makeText(context, exMessage.getMessage(), Toast.LENGTH_LONG).show();
                        }catch (Exception ex){
                            Crashlytics.logException(ex);
                            Toast.makeText(context, "Server Under Maintenance", Toast.LENGTH_LONG).show();
                        }*/
                        Toast.makeText(context, "Server Under Maintenance", Toast.LENGTH_LONG).show();

                    }else {
                        Toast.makeText(context, "No network available. Please check the network setting and try again.", Toast.LENGTH_LONG).show();
                    }
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        };
    }
}