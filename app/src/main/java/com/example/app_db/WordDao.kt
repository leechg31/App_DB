package com.example.app_db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface WordDao {

    @Query("SELECT * FROM word_table ORDER BY word ASC")
    fun getAlphavetizedWords() : LiveData<List<Word>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)//기존에 존재하는 데이터와 새로 들어온 데이터가 일치할 때, 충돌 방지
    suspend fun insert(word: Word)

    @Query("DELETE FROM word_table")//@Delete는 다 지우는게 아님
    suspend fun deleteAll()
}