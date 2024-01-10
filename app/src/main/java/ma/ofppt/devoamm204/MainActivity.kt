package ma.ofppt.devoamm204

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import ma.ofppt.devoamm204.databinding.ActivityMainBinding
import ma.ofppt.devoamm204.model.MVP
import ma.ofppt.devoamm204.model.Presenter
import ma.ofppt.devoamm204.model.User

class MainActivity : AppCompatActivity(),MVP.View {
    lateinit var binding: ActivityMainBinding
    var presenter : Presenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnNext.setOnClickListener {
            presenter?.onGetNext()
        }
    }

    override fun setUser(user: User) {
       binding.txtName.text = user.firstName + " " + user.lastName
    }
}