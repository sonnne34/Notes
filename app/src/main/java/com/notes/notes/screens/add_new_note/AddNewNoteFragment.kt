package com.notes.notes.screens.add_new_note

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.notes.notes.R
import com.notes.notes.databinding.FragmentAddNewNoteBinding
import com.notes.notes.models.AppNote
import com.notes.notes.utilits.APP_ACTIVITY
import com.notes.notes.utilits.log
import com.notes.notes.utilits.showToast

class AddNewNoteFragment : Fragment() {

    private var _binding: FragmentAddNewNoteBinding? = null
    private val mBinding get() = _binding!!
    private lateinit var mViewModel: AddNewFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddNewNoteBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()
        initialization()
    }

    private fun initialization() {
        mViewModel = ViewModelProvider(this).get(AddNewFragmentViewModel::class.java)
        log("mViewModel = ViewModelProvider(this).get(AddNewFragmentViewModel::class.java)")
        mBinding.btnAddNotes.setOnClickListener {
            log("mBinding.btnAddNote.setOnClickListener")
            val name = mBinding.inputNameNote.text.toString()
            val text = mBinding.inputTextNote.text.toString()
            if (name.isEmpty()) {
                showToast(getString(R.string.toast_enter_name))
            } else {
                log("до insert")
                mViewModel.insert(AppNote(name = name, text = text)) {
                    log("insert")
                    requireActivity().runOnUiThread { APP_ACTIVITY.navController.navigate(R.id.action_addNewNoteFragment_to_mainFragment) }
                    log(" APP_ACTIVITY.navController.navigate(R.id.action_addNewNoteFragment_to_mainFragment)")
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}