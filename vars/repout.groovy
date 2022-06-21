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
    
    class Example { 
   static void main(String[] args) { 
      String sample = "Hello world"; 
      println(sample[4]); // Print the 5 character in the string
		
      //Print the 1st character in the string starting from the back 
      println(sample[-1]); 
      println(sample[1..2]);//Prints a string starting from Index 1 to 2 
      println(sample[4..2]);//Prints a string starting from Index 4 back to 2 
      
   } 
}
    
    String[] array= "$repo".split('/n');
                    for(counter in array)
                    {
                        echo "$counter"
                    }   
}
