 pipeline {
   agent any
   stages {
       stage ('Build') {
         steps {
          git url: 'https://github.com/niccolox/browserstack-examples-testng'
          withMaven {
            sh "mvn clean verify"
          } // withMaven will discover the generated Maven artifacts, JUnit Surefire & FailSafe reports and FindBugs reports
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
