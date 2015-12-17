package io.tajrish.http;

import com.squareup.okhttp.OkHttpClient;

import retrofit.RestAdapter;
import retrofit.client.OkClient;

/**
 * Created by root on 10/10/15.
 */
public class TajrishAPI {

    static TajrishAPIInterface instance = null;
    private static final String ENDPOINT_URL = "http://178.238.226.60/candidate";

    public static TajrishAPIInterface getInstance() {
        if (instance == null) {
            RestAdapter.Builder builder = new RestAdapter.Builder()
                    .setEndpoint(ENDPOINT_URL)
                    .setClient(new OkClient(new OkHttpClient()));
            RestAdapter adapter = builder.build();

            instance = adapter.create(TajrishAPIInterface.class);
        }

        return instance;
    }
}
