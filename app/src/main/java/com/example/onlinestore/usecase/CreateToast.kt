package com.example.onlinestore.usecase

import android.content.Context
import android.graphics.Color
import android.graphics.PorterDuff
import android.widget.Toast

class CreateToast {
    fun showToastMessage(message: String, context: Context) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}