class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>(rowIndex + 1);

        //initialize the first element of the row
        row.add(1);

        //calculate each element based on the previous element
        for(int k = 1; k <= rowIndex; k++){
            row.add((int)((long) row.get(k-1)*(rowIndex - k + 1)/k));
        } 
        return row;
    }
}