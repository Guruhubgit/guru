def call(def giturl, def branch, def cred){
    echo "Cloning started"
     checkout(
                [$class: 'GitSCM', branches: [[name: "*/$branch"]],
                 userRemoteConfigs: [[credentialsId: "$cred", url: "$giturl"]]],
     )
    echo "looking for branches"
    
    repo_branch = sh (returnStdout: true, script:"""
        curl -s https://api.github.com/repos/Guruhubgit/guru/branches | jq '.[].name'
        """)
    
    repo = sh (returnStdout: true, script:"""
        for (branch in $repo_branch){
        $repo_branch | cut -d'"' -f 2
        }
        """)
    
    
    echo "$repo_branch"
    echo "$branch"
}
