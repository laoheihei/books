//Ѱ��ˮ������ˮ������������������1/2���ҳ�ˮ��
public class Test2 {
    //˼·1�����򣬼�����������ˮ��
    //˼·2������������д�0��ʼ��N/2�����ˮ��
    //˼·3��ÿ��ɾ��������ͬ��ID�����ʣ�µľ���ˮ��
    
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
    
    
    
    
    
    
    
    
    
    
    
    
    //��չ����3��ˮ����ÿ����������1/4���ҳ�����
}