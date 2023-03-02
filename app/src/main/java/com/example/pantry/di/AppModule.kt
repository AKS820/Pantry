package com.example.pantry.di

import com.example.pantry.category.repository.CategoryRepository
import com.example.pantry.category.repository.ICategoryRepository
import com.example.pantry.category.service.ICategoryService
import com.example.pantry.category.service.IMealService
import com.example.pantry.category.usecase.GetCategoriesUseCase
import com.example.pantry.category.usecase.IGetCategoriesUseCase
import com.example.pantry.meal.repository.IMealRepository
import com.example.pantry.meal.repository.MealRepository
import com.example.pantry.meal.usecase.GetMealUseCase
import com.example.pantry.meal.usecase.IGetMealUseCase
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
    fun providesCategoryService(
        retrofit: Retrofit) : ICategoryService{
        return retrofit.create(ICategoryService::class.java)
    }

    @Provides
    @Singleton
    fun providesMealService(
        retrofit: Retrofit) : IMealService{
        return retrofit.create(IMealService::class.java)
    }

    @Module
    @InstallIn(SingletonComponent::class)
    interface AppModuleInt {


        @Binds
        @Singleton
        fun provideCategoryRepository(repo: CategoryRepository) : ICategoryRepository

        @Binds
        @Singleton
        fun provideGetCategoryUseCase(uc : GetCategoriesUseCase) : IGetCategoriesUseCase

        @Binds
        @Singleton
        fun provideMealRepository(repo: MealRepository) : IMealRepository

        @Binds
        @Singleton
        fun provideGetMealUseCase(uc : GetMealUseCase) : IGetMealUseCase

    }
}