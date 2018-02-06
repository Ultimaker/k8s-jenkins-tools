#!/usr/bin/groovy
package com.ultimaker

@Grab('com.github.slugify:slugify:2.2')
import com.github.slugify.Slugify

def slug(String subject) {
  Slugify slugify = new Slugify()

  return slugify.slugify(subject)
}