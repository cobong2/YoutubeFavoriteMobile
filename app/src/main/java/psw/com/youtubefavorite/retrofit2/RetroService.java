package psw.com.youtubefavorite.retrofit2;

import java.util.List;

import psw.com.youtubefavorite.models.YoutubeVO;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RetroService {
    @GET("client/jsonYoutubeList")
    public Call<List<YoutubeVO>> getYoutubeList();
}
