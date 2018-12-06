package psw.com.youtubefavorite.retrofit2;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroAPI {

    private RetroAPI() {
    }

    private static Retrofit retro = null;

    public static Retrofit getRetro() {
        if (retro == null) {
            retro = new Retrofit.Builder()
                    .baseUrl("http://192.168.0.140:8090/myapp/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retro;
    }
}
