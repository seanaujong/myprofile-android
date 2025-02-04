package com.seanaujong.myprofile.data.auth

import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class FirebaseAuthRepository : AuthRepository {

    private val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()

    private val _isSignedIn = MutableStateFlow(firebaseAuth.currentUser != null)

    override fun isSignedIn(): StateFlow<Boolean> = _isSignedIn

    override fun signIn(email: String, password: String, onResult: (Boolean) -> Unit) {
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                _isSignedIn.value = firebaseAuth.currentUser != null
                onResult(task.isSuccessful)
            }
    }

    override fun signUp(email: String, password: String, onResult: (Boolean) -> Unit) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                _isSignedIn.value = firebaseAuth.currentUser != null
                onResult(task.isSuccessful)
            }
    }

    override fun signOut() {
        firebaseAuth.signOut()
        _isSignedIn.value = false
    }
}
