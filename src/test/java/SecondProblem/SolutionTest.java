package SecondProblem;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class SolutionTest {


    public List<VulnerabilityScript> createGraph(){
        List<VulnerabilityScript> graph = new ArrayList<>();


        graph.add(new VulnerabilityScript(7, null));
        graph.add(new VulnerabilityScript(8, new ArrayList<>()));
        graph.add(new VulnerabilityScript(9, new ArrayList<>()));
        graph.add(new VulnerabilityScript(10, new ArrayList<>()));
        graph.add(new VulnerabilityScript(11, new ArrayList<>()));
        graph.add(new VulnerabilityScript(12, new ArrayList<>()));

        Integer array1[] = {3,4,5};
        graph.add(new VulnerabilityScript(1, Arrays.asList(array1)));

        Integer array4[] = {9};
        graph.add(new VulnerabilityScript(4, Arrays.asList(array4)));

        Integer array5[] = {9,10};
        graph.add(new VulnerabilityScript(5, Arrays.asList(array5)));

        Integer array6[] = {10,11,12};
        graph.add(new VulnerabilityScript(6, Arrays.asList(array6)));

        Integer array2[] = {5,6};
        graph.add(new VulnerabilityScript(2, Arrays.asList(array2)));

        Integer array3[] = {7,8};
        graph.add(new VulnerabilityScript(3, Arrays.asList(array3)));


        return graph;

    }

    public VulnerabilityScript createVulnerabilityScript(int scriptId, List<Integer> dependencies){
        return new VulnerabilityScript(scriptId, dependencies);
    }

    @Test
    public void getExecutionSequenceTest() {
        Solution solution = new Solution();
        List<Integer> executed = new ArrayList<>();
        List<VulnerabilityScript> vulnerabilityScripts = solution.getExecutionSequence(createGraph());
        for (VulnerabilityScript vulnerabilityScript:vulnerabilityScripts){
            executed.add(vulnerabilityScript.getScriptId());
            Optional<List<Integer>> dependencies = Optional.ofNullable(vulnerabilityScript.getDependencies());
            if (dependencies.isPresent()){
                Assert.assertTrue(executed.containsAll(dependencies.get()));
            }
        }
    }


}