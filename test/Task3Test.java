import OtherTasks.Task3;
import org.junit.*;

public class Task3Test {
    private static Task3 task3;

    @BeforeClass
    public static void initTest(){
        task3 = new Task3();
    }

    @AfterClass
    public static void destroy(){
        task3 = null;
    }

    @Test
    public void testCheckArray01(){
        Assert.assertEquals(true, task3.checkArrayFor1or4(new int[]{1, 4, 1, 4, 1, 4}));
    }

    @Test
    public void testCheckArray02(){
        Assert.assertEquals(false, task3.checkArrayFor1or4(new int[]{1, 3, 5, 77, 13}));
    }

    @Test
    public void testCheckArray03(){
        Assert.assertEquals(false, task3.checkArrayFor1or4(new int[]{4, 8, 3, 5}));
    }

}
