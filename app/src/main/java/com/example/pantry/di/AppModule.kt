package com.example.pantry.di

import com.example.pantry.meal.repository.IMealRepository
import com.example.pantry.meal.repository.MealRepository
import com.example.pantry.meal.usecase.GetMealUseCase
import com.example.pantry.meal.usecase.IGetMealUseCase
import com.example.pantry.meal.service.IMealService
import com.example.pantry.recipes.service.IRecipeService
import com.example.pantry.recipes.usecase.GetRecipeUseCase
import com.example.pantry.recipes.usecase.IGetRecipeUseCase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
// Creates API Request framework
class AppModule {

    // Only once, provides Retrofit which makes the HTTP request and converts
    @Provides
    @Singleton
    fun provideRetrofit() : Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v2/9973533/")
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // Returns Retrofit created service
    @Provides
    @Singleton
    fun providesMealService(
        retrofit: Retrofit) : IMealService{
        return retrofit.create(IMealService::class.java)
    }

    @Provides
    @Singleton
    fun providesRecipeService(
        retrofit: Retrofit) : IRecipeService{
        return retrofit.create(IRecipeService::class.java)
    }

    @Module
    @InstallIn(SingletonComponent::class)
    interface AppModuleInt {

        @Binds
        @Singleton
        fun provideMealRepository(repo: MealRepository) : IMealRepository

        @Binds
        @Singleton
        fun provideGetMealUseCase(uc : GetMealUseCase) : IGetMealUseCase

        @Binds
        @Singleton
        fun provideGetRecipeUseCase(uc : GetRecipeUseCase) : IGetRecipeUseCase

    }
}