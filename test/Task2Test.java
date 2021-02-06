import OtherTasks.Task2;
import org.junit.*;
import org.junit.rules.ExpectedException;

public class Task2Test {
    private static Task2 task2;

    @BeforeClass
    public static void initTest(){
        task2 = new Task2();
    }

    @AfterClass
    public static void destroy(){
        task2 = null;
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void getArraysNumberAfterLast4_01(){
        int[] arr1 = {1, 7};
        Assert.assertArrayEquals(arr1, task2.getArraysNumberAfterLast4(new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}));
    }

    @Test
    public void getArraysNumberAfterLast4_02(){
        int[] arr2 = {3, 1, 1, 7};
        Assert.assertArrayEquals(arr2, task2.getArraysNumberAfterLast4(new int[]{1, 2, 4, 4, 4, 3, 1, 1, 7}));
    }

    @Test
    public void getArraysNumberAfterLast4_03(){
        int[] arr3 = {1, 3};
        Assert.assertArrayEquals(arr3, task2.getArraysNumberAfterLast4(new int[]{4, 4, 4, 4, 1, 3}));
    }

    @Test
    public void getArraysNumberAfterLast4_04(){
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("В массиве нет ни одной цифры 4!");
        task2.getArraysNumberAfterLast4(new int[]{1, 1, 5, 5, 8});
    }

}
