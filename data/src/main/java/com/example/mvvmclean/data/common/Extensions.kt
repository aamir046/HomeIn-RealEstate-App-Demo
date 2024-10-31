package com.example.mvvmclean.data.common

import android.content.Context
import androidx.datastore.preferences.preferencesDataStore
import com.example.mvvmclean.data.common.constants.Constants

val Context.dataStore by preferencesDataStore(Constants.PREFERENCES_NAME)
