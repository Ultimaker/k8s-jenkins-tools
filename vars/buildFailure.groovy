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

}
