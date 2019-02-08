#!/usr/bin/groovy

package com.ultimaker

@Grab('commons-lang:commons-lang:3.8.1')

import org.apache.commons.lang3.RandomStringUtils

String string(int length) {
  return RandomStringUtils.randomAlphanumeric(length)
}
