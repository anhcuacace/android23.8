package com.dungnd.mvvm.data.local

import com.dungnd.mvvm.data.local.dao.FavouriteQuoteDao
import com.dungnd.mvvm.data.local.dao.ItemDao
import com.dungnd.mvvm.data.local.dao.StudentDao
import com.dungnd.mvvm.data.local.model.FavouriteQuote
import com.dungnd.mvvm.data.local.model.Item
import com.dungnd.mvvm.data.local.model.Student
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalRepository @Inject constructor(
    private val favouriteQuoteDao: FavouriteQuoteDao,
    private val itemDao: ItemDao,
    private val studentDao: StudentDao
) {

    suspend fun addFavouriteQuote(favouriteQuote: FavouriteQuote) {
        favouriteQuoteDao.addQuote(favouriteQuote)
    }

    suspend fun deleteFavouriteQuote(favouriteQuote: FavouriteQuote) {
        favouriteQuoteDao.removeFromFavourite(favouriteQuote)
    }

    suspend fun getAllFavouriteQuotes(): List<FavouriteQuote> {
        return favouriteQuoteDao.getAllQuotes()
    }

    suspend fun addItem(item: Item) = itemDao.addItem(item)

    suspend fun getItemWithId(id: Int) = itemDao.getItemWithId(id)

    suspend fun getAllItems() = itemDao.getAllItems()

    suspend fun addStudent(student: Student)= studentDao.addStudent(student)

    suspend fun getStudentWithId(id:Int)=studentDao.getItemWithId(id)

    suspend fun getAllStudent()=studentDao.getAllFolder()

    suspend fun deleteWithid(id: Int)=studentDao.deleteById(id)

    suspend fun getFinishedItemCountByType(type: String) =
        itemDao.getFinishedItemCountByType(type)

    suspend fun getWatchedEpisodesSum() = itemDao.getWatchedEpisodesSum()
}