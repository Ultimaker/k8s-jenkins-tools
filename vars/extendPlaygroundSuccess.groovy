#!/usr/bin/groovy

def call(String name, String buildUrl, String expiresAfter) {

  Map[] attachments = [[
    color: 'warning',
    fallback: "Playground \"${name}\" extended with ${expiresAfter}.",
    text: "Playground \"${name}\" extended with *${expiresAfter}* ( <${buildUrl}|job> / <${buildUrl}console|console> )."
  ]]

  slackSend channel: '#ci-playgrounds', attachments: attachments

}
