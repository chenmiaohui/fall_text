package fall.huihui.com;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private fallView fall;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fall = (fallView) findViewById(R.id.fall);
        fall.setPollutant("安卓巴士");
    }
}
