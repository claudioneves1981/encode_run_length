import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String s = "teste";
        System.out.println(encodeRunLengths(s));
    }

    public static Map<Character,Map<Integer, Integer>> encodeRunLength(String s, Integer startIndex){

        char c  = s.charAt(startIndex);
        int count = 1;
        int i = startIndex + 1;

        while(i < s.length() && s.charAt(i) == c){

            count++;
            i++;

        }

        Map<Integer, Integer> value = Map.of(count, i);
        return Map.of(c, value);

    }

    public static Map<Character, Integer> encodeRunLengths(String s){

        Map<Character, Integer> groups = new java.util.HashMap<>(Map.of());
        int index = 0;
        Map<Character,Map<Integer, Integer>> result;
        Character c;
        int count;
        int nextIndex;
        Map<Integer, Integer> map;

        while(index < s.length()){

            result = encodeRunLength(s, index);
            if(result.isEmpty()){
                break;
            }

            c = result.keySet().stream().findAny().get();
            map = result.values().stream().findAny().get();
            count = map.keySet().stream().findAny().get();
            nextIndex = map.values().stream().findAny().get();
            groups.put(c,count);
            index = nextIndex;
        }

        return groups;

    }

}
