
import java.util.*;

public class Self_AVL {
    //AVL

    static class Node {
        int val;
        int ht;
        Node left;
        Node right;

        static Node newNode(int data) {
            Node temp = new Node();
            temp.val = data;
            temp.left = null;
            temp.right = null;
            return temp;
        }


        static int ht_hidden(Node T)
        {
            int lh, rh;
            if (T == null)
            {
                return(0);
            }
            if (T.left == null)
            {
                lh = 0;
            }
            else
            {
                lh = 1 + T.left.ht;
            }
            if (T.right == null)
            {
                rh = 0;
            }
            else
            {
                rh = 1 + T.right.ht;
            }
            if (lh > rh)
            {
                return(lh);
            }
            return(rh);
        }
        static Node rotate_right_hidden(Node x)
        {
            Node y;
            y = x.left;
            x.left = y.right;
            y.right = x;
            x.ht = ht_hidden(x);
            y.ht = ht_hidden(y);
            return(y);
        }
        static Node  rotate_left_hidden(Node x)
        {
            Node y;
            y = x.right;
            x.right = y.left;
            y.left = x;
            x.ht = ht_hidden(x);
            y.ht = ht_hidden(y);
            return(y);
        }
        static Node RR_hidden(Node T)
        {
            T = rotate_left_hidden(T);
            return(T);
        }
        static Node LL_hidden(Node T)
        {
            T = rotate_right_hidden(T);
            return(T);
        }
        static Node LR_hidden(Node T)
        {
            T.left = rotate_left_hidden(T.left);
            T = rotate_right_hidden(T);
            return(T);
        }
        static Node RL_hidden(Node T)
        {
            T.right = rotate_right_hidden(T.right);
            T = rotate_left_hidden(T);
            return(T);
        }
        static int BF_hidden(Node T)
        {
            int lh, rh;
            if (T == null)
            {
                return(0);
            }
            if (T.left == null)
            {
                lh = 0;
            }
            else
            {
                lh = 1 + T.left.ht;
            }
            if (T.right == null)
            {
                rh = 0;
            }
            else
            {
                rh = 1 + T.right.ht;
            }
            return(lh - rh);
        }
        static void inorder_hidden(Node T)
        {
            if (T != null)
            {
                inorder_hidden(T.left);
                // printf("%d(BF=%d) ", T->val, BF_hidden(T));
                System.out.print(T.val+"(BF="+BF_hidden(T)+") ");
                inorder_hidden(T.right);
            }
        }

        static void preorder_hidden(Node T)
        {
            if (T != null)
            {
                System.out.print(T.val+"(BF="+BF_hidden(T)+") ");
                preorder_hidden(T.left);
                preorder_hidden(T.right);
            }
        }



        static Node hiddenInsert(Node T,int x)
        {
            if (T == null)
            {
                T = newNode(x);
            }
            else if (x > T.val)
            {
                T.right = hiddenInsert(T.right, x);
                if (BF_hidden(T) == -2)
                {
                    if (x > T.right.val)
                    {
                        T = RR_hidden(T);
                    }
                    else
                    {
                        T = RL_hidden(T);
                    }
                }
            }
            else if (x < T.val)
            {
                T.left = hiddenInsert(T.left, x);
                if (BF_hidden(T) == 2){
                    if (x < T.left.val)
                    {
                        T = LL_hidden(T);
                    }
                    else
                    {
                        T = LR_hidden(T);
                    }
                }
            }
            T.ht = ht_hidden(T);
            return(T);
        }


        static int height(Node x) {
            if (x == null) {
                return -1;
            }
            return x.ht;
        }

        static int getBalanceFactor(Node N) {
            if (N == null) {
                return 0;
            }
            return height(N.left) - height(N.right);
        }

        static Node rightRotate(Node y) {
            Node x = y.left;
            Node T2 = x.right;
            x.right = y;
            y.left = T2;
            y.ht = Math.max(height(y.left), height(y.right)) + 1;
            x.ht = Math.max(height(x.left), height(x.right)) + 1;
            return x;
        }

        static Node leftRotate(Node x) {
            Node y = x.right;
            Node T2 = y.left;
            y.left = x;
            x.right = T2;
            x.ht = Math.max(height(x.left), height(x.right)) + 1;
            y.ht = Math.max(height(y.left), height(y.right)) + 1;
            return y;
        }

        static Node insert(Node root, int data) {
            if (root == null) {
                return newNode(data);
            }
            if (data < root.val) {
                root.left = insert(root.left, data);
            } else if (data > root.val) {
                root.right = insert(root.right, data);
            } else {
                return root;
            }

            root.ht = Math.max(height(root.left), height(root.right)) + 1;
            int balanceFactor = getBalanceFactor(root);


            if (balanceFactor > 1) {
                if (data < root.left.val) {
                    return rightRotate(root);
                }
                else if (data > root.left.val) {
                    root.left = leftRotate(root.left);
                    return rightRotate(root);
                }
            }

            if (balanceFactor < -1) {
                if (data > root.right.val) {
                    return leftRotate(root);
                }
                else if (data < root.right.val) {
                    root.right = rightRotate(root.right);
                    return leftRotate(root);
                }
            }

            return root;
        }

    }

    public class avl {

        public static void main(String[] args) {
            /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
            int n;
            Scanner in = new Scanner(System.in);
            n=in.nextInt();


            Node root=null;

            for(int i=0;i<n;i++)
            {
                int val;
                val=in.nextInt();
                root=root.hiddenInsert(root,val);
            }
            int nv;
            nv=in.nextInt();
            root=root.insert(root,nv);
            Node.inorder_hidden(root);
            System.out.println("");
            Node.preorder_hidden(root);
            System.out.println("");
        }
    }
}
