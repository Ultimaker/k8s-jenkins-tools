#!/usr/bin/groovy

def call(
  String name,
  String buildUrl,
  String deploymentUrl,
  String component,
  String repo,
  String branch,
  String commit
) {

  Map[] attachments = [[
    color: 'good',
    fallback: "Deployment \"${name}\" was updated.",
    text: "Deployment \"<${deploymentUrl}|${name}>\" was updated ( <${buildUrl}|job> / <${buildUrl}console|console> ).",
    fields: [
      [ title: 'Component', value: "<https://github.com/Ultimaker/${repo}|${component}>" ],
      [ title: 'Branch', value: "<https://github.com/Ultimaker/${repo}/tree/${branch}|${branch}>" ],
      [ title: 'Commit', value: "<https://github.com/Ultimaker/${repo}/commit/${commit}|${commit}>" ],
    ]
  ]]

  slackSend channel: '#ci-deployments', attachments: attachments

}
