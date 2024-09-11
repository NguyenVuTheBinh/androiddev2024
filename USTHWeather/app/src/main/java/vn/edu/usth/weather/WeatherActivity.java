package vn.edu.usth.weather;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class WeatherActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // creating and initializing variable for fragment transaction.
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        Fragment fragment1 = new WeatherFragment();
        ft.add(R.id.upperContainer, fragment1, "fragment1");

        Fragment fragment2 = new aForecastFragment();
        ft.add(R.id.lowerContainer, fragment2, "fragment2");

        // committing the transaction.
        ft.commit();
//        aForecastFragment firstFragment = new aForecastFragment();
//        getSupportFragmentManager().beginTransaction().add(R.id.forecast_frag, firstFragment).commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Start", "Start");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.i("Resume","Resume");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.i("Pause","Pause");
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.i("Stop","Stop");
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i("Destroy","Destroy");
    }
}