import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
public class PythagoreanTriplet {
    private int a;
    private int b;
    private int c;
    public PythagoreanTriplet(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public static Builder makeTripletsList() {
        return new Builder();
    }
    public static class Builder {
        private int sum;
        private List<PythagoreanTriplet> list = new ArrayList<>();
        public Builder withFactorsLessThanOrEqualTo(int num) {
            return this;
        }
        public Builder thatSumTo(int num) {
            this.sum = num;
            return this;
        }
        public List<PythagoreanTriplet> build() {
            for(int a = 1;a < Math.floorDiv(sum, 3);a++) {
                for(int b = a + 1;b<sum - a;b++) {
                   int c = sum - a - b;
                   if(c <= b) {
                       break;
                   }
                    if(Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2)) {
                            list.add(new PythagoreanTriplet(a, b, c));
                        }
                }
            }
            return list;
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PythagoreanTriplet that = (PythagoreanTriplet) o;
        return a == that.a &&
                b == that.b &&
                c == that.c;
    }
    @Override
    public int hashCode() {
        return Objects.hash(a, b, c);
    }
}