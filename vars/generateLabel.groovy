#!/usr/bin/env groovy

GString call(String prefix) {

  // max length is 64 characters, UUID is 36, leaves us with 28
  if (prefix.length() > 28) {
    prefix = prefix.take(28)
  }

  return "$prefix-${UUID.randomUUID().toString()}"

}
