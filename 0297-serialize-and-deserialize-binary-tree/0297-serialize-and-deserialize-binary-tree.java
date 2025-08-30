/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        Queue < TreeNode > q = new LinkedList <> ();

        StringBuilder searilizedTree = new StringBuilder();

        q.add( root );


        while ( !q.isEmpty () ) {

            Queue < TreeNode > tempQ = new LinkedList <> ();

            while ( !q.isEmpty () ) {

                TreeNode node = q.poll();

                if ( node == null ) {

                    searilizedTree.append("null,");
                    continue;

                }

                tempQ.offer( node.left );
                tempQ.offer( node.right );
                
                searilizedTree.append(String.valueOf ( node.val ) + "," );
                 
            }

            if ( !tempQ.isEmpty () ) q = tempQ;

        }

        return searilizedTree.toString();
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        TreeNode root = new TreeNode ();

        String [] dataValues = data.split(",");
        int index = 0;

        if ( dataValues [ 0 ].equals("null") ) return null;

        root.val = Integer.parseInt ( dataValues [ index++ ] );

        Queue < TreeNode > q = new LinkedList <> ();

        q.offer ( root );

        while ( !q.isEmpty () ) {

            Queue < TreeNode > tempQ = new LinkedList <> ();

            while ( !q.isEmpty () ) {

                TreeNode node = q.poll();

                String left = dataValues [ index++ ] , right = dataValues [ index++ ];

                if ( !left.equals("null") ) {
                
                     int val = Integer.parseInt ( left );
                     node.left = new TreeNode ( val );
                     tempQ.add ( node.left );

                }

                 if ( !right.equals("null") ) {
                
                     int val = Integer.parseInt ( right );
                     node.right = new TreeNode ( val );
                     tempQ.add ( node.right );

                }

            }

            if ( !tempQ.isEmpty () ) q = tempQ;

        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));