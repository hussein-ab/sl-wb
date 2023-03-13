pipeline {
    agent {label 'machine-1'}
    stages {
       stage('log version info') {
         steps {
          sh './mvnw --version'
         }
       }

       stage('Maven clean package') {
            steps {
                sh './mvnw clean package'
            }
       }
       stage('build image') {
          steps {
            sh './mvnw spring-boot:build-image'
          }
       }
//
//     stage('Build image') {
//        dockerImage = docker.build("docker01120/sl-wb:latest")
//     }
       stage('run test') {
          steps {
            sh './mvnw test'
          }
       }
       stage('Push image') {
         steps {
            withDockerRegistry([ credentialsId: "dockerhub", url: "" ]) {
              sh 'docker tag  docker.io/library/sl-wb:1.0-SNAPSHOT docker01120/sl-wb:latest'
              sh 'docker push docker01120/sl-wb:latest'
//           dockerImage.push()
            }
         }

       }
       stage('run container') {
          steps {
            sh 'docker run -d --name slwb_app -p 8000:8000 docker01120/sl-wb:latest'
          }
       }

    }
}