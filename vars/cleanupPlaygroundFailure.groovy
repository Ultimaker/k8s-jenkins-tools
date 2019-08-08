#!/usr/bin/groovy

def call(String name) {

  slackSend color: 'danger', channel: '#ci-playgrounds',
    message: "Failed to clean up \"${name}\" playground."

}
