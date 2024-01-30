package ma.ofppt.devoamm204

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ma.ofppt.devoamm204.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
    private class MyAsncTask : AsyncTask<Unit, Int, String>() {
        override fun doInBackground(vararg params: Unit?): String {
            for(i in 0 until 100){
               publishProgress(i)
                Thread.sleep(100)
            }
            return "Téléchargement Terminé"
        }

        override fun onProgressUpdate(vararg values: Int?) {
            super.onProgressUpdate(*values)

        }
    }
}