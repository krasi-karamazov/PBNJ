package com.appsbg.presentation.util.user

sealed class User {}

object NotAuthenticated: User()

data class AuthenticatedUser(val userName: String, val password: String): User()