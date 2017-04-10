//δ��ɣ�������������������������
interface TreeNode<T> {
    
    int size();           //�Ե�ǰ�ڵ�Ϊ���ĺ��������
    int height();         //��ǰ�ڵ㵽Ҷ�ڵ�������
    BinNode<T> insertAsLC(T e);
    BinNode<T> insertAsRC(T e);
    BinNode<T> succ();    //ȡ��ǰ�ڵ��ֱ�Ӻ��
    void travLevel();     //������α���
    void travPre();       //�����������
    void travIn();        //�����������
    void travPost();      //�����������
}
public class BinNode<T> {
    T data;
    BinNode<T> parent, lc, rc;  //����parent�ֶ�����˫���������Ӿ��ǵ�����
    int height;
    
    
/********************ǰ�����: ��ǰ�ڵ�-> lc -> rc *******************************************/
    
    public void travPre() {
        Stack<BinNode<T>> s = new Stack<>();
        BinNode<T> current = this;
        while (true) {
            visitAlongLeftBranch(current, s);
            if (s.isEmpty()) break;
            current = s.pop();
        }
    }
    private void visitAlongLeftBranch(BinNode<T> x, Stack<BinNode<T>> s) {
        while (x != null) {
            visit(x.data);
            s.push(x.rc);
            x = x.lc;
        }
    }
    
    
/*******************�������: lc -> ��ǰ�ڵ� -> rc *******************************************/
    public void travIn() {
        BinNode<T> current = this;
        Stack<BinNode<T>> s = new Stack<>();
        while (true) {
                goAlongLeftBranch(current, s);
                if (s.isEmpty()) break;
                current = s.pop();
                visit(current.data);
                current = current.rc;
            }
    }
    private void goAlongLeftBranch(BinNode<T> x, Stack<BinNode<T>> s) {
        while (x != null) {
            s.push(x);
            x = x.lc;            
        }
    }
    
/*****************�������: lc -> rc -> ��ǰ�ڵ� *******************************************/
    public void travPost() {
        BinNode<T> current = this;
        Stack<BinNode<T>> s = new Stack<>();        
        if (current != null)
            s.push(current);
        while (!s.isEmpty()) {
            if (s.peek() != current.parent) //����ǰջ��Ԫ�طǵ�ǰ�ڵ�ĸ��ף���ô��һ���ǵ�ǰ�ڵ�����֣�����Ҫ����������Ϊ����������HLVFL
                gotoHLVFL(s);
                
            current = s.pop();
            visit(current.data);
        }
    }
    //HLVFL: ������ɼ�Ҷ�ڵ�
    public void gotoHLVFL(Stack<BinNode<T>> s) {
        BinNode<T> current = s.peek();
        while (current != null) {
            if (HasLChild(current)) {
                if (HasRChild(current))     
                    s.push(current.rc);
                S.push(current.lc);
            } 
            else {
                s.push(current.rc);
            }
            //���սڵ�null������������ջ��Ԫ��Ϊ��ǰ������ɼ�Ҷ�ڵ�
            s.pop();
        }
    }
    
    
    
    public static <T> void visit(T e) {}
    
}








































