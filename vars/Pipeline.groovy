#!/usr/bin/env groovy

def call(body) {
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()
    new Sample(script:this).code()
    new Sample(script:this).build()
    new Sample(script:this).deploy()
    echo config.reponame
    
    
   pipeline {
    agent any
        
    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "maven-3"
    }
       
    environment {
      REPONAME = "${config.reponame}"
      DEPLOYNAME= "${config.DeploymentName}"
    }
       
    stages {
        stage('Code') {
            steps {
               cleanWs()
                checkout scm
                // Get some code from a GitHub repository
                //git 'https://github.com/abprakash405/maven-war.git'
                //bat "git clone https://github.com/abprakash405/${REPONAME}.git"
            }
           
        }
    stage('Build') {
            steps {
                
                    // Run Maven on a Unix agent.
                    bat "mvn -Dmaven.test.failure.ignore=true clean package"
                

            }
           
        }
    stage('Deploy') {
            steps {
                
                    //delete old package if required
                    //bat 'curl "http://admin:admin@localhost:8082/manager/text/undeploy?path=/asn-war-example-1.0.0-SNAPSHOT"'
                
                    //delete new package
                    bat "curl --upload-file target/${DEPLOYNAME}.war http://admin:admin@localhost:8082/manager/text/deploy?path=/${DEPLOYNAME}"
                
            }
           
        }
    }
  }
    
}
