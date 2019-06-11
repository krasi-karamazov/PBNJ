package com.appsbg.presentation.util.user

import android.accounts.Account
import android.accounts.AccountManager
import android.annotation.SuppressLint
import android.content.Context
import javax.inject.Inject

@SuppressLint("MissingPermission")
class UserManager @Inject constructor(val accountManager: AccountManager) {

    companion object {
        const val palmsBetAccountType = "com.appsbg.palmsbet"
    }
    var accountName: String? = null
    var isLoggedIn: Boolean = false
    var currentUser: User? = null

    init {
        val account = getCurrentAccount()
        if(account != null) {
            accountName = account.name
            currentUser = AuthenticatedUser(accountName!!, accountManager.getPassword(account))
        } else {
            currentUser = NotAuthenticated
        }
    }

    private fun getCurrentAccount(): Account? {
        val accounts: Array<Account> = accountManager.accounts
        for(account in accounts) {
            if(account.type.equals(palmsBetAccountType)) {
                return account
            }
        }
        return null
    }
}