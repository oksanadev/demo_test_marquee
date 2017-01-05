package oks.dev.com.demo_test_marquee;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    List<ScrollTextView> tvLongTexts = new ArrayList<>();
    LinearLayout activityContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activityContainer = (LinearLayout) findViewById(R.id.activity_main);
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            ScrollTextView scrollTextView = new ScrollTextView(this);
            scrollTextView.setId(i);

            scrollTextView.setBackgroundColor(Color.argb(255, random.nextInt(50) + 150, random.nextInt(50) + 150, random.nextInt(50) + 150));
            scrollTextView.setText(getResources().getTextArray(R.array.strings_array)[i]);
            scrollTextView.setTextSize(getResources().getDimension(R.dimen.text_size));
            scrollTextView.setPadding(0, 10, 0, 10);

            scrollTextView.setOnClickListener(textView);
            tvLongTexts.add(scrollTextView);

            activityContainer.addView(scrollTextView, new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        }
        activityContainer.post(new Runnable() {
            @Override
            public void run() {
                for (ScrollTextView longText : tvLongTexts) {
                    longText.startScroll();
                }
            }
        });

    }

    View.OnClickListener textView = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startDetailActivity((((ScrollTextView) view).getText().toString()));

        }
    };

    public void startDetailActivity(String text) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(DetailActivity.KEY_DETAIL, text);
        startActivity(intent);
    }


}
