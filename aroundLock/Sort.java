import java.util.Stack;

/**
 * @Author: will
 * @Date: 2020/3/26
 * @description:
 */


public class Sort {
    public static void insertSort(int[] array){
        for(int i = 1; i < array.length; ++i){

            // 1. 找待插入元素在前面已排好序部分的位置
            int key = array[i];
            int end = i-1;

            // 待插入元素为最小元素的情况
            while(end >= 0 && key < array[end]){
                array[end+1] = array[end];
                end--;
            }

            // 2. 插入元素
            array[end+1] = key;
        }
    }

    // O(N^1.25)~O(1.6N^1.25)  kunth
    public static void shellSort(int[] array){
        int gap = array.length;
        while(gap > 1)
        {
            gap = gap/3+1;  // gap: 每次除2  每次取素数。。
            for(int i = gap; i < array.length; ++i){

                // 1. 找待插入元素在前面已排好序部分的位置
                int key = array[i];
                int end = i-gap;

                // 待插入元素为最小元素的情况
                while(end >= 0 && key < array[end]){
                    array[end+gap] = array[end];
                    end -= gap;
                }

                // 2. 插入元素
                array[end+gap] = key;
            }

            //gap--;
        }
    }

    public static void selectSort(int[] array){
        // 选择的趟数
        for(int i = 0; i < array.length-1; ++i){

            // 具体选择的方式: 找到最大元素的位置
            int maxPos = 0;
            for(int j = 1; j < array.length - i; ++j){
                if(array[j] > array[maxPos]){
                    maxPos = j;
                }
            }

            if(array.length-1-i != maxPos){
                swap(array, maxPos, array.length-1-i);
            }
        }
    }

    // [)
    // []
    public static void selectSortOP(int[] array){
        // [begin, end]
        int begin = 0, end = array.length-1;
        while(begin < end) {

            // 一趟选择：即可以找到最大元素的位置，也可以找到最小元素的位置
            int maxPos = begin;
            int minPos = begin;  // minPos = end;  // 有问题的
            int index = begin+1;
            while(index <= end){
                if(array[index] > array[maxPos]){
                    maxPos = index;
                }

                if(array[index] < array[minPos]){
                    minPos = index;
                }

                ++index;
            }

            // 将最大元素放在区间最后位置
            if(maxPos != end){
                swap(array, maxPos, end);
            }

            // 如果最小元素刚好在区间最后一个位置，必须要更新minPos
            if(minPos == end){
                minPos = maxPos;
            }

            if(minPos != begin){
                swap(array, minPos, begin);
            }

            begin++;
            end--;
        }
    }

    // 向下调整
    public static void shiftDown(int[] array, int parent, int size){
        int child = parent*2+1;

        while(child < size){
            // 找左右孩子中较大的孩子
            if(child+1 < size && array[child+1] > array[child]){
                child += 1;
            }

            // 检测双亲是否比较大的孩子小
            if(array[child] > array[parent]){
                swap(array, child, parent);
                parent = child;
                child = parent*2+1;
            }
            else{
                break;
            }
        }
    }

    public static void heapSort(int[] array){
        // 1. 建堆
        // 找倒数第一个非叶子节点
        int lastLeaf = (array.length-2)>>1;

        // 从lastLeaf到root的位置不段进行向下调整
        for(int root = lastLeaf; root >= 0; root--){
            shiftDown(array, root, array.length);
        }

        // 2. 利用堆删除的思想进行排序
        int end = array.length-1;

        while(end >= 0) {
            swap(array, 0, end);
            shiftDown(array, 0, end);
            end--;
        }
    }

