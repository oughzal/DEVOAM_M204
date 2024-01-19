package ma.ofppt.devoamm204

import android.app.job.JobParameters
import android.app.job.JobService
import android.util.Log
import java.util.Random

class MyJobService : JobService() {
    override fun onStartJob(params: JobParameters?): Boolean {
        Log.i("JOB_Scheduler","Job Started " + Random().nextInt())
        return false
    }

    override fun onStopJob(params: JobParameters?): Boolean {
        return false
    }
}