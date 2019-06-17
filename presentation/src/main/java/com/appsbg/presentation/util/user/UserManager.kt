package com.appsbg.presentation.util.user

import android.accounts.Account
import android.accounts.AccountManager
import android.annotation.SuppressLint
import javax.inject.Inject
import javax.inject.Singleton

@SuppressLint("MissingPermission")
@Singleton
class UserManager @Inject constructor(val accountManager: AccountManager) {

    companion object {
        const val palmsBetAccountType = "com.appsbg.palmsbet"
    }
    var accountName: String? = null
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

    fun checkUserStatus(): User? {
        return currentUser
    }
}