#!/usr/bin/groovy

package com.ultimaker

/*
 * CREATE PLAYGROUND
 */

def createPlaygroundSuccess(
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
}

def createPlaygroundFailure(String name, String buildUrl) {
  Map[] attachments = [[
    color: 'danger',
    fallback: "Creating playground \"${name}\" failed.",
    text: "Creating playground \"${name}\" failed ( <${buildUrl}|job> / <${buildUrl}console|console> ).",
  ]]

  slackSend channel: '#ci-playgrounds', attachments: attachments
}

/*
 * CLEANUP PLAYGROUND
 */

def cleanupPlaygroundSuccess(String name) {
  slackSend color: 'warning', channel: '#ci-playgrounds',
    message: "Playground \"${name}\" has been cleaned up."
}

def cleanupPlaygroundFailure(String name) {
  slackSend color: 'danger', channel: '#ci-playgrounds',
    message: "Failed to clean up \"${name}\" playground."
}

/*
 * DELETE PLAYGROUND
 */

def deletePlaygroundSuccess(String name, String buildUrl) {
  Map[] attachments = [[
    color: 'warning',
    fallback: "Playground \"${name}\" was deleted.",
    text: "Playground \"${name}\" was deleted ( <${buildUrl}|job> / <${buildUrl}console|console> ).",
  ]]

  slackSend channel: '#ci-playgrounds', attachments: attachments
}

def deletePlaygroundFailure(String name, String buildUrl) {
  Map[] attachments = [[
    color: 'danger',
    fallback: "Failed to delete playground \"${name}\".",
    text: "Failed to delete playground \"${name}\" ( <${buildUrl}|job> / <${buildUrl}console|console> ).",
  ]]

  slackSend channel: '#ci-playgrounds', attachments: attachments
}

/*
 * EXTEND PLAYGROUND
 */

def extendPlaygroundSuccess(String name, String buildUrl, String expiresAfter) {
  Map[] attachments = [[
    color: 'warning',
    fallback: "Playground \"${name}\" extended with ${expiresAfter}.",
    text: "Playground \"${name}\" extended with *${expiresAfter}* ( <${buildUrl}|job> / <${buildUrl}console|console> )."
  ]]

  slackSend channel: '#ci-playgrounds', attachments: attachments
}

def extendPlaygroundFailure(String name, String buildUrl) {
  Map[] attachments = [[
    color: 'danger',
    fallback: "Failed to extend playground \"${name}\".",
    text: "Failed to extend \"${name}\" playground ( <${buildUrl}|job> / <${buildUrl}console|console> )."
  ]]

  slackSend channel: '#ci-playgrounds', attachments: attachments
}
