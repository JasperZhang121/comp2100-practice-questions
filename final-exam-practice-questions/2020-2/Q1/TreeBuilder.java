
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TreeBuilder {

    public RBTree<Integer, List<String>> build(String text) {
        // ########## YOUR CODE STARTS HERE ##########

        RBTree rbTree = new RBTree<Integer, List<String>>();

        var temp = "";
        var map = new HashMap<Integer, ArrayList<String>>();
        for (int i = 0; i < text.length(); i++) {
            if (Character.isLetter(text.charAt(i))){
                temp+=text.charAt(i);
            }
            if (!Character.isLetter(text.charAt(i))){
                if (temp.equals(temp.toUpperCase())){
                    if (!map.containsKey(temp.length())){
                        var value =  new ArrayList<String>();
                        value.add(temp);
                        map.put(temp.length(),value);
                    }else {
                        var lis = map.get(temp.length());
                        lis.add(temp);
                        map.put(temp.length(),lis);
                    }
                }
                temp = "";
            }
        }
        var keys = map.keySet();
        for (var key:keys) {
            rbTree.insert(key,map.get(key));
        }
        return rbTree; // change the return
        // ########## YOUR CODE ENDS HERE ##########
    }




}
