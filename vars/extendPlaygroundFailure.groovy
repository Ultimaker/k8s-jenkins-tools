#!/usr/bin/groovy

def call(String name, String buildUrl) {

  Map[] attachments = [[
    color: 'danger',
    fallback: "Failed to extend playground \"${name}\".",
    text: "Failed to extend \"${name}\" playground ( <${buildUrl}|job> / <${buildUrl}console|console> )."
  ]]

  slackSend channel: '#ci-playgrounds', attachments: attachments

}
