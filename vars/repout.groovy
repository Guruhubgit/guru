def call(def giturl, def branch, def cred){
    echo "Cloning started"
     checkout(
                [$class: 'GitSCM', branches: [[name: "*/$branch"]],
                 userRemoteConfigs: [[credentialsId: "$cred", url: "$giturl"]]],
     )
    echo "looking for branches"
    
    repo_branch = sh (returnStdout: true, script:"""
        curl -s https://api.github.com/repos/Guruhubgit/liauibasedemo/branches | jq '.[].name'
        """)
    echo "$repo_branch"
    
    repo = sh (returnStdout: true, script:"""
        #!/bin/bash
        echo "$repo_branch"
        """)
   echo "$repo"  
def gitNameArray = ["$repo"]
for (repo in gitNameArray) {
    if(repo == "main") {
        repo_branch = sh (returnStdout: true, script:"""
        curl -s -u $user_name:$password https://api.github.com/repos/Guruhubgit/liauibasedemo/branches/$repo | jq '.commit.commit.author.date'
        """)
    }
    else{
     repo_branch2 = sh (returnStdout: true, script:"""
        curl -s 'https://api.github.com/repos/Guruhubgit/liauibasedemo/branches/$repo | jq '.commit.commit.author.date''
        """)
    }
}
}
