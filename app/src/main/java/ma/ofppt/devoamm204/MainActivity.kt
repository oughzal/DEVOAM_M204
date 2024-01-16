package ma.ofppt.devoamm204

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import ma.ofppt.devoamm204.databinding.ActivityMainBinding
import ma.ofppt.devoamm204.fragments.FragmentA

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var fragmentA: FragmentA
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val x =savedInstanceState?.getFloat("x")
        fragmentA = FragmentA()
        binding.btnFragmentA.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer,fragmentA)
                .commit()
        }
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putFloat("x",3f)
    }

    override fun onRestoreInstanceState(
        savedInstanceState: Bundle?,
        persistentState: PersistableBundle?
    ) {
        super.onRestoreInstanceState(savedInstanceState, persistentState)
        val x = savedInstanceState?.getFloat("x")
    }
}