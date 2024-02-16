pipeline {
    agent any

    stages {

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn package -Dmaven.test.skip'
            }
        }

        stage('Docker build') {
            steps {
                sh 'docker build -t dg-users:latest .'
        }
        }

        stage('Deploy') {
             steps {
                      script {
                    def previousContainerId = sh(returnStdout: true, script: "docker ps -q --filter ancestor=dg-users").trim()
                    if (previousContainerId) {
                        sh "docker stop $previousContainerId"
                        sh 'docker container rm dg-users'
                    } else {
                        echo "Предыдущий контейнер отсутствует"
                    }
                }
            sh 'docker run --network dg-user-network -d -p 8889:8889 --name dg-users dg-users:latest'
                 echo "Контейнер запущен"
        }
    }
}
}
