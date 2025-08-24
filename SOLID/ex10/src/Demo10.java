/*
 * Issues in existing implementation:
 * ReportService is responsible for report generation but also decides how logging is done by instantiating ConsoleLogger. This violates the Single Responsibility Principle.
 * If tomorrow you want a FileLogger or DatabaseLogger, you must modify ReportService. This violates the Open/Closed Principle.
 * ReportService depends on ConsoleLogger (concrete), instead of an abstraction. This violates the Dependency Inversion Principle.
 */
public class Demo10 {
    public static void main(String[] args) {
        Logger logger = new ConsoleLogger();
        ReportService service = new ReportService(logger);

        service.generate();
    }
}