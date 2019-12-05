package amazon;


public class _388LongestAbsoluteFilePath {
    private static class File {
        String name;
        File parent;

        public File(String name) {
            this(name, null);
        }

        public File(String name, File parent) {
            this.name = name;
            this.parent = parent;
        }

        public int length() {
            return name.length() + (parent == null ? 0 : parent.length() + 1);
        }


        public boolean isFile() {
            return name.contains(".");
        }
    }

    private int getDepth(String s) {
        int ret = 0;
        int index = 0;
        while (s.substring(index, index + 1).equals("\t")) {
            ret++;
            index++;
        }
        return ret;
    }

    public int lengthLongestPath(String input) {
        String[] lines = input.split("\n");
        File root = new File(lines[0]);
        File lastFile = root;
        int lastDepth = 0;

        int maxlen = root.isFile() ? root.length() : 0;
        for (int i = 1; i < lines.length; i++) {
            int depth = getDepth(lines[i]);
            String name = lines[i].substring(depth);

            File currentFile = new File(name);

            if (depth > lastDepth) {
                currentFile.parent = lastFile;
            } else if (depth == lastDepth) {
                currentFile.parent = lastFile.parent;
            } else {
                currentFile.parent = lastFile.parent;
                for(int j = 0; j < lastDepth - depth; j++) {
                    currentFile.parent = currentFile.parent.parent;
                    
                }
            }
            if (currentFile.isFile()) {
                if (currentFile.length() > maxlen) {
                    maxlen = currentFile.length();
                }
            }

            lastFile = currentFile;
            lastDepth = depth;
        }

        return maxlen;
    }

    public static void main(String[] args) {
        _388LongestAbsoluteFilePath s = new _388LongestAbsoluteFilePath();
        String str = "a\n\taa\n\t\taaa\n\t\t\tfile1.txt\naaaaaaaaaaaaaaaaaaaaa\n\tsth.png";
        System.out.println(str);
        s.lengthLongestPath(str);
//        System.out.println(Arrays.toString(str.split("\n")));
//        for (char c : str.toCharArray()) {
//            System.out.println(c+":"+(int)c);
//        }
    }
//    "dir\n\t        file.txt\n\tfile2.txt"
}
