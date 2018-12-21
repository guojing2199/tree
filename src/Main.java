import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        TreeNode TreeNode1 = new TreeNode(0, 2, "A");
        TreeNode TreeNode2 = new TreeNode(2, 3, "B");
        TreeNode TreeNode3 = new TreeNode(2, 4, "C");
        TreeNode TreeNode4 = new TreeNode(3, 5, "D");
        TreeNode TreeNode5 = new TreeNode(3, 6, "E");
        TreeNode TreeNode6 = new TreeNode(2, 7, "F");
        TreeNode TreeNode7 = new TreeNode(6, 8, "G");

        List<TreeNode> list = new ArrayList<>();
        list.add(TreeNode1);
        list.add(TreeNode2);
        list.add(TreeNode3);
        list.add(TreeNode4);
        list.add(TreeNode5);

        TreeHelper helper = new TreeHelper(list);
        helper.getRoot().insertJuniorNode(TreeNode6);
        helper.getRoot().insertJuniorNode(TreeNode7);

        long start = System.currentTimeMillis();
        // 广度优先遍历
        helper.getRoot().breadthTraverse();
        long end = System.currentTimeMillis();
        System.out.println("广度优先遍历用时：" + (end - start) + "ms");

        long start1 = System.currentTimeMillis();
        // 深度优先遍历
        helper.getRoot().depthTraverse();
        long end1 = System.currentTimeMillis();
        System.out.println("深度优先遍历用时：" + (end1 - start) + "ms");

    }
}
