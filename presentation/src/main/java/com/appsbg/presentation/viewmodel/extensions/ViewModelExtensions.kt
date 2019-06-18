package com.appsbg.presentation.viewmodel.extensions

import androidx.annotation.Nullable
import androidx.lifecycle.ViewModel
import com.appsbg.presentation.state.Resource

inline fun <reified T> ViewModel.getAppropriateEvent(@Nullable data: T?, @Nullable error: Throwable?): Resource<T> {
    return when {
        data == null && error == null -> Resource.error("No data received", data)
        data != null -> Resource.success(data)
        error != null -> Resource.error(error.message, null)
        else -> {
            Resource.error("Undefined error", null)
        }
    }
}