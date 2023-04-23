package com.java8.datastructure.balancetree.test1;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @author chengsukai
 * 1.任意节点左子树上的节点值小于该节点的值,右子树上的节点值大于该节点的值,该节点的子节点也适用这个规律
 * 2.每个节点左右子树的深度差绝对值不大于1
 */
public class AVLTree {
    private final Queue<TreeNode> tree = new LinkedList<>();

    public void insertNode(int data) {
        TreeNode newNode = new TreeNode(data);
        tree.add(newNode);
    }

    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();
        avlTree.insertNode(7);
        System.out.println("final result: " + avlTree.tree);
    }

    /**
     * 计算插入节点的位置
     */
    private void indexOf(TreeNode oldNode, TreeNode newNode) {
        if (newNode.getData() == oldNode.getData()) {
            oldNode.setCount(oldNode.getCount() + 1);
        } else if (newNode.getData() < oldNode.getData()) {
            if (oldNode.getLeft_child() == null) {
                oldNode.setLeft_child(newNode);
                newNode.setParent_node(oldNode);
            } else {
                indexOf(oldNode.getLeft_child(), newNode);
            }
        } else {
            if (oldNode.getRight_child() == null) {
                oldNode.setRight_child(newNode);
                newNode.setParent_node(oldNode);
            } else {
                indexOf(oldNode.getRight_child(), newNode);
            }
        }
    }

    /**
     * 计算最小不平衡子树
     * 可能存在的情况:
     * 1.该节点是根节点(没有父节点)
     * 2.该节点的父节点平衡因子>1,代表此节点是最小不平衡子树
     * 3.该节点的父节点平衡因子<1,递归继续向上查找
     *
     * @param node 新插入的节点
     * @return 最小不平衡子树
     */
    private TreeNode countMinUnBalanceNode(TreeNode node) {
        TreeNode fromNode = node.getParent_node();
        if (fromNode != null) {
            int bfAbs = Math.abs(fromNode.getBf());
            if (bfAbs > 1) {
                return fromNode;
            } else {
                return countMinUnBalanceNode(fromNode);
            }
        } else {
            int bfAbs = Math.abs(node.getBf());
            if (bfAbs > 1) {
                return node;
            }
        }

        return null;
    }



}
