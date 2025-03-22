package com.elitec.logcapture.model

import kotlinx.serialization.Serializable

@Serializable
data class DevicesLog(
    val applicationName: String,
    val operativeSystem: String,
    val deviceBrand: String,
    val errorCode: String,
    val deviceModel: String,
    val errorMessage: String ,
    val date: String
)
