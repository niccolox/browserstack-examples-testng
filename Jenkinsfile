pipeline {
   agent any
   stages {
      stage('setup') {
         steps {
            browserstack(credentialsId: 'dw471drf-db68-4r23b-969d-24r3r32f') {
               echo "hello bsfs"
                 sh 'npm'
                //  sh 'node single.js'
                //  sh 'node parallel.js'
            }
         }
      }
    }
  }
