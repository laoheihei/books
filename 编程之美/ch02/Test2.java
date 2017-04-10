//寻找水贴王：水王发帖数超过总数的1/2，找出水王
public class Test2 {
    //思路1：排序，计数，最大的是水王
    //思路2：排序，排序队列从0开始第N/2项必是水王
    //思路3：每次删除两个不同的ID，最后剩下的就是水王
    
    public static int findKingOfWater(int[] a) {
        int index1 = 0;
        int index2 = 1;
        int numOfSameItems = 1;
        while (index2 < a.length) {
            if (a[index1] == a[index2]) {
                index2++;
                numOfSameItems++;                
            } else {
                if (numOfSameItems == 1) {
                    index1 = ++index2;
                    index2++;
                } else {
                index1++;
                index2++;
                numOfSameItems--;
                
                }
            }
        }
        return index1;
    }
    
    public static void main(String[] args) {
        int[] a = {5, 1, 2, 5, 3, 4, 5, 5, 5, 5, 5, 5, 6, 7,5,  8, 5, 9, 10, 5};
        System.out.println(findKingOfWater(a));
    }
    
    
    
    
    
    
    
    
    
    
    
    
    //拓展：有3个水王，每个发帖超过1/4，找出他们
}