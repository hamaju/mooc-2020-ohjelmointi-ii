
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PositiivisetLuvut {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        // testaa metodia täällä
        List<Integer> luvut = new ArrayList<>();
        luvut.add(-8);
        luvut.add(-11);
        luvut.add(-3);
        luvut.add(1);
        luvut.add(8);
        luvut.add(1);
        System.out.println(luvut);
        positiiviset(luvut);
    }
    
    public static List<Integer> positiiviset(List<Integer> luvut) {
        return luvut.stream()
                .filter(luku -> luku >= 0)
                //.collect(Collectors.toCollection(ArrayList::new));
                .collect(Collectors.toList());
    }
}
