//未完成！！！！！！！！！！！！！
interface TreeNode<T> {
    
    int size();           //以当前节点为根的后代的总数
    int height();         //当前节点到叶节点的最长距离
    BinNode<T> insertAsLC(T e);
    BinNode<T> insertAsRC(T e);
    BinNode<T> succ();    //取当前节点的直接后继
    void travLevel();     //子树层次遍历
    void travPre();       //子树先序遍历
    void travIn();        //子树中序遍历
    void travPost();      //子树后序遍历
}
public class BinNode<T> {
    T data;
    BinNode<T> parent, lc, rc;  //加入parent字段则变成双向链表；不加就是单链表
    int height;
    
    
/********************前序遍历: 当前节点-> lc -> rc *******************************************/
    
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
    
    
/*******************中序遍历: lc -> 当前节点 -> rc *******************************************/
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
    
/*****************后序遍历: lc -> rc -> 当前节点 *******************************************/
    public void travPost() {
        BinNode<T> current = this;
        Stack<BinNode<T>> s = new Stack<>();        
        if (current != null)
            s.push(current);
        while (!s.isEmpty()) {
            if (s.peek() != current.parent) //若当前栈顶元素非当前节点的父亲，那么就一定是当前节点的右兄，所以要访问以右兄为根的子树的HLVFL
                gotoHLVFL(s);
                
            current = s.pop();
            visit(current.data);
        }
    }
    //HLVFL: 最高左侧可见叶节点
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
            //将空节点null弹出，弹出后栈顶元素为当前最高左侧可见叶节点
            s.pop();
        }
    }
    
    
    
    public static <T> void visit(T e) {}
    
}








































