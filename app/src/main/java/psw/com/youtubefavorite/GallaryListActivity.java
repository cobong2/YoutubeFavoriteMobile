package psw.com.youtubefavorite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class GallaryListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallary_list);
        setTitle(R.string.gallary_list);
    }
}
