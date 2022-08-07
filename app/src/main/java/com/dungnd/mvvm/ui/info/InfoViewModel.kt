package com.dungnd.mvvm.ui.info

import androidx.lifecycle.viewModelScope
import com.dungnd.mvvm.data.local.LocalDatabase
import com.dungnd.mvvm.data.local.model.Student
import com.dungnd.mvvm.ui.base.BaseViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class InfoViewModel @Inject constructor(
    private val localDatabase: LocalDatabase
) : BaseViewModel() {
//    var studentList = MutableLiveData<List<Student>>()
    init {


    }

    fun updateStudent( student: Student) {
        viewModelScope.launch {
            localDatabase.studentDao().update(student)
        }
    }
    fun addStudent(student: Student){
        viewModelScope.launch {
            localDatabase.studentDao().addStudent(student)
        }
    }
}