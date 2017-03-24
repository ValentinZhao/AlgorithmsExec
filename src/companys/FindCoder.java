package companys;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FindCoder {
	public String[] findCoder(String[] A, int n) {
		ArrayList<Recorder> result = new ArrayList<>();
		for(int i = 0; i < n; i++){
			String str = A[i];
			str = str.toLowerCase();
			if(str.contains("coder")){
				int count = 0;
				int start = 0;
				while(str.indexOf("coder", start) >= 0 && start < str.length()){
					count++;
					start = str.indexOf("coder", start) + "coder".length();//向后推start指针
				}
				result.add(new Recorder(A[i], i, count));
			}
		}
		
		Collections.sort(result, new Comparator<Recorder>(){

			@Override
			public int compare(Recorder o1, Recorder o2) {
				if(o1.getCount() != o2.getCount()) 
					return o2.getCount() - o1.getCount();//让count较大的排在前面
				else return o1.getIndex() - o2.getIndex();//同count下，让index较小的排前面
			}
			
		});
		String[] sortedList = new String[result.size()];
		for(int i = 0; i < result.size(); i++){
			sortedList[i] = result.get(i).getData();
		}
		return sortedList;
    }
	
	class Recorder{
		private String data;
		private int index;
		private int count;
		
		
		public Recorder(String data, int index, int count) {
			super();
			this.data = data;
			this.index = index;
			this.count = count;
		}
		
		public String getData() {
			return data;
		}
		public void setData(String data) {
			this.data = data;
		}
		public int getIndex() {
			return index;
		}
		public void setIndex(int index) {
			this.index = index;
		}
		public int getCount() {
			return count;
		}
		public void setCount(int count) {
			this.count = count;
		}
		
		
		
	}
}
