package com.certified.rickmorty.di

import com.certified.rickmorty.util.Config.BASE_URL
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson, client: OkHttpClient): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create(gson))
        .baseUrl(BASE_URL)
        .client(client)
        .build()

    @Provides
    fun provideGson(): Gson = GsonBuilder()
        .setLenient()
        .create()

    @Provides
    fun provideLogger() = HttpLoggingInterceptor()

    @Provides
    @Singleton
    fun provideClient(logger: HttpLoggingInterceptor): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(logger)
        .build()

//    @Provides
//    fun provideRickMortyApiService(retrofit: Retrofit): RickMortyApiService =
//        retrofit.create(RickMortyApiService::class.java)
//
//    @Provides
//    fun provideGitHubRepository(service: RickMortyApiService): RickMortyRepository =
//        RickMortyRepository(service)
}