package io.kotlintest.provided

import io.kotest.core.config.AbstractProjectConfig
import io.kotest.core.spec.IsolationMode
import io.kotest.core.spec.SpecExecutionOrder


object ProjectConfig : AbstractProjectConfig() {

  override val globalAssertSoftly: Boolean
    get() = true

  override val specExecutionOrder = SpecExecutionOrder.FailureFirst

  override val isolationMode = IsolationMode.InstancePerLeaf

}