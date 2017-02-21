package com.example.danielalderman.eventviewer;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class ParseJSON {
    static String[] content;

    private static final String JSON_ARRAY = "events";
    private static final String EVENT_NAME = "name";

    private String json;

    ParseJSON(String json){
        this.json = json;
    }

    void parse(){
        JSONObject response;
        try {
            response = new JSONObject(json);
            JSONArray events = response.getJSONArray(JSON_ARRAY);

            content = new String[events.length()];

            for(int i = 0; i< events.length(); i++){
                JSONObject eventNameArray = events.getJSONObject(i);
                content[i] = eventNameArray.getString(EVENT_NAME);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}