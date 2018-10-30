package com.brahamaputra.mahindra.brahamaputra.Utils;

import android.content.Context;
import android.net.Uri;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class TokBoxWebServiceCoordinator {

    private static final String LOG_TAG = "TokBox";//WebServiceCoordinator.class.getSimpleName();

    private static RequestQueue reqQueue;

    private final Context context;
    public static Listener delegate;

    public TokBoxWebServiceCoordinator(Context context, Listener delegate) {
        this.context = context;
        this.delegate = delegate;
        this.reqQueue = Volley.newRequestQueue(context);
    }

    public void fetchSessionConnectionData(String sessionInfoUrlEndpoint)
    {
        String apiKey = Constants.TolkBox_APIKey;//response.getString("apiKey");
        String sessionId = Constants.TolkBox_SessionId;// response.getString("sessionId");
        String token = Constants.TolkBox_Token;//response.getString("token");
        Log.i(LOG_TAG, "WebServiceCoordinator returned session information\nApi : "+apiKey+"\nSession : "+sessionId+"\n Token :"+token);

        delegate.onSessionConnectionDataReady(apiKey, sessionId, token);

       /* RequestQueue reqQueue = Volley.newRequestQueue(context);
        reqQueue.add(
                new JsonObjectRequest(
                        Request.Method.GET,
                        sessionInfoUrlEndpoint,
                        null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    String apiKey = Constants.TolkBox_APIKey;//response.getString("apiKey");
                                    // 45964002
                                    String sessionId =Constants.TolkBox_SessionId;// response.getString("sessionId");
                                    // 2_MX40NTk2NDAwMn5-MTUxMjY0OTM2MjMyNX5sNTJlWm9EODQ3N2U0UXZJMzNFcmhKdlp-fg
                                    String token = Constants.TolkBox_Token;//response.getString("token");
                                    // cGFydG5lcl9pZD00NTk2NDAwMiZzZGtfdmVyc2lvbj1kZWJ1Z2dlciZzaWc9YTk1YjBiMjk5MGM1NGQwZTRkY2UzOGQ1ZWRlNzAwNzY0MmNkZDMzYzpzZXNzaW9uX2lkPTJfTVg0ME5UazJOREF3TW41LU1UVXhNalkwT1RNMk1qTXlOWDVzTlRKbFdtOUVPRFEzTjJVMFVYWkpNek5GY21oS2RscC1mZyZjcmVhdGVfdGltZT0xNTEyNjQ5MzYyJnJvbGU9bW9kZXJhdG9yJm5vbmNlPTE1MTI2NDkzNjIuMzM4NTE0MDY1MDA2MDUmZXhwaXJlX3RpbWU9MTUxNTI0MTM2Mg

                                    Log.i(LOG_TAG, "WebServiceCoordinator returned session information");

                                    delegate.onSessionConnectionDataReady(apiKey, sessionId, token);
                                } catch (Exception e) {
                                    delegate.onWebServiceCoordinatorError(e);
                                }
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                delegate.onWebServiceCoordinatorError(error);
                            }
                        }
                )
        );*/
    }

    public static interface Listener {
        void onSessionConnectionDataReady(String apiKey, String sessionId, String token);
        void onWebServiceCoordinatorError(Exception error);
    }

    public void startArchive(String sessionId) {
        JSONObject postBody = null;
        try {
            postBody = new JSONObject("{\"sessionId\": \"" + sessionId + "\"}");
        } catch (JSONException e){
            Log.e(LOG_TAG, "Parsing json body failed");
            e.getStackTrace();
        }

        this.reqQueue.add(new JsonObjectRequest(Request.Method.POST, "/archive/start",
                postBody,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.i(LOG_TAG, "archive started");
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                delegate.onWebServiceCoordinatorError(error);
            }
        }));
    }

    public void stopArchive(String archiveId) {
        String requestUrl = "/archive/:archiveId/stop".replace(":archiveId", archiveId);
        this.reqQueue.add(new JsonObjectRequest(Request.Method.POST, requestUrl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.i(LOG_TAG, "archive stopped");
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                delegate.onWebServiceCoordinatorError(error);
            }
        }));
    }

    public Uri archivePlaybackUri(String archiveId) {
        return Uri.parse("/archive/:archiveId/view".replace(":archiveId", archiveId));
    }
}

