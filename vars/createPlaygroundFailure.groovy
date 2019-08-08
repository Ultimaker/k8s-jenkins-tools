#!/usr/bin/groovy

def call(String name, String buildUrl) {

  Map[] attachments = [[
    color: 'danger',
    fallback: "Creating playground \"${name}\" failed.",
    text: "Creating playground \"${name}\" failed ( <${buildUrl}|job> / <${buildUrl}console|console> ).",
  ]]

  slackSend channel: '#ci-playgrounds', attachments: attachments

}
