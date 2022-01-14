package com.ikhsanhdyt.loginlayoutexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ikhsanhdyt.loginlayoutexample.databinding.ActivityMainBinding
import com.shashank.sony.fancytoastlib.FancyToast

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setOnClickListerners()
    }

    private fun setOnClickListerners() {
        binding.llGmail.setOnClickListener {
            FancyToast.makeText(
                this,
                getString(R.string.toast_gmail_success),
                Toast.LENGTH_SHORT,
                FancyToast.SUCCESS,
                false
            ).show()
        }
        binding.llFacebook.setOnClickListener {
            FancyToast.makeText(
                this,
                getString(R.string.toast_facebook_success),
                Toast.LENGTH_SHORT,
                FancyToast.SUCCESS,
                false
            ).show()
        }
        binding.btnLogin.setOnClickListener {
            checkLogin()
        }
    }

    fun checkLogin() {
        if (isFormValid()){
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etEmail.text.toString().trim()
            if (email == "admin@gmail.com" && password == "admin"){
                FancyToast.makeText(
                    this,
                    getString(R.string.toast_login_success),
                    Toast.LENGTH_SHORT,
                    FancyToast.SUCCESS,
                    false
                ).show()
            }
        }else{
            FancyToast.makeText(
                this,
                getString(R.string.toast_login_error),
                Toast.LENGTH_SHORT,
                FancyToast.ERROR,
                false
            ).show()
        }
    }

    private fun isFormValid() :Boolean {
        val email = binding.etEmail.text.toString().trim()
        val password = binding.etEmail.text.toString().trim()
        var isFormValid = true

        if (email.isEmpty()){
            isFormValid = false
            binding.tfEmail.isErrorEnabled = true
            binding.tfEmail.error = getString(R.string.text_error_email)
        }else{
            binding.tfEmail.isErrorEnabled = false
        }

        if (password.isEmpty()){
            isFormValid = false
            binding.tfPass.isErrorEnabled = true
            binding.tfPass.error = getString(R.string.text_error_pass)
        }else{
            binding.tfPass.isErrorEnabled = false
        }

        return isFormValid
    }
}