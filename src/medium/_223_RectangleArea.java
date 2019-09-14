package medium;

public class _223_RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int base = area(A,B,C,D)+area(E,F,G,H);
        
        // non intersecting by any which way
        if(G < A || E > C || F > D || H < B) {
            return base;
        }
        
        return base-area(Math.max(A,E), Math.max(B,F),Math.min(G,C), Math.min(H,D));
    }
    
    private int area(int a, int b, int c, int d){
        return (c-a)*(d-b); // remain positive
    }

    public static void main(String[] args) {
        _223_RectangleArea s = new _223_RectangleArea();
        s.computeArea(-3, 0, 3, 4, 0, -1, 9, 2);
    }
}
