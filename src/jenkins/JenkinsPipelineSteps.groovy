import jenkins.Constants
import groovy.json.JsonSlurper

// Constructor, called from PipelineBuilder.initialize().
void initialize() {
    echo 'Initializing PipelineSteps.'
}

void cleanWorkspace() {
    sh "echo 'Cleaning workspace'"
    deleteDir()
}

void checkout(String project, String branch) {
    checkout changelog: true, poll: true, scm: [
            $class           : 'GitSCM',
            branches         : [[name: '*/' + branch]],
            browser          : [$class: 'GitLab', repoUrl: Constants.GITLAB_WEB_BASE_URL + project , version: Constants.GITLAB_VERSION ],
            userRemoteConfigs: [[credentialsId: Constants.GITLAB_CREDENTIALS_ID, url: Constants.GITLAB_CHECKOUT_BASE_URL + project + '.git' ]]
    ]
}

return this;
