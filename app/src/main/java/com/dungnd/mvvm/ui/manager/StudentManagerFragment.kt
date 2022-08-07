package com.dungnd.mvvm.ui.manager

import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.dungnd.mvvm.R
import com.dungnd.mvvm.databinding.FragmentStudentManagerBinding
import com.dungnd.mvvm.ui.base.BaseFragment
import com.dungnd.mvvm.util.setOnSingClickListener


class StudentManagerFragment : BaseFragment<FragmentStudentManagerBinding,StudentManagerViewModel>() {
    private val adapter= StudentAdapter()
    override fun layoutRes(): Int {
        return R.layout.fragment_student_manager
    }

    override fun viewModelClass(): Class<StudentManagerViewModel> = StudentManagerViewModel::class.java

    override fun initView() {
        adapter.onStudentClick = { student, _ ->
            findNavController().navigate(
                R.id.action_studentManagerFragment_to_infoFragment,
                bundleOf(

                    Pair("type", true),
                    Pair("student",student)
                )
            )
        }
        viewModel.studentList.observe(this){
            adapter.studentList=it
        }
        binding.rclvBtvn7.adapter=adapter
        binding.addnewstudent.setOnSingClickListener {
            findNavController().navigate(
                R.id.action_studentManagerFragment_to_infoFragment,
                bundleOf(
                    Pair("type", false)
                )
            )
        }

    }


}