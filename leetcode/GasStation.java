package leetcode;

//https://leetcode.com/problems/gas-station/

public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] results = new int[gas.length];
        for(int i = 0; i < gas.length; i++){
            results[i] = gas[i] - cost[i];
        }
        int start = 0;
        int end = 0;
        int tank = 0;;
        int answer = -1;
        boolean startBegan = false;
        while(start != gas.length){
            if(!startBegan && results[start] >= 0){
                end = start + 1;
                if(end == gas.length){
                    end = 0;
                }
                tank = results[start];
                startBegan = true;
                continue;
            }
            else if(!startBegan){
                start++;
                continue;
            }
            if(tank + results[end] < 0){
                tank -= results[start];
                start++;
                if(start == end){
                    startBegan = false;
                }
            }
            else{
                if(start == 0 && end == results.length - 1){
                    answer = start;
                    break;
                }
                if(end == start - 1){
                    answer = start;
                    break;
                }
                tank += results[end];
                end++;
                if(end == gas.length){
                    end = 0;
                }
            }
        }
        
        return answer;
    }
}
