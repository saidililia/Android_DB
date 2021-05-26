package com.example.myapplication
import android.content.Context
import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class DBObject(context:Context): SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION){

      companion object {
            private const val DATABASE_VERSION = 1
            private const val DATABASE_NAME = "TRACK_IT"
            private const val TABLE_NAME = "sensors"
            private const val Humidity = "humidity"
            private const val Temperature = "temperature"
            private const val  Date = "date"
            private const val  longitude= "longitude"
            private const val latitude= "latitude"
            private const val KEY_ID = "id"
      }

       override fun onCreate(db: SQLiteDatabase?) {
              val query = ("CREATE TABLE "+ TABLE_NAME +"("+ KEY_ID + " INTEGER PRIMARY KEY"+ Temperature +
                      " float"+ Humidity + " float"+ Date + " Date"+ longitude + " float"
                      + latitude + "float")

              db?.execSQL(query)
       }

      override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
            db!!.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
            onCreate(db)
       }
      fun  addRecord(db:SQLiteDatabase?, data:DataTO): Boolean {
          val w=this.writableDatabase

           val values = ContentValues()
          values.put(Humidity, data.humidity)
          values.put(Temperature, data.temperature)
          values.put(Date, data.date.toString())
          values.put(longitude, data.long)
          values.put(latitude, data.latit)

          val success = db?.insert("sensors", null, values)
          db?.close()
          Log.v("InsertedID", "$success")
          return (Integer.parseInt("$success") != -1)
      }
      fun Delete_ALL(db:SQLiteDatabase?):Boolean {
          val d = this.writableDatabase;
          val del = db?.delete(TABLE_NAME, null, null)
          db?.close()
          return (Integer.parseInt("del") != -1)

      }

}