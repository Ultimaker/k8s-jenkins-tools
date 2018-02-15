#!/usr/bin/groovy
package com.ultimaker

def string(int length) {
  String charset = (('a'..'z') + ('A'..'Z') + ('0'..'9')).join()

  return RandomStringUtils.random(length, charset.toCharArray())
}
