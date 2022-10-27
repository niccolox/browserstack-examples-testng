 pipeline {
    agent any
    tools {
        maven 'Maven 3.3.9'
        jdk 'jdk8'
    }
    stages {
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }
        }
       stage('setup') {
         steps {
             browserstack(credentialsId: 'b8bf820d-6ee0-40ab-92e8-3e15c3db7965') {
                 sh 'mvn compile && mvn test -P on-prem-parallel-onboarding'
                 sh 'mvn compile && mvn test -P on-prem-single-onboarding'
             }
             browserStackReportPublisher 'automate'
         }
       }
     }
   }
