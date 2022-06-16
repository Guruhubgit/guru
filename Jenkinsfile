properties([parameters([[$class: 'CascadeChoiceParameter', choiceType: 'PT_SINGLE_SELECT', description: 'Select the resource you want to modify', filterLength: 1, filterable: false, name: 'Resources', randomName: 'choice-parameter-843794284471400', referencedParameters: '',
script: [$class: 'GroovyScript', fallbackScript: [classpath: [], sandbox: false, script: ''],
script: [classpath: [], sandbox: false,
script: 'return ["Compute", "LIVE:selected"]']]],
[$class: 'CascadeChoiceParameter', 
 choiceType: 'PT_SINGLE_SELECT',
 description: '', 
 filterLength: 1, filterable: false,
 name: 'choice1', 
 randomName: 'choice-parameter-843794300545400',
 referencedParameters: 'Resources',
 script: [$class: 'GroovyScript',
 fallbackScript: [classpath: [], sandbox: false, script: ''],
 script: [classpath: [], sandbox: false, 
 script: '''
 if (Resources.equals("Compute")){
                                return["aaaa","bbbb"]
                                  }
 else if(Resources.equals("LIVE")){
                                return["cccc","dddd"]
                            }''']]]])])
