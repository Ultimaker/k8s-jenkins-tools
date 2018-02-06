#!/usr/bin/groovy
package com.ultimaker

import groovy.time.TimeCategory

def fromNow(TimeCategory timeCategory) {

  Date expiresAt = new Date()

  use(TimeCategory) {
    expiresAt = expiresAt + timeCategory
  }

  return expiresAt.getDateTimeString()
}
