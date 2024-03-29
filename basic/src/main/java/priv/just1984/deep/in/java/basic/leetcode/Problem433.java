package priv.just1984.deep.in.java.basic.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: 一条基因序列由一个带有8个字符的字符串表示，其中每个字符都属于 "A", "C", "G", "T"中的任意一个。
 *
 * 假设我们要调查一个基因序列的变化。一次基因变化意味着这个基因序列中的一个字符发生了变化。
 *
 * 例如，基因序列由"AACCGGTT" 变化至 "AACCGGTA" 即发生了一次基因变化。
 *
 * 与此同时，每一次基因变化的结果，都需要是一个合法的基因串，即该结果属于一个基因库。
 *
 * 现在给定3个参数 — start, end, bank，分别代表起始基因序列，目标基因序列及基因库，请找出能够使起始基因序列变化为目标基因序列所需的最少变化次数。如果无法实现目标变化，请返回 -1。
 *
 * 注意:
 *
 * 起始基因序列默认是合法的，但是它并不一定会出现在基因库中。
 * 所有的目标基因序列必须是合法的。
 * 假定起始基因序列与目标基因序列是不一样的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-genetic-mutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: yixiezi1994@gmail.com
 * @date: 2019-11-23 14:44
 */
public class Problem433 {

    private static final String CHAR_REGEX = "[ACGT]";

    public static void main(String[] args) {
        String start = "AAAAACCC";
        String end = "AACCCCCC";
        String[] bank = new String[] {"AAAACCCC", "AAACCCCC", "AACCCCCC"};
        minMutation(start, end, bank);
    }

    public static int minMutation(String start, String end, String[] bank) {
        String pattern = "", rStart = "", rEnd = "";
        List<Integer> diffIndex = new ArrayList<>();
        for (int i = 0; i < start.length(); i++) {
            char sc = start.charAt(i);
            char ec = end.charAt(i);
            if (sc == ec) {
                pattern += sc;
            } else {
                pattern += CHAR_REGEX;
                rStart += sc;
                rEnd += ec;
                diffIndex.add(i);
            }
        }
        final String rPattern = pattern;
        List<String> bankList = Arrays.stream(bank).filter(s -> s.matches(rPattern)).map(s -> diffIndex.stream().map(i -> String.valueOf(s.charAt(i)))
                .collect(Collectors.joining(""))).collect(Collectors.toList());

        return -1;
    }

}
