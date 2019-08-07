#!/usr/bin/groovy

package com.ultimaker

@Grab('org.apache.commons:commons-lang3:3.9')

import org.apache.commons.lang3.RandomStringUtils

String string(int length) {
  return RandomStringUtils.randomAlphanumeric(length)
}
