package com.seanaujong.myprofile.data.auth

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.tasks.await

class FirebaseAuthRepository(
    private val firebaseAuth: FirebaseAuth
) : AuthRepository {

    private val _currentUser = MutableStateFlow<UserAccount?>(
        firebaseAuth.currentUser?.let { FirebaseUserAccount(it) }
    )
    override val currentUser: StateFlow<UserAccount?> = _currentUser.asStateFlow()

    init {
        firebaseAuth.addAuthStateListener { auth ->
            _currentUser.value = auth.currentUser?.let { FirebaseUserAccount(it) }
        }
    }

    override suspend fun signIn(email: String, password: String): Result<UserAccount> {
        return try {
            val result = firebaseAuth.signInWithEmailAndPassword(email, password).await()
            val user = result.user
            if (user != null) {
                val userAccount = FirebaseUserAccount(result.user!!)
                _currentUser.value = userAccount
                Result.success(userAccount)
            } else {
                Result.failure(IllegalStateException("User is null after signup"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun signUp(email: String, password: String): Result<UserAccount> {
        return try {
            val result = firebaseAuth.createUserWithEmailAndPassword(email, password).await()
            val userAccount = FirebaseUserAccount(result.user!!)
            _currentUser.value = userAccount
            Result.success(userAccount)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override fun signOut() {
        firebaseAuth.signOut()
        _currentUser.value = null
    }
}

class FirebaseUserAccount(private val firebaseUser: FirebaseUser) : UserAccount {
    override val uid: String get() = firebaseUser.uid
    override val email: String? get() = firebaseUser.email
    override val displayName: String? get() = firebaseUser.displayName
}
