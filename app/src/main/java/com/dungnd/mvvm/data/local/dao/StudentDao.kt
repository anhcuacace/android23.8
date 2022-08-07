package com.dungnd.mvvm.data.local.dao

import androidx.room.*
import com.dungnd.mvvm.data.local.model.Item
import com.dungnd.mvvm.data.local.model.Student

@Dao
interface StudentDao {
    @Query("SELECT * FROM student ORDER BY id DESC")
    fun getAllFolder(): List<Student>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addStudent(student: Student)

    @Query("select * from Item where malId = :id")
    suspend fun getItemWithId(id: Int): Item

    @Update
    fun update(student: Student)

    @Query("DELETE FROM student")
    fun deleteAll()
}