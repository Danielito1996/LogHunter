package com.elitec.logcapture.model

/**
 * Enum que representa los diferentes tipos de errores que pueden ocurrir en la aplicación.
 * Cada valor del enum corresponde a un tipo específico de error, con una descripción clara de su origen.
 */
enum class ErrorCode {
    /**
     * Error general no especificado.
     * Este código se utiliza para errores que no encajan en ninguna categoría específica.
     */
    Gen,

    /**
     * Error en la capa de datos del cliente.
     * Este código se utiliza para errores relacionados con la manipulación o recuperación de datos en el cliente.
     */
    CDatCl,

    /**
     * Error en la capa de datos del código.
     * Este código se utiliza para errores relacionados con la lógica de manejo de datos en el código.
     */
    CDatCo,

    /**
     * Error en la capa de dominio del código.
     * Este código se utiliza para errores relacionados con la lógica de negocio o reglas de dominio.
     */
    CDomCo,

    /**
     * Error de serialización.
     * Este código se utiliza para errores relacionados con la conversión de datos a un formato serializado (por ejemplo, JSON).
     */
    Ser,

    /**
     * Error de compatibilidad del SDK.
     * Este código se utiliza para errores relacionados con la incompatibilidad de versiones del SDK.
     */
    SDK,

    /**
     * Error de incompatibilidad con la versión del sistema operativo.
     * Este código se utiliza para errores relacionados con versiones no soportadas del sistema operativo.
     */
    SO,

    /**
     * Error en librerías de terceros.
     * Este código se utiliza para errores relacionados con el uso de librerías externas.
     */
    Libr,

    /**
     * Error en la base de datos.
     * Este código se utiliza para errores relacionados con operaciones de base de datos (por ejemplo, consultas, inserciones, etc.).
     */
    DB,

    /**
     * Error en la configuración de las instancias en el inyector de dependencias.
     * Este código se utiliza para errores relacionados con la inyección de dependencias (por ejemplo, Hilt o Dagger).
     */
    CAplInj,

    /**
     * Error en la configuración de instancias generales.
     * Este código se utiliza para errores relacionados con la configuración de instancias en la aplicación.
     */
    CAplConf,

    /**
     * Error en un ViewModel.
     * Este código se utiliza para errores relacionados con la lógica o el estado de un ViewModel.
     */
    CPreVM,

    /**
     * Error en un Composable.
     * Este código se utiliza para errores relacionados con la lógica o la renderización de un componente Composable en Jetpack Compose.
     */
    CPreComp
}