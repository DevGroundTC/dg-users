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
                sh 'docker build -t dg-user-api:latest .'
        }
        }

        stage('Deploy') {
             steps {
                      script {
                    def previousContainerId = sh(returnStdout: true, script: "docker ps -q --filter ancestor=dg-user-api").trim()
                    if (previousContainerId) {
                        sh "docker stop $previousContainerId"
                    } else {
                        echo "Предыдущий контейнер отсутствует"
                    }
                }
            sh 'docker run -d -p 1000:1000 dg-user-api:latest --name dg-user-api'
                 echo "Контейнер запущен"
        }
    }
}
}
