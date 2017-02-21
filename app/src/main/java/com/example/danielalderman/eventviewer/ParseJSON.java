package com.example.danielalderman.eventviewer;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class ParseJSON {
    static String[] names;
    static String[] dates;

    private static final String JSON_ARRAY = "events";
    private static final String EVENT_NAME_ARRAY = "name";
    private static final String EVENT_DATE_ARRAY = "start";

    private String json;

    ParseJSON(String json){
        this.json = json;
    }

    void parse(){
        JSONObject response;
        try {
            response = new JSONObject(json);
            JSONArray events = response.getJSONArray(JSON_ARRAY);

            names = new String[events.length()];
            dates = new String[events.length()];

            for(int i = 0; i< events.length(); i++){
                JSONObject eventData = events.getJSONObject(i);

                // Event Name
                JSONObject eventNameArray = eventData.getJSONObject(EVENT_NAME_ARRAY);
                names[i] = eventNameArray.getString("text");

                // Start Date
                JSONObject eventStartDateArray = eventData.getJSONObject(EVENT_DATE_ARRAY);
                String dateStr = eventStartDateArray.getString("local");
                // Slice dateStr to remove time
                String[] startDate = dateStr.split("T");
                dates[i] = startDate[0];
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}