    public static void bubbleSort(int[] array){
        // 用来优化冒泡---冒泡冒了一定趟数之后，可能已经有序了，后序的冒泡就不需要冒了
        // 如果已经有序，在冒泡时肯定不需要元素交换
        boolean isChange = false;

        // 外层循环：控制的是冒泡的趟数
        for(int i = 0; i < array.length-1; ++i){
            // 具体冒泡的方式
            // 一趟冒泡的方式：将相邻的两个元素进行比较
            // 让大的元素往后移动
            isChange = false;
            for(int j = 1; j < array.length-i; ++j){
                if(array[j-1] > array[j]){
                    swap(array, j-1, j);
                    isChange = true;
                }
            }

            if(!isChange){
                return;
            }
        }
    }

    // 取基准值的优化：
    // 从区间最左侧、中间、最右侧取基准值，对该三个位置的基准值进行比较，返回比较结果的中间值
    // 三数取中法
    public static int getIndexOfMiddle(int[] array, int left, int right){
        int mid = left + ((right-left)>>1);
        if(array[left] < array[right-1]){
            if(array[mid] < array[left]){
                return left;
            }
            else if(array[mid] > array[right-1]){
                return right - 1;
            }
            else{
                return mid;
            }
        }
        else
        {
            if(array[mid] > array[left]){
                return left;
            }
            else if(array[mid] < array[right-1]){
                return right-1;
            }
            else{
                return mid;
            }
        }
    }

    // [left, right)
    public static int partion1(int[] array, int left, int right){
        int begin = left;
        int end = right-1;
        int mid = getIndexOfMiddle(array, left, right);
        swap(array, mid, right-1);
        int key = array[end];

        while(begin < end){
            // 1. begin从前往后找，找比基准值大的元素
            while(begin < end && array[begin] <= key){
                begin++;
            }

            // 2. end从后往前找，找比基准值小的元素
            while(begin < end && array[end] >= key){
                end--;
            }

            if(begin < end){
                swap(array, begin, end);
            }
        }

        if(begin != right-1){
            swap(array, begin, right-1);
        }

        return begin;
    }

    // 挖坑法
    public static int partion2(int[] array, int left, int right){
        int begin = left;
        int end = right-1;
        int mid = getIndexOfMiddle(array, left, right);
        swap(array, mid, right-1);
        int key = array[end];

        while(begin < end){

            // 1. begin从前往后找，找比基准值大的元素
            while(begin < end && array[begin] <= key){
                begin++;
            }

            // 找到了一个比基准值大的元素，用该元素填end位置的坑
            if(begin < end){
                array[end--] = array[begin];
            }

            // 2. end从后往前找，找比基准值小的元素
            while(begin < end && array[end] >= key){
                end--;
            }

            // end从后往前找到了一个比基准值小的元素，用该元素填begin位置的坑
            if(begin < end){
                array[begin++] = array[end];
            }
        }

        // 用key填最后一个坑
        array[begin] = key;
        return  begin;
    }

    public static int partion3(int[] array, int left, int right){
        int cur = left;
        int prev = cur-1;
        int mid = getIndexOfMiddle(array, left, right);
        swap(array, mid, right-1);

        int key = array[right - 1];

        while(cur < right){
            if(array[cur] < key && ++prev != cur)
                swap(array, cur, prev);
            ++cur;
        }

        if(++prev != right-1){
            swap(array, prev, right-1);
        }

        return  prev;
    }


    public static void insertSort(int[] array, int left, int right){

    }

    // [left, right)
    public static void quickSort(int[] array, int left, int right){
        if(right - left < 16){
            insertSort(array, left, right);
        }
        else
        {
            // 说明区间中至少有两个元素
            // 按照基准值对[left, right)区间进行分割
            int div = partion3(array, left, right);

            // 递归排基准值的左半侧
            quickSort(array, left, div);

            // 递归排基准值的右半侧
            quickSort(array, div+1, right);
        }
    }

    public static void quickSortNor(int[] array){
        Stack<Integer> s = new Stack<>();
        s.push(array.length);
        s.push(0);

        while(!s.empty()){
            int left = s.pop();
            int right = s.pop();

            if(right - left > 1){
                int div = partion1(array, left, right);
                // [left, div)
                // [div+1, right)
                s.push(right);
                s.push(div+1);
                s.push(div);
                s.push(left);
            }
        }
    }


