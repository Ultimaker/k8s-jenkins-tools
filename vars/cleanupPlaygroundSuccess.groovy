#!/usr/bin/groovy

def call(String name) {

  slackSend color: 'warning', channel: '#ci-playgrounds',
    message: "Playground \"${name}\" has been cleaned up."

}
