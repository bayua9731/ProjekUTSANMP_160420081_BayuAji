package com.anmp.projekuts.view

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.anmp.projekuts.R
import com.anmp.projekuts.model.Rumah
import com.anmp.projekuts.viewmodel.LoginViewModel
import com.anmp.projekuts.viewmodel.ViewModelList
import kotlinx.android.synthetic.main.fragment_login.*


class LoginFragment : Fragment() {
    private lateinit var viewModel: LoginViewModel
    private lateinit var login:Rumah
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnDaftar.setOnClickListener {
            val action=LoginFragmentDirections.actionLoginFragmentToRegisterFragment()
            Navigation.findNavController(it).navigate(action)
        }

        btnLogin.setOnClickListener {
                viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
                viewModel.login(txtUsername.text.toString(),editTextTextPassword.text.toString())
                viewModel.homeLD.observe(viewLifecycleOwner, Observer {
                    if(it!=null){
                        Log.d("IDUSEEERRR",it.iduser.toString())
                        val intent=Intent(this.context,MainActivity::class.java)
                        intent.putExtra("idakun",it.iduser)
                        startActivity(intent)
                    }
                    else{
                        Toast.makeText(this.context,"Maaf username/password Salah",Toast.LENGTH_SHORT)
                    }
                })


        }
    }

}