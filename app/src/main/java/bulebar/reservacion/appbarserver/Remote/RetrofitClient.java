package bulebar.reservacion.appbarserver.Remote;

import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by MDJ16 on 16/02/2018.
 */

public class RetrofitClient {

    private static Retrofit retrofit = null;

    public static Retrofit getClient(String baseUrl){
        if(retrofit==null){
            retrofit = new Retrofit.Builder()
                                    .baseUrl(baseUrl)
                                    .addConverterFactory(ScalarsConverterFactory.create())
                                    .build();

        }

        return retrofit;
    }
}
