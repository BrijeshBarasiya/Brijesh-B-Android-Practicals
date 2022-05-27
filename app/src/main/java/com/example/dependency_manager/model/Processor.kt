package com.example.dependency_manager.model

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

interface Processor{
    fun start()
}

@Singleton
class Snapdragon @Inject constructor(@Named("core") var core: Int, @Named("clockSpeed") var clockSpeed: Int): Processor {

    init {
        start()
    }

    override fun start() {
        TODO("Not yet implemented")
    }

}

@Module
@InstallIn(SingletonComponent::class)
class SnapdragonModule {

    @Provides
    fun getProcessor(snapdragon: Snapdragon): Snapdragon = snapdragon

    @Provides
    @Named("core")
    fun getCore() = 8

    @Provides
    @Named("clockSpeed")
    fun getClockSpeed() = 3

}