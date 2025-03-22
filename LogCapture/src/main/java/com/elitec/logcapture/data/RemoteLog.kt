package com.elitec.logcapture.data

import android.content.Context
import android.os.Build
import com.elitec.logcapture.model.DevicesLog
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.http.isSuccess
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import java.time.Instant
import java.util.Date

object RemoteLog {
    private val _httpClient = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(
                Json {
                    ignoreUnknownKeys = true
                }
            )
        }
    }

    fun uploadLog(errorMesage: String, errorCode: String) {
        val log = DevicesLog(
            applicationName = "EnRuta",
            operativeSystem = Build.MANUFACTURER,
            deviceBrand = Build.BRAND,
            deviceModel = Build.MODEL,
            date = Instant.now().toString(),
            errorCode = errorCode,
            errorMessage = errorMesage
        )
        CoroutineScope(Dispatchers.IO + SupervisorJob()).launch {
            try {
                val response: HttpResponse = _httpClient.post(BackendInfoImpl.urlSec+"/log") {
                    contentType(ContentType.Application.Json)
                    setBody(
                        log
                    )
                }
            }
            catch (_: Exception) {

            }
        }
    }
}