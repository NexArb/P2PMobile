package com.dag.nexarbmobile.localdatastorage.preferencesdatastore

import androidx.datastore.preferences.core.booleanPreferencesKey

class PreferencesDataStoreKeys {
    companion object {
        val FIRST_LOGIN = booleanPreferencesKey("firs_login")
    }
}