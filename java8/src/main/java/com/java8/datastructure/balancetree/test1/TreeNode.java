package com.java8.datastructure.balancetree.test1;

import lombok.Data;

import java.util.Objects;

/**
 * @author chengsukai
 */
@Data
public class TreeNode {

    private int bf = 0; // balanceFactor平衡因子
    private int data; // 该节点存放的数据
    private TreeNode parent_node; // 该节点的父节点
    private TreeNode left_child,right_child; //左右子节点
    private int count = 0; // 重复插入的次数

    public TreeNode(int data){
        this.data = data;
    }

    /**
     * 此处注意不能直接打印左右子节点和父节点的全部节点信息
     * 因为节点之间有互相引用关系，如果全部打印会导致堆栈溢出
     * 故此处值打印父节点和左右子节点的值
     *
     * @return
     */
    @Override
    public String toString() {
        String p_data = null, l_data = null, r_data = null;
        if (parent_node != null) {
            p_data = String.valueOf(parent_node.data);
        }
        if (left_child != null) {
            l_data = String.valueOf(left_child.data);
        }
        if (right_child != null) {
            r_data = String.valueOf(right_child.data);
        }
        return "TreeNode{" +
                " data=" + data +
                ", bf=" + bf +
                ", count=" + count +
                ", parent_node_data=" + p_data +
                ", left_child_data=" + l_data +
                ", right_child_data=" + r_data +
                '}';
    }

    /**
     * 因为平衡二叉树的节点值唯一，所以此处只需要比较值相等
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TreeNode node = (TreeNode) o;
        return data == node.data;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bf, data, parent_node, left_child, right_child, count);
    }


}
