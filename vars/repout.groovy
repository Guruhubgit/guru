def call(def giturl, def branch, def cred, def repository){
    echo "Cloning started"
     checkout(
                [$class: 'GitSCM', branches: [[name: "*/$branch"]],
                 userRemoteConfigs: [[credentialsId: "$cred", url: "$giturl"]]],
     )
    echo "looking for branches"
    
    repo_branch = sh (returnStdout: true, script:"""
        curl -s https://api.github.com/repos/Guruhubgit/$repository/branches | jq '.[].name'
        """)
    echo "$repo_branch"
    
    repo = sh (returnStdout: true, script:"""
        #!/bin/bash
        echo "$repo_branch"
        """)
   echo "$repo"  
        String[] array= "$repo_branch".split('"');
                    for(counter in array)
                    {
                        if(counter == "$branch") {
                   test = sh (returnStdout: true, script:"""
                   curl -s https://api.github.com/repos/Guruhubgit/$repository/branches/$counter | jq '.commit.commit.author.date'
                   curl -s https://api.github.com/repos/Guruhubgit/$repository/branches/$counter | jq '.commit.commit.author.name'
                   """)
             }
           else{
                 echo "go next"
         }
                    }   
      echo "$test"
}
