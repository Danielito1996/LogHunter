package com.elitec.logcapture

import android.content.Context
import android.content.Intent
import com.elitec.logcapture.data.RemoteLog
import com.elitec.logcapture.model.ErrorCode
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

object ErrorHandler {
    fun initialize(context: Context) {
        // Configura el manejador global de excepciones
        Thread.setDefaultUncaughtExceptionHandler { thread, throwable ->
            CoroutineScope(Dispatchers.IO).launch {
                RemoteLog.uploadLog(
                    errorMesage = throwable.stackTraceToString(),
                    errorCode = ErrorCode.Gen.name
                )
            }
            // Reinicia la aplicación (opcional)
            restartApp(context)
        }
    }

    private fun restartApp(context: Context) {
        val intent = context.packageManager.getLaunchIntentForPackage(context.packageName)
        intent?.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        context.startActivity(intent)
        android.os.Process.killProcess(android.os.Process.myPid())
    }
}