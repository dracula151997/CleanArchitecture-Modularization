package com.dracula.data_local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dracula.data_local.db.user.UserDao
import com.dracula.data_local.db.user.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao
}