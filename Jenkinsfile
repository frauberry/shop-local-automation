pipeline {
    agent any

    tools {
        maven 'Maven'
        jdk 'JDK22'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test -P jenkins'
            }
        }
    }

    post {
        always {
            publishHTML(target: [
                allowMissing         : true,
                alwaysLinkToLastBuild: true,
                keepAll              : true,
                reportDir            : 'target/cucumber-reports',
                reportFiles          : 'cucumber.html',
                reportName           : 'Cucumber Report'
            ])
        }
    }
}
