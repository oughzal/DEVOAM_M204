package ma.ofppt.devoamm204;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;

import ma.ofppt.devoamm204.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnSrart.setOnClickListener(v ->{
            new MyAsyncTask().execute();
        });
    }

    private class MyAsyncTask extends AsyncTask<Void,Integer,String>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            binding.txtProgess.setText("Start Downloading");
        }

        @Override
        protected String doInBackground(Void... voids) {
            for(int i=0;i<=100;i++){
                publishProgress(i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            return "Télechagement Terminé";
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            binding.progess.setProgress(values[0]);
            binding.txtProgess.setText("Téléchargement : "+ values[0]+ "%");
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            binding.txtProgess.setText(s);
        }
    }
}