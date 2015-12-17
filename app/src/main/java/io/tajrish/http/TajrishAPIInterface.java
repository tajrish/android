package io.tajrish.http;

import java.util.List;

import io.tajrish.models.HomeScreenModel;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

/**
 * Created by root on 10/10/15.
 */
public interface TajrishAPIInterface {

    /*
    @POST("/blog/users/{user_id}")
    void getBlog(@Path("user_id") String userId, Callback<List<BlogItem>> blogItemCallback);
    */

    @GET("/users/{user_id}/provinces")
    void getProvinces(@Path("user_id") String userId, Callback<HomeScreenModel> homeScreenModelCallback);

    /*@POST("/blog/users/{user_id}")
    void getBlog(@Path("user_id") String userId, Callback<List<BlogItem>> blogItemCallback);*/

    /*@FormUrlEncoded
    @POST("/users")
    void registerUser(@Field("phone_number") String phone, @Field("password") String password, Callback<Session> tokenCallback);

    @GET("/users/login_session")
    void loginUser(@Query("phone_number") String phone, @Query("password") String password, Callback<User> userCallback);

    @GET("/users/login_bank")
    void loginBank(@Query("session") String session, @Query("username") String username, @Query("password") String password, @Query("bank_id") int bank_id, Callback<User> userCallback);*/
}
