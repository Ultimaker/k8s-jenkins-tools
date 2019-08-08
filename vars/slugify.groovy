#!/usr/bin/groovy

@Grab('com.github.slugify:slugify:2.4')

import com.github.slugify.Slugify

String call(String subject) {

  return new Slugify().slugify(subject)

}
