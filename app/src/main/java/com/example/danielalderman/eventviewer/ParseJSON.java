package com.example.danielalderman.eventviewer;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class ParseJSON {
    static String[] EVENT_NAME;

    private static final String JSON_ARRAY = "events";
    private static final String EVENT_NAME_ARRAY = "name";

    private String json;

    ParseJSON(String json){
        this.json = json;
    }

    void parse(){
        JSONObject response;
        try {
            response = new JSONObject(json);
            JSONArray events = response.getJSONArray(JSON_ARRAY);

            EVENT_NAME = new String[events.length()];

            for(int i = 0; i< events.length(); i++){
                JSONObject eventData = events.getJSONObject(i);

                // Event Name
                JSONObject eventNameArray = eventData.getJSONObject(EVENT_NAME_ARRAY);
                EVENT_NAME[i] = eventNameArray.getString("text");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}