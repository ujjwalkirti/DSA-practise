import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class EmployeeImportance {
    static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;

        public <T> Employee(int i, int i1, List<Integer> list) {
            this.id = i;
            this.importance = i1;
            this.subordinates = list;
        }
    }

    public static void main(String[] args) {
        EmployeeImportance obj = new EmployeeImportance();
        List<Employee> employees = Arrays.asList(new Employee(1, 5, Arrays.asList(2, 3)), new Employee(2, 3, new ArrayList<>()), new Employee(3, 3, new ArrayList<>()));
        int id = 1;
        System.out.println(obj.getImportance(employees, id));
    }

    public int getImportance(List<Employee> employees, int id) {

        int[] dp = new int[employees.size()+1];
        Arrays.fill(dp,);
        for (Employee employee:employees){
            if(employee.subordinates.size()==0){
                dp[employee.id] = employee.importance;
            }
        }




        return 0;
    }

}
