package trees;

public class TreeHeight {

    public static void main(String[] args) {
        Node tree = new Node(1);
        tree.left = new Node(2);
        tree.right = new Node(3);
        tree.left.left = new Node(4);
        tree.left.right = new Node(5);

        int height = findTreeHeight(tree);
        System.out.println("height of tree = "+height);
        int height2 = findTreeHeightFromGeeksfofGeeks(tree);
        System.out.println("height of tree from Geeks4Geeks = "+height2);
    }

    /**
     *       1
     *     /  \
     *    2    3
     *   / \
     *  4   5
     *
     * @param root
     * @return
     */
    public static int findTreeHeight(Node root) {
        if(root == null)
            return 0;
        else if(root.left == null && root.right == null) {
            return 1;
        }
        else {
            int lh = findTreeHeight(root.left);
            int rh = findTreeHeight(root.right);
            if(lh > rh) return lh + 1;
            else return rh + 1;
        }
    }

    private static int findTreeHeightFromGeeksfofGeeks(Node root) {
        if(root == null)
            return 0;
        else {
            int leftHeight = findTreeHeight(root.left);
            int rightHeight = findTreeHeight(root.right);
            if( leftHeight > rightHeight) {
                return  leftHeight + 1;
            } else {
                return  rightHeight + 1;
            }
        }
    }
}
