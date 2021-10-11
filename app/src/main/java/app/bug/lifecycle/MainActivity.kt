package app.bug.lifecycle

import android.app.Activity
import android.app.Application.ActivityLifecycleCallbacks
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    setupApplication()

    findViewById<TextView>(R.id.click_me).setOnClickListener {
      startActivity(Intent(this, AnotherActivity::class.java))
    }
  }

  private fun setupApplication() {
    application.registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks {
      override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        Log.i("Lifecycle", "Created: $activity")
      }

      override fun onActivityStarted(activity: Activity) {
        Log.i("Lifecycle", "Started: $activity")
      }

      override fun onActivityResumed(activity: Activity) {
        Log.i("Lifecycle", "Resumed: $activity")
      }

      override fun onActivityPaused(activity: Activity) {
        Log.w("Lifecycle", "Paused: $activity")
      }

      override fun onActivityStopped(activity: Activity) {
        Log.w("Lifecycle", "Stopped: $activity")
      }

      override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
        Log.d("Lifecycle", "Save state: $activity")
      }

      override fun onActivityDestroyed(activity: Activity) {
        Log.w("Lifecycle", "Destroyed: $activity")
      }
    })
  }
}
