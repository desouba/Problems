package SecondProblem;

import java.util.*;
import java.util.stream.Collectors;


public class Solution{

    List<VulnerabilityScript> getExecutionSequence(List<VulnerabilityScript> vulnerabilityScripts){
            Map<Integer, List<Integer>> scriptsUnexecuted = new HashMap<>();
            Set<Integer> scriptsExecuted = new HashSet<>();
            List<VulnerabilityScript> result = new ArrayList<>();


            //get all vulnerability scripts without dependencies and add them to the executed scripts
            for (VulnerabilityScript vulnerabilityScript : vulnerabilityScripts) {
                Optional<List<Integer>> deps = Optional.ofNullable(vulnerabilityScript.getDependencies());
                if (!deps.isPresent()){
                    scriptsExecuted.add(vulnerabilityScript.getScriptId());
                    result.add(vulnerabilityScript);
                }else{
                    scriptsUnexecuted.put(vulnerabilityScript.getScriptId(), vulnerabilityScript.getDependencies());
                }
            }

            while (scriptsExecuted.size()!=vulnerabilityScripts.size()){
                for (Iterator<Map.Entry<Integer, List<Integer>>> iterator = scriptsUnexecuted.entrySet().iterator(); iterator.hasNext();){
                    Map.Entry entry = iterator.next();
                    List<Integer> dependenciesOfCurrentScript = (List<Integer>) entry.getValue();
                    if (scriptsExecuted.containsAll(dependenciesOfCurrentScript)) {
                        scriptsExecuted.add((Integer) entry.getKey());
                        result.add(new VulnerabilityScript((int)entry.getKey(), (List<Integer>)entry.getValue()));
                        iterator.remove();
                    };
                };
            }

            result.forEach(s -> System.out.print(s.getScriptId() + ", "));
            return result;


    }



}
