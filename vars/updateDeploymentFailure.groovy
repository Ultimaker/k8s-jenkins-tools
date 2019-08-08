#!/usr/bin/groovy

def call(
  String name,
  String buildUrl,
  String component
) {

  Map[] attachments = [[
    color: 'danger',
    fallback: "Failure while deploying \"${component}\" to ${name}.",
    text: "Failure while deploying \"${component}\" to ${name} ( <${buildUrl}|job> / <${buildUrl}console|console> )."
  ]]

  slackSend channel: '#ci-deployments', attachments: attachments

}
