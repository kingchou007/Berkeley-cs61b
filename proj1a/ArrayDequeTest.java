public class ArrayDequeTest {
    public static boolean checkEmpty(boolean expected, boolean actual) {
        if (expected != actual) {
            System.out.println("isEmpty() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    public static void printTestStatus(boolean passed) {
        if (passed) {
            System.out.println("Test passed!\n");
        } else {
            System.out.println("Test failed!\n");
        }
    }

    public static void addRemoveTest(){
        System.out.println("Running add/remove test.");

        ArrayDeque arr1 = new ArrayDeque();

        // should be empty
        boolean passed = checkEmpty(true, arr1.isEmpty());

        arr1.addFirst(10);

        // should not be empty
        passed = checkEmpty(false, arr1.isEmpty()) && passed;


        arr1.removeFirst();
        // should be empty
        passed = checkEmpty(true, arr1.isEmpty()) && passed;

        /** test addLast */
        arr1.addLast(9);

        passed = checkEmpty(false, arr1.isEmpty()) && passed;

        arr1.removeLast();
        passed = checkEmpty(true, arr1.isEmpty()) && passed;

        printTestStatus(passed);
    }

    public static void main(String[] arg){
        System.out.println("Running tests.\n");
        addRemoveTest();
    }
}
