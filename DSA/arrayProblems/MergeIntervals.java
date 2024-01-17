/* Merge Intervals


 * Problem Description
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
You may assume that the intervals were initially sorted according to their start times.

Problem Constraints
0 <= |intervals| <= 105

Input Format
First argument is the vector of intervals

second argument is the new interval to be merged

Output Format
Return the vector of intervals after merging

Example Input
Input 1:
Given intervals [1, 3], [6, 9] insert and merge [2, 5] .

Input 2:
Given intervals [1, 3], [6, 9] insert and merge [2, 6] .

Example Output
Output 1:
 [ [1, 5], [6, 9] ]

Output 2:
 [ [1, 9] ]

Example Explanation
Explanation 1:

(2,5) does not completely merge the given intervals
Explanation 2:

(2,6) completely merges the given intervals
 */

package arrayProblems;

import java.util.ArrayList;


class Interval{
    int start, end;

    Interval(){
        start = 0;
        end = 0;
    }

    Interval(int s, int e){
        start = s;
        end = e;
    }

}

public class MergeIntervals {
    static ArrayList<Interval> mergeIntervals(ArrayList<Interval> intervals, Interval newInterval){
        ArrayList<Interval> ans = new ArrayList<>();
        int n = intervals.size();

        for(int i=0; i<n; i++){
            Interval curr = intervals.get(i);

            if(newInterval.start > curr.end){
                ans.add(curr);
            }
            else if(curr.start > newInterval.end){
                ans.add(newInterval);
                for(int j=i; j<n; j++){
                    ans.add(intervals.get(j));
                }
                return ans;
            }
            else{
                newInterval.start = Math.min(newInterval.start, curr.start);
                newInterval.end = Math.max(newInterval.end, curr.end);
            }

           
        }

        ans.add(newInterval);
            return ans;
    }
    public static void main(String[] args) {
       ArrayList<Interval> A = new ArrayList<>();
      
       A.add(new Interval(2, 4));
       A.add(new Interval(1, 5));
       A.add(new Interval(10, 15));
       A.add(new Interval(22, 30));
        int n = A.size();
        System.out.println(n);
       for(int i=0; i<n; i++){
            System.out.println(A.get(i).start+" - "+A.get(i).end);
       }
       System.out.println("After Mergig");
       Interval newInterval = new Interval(7, 10);
       ArrayList<Interval> B = mergeIntervals(A, newInterval);
       for(int i=0; i<B.size(); i++){
            System.out.println(B.get(i).start+" - "+B.get(i).end);
       }
    }
}
