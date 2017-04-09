package ss.jind.com.jindutiao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import ss.jind.com.jindutiao.view.ProssgrassView;

public class MainActivity extends AppCompatActivity {

    private ProssgrassView progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progress = (ProssgrassView) findViewById(R.id.progress);

    }
    public  void but(View view){
      progress.start();
    }
}
