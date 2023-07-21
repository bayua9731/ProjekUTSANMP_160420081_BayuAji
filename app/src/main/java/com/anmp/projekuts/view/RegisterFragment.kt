package com.anmp.projekuts.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.anmp.projekuts.R
import com.anmp.projekuts.model.Users
import com.anmp.projekuts.viewmodel.RegisterViewModel
import kotlinx.android.synthetic.main.fragment_register.*

class RegisterFragment : Fragment() {
    private lateinit var viewModel:RegisterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnSubmitRegister2.setOnClickListener {
            viewModel =
                ViewModelProvider(this).get(RegisterViewModel::class.java)

            val txtName=txtName2.text.toString()
            val txtEmail=editTextTextEmailAddress2.text.toString()
            val txtPhone=editTextPhone.text.toString()
            val txtUsername=txtUsernameRegister2.text.toString()
            val txtPassword=editTextTextPassword3.text.toString()
            val users=Users(txtName,txtEmail,txtPhone,txtUsername,txtPassword)
            viewModel.add(listOf(users))
            Toast.makeText(view.context, "Data added", Toast.LENGTH_LONG).show()
            Navigation.findNavController(it).popBackStack()
        }
        btnBack2.setOnClickListener {
            Navigation.findNavController(it).popBackStack()
        }
    }
}