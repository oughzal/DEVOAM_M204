package ma.ofppt.devoamm204;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        new Thread(new Runnable() {
            @Override
            public void run() {
               // TODO : BG Task
                //...
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                    }
                });
                //...
            }
        }).start();

      new MyThread().start();
    }
}