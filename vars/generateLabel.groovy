#!/usr/bin/env groovy

GString call(String prefix) {

  return "$prefix-${UUID.randomUUID().toString()}"

}
