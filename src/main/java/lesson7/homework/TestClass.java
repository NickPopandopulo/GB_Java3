package lesson7.homework;

public class TestClass {
    @BeforeSuite
    void runBefore() {
        System.out.println("Start method is run.");
    }

    @Test(priority = 6)
    void test1() {
        System.out.println("Test1 is run with priority equal to 6.");
    }

    @Test(priority = 3)
    void test2() {
        System.out.println("Test2 is run with priority equal to 3.");
    }

    @Test(priority = 6)
    void test3() {
        System.out.println("Test3 is run with priority equal to 6.");
    }

    @Test(priority = 9)
    void test4() {
        System.out.println("Test4 is run with priority equal to 9.");
    }

    @AfterSuite
    void runAfter() {
        System.out.println("End method is run.");
    }

}
