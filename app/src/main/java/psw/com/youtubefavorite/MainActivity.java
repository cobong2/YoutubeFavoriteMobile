package psw.com.youtubefavorite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clkBtn(View v) {
        Intent intent = null;
        if (v.getId() == R.id.btn_youtube) {
            intent = new Intent(MainActivity.this, YoutubeListActivity.class);
        } else if (v.getId() == R.id.btn_gallary) {
            intent = new Intent(MainActivity.this, GallaryListActivity.class);
        }

        if (intent != null) {
            startActivity(intent);
        }
    }
}
