package ma.ofppt.devoamm204

import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import ma.ofppt.devoamm204.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var jobScheduler: JobScheduler
    val JOB_ID = 1000
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnScheduleJob.setOnClickListener {
            scheduleJob(this)
            Toast.makeText(this, "Job scheduled", Toast.LENGTH_LONG).show()
        }
        binding.btnCancelJob.setOnClickListener {
            jobScheduler.cancel(JOB_ID)
            Toast.makeText(this, "Job canceled", Toast.LENGTH_LONG).show()
        }

    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun scheduleJob(context: Context){
        //TODO : initialisation de jobScheduler
        val componentName = ComponentName(this,MyJobService::class.java)
        val builder = JobInfo.Builder(JOB_ID,componentName)
            .setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED)
           .setRequiresBatteryNotLow(true)
            .setPeriodic(15*60*1000)
        val jobInfo = builder.build()
        jobScheduler = context.getSystemService(JOB_SCHEDULER_SERVICE) as JobScheduler
        jobScheduler.schedule(jobInfo)
    }
}