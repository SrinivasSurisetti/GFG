class Solution {
    public ArrayList<Integer> spirallyTraverse(int[][] mat) {
        // code here
        int n = mat.length;
        int m = mat[0].length;
        int left = 0, ryt  = m - 1;
        int top = 0, bottom = n - 1;
        ArrayList<Integer> res = new ArrayList<>();
        while(top <= bottom && left <= ryt){
            //top
            for(int i = left;i<=ryt;i++) {
                res.add(mat[top][i]);
            }
            top++;
            
            //ryt
            for(int i = top;i<=bottom;i++){
                res.add(mat[i][ryt]);
            }
            ryt--;
            
            //bottom
            if(top <= bottom){
                for(int i = ryt;i>=left;i--){
                    res.add(mat[bottom][i]);
                }
                bottom--;
            }
            
            //top
            if(left <= ryt){
                for(int i = bottom;i>=top;i--){
                    res.add(mat[i][left]);
                }
                left++;
            }
        }
        return res;
    }
}
