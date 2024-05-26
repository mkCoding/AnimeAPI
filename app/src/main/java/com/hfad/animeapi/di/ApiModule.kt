package com.hfad.animeapi.di

import com.google.gson.Gson
import com.hfad.animeapi.data.api.ApiDetails
import com.hfad.animeapi.data.api.ApiEndpoints
import com.hfad.animeapi.data.repository.ApiRepository
import com.hfad.animeapi.data.repository.ApiRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class) //instantiate object to only 1 class
class ApiModule {

    @Provides
    fun providesRetrofit():Retrofit {

        //used for converting java objects to json
        val gson = Gson()
        val gsonConverterFactory = GsonConverterFactory.create(gson)

        //Create Interceptor
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        //Create okhttpClient
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()

        return Retrofit.Builder()
            .baseUrl(ApiDetails.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }
        @Provides
        fun providesApiEndpoints(retrofit: Retrofit):ApiEndpoints {
            return retrofit.create(ApiEndpoints::class.java)
        }

        @Provides
        fun providesRepository(apiEndpoints: ApiEndpoints):ApiRepository{
            return ApiRepositoryImpl(apiEndpoints)
        }

    }


