package com.zz.jetpack.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.zz.jetpack.db.data.User

@Dao
interface UserDao {
    @Query("SELECT * FROM user WHERE user_account = :account AND user_pwd = :pwd")
    fun login(account:String,pwd:String):List<User>

    @Insert
    fun insertUser(user:User)

    @Delete
    fun deleteUser(user: User)
}