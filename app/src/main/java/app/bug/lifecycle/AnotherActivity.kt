package app.bug.lifecycle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class AnotherActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_another)
  }
}
