pipeline {
    agent any

    stages {
        stage('clone code') {
            steps {
                git branch: 'main', credentialsId: 'MyGitHub', url: 'https://github.com/NikhilChaurasiya/Application2.git'
            }
        }
        stage('build code') {
            steps {
                sh "mvn clean install"
            }
        }
	stage('Test') {
            steps {
                echo "testing application"
            }
        }
	stage('Deploy') {
            steps {
                echo "Deploying Application"
            }
        }
    }
}
