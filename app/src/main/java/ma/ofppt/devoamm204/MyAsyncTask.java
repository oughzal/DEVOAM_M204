package ma.ofppt.devoamm204;

import android.os.AsyncTask;

public class MyAsyncTask extends AsyncTask<String,Integer,String> {
    // Avant de passer en backhround ( UI Thread)
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    // background ( Thread séparé)
    @Override
    protected String doInBackground(String... strings) {
        return null;
    }
    // UI Thread
    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }
    // UI Thread
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }
}
