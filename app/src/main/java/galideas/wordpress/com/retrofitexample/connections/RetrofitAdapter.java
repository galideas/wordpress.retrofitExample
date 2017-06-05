package galideas.wordpress.com.retrofitexample.connections;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Galideas on 05/06/2017.
 */

public class RetrofitAdapter {

    Retrofit retrofit;

    public RetrofitAdapter(){
    }

    public Retrofit getAdapter(){
        retrofit = new Retrofit.Builder()
                .baseUrl("http://worldclockapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
