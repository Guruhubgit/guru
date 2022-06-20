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
    echo "$repo_branch"
    
    repo = sh (returnStdout: true, script:"""
        #!/bin/bash
        echo "$repo_branch"
        """)
   echo "$repo"  
    
     last_updated_date = sh (returnStdout: true, script:"""
        for branch in $repo; 
        do 
        curl -s https://api.github.com/repos/Guruhubgit/guru/branches/$repo | jq '.commit.commit.author.date'
        """)
}
