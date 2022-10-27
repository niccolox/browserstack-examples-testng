 pipeline {
   agent any
   stages {
       stage('setup') {
         steps {
             browserstack(credentialsId: 'b8bf820d-6ee0-40ab-92e8-3e15c3db7965') {
                 sh 'su root'
                 sh 'apt install maven -yq'
                 sh 'mvn compile && mvn test -P on-prem-parallel-onboarding'
                 sh 'mvn compile && mvn test -P on-prem-single-onboarding'
             }
             browserStackReportPublisher 'automate'
         }
       }
     }
   }
