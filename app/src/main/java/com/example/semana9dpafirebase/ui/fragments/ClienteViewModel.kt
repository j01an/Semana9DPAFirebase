package com.example.semana9dpafirebase.ui.fragments

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.semana9dpafirebase.database.CostumerRepository
import com.example.semana9dpafirebase.database.CustomerEntity

class ClienteViewModel(application: Application):AndroidViewModel(application) {
    private var repository = CostumerRepository(application)
    val customers = repository.getCustomer()

    fun saveCustomer(customerEntity: CustomerEntity){
        repository.insert(customerEntity)
    }
}