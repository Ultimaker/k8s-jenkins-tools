#!/usr/bin/groovy

def call(
  String name,
  String buildUrl,
  String component,
  String repo,
  String branch,
  String commit
) {

  office365ConnectorSend color: '#0be725',
    message: "Playground \"[${name}](https://playground-${name}.ultimaker.k8s-dev.ultimaker.works)\" was updated ( [job](${buildUrl}) / [console](${buildUrl}console) ).\n" +
    '## Component\n' +
    "[${component}](https://github.com/Ultimaker/${repo}/)\n" +
    '## Branch\n' +
    "[${branch}](https://github.com/Ultimaker/${repo}/tree/${branch})\n" +
    '## Commit\n' +
    "[${commit}](https://github.com/Ultimaker/${repo}/commit/${commit})\n",
    status: 'Success',
    // ci-playgrounds-connector
    webhookUrl: 'https://outlook.office.com/webhook/4829f4a1-35aa-4dca-9ad7-89ac07833f0a@aecc8a99-f9b2-4dad-9cf1-038b83a3ff5f/JenkinsCI/4aee1620d03b467eb08e51f1be42e441/cdfdcb89-4370-47bb-95e6-921ab334adb2'

}
