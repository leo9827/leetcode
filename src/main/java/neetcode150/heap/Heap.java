package neetcode150.heap;

public class Heap {

    class MinHeap {
        int[] array;
        int size;

        public MinHeap(int capacity) {
            this.array = new int[capacity];
        }

        public int peek() {
            return array[0];
        }

        public boolean isFull() {
            return size == array.length;
        }

        public int getSize() {
            return size;
        }

        // 向堆中添加元素
        public boolean offer(int offered) {
            if (isFull()) {
                return false;
            }
            up(offered, size);
            size++;
            return true;
        }

        // 替换堆顶元素
        public void replace(int replaced) {
            array[0] = replaced;
            down(0);
        }

        // 上浮操作
        private void up(int offered, int index) {
            int child = index; // 将变量 child 初始化为 index=size，表示当前节点的索引。
            int parent = (child - 1) / 2; // 计算当前节点的父节点索引，使用 (child - 1) / 2 的方式可以得到父节点在数组中的索引。
            while (child > 0 && array[parent] > offered) { // 进入一个循环，条件为当前节点不是根节点（索引大于0）且当前节点的父节点的值大于被插入的元素 offered
                array[child] = array[parent]; // 将父节点的值赋给当前节点，将当前节点向上移动一层
                child = parent; // 将 child 更新为父节点的索引，以便进行下一次循环判断
                parent = (child - 1) / 2; // 更新父节点的索引，继续向上移动
            }
            array[child] = offered; // 将被插入的元素 offered 放置在当前节点的位置，保持堆的性质
        }

        // 下沉操作
        private void down(int parent) {
            int left = 2 * parent + 1; // 计算当前节点的左子节点在数组中的索引，根据堆的映射公式，左子节点的索引为 2 * parent + 1
            while (left < size) { // 进入一个循环，条件是当前节点存在左子节点，即左子节点的索引小于堆的大小 size
                // 在左子节点和右子节点中选择值较小的节点。首先判断右子节点是否存在（右子节点的索引为 left + 1），如果存在且其值小于左子节点的值，则选择右子节点作为最小节点的索引 smallest，否则选择左子节点。
                int smallest = left + 1 < size && array[left + 1] < array[left] ? left + 1 : left;
                if (array[smallest] >= array[parent]) { // 如果最小节点的值大于等于父节点的值，则跳出循环，因为堆的性质已经满足
                    break;
                }
                swap(parent, smallest); // 交换父节点和最小节点的值，将较小的值向上移动
                parent = smallest; // 将当前节点的索引更新为最小节点的索引，以便进行下一次循环判断
                left = 2 * parent + 1; // 更新左子节点的索引，继续向下移动
            }
        }

        // 交换数组中的两个元素
        private void swap(int a, int b) {
            int temp = array[a];
            array[a] = array[b];
            array[b] = temp;
        }
    }

}
