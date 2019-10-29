package com.zz.jetpack.viewmodle

import android.content.Context
import android.content.Intent
import android.text.Editable
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableField
import com.zz.jetpack.MainActivity
import com.zz.jetpack.common.BaseConstant
import com.zz.jetpack.common.SimpleWatcher

class LoginModel constructor(name: String, pwd: String, context: Context){
    val n = ObservableField<String>(name)
    val p = ObservableField<String>(pwd)
    var context = context


    fun onNameChanged(s: CharSequence) {
        n.set(s.toString())
    }

    fun onPwdChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        p.set(s.toString())
    }

    fun login() {
        if (n.get().equals(BaseConstant.USER_NAME)
            && p.get().equals(BaseConstant.USER_PWD))
        {
            Toast.makeText(context, "账号密码正确", Toast.LENGTH_SHORT).show()
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }
    }

    val pwdWatcher = object : SimpleWatcher(){
        override fun afterTextChanged(s: Editable) {
            super.afterTextChanged(s)
            p.set(s.toString())
        }
    }

    @BindingAdapter("addTextChangedListener")
    fun addTextChangedListener(editText: EditText, simpleWatcher: SimpleWatcher) {
        editText.addTextChangedListener(simpleWatcher)
    }
}