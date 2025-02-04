package com.seanaujong.myprofile.di

import com.seanaujong.myprofile.data.auth.AuthRepository
import com.seanaujong.myprofile.data.auth.FirebaseAuthRepository
import com.seanaujong.myprofile.usecase.SignIn
import com.seanaujong.myprofile.usecase.SignOut
import com.seanaujong.myprofile.usecase.SignUp
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
    fun provideAuthRepository(): AuthRepository = FirebaseAuthRepository()

    @Provides
    @Singleton
    fun provideSignInUseCase(authRepository: AuthRepository): SignIn = SignIn(authRepository)

    @Provides
    @Singleton
    fun provideSignUpUseCase(authRepository: AuthRepository): SignUp = SignUp(authRepository)

    @Provides
    @Singleton
    fun provideSignOutUseCase(authRepository: AuthRepository): SignOut = SignOut(authRepository)
}
