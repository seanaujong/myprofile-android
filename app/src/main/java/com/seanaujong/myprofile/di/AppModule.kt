package com.seanaujong.myprofile.di

import com.google.firebase.auth.FirebaseAuth
import com.seanaujong.myprofile.data.auth.AuthRepository
import com.seanaujong.myprofile.data.auth.CurrentUserProvider
import com.seanaujong.myprofile.data.auth.FirebaseAuthRepository
import com.seanaujong.myprofile.usecase.IsSignedIn
import com.seanaujong.myprofile.usecase.SignIn
import com.seanaujong.myprofile.usecase.SignInProvider
import com.seanaujong.myprofile.usecase.SignOut
import com.seanaujong.myprofile.usecase.SignOutProvider
import com.seanaujong.myprofile.usecase.SignUp
import com.seanaujong.myprofile.usecase.SignUpProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideFireBaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    @Singleton
    fun provideAuthRepository(
        firebaseAuth: FirebaseAuth
    ): AuthRepository = FirebaseAuthRepository(
        firebaseAuth = firebaseAuth
    )

    @Provides
    @Singleton
    fun provideCurrentUserProvider(authRepository: AuthRepository): CurrentUserProvider = authRepository

    @Provides
    @Singleton
    fun provideSignInProvider(authRepository: AuthRepository): SignInProvider = authRepository

    @Provides
    @Singleton
    fun provideSignUpProvider(authRepository: AuthRepository): SignUpProvider = authRepository

    @Provides
    @Singleton
    fun provideSignOutProvider(authRepository: AuthRepository): SignOutProvider = authRepository

    @Provides
    @Singleton
    fun provideIsSignedIn(currentUserProvider: CurrentUserProvider): IsSignedIn = IsSignedIn(currentUserProvider)

    @Provides
    @Singleton
    fun provideSignIn(signInProvider: SignInProvider): SignIn = SignIn(signInProvider)

    @Provides
    @Singleton
    fun provideSignUp(signUpProvider: SignUpProvider): SignUp = SignUp(signUpProvider)

    @Provides
    @Singleton
    fun provideSignOut(signOutProvider: SignOutProvider): SignOut = SignOut(signOutProvider)
}
