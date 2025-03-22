package com.elitec.logcapture.util

fun messageExceptionFormater(e:Exception): String {
    // Extraer información manualmente de la excepción
    val exceptionType = e::class.simpleName
    val exceptionMessage = e.message ?: "Sin mensaje"
    val stackTrace = e.stackTrace[0] // Primera línea de la traza de la pila
    val fileName = stackTrace.fileName
    val lineNumber = stackTrace.lineNumber
    val className = stackTrace.className
    val methodName = stackTrace.methodName

    // Formatear el mensaje de error
    return """
            Tipo de excepción: $exceptionType
            Mensaje: $exceptionMessage
            Archivo: $fileName
            Línea: $lineNumber
            Clase: $className
            Método: $methodName
            Traza completa: ${e.stackTraceToString()}
        """.trimIndent()
}

fun messageExceptionFormater(throwable: Throwable): String {
    // Extraer información manualmente de la excepción
    val exceptionType = throwable::class.simpleName
    val exceptionMessage = throwable.message ?: "Sin mensaje"
    val stackTrace = throwable.stackTrace[0] // Primera línea de la traza de la pila
    val fileName = stackTrace.fileName
    val lineNumber = stackTrace.lineNumber
    val className = stackTrace.className
    val methodName = stackTrace.methodName

    // Formatear el mensaje de error
    return """
            Tipo de excepción: $exceptionType
            Mensaje: $exceptionMessage
            Archivo: $fileName
            Línea: $lineNumber
            Clase: $className
            Método: $methodName
            Traza completa: ${throwable.stackTraceToString()}
        """.trimIndent()
}