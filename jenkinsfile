pipeline {
    agent { docker { image 'maven:3.3.3' } }
    stages {
       stage('log version info') {
         steps {
          sh 'mvn --version'
         }
       }
       stage('run test') {
          steps {
            sh 'mvn test'
          }
       }
       stage('build image') {
          steps {
            sh 'mvn spring-boot:build-image'
          }
       }

    }
}