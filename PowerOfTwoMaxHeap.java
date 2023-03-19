public class PowerOfTwoMaxHeap{
    int z;

    public PowerOfTwoMaxHeap(int z){
        this.z = z;
    }


private List<Integer> elements = new List<>();

public void insert(int value){

    elements.add(value);
    int currentIndex = elements.size() -1;
    int parentIndex = (currentIndex - 1) / z;

    while (currentIndex > 0 && elements.get(currentIndex) > elements.get(parentIndex)) {

        int temp = elements.get(currentIndex);
        elements.set(currentIndex, elements.get(parentIndex));
        elements.set(parentIndex, temp);

        currentIndex = parentIndex;
        parentIndex = (currentIndex - 1) / z;
}
}

public int popMax() {
    int max = elements.get(0);
    elements.set(0, elements.get(elements.size() - 1));
    elements.remove(elements.size() - 1);

    int currentIndex = 0;

    while (true) {
        int maxChildIndex = findMaxChildIndex(currentIndex);

        if (maxChildIndex == -1 || elements.get(currentIndex) >= elements.get(maxChildIndex)) {
            break;
        }

        int temp = elements.get(currentIndex);
        elements.set(currentIndex, elements.get(maxChildIndex));
        elements.set(maxChildIndex, temp);

        currentIndex = maxChildIndex;
    }

    return max;
}

private int findMaxChildIndex(int currentIndex) {
    int maxChildIndex = -1;
    int startChildIndex = currentIndex * z + 1;
    int endChildIndex = Math.min(startChildIndex + z, elements.size());

    for (int i = startChildIndex; i < endChildIndex; i++) {
        if (maxChildIndex == -1 || elements.get(i) > elements.get(maxChildIndex)) {
            maxChildIndex = i;
        }
    }

    return maxChildIndex;
}
}







