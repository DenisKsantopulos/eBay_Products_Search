package com.example.onlinestore.domain.utils

import android.content.Context
import android.widget.Toast

class CreateToast {
    fun showToastMessage(message: String, context: Context) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}