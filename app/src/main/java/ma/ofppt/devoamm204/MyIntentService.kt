package ma.ofppt.devoamm204

import android.app.IntentService
import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.core.app.JobIntentService

class MyIntentService : Service() {

    override fun onBind(intent: Intent?): IBinder? {
    return null
    }
}