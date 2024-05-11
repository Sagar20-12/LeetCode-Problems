class Worker{
    double baseWage;
    int quality;
    public Worker(double baseWage, int quality){
        this.baseWage = baseWage;
        this.quality = quality;
    }
}
class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        // calculating the person base wage
        ArrayList<Worker> list = new ArrayList<>();
        int n = quality.length;
        for(int i = 0; i<n; i++){
            double baseWage = 1.0 * wage[i]/quality[i];
            list.add(new Worker(baseWage, quality[i]));
        }
        // Sorting the arrays based on the base wages
        Collections.sort(list, new Comparator<Worker>(){
            public int compare(Worker w1, Worker w2){
                if(w1.baseWage<=w2.baseWage){
                    return -1; // Dont swap already in increasing order 
                } else{
                    return 1;
                }
            }
        });
        PriorityQueue<Worker> pq = new PriorityQueue<>(new Comparator<Worker>(){
            public int compare(Worker w1, Worker w2){
                if(w1.quality<=w2.quality){
                    return 1; // swap if decreasing order found
                } else{
                    return -1;
                }
            }
        });
        double ans = Double.MAX_VALUE;
        int total = 0;
        for(int i = 0; i<n; i++){
            pq.offer(list.get(i));
            total+=list.get(i).quality;
            if(pq.size() == k){
                double cost = total*list.get(i).baseWage;
                ans = Math.min(ans, cost);
                // remove that person whose have quality maximum
                total-= pq.poll().quality;
            }
        }
        return ans;
    }
}