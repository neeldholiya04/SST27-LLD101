public class BasicPrinter implements Printer, Scanner, Fax {
    @Override
    public void print(String text) {
        System.out.println("Print: " + text);
    }

    @Override
    public void scan(String dstPath) {
        System.out.println("Scanning to: " + dstPath);
    }

    @Override
    public void fax(String number) {
        System.out.println("Faxing to number: " + number);
    }
}
