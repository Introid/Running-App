package com.example.runningapp.ui.fragments

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.runningapp.R
import com.example.runningapp.other.Constants.KEY_NAME
import com.example.runningapp.other.Constants.KEY_WEIGHT
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_settings.*
import kotlinx.android.synthetic.main.fragment_setup.*
import kotlinx.android.synthetic.main.fragment_setup.etName
import kotlinx.android.synthetic.main.fragment_setup.etWeight
import javax.inject.Inject

@AndroidEntryPoint
class SettingsFragment :Fragment(R.layout.fragment_settings){

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadFieldsFromSharedPrefs()
        btnApplyChanges.setOnClickListener {
            val success = applyChangesToSharedPrefs()
            if (success){
                Snackbar.make(view, "Saved Changes " ,Snackbar.LENGTH_LONG).show()
            }else {
                Snackbar.make(view, "Please Fill out all the Fields" , Snackbar.LENGTH_LONG).show()
            }
        }



    }

    private fun loadFieldsFromSharedPrefs() {
        val name = sharedPreferences.getString(KEY_NAME , "")
        val weight = sharedPreferences.getFloat(KEY_WEIGHT , 80f)
        etName.setText(name)
        etWeight.setText(weight.toString())


    }


    private fun applyChangesToSharedPrefs(): Boolean {
        val nameText = etName.text.toString()
        val weightText = etWeight.text.toString()

        if(nameText.isEmpty() || weightText.isEmpty()){
            return false
        }
        sharedPreferences.edit()
            .putString(KEY_NAME , nameText)
            .putFloat(KEY_WEIGHT , weightText.toFloat())
            .apply()

        val toolbarText = "Let's go $nameText"
        requireActivity().tvToolbarTitle.text = toolbarText
        return true
    }



}