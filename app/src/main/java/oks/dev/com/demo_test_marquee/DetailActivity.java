package oks.dev.com.demo_test_marquee;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    public static final String KEY_DETAIL = "KEY_DETAIL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        if (getIntent().getExtras() != null && getIntent().getExtras().containsKey(KEY_DETAIL)) {
            String string = getIntent().getExtras().getString(KEY_DETAIL);
            ((TextView) findViewById(R.id.tvDetailActivity)).setText(string);
        }
    }
}
