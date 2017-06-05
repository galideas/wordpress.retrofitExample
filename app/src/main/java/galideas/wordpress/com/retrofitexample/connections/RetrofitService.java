package galideas.wordpress.com.retrofitexample.connections;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Galideas on 05/06/2017.
 */

public interface RetrofitService {

    @GET("api/json/west/now")
    Call<TimeFromWeb> loadTime();

}
