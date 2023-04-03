import java.util.List;

/** 
 * Task 11: INDA-22
 * 
 * @author Sara Rydell
 * @version 2022-11-29
 */

public class BoxProcessor {
    // insertion sort arrays
    public void sort(Box[] array) {
        for(int i=1; i<array.length; i++) {
            int j = i;
            while(j>0 && array[j-1].compareTo(array[j])>0) {
                Box temp = array[j];
                array[j] = array[j-1];
                array[j-1] = temp;
                j--;
            }
        }
    }
    // insertion sort list
    public void sort(List<Box> list) {
        for(int i=1; i<list.size(); i++) {
            int j = i;
            while(j>0 && list.get(j-1).compareTo(list.get(j))>0) {
                Box temp = list.get(j);
                list.set(j,list.get(j-1));
                list.set(j-1,temp);
                j--;
            }
        }
    }

    // sequential search arrays
    public int sequentialSearch(Box[] array, Box box) {
        for(int i=0; i<array.length; i++) {
            if(array[i].compareTo(box)==0) {
                return i;
            }
        } 
        return -1;
    }
    // sequential search lists
    public int sequentialSearch(List<Box> list, Box box) {
        for(int i=0; i<list.size(); i++) {
            if(list.get(i).compareTo(box)==0) {
                return i;
            }
        } 
        return -1;
    }

    // binary search arrays
    public int binarySearch(Box[] array, Box box) {
        sort(array);
        int lowerBound = 0;
        int upperBound = array.length-1;
        while(lowerBound<=upperBound) {
            int index = (lowerBound + upperBound)/2;
            if(array[index].compareTo(box)==0) {
                return index;
            }
            else if(array[index].compareTo(box)>0) {
                upperBound = index-1;
            }
                else if(array[index].compareTo(box)<0) {
                    lowerBound = index+1;
                }     
        }
        return -1;
    }
    // binary search lists
    public int binarySearch(List<Box> list, Box box) {
        sort(list);
        int lowerBound = 0;
        int upperBound = list.size()-1;
        while(lowerBound<=upperBound) {
            int index = (lowerBound + upperBound)/2;
            if(list.get(index).compareTo(box)==0) {
                return index;
            }
            else if(list.get(index).compareTo(box)>0) {
                upperBound = index-1;
            }
                else if(list.get(index).compareTo(box)<0) {
                    lowerBound = index+1;
                }     
        }
        return -1;
    }
}
