#!/usr/bin/groovy
package com.ultimaker

@Grab('commons-lang:commons-lang:2.6')
import org.apache.commons.lang.RandomStringUtils

def string(int length) {
  String charset = (('a'..'z') + ('A'..'Z') + ('0'..'9')).join()

  return RandomStringUtils.random(length, charset.toCharArray())
}
