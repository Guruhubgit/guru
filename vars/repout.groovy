def call(def giturl, def branch){
    echo "Cloning started"
     checkout(
                [$class: 'GitSCMCheckout', branches: [[name: '*/branch']],
                 userRemoteConfigs: [[credentialsId: 'mine', url: 'giturl']]],
     )
}
