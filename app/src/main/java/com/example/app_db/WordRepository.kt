package com.example.app_db

import androidx.lifecycle.LiveData

class WordRepository (private val wordDao: WordDao) {

    val allWords : LiveData<List<Word>> = wordDao.getAlphavetizedWords()

    suspend fun insert(word: Word) {
        wordDao.insert(word)
    }
}