package io.kotlintest.provided

import io.kotlintest.AbstractProjectConfig
import io.kotlintest.FailureFirstSpecExecutionOrder
import io.kotlintest.IsolationMode

object ProjectConfig : AbstractProjectConfig() {

  override val globalAssertSoftly: Boolean
    get() = true

  override fun specExecutionOrder() = FailureFirstSpecExecutionOrder

  override fun isolationMode() = IsolationMode.InstancePerLeaf

}