package Q07_重建二叉树.垃圾的解法;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhangHao
 * @date 2020/2/20 21:01
 * @Description：
 */
public class BinTree {
    private BinTree lChild;//左孩子
    private BinTree rChild;//右孩子
    private BinTree root;//根节点
    private Object data; //数据域
    private List<BinTree> datas;//存储所有的节点

    private BinTree(BinTree lChild, BinTree rChild, Object data) {
        super();
        this.lChild = lChild;
        this.rChild = rChild;
        this.data = data;
    }
    BinTree(Object data) {
        this(null, null, data);
    }
    public BinTree() {
        super();
    }

    public void createTree(Object[] objs){
        datas=new ArrayList<BinTree>();
        for (Object object : objs) {
            datas.add(new BinTree(object));
        }
        root=datas.get(0);//将第一个作为根节点
        for (int i = 0; i < objs.length/2; i++) {
            datas.get(i).lChild=datas.get(i*2+1);
            if(i*2+2<datas.size()){//避免偶数的时候 下标越界
                datas.get(i).rChild=datas.get(i*2+2);
            }
        }
    }
    //先序遍历
    public void preorder(BinTree root){
        if(root!=null){
            visit(root.getData());
            preorder(root.lChild);
            preorder(root.rChild);
        }

    }
    //中序遍历
    public void inorder(BinTree root){
        if(root!=null){
            inorder(root.lChild);
            visit(root.getData());
            inorder(root.rChild);
        }

    }
    //后序遍历
    public void afterorder(BinTree root){
        if(root!=null){
            afterorder(root.lChild);
            afterorder(root.rChild);
            visit(root.getData());
        }

    }
    private void visit(Object obj) {
        System.out.print(obj+" ");
    }

    Object getData() {
        return this.data;
    }
    public BinTree getRoot() {
        return root;
    }

    public BinTree getlChild() {
        return lChild;
    }

    void setlChild(BinTree lChild) {
        this.lChild = lChild;
    }

    public BinTree getrChild() {
        return rChild;
    }

    void setrChild(BinTree rChild) {
        this.rChild = rChild;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
