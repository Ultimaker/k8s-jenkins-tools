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

  office365ConnectorSend color: '#0be725',
    message: "Deployment \"[${name}](${deploymentUrl})\" was updated ( [job](${buildUrl}) / [console](${buildUrl}console) ).\n" +
    '## Component\n' +
    "[${component}](https://github.com/Ultimaker/${repo}/)\n" +
    '## Branch\n' +
    "[${branch}](https://github.com/Ultimaker/${repo}/tree/${branch})\n" +
    '## Commit\n' +
    "[${commit}](https://github.com/Ultimaker/${repo}/commit/${commit})\n",
    status: 'Success',
    // ci-deployments-connector
    webhookUrl: 'https://outlook.office.com/webhook/4829f4a1-35aa-4dca-9ad7-89ac07833f0a@aecc8a99-f9b2-4dad-9cf1-038b83a3ff5f/JenkinsCI/2bf17d3039414d0eacbb2dcb387c4991/cdfdcb89-4370-47bb-95e6-921ab334adb2'

}
