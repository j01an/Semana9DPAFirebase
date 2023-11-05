package com.example.semana9dpafirebase.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "customer")
data class CustomerEntity(
    @ColumnInfo(name = "first_name") var firstName: String?,
    @ColumnInfo(name = "last_name") var lastName: String?,
    @ColumnInfo(name = "phone_number") var phoneNumber: String?
){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("customer_id") var customerId: Int=0
}
