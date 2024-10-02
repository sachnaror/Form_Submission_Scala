package com.Form_Submission_Scala

import org.scalatest.flatspec.AnyFlatSpec
import com.Form_Submission_Scala.controllers.AppController

class AppControllerSpec extends AnyFlatSpec {

  "AppController" should "return a greeting message" in {
    val controller = new AppController()
    assert(controller.greet("Scala") == "Hello, Scala")
  }
}
