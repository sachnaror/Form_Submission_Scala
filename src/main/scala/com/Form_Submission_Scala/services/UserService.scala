package com.Form_Submission_Scala.services

import com.Form_Submission_Scala.models.User

class UserService {
  def getUser(id: Int): User = User(id, "User" + id, "user" + id + "@example.com")
}
