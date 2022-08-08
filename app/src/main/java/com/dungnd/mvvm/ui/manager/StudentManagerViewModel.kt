package com.dungnd.mvvm.ui.manager

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dungnd.mvvm.data.local.LocalDatabase
import com.dungnd.mvvm.data.local.model.Student
import com.dungnd.mvvm.data.remote.model.Photo
import com.dungnd.mvvm.ui.base.BaseViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class StudentManagerViewModel @Inject constructor(
    private val localDatabase: LocalDatabase
) : BaseViewModel() {
    var studentList = MutableLiveData<List<Student>>()
    init {
        getAllStudent()
    }
    fun getAllStudent(){
        viewModelScope.launch {
            studentList.value= localDatabase.studentDao().getAllFolder()
        }
    }
    fun deletewithid(id:Int){
        viewModelScope.launch {
            localDatabase.studentDao().deleteById(id)
        }
    }

}