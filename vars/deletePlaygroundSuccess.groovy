#!/usr/bin/groovy

def call(String name, String buildUrl) {

  Map[] attachments = [[
    color: 'warning',
    fallback: "Playground \"${name}\" was deleted.",
    text: "Playground \"${name}\" was deleted ( <${buildUrl}|job> / <${buildUrl}console|console> ).",
  ]]

  slackSend channel: '#ci-playgrounds', attachments: attachments

}
