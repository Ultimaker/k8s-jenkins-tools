#!/usr/bin/groovy

def call(String name, String buildUrl) {

  Map[] attachments = [[
    color: 'danger',
    fallback: "Failed to delete playground \"${name}\".",
    text: "Failed to delete playground \"${name}\" ( <${buildUrl}|job> / <${buildUrl}console|console> ).",
  ]]

  slackSend channel: '#ci-playgrounds', attachments: attachments

}
