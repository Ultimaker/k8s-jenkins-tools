#!/usr/bin/groovy

def call(
  String buildUrl,
  String component,
  String repo,
  String branch,
  String stage
) {

  Map[] attachments = [[
    color: 'danger',
    fallback: "Failed building \"${component}\".",
    text: "Failed building \"${component}\" ( <${buildUrl}|job> / <${buildUrl}console|console> ).",
    fields: [
      [ title: 'Component', value: "<https://github.com/Ultimaker/${repo}|${component}>" ],
      [ title: 'Branch', value: "<https://github.com/Ultimaker/${repo}/tree/${branch}|${branch}>" ],
      [ title: 'Stage', value: stage ],
    ]
  ]]

  slackSend channel: '#ci-builds', attachments: attachments

  office365ConnectorSend color: '#d93232',
    message: "Failed building \"${component}\" ( [job](${buildUrl}) / [console](${buildUrl}console) ).",
    '## Component\n' +
    "[${component}](https://github.com/Ultimaker/${repo}/)\n" +
    '## Branch\n' +
    "[${branch}](https://github.com/Ultimaker/${repo}/tree/${branch})\n" +
    '## Stage\n' +
    stage,
    status: 'Failure',
    // ci-builds-connector
    webhookUrl: 'https://outlook.office.com/webhook/4829f4a1-35aa-4dca-9ad7-89ac07833f0a@aecc8a99-f9b2-4dad-9cf1-038b83a3ff5f/JenkinsCI/f708a35d1e664c1fb5834c370e974533/cdfdcb89-4370-47bb-95e6-921ab334adb2'

}
