package com.zz.jetpack.db.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * 用户表
 */
@Entity(tableName = "user")
data class User(
    @ColumnInfo(name = "user_account") val account: String,  // 账号
    @ColumnInfo(name = "user_pwd") val pwd: String,//密码
    @ColumnInfo(name = "user_name") val name: String
//    @Embedded val address: Address,  //地址
//    @Ignore val state: Int // 状态只是临时用，所以不需要储存在数据库中
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long = 0
}