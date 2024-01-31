package ma.ofppt.devoamm204

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ma.ofppt.devoamm204.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var  f1 : F1Fragmenty
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        f1 = F1Fragmenty()
        val i= 0;
       var patient = Patient.getLstPatients().get(i);
        val b = Bundle()
        b.putString("cin",patient.cin)
        b.putString("nom",patient.nom)
        b.putInt("age",patient.age)
        f1.arguments =b
        supportFragmentManager.beginTransaction().replace(R.id.fragments,f1).commit()
    }
}