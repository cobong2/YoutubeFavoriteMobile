package psw.com.youtubefavorite;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import psw.com.youtubefavorite.models.YoutubeVO;
import psw.com.youtubefavorite.retrofit2.RetroAPI;
import psw.com.youtubefavorite.retrofit2.RetroService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class YoutubeListActivity extends AppCompatActivity {
    private RetroService api = null;
    private List<YoutubeVO> list = new ArrayList<YoutubeVO>();
    private YoutubeAdapter adapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube_list);
        setTitle(R.string.youtube_list);

        _init();
    }

    private void _init() {
        listView = findViewById(R.id.listView);
        adapter = new YoutubeAdapter(this, list);
        listView.setAdapter(adapter);

        RetroService service = RetroAPI.getRetro().create(RetroService.class);
        Call<List<YoutubeVO>> call = service.getYoutubeList();
        call.enqueue(new Callback<List<YoutubeVO>>() {
            // 통신 잘 되면
            @Override
            public void onResponse(Call<List<YoutubeVO>> call, Response<List<YoutubeVO>> response) {
                if (response.body() != null) {
                    List<YoutubeVO> array = response.body();
                    for (YoutubeVO vo : array) {
                        list.add(vo);
                    }
                    adapter.notifyDataSetChanged();
                }
            }

            // 통신 잘 안 되면
            @Override
            public void onFailure(Call<List<YoutubeVO>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}

class YoutubeAdapter extends ArrayAdapter<YoutubeVO> {
    private List<YoutubeVO> list = null;
    YoutubeAdapter(Context ctx, List<YoutubeVO> list){
        super(ctx,0,list);
        this.list = list;
    }

    @Override
    public int getCount(){
        return list.size();
    }

    class ViewHolder {
        TextView tv_url;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder vh = null;
        if(view == null) {
            LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_youtube, parent, false);

            vh = new ViewHolder();
            vh.tv_url = view.findViewById(R.id.tv_url);

            view.setTag(vh);

        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        YoutubeVO vo = list.get(position);
        vh.tv_url.setText(vo.getY_url());

        return view;
    }
}