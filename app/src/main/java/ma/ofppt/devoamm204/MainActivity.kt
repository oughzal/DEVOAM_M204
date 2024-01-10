package ma.ofppt.devoamm204

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ma.ofppt.devoamm204.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}