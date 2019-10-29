package com.zz.jetpack.ui.fragment.login


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.zz.jetpack.R
import com.zz.jetpack.databinding.FragmentLoginBinding
import com.zz.jetpack.viewmodle.LoginModel

/**
 * A simple [Fragment] subclass.
 */
class LoginFragment : Fragment() {

    lateinit var loginModel:LoginModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // DataBindingUtil 方法
        val binding: FragmentLoginBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_login,container,false)

        //FragmentLoginBinding
//        val binding =  FragmentLoginBinding.inflate(inflater,container,false)

        loginModel = LoginModel("", "", context!!)
        binding.model = loginModel
        binding.activity = activity
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var name = arguments?.getString("name")
//        et_account.text = Editable.Factory.getInstance().newEditable(name)
////        et_account.setText(name)
//
//        btn_login.setOnClickListener {
//            val intent = Intent(context,MainActivity::class.java)
//            startActivity(intent)
//        }

        name?.let {
            loginModel.n.set(it)
        }

    }
}
