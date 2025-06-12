/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    HashMap<Integer , List<Integer> > map;
    HashMap<Integer , Integer> mapValues;
    public int getImportance(List<Employee> employees, int id) {
        map = new HashMap<>();
        mapValues = new HashMap<>();
        for(Employee employee : employees) {
            int eId = employee.id , importance = employee.importance;
            List<Integer> children = employee.subordinates;
            mapValues.put(eId , importance);
            map.put(eId , new ArrayList<>());
            for( int child : children ) map.computeIfAbsent( eId  , k -> new ArrayList<>()).add(child);
        }
        int totalImprovement = 0;
        System.out.print(map+" "+mapValues+"\n");
        Queue<Integer> q = new LinkedList<>();
        q.offer(id);
        HashSet<Integer> visited = new HashSet<>();
        while(!q.isEmpty()){
            int eId = q.poll();
            if(visited.contains(eId)) continue;
            visited.add(eId);
            totalImprovement += mapValues.get(eId);
            List<Integer> children = map.get(eId);
            for(int child : children) if(!visited.contains(child)) q.offer(child);
        }
        return totalImprovement;
    }
}