    public static void swap(int[] array, int left, int right){
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    public static void printArray(int[] array){
        for(int e : array)
            System.out.print(e + " ");
        System.out.println();
    }


    // [left, mid)  [mid, right)
    private static void mergeData(int[] array, int left, int mid, int right, int[] temp){
        int index = left;
        int begin1 = left, end1 = mid, begin2 = mid, end2 = right;

        while(begin1 < end1 && begin2 < end2){
            if(array[begin1] <= array[begin2]){
                temp[index++] = array[begin1++];
            }
            else{
                temp[index++] = array[begin2++];
            }
        }

        // 如果第一个区间中还有数据
        while(begin1 < end1){
            temp[index++] = array[begin1++];
        }

        // 如果第二个区间中有数据
        while(begin2 < end2){
            temp[index++] = array[begin2++];
        }
    }

    private static void mergeSort(int[] array, int left, int right, int[] temp){
        if(right - left < 16) {
            insertSort(array, left, right);
        }
        else {
            int mid = left + ((right - left)>>1);

            // [left, mid)---> 左半部分
            mergeSort(array, left, mid, temp);

            // [mid, right)---> 右半部分
            mergeSort(array, mid, right, temp);

            // 归并
            mergeData(array, left, mid, right, temp);

            // 归并结束后，有序序列存储在temp中
            // 将temp中的数据拷贝到array中去
            System.arraycopy(temp, left, array, left, right - left);
        }
    }

    public static void mergeSort(int[] array){
        int[] temp = new int[array.length];
        mergeSort(array, 0, array.length, temp);
    }

    public static void mergeSortNor(int[] array){
        int[] temp = new int[array.length];
        int gap = 1;

        while(gap < array.length){
            for(int i = 0; i < array.length; i += gap*2){
                int left = i;
                int mid = left+gap;
                int right = mid+gap;

                if(mid > array.length){
                    mid = array.length;
                }

                if(right > array.length){
                    right = array.length;
                }

                mergeData(array, left, mid, right, temp);
            }

            System.arraycopy(temp, 0, array, 0, array.length);

            //gap *= 2;
            gap <<= 1;
        }
    }

    // 场景：数据密集集中在某个范围中
    // 时间复杂度：O(N)  N: 表示区间中元素的个数
    // 空间复杂度：O(M)  M: 表示区间中元素种类的个数
    // 稳定性：稳定
    public static void countSort(int[] array){
        // 1. 统计元素的范围
        int minValue = array[0];
        int maxValue = array[0];
        for(int i = 1; i < array.length; ++i){
            if(array[i] > maxValue){
                maxValue = array[i];
            }

            if(array[i] < minValue){
                minValue = array[i];
            }
        }

        // 2. 开辟计数的空间
        // 该范围中最多包含不同元素种类的个数
        int range = maxValue - minValue + 1;
        int[] arrayCount = new int[range];

        // 3. 统计每个元素出现的次数
        for(int i = 0; i < array.length; ++i){
            arrayCount[array[i]-minValue]++;
        }

        // 4. 对元素进行回收---排序
        int index = 0;
        for(int i = 0; i < range; ++i){
            while(arrayCount[i]-- != 0){
                array[index++] = i + minValue;
            }
        }
    }

    public static void main(String[] args) {
        //int[] array = {3,8,2,6,9,7,1,4,0,5};
        // insertSort(array);
        // shellSort(array);
        // selectSort(array);
        // selectSortOP(array);
        // heapSort(array);
        // quickSortNor(array);
        // mergeSort(array);
        // mergeSortNor(array);
        //bubbleSort(array);

        int[] array = {3,8,2,6,2,1,6,0,1,5,5,5,1,7,9,7,1,4,0,5};
        countSort(array);

        printArray(array);
    }
}
