#!/usr/bin/groovy

package com.ultimaker

@Grab('org.apache.commons:commons-lang3:3.8.1')

import org.apache.commons.lang3.RandomStringUtils

String string(int length) {
  return RandomStringUtils.randomAlphanumeric(length)
}
