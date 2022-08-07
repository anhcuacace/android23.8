package com.dungnd.mvvm.ui.manager

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dungnd.mvvm.data.local.model.Student
import com.dungnd.mvvm.databinding.ItemStudentBinding
import com.dungnd.mvvm.util.setOnSingClickListener

class StudentAdapter: RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {
    inner class StudentViewHolder constructor(private val binding: ItemStudentBinding)
        :RecyclerView.ViewHolder(binding.root){
            fun bind(student: Student){
                binding.nameItem.text=student.name
                binding.addressItem.text=student.address
                binding.phoneItem.text=student.phone
            }

    }

    var studentList:List<Student>?=null
    var onStudentClick:((Student,Int)->Unit)?=null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val binding=ItemStudentBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return StudentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        studentList?.get(position)?.let { holder.bind(it) }
        holder.itemView.setOnSingClickListener {
            studentList?.let { it1 -> onStudentClick?.invoke(it1[position], position) }
        }
        }


    override fun getItemCount(): Int = studentList?.size?:0


}