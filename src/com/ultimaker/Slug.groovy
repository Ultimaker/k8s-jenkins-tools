#!/usr/bin/groovy

package com.ultimaker

@Grab('com.github.slugify:slugify:2.4')

import com.github.slugify.Slugify

String slug(String subject) {
  return new Slugify().slugify(subject)
}
