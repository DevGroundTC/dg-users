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
                    } else {
                        echo "Предыдущий контейнер отсутствует"
                    }
                }
            sh 'docker run -d -p 1000:2000 dg-users:latest --name dg-users'
                 echo "Контейнер запущен"
        }
    }
}
}
