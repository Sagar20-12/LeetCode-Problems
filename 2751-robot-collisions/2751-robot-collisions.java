class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Integer[] ind = new Integer[n];
        for(int i = 0; i<n; i++){
            ind[i] = i;
        }
        Arrays.sort(ind, new Comparator<Integer>(){
            //sorted in increasing order of positions
            public int compare(Integer a, Integer b){
                return positions[a] - positions[b];
            }
        });
        List<Integer> res = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        for(int index :  ind){
            if(directions.charAt(index) == 'R'){
                st.push(index);
            } else{
                boolean isSurvive = true;
                while(!st.isEmpty()){
                    int top = st.peek();
                    //case 1 : if incoming is L and top is also L so blind insertion
                    if(directions.charAt(top) == 'L'){
                        isSurvive = true;
                        break;

                    }
                    //case 2 : Top index is R, and health is more than index
                    else if(healths[top] > healths[index]){
                        isSurvive = false;
                        healths[index] = 0;
                        healths[top] -= 1;
                        break;
                    }
                    //case 3 : topIndex is R and health is less than index
                    else if(healths[index] > healths[top]){
                        isSurvive = true;
                        healths[top] = 0;
                        healths[index] -=1;
                        st.pop();
                    }

                    //case 4: Top index is R and health is equal 'index'
                    else{
                        isSurvive = false;
                        healths[top] = 0;
                        healths[index] = 0;
                        st.pop();
                        break;
                    }
                }
                if(isSurvive){
                    st.push(index); //left direction robot
                }
            }
        }
        for(int i = 0; i<n; i++){
            if(healths[i]>0){
                res.add(healths[i]);
            }
        }
        return res;
    }
}