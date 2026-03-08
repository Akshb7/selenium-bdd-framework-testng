pipeline {
    agent any  // run on any available Jenkins agent

    tools {
        maven 'Maven3'      // must match your Maven installation name in Jenkins
        jdk 'JDK17'         // must match your JDK installation name in Jenkins
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Checking out code from GitHub...'
                git url: 'https://github.com/Akshb7/selenium-bdd-framework-testng.git', branch: 'main'
            }
        }

        stage('Build') {
            steps {
                echo 'Building the project with Maven...'
                sh 'mvn clean compile'
            }
        }

        stage('Run Tests') {
            steps {
                echo 'Running TestNG suite...'
                // Make sure your testng.xml is in the root folder
                sh 'mvn test -DsuiteXmlFile=testng.xml'
            }
        }
    }

    post {
        always {
            echo 'Publishing TestNG results...'
            junit '**/target/surefire-reports/*.xml'
        }
    }
}