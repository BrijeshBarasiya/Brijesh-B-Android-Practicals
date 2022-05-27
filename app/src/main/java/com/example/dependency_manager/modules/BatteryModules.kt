package com.example.dependency_manager.modules

import com.example.dependency_manager.model.Battery
import com.example.dependency_manager.model.Cobalt
import com.example.dependency_manager.model.Lithium
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class BatteryModules {

    @Provides
    fun getCobalt(): Cobalt {
        return Cobalt()
    }

    @Provides
    fun getLithium(): Lithium {
        return Lithium()
    }

    @Provides
    @Singleton
    fun getBattery(cobalt: Cobalt, lithium: Lithium): Battery {
        return Battery(cobalt, lithium)
    }

}