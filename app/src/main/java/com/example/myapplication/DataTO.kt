package com.example.myapplication


import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime

class DataTO {
  var humidity: Float = 0.0f
  var temperature: Float = 0.0f
  var long: Float = 0.0f
  var latit: Float = 0.0f

  @RequiresApi(Build.VERSION_CODES.O)
  var date = LocalDateTime.now()
  var id:Int = 0
}