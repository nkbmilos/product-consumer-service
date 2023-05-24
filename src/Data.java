public class Data implements Comparable<Data> {
    private final int position;
    private final String word;

    public Data(int position, String word) {
        this.position = position;
        this.word = word;
    }

    public int getPosition() {
        return position;
    }

    public String getWord() {
        return word;
    }

    @Override
    public int compareTo(Data o) {
        if (o == null || o.position == position) {
            return 0;
        }
        return o.position >= position ? -1 : 1;
    }
}
