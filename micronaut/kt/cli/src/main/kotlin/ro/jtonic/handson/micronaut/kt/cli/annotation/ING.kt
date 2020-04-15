package ro.jtonic.handson.micronaut.kt.cli.annotation

import javax.inject.Qualifier
import kotlin.annotation.AnnotationRetention.RUNTIME

@Retention(RUNTIME)
@Qualifier
annotation class ING
