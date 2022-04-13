package _dsa._0_LeetCode_Village.String_Matching;

public class _1_check_if_a_word_occurs_as_a_prefix_of_any_word_in_a_sentence {
    // Question: https://leetcode.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/

    public static void main(String[] args) {
        System.out.println(isPrefixOfWord("I love eating burger", "burger"));
    }

    public static int isPrefixOfWord(String sentence, String searchWord) {
        String arr[] = sentence.split(" ");

        int res = -1;

        int swLen = searchWord.length();

        for(int i=0; i<arr.length; i++){
            String str = arr[i];

            if(str.length() >= swLen){
                if (str.substring(0,swLen).equals(searchWord)){
                    res = i + 1;
                    break;
                }
            }
        }

        return res;
    }
}
