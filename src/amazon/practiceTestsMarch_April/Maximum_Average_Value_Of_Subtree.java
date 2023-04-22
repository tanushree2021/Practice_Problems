package amazon.practiceTestsMarch_April;

import java.util.Scanner;
import java.util.StringTokenizer;

/*
*
*
* Sample Input 1:

2
1 2 3 4 -1 -1 -1 -1 -1
2 4 -1 6 -1 3 -1 -1 -1

Sample Output 1:
4.00000
4.50000
* 
*  */
public class Maximum_Average_Value_Of_Subtree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        System.out.println("MaxAvgValue is "+findMaxAvgValue(root));

        root = new TreeNode(2);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(6);
        root.left.left.left = new TreeNode(3);

        System.out.println("MaxAvgValue is "+findMaxAvgValue(root));
    }

    private static int findMaxAvgValue(TreeNode<Integer> root) {
        if(root == null){
            return 0;
        }
        if(root.left != null){
            int avgVal = (root.data/findMaxAvgValue(root.left));
        }
        return 0;
    }
    //    private static TreeNode createTree(String st) {
//
//        String[] stArr = st.split(" ");
//        int[] intArr = new int[stArr.length];
//        int i=0;
//        for(String string: stArr){
//            intArr[i++]=Integer.parseInt(string);
//        }
//        TreeNode root = new TreeNode(intArr[0]);
//        int k=1;
//        TreeNode tempNode = null;
//        for(int in : intArr){
//            if(tempNode == null && in != -1) {
//                root.left = new TreeNode(intArr[k]);
//            } else if(tempNode == null){
//                root.left = null;
//            } else {
//                if (tempNode.right == null){
//
//                }
//            }
//            tempNode = root;
//        }
//
//        return root;
//    }

}

class TreeNode<T> {
    public T data;
    public TreeNode<T> left;
    public TreeNode<T> right;

    TreeNode(T data) {
        this.data = data;
        left = right = null;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "data=" + data +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
