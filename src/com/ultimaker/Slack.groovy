#!/usr/bin/groovy

package com.ultimaker

def createPlaygroundSuccess(
  String name,
  String buildUrl,
  String frontendBranch,
  String integrationServiceBranch,
  String legacyBranch,
  String expiresIn,
  String clusterDomain
) {
  def attachments = [[
    color: 'good',
    fallback: "Playground \"${name}\" was created.",
    pretext: "Playground \"<https://playground-${name}.ultimaker.${clusterDomain}|${name}>\" was created ( <${buildUrl}|job> / <${buildUrl}console|console> ).",
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
}

def createPlaygroundFailure(String name, String buildUrl) {
  slackSend color: 'danger',
    channel: '#ci-playgrounds',
    message: "Creating playground \"${name}\" failed ( <${buildUrl}|job> / <${buildUrl}console|console> )."
}

def cleanupPlaygroundSuccess(String namespace) {
  slackSend color: 'warning',
    channel: '#ci-playgrounds',
    message: "Playground \"${namespace}\" has been cleaned up."
}

def cleanupPlaygroundFailure(String namespace) {
  slackSend color: 'danger',
    channel: '#ci-playgrounds',
    message: "Failed to clean up \"${namespace}\" playground."
}
