pipeline{
    agent any
    stages{
        stage('Build'){
            steps{
               // bat 'rd /s /q social-multiplication'
                bat 'git clone https://github.com/ashishbhatnagar05/social-multiplication.git'
                bat 'mvn clean -f social-multiplication'

            }
        }
        stage('Test'){
            steps{
                 bat 'mvn test -f social-multiplication'
            }
        }
        stage('Deploy'){
            steps{
                bat 'mvn package -f social-multiplication'
            }
        }
    }
}
