package rybki001_proj3;

class HBST <Key, Value>
{

    private class ValueNode
    {
        private Key key;
        private Value value;
        private ValueNode next;

        private ValueNode(Key key, Value value)
        {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private class TreeNode
    {
        private Key key;
        private ValueNode next;
        private TreeNode left;
        private TreeNode right;

        private TreeNode(Key key)
        {
            this.key = key;
            this.next = null;
            this.left = null;
            this.right = null;
        }
    }

    private TreeNode root;

    public HBST ()
    {
        root = new TreeNode(null);
    }

    public Value get(Key key)
    {
        if (key == null)
        {
            throw new IllegalArgumentException("Key is null");
        }

        TreeNode groot = root;

        while (groot != null)
        {
            if (hash(key) > hash(groot.key))
            {
                groot = groot.right;
            }

            else if (hash(key) < hash(groot.key))
            {
                groot = groot.left;
            }

            else
            {
                break;
            }
        }

        ValueNode temp = groot.next;

        while (temp != null)
        {
            if (temp.key.equals(key))
            {
                return temp.value;
            }
            else
            {
                temp = temp.next;
            }
        }

        throw new IllegalArgumentException("No value is associated with key");
    }


    private int hash (Key key)
    {
        if (key != null)
        {
            return key.hashCode();
        }
        else
        {
            return 0;
        }
    }


    public int height ()
    {
        return height(root);
    }

    private int height (TreeNode groot)
    {
        if (groot == null)
        {
            return 0;
        }
        else
        {
            int right = height(groot.right);
            int left = height(groot.left);
            if (right > left)
            {
                return right + 1;
            }
            else
            {
                return left + 1;
            }
        }
    }

    public void put (Key key, Value value)
    {
        if (key == null)
        {
            throw new IllegalArgumentException("Null");
        }

        else if (root == null)
        {
            root = new TreeNode(key);
        }

        else
        {
            TreeNode groot = root;
            while (true)
            {
                if  (hash(key) > hash(groot.key))
                {
                    if (groot.right == null)
                    {
                        groot.right = new TreeNode(key);
                        groot.right.next = new ValueNode(key,value);
                        return;
                    }
                    else
                    {
                        groot = groot.right;
                    }
                }
                else if (hash(key) < hash(groot.key))
                {
                    if (groot.left == null)
                    {
                        groot.left = new TreeNode(key);
                        groot.left.next = new ValueNode(key, value);
                        return;
                    }
                    else
                    {
                        groot = groot.left;
                    }
                }

                else
                {
                    ValueNode temp = groot.next;

                    while (true)
                    {
                        if (groot.next == null)
                        {
                            temp.next = new ValueNode(key,value);
                            return;
                        }
                        temp = temp.next;
                    }
                }
            }
        }
    }
}

class HBSTifier  //Was thinking about writing another driver class, but then realised that output from example driver class is good enough.
{
    private final static String[] keys =
            { "abstract",     "assert",       "boolean",     "break",
                    "byte",         "case",         "catch",       "char",
                    "class",        "const",        "continue",    "default",
                    "do",           "double",       "else",        "extends",
                    "false",        "final",        "finally",     "float",
                    "for",          "goto",         "if",          "implements",
                    "import",       "instanceof",   "int",         "interface",
                    "long",         "native",       "new",         "null",
                    "package",      "private",      "protected",   "public",
                    "return",       "short",        "static",      "super",
                    "switch",       "synchronized", "this",        "throw",
                    "throws",       "transient",    "true",        "try",
                    "var",          "void",         "volatile",    "while" };

    public static void main(String [] args)
    {
        HBST<String, Integer> hbst = new HBST<String, Integer>();

        for (int index = 0; index < keys.length; index += 1)
        {
            hbst.put(keys[index], index);
        }

        System.out.println(hbst.height());

        for (int index = 0; index < keys.length; index += 1)
        {
            System.out.format("%02d %s", hbst.get(keys[index]), keys[index]);
            System.out.println();
        }
    }
}