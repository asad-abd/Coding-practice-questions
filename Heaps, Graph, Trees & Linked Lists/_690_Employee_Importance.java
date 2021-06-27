public class _690_Employee_Importance {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> roll = new HashMap<>();
        Queue<Employee> q = new LinkedList<>();
        for(Employee e1 : employees){
            if(e1.id == id){
                q.add(e1);
            }
            roll.put(e1.id, e1);
        }
        HashSet<Integer> visited = new HashSet<>();
        int ans = 0;
        while(q.size()>0){
            Employee e = q.poll();
            if(!visited.contains(e.id)){
                visited.add(e.id);
                ans += e.importance;
                for(int id1 : e.subordinates){
                    if(!visited.contains(id1))
                        q.add(roll.get(id1));
                }
            }
        }
        return ans;
    }
    //apparently a compact solution from solution:
    Map<Integer, Employee> emap;
    public int getImportance(List<Employee> employees, int queryid) {
        emap = new HashMap();
        for (Employee e: employees) emap.put(e.id, e);
        return dfs(queryid);
    }
    public int dfs(int eid) {
        Employee employee = emap.get(eid);
        int ans = employee.importance;
        for (Integer subid: employee.subordinates)
            ans += dfs(subid);
        return ans;
    }
}
