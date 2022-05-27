package com.example.dependency_manager.model

import javax.inject.Inject

class Mobile @Inject constructor(var battery: Battery, var processor: Processor) {
}