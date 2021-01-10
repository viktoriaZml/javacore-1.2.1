import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
    List<Integer> outList = new ArrayList<>();
    for (Integer x : intList) {
      if (x > 0 && x % 2 == 0) outList.add(x);
    }
    mySort(outList, 0, outList.size() - 1);
    System.out.println(outList);
  }

  public static void mySort(List<Integer> list, int low, int high) {
    if (list.size() == 0)
      return;
    if (low >= high)
      return;
    int middle = low + (high - low) / 2;
    Integer x = list.get(middle);
    int i = low, j = high;
    while (i <= j) {
      while (list.get(i) < x) {
        i++;
      }
      while (list.get(j) > x) {
        j--;
      }
      if (i <= j) {
        Integer temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
        i++;
        j--;
      }
    }
    if (low < j)
      mySort(list, low, j);
    if (high > i)
      mySort(list, i, high);
  }
}
