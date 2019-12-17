# shared-library

Jenkins, go to Manage Jenkins > Configure System > Under Global Pipeline Libraries, add a library with the following settings:
Library name: shared-library 
retrival method: modern SCM 
select the git type: https://github.com/abprakash405/shared-library.git 

Create a Jenkins pipeline job and use this repository: 
https://github.com/abprakash405/jenkinsfile-repo.git

run the job. 

Expected output: 
[Pipeline] Start of Pipeline
[Pipeline] echo
Cloud DevOps training course from AspireNew Technologies
[Pipeline] echo
AspireNew Technologies
[Pipeline] End of Pipeline
Finished: SUCCESS

