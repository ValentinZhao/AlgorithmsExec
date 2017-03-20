package CodingInterviews;
/**
 * 正则表达式匹配
 * @author zhaoziliang
 *
 */
public class Interview53 {
	public static boolean match(char[] str, char[] pattern){
		if(str == null || pattern == null){
			return false;
		}
		return matchCore(str, 0, pattern, 0);
	}

	private static boolean matchCore(char[] str, int s, char[] pattern, int p) {
		if(str[s] == '\0' && pattern[p] == '\0'){
			return true;
		}
		if(str[s] != '\0' && pattern[p] == '\0'){
			return false;
		}
		if(pattern[p + 1] == '*'){
			if(pattern[p] == str[s] || (pattern[p] == '.' && str[s] != '\0')){
				//move on next state
				return matchCore(str, s + 1, pattern, p + 2) ||
						//stay on current state
						matchCore(str, s + 1, pattern, p) ||
						//ignore a '*'
						matchCore(str, s, pattern, p + 2);
			} else {
				//ignore a '*'
				return matchCore(str, s, pattern, p + 2);
			}
		}
		if(str[s] == pattern[p] || (pattern[p] == '.' && str[s] != '\0'))
			return matchCore(str, s + 1, pattern, p + 1);
		return false;
	}
}
