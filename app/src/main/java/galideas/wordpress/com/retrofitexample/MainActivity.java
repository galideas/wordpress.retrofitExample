package galideas.wordpress.com.retrofitexample;

import android.app.Activity;
import android.os.Bundle;

import galideas.wordpress.com.retrofitexample.connections.RetrofitAdapter;
import galideas.wordpress.com.retrofitexample.connections.RetrofitService;
import galideas.wordpress.com.retrofitexample.connections.TimeFromWeb;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends Activity {

    Call<TimeFromWeb> call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onResume() {
        super.onResume();

        Retrofit retrofit = new RetrofitAdapter().getAdapter();
        RetrofitService service = retrofit.create(RetrofitService.class);
        call = service.loadTime();
        call.enqueue(new Callback<TimeFromWeb>() {
            @Override
            public void onResponse(Call<TimeFromWeb> call, Response<TimeFromWeb> response) {
                System.out.println(response.body().getCurrentDateTime());
            }

            @Override
            public void onFailure(Call<TimeFromWeb> call, Throwable t) {
                System.out.println(t.getCause().toString());
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (!call.isCanceled())
            call.cancel();
    }
}
