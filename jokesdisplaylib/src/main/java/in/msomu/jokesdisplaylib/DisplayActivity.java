package in.msomu.jokesdisplaylib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.udacity.joke.Jokes;

public class DisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        String joke = getIntent().getStringExtra(Jokes.TAG);
        TextView textJoke = (TextView) findViewById(R.id.text_joke);
        textJoke.setText(joke);
    }
}
