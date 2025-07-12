import org.junit.jupiter.api.*;

public class DemoFirstTest {

    int result;

    @BeforeAll
    static void doBeforeAll(){
        System.out.println("\n#####  doBeforeAll()\n");
    }

    @BeforeEach
    void doBeforeEach(){
        System.out.println("#####  doBeforeEach()");
        result = getResult();
    }

    @AfterEach
    void doAfterEach(){
        System.out.println("#####  doAfterEach()\n");
        result = 0;
    }

    @AfterAll
    static void doAfterAll(){
        System.out.println("\n#####  doAfterEach()\n");
    }


    @Test
    void simpleFirstTest() {
        System.out.println("#####      simpleFirstTest()");
        Assertions.assertTrue(result>2);

    }

    @Test
    void simpleSecondTest() {
        System.out.println("#####      simpleSecondTest()");
        Assertions.assertTrue(result>2);

    }

    @Test
    void simpleThirdTest() {
        System.out.println("#####      simpleThirdTest()");
        Assertions.assertTrue(result>2);

    }

    private int getResult(){
        return 3;
    }
}
