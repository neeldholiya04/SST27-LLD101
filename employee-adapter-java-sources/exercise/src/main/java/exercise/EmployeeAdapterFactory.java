package exercise;

public final class EmployeeAdapterFactory {
    private EmployeeAdapterFactory() {}

    public static Employee adapt(Object legacy) {
        if (legacy instanceof EmployeeCSV e) {
            return new EmployeeCSVAdapter(e);
        } else if (legacy instanceof EmployeeDB e) {
            return new EmployeeDBAdapter(e);
        } else if (legacy instanceof EmployeeLDAP e) {
            return new EmployeeLDAPAdapter(e);
        }
        throw new IllegalArgumentException("Unsupported employee type: " + legacy.getClass());
    }
}
