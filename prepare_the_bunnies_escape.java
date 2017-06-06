package com.google.challenges; 

public class Answer { 
    public static int [][]value;
    
    public static list whole = new list();
	public static boolean possibleMove(int row,int col,int[][]m,int to,int from){
	    if( (row < m.length && row >=0) && (col <m[0].length && col>=0)){
	        if(to!=from){
    	        if(m[row][col] == 0){
    	            return true;
    	        }
	        }
	    }
	    return false;
	}
    
    public static void get(int row,int col,node n,int [][]m){
        node ref = null;
        if(value[row][col] > value[n.row][n.col]+1 || value[row][col] == 0){
			value[row][col] = value[n.row][n.col]+1;
            ref = new node(row,col);
			ref.setFrom(n.row, n.col);
			whole.add(ref);
		}  
    }    
	public static void addMove(node n,int [][]m){
	    int row = n.row;
	    int col = n.col;
	    int x = m.length;
	    int y = m[0].length;
		if(possibleMove(row+1,col,m,row+1,row)){
		    get(row+1,col,n,m);
		}
		if(possibleMove(row,col+1,m,col+1,col)){
		    get(row,col+1,n,m);
		}
		if(possibleMove(row-1,col,m,row-1,row)){
		    get(row-1,col,n,m);
		}
		if(possibleMove(row,col-1,m,col-1,col)){
		    get(row,col-1,n,m);
		}
	}
	
    public static int answer(int [][] m){
        if(m.length == 0 || m[0].length == 0) return 1;
		int row = m.length;
		int col = m[0].length;
		if(row == 1) return col;
		else if(col == 1) return row;
		value = new int[row][col];
		list wallr = new list();
		list wallc = new list();
		for(int i = 0;i<row;i++){
		    for(int j = 0;j<col;j++){
		        if(m[i][j] == 1){
                    wallr.add(new node(i));
                    wallc.add(new node(j));
		        }
		    }
		}
		wallr.add(new node(-1));
		wallc.add(new node(-1));
		node door = new node(0,0);
		door.setFrom(-1, -1);
		int ans = 10000;
		int tx = 0;
		int ty = 0;
		int result = 0;
		for(int i = 0;i<wallr.size;i++){
		    value = new int[row][col];
			value[0][0]= 1;
		    whole.add(door);
		    tx = wallr.next().coord;
		    ty = wallc.next().coord;
		    if(tx>=0){
		        m[tx][ty] = 0;
		    }
		    while(value[row-1][col-1] == 0 && whole.size!=0){
			    addMove(whole.pop(),m);
		    }
		    result = value[row-1][col-1];
		    if(result!=0 && result < ans) ans = result;
		    if(tx >= 0) m[tx][ty] = 1;
		    whole.clear();
		}
		return ans;
    }
}
class  list{
	node first = null;
	node last = null;
	int size = 0;
	node pop(){
	    node temp = first;
	    first = null;
	    first = temp.next;
	    size--;
	    return temp;
	}
	void add(node n){
		if(n != null){
			if(first == null){
				first = n;
				last = first;
			}
			else{
				last.next = n;
				last = last.next;
			}
			size++;
		}
	}
	
	node next(){
		node temp = first;
		if(first!=null){
			temp = first;
			first = first.next;
			return temp;
		}
		return temp;
	}
	
	void clear(){
		first = null;
		last = null;
		size = 0;
	}
}

class node{
	int value;
	int row;
	int col;
	int coord;
	int fromx = 0;
	int fromy = 0;
	node next = null;
	node(int row,int col){
		this.col= col;
		this.row = row;
	}
	
	node(int i){
	    this.coord = i;
	}
	
	void setFrom(int x,int y){
		this.fromx = x;
		this.fromy = y;
	}
}