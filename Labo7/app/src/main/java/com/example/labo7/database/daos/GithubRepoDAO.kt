package com.example.labo7.database.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.labo7.database.entities.GithubRepo

@Dao
interface GithubRepoDAO {

    @Query("SELECT * FROM repos")
    fun getAll():LiveData<List<GithubRepo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(repo:GithubRepo)

    @Query("DELETE FROM repos")
    fun nukeTable()
}