package com.dungnd.mvvm.ui.info

import android.util.Patterns
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.findNavController
import com.dungnd.mvvm.R
import com.dungnd.mvvm.data.local.model.Student
import com.dungnd.mvvm.databinding.FragmentInforBinding
import com.dungnd.mvvm.ui.base.BaseFragment
import com.dungnd.mvvm.util.setOnSingClickListener

class InfoFragment : BaseFragment<FragmentInforBinding,InfoViewModel>() {
    override fun layoutRes(): Int {
        return R.layout.fragment_infor
    }

    override fun viewModelClass(): Class<InfoViewModel> =InfoViewModel::class.java

    override fun initView() {

        val type =arguments?.getBoolean("type")
        if (type == true){
            editInfor()
        }else{
            addInfo()
        }
    }

    private fun addInfo() {
        var student:Student
        binding.toolbar.tvCenter.text=context?.getText(R.string.add_student)
//        binding.edtSvPhone.addTextChangedListener {
//            val phone=binding.edtSvPhone.text.toString().trim()
//            binding.edtSvPhone.setText(phone)
//            if (Patterns.PHONE.matcher(phone).matches()){
//                binding.edtSvPhone.error = "sdt hợp lý"
//                binding.btnSave.isEnabled=true
//            }else{
//                binding.edtSvPhone.error = "sdt méo hợp lý"
//                binding.btnSave.isEnabled=false
//            }
//        }
        binding.btnSave.setOnSingClickListener {
            val name = binding.edtFolderName.text.toString()
            val address = binding.edtSvAddress.text.toString()
            val phone = binding.edtSvPhone.text.toString()
            if (name.isEmpty() || address.isEmpty() || phone.isEmpty()) {
                Toast.makeText(context,getString(R.string.back),Toast.LENGTH_SHORT).show()

            } else {
                student= Student(System.currentTimeMillis().toInt(),name,address,phone)

                    viewModel.addStudent(student)

                findNavController().navigate(
                    R.id.action_infoFragment_to_studentManagerFragment
                )
            }

        }
    }

    private fun editInfor(){
        val student:Student= arguments?.get("student") as Student

        binding.toolbar.tvCenter.text=context?.getText(R.string.edit_student)
        binding.edtFolderName.setText(student.name)
        binding.edtSvAddress.setText(student.address)
        binding.edtSvPhone.setText(student.phone)
        binding.edtSvPhone.addTextChangedListener {
            val phone=binding.edtSvPhone.text.toString().trim()
            if (Patterns.PHONE.matcher(phone).matches()){
                binding.edtSvPhone.error = "sdt hợp lý"
                binding.btnSave.isEnabled=true
            }else{
                binding.edtSvPhone.error = "sdt méo hợp lý"
                binding.btnSave.isEnabled=false
            }
        }
        binding.btnSave.setOnSingClickListener {
            val name = binding.edtFolderName.text.toString()
            val address = binding.edtSvAddress.text.toString()
            val phone = binding.edtSvPhone.text.toString()
            if (name.isEmpty() || address.isEmpty() || phone.isEmpty()) {
                Toast.makeText(context,getString(R.string.back),Toast.LENGTH_SHORT).show()

            } else {
                student.name = name
                student.address = address
                student.phone = phone
                viewModel.updateStudent(student)
                findNavController().navigate(
                    R.id.action_infoFragment_to_studentManagerFragment
                )
            }

        }
    }


}