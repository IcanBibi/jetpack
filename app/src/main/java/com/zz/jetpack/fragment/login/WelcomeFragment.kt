package com.zz.jetpack.fragment.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.zz.jetpack.R
import kotlinx.android.synthetic.main.fragment_welcome.*


class WelcomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_welcome, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_login.setOnClickListener{
            //设置动画
            val navOptions = navOptions {
                anim {
                    enter = R.anim.slide_in_right
                    exit = R.anim.slide_out_left
                    popEnter = R.anim.slide_in_left
                    popExit = R.anim.slide_out_right
                }
            }
            //设置参数
            val bundle = Bundle()
            bundle.putString("name","Zz")
            //R.id.loginFragment 是在 navigation 中显示的 布局id
            findNavController().navigate(R.id.loginFragment, bundle,navOptions)
        }

        btn_register.setOnClickListener{
            val action = WelcomeFragmentDirections
                .actionWelcomeFragmentToRegisterFragment()
                .setEMAIL("Zz@Gamil.com")
            findNavController().navigate(action)
        }

    }


}
