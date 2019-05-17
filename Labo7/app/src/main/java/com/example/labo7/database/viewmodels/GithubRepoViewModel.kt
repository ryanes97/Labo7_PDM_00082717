package com.example.labo7.database.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.labo7.database.RoomDB
import com.example.labo7.database.entities.GithubRepo
import com.example.labo7.database.repositories.GithubRepoRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GithubRepoViewModel(app:Application):AndroidViewModel(app) {

    private val repository: GithubRepoRepository

    init {
        val repoDao=RoomDB.getInstance(app).repoDAO()
        repository= GithubRepoRepository(repoDao)
    }

    fun getAll():LiveData<List<GithubRepo>> = repository.getAll()

    fun insert(repo:GithubRepo)=viewModelScope.launch(Dispatchers.IO) {
        repository.instert(repo) }
}