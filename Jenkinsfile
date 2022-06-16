properties([
  parameters([
    [$class: 'choiceparameter', 
      choiceType: 'Check Boxes', 
      description: 'Select Environment',
      filterLength: 1,
      filterable: false,
      name: 'Environment', 
      script: [
        $class: 'GroovyScript', 
        script: [
          classpath: [], 
          sandbox: false, 
          script: 
            'return[\'Development\',\'QA\',\'Staging\',\'Production\']'
        ]
      ]
    ]
  ])
])

pipeline {
  environment {
         vari = ""
  }
  agent any
  stages {
      stage ("Example") {
        steps {
         script{
          echo 'Hello'
          echo "${params.Env}"
          echo "${params.Server}"
          if (params.Server.equals("Could not get Environment from Env Param")) {
              echo "Must be the first build after Pipeline deployment.  Aborting the build"
              currentBuild.result = 'ABORTED'
              return
          }
          echo "Crossed param validation"
        } }
      }
  }
}
