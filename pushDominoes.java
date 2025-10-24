class Solution {
    public String pushDominoes(String dominoes) {
        int n=dominoes.length();

        int[] forces=new int[n];

        int op=0;

        for(int i=0;i<n;i++){
            if(dominoes.charAt(i)=='R'){
                op=n;
            }else if(dominoes.charAt(i)=='L'){
                op=0;
            }else{
                op=Math.max(op-1 , 0);
            }
            forces[i] +=op;
        }

        for(int i=n-1;i>=0;i--){
            if(dominoes.charAt(i)=='L'){
                op=n;
            }else if(dominoes.charAt(i)=='R'){
                op=0;
            }else{
                op=Math.max(op-1 , 0);
            }
            forces[i] -= op;
        }

        StringBuilder res=new StringBuilder();

        for(int f:forces){
            if(f>0) res.append('R');
            else if(f<0) res.append('L');
            else res.append('.');
        }
        return res.toString();

    }
}
