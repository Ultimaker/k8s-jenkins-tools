#!/usr/bin/groovy

def call(
  String name,
  String buildUrl,
  String frontendBranch,
  String integrationServiceBranch,
  String legacyBranch,
  String expiresIn,
  String clusterDomain
) {

  Map[] attachments = [[
    color: 'good',
    fallback: "Playground \"${name}\" was created.",
    text: "Playground \"<https://playground-${name}.ultimaker.${clusterDomain}|${name}>\" was created ( <${buildUrl}|job> / <${buildUrl}console|console> ).",
    fields: [
      [
        title: 'Endpoints',
        value: """
          - https://playground-${name}.ultimaker.${clusterDomain}
          - https://playground-${name}.cms.${clusterDomain}/admin
          - https://playground-${name}.integration-service.${clusterDomain}
          """.stripIndent(),
        short: false
      ],
      [ title: 'Frontend branch', value: "<https://github.com/Ultimaker/Ultimaker.com-frontend/tree/${frontendBranch}|${frontendBranch}>", short: true ],
      [ title: 'Legacy branch', value: "<https://github.com/Ultimaker/Ultimaker.com/tree/${legacyBranch}|${legacyBranch}>", short: true ],
      [ title: 'Integration-Service branch', value: "<https://github.com/Ultimaker/Ultimaker.com-integration-service/tree/${integrationServiceBranch}|${integrationServiceBranch}>", short: true ],
      [ title: 'Expires in', value: expiresIn, short: true ],
    ]
  ]]

  slackSend channel: '#ci-playgrounds', attachments: attachments

  office365ConnectorSend color: '#0be725',
    message: "Playground \"[${name}](https://playground-${name}.ultimaker.${clusterDomain})\" was created ( [job](${buildUrl}) / [console](${buildUrl}console) ).\n" +
    '## Endpoints\n' +
    "- [https://playground-${name}.ultimaker.${clusterDomain}](https://playground-${name}.ultimaker.${clusterDomain})\n" +
    "- [https://playground-${name}.cms.${clusterDomain}/admin](https://playground-${name}.cms.${clusterDomain}/admin)\n" +
    "- [https://playground-${name}.integration-service.${clusterDomain}](https://playground-${name}.integration-service.${clusterDomain})\n\n" +
    '## Frontend branch\n' +
    "[${frontendBranch}](https://github.com/Ultimaker/Ultimaker.com-frontend/tree/${frontendBranch})\n" +
    '## Legacy branch\n' +
    "[${legacyBranch}](https://github.com/Ultimaker/Ultimaker.com/tree/${legacyBranch})\n" +
    '## Integration-Service branch\n' +
    "[${integrationServiceBranch}](https://github.com/Ultimaker/Ultimaker.com-integration-service/tree/${integrationServiceBranch})\n" +
    '## Expires in\n' +
    expiresIn,
    status: 'Success',
    // ci-playgrounds-connector
    webhookUrl: 'https://outlook.office.com/webhook/4829f4a1-35aa-4dca-9ad7-89ac07833f0a@aecc8a99-f9b2-4dad-9cf1-038b83a3ff5f/JenkinsCI/4aee1620d03b467eb08e51f1be42e441/cdfdcb89-4370-47bb-95e6-921ab334adb2'

}
