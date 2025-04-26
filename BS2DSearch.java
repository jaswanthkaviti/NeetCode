package org.example;

public class BS2DSearch {
    public static void main(String[] args){
        int[][] matrix = {{1,2,4,8},{10,11,12,13},{14,20,30,40}};
        System.out.println(searchMatrix(matrix,11));
    }

    private static boolean searchMatrix(int[][] matrix, int target) {
        int rIndx = poteintialRow(matrix,target);
        if(rIndx != -1){
            return bsOverRow(rIndx,matrix,target);
        }
        else{
            return false;
        }
    }

    private static boolean bsOverRow(int rIndx, int[][] matrix, int target) {
        int low =0;
        int high = matrix[rIndx].length-1;
        while(low <= high){
            int mid = low+(high-low)/2;
            if(matrix[rIndx][mid] == target){
                return true;
            }
            else if (matrix[rIndx][mid]>target){
                high=mid-1;
            }
            else if(matrix[rIndx][mid]<target){
                low=mid+1;
            }
        }
        return false;
    }

    private static int poteintialRow(int[][] matrix, int target) {
        int low =0;
        int high = matrix.length-1;
        while (low<=high){
            int mid = low+(high-low)/2;
            if(matrix[mid][0]<=target && target<=matrix[mid][matrix[mid].length-1]){
                return mid;
            }
            else if (matrix[mid][0]>target){
                high=mid-1;
            }
            else if (matrix[mid][0]<target){
                low=mid+1;
            }
        }
        return -1;
    }
}
